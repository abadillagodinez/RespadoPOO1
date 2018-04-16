/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author retr0
 */
public abstract class Entregable {
    protected String codReferencia;
    protected boolean estadoEntrega;
    protected String descripcion;
    protected String remitente;
    protected Cliente destinatario;
    protected String fechaRecepcion;
    protected String fechaEntrega;
    protected String horaEntrega;
    protected String impuesto;
    
    /**
     * constructor de la clase padre entregable
     * @param codReferencia
     * @param estadoEntrega
     * @param descripcion 
     * @param remitente 
     */
    
    public Entregable(String codReferencia, boolean estadoEntrega, String descripcion, String remitente) {
        setCodReferencia(codReferencia);
        setEstadoEntrega(estadoEntrega);
        setDescripcion(descripcion);
        setRemitente(remitente);
        Calendar fecha=Calendar.getInstance();
        Date date=fecha.getTime();
        String d=date.toString();
        String[] d2=d.split(" ");
        this.fechaRecepcion=d2[2]+"/"+d2[1]+"/"+d2[d2.length-1];
    }
    
    /**
     * 
     * @return codigo de referencia del objeto
     */
    public String getCodReferencia() {
        return codReferencia;
    }

    /**
     * setter del codigo de referencia
     * @param codReferencia 
     */
    public void setCodReferencia(String codReferencia) {
        this.codReferencia = codReferencia;
    }

    
    /**
     * 
     * @return el estado de entrega
     */
    public boolean getEstadoEntrega() {
        return estadoEntrega;
    }

    /**
     * setter del estado de entrega
     * @param estadoEntrega 
     */
    public void setEstadoEntrega(boolean estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    /**
     * 
     * @return la descripcion del entregable
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * setter del la descripcion
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    } 

    /**
     * 
     * @return el remitente del entregable
     */
    public String getRemitente() {
        return remitente;
    }

    /**
     * setter del remite
     * @param remitente 
     */
    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public Cliente getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Cliente destinatario) {
        this.destinatario = destinatario;
    }

    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public boolean isEstadoEntrega() {
        return estadoEntrega;
    }
    
    
    public void entregar(){
        this.estadoEntrega=true;
        Calendar fecha=Calendar.getInstance();
        Date date=fecha.getTime();
        String dato=date.toString();
        String[] moreDate=dato.split(" ");
        String dia=moreDate[2];
        String mes=identificarMes(moreDate[1]);
        String anio=moreDate[moreDate.length-1];
        String hora=moreDate[3];
        this.fechaEntrega=dia+"/"+mes+"/"+anio;
        this.horaEntrega=hora;
    }
    
    public String identificarMes(String s){
        int i=0;
        if(null != s.toLowerCase())switch (s.toLowerCase()) {
            case "jan":
                i= 1;
                break;
            case "feb":
                i= 2;
                break;
            case "mar":
                i= 3;
                break;
            case "apr":
                i= 4;
                break;
            case "may":
                i= 5;
                break;
            case "jun":
                i= 6;
                break;
            case "jul":
                i= 7;
                break;
            case "ago":
                i= 8;
                break;
            case "sep":
                i= 9;
                break;
            case "oct":
                i= 10;
                break;
            case "nov":
                i= 11;
                break;
            case "dec":
                i= 12;
                break;
            default:
                break;
        }
        return String.valueOf(i);
    }
    /**
     *metodo abstracto de calculo de impuesto en los hijos
     * @return 
     */
    public abstract double calcularImpuesto();
    

}
