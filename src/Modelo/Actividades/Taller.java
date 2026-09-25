package Modelo.Actividades;

import Modelo.Certificacion.Certificable;
import Modelo.Estudiante;

public  class Taller extends Actividad implements Certificable {
    private boolean requiereNotebook;

    public Taller(int id, String titulo, int cupoMaximo, boolean requiereNotebook) {
        super(id, titulo, cupoMaximo);
        this.requiereNotebook = requiereNotebook;
    }

    @Override
    public double calcularCostoMateriales() {
        return 1500.0; // Costo simulado
    }

    @Override
    public String getTipo() {
        return "Taller";
    }


    public String generarCertificado(Estudiante estudiante) {
        return "Certificado de " + ENTIDAD_EMISORA + " otorgado a " + estudiante.getNombre() +
                " por su asistencia al Taller: " + getTitulo();
    }
}