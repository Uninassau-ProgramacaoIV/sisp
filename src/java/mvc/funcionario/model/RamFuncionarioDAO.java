package mvc.funcionario.model;

import conexao.SqlServer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvc.cargo.Cargo;
import mvc.cargo.CargoController;
import mvc.cargo.model.RamCargoDAO;
import mvc.funcionario.Funcionario;

public class RamFuncionarioDAO implements FuncionarioDAO 
{
    private SqlServer con;

    @Override
    public void inserir(Funcionario funcionario) 
    {
        // Não fique criando e fechando a conexão, use DataSource.
        con = new SqlServer("localhost", "psf", "sa", "123456");
        
        try 
        {
            con.connect();
            
            // Use Prepared Stamenet em vez do Statement, isso preveni SQL Injection.
            // O código deve ser mais ou menos assim:
            
            // String SQL = "insert into tb_funcionario (fun_nome, fun_nascimento, fun_cargo) values (?,?,?);";
            // PreparedStatement pstm = con.preparedStatement( SQL );
            // pstm.setString( 1 , funcionario.getNome() );
            // pstm.setString( 2 , funcionario.getNascimento() );
            // pstm.setInt   ( 3 , funcionario.getCargo().getCodigo() );
            // pstm.execute();
            
            con.inserir("insert into tb_funcionario (fun_nome, fun_nascimento, fun_cargo) values ('"+funcionario.getNome()+"', '"+funcionario.getNascimento()+"', "+ funcionario.getCargo().getCodigo()+ ")");
        } 
        finally
        {
            con.disconnect();
        }
    }

    @Override
    public void alterar(Funcionario funcionario) {
        con = new SqlServer("localhost", "psf", "sa", "123456");
        try {
            con.connect();
            con.inserir("update tb_funcionario set fun_nome = '"+funcionario.getNome()+"', fun_nascimento = '"+funcionario.getNascimento()+"', fun_cargo = "+funcionario.getCargo().getCodigo()+" where fun_codigo = " + funcionario.getCodigo());
        } finally {
            con.disconnect();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario getFuncionario(int codigo) {
        Funcionario funcionario = new Funcionario();
        String sql = "select * from tb_funcionario where fun_codigo = " + codigo;
        SqlServer con = new SqlServer("localhost", "psf", "sa", "123456");
        try {
            con.connect();
            ResultSet rs = con.executar(sql);
            while (rs.next()) {
                funcionario.setCodigo(rs.getInt("fun_codigo"));
                funcionario.setNome(rs.getString("fun_nome"));
                funcionario.setCargo(new CargoController().getCargo(rs.getInt("fun_cargo")));
                funcionario.setNascimento(rs.getString("fun_nascimento"));
            }
        } catch (SQLException e) {
                Logger.getLogger(RamCargoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            con.disconnect();
        }
        return funcionario;
    }

    @Override
    public void excluir(int codigo) {
        try {
            con = new SqlServer("localhost", "psf", "sa", "123456");
            con.connect();
            con.inserir("delete from tb_funcionario where fun_codigo=" + codigo);
        } finally {
            con.disconnect();
        }
    }

    @Override
    public List<Funcionario> listar() {
        List<Funcionario> lista = new ArrayList<>();
        int codigo;
        String nome, nascimento;
        Cargo cargo;
        RamCargoDAO ramCargoDao = new RamCargoDAO();
        try {
            con = new SqlServer("localhost", "psf", "sa", "123456");
            con.connect();
            ResultSet rs = con.executar("select * from tb_funcionario");
            while (rs.next()) {
                codigo = rs.getInt("fun_codigo");
                nome = rs.getString("fun_nome");
                nascimento = rs.getString("fun_nascimento");
                cargo = ramCargoDao.getCargo(rs.getInt("fun_cargo"));
                lista.add(new Funcionario(codigo, nome, cargo, nascimento));
            }
        } catch (SQLException e) {

        } finally {
            con.disconnect();
        }
        return lista;
    }

}
