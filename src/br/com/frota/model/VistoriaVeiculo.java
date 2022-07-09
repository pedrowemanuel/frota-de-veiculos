package br.com.frota.model;

import br.com.frota.model.Veiculo;
import java.util.Date;

public class VistoriaVeiculo extends GenericModel {
    private String observacao;
    private Date dataVistoria;
    private Veiculo veiculo;
    private String userName;

    public VistoriaVeiculo(String observacao, Date dataVistoria, Veiculo veiculo, String userName) {
        this.observacao = observacao;
        this.dataVistoria = dataVistoria;
        this.veiculo = veiculo;
        this.userName = userName;
    }

    public VistoriaVeiculo(Integer id, String observacao, Date dataVistoria, Veiculo veiculo, String userName) {
        this.observacao = observacao;
        this.dataVistoria = dataVistoria;
        this.veiculo = veiculo;
        this.userName = userName;
        super.setId(id);
    }

    public VistoriaVeiculo(Integer id) {
        super.setId(id);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public DataVistoria getDataVistoria() {
        return dataVistoria;
    }

    public void setDataVistoria(DataVistoria dataVistoria) {
        this.dataVistoria = dataVistoria;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "VistoriaVeiculo {" +
                "id='" + this.getId() + "\'" +
                "observacao='" + observacao + "\'" +
                "dataVistoria='" + convertDateString(dataVistoria) + "\'" +
                "veiculo='" + veiculo.getDescricao() + "\'" +
                "userName='" + userName + "\'" +
                '}';
    }
}
