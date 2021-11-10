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
public class Punto {
    int x, y;
    int xResp, yResp;
    public Punto(int x, int y){
        this.x = this.xResp = x;
        this.y = this.yResp = y;
    }
    public void translacion(int sx, int sy){
        x += sx;
        y += sy;
    }
    public void escalar(float escx, float escy, int Tx, int Ty){
        x = (int) Math.round(x * escx - Tx * escx + Tx);
        y = (int) Math.round(y * escy - Ty * escy + Ty);
    }
    
    public void rotacion(double sen, double cos, int Tx, int Ty){
        x = (int) Math.round(x * cos + y * sen - Tx * cos - Ty * sen + Tx); 
        y = (int) Math.round(-x * sen + y * cos + Tx * sen - Ty * cos + Ty);
    }
}
