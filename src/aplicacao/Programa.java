package aplicacao;

import model.dao.DaoFabrica;
import model.dao.VendedorDao;
import model.entidade.Departamento;
import model.entidade.Vendedor;

import java.util.Date;

public class Programa {

    public static void main(String[] args) {
        Departamento obj = new Departamento(1, "Livros");
        Vendedor vendedor = new Vendedor(21, "Bob", "Bob@gmail.com", new Date(), 3000.00,
                obj);
        System.out.println(vendedor);
        VendedorDao se = DaoFabrica.criaVendedorDao();
    }
}
