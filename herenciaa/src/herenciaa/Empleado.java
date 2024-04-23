
package herenciaa;

import javax.swing.JOptionPane;


public class Empleado extends Persona{
    private double salario;

    public Empleado(double salario, String nombre, int edad) {
        super(nombre, edad);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }
    
    public void verEmpleado (){
        JOptionPane.showMessageDialog(null,"El nombre es: "+getNombre()+
                                   "\nLa edad es: "+getEdad()+
                                   "\nEl salario es: "+getSalario()); 
    }
    
   
}
