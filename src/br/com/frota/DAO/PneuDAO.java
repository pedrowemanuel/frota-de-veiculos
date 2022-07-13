package br.com.frota.DAO;

import br.com.frota.model.Pneu;
import br.com.frota.model.MarcaPneu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PneuDAO extends ConexaoDB {

	private static final String INSERT = "INSERT INTO pneu (raio,perfil,largura,altura,indice_carga,indice_velocidade,id_marca_pneu) VALUES (?,?,?,?,?,?,?,?);";
	private static final String SELECT_BY_ID = "SELECT id, raio, perfil, largura, altura, indice_carga, indice_velocidade, id_marca_pneu FROM pneu WHERE id = ?";
	private static final String SELECT_ALL = "SELECT id, raio, perfil, largura, altura, indice_carga, indice_velocidade, id_marca_pneu FROM pneu;";
	private static final String DELETE = "DELETE FROM pneu WHERE id = ?;";
	private static final String UPDATE = "UPDATE pneu SET id = ?, raio = ?, perfil = ?, largura = ?, altura = ?, indice_carga = ?, indice_velocidade = ?, id_marca_pneu = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM pneu;";

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

	public void insertPneu(Pneu entidade) {
		try (PreparedStatement preparedStatement = prapararSQL(INSERT)) {
			preparedStatement.setInt(1, entidade.getRaio());
			preparedStatement.setString(2, entidade.getPerfil());
			preparedStatement.setString(3, entidade.getLargura());
			preparedStatement.setString(4, entidade.getAltura());
			preparedStatement.setString(5, entidade.getIndiceCarga());
			preparedStatement.setString(6, entidade.getIndiceVelocidade());
			preparedStatement.setInt(7, entidade.getMarcaPneu().getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public Pneu selectPneu(int id) {
		Pneu entidade = null;
		try (PreparedStatement preparedStatement = prapararSQL(SELECT_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int raio = rs.getInt("raio");
				String perfil = rs.getString("perfil");
				String largura = rs.getString("largura");
				String altura = rs.getString("altura");
				String indiceCarga = rs.getString("indice_carga");
				String indiceVelocidade = rs.getString("indice_velocidade");
				int idMarcaPneu = rs.getInt("id_marca_pneu");
				entidade = new Pneu(id, raio, perfil, largura, altura, indiceCarga, indiceVelocidade,
						new MarcaPneu(idMarcaPneu));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Pneu> selectAllPneus() {
		List<Pneu> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int raio = rs.getInt("raio");
				String perfil = rs.getString("perfil");
				String largura = rs.getString("largura");
				String altura = rs.getString("altura");
				String indiceCarga = rs.getString("indice_carga");
				String indiceVelocidade = rs.getString("indice_velocidade");
				int idMarcaPneu = rs.getInt("id_marca_pneu");
				entidades.add(new Pneu(id, raio, perfil, largura, altura, indiceCarga, indiceVelocidade,
						new MarcaPneu(idMarcaPneu)));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public boolean deletePneu(int id) throws SQLException {
		try (PreparedStatement statement = prapararSQL(DELETE)) {
			statement.setInt(1, id);
			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean updatePneu(Pneu entidade) throws SQLException {
		try (PreparedStatement statement = prapararSQL(UPDATE)) {
			statement.setInt(1, entidade.getRaio());
			statement.setString(2, entidade.getPerfil());
			statement.setString(3, entidade.getLargura());
			statement.setString(4, entidade.getAltura());
			statement.setString(5, entidade.getIndiceCarga());
			statement.setString(6, entidade.getIndiceVelocidade());
			statement.setInt(7, entidade.getMarcaPneu().getId());
			statement.setInt(8, entidade.getId());

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
