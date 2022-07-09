package br.com.frota.model;

import br.com.frota.model.TipoEixo;

public class Eixo extends GenericModel {
    private String descricao;
    private int posicao;
    private TipoEixo tipo;

    public Eixo(String descricao) {
        this.descricao = descricao;
    }

    public Eixo(Integer id, String descricao, int posicao, TipoEixo tipo) {
        this.descricao = descricao;
        this.posicao = posicao;
        this.tipo = tipo;
        super.setId(id);
    }

    public Eixo(Integer id) {
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public TipoEixo getTipo() {
        return tipo;
    }

    public void setTipo(TipoEixo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Eixo {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" +
                "posicao='" + posicao + "\'" +
                "tipoEixo='" + tipo.getDescricao() + "\'" +
                '}';
    }
}
