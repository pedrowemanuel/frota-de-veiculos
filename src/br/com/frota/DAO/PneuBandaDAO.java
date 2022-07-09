package br.com.frota.DAO;

import br.com.frota.model.PneuBanda;
import br.com.frota.model.Pneu;
import br.com.frota.model.Banda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PneuBandaDAO extends ConexaoDB {

    private static final String INSERT = "INSERT INTO pneu_banda (observacao, id_banda, id_pneu, ordem) VALUES (?,?,?,?);";
    private static final String SELECT_BY_ID = "SELECT id, observacao, id_banda, id_pneu, ordem FROM pneu_banda WHERE id = ?";
    private static final String SELECT_ALL = "SELECT id, observacao, id_banda, id_pneu, ordem FROM pneu_banda;";
    private static final String DELETE = "DELETE FROM pneu_banda WHERE id = ?;";
    private static final String UPDATE = "UPDATE pneu_banda SET observacao = ?, id_banda = ?, id_pneu = ?, ordem = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM pneu_banda;";

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

    public void insertPneuBanda(PneuBanda entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setInt(2, entidade.getBanda().getId());
            preparedStatement.setInt(3, entidade.getPneu().getId());
            preparedStatement.setInt(4, entidade.getOrdem());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public PneuBanda selectPneuBanda(int id) {
        PneuBanda entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                int id_banda = rs.getInt("id_banda");
                int id_pneu = rs.getInt("id_pneu");
                int ordem = rs.getInt("ordem");
                entidade = new PneuBanda(id, observacao, new Banda(id_banda), new Pneu(id_pneu), ordem);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<PneuBanda> selectAllPneuBandas() {
        List<PneuBanda> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                int id_banda = rs.getInt("id_banda");
                int id_pneu = rs.getInt("id_pneu");
                int ordem = rs.getInt("ordem");
                entidades.add(new PneuBanda(id, observacao, new Banda(id_banda), new Pneu(id_pneu), ordem));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deletePneuBanda(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updatePneuBanda(PneuBanda entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE)) {
            statement.setString(1, entidade.getObservacao());
            statement.setInt(2, entidade.getBanda().getId());
            statement.setInt(3, entidade.getPneu().getId());
            statement.setInt(4, entidade.getOrdem());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
