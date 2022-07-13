package br.com.frota.DAO;

import br.com.frota.model.TipoEixo;
import br.com.frota.model.Eixo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EixoDAO extends ConexaoDB {

	private static final String INSERT = "INSERT INTO eixo (descricao, posicao, id_tipo_eixo) VALUES (?, ?, ?);";
	private static final String SELECT_BY_ID = "SELECT id, descricao, posicao, id_tipo_eixo, te.descricao descricao_tipo_eixo FROM eixo e"
			+ " JOIN tipo_eixo te ON (e.id_tipo_eixo = te.id)" + " WHERE id = ?";
	private static final String SELECT_ALL = "SELECT id, descricao, posicao, id_tipo_eixo, te.descricao descricao_tipo_eixo FROM eixo e"
			+ " JOIN tipo_eixo te ON (e.id_tipo_eixo = te.id)";
	private static final String DELETE = "DELETE FROM eixo WHERE id = ?;";
	private static final String UPDATE = "UPDATE eixo SET descricao = ?, posicao = ?, id_tipo_eixo = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM eixo;";

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

	public void insertEixo(Eixo entidade) {
		try (PreparedStatement preparedStatement = prapararSQL(INSERT)) {
			preparedStatement.setString(1, entidade.getDescricao());
			preparedStatement.setInt(2, entidade.getPosicao());
			preparedStatement.setInt(3, entidade.getTipo().getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public Eixo selectEixo(int id) {
		Eixo entidade = null;
		try (PreparedStatement preparedStatement = prapararSQL(SELECT_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String descricao = rs.getString("descricao");
				int posicao = rs.getInt("posicao");
				int id_tipo_eixo = rs.getInt("id_tipo_eixo");
				String descricao_tipo_eixo = rs.getString("descricao_tipo_eixo");
				entidade = new Eixo(id, descricao, posicao, new TipoEixo(id_tipo_eixo, descricao_tipo_eixo));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Eixo> selectAllEixos() {
		List<Eixo> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String descricao = rs.getString("descricao");
				int posicao = rs.getInt("posicao");
				int id_tipo_eixo = rs.getInt("id_tipo_eixo");
				String descricao_tipo_eixo = rs.getString("descricao_tipo_eixo");
				entidades.add(new Eixo(id, descricao, posicao, new TipoEixo(id_tipo_eixo, descricao_tipo_eixo)));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public boolean deleteEixo(int id) throws SQLException {
		try (PreparedStatement statement = prapararSQL(DELETE)) {
			statement.setInt(1, id);
			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean updateEixo(Eixo entidade) throws SQLException {
		try (PreparedStatement statement = prapararSQL(UPDATE)) {
			statement.setString(1, entidade.getDescricao());
			statement.setInt(2, entidade.getPosicao());
			statement.setInt(3, entidade.getTipo().getId());
			statement.setInt(4, entidade.getId());

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
