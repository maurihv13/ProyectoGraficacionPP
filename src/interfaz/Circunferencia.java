/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transformaciones;

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
