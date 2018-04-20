/**
 * WsIndicadoresEconomicosSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cr.fi.bccr.sdde.ws;

public interface WsIndicadoresEconomicosSoap extends java.rmi.Remote {

    /**
     * Obtiene los valores del indicador económico deseado (DataSet)
     * para un rango de fecha determinado con formato dd/mm/yyyy (día/mes/año).
     * Parámetros de entrada: Código del indicador, Fecha de inicio de tipo
     * string , Fecha final de tipo string, Nombre de la persona que utiliza
     * el servicio y el indicador (S = Si o N = No) para indicar si desea
     * o no obtener los subniveles del indicador a consultar. Retorna un
     * DataSet con los siguientes campos: Código de la variable tipo string,
     * fecha tipo date y el valor tipo numéric. TODOS los campos son obligatorios,
     * de no integresar algunos de los parámetros el valor de retorno del
     * servicio será Nothing.
     */
    public cr.fi.bccr.sdde.ws.ObtenerIndicadoresEconomicosResponseObtenerIndicadoresEconomicosResult obtenerIndicadoresEconomicos(java.lang.String tcIndicador, java.lang.String tcFechaInicio, java.lang.String tcFechaFinal, java.lang.String tcNombre, java.lang.String tnSubNiveles) throws java.rmi.RemoteException;

    /**
     * Obtiene los valores del indicador económico (XML) deseado para
     * un rango de fecha determinado con formato dd/mm/yyyy (día/mes/año).
     * Parámetros de entrada: Código del indicador, Fecha de inicio de tipo
     * string , Fecha final de tipo string, Nombre de la persona que utiliza
     * el servicio y el indicador (S = Si o N = No) para indicar si desea
     * o no obtener los subniveles del indicador a consultar. Retorna un
     * DataSet con los siguientes campos: Código de la variable tipo string,
     * fecha tipo date y el valor tipo numéric. TODOS los campos son obligatorios,
     * de no integresar algunos de los parámetros el valor de retorno del
     * servicio será Nothing.
     */
    public java.lang.String obtenerIndicadoresEconomicosXML(java.lang.String tcIndicador, java.lang.String tcFechaInicio, java.lang.String tcFechaFinal, java.lang.String tcNombre, java.lang.String tnSubNiveles) throws java.rmi.RemoteException;
}
