package br.com.frota.DAO;

import br.com.frota.model.VistoriaPneu;
import br.com.frota.model.VistoriaVeiculo;
import br.com.frota.model.Pneu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VistoriaPneuDAO extends ConexaoDB {

    private static final String INSERT = "INSERT INTO vistoria_pneu (observacao, data_cadastro, id_pneu, id_vistoria_veiculo) VALUES (?,?,?,?);";
    private static final String SELECT_BY_ID = "SELECT id, observacao, data_cadastro, id_pneu, id_vistoria_veiculo FROM vistoria_pneu WHERE id = ?";
    private static final String SELECT_ALL = "SELECT id, observacao, data_cadastro, id_pneu, id_vistoria_veiculo FROM vistoria_pneu;";
    private static final String DELETE = "DELETE FROM vistoria_pneu WHERE id = ?;";
    private static final String UPDATE = "UPDATE vistoria_pneu SET observacao = ?, data_cadastro = ?, id_pneu = ?, id_vistoria_veiculo = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM vistoria_pneu;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prapararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void insertVistoriaPneu(VistoriaPneu entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setString(2, entidade.convertDateString(entidade.getDataCadastro()));
            preparedStatement.setInt(3, entidade.getPneu().getId());
            preparedStatement.setInt(4, entidade.getVistoriaVeiculo().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public VistoriaPneu selectVistoriaPneu(int id) {
        VistoriaPneu entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                Date dataCadastro = rs.getDate("data_cadastro");
                int idPneu = rs.getInt("id_pneu");
                int idVistoriaVeiculo = rs.getInt("id_vistoria_veiculo");
                entidade = new VistoriaPneu(id, observacao, dataCadastro, new Pneu(idPneu), new VistoriaVeiculo(idVistoriaVeiculo));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<VistoriaPneu> selectAllVistoriaPneus() {
        List<VistoriaPneu> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                Date dataCadastro = rs.getDate("data_cadastro");
                int idPneu = rs.getInt("id_pneu");
                int idVistoriaVeiculo = rs.getInt("id_vistoria_veiculo");
                entidades.add(new VistoriaPneu(id, observacao, dataCadastro, new Pneu(idPneu), new VistoriaVeiculo(idVistoriaVeiculo)));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteVistoriaPneu(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateVistoriaPneu(VistoriaPneu entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE)) {
            statement.setString(1, entidade.getObservacao());
            statement.setString(2, entidade.convertDateString(entidade.getDataCadastro()));
            statement.setInt(3, entidade.getPneu().getId());
            statement.setInt(4, entidade.getVistoriaVeiculo().getId());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
