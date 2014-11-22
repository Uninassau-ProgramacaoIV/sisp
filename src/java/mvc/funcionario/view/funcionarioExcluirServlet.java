package mvc.funcionario.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.funcionario.FuncionarioController;

public class funcionarioExcluirServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("c"));
        FuncionarioController funcionarioController;
        try {
            FuncionarioController.getInstancia().excluir(codigo);
        } catch (Exception ex) {
            Logger.getLogger(funcionarioExcluirServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            response.sendRedirect("funcionarioListarServlet");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
