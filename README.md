# Proyecto de POO: Proyecto de Gestión de Tareas para Equipos de Desarrollo
Objetivo: Simplificar la asignación y seguimiento de tareas dentro de equipos de desarrollo, mejorando la colaboración y eficiencia en la gestión de proyectos.

El proyecto en cuestión ha sido desarrollado en lenguaje de programación Java en donde en el transcurso del mismo, se han aplicado diversos conocimientos y conceptos, los cuales han sido abordados a lo largo de todo el semestre, por lo que el diseño, la implementación, el desarrollo y la ejecución de este proyecto final han sido logrados en base a lo aprendido.

Para empezar, se ha utilizado como herramienta de desarrollo la aplicación IntellijIdea en donde se ha trabajado de principio a fin y se ha observado una alta confiabilidad y una excelente experiencia de usuario.

# Inicio de sesión

Para este trabajo acumulativo, se han definido dos tipos de roles: usuario administrador y usuario normal, los cuales a través de una ventana de inicio de sesión y con el uso de sus credenciales respectivas, ingresan a sus respectivos módulos y a partir de aquí, pueden ejecutar múltiples tipos de tareas.

![image](https://github.com/user-attachments/assets/d83a1179-e878-4e1e-a248-1347048f3664)

# Módulos líderes y miembros

Posteriormente, dependiendo del tipo de usuario, se mostrarán diferentes acciones, restringidas a su tipo y definidas tanto en los requerimientos como en la base de datos.

![image](https://github.com/user-attachments/assets/a81db5fa-9dbe-4e0c-9c69-76d538eac585)

![image](https://github.com/user-attachments/assets/2ec1ec16-9d5f-4e6b-a6dd-dc0231332792)

# Módulo líderes

En el caso del módulo de líderes, se evidencian 3 tipos de acciones, las cuales son: agregar miembros al equipo de desarrollo, agregar tareas para que las ejecuten dichos miembros y además, pueden ver el estado de las tareas, corroborar si sus desarrolladores están trabajando o no, además de una funcionalidad de cerrar sesión para abandonar el sistema.

Para la primera opción, si se ingresa, se podrá visualizar una nueva ventana en donde cada líder de grupo podrá asignar diversas tareas a cada miembro del equipo. Para este caso, se tendrán campos como por ejemplo título, descripción, categoría, fecha de inicio, fecha límite, el estado, la prioridad y el programador al que le fue asignado esta tarea.
Además, se ha implementado un sistema de verificación en donde no se pueden agregar tareas a cualquier usuario ya que este primero debe existir en la base de datos y muestra mensajes de advertencia o éxito, dependiendo de si el usuario ingresó bien o mal este último campo.

![image](https://github.com/user-attachments/assets/0c2f63a9-7338-47be-bbd0-f496c9d329ae)

Por otro lado, en el caso de agregar nuevos miembros, se tiene que los campos a ser llenados con nombre, apellido, cédula de identidad, número de teléfono, correo electrónico, entre otros, los cuales son importantes para conocer mejor a los programadores que ingresan al proyecto.

![image](https://github.com/user-attachments/assets/1335ed31-3e0b-4fc8-a2a6-6b262c1f2e7b)

Finalmente, se tiene el apartado de visualizar estado del equipo en donde los líderes tienen la capacidad de ver el estado de trabajo de sus programadores con tan solo ingresar el nombre de alguno de estos y automáticamente se mostrará en la misma ventana los datos de la tarea asignada al usuario ingresado.

![image](https://github.com/user-attachments/assets/fb4280cd-b473-4b90-ac07-d581b3ba7d78)

# Módulo miembros

Este módulo es mucho más restrictivo que el anterior puesto que este solo permite agregar nuevos miembros al equipo de desarrollo y actualizar el estado de las tareas.

Para la incorporación de nuevos miembros al equipo por parte de los mismos miembros, se ha reutilizado código de la sección de líderes, dado que a la final, la acción es la misma y se puede usar el mismo código e incluso el mismo tipo de ventana, lo cual ahorra tiempo para este caso específico.

En la parte de actualización de tareas, se ha agregado una función que permite modificar las tareas solo si estas existen dentro de la base de datos. En caso de que no fuese así, muestra un error que indica que la tarea no existe.

![image](https://github.com/user-attachments/assets/7b1e89ef-eade-4a69-8133-e236f5dbbb8e)

# Base de datos

En el caso de la base de datos se ha utilizado una de tipo semi-estructurada (MongoDB Compass) la cual alberga múltiples registros, cada uno dentro de colecciones según correspondan. Para este caso, hemos llamado a la base "BD_TaskFlow", misma que cuenta con 5 colecciones diferentes en donde se guardan, credenciales y datos personales, tanto de líderes como de miembros, además de tener la colección de tareas.

![image](https://github.com/user-attachments/assets/32c6eff5-36c8-4cb9-bc0f-424df3dbca91)

# Código fuente

Es importante adicionar el código fuente para visualizar lo que se ha hecho o logrado en el presente trabajo ya que forma parte de una evidencia imprescindible que demuestra la originalidad, calidad e ingenio durante la creación del proyecto.

Login:

![image](https://github.com/user-attachments/assets/3817424c-320a-431f-ad5f-f6592083a97a)

Módulo líderes:

![image](https://github.com/user-attachments/assets/76797296-3f58-471b-a535-ce9c5eb997ad)

Crear tareas, agregar miembros y visualizar estado del equipo, respectivamente (módulo líderes):

![image](https://github.com/user-attachments/assets/1916d97e-cba3-4636-8a6b-96cb4ffc9c31)

![image](https://github.com/user-attachments/assets/f554ed43-5342-47c3-a3bb-77e70620845f)

![Captura de pantalla 2024-08-07 223430](https://github.com/user-attachments/assets/a5611f67-5c12-4699-b657-c4276f6f046d)

Módulo miembros:

![image](https://github.com/user-attachments/assets/b99f03ab-0546-48dc-ae38-51be4119070c)

Actualizar tareas (módulo miembros):

![image](https://github.com/user-attachments/assets/cba713e5-d684-4602-a107-96aafc7ad96b)

# Documentación

Adicional a todo esto, se ha agregado la respectiva documentación a través de un Javadoc, el cual permite ver de manera más clara todo lo que se ha implementado: librerías, funciones, métodos, instrucciones, fragmentos de código del mismo o de otros proyectos, etc.

![image](https://github.com/user-attachments/assets/6bfdfe5c-d683-4180-bfdf-3d28526302e5)

Link del video: https://youtu.be/4Oj02mtFtYc

