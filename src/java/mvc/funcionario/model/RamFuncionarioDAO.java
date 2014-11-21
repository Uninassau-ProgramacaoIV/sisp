
package mvc.funcionario.model;

import conexao.SqlServer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import mvc.funcionario.Funcionario;
import mvc.cargo.Cargo;

public class RamFuncionarioDAO implements FuncionarioDAO {
    private SqlServer con;

    @Override
    public void inserir(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario getFuncionario(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> listar() {
        List<Funcionario> lista = new ArrayList<Funcionario>();
        int codigo;
        String nome, nascimento;
        try {
            con = new SqlServer("localhost", "psf", "sa", "123456");
            con.connect();
            ResultSet rs = con.executar("select * from tb_funcionario");
            while (rs.next()) {
                codigo = rs.getInt("fun_codigo");
                nome = rs.getString("fun_nome");
                nascimento = rs.getString("fun_nascimento");
                lista.add(new Funcionario(codigo, nome, null, nascimento));
            }
        } catch (SQLException e) {
            
        }
        finally {
            con.disconnect();
        }
        return lista;
    }
    
}
