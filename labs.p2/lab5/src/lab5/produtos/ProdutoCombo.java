package lab5.produtos;

public class ProdutoCombo extends Comida implements Produto, Promocao {

	private String fator;
	private String produtos;

	public ProdutoCombo(String nomeProduto, String descricao, String fator, String produtos) {
		super(nomeProduto, descricao);
		this.fator = fator;
		this.produtos = produtos;
	}

	public void setProdutos(String produtos2) {
		this.produtos = produtos2;
	}

	public void setFator(String novoFator) {
		this.fator = novoFator;
	}

	@Override
	public double getPreco() {
		return getPrecoGeral(this.produtos);
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - R$" + getPrecoComPromo().replace(".", ",");
	}

	@Override
	public String getPrecoComPromo() {
		double preco = getPrecoGeral(this.produtos);
		double fator = Double.parseDouble(this.fator);
		return String.format("%.2f", aplicaPromo(preco, fator));
	}

	@Override
	public double aplicaPromo(double preco, double fator) {
		return preco - (preco * fator);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fator == null) ? 0 : fator.hashCode());
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoCombo other = (ProdutoCombo) obj;
		if (fator == null) {
			if (other.fator != null)
				return false;
		} else if (!fator.equals(other.fator))
			return false;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		return true;
	}

	private double getPrecoGeral(String produtos) {
		double preco = 0.0;
		for (String palavra : produtos.split(" ")) {
			if (palavra.contains("R$"))
				preco += Double.valueOf(palavra.substring(2, 6).replace(",", "."));
		}
		return preco;
	}

}
