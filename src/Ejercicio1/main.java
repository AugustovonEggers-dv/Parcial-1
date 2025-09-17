package Ejercicio1;

import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args) {
        String marca = JOptionPane.showInputDialog("Ingrese la marca:");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
        int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año:"));
        int km = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el kilometraje:"));
        String estado = JOptionPane.showInputDialog("Ingrese el estado inicial (en revisión, listo para retirar, pendiente):");

        vehiculo nuevo = new vehiculo(marca, modelo, anio, km, estado);

        
        do {
            String[] opcionesPosibles = {
                "Mostrar Datos",
                "Registrar revisión",
                "Cambiar estado",
                "Cambiar kilometraje",
                "Salir"
            };

            int opcion = JOptionPane.showOptionDialog(
                    null,
                    "¡Bienvenido de nuevo! Elija una opción:",
                    "Menú del vehículo",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcionesPosibles,
                    opcionesPosibles[0]
            );

            switch (opcion) {
                case 0:
                    nuevo.mostrarDatos();
                    break;
                case 1:
                    nuevo.registrarRevision();
                    break;
                case 2:
                    String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado:");
                    nuevo.cambiarEstado(nuevoEstado);
                    break;
                case 3:
                    int nuevoKm = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo kilometraje:"));
                    nuevo.cambiarKilometraje(nuevoKm);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }

            if (opcion == 4) break;

        } while (true);
    }
}
