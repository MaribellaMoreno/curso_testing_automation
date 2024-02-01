#language:es

Característica: Crear cuenta en opencart

  Escenario: Crear una cuenta en el sitio opencart
    Dado un usuario que se encuentra en la home page
    Cuando el usuario navega a la pagina de registro
    Y realiza el registro de datos en registrar cuenta con nombre "Maribella", apellido "Moran", usuario "MMoreno", telefono "957123456", contrasenia "hola123"
    Entonces valido elementos de registro cuenta
