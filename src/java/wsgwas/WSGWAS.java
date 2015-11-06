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
    public String procesarArchivoPedWS(@WebParam(name = "archivo") String archivo) throws Exception{
        
        DateFormat timeFormat = new SimpleDateFormat( "HH:mm:ss" );
        
        System.out.println( "\n" + timeFormat.format( Calendar.getInstance().getTime() ) + " *************Archivo Cargado en el servidor: "  + archivo + " *************\n" );
        long inicio = System.currentTimeMillis();        
        
        PruebaLeerArchivo pruebaLeerArchivo = new PruebaLeerArchivo();
        String rutaSnpJsonArray = pruebaLeerArchivo.procesar( archivo );
        return rutaSnpJsonArray;
        /*
        JSONArray snpJsonArray = pruebaLeerArchivo.procesar( archivo );
        
        System.out.println( "Tamaño snpJsonArray: " + snpJsonArray.length() );
        try{
            System.out.println( "Resultado Primer SNP: " + snpJsonArray.getJSONObject(0).toString() );
            System.out.println( "Resultado Primer SNP: " + snpJsonArray.getJSONObject( snpJsonArray.length() - 1 ).toString() );
        }
        catch ( JSONException error ){
            error.printStackTrace();
            throw new Exception( error.getMessage() );
        }
        long fin = System.currentTimeMillis();
        System.out.println( timeFormat.format( Calendar.getInstance().getTime() ) + " *************Tiempo Total ejecucion servidor: " + ((fin - inicio)/1000.0) + " Segs************* \n\n" );        

        return snpJsonArray.toString();  
        */
    }
    
}
