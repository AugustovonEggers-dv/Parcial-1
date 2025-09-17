package Ejercicio1;

import java.time.LocalDate;
import java.time.Period;
import javax.swing.JOptionPane;

public class vehiculo {

    private String marca;
    private String modelo;
    private int anio;
    private int kilometraje;
    private String estado;
    private LocalDate ultimaRevision;

    public vehiculo(String marca, String modelo, int anio, int kilometraje, String estado) {
        this.marca = marca;
        this.modelo = modelo;
        if (anio > 1900 && anio <= LocalDate.now().getYear()) {
            this.anio = anio;
        } else {
            this.anio = LocalDate.now().getYear();
        }
        if (kilometraje >= 0) {
            this.kilometraje = kilometraje;
        } else {
            this.kilometraje = 0;
        }
        this.estado = estado;
        this.ultimaRevision = null; 
    }

    public vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = LocalDate.now().getYear();
        this.kilometraje = 0;
        this.estado = "pendiente";
        this.ultimaRevision = null;
    }

    public void mostrarDatos() {
        String datos = "Vehículo:\nMarca: " + marca +
                       "\nModelo: " + modelo +
                       "\nAño: " + anio +
                       "\nKilometraje: " + kilometraje +
                       "\nEstado: " + estado;

        if (ultimaRevision != null) {
            datos += "\nÚltima revisión: " + ultimaRevision;
            Period p = Period.between(ultimaRevision, LocalDate.now());
            datos += "\nDías desde la última revisión: " + p.getDays();
        } else {
            datos += "\nÚltima revisión: Ninguna";
        }

        int edad = LocalDate.now().getYear() - anio;
        datos += "\nEdad del vehículo: " + edad + " años";

        JOptionPane.showMessageDialog(null, datos);
    }

    public void registrarRevision() {
        this.ultimaRevision = LocalDate.now();
        JOptionPane.showMessageDialog(null,
                "El vehículo fue revisado el " + ultimaRevision);
    }

    public void cambiarEstado(String nuevoEstado) {
        switch (nuevoEstado.toLowerCase()) {
            case "en revisión":
            case "listo para retirar":
            case "pendiente":
                this.estado = nuevoEstado;
                JOptionPane.showMessageDialog(null,
                        "Estado cambiado a: " + nuevoEstado);
                break;
            default:
                JOptionPane.showMessageDialog(null,
                        "Estado inválido. Por favor, vuélvalo a intentar con: 'en revisión', 'listo para retirar' o 'pendiente'.");
        }
    }

    public void cambiarKilometraje(int kilometraje) {
        if (kilometraje >= 0) {
            this.kilometraje = kilometraje;
            JOptionPane.showMessageDialog(null,
                    "El kilometraje ha sido actualizado a " + kilometraje);
        } else {
            JOptionPane.showMessageDialog(null,
                    "El kilometraje no puede ser negativo. Por favor, inténtelo de nuevo");
        }
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public int getKilometraje() { return kilometraje; }
    public void setKilometraje(int kilometraje) { this.kilometraje = kilometraje; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDate getUltimaRevision() { return ultimaRevision; }
}
