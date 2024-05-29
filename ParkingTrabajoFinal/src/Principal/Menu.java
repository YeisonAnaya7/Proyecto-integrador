package Principal;

import javax.swing.JOptionPane;

public class Menu {

    private Parking parking;
    private int cantidadPlazas;

    public void DefinirCantidadPlazas() {
        do {
            String cantidadPlazasStr = JOptionPane.showInputDialog(null, "Ingrese la cantidad de plazas del parking",
                    "Configuración", JOptionPane.INFORMATION_MESSAGE);

            this.cantidadPlazas = Integer.parseInt(cantidadPlazasStr);

            if (cantidadPlazas <= 0) {
                JOptionPane.showMessageDialog(null, "Cantidad de plazas no válida. Debe ser mayor a cero", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                this.parking = new Parking("Parking Lot ", cantidadPlazas);
            }

        } while (cantidadPlazas <= 0);
    }

    public void iniciar() {
        while (true) {
            String menu = "***************" + parking.getNombre() + "***************\n" +
                    "*Lugares totales: " + parking.getLugaresTotales() + "\n" +
                    "*Lugares ocupados: " + parking.getLugaresOcupados() + "\n" +
                    "*Lugares libres: " + parking.getLugaresLibres() + "\n" +
                    "--------------------------------------------\n" +
                    "***********Menú:********** \n" +
                    "1. Entrada del carro\n" +
                    "2. Salida del carro\n" +
                    "3. Mostrar estado del parking\n" +
                    "4. Salir del programa\n";

            String input = JOptionPane.showInputDialog(null, menu, "Menú", JOptionPane.INFORMATION_MESSAGE);

            if (input.equals(null)) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                break;
            }

            int opcion;

            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                if (input.isEmpty()) { continue;
                }
                JOptionPane.showMessageDialog(null, "Opción no válida. Introduzca un número entre 1 y 4.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (opcion) {
                case 1:
                    this.opcion1();
                    break;

                case 2:
                    this.opcion2();
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, parking, "Información", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "Saliste del programa. Regresa pronto", "Información",
                            JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Introduzca un número entre 1 y 4.");
            }
        }
    }

    private void opcion1() {
        String matriculaEntrada = JOptionPane.showInputDialog("Introduzca la matrícula del carro:");
        if (matriculaEntrada.equals("")) {
            JOptionPane.showMessageDialog(null, "Matrícula incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        }

        String plazaEntradaStr = JOptionPane.showInputDialog("Introduzca la plaza (1 - " + this.cantidadPlazas + "):");
        int plazaEntrada;
        try {
            plazaEntrada = Integer.parseInt(plazaEntradaStr) - 1;

            if (plazaEntrada < 0) {
                JOptionPane.showMessageDialog(null, "Plaza no válida", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                parking.entrada(matriculaEntrada, plazaEntrada);
                JOptionPane.showMessageDialog(null, "El carro se aparco correctamente");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Plaza no válida", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParkingException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + " - Matrícula: " + e.getMatricula(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void opcion2() {
        String matriculaSalida = JOptionPane
                .showInputDialog("Introduzca la matrícula del carro que saldrá: ");
        try {
            parking.salida(matriculaSalida);
        } catch (ParkingException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage() + " - Matrícula: " + e.getMatricula(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

