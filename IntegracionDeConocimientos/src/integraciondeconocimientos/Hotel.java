package integraciondeconocimientos;

import javax.swing.JOptionPane;

public class Hotel {

    //Cantidad de pisos y habitaciones
    private Habitacion habitacion[][] = new Habitacion[2][2];

    //Cantidad de habitaciones Limpias, Ocupadas, Sucias
    private int limpia;
    private int sucia;
    private int ocupada;

    //Ingresos de salas ocupadas
    private int ingresos;

    public void ingresos() {
        int ingresos = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (habitacion[i][j].getContador() == 2) {
                    ingresos += habitacion[i][j].getPrecio();
                }
            }

        }
        JOptionPane.showMessageDialog(null, "Los ingresos de las habitaciones ocupadas es de:" + ingresos);

    }

    //Manejo de contador de estado de habitaciones
    public void contadorEstado() {
        llenarHabitaciones();
        //Cotandor 1,Libre 2.Ocupada 3.Sucia
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                //Contador Habitaciones Limpias
                if (habitacion[i][j].getContador() == 1) {
                    this.limpia++;

                }
                //Contador Habitaciones Ocupadas
                if (habitacion[i][j].getContador() == 2) {
                    this.ocupada++;

                }
                if (habitacion[i][j].getContador() == 3) {
                    this.sucia++;

                }

            }

        }
    }

    public void mostrarContador() {
        JOptionPane.showMessageDialog(null, "La cantidad de habitaciones ocupadas es: " + this.ocupada + "\n" + "La cantidad de habitaciones libres es: " + this.limpia + "\n"
                + "La cantidad de habitaciones sucias es: " + this.sucia);

    }

    //Habitaciones que usamos
    public void llenarHabitaciones() {
        habitacion[0][0] = new Habitacion(60, 10, "Libre", "Individual", 1);
        habitacion[1][0] = new Habitacion(90, 21, "Sucia", "Doble", 3);
        habitacion[0][1] = new Habitacion(30, 12, "Ocupado", "Individual", 2);
        habitacion[1][1] = new Habitacion(45, 22, "Ocupado", "Doble", 2);

    }

    public void mostrarReservas() {
        llenarHabitaciones();
        String mensaje = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                mensaje += "El piso " + (i + 1) + "\n" + habitacion[i][j].mostrarHabitacion() + "\n" + "*";
            }
            mensaje += "************************" + "\n";

        }

        JOptionPane.showMessageDialog(null, mensaje);

    }

    public void menu() {
        boolean repetir = true;

        while (repetir) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Hola que desea hacer\n" + "1.Ver reservaciones ya hechas\n" + "2.Ver estado general\n" + "3.Cambiar precio habitacion"));
            switch (opcion) {
                case 1:
                    mostrarReservas();
                    break;
                case 2:
                    mostrarContador();
                    ingresos();
                    break;
                case 3:
                    cambiarPrecio(Integer.parseInt(JOptionPane.showInputDialog("Cual es el nuevo precio")));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
            }
        }
    }

    public void cambiarPrecio(int precio) {
        int habitacion = Integer.parseInt(JOptionPane.showInputDialog("Cual es la habitacion que va a cambiar"));
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (this.habitacion[i][j].getNumeroHabitacion() == habitacion) {
                    this.habitacion[i][j].setPrecio(precio);
                    break;

                } else {
                    JOptionPane.showMessageDialog(null, "El cambio no fue posible");
                }

            }

        }
        mostrarReservas();

    }
}
