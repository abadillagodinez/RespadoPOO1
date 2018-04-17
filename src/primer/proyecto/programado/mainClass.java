/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primer.proyecto.programado;
import Interfaz.MenuInicio;
import Logic.*;

/**
 *
 * @author retr0
 */
public class mainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Casillero nuevoCasi = new Casillero("1");
        //Cliente nuevo = new Cliente("Adrian Badilla", "adriangazubg7@gmail.com", "85194033", "asdfas", "Masculino", "1999/09/07", nuevoCasi);
        /*Entregable sobrecito = new Sobre("Manila", "Documentacion", 25, 2, false, "Sobre para don fernando", nuevo);
        Entregable revistica = new Revista("Sabores", true, "Cocina", 1, true, "Revista de cocina de la\n familia Cortez", nuevo);
        System.out.println(sobrecito.toString());
        System.out.println(revistica.toString());
        System.out.println(sobrecito.calcularImpuesto());*/
        //Counter count = new Counter(24);
        //String cuerpo = "Puedo mandar un correo desde java";
        //count.enviarCorreo(nuevo, cuerpo);
        new MenuInicio().setVisible(true);
    }
    
}

