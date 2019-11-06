package model.dao.impl;

public interface ComandoSQL {

    String COMANDO_SQL_ENCONTRAR_PELO_ID = "SELECT vendas.* , departamento.Nome as DepNome " +
            "FROM vendas INNER JOIN departamento " +
            "ON vendas.DepartamentoId = departamento.Id " +
            "WHERE vendas.Id = ?";
}
