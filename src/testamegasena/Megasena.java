/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testamegasena;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author guigu
 */
public class Megasena {
    private int qtdeJogos;
    private int qtdeApostas;
    private ArrayList <Set> bolao;
    private int qtdeQuadras = 0;
    private int qtdeQuinas = 0;
    private int qtdeSenas = 0;
    

    public Megasena(int qtdeJogos, int qtdeApostas) {
        
        if (qtdeJogos<=0) {
            qtdeJogos =1;
        }
        
        if (qtdeApostas < 6) {
            qtdeApostas = 6;
        }
        
        if (qtdeApostas>15) {
            qtdeApostas =15;
        }
        
        this.qtdeJogos = qtdeJogos;
        this.qtdeApostas = qtdeApostas;
        
       
        bolao = new ArrayList <Set>();
        
        preencheBolao();
        
    }

    private void preencheBolao(){
        Random mariaLouca = new Random();
        mariaLouca.setSeed(new Date().getTime());
        
        for (int i = 0; i < qtdeJogos; i++) {
            Set <Integer> jogo = new HashSet<Integer>();
            
            while (jogo.size() < qtdeApostas){
                jogo.add(mariaLouca.nextInt(60)+1);
                //Double d = Math.random()*59+1;
                //jogo.add(d.intValue());
            }
            bolao.add(jogo);
        }
    }
    
    public void imprimeBolao(){
        int tamanho = bolao.size(); // reduzir 
        
        for (int i = 0; i < tamanho ; i++) {
            Set<Integer> jogo = bolao.get(i);
            System.out.println((i+1) + " -> " + jogo);
        }
        System.out.println();
  
    }
    
    public void confereBolao(Integer [] r){
        int tamanho = bolao.size();
        
        for (int i = 0; i < tamanho; i++) {
            Set <Integer> jogo = bolao.get(i);
            
            int contador = 0;
            for (int j = 0; j < 5; j++) {
                if (jogo.contains(r[j])) {
                    contador++;
                }
            }
            
            switch(contador){
                case 4: qtdeQuadras ++; break;
                case 5: qtdeQuinas ++; break;
                case 6: qtdeSenas ++; break;
                
            }
        }
    }
    
    public void imprimeResulado(){
        System.out.println("Resultado do bolão:");
        System.out.println("-------------------");
        System.out.println("Quadras: " + qtdeQuadras);
        System.out.println("-------------------");
        System.out.println("Quinas: " + qtdeQuinas);
        System.out.println("-------------------");
        System.out.println("Senas: " + qtdeSenas);
        System.out.println("-------------------");
          
        

    }
    
    
    
}
