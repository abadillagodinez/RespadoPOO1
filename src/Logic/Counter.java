/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author retr0
 */
public class Counter {
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    ArrayList<Casillero> casilleros;
    int cantidadCasilleros;

    public Counter(int cantidadCasilleros) {
        setCantidadCasilleros(cantidadCasilleros);
        casilleros = new ArrayList<Casillero>(cantidadCasilleros);
    }

    /**
     * 
     * @return la lista de clientes
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * setter de la lista de clientes
     * @param clientes 
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * 
     * @return la lista de casilleros
     */
    public ArrayList<Casillero> getCasilleros() {
        return casilleros;
    }

    /**
     * setter de la lista de casilleros
     * @param casilleros 
     */
    public void setCasilleros(ArrayList<Casillero> casilleros) {
        this.casilleros = casilleros;
    }

    /**
     * 
     * @return la cantidad de casilleros
     */
    public int getCantidadCasilleros() {
        return cantidadCasilleros;
    }

    /**
     * setter de la cantidad de casilleros
     * @param cantidadCasilleros 
     */
    public void setCantidadCasilleros(int cantidadCasilleros) {
        this.cantidadCasilleros = cantidadCasilleros;
    }
    
    public void registrarCliente(String nombre, String correo, int telefono, String direccion, String sexo, String fechaNacimiento, Tipo tipo){
        if(clientes.size() < cantidadCasilleros){
            Cliente nuevo = new Cliente(nombre, correo, telefono, direccion, sexo, fechaNacimiento, tipo);
            clientes.add(nuevo);
        }
        else{
            System.out.println("No se puede registrar el cliente");
        }
    }
    
    /*
    public void modificarCliente(int pos, ){
        for(int i = 0; i < clientes.size(); i++){
            if (i == pos){
                
            }
        }
    }*/
    
     public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
    // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
        String remitente = "adriangazubg7@gmail.com";  //Para la dirección nomcuenta@gmail.com
        String clave = "OLYOLYOXENFREE";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Se envió exitosamente\n");
        }
        catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
    }
    
    
}
