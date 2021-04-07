/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testamegasena;

/**
 *
 * @author guigu
 */
public class TestaMegasena {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Megasena b = new Megasena(1000, 6);
        b.imprimeBolao();
        
        Integer [] resultado = {8, 32, 38, 15, 44, 65};
        
        b.confereBolao(resultado);
        b.imprimeResulado();
    }
    
}
