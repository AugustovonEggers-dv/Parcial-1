package Ejercicio2;

import javax.swing.JOptionPane;

public class main {
	public static void main(String[] args) {
		
		 int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de pedido:"));
	        String cliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");

	        Pedido pedido = new Pedido(numero, cliente);

	        String[] opciones = {
	            "Mostrar Pedido",
	            "Agregar Producto",
	            "Cambiar Estado",
	            "Finalizar Pedido",
	            "Salir"
	        };

	        while (true) {
	            int opcion = JOptionPane.showOptionDialog(
	                    null,
	                    "Seleccione una opción",
	                    "Menú de Pedido",
	                    JOptionPane.DEFAULT_OPTION,
	                    JOptionPane.INFORMATION_MESSAGE,
	                    null,
	                    opciones,
	                    opciones[0]
	            );

	            switch (opcion) {
	                case 0:
	                    pedido.mostrarPedido();
	                    break;
	                case 1:
	                    String producto = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
	                    pedido.agregarProducto(producto); 
	                    break;
	                case 2:
	                    String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado (pendiente, en preparación, finalizado):");
	                    pedido.cambiarEstado(nuevoEstado);
	                    break;
	                case 3:
	                    pedido.finalizarPedido();
	                    break;
	                case 4:
	                    JOptionPane.showMessageDialog(null, "Saliendo...");
	                    return;
	                default:
	                    JOptionPane.showMessageDialog(null, "Opción inválida.");
	            }
	        }
	    }
	}

