/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectograficacionpp.transformaciones;

/**
 *
 * @author MAURICIO
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

class DirectDrawDemo extends JPanel{
    private BufferedImage canvas;
    public DirectDrawDemo(int width, int height) {
        
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        fillCanvas(Color.WHITE);
    }

    public Dimension getPreferredSize() {
        return new Dimension(canvas.getWidth(), canvas.getHeight());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }


    public void fillCanvas(Color c) {
        int color = c.getRGB();
        for (int x = 0; x < canvas.getWidth(); x++) {
            for (int y = 0; y < canvas.getHeight(); y++) {
                canvas.setRGB(x, y, color);
            }
        }
        repaint();
    }

    public void limpiarPant(){
        this.fillCanvas(Color.white);
    }
    
    public void bresenham(Circunferencia cir, Color c){
        Punto centro = cir.centro;
        int r = cir.radio;
        int posx = centro.x;
        int posy = centro.y;
        
        int color = c.getRGB();
        int dif = posy - posx;
        int x, y, e, w, h, nposx, nposy;
        x = r; y = 0; e = 0;
        w = canvas.getWidth(); h = canvas.getHeight();
        //canvas.setRGB(posx, posy, color); Math.round(()*escY)
        while (y <= x){
            nposx = x + posx; nposy = y + posy;
            dibujarPunto(nposx, nposy, color);
            
            nposx = y + posy - dif; nposy = x + posx + dif;
            dibujarPunto(nposx, nposy, color);
            
            nposx = -x + posx; nposy = y + posy;
            dibujarPunto(nposx, nposy, color);
            
            nposx = -y + posy - dif; nposy = x + posx + dif;
            dibujarPunto(nposx, nposy, color);
            
            nposx = x + posx; nposy = -y + posy;
            dibujarPunto(nposx, nposy, color);
            
            nposx = y + posy - dif; nposy = -x + posx + dif;
            dibujarPunto(nposx, nposy, color);
            
            nposx = -x + posx; nposy = -y + posy;
            dibujarPunto(nposx, nposy, color);
            
            nposx = -y + posy - dif; nposy = -x + posx + dif;
            dibujarPunto(nposx, nposy, color);
            
            e = e + 2*y + 1;
            y += 1;
            if (2*e > (2*x-1)){
                x -= 1;
                e = e - 2*x +1;
            }

        }
    }
    public void lineaAlg(Linea l, Color c){
        Punto p0, p1;
        int x0,y0,x1,y1;
        int color = c.getRGB();
        p0 = l.puntos[0];
        p1 = l.puntos[1];
        x0 = p0.x; y0 = p0.y;
        x1 = p1.x; y1 = p1.y; 
        //modifica para escalacion
        int dx = (x1-x0);
        int dy = (y1-y0);
        float m=0,b=0;
        if(dx!=0){
            m=(float)dy/(float)dx;
            b=y0-m*x0;
            if(x1>x0){
                dx=1;
            }else{
                dx=-1;
            }
            
            while(x0!=x1){
                x0 += dx;
                y0 = Math.round(m*x0+b);
                dibujarPunto(x0,y0,color);
            }
           //  
        }
    }
    
    public void lineaDDA(Linea l, Color c){
        int deltaX,deltaY;
        int x1,y1,x2,y2;
        Punto p1,p2;
        int color = c.getRGB();
        p1 = l.puntos[0]; p2 = l.puntos[1];
        x1 = p1.x; y1 = p1.y;
        x2 = p2.x; y2 = p2.y;
        
        deltaX = Math.abs(x2-x1);
        deltaY = Math.abs(y2-y1);
        
        float pasos = comparaciondda(deltaX,deltaY);
        float xIncrementodda = deltaX/pasos;
        float yIncrementodda = deltaY/pasos;
        /*   Correcion para sentido de lineas   */
        if(x1>x2) xIncrementodda *= -1;
        if(y1>y2) yIncrementodda *= -1;
        int i,x1dda,y1dda;
        float cX1,cY1;
        i=0;
        x1dda= x1;
        y1dda=y1;
        cX1=x1;
        cY1=y1;
        
        while(i<pasos){
            dibujarPunto(x1dda,y1dda,color);
            cX1=cX1 +xIncrementodda;
            cY1=cY1 +yIncrementodda;
            x1dda=Math.round(cX1);
            y1dda=Math.round(cY1);
            i++;
        }
    }
    
    private int comparaciondda(int delY,int delX){
        int res;
        if(delY>delX){
            res=delY;
        }else{
            res=delX;
        }
        return res;
    }
    
    public void triangulo(Triangulo t, Color c){
        Linea[] lineas = t.getLineas();
        for(Linea l : lineas){
            this.lineaDDA(l, c);
        }
    }
    
    public void cuadrado(Cuadrado t, Color c){
        Linea[] lineas = t.getLineas();
        for(Linea l : lineas){
            this.lineaDDA(l, c);
        }
    }
    
    private void dibujarPunto(int posx, int posy, int c){
        int w,h;
        w = canvas.getWidth(); h = canvas.getHeight();
        if ((posx > 0) && (posy > 0)){
            if(posx < w && posy < h){
               canvas.setRGB(posx, posy, c); 
            } 
        }
    }
}
