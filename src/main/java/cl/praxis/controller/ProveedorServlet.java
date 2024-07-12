package cl.praxis.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.model.dao.ProveedorDAO;
import cl.praxis.model.Proveedor;

@WebServlet("/ProveedorServlet")
public class ProveedorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProveedorDAO proveedorDAO;

    public void init() {
        proveedorDAO = new ProveedorDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            listarProveedores(request, response);
        } else {
            switch (action) {
                case "edit":
                    mostrarFormularioEdicion(request, response);
                    break;
                default:
                    listarProveedores(request, response);
                    break;
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            registrarProveedor(request, response);
        } else {
            switch (action) {
                case "update":
                    actualizarProveedor(request, response);
                    break;
                case "delete":
                    eliminarProveedor(request, response);
                    break;
                default:
                    registrarProveedor(request, response);
                    break;
            }
        }
    }

    private void listarProveedores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Proveedor> proveedores = proveedorDAO.obtenerProveedores();
            request.setAttribute("proveedores", proveedores);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error al cargar proveedores", e);
        }
    }

    private void mostrarFormularioEdicion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Proveedor proveedor = proveedorDAO.obtenerProveedorPorId(id);
            request.setAttribute("proveedor", proveedor);
            request.getRequestDispatcher("edicion.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error al cargar el proveedor", e);
        }
    }

    private void registrarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String rut = request.getParameter("rut");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String contacto = request.getParameter("contacto");
        String telefonoContacto = request.getParameter("telefono_contacto");

        Proveedor proveedor = new Proveedor(0, nombre, rut, direccion, correo, telefono, contacto, telefonoContacto);
        try {
            proveedorDAO.insertarProveedor(proveedor);
            response.sendRedirect("ProveedorServlet");
        } catch (SQLException e) {
            throw new ServletException("Error al insertar el proveedor", e);
        }
    }

    private void actualizarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String rut = request.getParameter("rut");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String contacto = request.getParameter("contacto");
        String telefonoContacto = request.getParameter("telefono_contacto");

        Proveedor proveedor = new Proveedor(id, nombre, rut, direccion, correo, telefono, contacto, telefonoContacto);
        try {
            proveedorDAO.actualizarProveedor(proveedor);
            response.sendRedirect("ProveedorServlet");
        } catch (SQLException e) {
            throw new ServletException("Error al actualizar el proveedor", e);
        }
    }

    private void eliminarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            proveedorDAO.eliminarProveedor(id);
            response.sendRedirect("ProveedorServlet");
        } catch (SQLException e) {
            throw new ServletException("Error al eliminar el proveedor", e);
        }
    }
}
