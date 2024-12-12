package integraciondeconocimientos;

import javax.swing.JOptionPane;

public class Habitacion {

    private int precio;
    private int numeroHabitacion;
    private String estado;
    private String tipo;
    //Cotandor 1,Libre 2.Ocupada 3.Sucia
    private int contador;

    public Habitacion(int precio, int numeroHabitacion, String estado, String tipo, int contador) {
        this.precio = precio;
        this.numeroHabitacion = numeroHabitacion;
        this.estado = estado;
        this.tipo = tipo;
        this.contador = contador;
    }

    public Habitacion() {
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String mostrarHabitacion() {
        String mensaje = "";

        mensaje = "Habitacion: " + this.numeroHabitacion + "\n" + this.estado + "\n" + this.tipo + "\n" + this.precio;
        return mensaje;

    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        //verificamos que precion no sea 0 o negativo

        this.precio = precio;

    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado() {
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Cual es el estado\n" + "1.Libre\n" + "2.Ocupado\n" + "3.Sucia"));
        if (opcion == 1) {
            this.estado = "Libre";
            this.contador = 1;
        }
        if (opcion == 2) {
            this.estado = "Ocupado";
            this.contador = 2;
        }
        if (opcion == 3) {
            this.estado = "Sucio";
            this.contador = 3;
        } else {
            JOptionPane.showMessageDialog(null, "Opcion no valida es estado ahora es ocupado intente otra vez");
            this.estado = "Ocupado";
            this.contador = 2;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo() {
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Cual es el tipo de habitacion\n" + "1.Individual\n" + "2.Doble\n"));
        if (opcion == 1) {
            this.tipo = "Individual";
        }
        if (opcion == 2) {
            this.tipo = "Doble";
        } else {
            JOptionPane.showMessageDialog(null, "Opcion no valida");
            this.tipo = "N/A";

        }
    }

}
