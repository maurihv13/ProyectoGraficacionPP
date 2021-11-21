/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectograficacionpp.transformaciones;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author MAURICIO
 */
public class GraficaBresenham {
    public static void main(String[] args) {
        int width = 640;
        int height = 480;
        JFrame frame = new JFrame("Algoritmo Bresenham");

        DirectDrawDemo panel = new DirectDrawDemo(width, height);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int x, y, r;
        Color c = Color.RED;
        /*   Parametros de entrada   */
        x = 235; y = 115; r = 85;
        Punto centro = new Punto(235,115);
        Circunferencia circ = new Circunferencia(centro, r);
        panel.bresenham(circ, c);
        
        //panel.fillCanvas(Color.WHITE); // Limpiando
        
        //circ.translacion(50,0);
        
        circ.escalacion(0.5f);
        
        c = Color.GREEN;
        panel.bresenham(circ, c);
        
        c = Color.BLUE;
        panel.bresenham(circ, c);
        
        circ.escalacion(1.5f);
        //circ.acomodarPuntoEsc();
        panel.bresenham(circ, c);
        
        /*   Pruebas con transformaciones   */
        Punto p1, p2, p3, p4;
        p1 = new Punto (152,235);
        p2 = new Punto (237,145);
        Linea l = new Linea(p1, p2);
        
        panel.lineaAlg(l, c);
        
        l.translacion(0, 10);
        l.escalacion(2.0f, 2.0f);
        panel.lineaAlg(l, c);
        
        
        l.escalacion(0.5f, 0.5f);
        l.translacion(0, 15);
        panel.lineaAlg(l, c);
        
        l.rotacion(-12);
        panel.lineaAlg(l, c);
        
        l.rotacion(-12);
        panel.lineaAlg(l, c);
        
        c = Color.GREEN;
        
        /*   Pruebas con triangulos   */
        p1 = new Punto (170,69);
        p2 = new Punto (80,269);        
        p3 = new Punto (53,142);
        
        Triangulo trian = new Triangulo(p1, p2, p3);
        
        panel.triangulo(trian, c);
        
        trian.rotacion(15);
        panel.triangulo(trian, c);
        
        trian.escalacion(1.5f,1.5f);
        panel.triangulo(trian, c);
        
        trian.translacion(154, 24);
        panel.triangulo(trian, c);
        
        /*   Pruebas con cuadrados   */
        p4 = new Punto(203,178);
        int largoLado = 100;
        Cuadrado cuad = new Cuadrado(p4, largoLado);
        c = Color.MAGENTA;
        panel.limpiarPant();
        
        
        Linea l1 = new Linea(new Punto(10,50),new Punto(10,90));
        
        panel.lineaAlg(l1, c);
        
        panel.cuadrado(cuad, c);
        
        panel.limpiarPant();
        
        Rectangulo r1 = new Rectangulo(new Punto(30,30), new Punto(140,150));
        panel.rectangulo(r1, c);
        
    }
}
