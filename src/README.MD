🐾 Taller Práctico – Herencia, Polimorfismo y Serialización en Java
🎯 Objetivo
Implementar un sistema de gestión de personas en una veterinaria, aplicando:

🧬 Herencia

🎭 Polimorfismo

🖥️ GUI con Swing

💾 Persistencia de datos

✅ Actividades realizadas
1. ✨ Refactorización de clases
   Creación de la clase base Persona con atributos comunes: nombre y identificacion.

Subclases:

Propietario

Veterinario

2. 📝 Atributos propios en las clases hijas
   Propietario

➕ telefono

Veterinario

➕ especialidad

3. 🗂️ Lista polimórfica
   Implementación de List<Persona> para almacenar propietarios y veterinarios.

4. 💻 Formulario dinámico con Swing
   Diseño de FormPersona.java con:

JComboBox para seleccionar tipo de persona.

Campo extra dinámico según selección (📞 teléfono o 🩺 especialidad).

✅ Validaciones de campos vacíos y documento numérico.

🆕 Botones:

Agregar

Eliminar por ID

🖥️ Área de texto para mostrar listado de personas registradas.

5. 🖊️ Método toString()
   Cada clase hija implementa su propio toString() para mostrar información clara y legible.

6. 💾 Persistencia de datos
   Serialización de objetos en personas.ser con ObjectOutputStream y ObjectInputStream.

🔄 Carga automática de datos al iniciar la aplicación.

📝 Actualización del archivo al agregar o eliminar personas.

7. 🔧 Cambios recientes (Mejoras en persistencia y estructura)
   ⚙️ Main.java
   Eliminada la lista local de personas sin persistencia.

Ahora se usa PersonaControlador para gestionar personas centralizadamente.

Agrega personas de prueba (Laura y Pedro) solo si la lista está vacía, evitando duplicados.

Garantiza persistencia usando agregar() del controlador, guardando en personas.dat.

✅ Flujo real implementado respetando MVC, evitando pérdida de datos.

📂 PersonaDAO.java
Agregada verificación y creación de la carpeta data antes de guardar el archivo personas.dat.

✅ Se soluciona el error "El sistema no puede encontrar la ruta especificada", asegurando persistencia desde la primera ejecución.

🗃️ Ejecución
Ejecuta Main.java para:

Configurar el LookAndFeel del sistema operativo.

Abrir la ventana principal FormPersona.

📁 Estructura de paquetes
css
Copiar
Editar
modelo/
├── Persona.java
├── Propietario.java
└── Veterinario.java

controlador/
└── PersonaControlador.java

dao/
├── PersonaDAO.java
└── ArchivoUtil.java

vista/
└── FormPersona.java

Main.java

📝 Notas adicionales
Incluye clases utilitarias (ArchivoUtil, ArchivoManager) para manejo de archivos de texto.

El sistema está preparado para futuras extensiones:

🐶 Gestión de mascotas

🔎 Filtrado de personas

🗃️ Conexión con bases de datos

👨‍💻 Autor
✍️ Taller realizado por Miguel Angel Guarin

🎓 Estado del taller: COMPLETADO ✅
