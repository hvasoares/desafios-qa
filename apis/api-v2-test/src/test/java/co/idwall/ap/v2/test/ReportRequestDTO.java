package co.idwall.ap.v2.test;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportRequestDTO {

	
	
	private String matriz = "consultaPessoaDefault";
	private Parametros parametros = new Parametros();
	
	public String getMatriz() {
		return matriz;
	}

	public void setMatriz(String matriz) {
		this.matriz = matriz;
	}

	public Parametros getParametros() {
		return parametros;
	}

	public void setParametros(Parametros parametros) {
		this.parametros = parametros;
	}

	public static class Parametros{
		
		@JsonProperty(value="cpf_data_de_nascimento")
		private String dataDeNascimento = "";
		@JsonProperty(value="cpf_nome")
		private String nome = "";
		@JsonProperty(value="cpf_numero")
		private String numero = "";
		
		public String getDataDeNascimento() {
			return dataDeNascimento;
		}
		public void setDataDeNascimento(String dataNascimento) {
			this.dataDeNascimento = dataNascimento;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getNumero() {
			return numero;
		}
		public void setNumero(String numero) {
			this.numero = numero;
		}
		
		
		
	}
}
