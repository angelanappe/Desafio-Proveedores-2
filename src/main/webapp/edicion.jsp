<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edición de Proveedor</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Edición de Proveedor</h2>
    <form action="ProveedorServlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${proveedor.id}">
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" class="form-control" id="nombre" name="nombre" value="${proveedor.nombre}" required>
        </div>
        <div class="form-group">
            <label for="rut">RUT:</label>
            <input type="text" class="form-control" id="rut" name="rut" value="${proveedor.rut}" required>
        </div>
        <div class="form-group">
            <label for="direccion">Dirección:</label>
            <input type="text" class="form-control" id="direccion" name="direccion" value="${proveedor.direccion}" required>
        </div>
        <div class="form-group">
            <label for="correo">Correo:</label>
            <input type="email" class="form-control" id="correo" name="correo" value="${proveedor.correo}" required>
        </div>
        <div class="form-group">
            <label for="telefono">Teléfono:</label>
            <input type="text" class="form-control" id="telefono" name="telefono" value="${proveedor.telefono}" required>
        </div>
        <div class="form-group">
            <label for="contacto">Contacto:</label>
            <input type="text" class="form-control" id="contacto" name="contacto" value="${proveedor.contacto}" required>
        </div>
        <div class="form-group">
            <label for="telefono_contacto">Teléfono Contacto:</label>
            <input type="text" class="form-control" id="telefono_contacto" name="telefono_contacto" value="${proveedor.telefonoContacto}" required>
        </div>
        <button type="submit" class="btn btn-primary">Guardar Cambios</button>
    </form>
</div>
</body>
</html>