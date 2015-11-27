/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsgwas;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.json.JSONArray;
import org.json.JSONException;
import snpBasicStatc.SNP;
import snpBasicStatcPedFiles.PruebaLeerArchivo;
//import snpBasicStatc.SNP;
//import snpBasicStatcPedFiles.ProcesarEstructuraPed;

/**
 *
 * @author Loena
 */
@WebService(serviceName = "WSGWAS")
public class WSGWAS {
    SNP snpbasico;

    /**
     * This is a sample web service operation
     */
    
    public WSGWAS()
    {
        snpbasico = new SNP();
    }
    

    @WebMethod(operationName = "procesarArchivoPedWS")
    public String procesarArchivoPedWS(@WebParam(name = "archivo") String archivo) throws Exception{
        
        DateFormat timeFormat = new SimpleDateFormat( "HH:mm:ss" );
        
        System.out.println( "\n" + timeFormat.format( Calendar.getInstance().getTime() ) + " *************Archivo Cargado en el servidor: "  + archivo + " *************\n" );
        long inicio = System.currentTimeMillis();        
        
        PruebaLeerArchivo pruebaLeerArchivo = new PruebaLeerArchivo();
        String rutaSnpJsonArray = pruebaLeerArchivo.procesar( archivo );      
        long fin = System.currentTimeMillis();
        System.out.println( "Ruta Salida: " + new File(rutaSnpJsonArray).getAbsolutePath() );
        System.out.println( timeFormat.format( Calendar.getInstance().getTime() ) + " *************Tiempo Total ejecucion servidor: " + ((fin - inicio)/1000.0) + " Segs************* \n\n" );        
        return rutaSnpJsonArray;
    }
    
    @WebMethod(operationName = "oddRatios")
    public double oddRatios(@WebParam(name = "dato1") int dato1, 
            @WebParam(name = "dato2") int dato2, 
            @WebParam(name = "dato3") int dato3, 
            @WebParam(name = "dato4") int dato4) {
        return snpbasico.oddRatio(dato1,dato2,dato3,dato4);
    }
   
    @WebMethod(operationName = "allelicFrecuenciasCountAllel_A")
    public double allelicFrecuenciasCountAllel_A(@WebParam(name = "genAA") int genAA, @WebParam(name = "GenAa") int GenAa){
        return 2*genAA+GenAa;
    }
    
    @WebMethod(operationName = "allelicFrecuenciasCountAllel_a")
    public double allelicFrecuenciasCountAllel_a(@WebParam(name = "genaa") int genaa, @WebParam(name = "GenAa") int GenAa){
        return 2*genaa+GenAa;
    }
    
    @WebMethod(operationName = "calculoError")
    public double calculoError(double x, double y, double z, double w){
        double respuesta= (double)(1/x + 1/y + 1/z + 1/w);       
        return Math.sqrt(respuesta);
    }
    
}
