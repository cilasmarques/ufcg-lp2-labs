package cilas_medeiros_prova1;

public class SistemaEstacionamento {

	private Vaga[] vagas;
	private int  lucro;
	
	public SistemaEstacionamento() {
		vagas = new Vaga[50];
	}

	public SistemaEstacionamento(int quantVagas) {
		vagas = new Vaga[quantVagas];
	}

	public int valorDoCaixa(int posicao) {
		if (vagas[posicao].getHoras() <= 2)
			return 5;
		return 5 + vagas[posicao].getHoras();
	}

	public void ocupaCarro(int horaEntrada, String placa) {
		encontraVagaLivre().vagaOcupada(horaEntrada, placa);
	}

	private Vaga encontraVagaLivre() {
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i].getStatus())
				return vagas[i];
		}
		return null;
	}

	public int liberaVaga(int posicao) {
		vagas[posicao].vagaLiberada();
		return valorDoCaixa(posicao);
	}

	public void painelVagas() {
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i].getStatus())
				System.out.println(vagas[i].toString());
		}
	}
	
	public String localizarCarro(String placa) {
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i].getPlacaCarro().equals(placa))
				return (vagas[i].getLocalizacao());
		}
		return "Carro não esta estacionado!";
	}
	
	
	public void calculaLucro() {
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] != null)
				this.lucro += valorDoCaixa(i);
		}
	}
	
	public void imprimeLucro() {
		calculaLucro();
		System.out.println(this.lucro);
	}
	
}