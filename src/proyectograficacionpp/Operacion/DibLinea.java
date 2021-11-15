/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectograficacionpp.Operacion;
import java.awt.*;
/**
 *
 * @author Juan Pablo
 */
public class DibLinea {
    private int x0;
    private int x1;
    private int y0;
    private int y1;
    private int aux;
    private boolean control;
    private int grosor;
    
    
    public DibLinea(int x0,int x1,int y0,int y1,int aux,boolean control,int grosor){
        this.x0 = x0;
        this.x1 = x1;
        this.y0 = y0;
        this.y1 = y1;
        this.aux = aux;
        this.control = control;
        this.grosor = grosor;
    }
    
    public void dibujarLinea (Graphics g,Color c)
    {
        g.setColor(c);
        float dx = x1-x0;
        float dy = y1-y0;
        float m=0,b=0;
        g.drawLine(x0,y0,x0,y0);
        
        if(dx != 0 ){
            if (dy == 0){
                g.drawLine(x0,y0,x1,y1);
                int aux = 1;
                if(control == true)
                    while(grosor!=0){
                        g.drawLine(x0,y0+aux,x1,y1+aux);
                        g.drawLine(x0,y0-aux,x1,y1-aux);
                        grosor--;
                        aux++;
                    }
            }else{
                if(control == true){
                    aumentarGrosor(x0,y0,grosor,g);
                    aumentarGrosor(x1,y1,grosor,g);
                }
                m = (float)dy / (float)dx;
                b = y0 - m*x0;
                //x0 =3 x1=8 y0=2 y1=12
                if(x1 > x0)
                    dx = 1;
                else
                    dx = -1;
                while (x0 != x1) {
                  x0 += dx;//4
                  y0 = Math.round(m*x0 + b);
                  g.drawLine(x0,y0,x0,y0);
                  if(control == true)
                    aumentarGrosor(x0,y0,grosor,g);
                }
            }
        }else{
            g.drawLine(x0,y0,x1,y1);
            int aux1 = 1;
            if(control == true)
                
                while(grosor!=0){
                    g.drawLine(x0+aux1,y0,x1+aux1,y1);
                    g.drawLine(x0-aux1,y0,x1-aux1,y1);
                    grosor--;
                    aux++;
            }
        }
        System.out.println("La pendiente es : " + m + "\n" + "La interseccion de y es : "+ b);
    }
    private void aumentarGrosor(int x0,int y0,int grosor,Graphics g ){
        int aux =1;
        while(grosor != 0){
            g.drawLine(x0+aux,y0,x0,y0);
            //g.drawLine(x0,y0+aux,x0,y0);
            g.drawLine(x0-aux,y0,x0,y0);
            //g.drawLine(x0,y0-aux,x0,y0);
            
            aux++;
            grosor--;
        }
    }
}
