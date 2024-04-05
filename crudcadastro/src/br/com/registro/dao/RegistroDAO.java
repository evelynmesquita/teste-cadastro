package br.com.registro.dao;

import br.com.registro.model.Registro;
import br.com.registro.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistroDAO {
    private Connection connection;

    public RegistroDAO() {
        try {
            connection = ConnectionFactory.createConnectiontoMySQL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(Registro registro) {
        String sql = "INSERT INTO clientes (nome, cpf, idade) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, registro.getNome());
            statement.setString(2, registro.getCpf());
            statement.setInt(3, registro.getIdade());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Registro registro) {
        String sql = "UPDATE clientes SET nome = ?, cpf = ?, idade = ? WHERE codigo = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, registro.getNome());
            statement.setString(2, registro.getCpf());
            statement.setInt(3, registro.getIdade());
            statement.setInt(4, registro.getCodigo());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int codigo) {
        String sql = "DELETE FROM clientes WHERE codigo = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codigo);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Registro> getAllRegistros() {
        List<Registro> registros = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Registro registro = new Registro();
                registro.setCodigo(resultSet.getInt("codigo"));
                registro.setNome(resultSet.getString("nome"));
                registro.setCpf(resultSet.getString("cpf"));
                registro.setIdade(resultSet.getInt("idade"));
                registros.add(registro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registros;
    }
}
