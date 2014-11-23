
package mvc.cargo.model;

import conexao.SqlServer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvc.cargo.Cargo;

public class RamCargoDAO implements CargoDAO {
    SqlServer con;

    @Override
    public void inserir(Cargo cargo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Cargo cargo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cargo getCargo(int codigo) {
        Cargo cargo = new Cargo();
        String sql = "select * from tb_cargo where car_codigo = " + codigo;
        SqlServer con = new SqlServer("localhost", "psf", "sa", "123456");
        try {
            con.connect();
            ResultSet rs = con.executar(sql);
            while (rs.next()) {
                cargo.setCodigo(rs.getInt("car_codigo"));
                cargo.setDescricao(rs.getString("car_descricao"));
            }
        } catch (SQLException e) {
                Logger.getLogger(RamCargoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            con.disconnect();
        }
        return cargo;
    }

    @Override
    public void excluir(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cargo> listar() {
        List<Cargo> lista = new ArrayList<>();
        int codigo;
        String descricao;
        RamCargoDAO ramCargoDao = new RamCargoDAO();
        try {
            con = new SqlServer("localhost", "psf", "sa", "123456");
            con.connect();
            ResultSet rs = con.executar("select * from tb_cargo");
            while (rs.next()) {
                codigo = rs.getInt("car_codigo");
                descricao = rs.getString("car_descricao");
                lista.add(new Cargo(codigo, descricao));
            }
        } catch (SQLException e) {

        } finally {
            con.disconnect();
        }
        return lista;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
