package br.com.frota.model;

import br.com.frota.model.Marca;

public class Veiculo extends GenericModel {
    private String descricao;
    private Marca marca;

    public Veiculo(String descricao, Marca marca) {
        this.descricao = descricao;
        this.marca = marca;
    }

    public Veiculo(Integer id, String descricao, Marca marca) {
        this.descricao = descricao;
        this.marca = marca;
        super.setId(id);
    }

    public Veiculo(Integer id) {
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Marca getMarca() { return marca; }

    public void setMarca(Marca marca) { this.marca = marca; }

    @Override
    public String toString() {
        return "Veiculo {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" +
                "marca='" + marca.getDescricao() + "\'" +
                '}';
    }
}
