package mvc.cargo;

import java.util.List;
import mvc.cargo.model.*;

public class CargoController {

    private CargoDAO dao;
    private static CargoController instancia;

    public static CargoController getInstancia() {
        if (instancia == null) {
            instancia = new CargoController();
        }

        return instancia;
    }

    public CargoController() {
        dao = new RamCargoDAO();
    }

    public List<Cargo> listar() {
        return dao.listar();
    }
    public Cargo getCargo(int codigo) {
        return dao.getCargo(codigo);
    }
}
