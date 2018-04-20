/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;


import java.util.*;
import javax.mail.Message; 
import javax.mail.MessagingException; 
import javax.mail.Session; 
import javax.mail.Transport; 
import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeMessage; 


import cr.fi.bccr.sdde.ws.*;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.axis.AxisFault;

/**
 *
 * @author retr0
 */
public class Counter implements WSBCCR{
    ArrayList<Cliente> clientes;
    ArrayList<Casillero> casilleros;
    int cantidadCasilleros;
    static int cantidadEntregables = 0;
    ArrayList<ArrayList<String>> Reporte=new ArrayList<>();

    public Counter(int cantidadCasilleros) {
        setCantidadCasilleros(cantidadCasilleros);
        casilleros = new ArrayList<>(this.cantidadCasilleros);
        for(int i = 1; i <= this.cantidadCasilleros; i++){
            Casillero nuevo = new Casillero(Integer.toString(i));
            casilleros.add(nuevo);
        }
        clientes = new ArrayList<>(cantidadCasilleros);
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
   
    public int getCantidadEntregables(){
        int i = cantidadEntregables;
        return i;
    }
    public Casillero getCasilleroLibre(){
        Casillero definitivo = null;
        for(int i = 0; i < casilleros.size(); i++){
            Casillero actual = casilleros.get(i);
            if(actual.isLibre()){
                definitivo = actual;
                break;
            }
        }
        return definitivo;
    }
            
    public Cliente registrarCliente(String nombre, String correo, String telefono, String direccion, String sexo, String fechaNacimiento){
        Cliente aRetornar = null;
        if(clientes.size() < cantidadCasilleros){
            Casillero primeroLibre = getCasilleroLibre();
            Cliente nuevo = new Cliente(nombre, correo, telefono, direccion, sexo, fechaNacimiento, primeroLibre);
            clientes.add(nuevo);
            aRetornar = nuevo;
        }
        else{
            System.out.println("No quedan casilleros disponibles");
        }
        return aRetornar;
    }
    
    public void eliminarCliente(String idCliente){
        for(int i=0; clientes.size()>i;i++){
            if(clientes.get(i).getIdCliente().equals(idCliente)){
                clientes.remove(i);
                System.out.println("Cliente eliminado");
            }
        }
    }
    
    public void consultarCliente(String idCliente){
        Cliente cliente=selecionarCliente(idCliente);
        if("0".equals(cliente.getIdCliente())){
            System.out.println("Cliente no encontrado");
        }else{
            System.out.println(cliente.toString());
        }
    }
    
    public void consultarClientes(){
        for(int i=0;clientes.size()>i;i++){
            System.out.println(clientes.get(i).toString());
        }
    }
    
    public Cliente selecionarCliente(String idCliente ){
        boolean encontrado=false;
        Cliente cliente=new Cliente();
        for(int i=0;clientes.size()>i;i++){
            if(clientes.get(i).getIdCliente().equals(idCliente)){
                encontrado=true;
                cliente= clientes.get(i);
                break;
            }
        }
        if(!encontrado){
            cliente=clientes.get(0);
        }
        return cliente;
    }
    
    public void enviarCorreo(Cliente cliente, String mensaje){ 
        String remitente = "adriangazubg7@gmail.com"; 
        String clave = "OLYOLYOXENFREE"; 
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", "miClaveDeGMail");    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

    try {
        message.setFrom(new InternetAddress(remitente));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(cliente.getCorreo()));   //Se podrían añadir varios de la misma manera
        message.setSubject("Notificacion de Aero Pancake, siempre en la arepa voladora");
        message.setText(mensaje);
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", remitente, clave);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
    catch (MessagingException me) {
        me.printStackTrace();   //Si se produce un error
    }
    }
    
    public void recibirArticulo(Entregable entregable, String idCliente){
        //String idCliente=entregable.destinatario.getIdCliente();
        Cliente cliente=selecionarCliente(idCliente);
        if(cliente.getIdCliente().equals("0")){
            System.out.println("El cliente no existe");
        }else{
            ++cantidadEntregables;
            cliente.getCasillero().agregarEntregable(entregable);
            String mensaje = "Estimado cliente se le notifica que ha sido registrado un nuevo entregable\nen el casillero " + cliente.getCasillero().getIdCasillero() 
                    + " el cual se le recuerda esta disponible para su retiro"; 
            enviarCorreo(cliente, mensaje);
        }
    }
    
    public void entregarArticulo(String idArticulo, String IDcliente){
        Cliente cliente=selecionarCliente(IDcliente);
        if(cliente.getIdCliente().equals("0")){
            System.out.println("Cliente no encontrado");
        }else{
            cliente.getCasillero().entregarEntregable(IDcliente);
        }
    }
    
    public String consultarCasillero(String idCasillero){
        String res = "";
        boolean encontrado=false;
        for(Casillero casillero:casilleros){
            if(idCasillero.equals(casillero.getIdCasillero())){
                res = casillero.toString();
                encontrado=true;
                break;
            }
        }
        return res;
    }
    
    public String consultarCasilleroCliente(String idCliente){
        Cliente cliente=selecionarCliente(idCliente);
        String res = "";
        Casillero casillero = cliente.getCasillero();
        res += casillero.toString();
        
        return res;
    }
    
    public ArrayList<String> consultEntregableFechaRecepcion(String fecha){
        ArrayList<String> entregables=new ArrayList<>();
        for(Casillero casillero:casilleros){
            for(Entregable entregable:casillero.getEntregables()){
                if(entregable.fechaRecepcion.equals(fecha)){
                    entregables.add(entregable.toString());
                }
            }
        }
        if(entregables.isEmpty()){
            entregables.add("No se encontro ningun entregable con la fecha:"+fecha);
        }
        return entregables;
    }
    
    public ArrayList<String> consultEntregableFechaEntrega(String fecha){
        ArrayList<String> entregables=new ArrayList<>();
        for(Casillero casillero:casilleros){
            for(Entregable entregable:casillero.getEntregables()){
                if(entregable.fechaEntrega.equals(fecha)){
                    entregables.add(entregable.toString());
                }
            }
        }
        if(entregables.isEmpty()){
            entregables.add("No se encontro ningun entregable con la fecha:"+fecha);
        }
        return entregables;
    }
    
    public ArrayList<String> consultPaquetesSinEntregar(){
        ArrayList<String> entregables=new ArrayList<>();
        for(Casillero casillero:casilleros){
            for(Entregable entregable:casillero.getEntregables()){
                if(!entregable.estadoEntrega){
                   entregables.add(entregable.toString());
                }
            }
        }
        if(entregables.isEmpty()){
            entregables.add("Todos los paquetes se han entregado");
        }
        return entregables;
    }
    
    public ArrayList<String> consultClientesPaquetesPendientes(){
        ArrayList<String> clients=new ArrayList<>();
        int i;
        boolean tienePendientes=false;
        for(Casillero casillero:casilleros){
            i=0;
            for(Entregable entregable:casillero.getEntregables()){
                if(!entregable.estadoEntrega){
                    tienePendientes=true;
                    i++;
                }
            }
            if(tienePendientes){
                clients.add(casillero.getCliente().toString()+ " Tiene: "+
                        String.valueOf(i)+" paquetes pendientes");
            }
            tienePendientes=false;
        }
        return clients;
    }
    
    public void correoTodosPendientes(ArrayList<Cliente> clientus){
        //clientus.forEach(this::enviarCorreo);
    }
    
    public ArrayList<String> informeContable(String fecha){
        ArrayList<String> informe=new ArrayList<>();
        String descontado;
        String impuesto;
        double descontado2;
        double impuesto2;
        String informe2;
        for(Casillero casillero:casilleros){
            informe2="";
            descontado="";
            impuesto="";
            descontado2=0;
            impuesto2=0;
            for(Entregable entregable:casillero.getEntregables()){
                if(entregable.getFechaEntrega().equals(fecha)){
                    impuesto2+=entregable.calcularImpuesto();
                }
            }
            if(casillero.getCliente().getTipo()==Tipo.PLATA){
                descontado2=0.1;
            }else if(casillero.getCliente().getTipo()==Tipo.ORO){
                descontado2=0.2;
            }
            descontado2*=impuesto2;
            descontado=String.valueOf(descontado2);
            impuesto=String.valueOf(impuesto2);
            informe2="Impuesto Cobrado: "+String.valueOf(impuesto2-descontado2)+" \n Descuento Aplicado: "+
                    descontado+" \n Impuesto Total: "+impuesto;
            informe.add(informe2);
        }
        return informe;
    }

    @Override
    public double obtenerCompraDelTipoDeCambio(String fecha) {
        double res = 0;
        WsIndicadoresEconomicosSoapProxy obtener =
                new WsIndicadoresEconomicosSoapProxy("http://indicadoreseconomicos.bccr.fi.cr/indicadoreseconomicos/WebServices/wsIndicadoresEconomicos.asmx");
        try {
            String numero = parsearXML(obtener.obtenerIndicadoresEconomicosXML("317", fecha, fecha, "IC2101", "N"));
            res = Double.parseDouble(numero);
        } catch (RemoteException ex) {
            Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public double obtenerVentaDelTipoDeCambio(String fecha) {
        double res = 0;
        WsIndicadoresEconomicosSoapProxy obtener =
                new WsIndicadoresEconomicosSoapProxy("http://indicadoreseconomicos.bccr.fi.cr/indicadoreseconomicos/WebServices/wsIndicadoresEconomicos.asmx");
        try {
            String numero = parsearXML(obtener.obtenerIndicadoresEconomicosXML("318", fecha, fecha, "IC2101", "N"));
            res = Double.parseDouble(numero);
        } catch (RemoteException ex) {
            Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }   
    
    private String parsearXML(String xml){
        String res = "";
        int linea = 0;
        for (int i = 0; i < xml.length(); i++){
            if(linea == 4){
                for(int j = i; xml.charAt(j) != '\n' ;j++){
                    if(xml.charAt(j) == '>'){
                        for(int k = j+1; xml.charAt(k) != '<' ;k++){
                            res += xml.charAt(k);
                        }
                    }
                }
            break;
            }
            else if(xml.charAt(i) == '\n'){
                linea++;
            }
        }
        return res;
    }
}
