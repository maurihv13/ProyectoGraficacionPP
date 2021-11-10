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
public class Circunferencia {
    Punto centro;
    int radio;
    float escalax;
    float escalay;
    public Circunferencia(Punto c, int r){
        centro = c;
        radio = r;
        escalax = 1;
        escalay = 1;
    }
    public void translacion(int sx, int sy){
        centro.translacion(sx, sy);
    }
    public void escalacion(float sx, float sy){ //Escalar hace perdida de calidad en imagen
        escalax *= sx;
        escalay *= sy;
        //this.acomodarPuntoEsc();
    }
    public void elimEscala(){
        escalax = 1;
        escalay = 1;
    }
    
}
