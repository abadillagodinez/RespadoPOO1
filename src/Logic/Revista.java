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
            s="Es revista,\n Impuesto = 1";
        }
        this.impuesto=s;
        return result;
    }
    
     /**
     * toString de la clase
     */
    public String toString(){
        String msg = "\tRevista\n";
        msg += "\tCodigo: " + super.getCodReferencia() + "\n";
        msg += "\tNombre: " + getNombre()+ "\n";
        if(isCatalogo()){
            msg += "\tTipo: Catalogo\n";
        }
        else{
            msg += "\tTipo: Revista\n"; 
        }
        msg += "\tTema: " + getTema()+ "\n";
        if(super.getEstadoEntrega()){
            msg += "\tEstado:"  + " Entregado\n";
            msg += "\tFecha de entrega: "+ this.fechaEntrega +"\n";
            msg += "\tHora de entrega: "+ this.horaEntrega +"\n";
        }
        else{
            msg += "\tEstado:" + " No Entregado\n";
        }
        msg += "\tFecha recepcion: " + super.fechaRecepcion + "\n";
        msg += "\tDescripcion: " + super.getDescripcion() + "\n";
        msg += "\tRemitente: " + remitente.toString() + "\n";
        return msg;
    }
    
    @Override
    public String toList() {
        String msg="";
        msg+="Codigo: "+this.codReferencia;
        msg+=";Revista de: "+this.remitente;
        msg+=" Impuesto: "+String.valueOf(calcularImpuesto());
        return msg;
    }
}
