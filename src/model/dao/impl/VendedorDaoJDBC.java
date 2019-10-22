package model.dao.impl;

import db.Db;
import db.DbException;
import model.dao.VendedorDao;
import model.entidade.Departamento;
import model.entidade.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class VendedorDaoJDBC implements VendedorDao {

    private Connection conn;

    public VendedorDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inserir(Vendedor obj) {

    }

    @Override
    public void atualizar(Vendedor obj) {

    }

    @Override
    public void deletarPorId(Integer id) {

    }

    @Override
    public Vendedor procurarPorId(Integer id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = conn.prepareStatement("SELECT vendas.*, " +
                    " departamento.Nome AS DepNameFROM vendas INNER JOIN " +
                    " departamento vendas.DepartamentoId = departamento.Id WHERE vendas.id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Departamento departamento = new Departamento();
                departamento.setId(resultSet.getInt("DepartamentoId"));
                departamento.setNome(resultSet.getString("DepName"));
                Vendedor obj = new Vendedor();
                obj.setId(resultSet.getInt("Id"));
                obj.setNome(resultSet.getString("Nome"));
                obj.setEmail(resultSet.getString("Email"));
                obj.setSalarioBase(resultSet.getDouble("SalarioBase"));
                obj.setAniversario(resultSet.getDate("Aniversario"));
                obj.setDepartament(departamento);

            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            Db.fechandoStatement(preparedStatement);
            Db.fechandoResultSet(resultSet);
        }
    }

    @Override
    public List<Vendedor> procurarTodos() {
        return null;
    }
}
