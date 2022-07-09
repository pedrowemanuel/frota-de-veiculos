package br.com.frota.DAO;

import br.com.frota.model.Banda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BandaDAO extends ConexaoDB {

    private static final String INSERT = "INSERT INTO banda (descricao) VALUES (?);";
    private static final String SELECT_BY_ID = "SELECT id, descricao FROM banda WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM banda;";
    private static final String DELETE = "DELETE FROM banda WHERE id = ?;";
    private static final String UPDATE = "UPDATE banda SET descricao = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM banda;";

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

    public void insertBanda(Banda entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Banda selectBanda(int id) {
        Banda entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                entidade = new Banda(id, descricao);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Banda> selectAllBandas() {
        List<Banda> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                entidades.add(new Banda(id, descricao));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteBanda(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateBanda(Banda entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE)) {
            statement.setString(1, entidade.getDescricao());
            statement.setInt(2, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
