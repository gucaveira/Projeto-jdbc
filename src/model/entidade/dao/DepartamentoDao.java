package model.entidade.dao;

import model.entidade.Departamento;

import java.util.List;

public interface DepartamentoDao {

   void inserir(Departamento obj);

   void atualizar(Departamento obj);

   void deletarPorId(Integer id);

   Departamento procurarPorId(Integer id);

   List<Departamento> procurarTodos();
}
