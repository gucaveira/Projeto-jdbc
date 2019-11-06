package aplicacao;

import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.entidade.Departamento;
import model.entidade.Vendedor;

import java.util.List;

public class Programa {

    public static void main(String[] args) {

        VendedorDao vendedorDao = FabricaDao.criaVendedorDao();
        System.out.println("=== TEST 1: vendas procuraPorId ===");
        Vendedor vendedor = vendedorDao.procurarPorId(1);
        System.out.println(vendedor);

        System.out.println("\n=== TEST 2: vendas procuraPorDepartamento ===");
        Departamento departamento = new Departamento(2, null);
        List<Vendedor> vendedores = vendedorDao.procurarPorDepartamento(departamento);
        for (Vendedor vend :
                vendedores) {
            System.out.println(vend);
        }
    }
}
