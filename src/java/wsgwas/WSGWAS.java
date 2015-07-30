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
    
}
