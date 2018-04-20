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

/**
 *
 * @author retr0
 */
public class Counter implements WSBCCR{
    ArrayList<Cliente> clientes;
    ArrayList<Casillero> casilleros;
    int cantidadCasilleros;
    static int cantidadEntregables = 0;
    //ArrayList<ArrayList<String>> Reporte=new ArrayList<>();

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
    
    /**
     * metodo que retorna el primer casillero que este libre en la lista de casilleros
     * @return 
     */
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
            
    /**
     * registra un cliente y lo retorna para asignarle ese cliente a un casillero
     * @param nombre
     * @param correo
     * @param telefono
     * @param direccion
     * @param sexo
     * @param fechaNacimiento
     * @return dicho cliente
     */
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
    
    /**
     * elimina un cliente segun su id 
     * @param idCliente 
     */
    public void eliminarCliente(String idCliente){
        for(int i=0; clientes.size()>i;i++){
            if(clientes.get(i).getIdCliente().equals(idCliente)){
                clientes.remove(i);
                System.out.println("Cliente eliminado");
            }
        }
    }
    
    /**
     * consulta un cliente segun un string
     * @param idCliente 
     */
    public void consultarCliente(String idCliente){
        Cliente cliente=selecionarCliente(idCliente);
        if("0".equals(cliente.getIdCliente())){
            System.out.println("Cliente no encontrado");
        }else{
            System.out.println(cliente.toString());
        }
    }
    
    /**
     * consulta todos clientes
     */
    public void consultarClientes(){
        for(int i=0;clientes.size()>i;i++){
            System.out.println(clientes.get(i).toString());
        }
    }
    
    /**
     * retorna al cliente segun el id
     * @param idCliente
     * @return 
     */
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
    
    /**
     * envia un correo segun un cliente y un mensaje
     * @param cliente
     * @param mensaje 
     */
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
        message.setSubject("Notificacion de Aero Pancake, siempre en la arepa voladora. ");
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
    
    /**
     * marca un articulo como recibido
     * @param entregable
     * @param idCliente 
     */
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
    
    /**
     * entrega un articulo
     * @param idArticulo
     * @param IDcliente 
     */
    public void entregarArticulo(String idArticulo, String IDcliente){
        Cliente cliente=selecionarCliente(IDcliente);
        if(cliente.getIdCliente().equals("0")){
            System.out.println("Cliente no encontrado");
        }else{
            cliente.getCasillero().entregarEntregable(IDcliente);
        }
    }
    
    /**
     * consulta un casillero segun su id
     * @param idCasillero
     * @return 
     */
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
    
    /**
     * consulta un casillero de un cliente segun el id de este cliente
     * @param idCliente
     * @return el tostring de casillero
     */
    public String consultarCasilleroCliente(String idCliente){
        Cliente cliente=selecionarCliente(idCliente);
        String res = "";
        Casillero casillero = cliente.getCasillero();
        res += casillero.toString();
        
        return res;
    }
    
    /**
     * retorna los entregables de una fecha de recepcion
     * @param fecha
     * @return 
     */
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
    
    /**
     * retorna los entregables de una fecha de entrega
     * @param fecha
     * @return 
     */
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
    
    /**
     * consulta los paquetes sin entregables
     * @return Arraylist de los entregables
     */
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
    
    /**
     * regresa el arryalist de los clientes con paquetes pendientes
     * @return 
     */
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
    
    /**
     * realiza el informe contable segun una fecha dada
     * @param fecha
     * @return 
     */
    public ArrayList<String> informeContable(String fecha){
        ArrayList<String> informe=new ArrayList<>();
        String descontado;
        String impuesto;
        double descontado2;
        double impuesto2;
        String informe2;
        for(Casillero casillero:casilleros){
            if(casillero.getCliente()!=null){
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
        }
        //System.out.println("No se despichó tere");
        return informe;
    }

    /**
     * metodo de la interface WSBCCR
     * @param fecha
     * @return el tipo de cambio de compra de esa fecha
     */
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

    /**
     * metodo de la interface WSBCCR
     * @param fecha
     * @return el tipo de cambio de venta de esa fecha
     */
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
    
    /**
     * parsea el string del xml para obtener un string del valor
     * @param xml
     * @return 
     */
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
