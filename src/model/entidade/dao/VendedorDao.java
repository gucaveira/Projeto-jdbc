package model.entidade.dao;

import model.entidade.Departamento;
import model.entidade.Vendedor;

import java.util.List;

public interface VendedorDao {

    void inserir(Vendedor obj);

    void atualizar(Vendedor obj);

    void deletarPorId(Integer id);

    Vendedor procurarPorId(Integer id);

    List<Vendedor> procurarTodos();
}
