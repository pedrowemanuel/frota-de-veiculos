package br.com.frota.model;

import br.com.frota.model.Veiculo;
import br.com.frota.model.Eixo;
import br.com.frota.model.Pneu;

public class EixoVeiculo extends GenericModel {
    private Eixo eixo;
    private Veiculo veiculo;
    private Pneu pneu;

    public EixoVeiculo(Eixo eixo, Veiculo veiculo, Pneu pneu) {
        this.eixo = eixo;
        this.veiculo = veiculo;
        this.pneu = pneu;
    }

    public EixoVeiculo(Integer id, Eixo eixo, Veiculo veiculo, Pneu pneu) {
        this.eixo = eixo;
        this.veiculo = veiculo;
        this.pneu = pneu;
        super.setId(id);
    }

    public EixoVeiculo(Integer id) {
        super.setId(id);
    }

    public Eixo getEixo() {
        return eixo;
    }

    public void setEixo(Eixo eixo) {
        this.eixo = eixo;
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
        return "EixoVeiculo {" +
                "id='" + this.getId() + "\'" +
                "eixo='" + eixo.getId() + "\'" +
                "veiculo='" + veiculo.getId() + "\'" +
                "pneu='" + pneu.getId() + "\'" +
                '}';
    }
}
