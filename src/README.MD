# Taller Práctico – Herencia, Polimorfismo y Serialización en Java

## 🎯 **Objetivo**

Implementar un sistema de gestión de personas en una veterinaria, aplicando conceptos de herencia, polimorfismo, GUI con Swing y persistencia de datos.

---

## ✅ **Actividades realizadas**

1. **Refactorización de clases**
    - Se creó la clase base `Persona` con atributos comunes: `nombre` y `identificacion`.
    - Las clases `Propietario` y `Veterinario` heredan de `Persona`.

2. **Atributos propios en las clases hijas**
    - `Propietario`:
        - Atributo propio: `telefono`.
    - `Veterinario`:
        - Atributo propio: `especialidad`.

3. **Lista polimórfica**
    - Se implementó una lista de tipo `List<Persona>` para almacenar tanto propietarios como veterinarios de manera polimórfica.

4. **Formulario dinámico con Swing**
    - Se diseñó un formulario (`FormPersona.java`) con:
        - `JComboBox` para seleccionar el tipo de persona.
        - Campo extra dinámico que cambia la etiqueta según la selección (teléfono o especialidad).
        - Validaciones de campos vacíos y de documento numérico.
        - Botones de **Agregar** y **Eliminar por ID**.
        - Área de texto para mostrar el listado de personas registradas.

5. **Implementación de `toString()`**
    - Cada clase hija implementa su propio método `toString()` para mostrar su información de manera clara en el listado.

6. **Persistencia opcional**
    - Se implementó persistencia de las personas mediante serialización de objetos en archivo `personas.ser` usando `ObjectOutputStream` y `ObjectInputStream`.
    - Al iniciar la aplicación, se cargan los datos previamente guardados.
    - Al agregar o eliminar personas, el archivo se actualiza.

---

## 💻 **Ejecución**

- Ejecutar la clase `Main.java`, que configura el `LookAndFeel` del sistema operativo y abre la ventana principal `FormPersona`.

---

## 📁 **Estructura de paquetes**

- **modelo**
    - `Persona.java`
    - `Propietario.java`
    - `Veterinario.java`

- **controlador**
    - `PersonaControlador.java`

- **dao / persistencia**
    - `PersonaDAO.java`
    - `ArchivoUtil.java` (utilidades de archivos)

- **vista**
    - `FormPersona.java`

- **Main.java**

---

## 📝 **Notas adicionales**

- Se implementaron clases utilitarias para manejo de archivos de texto (`ArchivoUtil`, `ArchivoManager`), aunque la persistencia principal usa serialización.
- El sistema está preparado para futuras extensiones, como filtrado de personas o conexión con gestión de mascotas.

---

## 👨‍💻 **Autor**

> Taller realizado por **Miguel Angel Guarin**  

---

### ✅ **Estado del taller: COMPLETADO**
