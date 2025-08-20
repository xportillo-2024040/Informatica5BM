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
    Propietario propietario = new Propietario();
    Propiedad propiedad = new Propiedad();
    int codPropietario;
    int codPropiedad;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        if (menu.equals("Propietario")) {
            switch (accion) {
                case "Listar":
                    List<Propietario> listaPropietario = propietarioDAO.listar();
                    request.setAttribute("propietarios", listaPropietario);
                    break;
                case "Agregar":
                    String nombrePropietario = request.getParameter("txtNombre");
                    String telefonoPropietario = request.getParameter("txtTelefono");
                    propietario.setNombre(nombrePropietario);
                    propietario.setTelefono(telefonoPropietario);
                    propietarioDAO.agregar(propietario);
                    request.getRequestDispatcher("Controlador?menu=Propietario&accion=Listar").forward(request, response);
                    return;
                case "Editar":
                    try {
                        codPropietario = Integer.parseInt(request.getParameter("codigoPropietario"));
                        Propietario p = propietarioDAO.listarCodigoPropietario(codPropietario);
                        request.setAttribute("propietario", p);
                    } catch (NumberFormatException e) {
                        System.err.println("Error al parsear el código de propietario para editar: " + e.getMessage());
                    }
                    break;
                case "Actualizar":
                    try {
                        int id = Integer.parseInt(request.getParameter("txtCodigoPropietario"));
                        String nomPropietario = request.getParameter("txtNombre");
                        String telPropietario = request.getParameter("txtTelefono");
                        propietario.setCodigoPropietario(id);
                        propietario.setNombre(nomPropietario);
                        propietario.setTelefono(telPropietario);
                        propietarioDAO.actualizar(propietario);
                    } catch (NumberFormatException e) {
                        System.err.println("Error al parsear el código de propietario para actualizar: " + e.getMessage());
                    }
                    request.getRequestDispatcher("Controlador?menu=Propietario&accion=Listar").forward(request, response);
                    return;
                case "Eliminar":
                    try {
                        codPropietario = Integer.parseInt(request.getParameter("codigoPropietario"));
                        propietarioDAO.eliminar(codPropietario);
                    } catch (NumberFormatException e) {
                        System.err.println("Error al parsear el código de propietario para eliminar: " + e.getMessage());
                    }
                    request.getRequestDispatcher("Controlador?menu=Propietario&accion=Listar").forward(request, response);
                    return;
            }
            List<Propietario> listaPropietarios = propietarioDAO.listar();
            request.setAttribute("propietarios", listaPropietarios);
            request.getRequestDispatcher("Propietario.jsp").forward(request, response);
        } else if (menu.equals("Propiedad")) {
            List<Propietario> listaPropietariosCombo = propietarioDAO.listar();
            request.setAttribute("propietarios", listaPropietariosCombo);

            switch (accion) {
                case "Listar":
                    List<Propiedad> listaPropiedad = propiedadDAO.listar();
                    request.setAttribute("propiedades", listaPropiedad);
                    break;
                case "Agregar":
                    try {
                        propiedad.setTipo(request.getParameter("txtTipo"));
                        propiedad.setDireccion(request.getParameter("txtDireccion"));
                        propiedad.setNumeroHabitaciones(Integer.parseInt(request.getParameter("txtNumeroHabitaciones")));
                        propiedad.setPrecio(request.getParameter("txtPrecio"));
                        propiedad.setCodigoPropietario(Integer.parseInt(request.getParameter("txtCodigoPropietario")));
                        propiedadDAO.agregar(propiedad);
                    } catch (NumberFormatException e) {
                        System.err.println("Error al parsear un campo numérico al agregar propiedad: " + e.getMessage());
                    }
                    request.getRequestDispatcher("Controlador?menu=Propiedad&accion=Listar").forward(request, response);
                    return;
                case "Editar":
                    try {
                        codPropiedad = Integer.parseInt(request.getParameter("codigoPropiedad"));
                        Propiedad pro = propiedadDAO.listarCodigoPropiedad(codPropiedad);
                        request.setAttribute("propiedad", pro);
                    } catch (NumberFormatException e) {
                        System.err.println("Error al parsear el código de propiedad para editar: " + e.getMessage());
                    }
                    break;
                case "Actualizar":
                    try {
                        propiedad.setCodigoPropiedad(Integer.parseInt(request.getParameter("txtCodigoPropiedad")));
                        propiedad.setTipo(request.getParameter("txtTipo"));
                        propiedad.setDireccion(request.getParameter("txtDireccion"));
                        propiedad.setNumeroHabitaciones(Integer.parseInt(request.getParameter("txtNumeroHabitaciones")));
                        propiedad.setPrecio(request.getParameter("txtPrecio"));
                        propiedad.setCodigoPropietario(Integer.parseInt(request.getParameter("txtCodigoPropietario")));
                        propiedadDAO.actualizar(propiedad);
                    } catch (NumberFormatException e) {
                        System.err.println("Error al parsear un campo numérico al actualizar propiedad: " + e.getMessage());
                    }
                    request.getRequestDispatcher("Controlador?menu=Propiedad&accion=Listar").forward(request, response);
                    return;
                case "Eliminar":
                    try {
                        codPropiedad = Integer.parseInt(request.getParameter("codigoPropiedad"));
                        propiedadDAO.eliminar(codPropiedad);
                    } catch (NumberFormatException e) {
                        System.err.println("Error al parsear el código de propiedad para eliminar: " + e.getMessage());
                    }
                    request.getRequestDispatcher("Controlador?menu=Propiedad&accion=Listar").forward(request, response);
                    return;
            }
            List<Propiedad> listaPropiedades = propiedadDAO.listar();
            request.setAttribute("propiedades", listaPropiedades);
            request.getRequestDispatcher("Propiedad.jsp").forward(request, response);
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