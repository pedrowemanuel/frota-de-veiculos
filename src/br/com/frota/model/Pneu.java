package br.com.frota.model;

import br.com.frota.model.MarcaPneu;

public class Pneu extends GenericModel {
    private int raio;
    private String perfil;
    private String largura;
    private String altura;
    private String indiceCarga;
    private String indiceVelocidade;
    private MarcaPneu marcaPneu;

    public Pneu(int raio, String perfil, String largura, String altura, String indiceCarga, String indiceVelocidade, MarcaPneu marcaPneu) {
        this.raio = raio;
        this.perfil = perfil;
        this.largura = largura;
        this.altura = altura;
        this.indiceCarga = indiceCarga;
        this.indiceVelocidade = indiceVelocidade;
        this.marcaPneu = marcaPneu;
    }

    public Pneu(Integer id, int raio, String perfil, String largura, String altura, String indiceCarga, String indiceVelocidade, MarcaPneu marcaPneu) {
        this.raio = raio;
        this.perfil = perfil;
        this.largura = largura;
        this.altura = altura;
        this.indiceCarga = indiceCarga;
        this.indiceVelocidade = indiceVelocidade;
        this.marcaPneu = marcaPneu;
        super.setId(id);
    }

    public Pneu(Integer id) {
        super.setId(id);
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
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

    @Override
    public String toString() {
        return "Pneu {" +
                "id='" + this.getId() + "\'" +
                "raio='" + raio + "\'" +
                "perfil='" + perfil + "\'" +
                "largura='" + largura + "\'" +
                "altura='" + altura + "\'" +
                "indiceCarga='" + indiceCarga + "\'" +
                "indiceVelocidade='" + indiceVelocidade + "\'" +
                "marcaPneu='" + marcaPneu.getDescricao() + "\'" +
                '}';
    }
}
