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
import static proyecto2.cuerpo2.mat3;

/**
 *
 * @author atera
 */
public class Fantasmas2 {
    
    //ATRIBUTOS
    int fantasmax2;
    int fantasmay2;
    Timer time2;
    Random aleatorio2;
    int direccion2;
    int despalzamientox2;
    int despalzamientoy2;
    
    //CONTRUCTOR
    /**
     * Este es el constructo de los fantasmas y sus movimientos atravez ddel mapa.
     * @param x
     * @param y 
     */
    public Fantasmas2(int x, int y){
        
        aleatorio2 = new Random();
        fantasmax2 = x;
        fantasmay2 = y;
        cuerpo2.mat2[fantasmax2][fantasmay2] = 4;
        direccion2 = aleatorio2.nextInt(4);
        this.movimieto2();
    }
    /**
     * Aquí se encuentra toda la parte del codigo referente a como se comportaran los fantasmas asi como el comportamiento que
     * tendran al moverse o elegir cada una de sus rutas a seguir.
     */
    public void movimieto2(){
        
        time2 = new Timer(200, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                //IZQUIERDA
                if(direccion2==0){
                    //Camina
                    if(cuerpo2.mat2[fantasmax2-1][fantasmay2]==0||cuerpo2.mat2[fantasmax2-1][fantasmay2]==1){
                        cuerpo2.mat2[fantasmax2][fantasmay2]= cuerpo2.mataux2[fantasmax2][fantasmay2];
                        fantasmax2 -= 1;
                        cuerpo2.mat2[fantasmax2][fantasmay2] = 4;
                    }
                //CHOCAN CON PARED
                    if(fantasmax2 > 0 && cuerpo2.mat2[fantasmax2-1][fantasmay2]==2){
                        direccion2 = aleatorio2.nextInt(4);
                    }
                    //CHOCAN ENTRE SI
                    if(cuerpo2.mat2[fantasmax2-1][fantasmay2]==2){
                        direccion2 = aleatorio2.nextInt(4);
                    }
                }
                //DERECHA
                if(direccion2==1){
                    
                    if(cuerpo2.mat2[fantasmax2+1][fantasmay2]==0||cuerpo2.mat2[fantasmax2+1][fantasmay2]==1){
                        cuerpo2.mat2[fantasmax2][fantasmay2]= cuerpo2.mataux2[fantasmax2][fantasmay2];
                        fantasmax2 += 1;
                        cuerpo2.mat2[fantasmax2][fantasmay2] = 4;
                    }
                    if(fantasmax2 < 13 && cuerpo2.mat2[fantasmax2+1][fantasmay2]==2){
                        direccion2 = aleatorio2.nextInt(4);
                    }
                    if(cuerpo2.mat2[fantasmax2+1][fantasmay2]==2){
                        direccion2 = aleatorio2.nextInt(4);
                    }
                }
                //ARRIBA
                if(direccion2==2){
                    if(cuerpo2.mat2[fantasmax2][fantasmay2-1]==0||cuerpo2.mat2[fantasmax2][fantasmay2-1]==1){
                       cuerpo2.mat2[fantasmax2][fantasmay2]= cuerpo2.mataux2[fantasmax2][fantasmay2];
                        fantasmay2 -= 1;
                        cuerpo2.mat2[fantasmax2][fantasmay2] = 4;
                }
                   if(fantasmay2 > 0 && cuerpo2.mat2[fantasmax2][fantasmay2-1]==2){
                        direccion2 = aleatorio2.nextInt(4);
                    }
                   if(cuerpo2.mat2[fantasmax2][fantasmay2-1]==2){
                        direccion2 = aleatorio2.nextInt(4);
                    }
                }
                //ABAJO
                if(direccion2==3){
                    if(cuerpo2.mat2[fantasmax2][fantasmay2+1]==0||cuerpo2.mat2[fantasmax2][fantasmay2+1]==1){
                       cuerpo2.mat2[fantasmax2][fantasmay2]= cuerpo2.mataux2[fantasmax2][fantasmay2];
                        fantasmay2 += 1;
                        cuerpo2.mat2[fantasmax2][fantasmay2] = 4;
                }
                    if(fantasmay2 < 13 && cuerpo2.mat2[fantasmax2][fantasmay2+1]==2){
                        direccion2 = aleatorio2.nextInt(4);
                }
                    if(cuerpo2.mat2[fantasmax2][fantasmay2+1]==2){
                        direccion2 = aleatorio2.nextInt(4);
                    }
                }
                
                cuerpo2.pintarMatris();
             
                
    }});
        
        time2.start();
        
    }
    
}
