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

public class VendedorDaoJDBC implements VendedorDao, Contantes, ComandoSQL {

    private Connection conn;
    private int primeiraInterrogacao;

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
        primeiraInterrogacao = 1;
        try {
            preparedStatement = conn.prepareStatement(
                    COMANDO_SQL_ENCONTRAR_PELO_ID);
            preparedStatement.setInt(primeiraInterrogacao, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Departamento departamento = new Departamento();
                departamento.setId(resultSet.getInt(DEPARTAMENTO_ID));
                departamento.setNome(resultSet.getString(DEP_NOME));
                Vendedor obj = new Vendedor();
                obj.setId(resultSet.getInt(ID_VENDAS));
                obj.setNome(resultSet.getString(NOME_VENDAS));
                obj.setEmail(resultSet.getString(EMAIL_VENDAS));
                obj.setSalarioBase(resultSet.getDouble(SALARIO_BASE_VENDAS));
                obj.setAniversario(resultSet.getDate(ANIVERSARIO_VENDAS));
                obj.setDepartament(departamento);
                return obj;
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
