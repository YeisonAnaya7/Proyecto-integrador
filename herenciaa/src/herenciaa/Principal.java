
package herenciaa;

import javax.swing.JOptionPane;


public class Principal {

    public static void main(String[] args) {
        String menu = JOptionPane.showInputDialog("menu \n" +
                                               "1. empleado \n"+
                                               "2. cliente \n"+
                                                "3. salir \n");
     
        int opciones  = Integer.parseInt(menu);
       switch (opciones)  {
           case 1:
               String nombreEmp=JOptionPane.showInputDialog("ingrese su nombre");
               String edadEmp= JOptionPane.showInputDialog("ingrese su edad");
               int edad1=Integer.parseInt(edadEmp);
               String salarioEmp = JOptionPane.showInputDialog("ingrese su salario");
               double salario1 = Double.parseDouble(salarioEmp);
        
               Empleado empleado1 = new Empleado(salario1, nombreEmp, edad1);
               empleado1.verEmpleado();
        
               break;
        
           case 2:
               String nombreCli = JOptionPane.showInputDialog("ingrese su nombre");
               String edadCli = JOptionPane.showInputDialog("ingrese su edad");
               int edad2 = Integer.parseInt(edadCli);
               String direccionCli = JOptionPane.showInputDialog("ingrese su direccion");
               
               Cliente cliente1 = new Cliente(direccionCli, nombreCli, edad2);
                cliente1.verCliente();
              break;
              
           case 3:
           
               break;
       }
    }
    
}
