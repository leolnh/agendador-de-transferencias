<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
<head>
	<title>Agendamento de Transferências</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="css/estilo.css">
</head>

<body>

<c:if test="${not empty mensagem}">
	<div class="alert alert-success">${mensagem}</div>
</c:if>
<c:forEach var="error" items="${errors}">
	<div class="alert alert-danger"><b><fmt:message key="${error.category}"/></b> - ${error.message}</div>
</c:forEach>
<div class="panel panel-default">
	
    <div class="panel-body">
    
		<form method="post" action="<c:url value="/agendar"/>">
		
		<div class="row">
			
			<div class="form-group col-md-4"> 
				<label for="origem"><fmt:message key="contaOrigem"/></label> 
				<input name="transferencia.contaOrigem" value="${transferencia.contaOrigem}" class="form-control" id="origem" type="text" placeholder="00000-0"> 
			</div>
			
			<div class="form-group col-md-4"> 
				<label for="destino"><fmt:message key="contaDestino"/></label> 
				<input name="transferencia.contaDestino" value="${transferencia.contaDestino}" class="form-control" id="destino" type="text" placeholder="00000-0"> 
			</div>
			
			<div class="form-group col-md-4"> 
				<label for="destino"><fmt:message key="dataDaTransferencia"/></label> 
				<input name="transferencia.dataDaTransferencia" value="${transferencia.dataDaTransferencia}" class="form-control" id="destino" type="text"  placeholder="DD/MM/AAAA"> 
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-4"> 
				<label for="valor"><fmt:message key="valor"/></label> 
				<input name="transferencia.valor" value="${transferencia.valor}" class="form-control" id="valor" type="text" placeholder="000,00"> 
			</div>
			
			
			<div class="form-group col-md-4"> 
				<label for="tipo"><fmt:message key="tipo"/></label> 
				<select name="transferencia.tipo" class="form-control" id="tipo">
			 		<c:forEach items="${tipos}" var="tipo">
						<option value="${tipo}" ${transferencia.tipo==tipo?' selected ':''}>${tipo}</option>  
		            </c:forEach>
				</select>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-4"> 
				<input type="submit" value="Agendar" class="btn btn-primary"/>
			</div>
		</div>
		</form>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-heading">
              <h3 class="panel-title">Transferências Agendadas</h3>
    </div>
    <div class="panel-body">
		<div class="table-responsive">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th><fmt:message key="contaOrigem"/></th>
						<th><fmt:message key="contaDestino"/></th>
						<th><fmt:message key="valor"/></th>
						<th><fmt:message key="taxa"/></th>
						<th><fmt:message key="dataDaTransferencia"/></th>
						<th><fmt:message key="dataDoAgendamento"/></th>
						<th><fmt:message key="tipo"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="transferencia" items="${transferencias}">
						<tr>
							<td class="conta">${transferencia.contaOrigem}</td>
							<td class="conta">${transferencia.contaDestino}</td>
							<td class="valor"><fmt:formatNumber type="currency" value="${transferencia.valor}" /></td>
							<td class="valor"><fmt:formatNumber type="currency" value="${transferencia.taxa}" /></td>
							<td class="data">${transferencia.dataDaTransferencia}</td>
							<td class="data">${transferencia.dataDoAgendamento}</td>
							<td class="tipo">${transferencia.tipo}</td>
						</tr>
					</c:forEach>
					
					<c:if test="${empty transferencias}">
						<tr>
							<td colspan="7">Nenhuma transferencia agendada.</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
</div>

</body>

</html>
