package br.com.frota.model;

public class Banda extends GenericModel {
    private String descricao;

    public Banda(String descricao) {
        this.descricao = descricao;
    }

    public Banda(Integer id, String descricao) {
        this.descricao = descricao;
        super.setId(id);
    }

    public Banda(Integer id) {
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
        return "Banda {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" +
                '}';
    }
}
