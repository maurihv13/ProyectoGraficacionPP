/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectograficacionpp.figuras;

import proyectograficacionpp.transformaciones.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Fred
 */
public class Figuras extends JFrame {

    static LineaDDA linea;
    static BresenhamLinea linBr;
    static LineaAlgoEcuacion lnE;
    private static int x1, x2, y1, y2, x3, y3, nV;
    static Punto p1,p2;
    static Linea l;
    static DirectDrawDemo direct;
    static JPanel panelDibujo;
    //static Linea l;

    public Figuras() {
         //linBr=new BresenhamLinea(600,600);
         //this.add(linBr);
//         this.add(panelDibujo);
        direct = new DirectDrawDemo(500, 500);
        this.add(direct);
        
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void lineDDA(int x1, int y1, int x2, int y2) {
        p1=new Punto(x1, y1);
        p2= new Punto(x2, y2);
        l=new Linea(p1, p2);
        
//        Graphics g=linBr.getGraphics();
//        linBr.bresenham(g, x1, y1, x2, y2);
        direct.setGrosor(2);
        direct.lineaAlg(l, Color.ORANGE); //tienes que minimizar y maximisar la pagina
    }

    public static void main(String[] args) {
        Figuras f = new Figuras();
        /*
        Scanner sn = new Scanner(System.in);
        
        System.out.println("ingrese x y inicial:");
        x1 = sn.nextInt();
        y1 = sn.nextInt();
        System.out.println("ingrese x,y final");
        x2 = sn.nextInt();
        y2 = sn.nextInt();
        */
        x1=24;y1=43;x2=222;y2=333;
//          System.out.println("x3,y3"); x3=sn.nextInt(); y3=sn.nextInt();
//          ArrayList pos=new ArrayList(); pos.add(x1); pos.add(y1); pos.add(x2);
//          pos.add(y2);
//         
//         pos.add(x3); pos.add(y3);
        //cuadrilatero(pos);
         
        
        lineDDA(x1, y1, x2, y2);
         //triangulo(pos);

    }

    public static void cuadrilatero(ArrayList posisiones) {
        int x1Izq, pyIzq, pxDer, pyDer;
        x1Izq = (int) posisiones.get(0);
        pyIzq = (int) posisiones.get(1);
        pxDer = (int) posisiones.get(2);
        pyDer = (int) posisiones.get(3);
        //int list=
        nV = 0;
        lineDDA(x1Izq, pyIzq, pxDer, pyIzq);
        nV = 1;
        lineDDA(x1Izq, pyIzq, x1Izq, pyDer);
        lineDDA(x1Izq, pyDer, pxDer, pyDer);
        lineDDA(pxDer, pyDer, x1Izq, pyIzq);

    }

    public static void triangulo(ArrayList posisiones) {
        int xA, yA, xb, yb, xc, yc;
        xA = (int) posisiones.get(0);
        yA = (int) posisiones.get(1);
        xb = (int) posisiones.get(2);
        yb = (int) posisiones.get(3);
        xc = (int) posisiones.get(4);
        yc = (int) posisiones.get(5);
        lineDDA(xA, yA, xb, yb);
        lineDDA(xA, yA, xc, yc);
        lineDDA(xb, yb, xc, yc);
    }
}
