package mvc.funcionario;

import java.util.List;
import mvc.funcionario.model.*;

public class FuncionarioController 
{
    private static FuncionarioController instancia;
    
    private FuncionarioDAO dao;

    private FuncionarioController() 
    {
        dao = new RamFuncionarioDAO();
    }
    

    public static FuncionarioController getInstancia() 
    {
        if (instancia == null) 
        {
            instancia = new FuncionarioController();
        }

        return instancia;
    }

    public List<Funcionario> listar() throws Exception 
    {
        return dao.listar();
    }

    public void excluir( int codigo ) throws Exception 
    {
        validar( codigo );
        dao.excluir( codigo );
    }
    
    public Funcionario getFuncionario( int codigo ) throws Exception 
    {
        validar( codigo );
        return dao.getFuncionario( codigo );
    }
    
    public void editar(Funcionario funcionario) throws Exception 
    {
        validar( funcionario );
        validar( funcionario.getCodigo() );
        
        dao.alterar(funcionario);
    }
    
    public void inserir( Funcionario funcionario ) throws Exception 
    {
        validar( funcionario );
        dao.inserir( funcionario );
    }
    
    public void validar( int funcionarioId ) throws Exception
    {
        if( funcionarioId <= 0 )
        {
            throw new Exception( "O identificador do funcionário está incorreto." );
        }
    }
    
    public void validar( Funcionario func ) throws Exception
    {
        if( func == null )
        {
            throw new Exception( "O funcionário está nulo." );
        }
        else if( func.getNome() == null
                    ? true
                    : func.getNome().isEmpty() )
        {
            throw new Exception( "O funcionário está sem nome." );
        }
        else if( func.getNascimento() == null
                    ? true
                    : func.getNome().isEmpty() )
        {
            throw new Exception( "O funcionário está sem data de nascimento." );
        }
    }
}
