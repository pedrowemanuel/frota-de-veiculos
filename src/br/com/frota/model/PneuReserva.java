package br.com.frota.model;

import br.com.frota.model.Veiculo;
import br.com.frota.model.Pneu;

public class PneuReserva extends GenericModel {
    private String observacao;
    private Veiculo veiculo;
    private Pneu pneu;

    public PneuReserva(String observacao, Veiculo veiculo, Pneu pneu) {
        this.observacao = observacao;
        this.veiculo = veiculo;
        this.pneu = pneu;
    }

    public PneuReserva(Integer id, String observacao, Veiculo veiculo, Pneu pneu) {
        this.observacao = observacao;
        this.veiculo = veiculo;
        this.pneu = pneu;
        super.setId(id);
    }

    public PneuReserva(Integer id) {
        super.setId(id);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Pneu getPneu() {
        return pneu;
    }

    public void setPneu(Pneu pneu) {
        this.pneu = pneu;
    }

    @Override
    public String toString() {
        return "PneuReserva {" +
                "id='" + this.getId() + "\'" +
                "observacao='" + observacao + "\'" +
                "veiculo='" + veiculo.getDescricao() + "\'" +
                "pneu='" + pneu.getId() + "\'" +
                '}';
    }
}
