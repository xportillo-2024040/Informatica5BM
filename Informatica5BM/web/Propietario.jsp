<%-- 
    Document   : Propietario
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
        <title>Gestión de Propietario</title>
    </head>
    <body>
        <header class="headerOpciones">
            <div class="bannerInfo">
                <div class="logo">
                    <h1>Gestión de Propietarios</h1>
                </div>
            </div>
            <nav class="bannerOpciones">
                <ul class="menu">
                    <li><a href="index.jsp">Inicio</a></li>
                    <li><a href="Controlador?menu=Propiedad&accion=Listar">Propiedad</a></li>
                </ul>
            </nav>
        </header>

        <main class="crud-main">
            <!-- FORMULARIO -->
            <section class="top-container">
                <div class="formulario">
                    <h2>Agregar / Modificar Propietario</h2>
                    <form action="Controlador?menu=Propietario" method="POST">
                        <label for="nombre">Nombre</label>
                        <input type="text" value="${propietario.nombre}" 
                               name="txtNombre" placeholder="Nombre completo" required/>

                        <label for="telefono">Teléfono</label>
                        <input type="text" value="${propietario.telefono}" 
                               name="txtTelefono" placeholder="Teléfono" required/>

                        <input type="hidden" name="txtCodigoPropietario" 
                               value="${propietario.codigoPropietario}"/>

                        <button name="accion" value="Agregar" class="btn-agregar">Agregar</button>
                        <button name="accion" value="Actualizar" class="btn-Actualizar">Actualizar</button>
                    </form>
                </div>

                <div class="tabla-registros">
                    <h2>Propietarios Registrados</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Nombre</th>
                                <th>Teléfono</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="p" items="${propietarios}">
                                <tr>
                                    <td>${p.codigoPropietario}</td>
                                    <td>${p.nombre}</td>
                                    <td>${p.telefono}</td>
                                    <td id="table-button">
                                        <a href="Controlador?menu=Propietario&accion=Editar&codigoPropietario=${p.codigoPropietario}" 
                                           class="btn-Actualizar">Editar</a>
                                        <a href="Controlador?menu=Propietario&accion=Eliminar&codigoPropietario=${p.codigoPropietario}" 
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
