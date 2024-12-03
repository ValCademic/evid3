# Proyecto Final - Sistema Hospital

## 1. Introduccion
El proyecto consiste en un gestor de datos, especificamente la creacion y modificacion de miembros y citas dentro de un hospital.

## 2. Requisitos
a) Existe documentación y manual de usuario

b) Tiene ventana de login

c) Se pueden consultar doctores existentes

d) Se pueden ingresar doctores que no existen

e) Se pueden consultar pacientes existentes

f) Se pueden ingresar pacientes que no existen

g) Se puede crear una cita con fecha, hora y observaciones

h) Hay validaciones para no ingresar datos en blanco

i) Hay validaciones de fecha

j) Existen métodos diseñados para las validaciones

k) Existen métodos diseñados para leer su archivo

l) Existen métodos diseñados en otro paquete para cada una de las operaciones CRUD requeridas en este checklist

m) Existe FAT jar

## 3. Instalacion
Para la correcta ejecución del programa, debe crearse la carpeta C:/Sistema\_HealthPlus en su ordenador.

## 4. Como usar el programa


### LOGIN

Al ejecutar el programa, se abre la ventana de login. Por el momento existen 2 usuarios:

    Usuario: admin

    Contraseña: 0000

y

    Usuario: usuario

    Contraseña: 2222
![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.002.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.002.png)

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.003.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.003.png)

Al dar clic a Login, y luego OK, te abrirá la pantalla de **Sistema**.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.004.jpeg](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.004.jpeg)

### Acerca De

Al dar clic a “Acerca De”, se muestra un mensaje con información acerca de la empresa.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.005.jpeg](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.005.jpeg)

### Salir

El botón salir te mostrara un mensaje de confirmación. Al dar clic a Yes, cerrará el programa.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.006.jpeg](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.006.jpeg)

### Citas

Al dar clic a citas, abrirá la ventana de consulta y registro de citas.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.007.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.007.png)

Las casillas enseguida de “Paciente:” al igual que la de “Doctor:”, muestran sus #ID correspondientes. Al seleccionar cualquiera, se mostrara el nombre del paciente o doctor correspondiente al ID en las cajas de texto debajo.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.008.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.008.png) >>>> ![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.009.jpeg](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.009.jpeg)

Al dar clic a “Crear”, se creará una cita con los datos ingresados.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.010.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.010.png)

Si das clic a “Buscar”, te mostrara la cita correspondiente al PACIENTE seleccionado.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.011.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.011.png) >>>> ![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.012.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.012.png)

Siempre al dar clic al botón “Cancelar”, te mostrara un mensaje de confirmación, y al dar clic a Yes, te regresara a la ventana Sistema.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.013.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.013.png) >>>> ![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.014.jpeg](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.014.jpeg)
### Registrar o Consultar Pacientes

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.015.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.015.png)

Buscar:

Al ingresar datos en la caja de ID y dar clic a Buscar, se identificará al paciente correspondiente al #ID y se auto-llenaran las cajas de información con sus datos.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.016.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.016.png)

En caso de no existir o encontrarse, dará la opción de crear un paciente nuevo. Para esto refiérase al botón Agregar.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.017.jpeg](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.017.jpeg)

Agregar:

Después de ingresar sus datos, puedes agregar un nuevo paciente. Si hay alguna caja de texto sin información NO SE AGREGARÁ y mostrará un mensaje de error.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.018.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.018.png)

En cambio, si llenas todas las celdas y das clic a Agregar, se agregará a la lista de datos.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.019.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.019.png)

Actualizar:

El botón de Actualizar te permite cambiar los datos de un paciente especifico. Cambia el dato que desees y da clic a Actualizar.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.020.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.020.png)

Eliminar:

Al dar clic a eliminar, se eliminará la información (de la lista de datos) del paciente al cual corresponde el ID introducido. Mostrará un mensaje de confirmación.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.021.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.021.png)

Al dar clic a Yes, se eliminará la información (sobre el paciente) del documento al igual que de las celdas.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.022.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.022.png)

Cancelar:

Por medio del botón Cancelar podrás regresar a la pantalla Sistema, después de dar clic a Yes.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.023.jpeg](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.023.jpeg)

### Registrar o Consultar Doctores:

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.024.jpeg](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.024.jpeg)

La pantalla de Registrar o Consultar Doctores funciona exactamente igual a la de pacientes, con la única excepción de la celda “Sexo” siendo reemplazada por la celda “Especializacion”.

Buscar:

En esta pantalla, podrás buscar doctores existentes por medio de la celda ID.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.025.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.025.png)

Agregar:

Para agregar un doctor nuevo, ingrese la información correspondiente a todas las celdas. De no ser así, se mostrará un mensaje de error, y no se guardará la información.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.026.jpeg](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.026.jpeg)

Actualizar:

Edita los datos correspondientes y da clic al botón de Actualizar.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.027.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.027.png)

Eliminar:

Se eliminará al doctor correspondiente a la ID ingresada.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.028.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.028.png) >>>> ![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.029.png](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.029.png)

Cancelar:

El botón de cancelar te regresará al menú Sistema.

![Aspose.Words.f581407b-c0fc-485b-be72-2535006668f3.030.jpeg](src%2FMANUAL%20DE%20USUARIO%2FAspose.Words.f581407b-c0fc-485b-be72-2535006668f3.030.jpeg)
