/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Fred
 */
public class Figuras {
   static LineaDDA  linea;
   static BresenhamLinea linBr;
   static LineaAlgoEcuacion lnE;
   private static int x1,x2,y1,y2,x3,y3;
    public Figuras() {
         linea= new LineaDDA();
         linBr=new BresenhamLinea();
         //lnE= new LineaAlgoEcuacion(x1, x1, y1, y1);
    }
    
    public static void lineDDA(int x1,int y1,int x2,int y2){
        //linea= new LineaDDA();
       //Graphics g=null;
        //linea.lineaDDA(x1, y1, x2, y2);
        //linBr.bresenham(g, x2, y2, x1, y1);
        lnE= new LineaAlgoEcuacion(x1, x2, y1, y2,Color.BLUE);
        
    }
    public static void main(String[] args) {
         Scanner sn=new Scanner(System.in);
        System.out.println("ingrese:");
        x1=sn.nextInt();
        x2=sn.nextInt();
        System.out.println("ingrese x,y final");
        y1=sn.nextInt();
        y2=sn.nextInt();
        System.out.println("x,y");
        x3=sn.nextInt();
        y3=sn.nextInt();
        ArrayList pos=new ArrayList();
        pos.add(x1);
        pos.add(y1);
        pos.add(x2);
        pos.add(y2);
        
        pos.add(x3);
        pos.add(y3);
        cuadrilatero(pos);
        //lineDDA(x1,y1,x2,y2);
        // triangulo(pos);
        
    }
    
    public static void cuadrilatero(ArrayList posisiones){
        int x1Izq,pyIzq,pxDer,pyDer;
         x1Izq=(int)posisiones.get(0);
         pyIzq=(int)posisiones.get(1);
         pxDer=(int)posisiones.get(2);
         pyDer=(int)posisiones.get(3);
         lineDDA(x1Izq,pyIzq,pxDer,pyIzq);
         lineDDA(x1Izq,pyIzq,x1Izq,pyDer);
         lineDDA(x1Izq, pyDer, pxDer, pyDer);
         lineDDA(pxDer, pyDer,x1Izq,pyIzq);
         
    }
    public static void triangulo(ArrayList posisiones){
        int xA,yA,xb,yb,xc,yc;
        xA=(int)posisiones.get(0);
        yA=(int)posisiones.get(1);
        xb=(int)posisiones.get(2);
        yb=(int)posisiones.get(3);
        xc=(int)posisiones.get(4);
        yc=(int)posisiones.get(5);
        lineDDA(xA, yA,xb,yb);
        lineDDA(xA, yA,xc,yc);
        lineDDA(xb,yb,xc,yc);
    }
}
