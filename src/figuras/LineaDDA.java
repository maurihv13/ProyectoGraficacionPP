/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 * @author Fred
 */
public class LineaDDA extends Canvas {
    static int x1,x2,y1,y2,incE,incNE,d,deltaXB,deltaYB;
    static float pasos,xInccrementodda,yIncrementodda;
    public LineaDDA() {
      
      
    }
    public static void main(String[] args) {
        while(true){
            int deltaX,deltaY;
            puntoInicial();
            
            deltaX=Math.abs(x2-x1);
            deltaY=Math.abs(y2-y1);
            pasos=comparaciondda(deltaX,deltaY);
            xInccrementodda=deltaX/pasos;
            yIncrementodda=deltaY/pasos;
            deltaXB=x2-x1;
            deltaYB=y2-y1;
            incE=2*deltaYB;
            incNE=(2*deltaYB)-(2*deltaXB);
            d=(2*deltaYB)-(deltaXB);
            JFrame frame=new JFrame();
            frame.setBounds(500, 500,500, 500);
            
            Canvas canvas=new LineaDDA();
            canvas.setSize(500,500);
            frame.add(canvas);
            frame.setVisible(true);
        }
    }
    public void paint(Graphics g){
        int i,x1dda,y1dda,yb,xb;
        float cX1,cY1;
        yb = y1;
        xb = x1;
        i=0;
        x1dda= x1;
        y1dda=y1;
        cX1=x1;
        cY1=y1;
        
        while(i<pasos){
            g.setColor(Color.blue);
            g.drawLine(x1dda,y1dda,x1dda,y1dda);
            cX1=cX1 +xInccrementodda;
            cY1=cY1 +yIncrementodda;
            x1dda=Math.round(cX1);
            y1dda=Math.round(cY1);
            i++;
        }
    }
    public static void puntoInicial(){
        Scanner sn=new Scanner(System.in);
        System.out.println("ingrese:");
        x1=sn.nextInt();
        x2=sn.nextInt();
        System.out.println("ingrese x,y final");
        y1=sn.nextInt();
        y2=sn.nextInt();
    }
    public static int comparaciondda(int delY,int delX){
        int res;
        if(delY>delX){
            res=delY;
        }else{
            res=delX;
        }
        return res;
    }
}
