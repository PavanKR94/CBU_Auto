<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Customer delete form</title>
	<link style="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
		>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<header> CRM - Customer Relationship Manager</header>
		</div>	
	</div>
	
	<div id="container">
		<h3> Delete customer</h3>
		<form:form action="deleteCustomer" modelAttribute="customer" method="POST">
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td>First name: </td>>
						<td>$
					</tr>
					
				</tbody>
			</table>
		
		</form:form>
	</div>	
	
</body>

</html>