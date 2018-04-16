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
    public static void main(String[] args) {/*
        Cliente nuevo = new Cliente("Luis Adrian Badilla Godinez", "adriangazubg7@gmail.com", 
        85104033, "Residencias del TEC", "Masculino", "7/9/99", Tipo.NORMAL);
        Entregable sobrecito = new Sobre("Manila", "Documentacion", 25, 2, false, "Sobre para don fernando", nuevo);
        Entregable revistica = new Revista("Sabores", true, "Cocina", 1, true, "Revista de cocina de la\n familia Cortez", nuevo);
        System.out.println(sobrecito.toString());
        System.out.println(revistica.toString());
        System.out.println(sobrecito.calcularImpuesto());*/
        Counter count = new Counter(24);
        String destinatario = "azofeifacris4@gmail.com";
        String asunto = "Holi yiyo";
        String cuerpo = "Puedo mandar un correo desde java";
        //count.enviarConGMail(destinatario, asunto, cuerpo);
        new MenuInicio().setVisible(true);
    }
    
}

