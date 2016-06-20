<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Cadastro Usuário</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Adicionar Usuário
</h1>

<c:url var="addAction" value="/usuario/add" ></c:url>

<form:form action="${addAction}" commandName="usuario">
<table>
	<c:if test="${!empty usuario.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Nome"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="country">
				<spring:message text="País"/>
			</form:label>
		</td>
		<td>
			<form:input path="country" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty usuario.name}">
				<input type="submit"
					value="<spring:message text="Alterar"/>" />
			</c:if>
			<c:if test="${empty usuario.name}">
				<input type="submit"
					value="<spring:message text="Incluir"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Lista de Usuários</h3>
<c:if test="${!empty listUsuarios}">
	<table class="tg">
	<tr>
		<th width="80">ID Usuário</th>
		<th width="120">Nome</th>
		<th width="120">País</th>
		<th width="60">Alterar</th>
		<th width="60">Excluir</th>
	</tr>
	<c:forEach items="${listUsuarios}" var="usuario">
		<tr>
			<td>${usuario.id}</td>
			<td>${usuario.name}</td>
			<td>${usuario.country}</td>
			<td><a href="<c:url value='/edit/${usuario.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${usuario.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
