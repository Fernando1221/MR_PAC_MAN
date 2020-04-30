/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

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
 * Esta es la clase donde se ubicara el segundo mapa para el multijugador
 *@version 3.0.0
 * @author atera
 */
public class cuerpo2 {
    
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
    
    static JPanel panelj2;
    JLabel fondoj;
    ImageIcon imagenj;
    static int mat3[][];
    int px;
    int py;
    static JLabel matris2[][];
    String nombre;
    String nombre2;
    JLabel jugador;
    JLabel jugador2;
    int puntos;
    int puntos2;
    JLabel record;
    JLabel record2;
    int abajo;
    int arriba;
    int derecha;
    int izquierda;
    Timer time;
    
    //PRUEBA
    static int mat2[][];
    int px2;
    int py2;
    
    //FANTASMAS
    Fantasmas2 fantasma;
    Fantasmas2 fantasma2;
    Fantasmas2 fantasma3;
    Fantasmas2 fantasma4;
    static int mataux2[][];
    /**
     * Este es el constructor de todas las ventanas, el tamaño de los mapas y la capacidad de 
     * mivilidad tanto de pacman como de los fantasmas
     */
    public cuerpo2(){
        
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
        
        boton = new JButton[1];
        for (int x=0; x<boton.length; x++){
            boton[x] = new JButton();
        
        }

        
        comenzar.addMouseListener(new MouseAdapter(){
            /**
             * Evento al clicar
             */
            public void mousePressed(MouseEvent e){
                menu();
                eventomenu();
            }
            
        });
        
        //JUEGO
        
        mat3 = new int[15][15];
        mat3 = mapa(1);
        
        
        //PRUEBA
        mat2 = new int[15][15];
        mat2 = mapa(1);
        
        
       // mataux = mapa(1);
        matris2 = new JLabel[15][15];
        mataux2 = new int[15][15];
        for (int x=0; x<mat3.length; x++){
            for (int y=0; y<mat3.length; y++){
                matris2[x][y] = new JLabel();
                mataux2[x][y] = mat3[x][y];
            }
        }
        
        //PRUEBA
        for (int x=0; x<mat2.length; x++){
            for (int y=0; y<mat2.length; y++){
                matris2[x][y] = new JLabel();
                mataux2[x][y] = mat2[x][y];
            }
        }

        //PERSONAJES
        px = 1;
        py = 1;
        mat3[px][py] = 3;
        
        //PRUEBA
        px2 = 1;
        py2 = 1;
        mat2[px2][py2] = 6;
        
        
        abajo = 0;
        arriba = 0;
        derecha = 0;
        izquierda = 0;
        
        ventana.add(panel);
        
        
        ventana.setVisible(true);
    }//FIN CONSTRUCTOR
    /**
     * Construccion de la ventana y de los mapas en el juego.
     */
    public void jugar(){
        
        panelm.setVisible(false);
        panelj2 = new JPanel();
        panelj2.setLayout(null);
        panelj2.setBounds(0,0,ventana.getWidth(),ventana.getHeight());
        panelj2.setVisible(true);
        
        fondoj = new JLabel();
        fondoj.setBounds(0, 0,ventana.getWidth(),ventana.getHeight());
        imagenj = new ImageIcon("Proyecto 2/Fondo negro.png");
        imagenj = new ImageIcon(imagenm.getImage().getScaledInstance(ventana.getWidth(),ventana.getHeight(),Image.SCALE_DEFAULT));
        fondoj.setIcon(imagenj);
        fondoj.setVisible(true);
        panelj2.add(fondoj,0);
        
        for (int x=0; x<mat2.length; x++){
            for (int y=0; y<mat2.length; y++){
                matris2[x][y].setIcon(new ImageIcon("Proyecto 2/" + mat3[x][y] + ".png "));
                matris2[x][y].setBounds(150+(x*30), (y*30), 30, 30);
                matris2[x][y].setVisible(true);
                panelj2.add(matris2[x][y],0);
            }
            
        }
        
        //PUNTOS
        
        jugador = new JLabel("JUGADOR: " + nombre);
        jugador.setBounds(20, 20, 200, 30);
        jugador.setForeground(Color.blue);
        jugador.setVisible(true);
        panelj2.add(jugador,0);
     
        puntos = 0;
        record = new JLabel("Puntos: " + puntos);
        record.setBounds(20, 40, 200, 30);
        record.setVisible(true);
        record.setForeground(Color.white);
        panelj2.add(record,0);
        
        jugador = new JLabel("JUGADOR: " + nombre2);
        jugador.setBounds(20, 20, 200, 100);
        jugador.setForeground(Color.blue);
        jugador.setVisible(true);
        panelj2.add(jugador,0);
        
        puntos2 = 0;
        record2 = new JLabel("Puntos: " + puntos2);
        record2.setBounds(20, 40, 200, 90);
        record2.setVisible(true);
        record2.setForeground(Color.white);
        panelj2.add(record2,0);
        
        movimientos2();
        fantasma = new Fantasmas2(10,11);
        fantasma2 = new Fantasmas2(11,11);
        fantasma3 = new Fantasmas2(12,12);
        


        ventana.add(panelj2);
        
    }
    /**
     * Para pintar la matriz que representa el mapa
     */
    public static void pintarMatris(){
        
        for (int x=0; x<mat2.length; x++){
            for (int y=0; y<mat2.length; y++){
                matris2[x][y].setIcon(new ImageIcon("Proyecto 2/" + mat3[x][y] + ".png "));
                matris2[x][y].setBounds(150+(x*30), (y*30), 30, 30);
                matris2[x][y].setVisible(true);
                panelj2.add(matris2[x][y],0);
                
            }
            
        }
        
        //PRUEBA
        for (int x=0; x<mat2.length; x++){
            for (int y=0; y<mat2.length; y++){
                matris2[x][y].setIcon(new ImageIcon("Proyecto 2/" + mat2[x][y] + ".png "));
                matris2[x][y].setBounds(150+(x*30), (y*30), 30, 30);
                matris2[x][y].setVisible(true);
                panelj2.add(matris2[x][y],0);
            }
            
        }
        
    }
    /**
     * Movimientos de los fantasmas y el comportamiento de Pac Man ante ellos asi como del control
     * de pacman mediante las flechas.
     */
    public void movimientos2(){
        
        time = new Timer(200, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                if(arriba==1 && (mat3[px][py-1]==1 || mat3[px][py-1]==0)){
                    if (mat3[px][py-1]==1){
                        puntos = puntos + 50;
                        record.setText("Puntos: " + puntos);
                    }
                     mat3[px][py]=0;
                     mataux2[px][py] = mat3[px][py]; //PARA LOS FANTASMAS
                    py = py-1;
                    mat3[px][py]=3;
                    pintarMatris();
                    
                }
                if(abajo==1 && (mat3[px][py+1]==1 || mat3[px][py+1]==0)){
                    if (mat3[px][py+1]==1){
                        puntos = puntos + 50;
                        record.setText("Puntos: " + puntos);
                    }
                     mat3[px][py]=0;
                     mataux2[px][py] = mat3[px][py]; //PARA LOS FANTASMAS
                    py = py+1;
                    mat3[px][py]=3;
                    pintarMatris();
                }
                if(izquierda==1 && (mat3[px-1][py]==1 || mat3[px-1][py]==0)){
                    if (mat3[px-1][py]==1){
                        puntos = puntos + 50;
                        record.setText("Puntos: " + puntos);
                    }
                     mat3[px][py]=0;
                     mataux2[px][py] = mat3[px][py]; //PARA LOS FANTASMAS
                    px = px-1;
                    mat3[px][py]=3;
                    pintarMatris();
                }
                if(derecha==1 && (mat3[px+1][py]==1 || mat3[px+1][py]==0)){
                    if (mat3[px+1][py]==1){
                        puntos = puntos + 50;
                        record.setText("Puntos: " + puntos);
                    }
                     mat3[px][py]=0;
                     mataux2[px][py] = mat3[px][py]; //PARA LOS FANTASMAS
                    px = px+1;
                    mat3[px][py]=3;
                    pintarMatris();
                }
                int enc = 0;
                for(int x=0; x<mat3.length && enc==0; x++){
                  for(int y=0; y<mat3.length && enc==0; y++){
                      if(mat3[x][y]==1){
                          enc = 1;
                      }
                  }
                }
                if (enc==0){
                      JOptionPane.showMessageDialog(ventana, "FELICIDADES HAS GANADO");
                      panelj2.setVisible(false);
                      panelm.setVisible(true);
                      time.stop();
                      
                  }
            
                //ANIQUILAR A PACMAN
                if (mat3[px][py+1] == 4 || mat3[px][py-1] == 4 || mat3[px-1][py] == 4 || mat3[px+1][py] == 4){
                    fantasma.time2.stop();
                    fantasma2.time2.stop();
                    fantasma3.time2.stop();
                    JOptionPane.showMessageDialog(ventana, "HAS MUERTO");
                    
                    panelj2.setVisible(false);
                    panelm.setVisible(true);
                    time.stop();
                }
            
            }
        });
        
        //PRUEBA
        time = new Timer(200, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                if(arriba==1 && (mat2[px2][py2-1]==1 || mat2[px2][py2-1]==0)){
                    if (mat2[px2][py2-1]==1){
                        puntos = puntos + 50;
                        record.setText("Puntos: " + puntos);
                    }
                     mat3[px2][py2]=0;
                     mataux2[px2][py2] = mat2[px2][py2]; //PARA LOS FANTASMAS
                    py2 = py2-1;
                    mat2[px2][py2]=6;
                    pintarMatris();
                    
                }
                if(abajo==1 && (mat2[px2][py2+1]==1 || mat2[px2][py2+1]==0)){
                    if (mat2[px2][py2+1]==1){
                        puntos = puntos + 50;
                        record.setText("Puntos: " + puntos);
                    }
                     mat2[px2][py2]=0;
                     mataux2[px2][py2] = mat2[px2][py2]; //PARA LOS FANTASMAS
                    py2 = py2+1;
                    mat2[px2][py2]=6;
                    pintarMatris();
                }
                if(izquierda==1 && (mat2[px2-1][py2]==1 || mat2[px2-1][py2]==0)){
                    if (mat2[px2-1][py2]==1){
                        puntos = puntos + 50;
                        record.setText("Puntos: " + puntos);
                    }
                     mat2[px2][py2]=0;
                     mataux2[px2][py2] = mat2[px2][py2]; //PARA LOS FANTASMAS
                    px2 = px2-1;
                    mat2[px2][py2]=3;
                    pintarMatris();
                }
                if(derecha==1 && (mat2[px2+1][py2]==1 || mat2[px2+1][py2]==0)){
                    if (mat2[px2+1][py2]==1){
                        puntos = puntos + 50;
                        record.setText("Puntos: " + puntos);
                    }
                     mat2[px2][py2]=0;
                     mataux2[px2][py2] = mat2[px2][py2]; //PARA LOS FANTASMAS
                    px2 = px2+1;
                    mat2[px2][py2]=6;
                    pintarMatris();
                }
                int enc = 0;
                for(int x=0; x<mat2.length && enc==0; x++){
                  for(int y=0; y<mat2.length && enc==0; y++){
                      if(mat2[x][y]==1){
                          enc = 1;
                      }
                  }
                }
                if (enc==0){
                      JOptionPane.showMessageDialog(ventana, "FELICIDADES HAS GANADO");
                      panelj2.setVisible(false);
                      panelm.setVisible(true);
                      time.stop();
                      
                  }
            
                //ANIQUILAR A PACMAN
                if (mat2[px2][py2+1] == 4 || mat2[px2][py2-1] == 4 || mat2[px2-1][py2] == 4 || mat2[px2+1][py2] == 4){
                    fantasma.time2.stop();
                    fantasma2.time2.stop();
                    fantasma3.time2.stop();
                    JOptionPane.showMessageDialog(ventana, "HAS MUERTO");
                    
                    panelj2.setVisible(false);
                    panelm.setVisible(true);
                    time.stop();
                }
            
            }
        });
        
        KeyListener movimiento = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //PRUEBA
                if (e.getKeyChar()=='W'|| e.getKeyChar()=='w'|| e.getExtendedKeyCode()== KeyEvent.VK_UP){
                    if(mat2[px2][py2-1]==1 || mat2[px2][py2-1]==0){
                    arriba = 1;
                    abajo = 0;
                    derecha = 0;
                    izquierda = 0;
                    }
                }
                if (e.getKeyChar()=='S'|| e.getKeyChar()=='s'|| e.getExtendedKeyCode()== KeyEvent.VK_DOWN){
                    if(mat2[px2][py2+1]==1 || mat2[px2][py2+1]==0){
                    arriba = 0;
                    abajo = 1;
                    derecha = 0;
                    izquierda = 0;
                    }
                }
                if (e.getKeyChar()=='A'|| e.getKeyChar()=='a'|| e.getExtendedKeyCode()== KeyEvent.VK_LEFT){
                    if(mat2[px2-1][py2]==1 || mat2[px2-1][py2]==0){
                    arriba = 0;
                    abajo = 0;
                    derecha = 0;
                    izquierda = 1;
                    }
                }
                if (e.getKeyChar()=='D'|| e.getKeyChar()=='d'|| e.getExtendedKeyCode()== KeyEvent.VK_RIGHT){
                    if(mat2[px2+1][py2]==1 || mat2[px2+1][py2]==0){
                    arriba = 0;
                    abajo = 0;
                    derecha = 1;
                    izquierda = 0;
                    }
                }
                
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
                    if(mat3[px][py-1]==1 || mat3[px][py-1]==0){
                    arriba = 1;
                    abajo = 0;
                    derecha = 0;
                    izquierda = 0;
                    }
                }
                //TECLA ABAJO
                if (e.getKeyCode()==KeyEvent.VK_DOWN){
                    if(mat3[px][py+1]==1 || mat3[px][py+1]==0){
                    arriba = 0;
                    abajo = 1;
                    derecha = 0;
                    izquierda = 0;
                    }
                }
                //TECLA IZQUIERDA
                if (e.getKeyCode()==KeyEvent.VK_LEFT){
                    if(mat3[px-1][py]==1 || mat3[px-1][py]==0){
                    arriba = 0;
                    abajo = 0;
                    derecha = 0;
                    izquierda = 1;
                    }
                }
                //TECLA DERECHA
                if (e.getKeyCode()==KeyEvent.VK_RIGHT){
                   
                    if(mat3[px+1][py]==1 || mat3[px+1][py]==0){
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
     * La matriz para indicar que partes son los muros (2) y que partes son las comestibles y por lo tanto donde
     * se puede pasar (1).
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
     * Como se realizo el menu
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
        //boton[2].setText("RECORD");
        //boton[3].setText("SALIR");
        
        for(int x=0; x<boton.length; x++){
            boton[x].setBounds(300, (x+1)*50, 200, 40);
            boton[x].setVisible(true);
            boton[x].setBackground(Color.WHITE);
            panelm.add(boton[x],0);
        }
        ventana.add(panelm);
    }//FIN MENU
    /**
     * Los diferentes eventos que sucederan al clicar alguno de los botones.
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
                
                nombre2 = JOptionPane.showInputDialog(ventana,"Nombre jugador", "Escribir");
                while (nombre2==null || nombre2.compareTo("Escribir")==0 || nombre2.compareTo("")==0 ){
                    nombre2 = JOptionPane.showInputDialog(ventana, "Debe registarse");
                }
                
               jugar(); 
            }
            
        });
        
        //JUGAR VS
        
        //boton[1].addMouseListener(new MouseAdapter(){
            
            //public void mousePressed(MouseEvent e){
                 
            //}
            
        //});
        
        //RECORD
        
        //boton[2].addMouseListener(new MouseAdapter(){
            
            //public void mousePressed(MouseEvent e){
                
            //}
            
        //});
        
        //SALIR
        
        //boton[3].addMouseListener(new MouseAdapter(){
            
            //public void mousePressed(MouseEvent e){
                //System.exit(0);
            //}
            
        //});
    }
    
}
