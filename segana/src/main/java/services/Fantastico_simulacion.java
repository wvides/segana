/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Omar
 */
@WebService(serviceName = "Fantastico_simulacion")
public class Fantastico_simulacion {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getdeportes")
    public String getdeportes(@WebParam(name = "deportes") String deportes) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "gettorneos")
    public String gettorneos(@WebParam(name = "torneos") String torneos) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getequipos")
    public String getequipos(@WebParam(name = "equipos") String equipos) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getediciones")
    public String getediciones(@WebParam(name = "ediciones") String ediciones) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getencuentros")
    public String getencuentros(@WebParam(name = "encuentros") String encuentros) {
        //TODO write your implementation code here:
        return null;
    }
}
