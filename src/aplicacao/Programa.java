package aplicacao;

import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.entidade.Departamento;
import model.entidade.Vendedor;

import java.util.Date;
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

        System.out.println("\n=== TEST 3: vendas procuraTudo ===");
        vendedores = vendedorDao.procurarTodos();
        for (Vendedor vend :
                vendedores) {
            System.out.println(vend);
        }

        System.out.println("\n=== TEST 4: vendas insere ===");
        Vendedor novoVendedor = new Vendedor(null,"Greg", "greg@gmail.com",
                new Date(), 4000.0, departamento);
        vendedorDao.inserir(novoVendedor);
        System.out.println("Inserido novo Id = " + novoVendedor.getId());

        System.out.println("\n=== TEST 5: vendas insere ===");
        vendedor = vendedorDao.procurarPorId(1);
        vendedor.setNome("Marta");
        vendedorDao.atualizar(vendedor);
        System.out.println("Atualizacão completada");
    }
}
