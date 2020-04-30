/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import static proyecto2.Cuerpo.mat;

/**
 * Esta es la clase Fantasmas donde se encuentra todo el codigo referente a lo que es el 
 * comportamiento de los fantasmas.
 *@version 11.0.0
 * @author atera
 */
public class Fantasmas {
    
    //ATRIBUTOS
    int fantasmax;
    int fantasmay;
    Timer time;
    Random aleatorio;
    int direccion;
    int despalzamientox;
    int despalzamientoy;
    
    //CONTRUCTOR
    /**
     * Este es el constructo de los fantasmas y sus movimientos atravez ddel mapa.
     * @param x
     * @param y 
     */
    public Fantasmas(int x, int y){
        
        aleatorio = new Random();
        fantasmax = x;
        fantasmay = y;
        Cuerpo.mat[fantasmax][fantasmay] = 4;
        direccion = aleatorio.nextInt(4);
        this.movimieto();
    }
    /**
     * Aquí se encuentra toda la parte del codigo referente a como se comportaran los fantasmas asi como el comportamiento que
     * tendran al moverse o elegir cada una de sus rutas a seguir.
     */
    public void movimieto(){
        
        time = new Timer(200, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                //IZQUIERDA
                if(direccion==0){
                    //Camina
                    if(Cuerpo.mat[fantasmax-1][fantasmay]==0||Cuerpo.mat[fantasmax-1][fantasmay]==1){
                        Cuerpo.mat[fantasmax][fantasmay]= Cuerpo.mataux[fantasmax][fantasmay];
                        fantasmax -= 1;
                        Cuerpo.mat[fantasmax][fantasmay] = 4;
                    }
                //CHOCAN CON PARED
                    if(fantasmax > 0 && Cuerpo.mat[fantasmax-1][fantasmay]==2){
                        direccion = aleatorio.nextInt(4);
                    }
                    //CHOCAN ENTRE SI
                    if(Cuerpo.mat[fantasmax-1][fantasmay]==2){
                        direccion = aleatorio.nextInt(4);
                    }
                }
                //DERECHA
                if(direccion==1){
                    
                    if(Cuerpo.mat[fantasmax+1][fantasmay]==0||Cuerpo.mat[fantasmax+1][fantasmay]==1){
                        Cuerpo.mat[fantasmax][fantasmay]= Cuerpo.mataux[fantasmax][fantasmay];
                        fantasmax += 1;
                        Cuerpo.mat[fantasmax][fantasmay] = 4;
                    }
                    if(fantasmax < 13 && Cuerpo.mat[fantasmax+1][fantasmay]==2){
                        direccion = aleatorio.nextInt(4);
                    }
                    if(Cuerpo.mat[fantasmax+1][fantasmay]==2){
                        direccion = aleatorio.nextInt(4);
                    }
                }
                //ARRIBA
                if(direccion==2){
                    if(Cuerpo.mat[fantasmax][fantasmay-1]==0||Cuerpo.mat[fantasmax][fantasmay-1]==1){
                       Cuerpo.mat[fantasmax][fantasmay]= Cuerpo.mataux[fantasmax][fantasmay];
                        fantasmay -= 1;
                        Cuerpo.mat[fantasmax][fantasmay] = 4;
                }
                   if(fantasmay > 0 && Cuerpo.mat[fantasmax][fantasmay-1]==2){
                        direccion = aleatorio.nextInt(4);
                    }
                   if(Cuerpo.mat[fantasmax][fantasmay-1]==2){
                        direccion = aleatorio.nextInt(4);
                    }
                }
                //ABAJO
                if(direccion==3){
                    if(Cuerpo.mat[fantasmax][fantasmay+1]==0||Cuerpo.mat[fantasmax][fantasmay+1]==1){
                       Cuerpo.mat[fantasmax][fantasmay]= Cuerpo.mataux[fantasmax][fantasmay];
                        fantasmay += 1;
                        Cuerpo.mat[fantasmax][fantasmay] = 4;
                }
                    if(fantasmay < 13 && Cuerpo.mat[fantasmax][fantasmay+1]==2){
                        direccion = aleatorio.nextInt(4);
                }
                    if(Cuerpo.mat[fantasmax][fantasmay+1]==2){
                        direccion = aleatorio.nextInt(4);
                    }
                }
                
                Cuerpo.pintarMatris();
             
                
    }});
        
        time.start();
        
    }
}
