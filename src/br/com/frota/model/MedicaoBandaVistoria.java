package br.com.frota.model;

import br.com.frota.model.PneuBanda; 
import br.com.frota.model.MedicaoVistoria; 

public class MedicaoBandaVistoria extends GenericModel {
    private float valor;
    private PneuBanda pneuBanda;
    private MedicaoVistoria medicaoVistoria;

    public MedicaoBandaVistoria(float valor, PneuBanda pneuBanda, MedicaoVistoria medicaoVistoria) {
        this.valor = valor;
        this.pneuBanda = pneuBanda;
        this.medicaoVistoria = medicaoVistoria;
    }

    public MedicaoBandaVistoria(Integer id, float valor, PneuBanda pneuBanda, MedicaoVistoria medicaoVistoria) {
        this.valor = valor;
        this.pneuBanda = pneuBanda;
        this.medicaoVistoria = medicaoVistoria;
        super.setId(id);
    }

    public MedicaoBandaVistoria(Integer id) {
        super.setId(id);
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public PneuBanda getPneuBanda() {
        return pneuBanda;
    }

    public void setPneuBanda(PneuBanda pneuBanda) {
        this.pneuBanda = pneuBanda;
    }

    public MedicaoVistoria getMedicaoVistoria() {
        return medicaoVistoria;
    }

    public void setMedicaoVistoria(MedicaoVistoria medicaoVistoria) {
        this.medicaoVistoria = medicaoVistoria;
    }

    @Override
    public String toString() {
        return "MedicaoBandaVistoria {" +
                "id='" + this.getId() + "\'" +
                "valor='" + valor + "\'" +
                "pneuBanda='" + pneuBanda.getId() + "\'" +
                "medicaoVistoria='" + medicaoVistoria.getId() + "\'" +
                '}';
    }
}
