package aplicacao;

import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.entidade.Vendedor;

public class Programa {

    public static void main(String[] args) {


        VendedorDao vendedorDao = FabricaDao.criaVendedorDao();

        Vendedor vendedor = vendedorDao.procurarPorId(1);

        System.out.println(vendedor);
    }
}
