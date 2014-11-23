<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Funcionários</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <jsp:include page="../componentes/cabecalho.jsp" />
        <div class="container">
            <c:if test="${!(empty msg)}" >
                <span class="alert alert-success" style="margin: auto 15px">${msg}</span>
            </c:if>
            <h1>Inserir funcionário</h1>
            
            <form method="post">

                <label for="codigo">Código</label>
                <input type="text" name="codigo" value="Um novo código será criado automaticamente" class="form-control" disabled="disabled"><br>

                <label for="nome">Nome:</label>
                <input type="text" name="nome" placeholder="Digite um nome." class="form-control"><br>

                <label for="cargo">Cargo:</label>
                <select name="cargo" class="form-control">
                    <option value="0">Selecione o cargo</option>

                    <c:forEach items="${listaCargo}" var="cargo">
                        <c:choose>
                            <c:when test="${cargo.codigo == funcionario.cargo.codigo}">
                                <option value="${cargo.codigo}" selected="selected">${cargo.descricao}</option>
                            </c:when>

                            <c:otherwise>
                                <option value="${cargo.codigo}">${cargo.descricao}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select><br>

                <label for="nascimento">Data de nascimento:</label>
                <input type="date" name="nascimento" class="form-control"><br>

                <input type="submit" value="Confirmar" class="btn btn-default">
            </form>
        </div>
    </body>
</html>
