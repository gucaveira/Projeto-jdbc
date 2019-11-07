package model.dao.impl;

public interface ComandoSQL {

    String SQL_PROCURAR_PELO_ID = "SELECT vendas.* , departamento.Nome as DepNome " +
            "FROM vendas INNER JOIN departamento " +
            "ON vendas.DepartamentoId = departamento.Id " +
            "WHERE vendas.Id = ?";

    String SQL_PROCURAR_PELO_DEPARTAMENTO = "SELECT vendas.*, departamento.Nome as DepNome " +
            " FROM vendas INNER JOIN departamento " +
            " ON vendas.DepartamentoId = departamento.Id " +
            " WHERE DepartamentoId = ? ORDER BY Nome";

    String SQL_PROCURAR_TUDO = "SELECT vendas.*, departamento.Nome as DepNome " +
            " FROM vendas INNER JOIN departamento " +
            " ON vendas.DepartamentoId = departamento.Id " +
            " ORDER BY Nome";
}
