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
    public Circunferencia(Punto c, int r){
        centro = c;
        radio = r;
    }
    public void translacion(int sx, int sy){
        centro.translacion(sx, sy);
    }
    public void escalacion(float escx){ //Escalar hace perdida de calidad en imagen
        radio = Math.round(radio*escx);
        //this.acomodarPuntoEsc();
    }
    
}
