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
        
        circ.translacion(50,0);
        
        circ.escalacion(2f, 1);
        
        c = Color.GREEN;
        panel.bresenham(circ, c);
        
        circ.elimEscala();
        c = Color.BLUE;
        panel.bresenham(circ, c);
        
        circ.escalacion(1.5f, 1.5f);
        //circ.acomodarPuntoEsc();
        panel.bresenham(circ, c);
        
        Punto p1, p2;
        p1 = new Punto (152,235);
        p2 = new Punto (237,145);
        Linea l = new Linea(p1, p2);
        
        panel.lineaAlg(l, c);
        
        l.translacion(0, 10);
        l.escalacion(2.0f, 2.0f);
        panel.lineaAlg(l, c);
        
        l.escalacion(1, 1);
        l.translacion(130, 96);
        panel.lineaAlg(l, c);
        
        
    }
}
