package aplicacao;

import model.dao.DaoFabrica;
import model.dao.VendedorDao;
import model.entidade.Departamento;
import model.entidade.Vendedor;

import java.util.Date;

public class Programa {

    public static void main(String[] args) {


        VendedorDao vendedorDao = DaoFabrica.criaVendedorDao();

        Vendedor vendedor = vendedorDao.procurarPorId(3);

        System.out.println(vendedorDao);
    }
}
