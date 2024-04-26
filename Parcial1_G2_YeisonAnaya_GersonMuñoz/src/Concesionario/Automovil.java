
package Concesionario;

public class Automovil {
private String placa;
private double precio;
private int modelo;

    public Automovil(String placa, double precio, int modelo) {
        this.placa = placa;
        this.precio = precio;
        this.modelo = modelo;
        
    }

    public String getPlaca() {
        return placa;
    }

    public double getPrecio() {
        return precio;
    }

    public int getModelo() {
        return modelo;
    }

}
