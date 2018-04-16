/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author retr0
 */
public class Revista extends Entregable {
    private String nombre;
    private boolean catalogo;
    private String tema;

    public Revista(String nombre, boolean catalogo, String tema, String codReferencia,
            boolean estadoEntrega, String descripcion, String remitente) {
        super(codReferencia, estadoEntrega, descripcion, remitente);
        setNombre(nombre);
        setCatalogo(catalogo);
        setTema(tema);
    }
   
    /**
     * 
     * @return el nombre de la revista
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * setter del nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return si es un catalogo o no
     */
    public boolean isCatalogo() {
        return catalogo;
    }

    /**
     * setter de el estado de catalogo
     * @param catalogo 
     */
    public void setCatalogo(boolean catalogo) {
        this.catalogo = catalogo;
    }

    /**
     * 
     * @return el tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * setter del tema
     * @param tema 
     */
    public void setTema(String tema) {
        this.tema = tema;
    }
    
    /**
     * metodo abstracto aplicado
     * @return 
     */
     @Override
    public double calcularImpuesto(){
        double result = 0;
        String s="Es catalogo no paga impuestos";
        if(!isCatalogo()){
            result = 1;
            s="Es revista, Impuesto = 1";
        }
        this.impuesto=s;
        return result;
    }
    
     /**
     * toString de la clase
     */
    public String toString(){
        String msg = "";
        msg += "Codigo: " + super.getCodReferencia() + "\n";
        msg += "Nombre: " + getNombre()+ "\n";
        if(isCatalogo()){
            msg += "Tipo: Catalogo\n";
        }
        else{
            msg += "Tipo: Revista\n"; 
        }
        msg += "Tema: " + getTema()+ "\n";
        if(super.getEstadoEntrega()){
            msg += "Estado:"  + " Entregado\n";
            msg += "Fecha de entrega: "+ this.fechaEntrega +"\n";
            msg += "Hora de entrega: "+ this.horaEntrega +"\n";
        }
        else{
            msg += "Estado:" + " No Entregado\n";
        }
        msg += "Descripcion: " + super.getDescripcion() + "\n";
        msg += "Remitente: " + "\n" + "\t" + remitente.toString() + "\n";
        return msg;
    }
}
