<%-- 
    Document   : Propiedad
    Created on : 19/08/2025
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="Styles/StyleCrud.css"/>
        <title>Gestión de Propiedad</title>
    </head>
    <body>
        <header class="headerOpciones">
            <div class="bannerInfo">
                <div class="logo">
                    <h1>Gestión de Propiedades</h1>
                </div>
            </div>
            <nav class="bannerOpciones">
                <ul class="menu">
                    <li><a href="index.jsp">Inicio</a></li>
                    <li><a href="Controlador?menu=Propietario&accion=Listar">Propietario</a></li>
                </ul>
            </nav>
        </header>

        <main class="crud-main">
            <section class="top-container">
                <div class="formulario">
                    <h2>Agregar / Modificar Propiedad</h2>
                    <form action="Controlador?menu=Propiedad" method="POST">
                        <label for="tipo">Tipo</label>
                        <select name="txtTipo" required>
                            <option value="Casa" <c:if test="${propiedad.tipo == 'Casa'}">selected</c:if>>Casa</option>
                            <option value="Apartamento" <c:if test="${propiedad.tipo == 'Apartamento'}">selected</c:if>>Apartamento</option>
                            </select>

                            <label for="direccion">Dirección</label>
                            <input type="text" value="${propiedad.direccion}" 
                               name="txtDireccion" placeholder="Dirección" required/>

                        <label for="habitaciones">Número de Habitaciones</label>
                        <input type="number" value="${propiedad.numeroHabitaciones}" 
                               name="txtNumeroHabitaciones" min="1" required/>

                        <label for="precio">Precio</label>
                        <input type="number" step="0.01" value="${propiedad.precio}" 
                               name="txtPrecio" placeholder="Ej: 150000.00" required/>

                        <label for="codigoPropietario">Propietario</label>
                        <select name="txtCodigoPropietario" required>
                            <c:forEach var="p" items="${propietarios}">
                                <option value="${p.codigoPropietario}" 
                                        <c:if test="${propiedad.codigoPropietario == p.codigoPropietario}">selected</c:if>>
                                    ${p.nombre}
                                </option>
                            </c:forEach>
                        </select>

                        <input type="hidden" name="txtCodigoPropiedad" 
                               value="${propiedad.codigoPropiedad}"/>

                        <button name="accion" value="Agregar" class="btn-agregar">Agregar</button>
                        <button name="accion" value="Actualizar" class="btn-Actualizar">Actualizar</button>
                    </form>
                </div>

                <div class="tabla-registros">
                    <h2>Propiedades Registradas</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Tipo</th>
                                <th>Dirección</th>
                                <th>Habitaciones</th>
                                <th>Precio</th>
                                <th>Propietario</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="r" items="${propiedades}">
                                <tr>
                                    <td>${r.codigoPropiedad}</td>
                                    <td>${r.tipo}</td>
                                    <td>${r.direccion}</td>
                                    <td>${r.numeroHabitaciones}</td>
                                    <td>${r.precio}</td>
                                    <td>${r.codigoPropietario}</td>
                                    <td id="table-button">
                                        <a href="Controlador?menu=Propiedad&accion=Editar&codigoPropiedad=${r.codigoPropiedad}" 
                                           class="btn-Actualizar">Editar</a>
                                        <a href="Controlador?menu=Propiedad&accion=Eliminar&codigoPropiedad=${r.codigoPropiedad}" 
                                           class="btn-drop btn-confirm-delete">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </section>
        </main>

        <footer id="footer" style="padding: 20px; text-align:center;">
            <p>© 2025 – Todos los derechos reservados.</p>
        </footer>


    </body>
</html>
