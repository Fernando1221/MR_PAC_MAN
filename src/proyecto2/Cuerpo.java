/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.awt.Button;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Esta es la clase cuerpo, aquí se programara todo lo referente a lo que son las 
 * ventanas, el pacman, laberinto, menu y los botones que se usaran dentro del menu.
 *@version 11.0.0
 * @author Sergio Morán
 *
 */
public class Cuerpo {
    //ATRIBUTOS
    
    static JFrame ventana;
    
    //PRESENTACION
    JPanel panel;
    JButton comenzar;
    JLabel fondo;
    ImageIcon imagen;
    
    //MENU
    
    JButton boton[];
    JPanel panelm;
    JLabel fondom;
    ImageIcon imagenm;
    
    //JUEGO
    
    static JPanel panelr;
    ImageIcon imagenr;
    JLabel fondor; 
    static JPanel panelj;
    JLabel fondoj;
    ImageIcon imagenj;
    static int mat[][];
    int px;
    int py;
    static JLabel matris[][];
    String nombre;
    JLabel jugador;
    int puntos;
    JLabel record;
    int abajo;
    int arriba;
    int derecha;
    int izquierda;
    Timer time;
    Button pausas;
    
    //FANTASMAS
    Fantasmas fantasma;
    Fantasmas fantasma2;
    Fantasmas fantasma3;
    Fantasmas fantasma4;
    static int mataux[][];
    
    //PAUSA
    boolean pausa;
    /**
    * Este es el constructo tanto de las ventanas como del mapa y del menu
    */
    public Cuerpo(){
        
        ventana = new JFrame("MR.PAC-MAN");
        ventana.setSize(750,500);
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,ventana.getWidth(),ventana.getHeight());
        panel.setVisible(true);
        panel.setBackground(Color.black);
        
        comenzar = new JButton("COMENZAR");
        comenzar.setBounds(310, 240, 120, 50);
        comenzar.setVisible(true);
        comenzar.setBackground(Color.white);
        panel.add(comenzar);
        
        
        fondo = new JLabel();
        fondo.setBounds(0, 0,ventana.getWidth(),ventana.getHeight());
        imagen = new ImageIcon("Proyecto 2/Fondo negro.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(ventana.getWidth(),ventana.getHeight(),Image.SCALE_DEFAULT));
        fondo.setIcon(imagen);
        fondo.setVisible(true);
        panel.add(fondo,0);
        
        //ADENTRO DEL MENU
        
        boton = new JButton[3];
        for (int x=0; x<boton.length; x++){
            boton[x] = new JButton();
        
        }

        
        comenzar.addMouseListener(new MouseAdapter(){
            /**
             * Este es el evento que permite que sea clicado cada uno de los Botones.
             */
            public void mousePressed(MouseEvent e){
                menu();
                eventomenu();
            }
            
        });
        
        //JUEGO
        
        mat = new int[15][15];
        mat = mapa(1);
       // mataux = mapa(1);
        matris = new JLabel[15][15];
        mataux = new int[15][15];
        for (int x=0; x<mat.length; x++){
            for (int y=0; y<mat.length; y++){
                matris[x][y] = new JLabel();
                mataux[x][y] = mat[x][y];
            }
        }

        //PERSONAJES
        px = 1;
        py = 1;
        mat[px][py] = 3;
        
        
        abajo = 0;
        arriba = 0;
        derecha = 0;
        izquierda = 0;
        
        ventana.add(panel);
        
        
        ventana.setVisible(true);
    }//FIN CONSTRUCTOR
    /**
     * En esta parte se encuentra la construcción de la ventana para el juego, tambien encontraremos los movimientos de los fantasmas, 
     * asi como de como se hubicara el cada pieza en el mapa incluyendo la posicion del nombre y el punteo para el jugador.
     */
    public void jugar(){
        
        panelm.setVisible(false);
        panelj = new JPanel();
        panelj.setLayout(null);
        panelj.setBounds(0,0,ventana.getWidth(),ventana.getHeight());
        panelj.setVisible(true);
        
        fondoj = new JLabel();
        fondoj.setBounds(0, 0,ventana.getWidth(),ventana.getHeight());
        imagenj = new ImageIcon("Proyecto 2/Fondo negro.png");
        imagenj = new ImageIcon(imagenm.getImage().getScaledInstance(ventana.getWidth(),ventana.getHeight(),Image.SCALE_DEFAULT));
        fondoj.setIcon(imagenj);
        fondoj.setVisible(true);
        panelj.add(fondoj,0);
        
        for (int x=0; x<mat.length; x++){
            for (int y=0; y<mat.length; y++){
                matris[x][y].setIcon(new ImageIcon("Proyecto 2/" + mat[x][y] + ".png "));
                matris[x][y].setBounds(150+(x*30), (y*30), 30, 30);
                matris[x][y].setVisible(true);
                panelj.add(matris[x][y],0);
            }
            
        }
        
        //PUNTOS
        
        jugador = new JLabel("JUGADOR: " + nombre);
        jugador.setBounds(20, 20, 200, 30);
        jugador.setForeground(Color.blue);
        jugador.setVisible(true);
        panelj.add(jugador,0);
        
        puntos = 0;
        record = new JLabel("Puntos: " + puntos);
        record.setBounds(20, 40, 200, 30);
        record.setVisible(true);
        record.setForeground(Color.white);
        panelj.add(record,0);
        
        //PAUSA
        //pausas = new Button("PAUSA ");
        //pausas.setBounds(20, 100, 50, 20);
        //pausas.setForeground(Color.blue);
        //pausas.setVisible(true);
        //panelj.add(pausas,0);
        
        movimientos();
        fantasma = new Fantasmas(10,11);
        fantasma2 = new Fantasmas(11,11);
        fantasma3 = new Fantasmas(12,12);
        


        ventana.add(panelj);
        
    }
    /**
     * En esta parte se encuentra la armazon de la venta de los records
     */
    public void record(){
        panelm.setVisible(false);
        panelr = new JPanel();
        panelr.setLayout(null);
        panelr.setBounds(0,0,ventana.getWidth(),ventana.getHeight());
        panelr.setVisible(true);
        
        fondor = new JLabel();
        fondor.setBounds(0, 0,ventana.getWidth(),ventana.getHeight());
        imagenr = new ImageIcon("Proyecto 2/Fondo negro.png");
        imagenr = new ImageIcon(imagenm.getImage().getScaledInstance(ventana.getWidth(),ventana.getHeight(),Image.SCALE_DEFAULT));
        fondor.setIcon(imagenr);
        fondor.setVisible(true);
        panelr.add(fondor,0);
        
        
        ventana.add(panelr);
    }
    
    /**
     * Aquí se programo el "for" para poder crear el mapa y colocar las diferentes piezas que lo conforman.
     */
    public static void pintarMatris(){
        
        for (int x=0; x<mat.length; x++){
            for (int y=0; y<mat.length; y++){
                matris[x][y].setIcon(new ImageIcon("Proyecto 2/" + mat[x][y] + ".png "));
                matris[x][y].setBounds(150+(x*30), (y*30), 30, 30);
                matris[x][y].setVisible(true);
                panelj.add(matris[x][y],0);
            }
            
        }
        
    }
    /**
     *Aquí encontrara como se programaron cada uno de los movimientos del Pac Man y de como interactua ante los fantasmas,
     * tambien se encuentra la programacion de los botones de las flechas que permiten la movilidad.
     */
    public void movimientos(){
        
        time = new Timer(200, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                if(arriba==1 && (mat[px][py-1]==1 || mat[px][py-1]==0)){
                    if (mat[px][py-1]==1){
                        puntos = puntos + 50;
                        record.setText("Puntos: " + puntos);
                    }
                     mat[px][py]=0;
                     mataux[px][py] = mat[px][py]; //PARA LOS FANTASMAS
                    py = py-1;
                    mat[px][py]=3;
                    pintarMatris();
                    
                }
                if(abajo==1 && (mat[px][py+1]==1 || mat[px][py+1]==0)){
                    if (mat[px][py+1]==1){
                        puntos = puntos + 50;
                        record.setText("Puntos: " + puntos);
                    }
                     mat[px][py]=0;
                     mataux[px][py] = mat[px][py]; //PARA LOS FANTASMAS
                    py = py+1;
                    mat[px][py]=3;
                    pintarMatris();
                }
                if(izquierda==1 && (mat[px-1][py]==1 || mat[px-1][py]==0)){
                    if (mat[px-1][py]==1){
                        puntos = puntos + 50;
                        record.setText("Puntos: " + puntos);
                    }
                     mat[px][py]=0;
                     mataux[px][py] = mat[px][py]; //PARA LOS FANTASMAS
                    px = px-1;
                    mat[px][py]=3;
                    pintarMatris();
                }
                if(derecha==1 && (mat[px+1][py]==1 || mat[px+1][py]==0)){
                    if (mat[px+1][py]==1){
                        puntos = puntos + 50;
                        record.setText("Puntos: " + puntos);
                    }
                     mat[px][py]=0;
                     mataux[px][py] = mat[px][py]; //PARA LOS FANTASMAS
                    px = px+1;
                    mat[px][py]=3;
                    pintarMatris();
                }
                int enc = 0;
                for(int x=0; x<mat.length && enc==0; x++){
                  for(int y=0; y<mat.length && enc==0; y++){
                      if(mat[x][y]==1){
                          enc = 1;
                      }
                  }
                }
                if (enc==0){
                      JOptionPane.showMessageDialog(ventana, "FELICIDADES HAS GANADO");
                      panelj.setVisible(false);
                      panelm.setVisible(true);
                      time.stop();
                      
                  }
            
                //ANIQUILAR A PACMAN
                if (mat[px][py+1] == 4 || mat[px][py-1] == 4 || mat[px-1][py] == 4 || mat[px+1][py] == 4){
                    fantasma.time.stop();
                    fantasma2.time.stop();
                    fantasma3.time.stop();
                    JOptionPane.showMessageDialog(ventana, "HAS MUERTO");
                    
                    panelj.setVisible(false);
                    panelm.setVisible(true);
                    time.stop();
                }
            
            }
        });
        
        KeyListener movimiento = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //TECLA ARRIBA
                if (e.getKeyCode()==KeyEvent.VK_UP){
                    if(mat[px][py-1]==1 || mat[px][py-1]==0){
                    arriba = 1;
                    abajo = 0;
                    derecha = 0;
                    izquierda = 0;
                    }
                }
                //TECLA ABAJO
                if (e.getKeyCode()==KeyEvent.VK_DOWN){
                    if(mat[px][py+1]==1 || mat[px][py+1]==0){
                    arriba = 0;
                    abajo = 1;
                    derecha = 0;
                    izquierda = 0;
                    }
                }
                //TECLA IZQUIERDA
                if (e.getKeyCode()==KeyEvent.VK_LEFT){
                    if(mat[px-1][py]==1 || mat[px-1][py]==0){
                    arriba = 0;
                    abajo = 0;
                    derecha = 0;
                    izquierda = 1;
                    }
                }
                //TECLA DERECHA
                if (e.getKeyCode()==KeyEvent.VK_RIGHT){
                   
                    if(mat[px+1][py]==1 || mat[px+1][py]==0){
                    arriba = 0;
                    abajo = 0;
                    derecha = 1;
                    izquierda = 0;
                    }
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        time.start();
        ventana.addKeyListener(movimiento);
    }
    /**
     * En esta seccion se constrira el mapa, siendo así que el número 2 reoresenta los bloques donde no se puede pasar
     * y el número 1 representando los espacios donde se puede pasar y se comera la comida, a su vez la matriz se actualizar 
     * de tal manera que los bloques donde se halla comido aparezcan sin la comida respectivamente.
     * @param opcion
     * @return 
     */
    public int[][] mapa(int opcion){
        int [][] aux1 = new int [15][15];
        if (opcion == 1){
            int aux[][] = {
                {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                {2,1,1,1,1,1,1,2,1,1,1,1,1,1,2},
                {2,1,2,2,1,2,1,2,1,2,2,1,2,1,2},
                {2,1,2,1,1,2,1,1,1,1,2,1,2,1,2},
                {2,1,1,1,2,2,2,1,2,1,1,1,1,1,2},
                {2,1,2,1,1,1,1,1,2,2,2,1,2,2,2},
                {2,1,2,2,1,2,2,1,1,2,2,1,1,1,2},
                {2,1,1,1,1,1,2,2,1,1,1,1,2,1,2},
                {2,2,2,1,2,1,2,2,2,1,2,1,2,1,2},
                {2,1,1,1,2,1,1,1,1,1,1,1,1,1,2},
                {2,1,2,1,1,1,2,2,2,1,2,1,2,1,2},
                {2,1,1,1,2,1,2,1,1,1,1,1,2,1,2},
                {2,1,2,1,2,1,2,1,2,1,2,1,2,1,2},
                {2,1,1,1,2,1,1,1,1,1,1,1,1,1,2},
                {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
            };
            return aux;
        }
        return aux1;
    }
    
    
    /**
     * Esta es la construccion de la ventana menu con sus diferentes botones.
     */
    public void menu(){
        panel.setVisible(false);
        panelm = new JPanel();
        panelm.setLayout(null);
        panelm.setBounds(0,0,ventana.getWidth(),ventana.getHeight());
        panelm.setVisible(true);
        
        fondom = new JLabel();
        fondom.setBounds(0, 0,ventana.getWidth(),ventana.getHeight());
        imagenm = new ImageIcon("Proyecto 2/Fondo negro.png");
        imagenm = new ImageIcon(imagenm.getImage().getScaledInstance(ventana.getWidth(),ventana.getHeight(),Image.SCALE_DEFAULT));
        fondom.setIcon(imagenm);
        fondom.setVisible(true);
        panelm.add(fondom,0);
        
        boton[0].setText("JUGAR");
        //boton[1].setText("JUGAR VS");
        boton[1].setText("RECORD");
        boton[2].setText("SALIR");
        
        for(int x=0; x<boton.length; x++){
            boton[x].setBounds(300, (x+1)*50, 200, 40);
            boton[x].setVisible(true);
            boton[x].setBackground(Color.WHITE);
            panelm.add(boton[x],0);
        }
        ventana.add(panelm);
    }//FIN MENU
    /**
     * Esta es la parte donde colocaremos los eventos que sucedarean una vez se clicla en cada uno de los botones
     * se desplegara cada uno de ellos segun corresponda.
     */
    public void eventomenu(){
        
        //JUGAR
        
        boton[0].addMouseListener(new MouseAdapter(){
            
            public void mousePressed(MouseEvent e){
                //PEDIR EL NOMBRE
                nombre = JOptionPane.showInputDialog(ventana,"Nombre jugador", "Escribir");
                while (nombre==null || nombre.compareTo("Escribir")==0 || nombre.compareTo("")==0 ){
                    nombre = JOptionPane.showInputDialog(ventana, "Debe registarse");
                }

               jugar(); 

                
                
            }
            
        });
        
        //JUGAR VS
        
        //boton[1].addMouseListener(new MouseAdapter(){
            
            //public void mousePressed(MouseEvent e){
                 
                //nombre = JOptionPane.showInputDialog(ventana,"Nombre jugador", "Escribir");
                //while (nombre==null || nombre.compareTo("Escribir")==0 || nombre.compareTo("")==0 ){
                //    nombre = JOptionPane.showInputDialog(ventana, "Debe registarse");
                //}
                
               // jugar();
                
            //}
            
        //});
        
        //RECORD
        
        boton[1].addMouseListener(new MouseAdapter(){
            
            public void mousePressed(MouseEvent e){
                record();
                
            }
            
        });
        
        //SALIR
        
        boton[2].addMouseListener(new MouseAdapter(){
            
            public void mousePressed(MouseEvent e){
                System.exit(0);
            }
            
        });
    }
}
