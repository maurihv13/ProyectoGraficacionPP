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
public class Linea {
    Punto p1, p2;
    float escX,escY;
    public Linea(Punto p1, Punto p2){
        this.p1 = p1;
        this.p2 = p2;
        escX = 1; 
        escY = 1;
    }
    public void translacion(int sx, int sy){
        p1.translacion(sx, sy);
        p2.translacion(sx, sy);
    }
    public void escalacion(float sx, float sy){ 
        escX = sx;
        escY = sy;
    }
}
