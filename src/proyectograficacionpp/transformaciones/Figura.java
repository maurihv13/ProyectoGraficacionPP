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
public abstract class Figura {
    public abstract void translacion(int sx, int sy);
    public abstract void escalacion(float escx, float escy);
    public abstract void rotacion(int ang);
}
