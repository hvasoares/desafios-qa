package co.idwall.ap.v2.test;


public class ReportRequestBuilder {
	
	private ReportRequestDTO instance = new ReportRequestDTO();
	
	public static ReportRequestBuilder start() {
		return new ReportRequestBuilder();
	}
	
	public ReportRequestDTO build() {
		return instance;
	}
	
	public ReportRequestBuilder dataNascimento(String dataNascimento) {
		instance.getParametros().setDataDeNascimento(dataNascimento);
		return this;
	}
	
	public ReportRequestBuilder nome(String nome) {
		instance.getParametros().setNome(nome);
		return this;
	}
	
	public ReportRequestBuilder numero(String numero) {
		instance.getParametros().setNumero(numero);
		return this;
	}
}
