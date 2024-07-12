<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de Proveedores</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
    crossorigin="anonymous">
<link
    href="//cdn.datatables.net/2.0.8/css/dataTables.dataTables.min.css"
    rel="stylesheet">
<link rel="stylesheet" type="text/css" 
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" 
    integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<div class="container">
	    <h2>Registro de Proveedor</h2>
	    <form action="ProveedorServlet" method="post">
	        <div class="form-group">
	            <label for="nombre">Nombre:</label>
	            <input type="text" class="form-control" id="nombre" name="nombre" required>
	        </div>
	        <div class="form-group">
	            <label for="rut">RUT:</label>
	            <input type="text" class="form-control" id="rut" name="rut" required>
	        </div>
	        <div class="form-group">
	            <label for="direccion">Dirección:</label>
	            <input type="text" class="form-control" id="direccion" name="direccion" required>
	        </div>
	        <div class="form-group">
	            <label for="correo">Correo:</label>
	            <input type="email" class="form-control" id="correo" name="correo" required>
	        </div>
	        <div class="form-group">
	            <label for="telefono">Teléfono:</label>
	            <input type="text" class="form-control" id="telefono" name="telefono" required>
	        </div>
	        <div class="form-group">
	            <label for="contacto">Contacto:</label>
	            <input type="text" class="form-control" id="contacto" name="contacto" required>
	        </div>
	        <div class="form-group">
	            <label for="telefono_contacto">Teléfono Contacto:</label>
	            <input type="text" class="form-control" id="telefono_contacto" name="telefono_contacto" required>
	        </div>
	        <button type="submit" class="btn btn-primary">Registrar Proveedor</button>
	    </form>
	</div>
	<div class="container mt-4">
	    <h2>Lista de Proveedores</h2>
	    <table class="table table-striped">
	        <thead>
	            <tr>
	                <th>ID</th>
	                <th>Nombre</th>
	                <th>RUT</th>
	                <th>Dirección</th>
	                <th>Correo</th>
	                <th>Teléfono</th>
	                <th>Contacto</th>
	                <th>Teléfono Contacto</th>
	                <th>Acciones</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach var="proveedor" items="${proveedores}">
	                <tr>
	                    <td>${proveedor.id}</td>
	                    <td>${proveedor.nombre}</td>
	                    <td>${proveedor.rut}</td>
	                    <td>${proveedor.direccion}</td>
	                    <td>${proveedor.correo}</td>
	                    <td>${proveedor.telefono}</td>
	                    <td>${proveedor.contacto}</td>
	                    <td>${proveedor.telefonoContacto}</td>
	                    <td>
	                        <a href="ProveedorServlet?action=edit&id=${proveedor.id}" class="btn btn-warning btn-sm"><i class="fa-regular fa-pen-to-square"></i></a>
	                        <form action="ProveedorServlet" method="post" style="display:inline;">
	                            <input type="hidden" name="action" value="delete">
	                            <input type="hidden" name="id" value="${proveedor.id}">
	                            <button type="submit" class="btn btn-danger btn-sm"><i class="fa-regular fa-trash-can"></i></button>
	                        </form>
	                    </td>
	                </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	</div>
	<hr>
</body>
</html>