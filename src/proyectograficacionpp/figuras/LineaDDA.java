/*
 
 */
package proyectograficacionpp.figuras;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 * @author Fred
 */
public class LineaDDA extends Canvas {
    private int x1,x2,y1,y2,incE,incNE,d,deltaXB,deltaYB;
    static float pasos,xInccrementodda,yIncrementodda;
    public LineaDDA() {
      
    }
    public void lineaDDA(int x1,int y1,int x2,int y2) {
        JFrame frame=new JFrame();
            frame.setBounds(500, 500,500, 500);
            Canvas canvas=new LineaDDA();
            canvas.setSize(500,500);
            frame.add(canvas);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true){
            int deltaX,deltaY;
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
        /**
        while(i<pasos){
            g.setColor(Color.blue);
            g.drawLine(x1dda,y1dda,x1dda,y1dda);
            cX1=cX1 +xInccrementodda;
            cY1=cY1 +yIncrementodda;
            x1dda=Math.round(cX1);
            y1dda=Math.round(cY1);
            i++;
        }*/
        
        while(xb<=x2){
            g.setColor(Color.RED);
            g.drawLine(xb, yb, xb, yb);
            if(d<=0){
                d += incE;
            }else{
                d += incE;
                yb++;
            }
            xb++;
        }
    }
    /*public static void puntoInicial(){
        Scanner sn=new Scanner(System.in);
        System.out.println("ingrese:");
        x1=sn.nextInt();
        x2=sn.nextInt();
        System.out.println("ingrese x,y final");
        y1=sn.nextInt();
        y2=sn.nextInt();
    }*/
    public  int comparaciondda(int delY,int delX){
        int res;
        if(delY>delX){
            res=delY;
        }else{
            res=delX;
        }
        return res;
    }
}
