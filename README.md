Aclaracion subire los archivos de environment por ser una prueba tecnica en un ambiente real no deberian de subirse asi mismo la llave privada y publica 


Para el backend se tiene que agregar una configuracion que se encuentra en /src/main/resources/application-example.yml puede renombrarlo como application.yml

ahi se vera en el apartado de jwt un private.key y un public.key se deben de generar para poder encriptar y desencriptar el token jwt y despues agregarlos al /src/main/resources/
 
En linux con Openssl podemos crearlos asi 
openssl genrsa > private.key
openssl rsa -in private.key -pubout -out public.key


Debe de ejecutar el table.sql para la creacion de la base de datos
Hay un request.http el cual podra ver los diferentes endpoints como tal en este caso se ha creado un endpoint de registro para despues poder hacer el login


Para el frontend Se han creado archivos de environment el cual contiente la ruta 
Podran ver un login y despues de hacer login los deberia de llevar a una pantalla de contenido el cual tiene un navbar que tambien tiene un logout

Video demostrativo 
https://youtu.be/Oc1lquT_lbQ

Video demostrativo version con el crud de productos
https://youtu.be/ojK0_fXrfAc
