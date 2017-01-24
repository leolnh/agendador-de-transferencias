<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>Agendamento de Transferências</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="css/estilo.css">
</head>

<body>
<div class="alert alert-success">Transferência salva com sucesso</div>
<div class="panel panel-default">
	
    <div class="panel-body">
    
		<form method="post" action="<c:url value="/agendar"/>">
		
		<div class="row">
			
			<div class="form-group col-md-4"> 
				<label for="origem">Conta Origem</label> 
				<input name="transferencia.contaOrigem" class="form-control" id="origem" type="text"> 
			</div>
			
			<div class="form-group col-md-4"> 
				<label for="destino">Conta Destino</label> 
				<input name="transferencia.contaDestino" class="form-control" id="destino" type="text"> 
			</div>
			
			<div class="form-group col-md-4"> 
				<label for="destino">Data</label> 
				<input name="transferencia.dataDaTransferencia" class="form-control" id="destino" type="text"> 
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-4"> 
				<label for="valor">Valor</label> 
				<input name="transferencia.valor" class="form-control" id="valor" type="text"> 
			</div>
			
			
			<div class="form-group col-md-4"> 
				<label for="tipo">Tipo</label> 
				<select name="transferencia.tipo" class="form-control" id="tipo">
			 		<c:forEach items="${tipos}" var="tipo">
						<option value="${tipo}">${tipo}</option>  
		            </c:forEach>
				</select>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-4"> 
				<label>&nbsp;</label> 
				<input type="submit" value="Agendar" />
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
						<th>Conta Origem</th>
						<th>Conta Destino</th>
						<th>Valor</th>
						<th>Taxa</th>
						<th>Data</th>
						<th>Tipo</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="transferencia" items="${transferencias}">
						<tr>
							<td>${transferencia.contaOrigem}</td>
							<td>${transferencia.contaDestino}</td>
							<td><fmt:formatNumber type="currency" value="${transferencia.valor}" /></td>
							<td><fmt:formatNumber type="currency" value="${transferencia.taxa}" /></td>
							<td>${transferencia.dataDaTransferencia}</td>
							<td>${transferencia.tipo}</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
	</div>
</div>

</body>

</html>
