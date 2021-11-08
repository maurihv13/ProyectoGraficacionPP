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

    
    public void bresenham(Circunferencia cir, Color c){
        Punto centro = cir.centro;
        int r = cir.radio;
        int posx = centro.x;
        int posy = centro.y;
        float escX = cir.escalax;
        float escY = cir.escalay;
        
        int color = c.getRGB();
        int dif = posy - posx;
        int x, y, e, w, h, nposx, nposy;
        x = r; y = 0; e = 0;
        w = canvas.getWidth(); h = canvas.getHeight();
        //canvas.setRGB(posx, posy, color); Math.round(()*escY)
        while (y <= x){
            nposx = Math.round((x + posx)*escX); nposy = Math.round((y + posy)*escY);
            if ((nposx > 0) && (nposy > 0)){
                if(nposx < w && nposy < h) canvas.setRGB(nposx, nposy, color);
            }
            
            nposx = Math.round((y + posy- dif)*escX) ; nposy = Math.round((x + posx + dif)*escY);
            if ((nposx > 0) && (nposy > 0)){
                if(nposx < w && nposy < h) canvas.setRGB(nposx, nposy, color);
            }
            
            nposx = Math.round((-x + posx)*escX); nposy = Math.round((y + posy)*escY);
            if ((nposx > 0) && (nposy > 0)){
                if(nposx < w && nposy < h) canvas.setRGB(nposx, nposy, color);
            }
            
            nposx = Math.round((-y + posy - dif)*escX); nposy = Math.round((x + posx + dif)*escY);
            if ((nposx > 0) && (nposy > 0)){
                if(nposx < w && nposy < h) canvas.setRGB(nposx, nposy, color);
            }
            
            nposx = Math.round((x + posx)*escX); nposy = Math.round((-y + posy)*escY);
            if ((nposx > 0) && (nposy > 0)){
                if(nposx < w && nposy < h) canvas.setRGB(nposx, nposy, color);
            }
            
            nposx = Math.round((y + posy - dif)*escX); nposy = Math.round((-x + posx + dif)*escY);
            if ((nposx > 0) && (nposy > 0)){
                if(nposx < w && nposy < h) canvas.setRGB(nposx, nposy, color);
            }
            
            nposx = Math.round((-x + posx)*escX); nposy = Math.round((-y + posy)*escY);
            if ((nposx > 0) && (nposy > 0)){
                if(nposx < w && nposy < h) canvas.setRGB(nposx, nposy, color);
            }
            
            nposx = Math.round((-y + posy - dif)*escX); nposy = Math.round((-x + posx + dif)*escY);
            if ((nposx > 0) && (nposy > 0)){
                if(nposx < w && nposy < h) canvas.setRGB(nposx, nposy, color);
            }
            
            e = e + 2*y + 1;
            y += 1;
            if (2*e > (2*x-1)){
                x -= 1;
                e = e - 2*x +1;
            }

        }
    }
}
