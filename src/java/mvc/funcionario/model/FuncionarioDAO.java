
package mvc.funcionario.model;

import java.util.List;
import mvc.funcionario.Funcionario;

public interface FuncionarioDAO {
    public void inserir(Funcionario funcionario);
    public void alterar(Funcionario funcionario);
    public Funcionario getFuncionario(int codigo);
    public void excluir(int codigo);
    public List<Funcionario> listar();
}
