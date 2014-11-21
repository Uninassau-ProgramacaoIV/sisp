<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Funcionários</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Listar Funcionários</h1>
        <table class="table table-striped">
            <tr class="tab-pane">
                <th>Alterar</th>
                <th>Excluir</th>
                <th>Código</th>
                <th>Nome</th>
            </tr>

            <c:forEach items="${lista}" var="funcionario">
                <tr>
                    <td><a href="#"><img src="imagens/alterar.png" alt="Alterar" title="Alterar"></a></td>
                    <td><a href="#"><img src="imagens/excluir.png" alt="Excluir" title="Excluir"></a></td>
                    <td>${funcionario.codigo}</td>
                    <td>${funcionario.nome}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
