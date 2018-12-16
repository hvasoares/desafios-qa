package co.idwall.ap.v2.test;

import java.util.Objects;
import java.util.Optional;

public class ReportRequestDTOFactory {

	public ReportRequestDTO createDataNascimentoErrada() {
		return ReportRequestBuilder.start().nome("Gabriel Oliveira").numero("07614917677").dataNascimento("28/09/1988")
				.build();
	}

	public ReportRequestDTO createNomeErrado() {
		
		
		
		return ReportRequestBuilder.start().dataNascimento("25/07/1987").nome("Gabriel Oliveira").numero("07614917677")
				.build();
	}

	public ReportRequestDTO createDesconhecido() {
		return ReportRequestBuilder.start().dataNascimento(getPropriedadeTestConhecido("DATA_NASCIMENTO"))
				.nome(getPropriedadeTestConhecido("NOME"))
				.numero(getPropriedadeTestConhecido("NUMERO")).build();
	}

	private String getPropriedadeTestConhecido(String propriedade) {
		String key = "IDWALL_TEST_" + propriedade;
		Optional<String> returnedValue =   Optional.ofNullable(System.getenv(key)) ;;
		String value = returnedValue.orElse(propriedade + " invalido(a)");
		System.out.println(String.format("propriedade %s valor %s ", key,value));
		
		return value;
	}
}
