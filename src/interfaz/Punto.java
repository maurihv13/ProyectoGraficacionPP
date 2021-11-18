/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transformaciones;

/**
 *
 * @author Juan Pablo
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
        x = (int) Math.round(x * cos - y * sen); 
        y = (int) Math.round(x * sen + y * cos);
    }
}
