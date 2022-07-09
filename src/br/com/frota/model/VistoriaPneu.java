package br.com.frota.model;

import br.com.frota.model.Pneu;
import java.util.Date;

public class VistoriaPneu extends GenericModel {
    private String observacao;
    private Date dataCadastro;
    private Pneu pneu;
    private VistoriaVeiculo vistoriaVeiculo;

    public VistoriaPneu(String observacao, Date dataCadastro, Pneu pneu, VistoriaVeiculo vistoriaVeiculo) {
        this.observacao = observacao;
        this.dataCadastro = dataCadastro;
        this.pneu = pneu;
        this.vistoriaVeiculo = vistoriaVeiculo;
    }

    public VistoriaPneu(Integer id, String observacao, Date dataCadastro, Pneu pneu, VistoriaVeiculo vistoriaVeiculo) {
        this.observacao = observacao;
        this.dataCadastro = dataCadastro;
        this.pneu = pneu;
        this.vistoriaVeiculo = vistoriaVeiculo;
        super.setId(id);
    }

    public VistoriaPneu(Integer id) {
        super.setId(id);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public DataCadastro getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(DataCadastro dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Pneu getPneu() {
        return pneu;
    }

    public void setPneu(Pneu pneu) {
        this.pneu = pneu;
    }

    public VistoriaVeiculo getVistoriaVeiculo() {
        return vistoriaVeiculo;
    }

    public void setVistoriaVeiculo(VistoriaVeiculo vistoriaVeiculo) {
        this.vistoriaVeiculo = vistoriaVeiculo;
    }

    @Override
    public String toString() {
        return "VistoriaPneu {" +
                "id='" + this.getId() + "\'" +
                "observacao='" + observacao + "\'" +
                "dataCadastro='" + convertDateString(dataCadastro) + "\'" +
                "pneu='" + pneu.getId() + "\'" +
                "vistoriaVeiculo='" + vistoriaVeiculo.getId() + "\'" +
                '}';
    }
}
