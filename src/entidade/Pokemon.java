package entidade;

public class Pokemon {

	private Integer id;
	private String caracteristica;
	private String respostaSim;
	private String respostaNao;
	private Integer idPai;
	private Integer filhoDaResposta;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCaracteristica() {
		return this.caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Integer getIdPai() {
		return this.idPai;
	}

	public void setidPai(Integer idPai) {
		this.idPai = idPai;
	}

	public String getRespostaSim() {
		return this.respostaSim;
	}

	public void setRespostaSim(String respostaSim) {
		this.respostaSim = respostaSim;
	}

	public String getRespostaNao() {
		return this.respostaNao;
	}

	public void setRespostaNao(String respostaNao) {
		this.respostaNao = respostaNao;
	}

	public Integer getFilhoDaResposta() {
		return this.filhoDaResposta;
	}

	public void setFilhoDaResposta(Integer filhoDaResposta) {
		this.filhoDaResposta = filhoDaResposta;
	}

	public String toString() {
		return "Animal [id=" + this.id + ", caracteristica=" + this.caracteristica + ", respostaSim=" + this.respostaSim
				+ ", respostaNao=" + this.respostaNao + ", idPai=" + this.idPai + ", filhoDaResposta="
				+ this.filhoDaResposta + "]";
	}

}
