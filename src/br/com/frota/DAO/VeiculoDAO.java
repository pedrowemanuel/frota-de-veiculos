package br.com.frota.DAO;

import br.com.frota.model.Veiculo;
import br.com.frota.model.Marca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO extends ConexaoDB {

	private static final String INSERT = "INSERT INTO veiculo (descricao, id_marca) VALUES (?, ?);";
	private static final String SELECT_BY_ID = "SELECT id, descricao, v.id_marca, m.descricao descricao_marca FROM veiculo v"
			+ "INNER JOIN marca m ON (v.id_marca = m.id)" + "WHERE id = ?";
	private static final String SELECT_ALL = "SELECT id, descricao, v.id_marca, m.descricao descricao_marca FROM veiculo v"
			+ "INNER JOIN marca m ON (v.id_marca = m.id)";
	private static final String DELETE = "DELETE FROM veiculo WHERE id = ?;";
	private static final String UPDATE = "UPDATE veiculo SET descricao = ?, id_marca = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM veiculo;";

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

	public void insertVeiculo(Veiculo entidade) {
		try (PreparedStatement preparedStatement = prapararSQL(INSERT)) {
			preparedStatement.setString(1, entidade.getDescricao());
			preparedStatement.setInt(2, entidade.getMarca().getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public Veiculo selectVeiculo(int id) {
		Veiculo entidade = null;
		try (PreparedStatement preparedStatement = prapararSQL(SELECT_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String descricao = rs.getString("descricao");
				int id_marca = rs.getInt("id_marca");
				String descricao_marca = rs.getString("descricao_marca");

				entidade = new Veiculo(id, descricao, new Marca(id_marca, descricao_marca));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Veiculo> selectAllVeiculos() {
		List<Veiculo> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String descricao = rs.getString("descricao");
				int id_marca = rs.getInt("id_marca");
				String descricao_marca = rs.getString("descricao_marca");

				entidades.add(new Veiculo(id, descricao, new Marca(id_marca, descricao_marca)));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public boolean deleteVeiculo(int id) throws SQLException {
		try (PreparedStatement statement = prapararSQL(DELETE)) {
			statement.setInt(1, id);
			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean updateVeiculo(Veiculo entidade) throws SQLException {
		try (PreparedStatement statement = prapararSQL(UPDATE)) {
			statement.setString(1, entidade.getDescricao());
			statement.setInt(2, entidade.getMarca().getId());
			statement.setInt(3, entidade.getId());

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
