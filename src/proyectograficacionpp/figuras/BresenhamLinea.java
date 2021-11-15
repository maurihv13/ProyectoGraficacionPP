/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *aun no funciona
 * @author Fred
 */
public class BresenhamLinea extends JFrame{
   private int x0,x1,y0,y1,incE,incNE,d,deltaXB,deltaYB;
    public BresenhamLinea(){
        this.setBounds(600, 600, 600, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        BresenhamLinea l=new BresenhamLinea();
        l.bresenham(null,54,66,222,333);
    }
    
    public void algoritmo(int x0,int y0,int x1,int y1){
        int dx,dy,contad,pasox,pasoy,x,y,p,incE,incNE;
        int espacio=0;
        int segment=0;
        boolean lleno;
        dx=x1-x0;
        dy=y1-y0;
        contad=0;
        lleno=false;
        pasox=1;
        pasoy=1;
        if (dx<0) {
            dx=-dx;
            pasox=-1;
        }else{
            pasoy=1;
        }
        if(dy<0){
            dy=-dy;
            pasoy=-1;
        }else{
            pasoy=1;
        }
        x=x0;
        y=y0;
        
        if(dx>dy){
            p=2*dy-dx;
            incE=2*dy;
            incNE=2*(dy-dx);
            
            while(x!=x1){
                x=x+pasox;
                if(p<0){
                    p=p+incE;
                }else{
                    y=y+pasoy;
                    p=p+incNE;
                    
                }
                if(espacio!=0){
                    if(lleno){
                        if(contad<segment){
                            boolean arrib=true;
                            //aqui pinta
                        }
                    }else{}
                }else{}
            }
        }else{}
        
    }
    /*Graphics g, int x0, int y0, int x1, int y1*/
    
    public void bresenham(Graphics g, int x0, int y0, int x1, int y1) {
        super.paint(g);
        int x, y, dx, dy, p, incE, incNE, stepx, stepy;
        dx = (x1 - x0);
        dy = (y1 - y0);/* determinar que punto usar para empezar, cual para terminar*/ 
        if (dy< 0) {
            dy = -dy;
            stepy = -1;
        } else {
            stepy = 1;
        }
        if (dx
                < 0) {
            dx = -dx;
            stepx = -1;
        } else {
            stepx = 1;
        }
        x = x0;
        y = y0;

        g.drawLine(x0, y0, x0, y0);/* se cicla hasta llegar al extremo de la línea */ 
        if (dx > dy) {
            p = 2 * dy - dx;
            incE = 2 * dy;
            incNE = 2 * (dy - dx);
            while (x != x1) {
                x = x + stepx;
                if (p < 0) {
                    p = p + incE;
                } else {
                    y = y + stepy;
                    p = p + incNE;
                }
                g.drawLine(x0, y0, x0, y0);
            }
        } else {
            p = 2 * dx - dy;
            incE = 2 * dx;
            incNE = 2 * (dx - dy);
            while (y != y1) {
                y = y + stepy;
                if (p < 0) {
                    p = p + incE;
                } else {
                    x = x + stepx;
                    p = p + incNE;
                }
                g.drawLine(x0, y0, x0, y0);
            }
        }
    }

    
}
