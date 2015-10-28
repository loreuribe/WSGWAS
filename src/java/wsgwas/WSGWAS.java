/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsgwas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.json.JSONArray;
import snpBasicStatcPedFiles.PruebaLeerArchivo;
//import snpBasicStatc.SNP;
//import snpBasicStatcPedFiles.ProcesarEstructuraPed;

/**
 *
 * @author Loena
 */
@WebService(serviceName = "WSGWAS")
public class WSGWAS {
    //SNP snpbasico;

    /**
     * This is a sample web service operation
     */
    
    public WSGWAS()
    {
        //snpbasico = new SNP();
    }

    @WebMethod(operationName = "procesarArchivoPedWS")
    public String procesarArchivoPedWS(@WebParam(name = "archivo") String archivo){
        
        DateFormat timeFormat = new SimpleDateFormat( "HH:mm:ss" );
        
        System.out.println( "\n" + timeFormat.format( Calendar.getInstance().getTime() ) + " *************Archivo Cargado en el servidor: \n"  + archivo + " *************\n" );
        long inicio = System.currentTimeMillis();
        
        PruebaLeerArchivo pruebaLeerArchivo = new PruebaLeerArchivo();
        JSONArray snpJsonArray = pruebaLeerArchivo.procesar( archivo );
        System.out.println("RESULTADO: " + snpJsonArray);
        
        long fin = System.currentTimeMillis();
        System.out.println( timeFormat.format( Calendar.getInstance().getTime() ) + "\tTiempo Total ejecucion servidor: " + (fin - inicio) );        
        
        return snpJsonArray.toString();
    }
    
}
