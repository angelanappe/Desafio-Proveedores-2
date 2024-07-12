package cl.praxis.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.praxis.connection.DatabaseConnection;
import cl.praxis.model.Proveedor;

public class ProveedorDAO {

	 public void insertarProveedor(Proveedor proveedor) throws SQLException {
	        String sql = "INSERT INTO proveedores (nombre, rut, direccion, correo, telefono, contacto, telefono_contacto) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, proveedor.getNombre());
	            statement.setString(2, proveedor.getRut());
	            statement.setString(3, proveedor.getDireccion());
	            statement.setString(4, proveedor.getCorreo());
	            statement.setString(5, proveedor.getTelefono());
	            statement.setString(6, proveedor.getContacto());
	            statement.setString(7, proveedor.getTelefonoContacto());
	            statement.executeUpdate();
	        }
	    }

	    public List<Proveedor> obtenerProveedores() throws SQLException {
	        List<Proveedor> proveedores = new ArrayList<>();
	        String sql = "SELECT id, nombre, rut, direccion, correo, telefono, contacto, telefono_contacto FROM proveedores";
	        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
	            ResultSet resultSet = statement.executeQuery();
	            while (resultSet.next()) {
	                Proveedor proveedor = new Proveedor();
	                proveedor.setId(resultSet.getInt("id"));
	                proveedor.setNombre(resultSet.getString("nombre"));
	                proveedor.setRut(resultSet.getString("rut"));
	                proveedor.setDireccion(resultSet.getString("direccion"));
	                proveedor.setCorreo(resultSet.getString("correo"));
	                proveedor.setTelefono(resultSet.getString("telefono"));
	                proveedor.setContacto(resultSet.getString("contacto"));
	                proveedor.setTelefonoContacto(resultSet.getString("telefono_contacto"));
	                proveedores.add(proveedor);
	            }
	        }
	        return proveedores;
	    }

	    public Proveedor obtenerProveedorPorId(int id) throws SQLException {
	        Proveedor proveedor = null;
	        String sql = "SELECT id, nombre, rut, direccion, correo, telefono, contacto, telefono_contacto FROM proveedores WHERE id = ?";
	        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, id);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                proveedor = new Proveedor();
	                proveedor.setId(resultSet.getInt("id"));
	                proveedor.setNombre(resultSet.getString("nombre"));
	                proveedor.setRut(resultSet.getString("rut"));
	                proveedor.setDireccion(resultSet.getString("direccion"));
	                proveedor.setCorreo(resultSet.getString("correo"));
	                proveedor.setTelefono(resultSet.getString("telefono"));
	                proveedor.setContacto(resultSet.getString("contacto"));
	                proveedor.setTelefonoContacto(resultSet.getString("telefono_contacto"));
	            }
	        }
	        return proveedor;
	    }

	    public void actualizarProveedor(Proveedor proveedor) throws SQLException {
	        String sql = "UPDATE proveedores SET nombre = ?, rut = ?, direccion = ?, correo = ?, telefono = ?, contacto = ?, telefono_contacto = ? WHERE id = ?";
	        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, proveedor.getNombre());
	            statement.setString(2, proveedor.getRut());
	            statement.setString(3, proveedor.getDireccion());
	            statement.setString(4, proveedor.getCorreo());
	            statement.setString(5, proveedor.getTelefono());
	            statement.setString(6, proveedor.getContacto());
	            statement.setString(7, proveedor.getTelefonoContacto());
	            statement.setInt(8, proveedor.getId());
	            statement.executeUpdate();
	        }
	    }

	    public void eliminarProveedor(int id) throws SQLException {
	        String sql = "DELETE FROM proveedores WHERE id = ?";
	        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, id);
	            statement.executeUpdate();
	        }
	    }
}
