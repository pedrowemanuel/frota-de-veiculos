package br.com.frota.model;

public class TipoEixo extends GenericModel {
    private String descricao;

    public TipoEixo(String descricao) {
        this.descricao = descricao;
    }

    public TipoEixo(Integer id, String descricao) {
        this.descricao = descricao;
        super.setId(id);
    }

    public TipoEixo(Integer id) {
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TipoEixo {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" +
                '}';
    }
}
