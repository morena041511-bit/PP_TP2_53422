# Trabajo Práctico N° 2: Programación Orientada a Objetos en Java

  Alumno: Morena Martin
  Legajo: 53422
  Comisión: 2K7
  Asignatura: Paradigmas de Programación - UTN Facultad Regional Mendoza (UTN FRM)

---

##  Descripción del Proyecto

Este proyecto corresponde a la resolución del Trabajo Práctico N° 2 de la materia Paradigmas de Programación[cite: 7]. Consiste en la evolución y escalado de un sistema de gestión de eventos universitarios orientado a objetos en Java, incorporando características avanzadas del paradigma:

1. **Modularización y Encapsulamiento:** Organización del código fuente mediante una jerarquía de paquetes (`modelo`, `modelo.actividades`, `modelo.certificacion` y `exepciones`) para proteger los componentes y estructurar correctamente las clases[cite: 1, 7].
2. **Gestión de Errores y Excepciones:** Modelado de excepciones personalizadas como objetos (ej. `CupoExcedidoException` heredando de `Exception`), aplicando bloques `try-catch-finally` y cláusulas `throws`/`throw` para garantizar la tolerancia a fallos[cite: 2, 7].
3. **Persistencia de Objetos:** Implementación de flujos de E/S (`FileOutputStream`, `ObjectOutputStream`, `FileInputStream`, `ObjectInputStream`) para almacenar y recuperar el estado de los eventos en disco mediante serialización y deserialización[cite: 3, 7].
4. **Interfaces y Polimorfismo:** Uso de la interfaz `Certificable` para extender el comportamiento de subtipos específicos (Talleres y Cursos) sin alterar la jerarquía principal de actividades[cite: 4, 7].
5. **Genéricos y Wildcards (Comodines):** Aplicación de clases/métodos parametrizados acotados (`<T extends Actividad>`) y comodines con límites superiores (`<? extends Actividad>`) para optimizar el filtrado de colecciones y el cálculo dinámico de costos[cite: 5, 7].

---

##  Guía para Clonar y Ejecutar el Proyecto

### Requisitos Previos
* Tener instalado **Java JDK 17** (o superior).
* Contar con un entorno de desarrollo integrado (IDE) compatible con proyectos Java, preferiblemente **IntelliJ IDEA**.
* Tener instalado **Git**.

1. Clonar el repositorio
  Abre tu terminal o consola de comandos y ejecuta la siguiente instrucción para clonar el repositorio mediante HTTPS:

  ```bash
  git clone [https://github.com/morena041511-bit/PP_TP2_53422.git](https://github.com/morena041511-bit/PP_TP2_53422.git).

2. Abrir en el IDE (IntelliJ IDEA)
  Abre IntelliJ IDEA.

  Selecciona File > Open y busca la carpeta del repositorio que acabas de clonar.

  Asegúrate de que el proyecto reconozca la ruta de las fuentes (src) y que esté configurado el Project SDK apuntando al JDK 17.

3. Ejecutar la Aplicación
  En el panel de navegación de la izquierda, despliega la carpeta src.

  Ubica la clase principal App (ubicada en la raíz del directorio src).

  Haz clic derecho sobre App.java y selecciona Run 'App.main()'.

 

      




