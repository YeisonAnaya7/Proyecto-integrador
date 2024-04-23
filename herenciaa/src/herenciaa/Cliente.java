
package herenciaa;

import javax.swing.JOptionPane;


public class Cliente extends Persona{
    private String direccion;

    public Cliente(String direccion, String nombre, int edad) {
        super(nombre, edad);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }
    public void verCliente (){
    JOptionPane.showMessageDialog(null, "el nombre es "+getNombre()+
                                        "\nla edad es "+getEdad()+
                                        "\nla direccion es "+ getDireccion() );

    
    }
}