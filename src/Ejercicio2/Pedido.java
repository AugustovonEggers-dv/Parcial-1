package Ejercicio2;
import javax.swing.JOptionPane;

public class Pedido {
    private int numeroPedido;
    private String cliente;
    private String estado;
    private double total;

    public Pedido(int numeroPedido, String cliente, String estado, double total) {
        if (numeroPedido > 0) {
            this.numeroPedido = numeroPedido;
        } else {
            this.numeroPedido = 1;
        }

        if (cliente != null && !cliente.isEmpty()) {
            this.cliente = cliente;
        } else {
            this.cliente = "Cliente desconocido";
        }

        if (total >= 0) {
            this.total = total;
        } else {
            this.total = 0;
        }

        this.estado = estado;
    }

    public Pedido(int numeroPedido, String cliente) {
        this(numeroPedido, cliente, "pendiente", 0.0);
    }

    public void mostrarPedido() {
        String datos = "Pedido #" + numeroPedido +
                       "\nCliente: " + cliente +
                       "\nEstado: " + estado +
                       "\nTotal: $" + total;
        JOptionPane.showMessageDialog(null, datos);
    }

    public void agregarProducto(String producto) {
        int min = 1000;
        int max = 10000;
        double precio = (int)(Math.random() * (max - min + 1) + min);

        total += precio;
        JOptionPane.showMessageDialog(null,
                "Producto agregado: " + producto +
                "\nPrecio asignado: $" + precio +
                "\nNuevo total: $" + total);
    }

    public void finalizarPedido() {
        estado = "finalizado";
        JOptionPane.showMessageDialog(null,
                "El pedido ha sido finalizado.\nTotal a pagar: $" + total);
    }

    public void cambiarEstado(String nuevoEstado) {
        String estadoMin = nuevoEstado.toLowerCase();

        switch (estadoMin) {
            case "pendiente":
            case "en preparación":
            case "finalizado":
                this.estado = nuevoEstado;
                JOptionPane.showMessageDialog(null,
                        "El estado ha cambiado a: " + nuevoEstado);
                break;
            default:
                JOptionPane.showMessageDialog(null,
                        "Estado inválido. Por favor, utilice: 'pendiente', 'en preparación' o 'finalizado'.");
        }
    }

    public int getNumeroPedido() { return numeroPedido; }
    public void setNumeroPedido(int numeroPedido) {
        if (numeroPedido > 0) {
            this.numeroPedido = numeroPedido;
        }
    }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) {
        if (cliente != null && !cliente.isEmpty()) {
            this.cliente = cliente;
        }
    }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { 
        this.estado = estado; 
    }

    public double getTotal() { return total; }
    public void setTotal(double total) { 
        if (total >= 0) {
            this.total = total;
        } else {
            this.total = 0;
        }
    }
}
