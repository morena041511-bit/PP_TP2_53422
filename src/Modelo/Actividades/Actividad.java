package Modelo.Actividades;

import Exepciones.CupoExcedidoException;
import Modelo.Estudiante;
import Modelo.Inscripcion;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad implements Serializable {
    private int id;
    private String titulo;
    private int cupoMaximo;
    public final int CUPO_MINIMO = 5;

    protected List<Inscripcion> inscripciones;

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }

    public Inscripcion inscribir(Estudiante estudiante) throws CupoExcedidoException {
        if (inscripciones.size() >= cupoMaximo) {
            throw new CupoExcedidoException("No hay cupo disponible en la actividad: " + titulo);
        }
        Inscripcion nuevaInscripcion = new Inscripcion(LocalDate.now(), "Confirmada", estudiante);
        inscripciones.add(nuevaInscripcion);
        return nuevaInscripcion;
    }

    public void mostrarInscripciones() {
        System.out.println("Inscripciones para " + titulo + ":");
        for (Inscripcion ins : inscripciones) {
            System.out.println("- " + ins.getEstudiante().getNombre() + " (" + ins.getEstado() + ")");
        }
    }

    public final void mostrarIdentificacion() {
        System.out.println("ID Actividad: " + id + " | Título: " + titulo);
    }

    public abstract double calcularCostoMateriales();

    public abstract String getTipo();

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public String getTitulo() {
        return titulo;
    }
}