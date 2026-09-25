import Modelo.Actividades.*;
import Modelo.Certificacion.Certificable;
import Exepciones.CupoExcedidoException;
import Modelo.*;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Estudiante est1 = new Estudiante("50268", "Ignacio Perez");
        Estudiante est2 = new Estudiante("50269", "María Lopez");
        Estudiante est3 = new Estudiante("50270", "Juan Gomez");

        Sala sala = new Sala(1, "Laboratorio Sistemas");
        EventoUniversitario evento = new EventoUniversitario("EV_001", "Jornadas de Ingeniería de Software", 0.0, true);
        evento.asignarSala(sala);

        // Crear actividades
        Charla charla = new Charla(10, "Tendencias en POO", 50, "Ing. Martinez");
        Taller taller = new Taller(20, "Spring Boot Básico", 2, true); // Cupo restringido a 2 para forzar excepción
        Curso curso = new Curso(30, "Patrones de Diseño", 20, 1);

        evento.crearActividad(charla);
        evento.crearActividad(taller);
        evento.crearActividad(curso);

        // EJERCICIO 1: Manejo de Excepciones mediante try-catch-finally
        System.out.println("--- INSCRIPCIONES ---");
        try {
            System.out.println("Intentando inscribir estudiantes en el Taller...");
            taller.inscribir(est1); // Éxito
            taller.inscribir(est2); // Éxito
            System.out.println("Inscripciones exitosas.");

            // Forzar falla
            System.out.println("Intentando inscribir a un tercer estudiante...");
            taller.inscribir(est3);
        } catch (CupoExcedidoException e) {
            System.err.println("Error controlado: " + e.getMessage());
        } finally {
            System.out.println("Finalizó el proceso transaccional de inscripciones.\n");
        }

        // Inscribir en otras actividades para poblar los certificados
        try {
            curso.inscribir(est1);
            charla.inscribir(est2);
        } catch (CupoExcedidoException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // EJERCICIO 2: Interfaces y Emisión de Certificados
        System.out.println("--- EMISIÓN DE CERTIFICADOS ---");
        for (Actividad act : evento.getActividades()) {
            if (act instanceof Certificable) {
                Certificable certificable = (Certificable) act;
                for (Inscripcion ins : act.getInscripciones()) {
                    System.out.println(certificable.generarCertificado(ins.getEstudiante()));
                }
            }
        }

        // EJERCICIO 1: Persistencia de Objetos
        System.out.println("\n--- PERSISTENCIA ---");
        if (evento.persistirEvento()) {
            System.out.println("Evento persistido correctamente en disco.");
        }

        EventoUniversitario eventoRecuperado = EventoUniversitario.recuperarEvento("EV_001");
        if (eventoRecuperado != null) {
            System.out.println("Datos del evento recuperado desde el archivo:");
            eventoRecuperado.mostrarDatos();
        }

        // EJERCICIO 3: Generics y Wildcards
        System.out.println("\n--- FILTRADO POR CLASES PARAMETRIZADAS ---");
        List<Charla> listaCharlas = evento.filtrarActividadesPorTipo(Charla.class);
        List<Taller> listaTalleres = evento.filtrarActividadesPorTipo(Taller.class);
        List<Curso> listaCursos = evento.filtrarActividadesPorTipo(Curso.class);

        System.out.println("Cantidad de Charlas: " + listaCharlas.size());
        System.out.println("Cantidad de Talleres: " + listaTalleres.size());
        System.out.println("Cantidad de Cursos: " + listaCursos.size());

        System.out.println("\n--- CÁLCULO DE COSTO DE MATERIALES (Wildcards) ---");
        System.out.println("Costo total para Charlas: $" + evento.calcularCostoMateriales(listaCharlas));
        System.out.println("Costo total para Talleres: $" + evento.calcularCostoMateriales(listaTalleres));
        System.out.println("Costo total para Cursos: $" + evento.calcularCostoMateriales(listaCursos));
    }
}