package br.com.frota.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class GenericModel {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GenericModel{" +
                "id=" + id +
                '}';
    }

    public String convertDateString(Date data) {
		SimpleDateFormat dateParser = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		return dateParser.format(data);
	}
}
