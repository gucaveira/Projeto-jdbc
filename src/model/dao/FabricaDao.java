package model.dao;

import db.Db;
import model.dao.impl.VendedorDaoJDBC;

public class FabricaDao {

    public static VendedorDao criaVendedorDao(){
        return new VendedorDaoJDBC(Db.abreConexao());
    }
}
