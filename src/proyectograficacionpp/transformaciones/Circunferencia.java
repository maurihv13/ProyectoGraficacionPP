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
        centro.x += sx;
        centro.y += sy;
    }
    public void escalacion(float sx, float sy){
        escalax *= sx;
        escalay *= sy;
        //this.acomodarPuntoEsc();
    }
    public void elimEscala(){
        escalax = 1;
        escalay = 1;
    }
    
    public void acomodarPuntoEsc(){ //No Funciona realmente para acomodar la escalacion
        float difx, dify;
        difx = 1-escalax;
        dify = 1-escalay;
        centro.x += Math.round(centro.x * difx);
        centro.y += Math.round(centro.y * dify);
    }
}
