
package mvc.funcionario;

import java.util.List;
import mvc.funcionario.model.*;

public class FuncionarioController {
    private FuncionarioDAO dao;
    private static FuncionarioController instancia;


private FuncionarioController()
    {
        dao = new RamFuncionarioDAO();
    }

public static FuncionarioController getInstancia()
    {
        if( instancia == null )
        {
            instancia = new FuncionarioController();
        }
        
        return instancia;
    }

public List<Funcionario> listar() throws Exception
    {
        return dao.listar();
    }
}
