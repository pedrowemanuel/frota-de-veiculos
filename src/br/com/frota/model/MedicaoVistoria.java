package br.com.frota.model;

import br.com.frota.MarcaPneu;
import br.com.frota.VistoriaPneu;

public class MedicaoVistoria extends GenericModel {
    private int raio;
    private String perfil;
    private String largura;
    private String altura;
    private String indiceCarga;
    private String indiceVelocidade;
    private MarcaPneu marcaPneu;
    private VistoriaPneu vistoriaPneu;

    public MedicaoVistoria(int raio, String perfil, String largura, String altura, String indiceCarga, String indiceVelocidade, MarcaPneu marcaPneu, VistoriaPneu vistoriaPneu) {
        this.raio = raio;
        this.perfil = perfil;
        this.largura = largura;
        this.altura = altura;
        this.indiceCarga = indiceCarga;
        this.indiceVelocidade = indiceVelocidade;
        this.marcaPneu = marcaPneu;
        this.vistoriaPneu = vistoriaPneu;
    }

    public MedicaoVistoria(Integer id, int raio, String perfil, String largura, String altura, String indiceCarga, String indiceVelocidade, MarcaPneu marcaPneu, VistoriaPneu vistoriaPneu) {
        this.raio = raio;
        this.perfil = perfil;
        this.largura = largura;
        this.altura = altura;
        this.indiceCarga = indiceCarga;
        this.indiceVelocidade = indiceVelocidade;
        this.marcaPneu = marcaPneu;
        this.vistoriaPneu = vistoriaPneu;
        super.setId(id);
    }

    
    public MedicaoVistoria(Integer id) {
        super.setId(id);
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public String getperfil() {
        return perfil;
    }

    public void setperfil(String perfil) {
        this.perfil = perfil;
    }

    public String getLargura() {
        return largura;
    }

    public void setLargura(String largura) {
        this.largura = largura;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getIndiceCarga() {
        return indiceCarga;
    }

    public void setIndiceCarga(String indiceCarga) {
        this.indiceCarga = indiceCarga;
    }

    public String getIndiceVelocidade() {
        return indiceVelocidade;
    }

    public void setIndiceVelocidade(String indiceVelocidade) {
        this.indiceVelocidade = indiceVelocidade;
    }

    public MarcaPneu getMarcaPneu() {
        return marcaPneu;
    }

    public void setMarcaPneu(MarcaPneu marcaPneu) {
        this.marcaPneu = marcaPneu;
    }

    public MarcaPneu getVistoriaPneu() {
        return vistoriaPneu;
    }

    public void setVistoriaPneu(VistoriaPneu vistoriaPneu) {
        this.vistoriaPneu = vistoriaPneu;
    }

    @Override
    public String toString() {
        return "MedicaoVistoria {" +
                "id='" + this.getId() + "\'" +
                "raio='" + raio + "\'" +
                "perfil='" + perfil + "\'" +
                "largura='" + largura + "\'" +
                "altura='" + altura + "\'" +
                "indiceCarga='" + indiceCarga + "\'" +
                "indiceVelocidade='" + indiceVelocidade + "\'" +
                "marcaPneu='" + marcaPneu.getDescricao() + "\'" +
                "vistoriaPneu='" + vistoriaPneu.getId() + "\'" +
                '}';
    }
}
