package br.com.frota.model;

import br.com.frota.model.Banda;
import br.com.frota.model.Pneu;

public class PneuBanda extends GenericModel {
    private String observacao;
    private Banda banda;
    private Pneu pneu;
    private int ordem;

    public PneuBanda(String observacao, Banda banda, Pneu pneu, int ordem) {
        this.observacao = observacao;
        this.banda = banda;
        this.pneu = pneu;
        this.ordem = ordem;
    }

    public PneuBanda(Integer id, String observacao, Banda banda, Pneu pneu, int ordem) {
        this.observacao = observacao;
        this.banda = banda;
        this.pneu = pneu;
        this.ordem = ordem;
        super.setId(id);
    }

    public PneuBanda(Integer id) {
        super.setId(id);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public Pneu getPneu() {
        return pneu;
    }

    public void setPneu(Pneu pneu) {
        this.pneu = pneu;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    @Override
    public String toString() {
        return "PneuBanda {" +
                "id='" + this.getId() + "\'" +
                "observacao='" + observacao + "\'" +
                "banda='" + banda.getDescricao() + "\'" +
                "pneu='" + pneu.getId() + "\'" +
                "ordem='" + ordem + "\'" +
                '}';
    }
}
