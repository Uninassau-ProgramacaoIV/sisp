package mvc.cargo.model;

import java.util.List;
import mvc.cargo.Cargo;

public interface CargoDAO {
    public void inserir(Cargo cargo);
    public void alterar(Cargo cargo);
    public Cargo getCargo(int codigo);
    public void excluir(int codigo);
    public List<Cargo> listar();
}
