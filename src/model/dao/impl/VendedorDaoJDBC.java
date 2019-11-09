package model.dao.impl;

import db.Db;
import db.DbException;
import model.dao.VendedorDao;
import model.entidade.Departamento;
import model.entidade.Vendedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendedorDaoJDBC implements VendedorDao, Contantes, ComandoSQL {

    private Connection conn;
    private int primeiraInterrogacao;

    public VendedorDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inserir(Vendedor vendedor) {
        int nome = 1;
        int email = 2;
        int data = 3;
        int salario = 4;
        int idDeparmento = 5;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(SQL_INSERE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(nome, vendedor.getNome());
            preparedStatement.setString(email, vendedor.getEmail());
            preparedStatement.setDate(data, new java.sql.Date(vendedor.getAniversario().getTime()));
            preparedStatement.setDouble(salario, vendedor.getSalarioBase());
            preparedStatement.setInt(idDeparmento, vendedor.getDepartament().getId());

            int linhasAfetada = preparedStatement.executeUpdate();

            if (linhasAfetada > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    vendedor.setId(id);
                }
                Db.fechandoResultSet(resultSet);
            } else {
                throw new DbException("Erro inesperado nem uma linha afetada");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            Db.fechandoStatement(preparedStatement);
        }
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
                    SQL_PROCURAR_PELO_ID);
            preparedStatement.setInt(primeiraInterrogacao, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Departamento departamento = instaciaDepartamento(resultSet);
                return instanciaVendedor(resultSet, departamento);
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            Db.fechandoStatement(preparedStatement);
            Db.fechandoResultSet(resultSet);
        }
    }

    private Vendedor instanciaVendedor(ResultSet resultSet, Departamento departamento) throws SQLException {
        Vendedor obj = new Vendedor();
        obj.setId(resultSet.getInt(ID_VENDAS));
        obj.setNome(resultSet.getString(NOME_VENDAS));
        obj.setEmail(resultSet.getString(EMAIL_VENDAS));
        obj.setSalarioBase(resultSet.getDouble(SALARIO_BASE_VENDAS));
        obj.setAniversario(resultSet.getDate(ANIVERSARIO_VENDAS));
        obj.setDepartament(departamento);
        return obj;
    }

    private Departamento instaciaDepartamento(ResultSet resultSet) throws SQLException {
        Departamento departamento = new Departamento();
        departamento.setId(resultSet.getInt(DEPARTAMENTO_ID));
        departamento.setNome(resultSet.getString(DEP_NOME));
        return departamento;
    }

    @Override
    public List<Vendedor> procurarTodos() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = conn.prepareStatement(SQL_PROCURAR_TUDO);
            resultSet = preparedStatement.executeQuery();
            List<Vendedor> vendedores = new ArrayList<>();
            Map<Integer, Departamento> map = new HashMap<>();
            while (resultSet.next()) {
                Departamento dep = map.get(resultSet.getInt(DEPARTAMENTO_ID));
                if (dep == null) {
                    dep = instaciaDepartamento(resultSet);
                    map.put(resultSet.getInt(DEPARTAMENTO_ID), dep);
                }
                Vendedor vendedor = instanciaVendedor(resultSet, dep);
                vendedores.add(vendedor);
            }
            return vendedores;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            Db.fechandoStatement(preparedStatement);
            Db.fechandoResultSet(resultSet);
        }
    }

    @Override
    public List<Vendedor> procurarPorDepartamento(Departamento departamento) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        primeiraInterrogacao = 1;
        try {
            preparedStatement = conn.prepareStatement(SQL_PROCURAR_PELO_DEPARTAMENTO);
            preparedStatement.setInt(primeiraInterrogacao, departamento.getId());
            resultSet = preparedStatement.executeQuery();

            List<Vendedor> vendedores = new ArrayList<>();
            Map<Integer, Departamento> map = new HashMap<>();

            while (resultSet.next()) {

                Departamento dep = map.get(resultSet.getInt(DEPARTAMENTO_ID));

                if (dep == null) {
                    dep = instaciaDepartamento(resultSet);
                    map.put(resultSet.getInt(DEPARTAMENTO_ID), dep);
                }
                Vendedor vendedor = instanciaVendedor(resultSet, departamento);
                vendedores.add(vendedor);
            }
            return vendedores;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            Db.fechandoStatement(preparedStatement);
            Db.fechandoResultSet(resultSet);
        }
    }
}
