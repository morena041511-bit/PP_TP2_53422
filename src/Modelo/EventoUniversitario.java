package Modelo;


import Modelo.Actividades.Actividad;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario implements Serializable {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos = 0;

    private Sala sala;
    private List<Actividad> actividades;

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        this.actividades = new ArrayList<>();
        cantidadEventos++;
    }

    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        this.sala = otro.sala;
        this.actividades = new ArrayList<>(otro.actividades);
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    public double calcularCostoEstimado() {
        return gratuito ? 0.0 : costoBase;
    }

    public void crearActividad(Actividad actividad) {
        this.actividades.add(actividad);
    }

    // Ejercicio 3: Uso de métodos parametrizados acotados (Generic bounded parameters)
    public <T extends Actividad> List<T> filtrarActividadesPorTipo(Class<T> tipo) {
        List<T> filtradas = new ArrayList<>();
        for (Actividad act : actividades) {
            if (tipo.isInstance(act)) {
                filtradas.add(tipo.cast(act));
            }
        }
        return filtradas;
    }

    // Ejercicio 3: Uso de wildcards con upper bounds
    public double calcularCostoMateriales(List<? extends Actividad> actividadesList) {
        double total = 0;
        for (Actividad act : actividadesList) {
            total += act.calcularCostoMateriales();
        }
        return total;
    }

    public void mostrarDatos() {
        System.out.println("Evento: " + titulo + " (ID: " + id + ")");
        if (sala != null) {
            System.out.println("Sala asignada: " + sala.getNombre());
        }
        System.out.println("Cantidad de actividades: " + actividades.size());
    }

    // Ejercicio 1: Serialización
    public boolean persistirEvento() {
        try (FileOutputStream fos = new FileOutputStream(this.id + ".dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
            return true;
        } catch (IOException e) {
            System.err.println("Error de E/S al guardar el evento: " + e.getMessage());
            return false;
        }
    }

    // Ejercicio 1: Deserialización
    public static EventoUniversitario recuperarEvento(String id) {
        try (FileInputStream fis = new FileInputStream(id + ".dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (EventoUniversitario) ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Error: No se encontró el archivo del evento.");
        } catch (IOException e) {
            System.err.println("Se produjo un error de E/S al leer el evento.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error de conversión de clase.");
        }
        return null;
    }

    public int getCantidadEventos() {
        return cantidadEventos;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }
}