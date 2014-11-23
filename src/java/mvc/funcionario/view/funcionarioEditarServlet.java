
package mvc.funcionario.view;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.cargo.Cargo;
import mvc.cargo.CargoController;
import mvc.funcionario.Funcionario;
import mvc.funcionario.FuncionarioController;

public class funcionarioEditarServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("c"));
        
        Funcionario funcionario = FuncionarioController.getInstancia().getFuncionario(codigo);
        request.setAttribute("funcionario", funcionario);
        
        List<Cargo> listaCargo = CargoController.getInstancia().listar();
            request.setAttribute("listaCargo", listaCargo);
        
        RequestDispatcher rd = request.getRequestDispatcher("funcionario/FuncionarioEditar.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String nascimento = request.getParameter("nascimento");
        int codigo = Integer.parseInt(request.getParameter("c"));
        Cargo cargo = CargoController.getInstancia().getCargo(Integer.parseInt(request.getParameter("cargo")));
        Funcionario funcionario = new Funcionario(codigo, nome, cargo, nascimento);
        FuncionarioController.getInstancia().editar(funcionario);
        processRequest(request, response);
    }


}
