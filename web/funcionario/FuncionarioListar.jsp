<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Funcionários</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            function ConfirmaExclusao(codigo) {
                var r = confirm("Você tem certesa que deseja excluir este item?");
                if (r == true) {
                    window.location= "funcionarioExcluirServlet?c=" + codigo;
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="../componentes/cabecalho.jsp" />
        <div class="container">
            <h1>Listar Funcionários</h1>
            <table class="table table-striped">
                <tr class="tab-pane">
                    <th width="30">Alterar</th>
                    <th width="30">Excluir</th>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Cargo</th>
                </tr>

                <c:forEach items="${lista}" var="funcionario">
                    <tr>
                        <td><a href="#"><img src="imagens/alterar.png" alt="Alterar" title="Alterar"></a></td>
                        <td><a href="#" onclick="ConfirmaExclusao(${funcionario.codigo})"><img src="imagens/excluir.png" alt="Excluir" title="Excluir"></a></td>
                        <td>${funcionario.codigo}</td>
                        <td>${funcionario.nome}</td>
                        <td>${funcionario.cargo.descricao}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
