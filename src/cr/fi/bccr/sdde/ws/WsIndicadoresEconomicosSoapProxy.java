package cr.fi.bccr.sdde.ws;

public class WsIndicadoresEconomicosSoapProxy implements cr.fi.bccr.sdde.ws.WsIndicadoresEconomicosSoap {
  private String _endpoint = null;
  private cr.fi.bccr.sdde.ws.WsIndicadoresEconomicosSoap wsIndicadoresEconomicosSoap = null;
  
  public WsIndicadoresEconomicosSoapProxy() {
    _initWsIndicadoresEconomicosSoapProxy();
  }
  
  public WsIndicadoresEconomicosSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWsIndicadoresEconomicosSoapProxy();
  }
  
  private void _initWsIndicadoresEconomicosSoapProxy() {
    try {
      wsIndicadoresEconomicosSoap = (new cr.fi.bccr.sdde.ws.WsIndicadoresEconomicosLocator()).getwsIndicadoresEconomicosSoap();
      if (wsIndicadoresEconomicosSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wsIndicadoresEconomicosSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wsIndicadoresEconomicosSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wsIndicadoresEconomicosSoap != null)
      ((javax.xml.rpc.Stub)wsIndicadoresEconomicosSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cr.fi.bccr.sdde.ws.WsIndicadoresEconomicosSoap getWsIndicadoresEconomicosSoap() {
    if (wsIndicadoresEconomicosSoap == null)
      _initWsIndicadoresEconomicosSoapProxy();
    return wsIndicadoresEconomicosSoap;
  }
  
  public cr.fi.bccr.sdde.ws.ObtenerIndicadoresEconomicosResponseObtenerIndicadoresEconomicosResult obtenerIndicadoresEconomicos(java.lang.String tcIndicador, java.lang.String tcFechaInicio, java.lang.String tcFechaFinal, java.lang.String tcNombre, java.lang.String tnSubNiveles) throws java.rmi.RemoteException{
    if (wsIndicadoresEconomicosSoap == null)
      _initWsIndicadoresEconomicosSoapProxy();
    return wsIndicadoresEconomicosSoap.obtenerIndicadoresEconomicos(tcIndicador, tcFechaInicio, tcFechaFinal, tcNombre, tnSubNiveles);
  }
  
  public java.lang.String obtenerIndicadoresEconomicosXML(java.lang.String tcIndicador, java.lang.String tcFechaInicio, java.lang.String tcFechaFinal, java.lang.String tcNombre, java.lang.String tnSubNiveles) throws java.rmi.RemoteException{
    if (wsIndicadoresEconomicosSoap == null)
      _initWsIndicadoresEconomicosSoapProxy();
    return wsIndicadoresEconomicosSoap.obtenerIndicadoresEconomicosXML(tcIndicador, tcFechaInicio, tcFechaFinal, tcNombre, tnSubNiveles);
  }
  
  
}