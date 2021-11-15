/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectograficacionpp.Operacion;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Juan Pablo
 */
public class DibCirculo {
    private int x;
    private int y;
    private int radio;
    
    public DibCirculo(int x,int y,int radio){
        this.x = x;
        this.y = y;
        this.radio = radio;
    }
    
    public void dibujar(Graphics g){
        double x1,y1;
        double angulo = 0;
        do{
            x1 = x+this.radio * ((float) Math.cos(angulo));
            y1 = y+this.radio * ((float) Math.sin(angulo));
            g.setColor(Color.BLACK);
            g.drawRect((int) x1,(int) y1,0,0);
            angulo = angulo +0.005;
            }while(angulo < 6.8);
    }
}
