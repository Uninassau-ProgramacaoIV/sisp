package mvc.funcionario.view;

import java.io.IOException;
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

public class funcionarioInserirServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Cargo> listaCargo = CargoController.getInstancia().listar();
            request.setAttribute("listaCargo", listaCargo);
            
        RequestDispatcher rd = request.getRequestDispatcher("funcionario/FuncionarioInserir.jsp");
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
        int cargo = Integer.parseInt(request.getParameter("cargo"));
        String nascimento = request.getParameter("nascimento");
        
        FuncionarioController.getInstancia().inserir(new Funcionario(nome, CargoController.getInstancia().getCargo(cargo), nascimento));
        
        request.setAttribute("msg", "Cadastro realizado com sucesso.");
        processRequest(request, response);
    }
}
