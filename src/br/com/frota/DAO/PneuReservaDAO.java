package br.com.frota.DAO;

import br.com.frota.model.PneuReserva;
import br.com.frota.model.Pneu;
import br.com.frota.model.Veiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PneuReservaDAO extends ConexaoDB {

    private static final String INSERT = "INSERT INTO pneu_reserva (observacao, id_veiculo, id_pneu) VALUES (?,?,?);";
    private static final String SELECT_BY_ID = "SELECT id, observacao, id_veiculo, id_pneu FROM pneu_reserva WHERE id = ?";
    private static final String SELECT_ALL = "SELECT id, observacao, id_veiculo, id_pneu FROM pneu_reserva;";
    private static final String DELETE = "DELETE FROM pneu_reserva WHERE id = ?;";
    private static final String UPDATE = "UPDATE pneu_reserva SET observacao = ?, id_veiculo = ?, id_pneu = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM pneu_reserva;";

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

    public void insertPneuReserva(PneuReserva entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setInt(2, entidade.getVeiculo().getId());
            preparedStatement.setInt(3, entidade.getPneu().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public PneuReserva selectPneuReserva(int id) {
        PneuReserva entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                int id_veiculo = rs.getInt("id_veiculo");
                int id_pneu = rs.getInt("id_pneu");
                entidade = new PneuReserva(id, observacao, new Veiculo(id_veiculo), new Pneu(id_pneu));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<PneuReserva> selectAllPneuReservas() {
        List<PneuReserva> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                int id_veiculo = rs.getInt("id_veiculo");
                int id_pneu = rs.getInt("id_pneu");
                entidades.add(new PneuReserva(id, observacao, new Veiculo(id_veiculo), new Pneu(id_pneu)));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deletePneuReserva(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updatePneuReserva(PneuReserva entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE)) {
            statement.setString(1, entidade.getObservacao());
            statement.setInt(2, entidade.getVeiculo().getId());
            statement.setInt(3, entidade.getPneu().getId());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
