/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Concesionario;


public class Sedan extends Automovil{
private double motor;
private boolean frenos;

    public Sedan(double motor, boolean frenos, String placa, double precio, int modelo) {
        super(placa, precio, modelo);
        this.motor = motor;
        this.frenos = frenos;
    }

    public double getMotor() {
        return motor;
    }

    public boolean isFrenos() {
        return frenos;
    }
   public String frenosABS(){
   if(frenos){
       return"El auto movil tiene fenos ABS";
   }else{
       return"El automovil no tiene frenos ABS";
   }
   }
}
