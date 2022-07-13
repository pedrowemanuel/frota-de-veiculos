package br.com.frota.DAO;

import br.com.frota.model.MedicaoBandaVistoria;
import br.com.frota.model.PneuBanda;
import br.com.frota.model.MedicaoVistoria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicaoBandaVistoriaDAO extends ConexaoDB {

	private static final String INSERT = "INSERT INTO medicao_banda_vistoria (valor,id_pneu_banda,id_medicao_vistoria) VALUES (?);";
	private static final String SELECT_BY_ID = "SELECT id, valor,id_pneu_banda,id_medicao_vistoria FROM medicao_banda_vistoria WHERE id = ?";
	private static final String SELECT_ALL = "SELECT id, valor,id_pneu_banda,id_medicao_vistoria FROM medicao_banda_vistoria;";
	private static final String DELETE = "DELETE FROM medicao_banda_vistoria WHERE id = ?;";
	private static final String UPDATE = "UPDATE medicao_banda_vistoria SET valor = ?, id_pneu_banda = ?,id_medicao_vistoria = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM medicao_banda_vistoria;";

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

	public void insertMedicaoBandaVistoria(MedicaoBandaVistoria entidade) {
		try (PreparedStatement preparedStatement = prapararSQL(INSERT)) {
			preparedStatement.setFloat(1, entidade.getValor());
			preparedStatement.setInt(2, entidade.getPneuBanda().getId());
			preparedStatement.setInt(3, entidade.getMedicaoVistoria().getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public MedicaoBandaVistoria selectMedicaoBandaVistoria(int id) {
		MedicaoBandaVistoria entidade = null;
		try (PreparedStatement preparedStatement = prapararSQL(SELECT_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				float valor = rs.getFloat("valor");
				int idPneuBanda = rs.getInt("id_pneu_banda");
				int idMedicaoVistoria = rs.getInt("id_medicao_vistoria");
				entidade = new MedicaoBandaVistoria(id, valor, new PneuBanda(idPneuBanda),
						new MedicaoVistoria(idMedicaoVistoria));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<MedicaoBandaVistoria> selectAllMedicaoBandaVistorias() {
		List<MedicaoBandaVistoria> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				float valor = rs.getFloat("valor");
				int idPneuBanda = rs.getInt("id_pneu_banda");
				int idMedicaoVistoria = rs.getInt("id_medicao_vistoria");
				entidades.add(new MedicaoBandaVistoria(id, valor, new PneuBanda(idPneuBanda),
						new MedicaoVistoria(idMedicaoVistoria)));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public boolean deleteMedicaoBandaVistoria(int id) throws SQLException {
		try (PreparedStatement statement = prapararSQL(DELETE)) {
			statement.setInt(1, id);
			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean updateMedicaoBandaVistoria(MedicaoBandaVistoria entidade) throws SQLException {
		try (PreparedStatement statement = prapararSQL(UPDATE)) {
			statement.setFloat(1, entidade.getValor());
			statement.setInt(2, entidade.getPneuBanda().getId());
			statement.setInt(3, entidade.getMedicaoVistoria().getId());
			statement.setInt(4, entidade.getId());

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
