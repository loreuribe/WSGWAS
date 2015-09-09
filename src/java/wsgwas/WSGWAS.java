/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsgwas;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import snpBasicStatc.SNP;
import snpBasicStatcPedFiles.ProcesarEstructuraPed;

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

    /*
    @WebMethod(operationName = "ooddRatios")
    public double oddRatios(@WebParam(name = "dato1") int dato1, @WebParam(name = "dato2") int dato2, @WebParam(name = "dato3") int dato3, @WebParam(name = "dato4") int dato4) {
        return snpbasico.oddRatio(dato1,dato2,dato3,dato4);
    }
    
    public double allelicFrecuenciasCountAllel_A(@WebParam(name = "genAA") int genAA, @WebParam(name = "GenAa") int GenAa) 
    {
        return 2*genAA+GenAa;
    }
    public double allelicFrecuenciasCountAllel_a(@WebParam(name = "genaa") int genaa, @WebParam(name = "GenAa") int GenAa) 
    {
        return 2*genaa+GenAa;
    }
    */
    @WebMethod(operationName = "procesarArchivoPedWS")
    public String procesarArchivoPedWS(@WebParam(name = "archivo") String archivo){
        System.out.println( "Archivo Cargado en el servidor: " + archivo );
        ProcesarEstructuraPed procesarEstructuraPed = new ProcesarEstructuraPed();
        /*
        public String procesarArchivoPedWS( String archivo ){
            FuncionesPed funciones=new FuncionesPed(); 
            ArrayList <String> textoArchivo = funciones.leer_Archivo( archivo );
            String estructuraArchivo = funciones.llenar_Estructura(textoArchivo);
            return estructuraArchivo;
        }
        */        
        return procesarEstructuraPed.procesarArchivoPedWS( archivo );
    }
    
}
