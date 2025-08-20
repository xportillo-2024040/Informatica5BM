package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;

public class Controlador extends HttpServlet {

    PropietarioDAO propietarioDAO = new PropietarioDAO();
    PropiedadDAO propiedadDAO = new PropiedadDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        switch (menu) {
            case "Propietario":
                switch (accion) {
                    case "Listar":
                        List<Propietario> listaPropietario = propietarioDAO.listar();
                        request.setAttribute("propietarios", listaPropietario);
                        break;
                    case "Agregar":
                        String nombrePropietario = request.getParameter("txtNombre");
                        String telefonoPropietario = request.getParameter("txtTelefono");
                        Propietario nuevoPropietario = new Propietario();
                        nuevoPropietario.setNombre(nombrePropietario);
                        nuevoPropietario.setTelefono(telefonoPropietario);
                        propietarioDAO.agregar(nuevoPropietario);
                        break;
                    case "Editar":
                        try {
                            int codPropietario = Integer.parseInt(request.getParameter("codigoPropietario"));
                            Propietario p = propietarioDAO.listarCodigoPropietario(codPropietario);
                            request.setAttribute("propietario", p);
                        } catch (NumberFormatException e) {
                            System.err.println("Error al parsear el código de propietario para editar: " + e.getMessage());
                            // Puedes agregar un mensaje de error para el usuario si lo deseas
                        }
                        break;
                    case "Actualizar":
                        try {
                            int id = Integer.parseInt(request.getParameter("txtCodigoPropietario"));
                            String nomPropietario = request.getParameter("txtNombre");
                            String telPropietario = request.getParameter("txtTelefono");
                            Propietario propActualizado = new Propietario();
                            propActualizado.setCodigoPropietario(id);
                            propActualizado.setNombre(nomPropietario);
                            propActualizado.setTelefono(telPropietario);
                            propietarioDAO.actualizar(propActualizado);
                        } catch (NumberFormatException e) {
                            System.err.println("Error al parsear el código de propietario para actualizar: " + e.getMessage());
                        }
                        break;
                    case "Eliminar":
                        try {
                            int codPropietario = Integer.parseInt(request.getParameter("codigoPropietario"));
                            propietarioDAO.eliminar(codPropietario);
                        } catch (NumberFormatException e) {
                            System.err.println("Error al parsear el código de propietario para eliminar: " + e.getMessage());
                        }
                        break;
                }
                List<Propietario> listaPropietarios = propietarioDAO.listar();
                request.setAttribute("propietarios", listaPropietarios);
                request.getRequestDispatcher("Propietario.jsp").forward(request, response);
                break;

            case "Propiedad":
                // Obtener la lista de propietarios para el combo box
                List<Propietario> listaPropietariosCombo = propietarioDAO.listar();
                request.setAttribute("propietarios", listaPropietariosCombo);

                switch (accion) {
                    case "Listar":
                        List<Propiedad> listaPropiedad = propiedadDAO.listar();
                        request.setAttribute("propiedades", listaPropiedad);
                        break;
                    case "Agregar":
                        try {
                            Propiedad nuevaPropiedad = new Propiedad();
                            nuevaPropiedad.setTipo(request.getParameter("txtTipo"));
                            nuevaPropiedad.setDireccion(request.getParameter("txtDireccion"));
                            nuevaPropiedad.setNumeroHabitaciones(Integer.parseInt(request.getParameter("txtNumeroHabitaciones")));
                            nuevaPropiedad.setPrecio(request.getParameter("txtPrecio"));
                            nuevaPropiedad.setCodigoPropietario(Integer.parseInt(request.getParameter("txtCodigoPropietario")));
                            propiedadDAO.agregar(nuevaPropiedad);
                        } catch (NumberFormatException e) {
                            System.err.println("Error al parsear un campo numérico al agregar propiedad: " + e.getMessage());
                        }
                        break;
                    case "Editar":
                        try {
                            int codPropiedad = Integer.parseInt(request.getParameter("codigoPropiedad"));
                            Propiedad pro = propiedadDAO.listarCodigoPropiedad(codPropiedad);
                            request.setAttribute("propiedad", pro);
                        } catch (NumberFormatException e) {
                            System.err.println("Error al parsear el código de propiedad para editar: " + e.getMessage());
                        }
                        break;
                    case "Actualizar":
                        try {
                            Propiedad propActualizada = new Propiedad();
                            propActualizada.setCodigoPropiedad(Integer.parseInt(request.getParameter("txtCodigoPropiedad")));
                            propActualizada.setTipo(request.getParameter("txtTipo"));
                            propActualizada.setDireccion(request.getParameter("txtDireccion"));
                            propActualizada.setNumeroHabitaciones(Integer.parseInt(request.getParameter("txtNumeroHabitaciones")));
                            propActualizada.setPrecio(request.getParameter("txtPrecio"));
                            propActualizada.setCodigoPropietario(Integer.parseInt(request.getParameter("txtCodigoPropietario")));
                            propiedadDAO.actualizar(propActualizada);
                        } catch (NumberFormatException e) {
                            System.err.println("Error al parsear un campo numérico al actualizar propiedad: " + e.getMessage());
                        }
                        break;
                    case "Eliminar":
                        try {
                            int codPropiedad = Integer.parseInt(request.getParameter("codigoPropiedad"));
                            propiedadDAO.eliminar(codPropiedad);
                        } catch (NumberFormatException e) {
                            System.err.println("Error al parsear el código de propiedad para eliminar: " + e.getMessage());
                        }
                        break;
                }
                List<Propiedad> listaPropiedades = propiedadDAO.listar();
                request.setAttribute("propiedades", listaPropiedades);
                request.getRequestDispatcher("Propiedad.jsp").forward(request, response);
                break;
        }
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
