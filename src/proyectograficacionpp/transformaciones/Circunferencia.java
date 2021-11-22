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
public class Circunferencia extends Figura{
    Punto centro;
    int radio;
    public Circunferencia(Punto c, int r){
        centro = c;
        radio = r;
    }
    public void translacion(int sx, int sy){
        centro.translacion(sx, sy);
    }

    @Override
    public void escalacion(float escx, float escy) {
        radio = Math.round(radio*escx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rotacion(int ang) {
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
