package br.com.frota.util;

import br.com.frota.DAO.MarcaDAO;
import br.com.frota.model.Marca;
import br.com.frota.DAO.TipoEixoDAO;
import br.com.frota.model.TipoEixo;

import java.sql.SQLException;
import java.util.List;

public class Teste {
    static MarcaDAO marcaDAO = new MarcaDAO();
    static MarcaPneuDAO  marcaPneuDAO = new MarcaPneuDAO();
    static TipoEixoDAO tipoEixoDAO = new TipoEixoDAO();
    static VeiculoDAO veiculoDAO = new VeiculoDAO();
    static PneuDAO pneuDAO = new PneuDAO();
    static VistoriaVeiculoDAO vistoriaVeiculoDAO = new VistoriaVeiculoDAO();

    public static void main(String[] args) throws SQLException {

//        //count
        System.out.println("Quantidade Marca: " + marcaDAO.count());
        System.out.println("Quantidade Marca Pneu: " + marcaPneuDAO.count());
        System.out.println("Quantidade Tipo Eixo: " + tipoEixoDAO.count());
        System.out.println("Quantidade Veiculo: " + veiculoDAO.count());
        System.out.println("Quantidade Pneu: " + pneuDAO.count());
        System.out.println("Quantidade Vistoria Veiculo: " + vistoriaVeiculoDAO.count());
//
//        //salvar
//        Marca marca = new Marca("Citroen");
//        marcaDAO.insertMarca(marca);
//
//        //buscar por ID
//        marca = marcaDAO.selectMarca(2);
//        System.out.println(marca);
//
//        //Update
//        marca.setDescricao("Volt");
//        marcaDAO.updateMarca(marca);
//        marca = marcaDAO.selectMarca(2);
//        System.out.println(marca);
//
//        //Select all
//        List<Marca> marcas = marcaDAO.selectAllMarcas();
//        marcas.forEach(System.out::println);
//
//        //Delete
//        marcaDAO.deleteMarca(2);
//        marcaDAO.selectAllMarcas().forEach(System.out::println);
    }
}
