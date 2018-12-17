package co.idwall.ap.v2.test;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Optional;

import javax.swing.JOptionPane;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

/**
 * Unit test for simple App.
 */
public class ReportTest{
	private static final String ERRO_DATA_NASCIMENTO_DIVERGENTE_RF = "Inválido. [ERROR] Não foi possível validar: Data de nascimento informada está divergente da constante na base de dados da Secretaria da Receita Federal do Brasil.";
	private static final String URL = "https://api-v2.idwall.co/relatorios";
	private static final String API_KEY = "24074832-0feb-40cb-91d4-e1ac9cf56dcd";
	private static final String AUTHORIZATION = "Authorization";

	public ReportRequestDTOFactory reportRequestFactory = new ReportRequestDTOFactory();

	@Test
	public void testCenarioZero() throws JsonProcessingException {
		
		
		RestAssured.given()
			.header(AUTHORIZATION, getApiKey())
			.contentType(ContentType.JSON)
			.body(
					ReportRequestBuilder.start()
						.build()
					)
			.when()
				.post(URL)
			.then()
				.assertThat()
					.body("error", equalTo( "Bad Request"))
					.body("message", equalTo( "É necessário enviar ao menos um parâmetro para criação do relatório."))
					.body("status_code", equalTo(400))
					.statusCode(400);
	}
	
	
	@Test
	public void testScenarioOne() throws InterruptedException {
		
		testarRelatorioComErro(
				reportRequestFactory.createDataNascimentoErrada(), 
				ERRO_DATA_NASCIMENTO_DIVERGENTE_RF
			);	
	}


	private void testarRelatorioComErro(ReportRequestDTO input, String mensagemEsperada) throws InterruptedException {
		
		testarRelatorio(input, mensagemEsperada, "INVALID");
	}


	private void testarRelatorio(ReportRequestDTO input, String mensagemEsperada, String resultResultado)
			throws InterruptedException {
		@SuppressWarnings("rawtypes")
		String numero = givenAuthorizedJsonContent()
			.body(input
					)
			.when()
				.post(URL)
			.then()
				.contentType(ContentType.JSON)
				.extract()
				
				.jsonPath()
				.getString("result.numero");

		
		AssertionError result =null;
		
		for( int i=0; i<20; i++) {
			try {
				Thread.currentThread().sleep(10000);
				tryOnce(mensagemEsperada, resultResultado, numero);
				return;
			}catch(AssertionError e) {
				result =e;
			}
		}
		
		if( result != null)
			throw new RuntimeException("erro ao ver validações de " + numero, result);
		
		
	}

	


	private void tryOnce(String mensagemEsperada, String resultResultado, String numero) {
		givenAuthorizedJsonContent()
			
		.when()
			.get(URL+"/" + numero)
		.then()
			.assertThat()
				.body("result.status", equalTo("CONCLUIDO"))
				.body("result.resultado", equalTo(resultResultado))
				.body("result.nome", equalTo("consultaPessoaDefault"))
				.body("result.mensagem",equalTo(mensagemEsperada));
	}

	 
	@Test
	public void testScenarioTwo() throws InterruptedException {
		testarRelatorioComErro(
				reportRequestFactory.createNomeErrado(), 
				"Inválido. [INVALID] Nome diferente do cadastrado na Receita Federal."
		);
	}
	
	@Test 
	public void testScenarioOneConhecido() throws InterruptedException {
		
		testarRelatorio(reportRequestFactory.createDesconhecido(), "Válido.", "VALID");
	}


	private RequestSpecification givenAuthorizedJsonContent() {
		return given()
			.header(AUTHORIZATION,getApiKey())
			.contentType(ContentType.JSON);
	}


	private String getApiKey() {
		return Optional.ofNullable(System.getenv("IDWALL_TEST_KEY"))
				.orElse(API_KEY);
	}
}
  

