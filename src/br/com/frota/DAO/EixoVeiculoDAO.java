package br.com.frota.DAO;

import br.com.frota.model.EixoVeiculo;
import br.com.frota.model.Eixo;
import br.com.frota.model.Pneu;
import br.com.frota.model.Veiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EixoVeiculoDAO extends ConexaoDB {

    private static final String INSERT = "INSERT INTO eixo_veiculo (id_eixo, id_veiculo, id_pneu) VALUES (?,?,?);";
    private static final String SELECT_BY_ID = "SELECT id, id_eixo, id_veiculo, id_pneu FROM eixo_veiculo WHERE id = ?";
    private static final String SELECT_ALL = "SELECT id, id_eixo, id_veiculo, id_pneu FROM eixo_veiculo;";
    private static final String DELETE = "DELETE FROM eixo_veiculo WHERE id = ?;";
    private static final String UPDATE = "UPDATE eixo_veiculo SET id_eixo = ?, id_veiculo = ?, id_pneu = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM eixo_veiculo;";

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

    public void insertEixoVeiculo(EixoVeiculo entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT)) {
            preparedStatement.setInt(1, entidade.getEixo().getId());
            preparedStatement.setInt(2, entidade.getVeiculo().getId());
            preparedStatement.setInt(3, entidade.getPneu().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public EixoVeiculo selectEixoVeiculo(int id) {
        EixoVeiculo entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_eixo = rs.getInt("id_eixo");
                int id_veiculo = rs.getInt("id_veiculo");
                int id_pneu = rs.getInt("id_pneu");
                entidade = new EixoVeiculo(id, new Eixo(id_eixo), new Veiculo(id_veiculo), new Pneu(id_pneu));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<EixoVeiculo> selectAllEixoVeiculos() {
        List<EixoVeiculo> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int id_eixo = rs.getInt("id_eixo");
                int id_veiculo = rs.getInt("id_veiculo");
                int id_pneu = rs.getInt("id_pneu");
                entidades.add(new EixoVeiculo(id,  new Eixo(id_eixo), new Veiculo(id_veiculo), new Pneu(id_pneu)));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEixoVeiculo(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEixoVeiculo(EixoVeiculo entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE)) {
            statement.setInt(1, entidade.getEixo().getId());
            statement.setInt(2, entidade.getVeiculo().getId());
            statement.setInt(3, entidade.getPneu().getId());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
