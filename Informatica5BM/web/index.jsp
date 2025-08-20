<%--
    Document    : index
    Created on : 19 ago 2025, 11:28:04
    Author      : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gestión de Propiedades</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="Styles/StyleIndex.css">
    </head>
    <body style="background: url('Images/fondo.jpg') no-repeat center center fixed; background-size: cover;">
        <div class="main-container">
            <h1>Bienvenidos a la Plataforma de Gestión de Propiedades</h1>
            <p>Explora un mundo de propiedades únicas y conecta con sus dueños.</p>

            <div class="link-cards-container">
                <a href="Controlador?menu=Propiedad&accion=Listar" class="link-card">
                    <div id="carouselPropiedad" class="carousel slide **carousel-fade** card-image" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="Images/images.jpg" class="d-block w-100" alt="Propiedad 1">
                            </div>
                            <div class="carousel-item">
                                <img src="Images/Propiedad2.jpg" class="d-block w-100" alt="Propiedad 2">
                            </div>
                            <div class="carousel-item">
                                <img src="Images/Propiedad3.jpg" class="d-block w-100" alt="Propiedad 3">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselPropiedad" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselPropiedad" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-text">
                        <h2>Gestionar Propiedades</h2>
                    </div>
                </a>

                <a href="Controlador?menu=Propietario&accion=Listar" class="link-card">
                    <div id="carouselPropietario" class="carousel slide **carousel-fade** card-image" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="Images/image.jpeg" class="d-block w-100" alt="Propietario 1">
                            </div>
                            <div class="carousel-item">
                                <img src="Images/Propietario2.jpg" class="d-block w-100" alt="Propietario 2">
                            </div>
                            <div class="carousel-item">
                                <img src="Images/Propietario3.jpg" class="d-block w-100" alt="Propietario 3">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselPropietario" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselPropietario" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-text">
                        <h2>Gestionar Propietarios</h2>
                    </div>
                </a>
            </div>
        </div>
    </body>
</html>