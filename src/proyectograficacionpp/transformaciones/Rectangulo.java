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
public class Rectangulo {
    private Punto[] puntos;
    private Punto pivote;
    public Rectangulo(Punto pSupIzq, Punto pInfDer){
        puntos = new Punto[4];
        this.crearPuntos(pSupIzq,pInfDer);
    }
    private void crearPuntos(Punto pSupIzq, Punto pInfDer){
        int x0,y0,x1,y1;
        int distX,distY;
        x0 = pSupIzq.x; y0 = pSupIzq.y;
        x1 = pInfDer.x; y1 = pInfDer.y;
        distX = (x1 - x0)/2;
        distY = (y1 - y0)/2;
        puntos[0] = new Punto(x0,y0);
        puntos[1] = new Punto(x1,y0);
        puntos[2] = new Punto(x1,y1);
        puntos[3] = new Punto(x0,y1);
        pivote = new Punto(distX,distY);
    }
    
    public Linea[] getLineas(){
        Linea[] lineas = new Linea[4];
        for(int i=0;i<4;i++){
            lineas[i] = new Linea(puntos[i], puntos[(i+1)%4]);
        }
        return lineas;
    }
    
    public void translacion(int sx, int sy){
        for(Punto p : puntos){
            p.translacion(sx, sy);
        }
    }
    
    public void escalacion(float escx, float escy){ 
        /* Trabajo con pivote */
        int Tx = pivote.x;
        int Ty = pivote.y;
        for(Punto p : puntos){
            p.escalar(escx, escy, Tx, Ty);
        }
    }
    
    public void rotacion(int ang){
        double rad = Math.toRadians(ang);
        double seno = Math.sin(rad);
        double coseno = Math.cos(rad);
        /* Trabajo con pivote */
        int Tx = pivote.x;
        int Ty = pivote.y;
        
        this.translacion(-Tx, -Ty);
        for(Punto p : puntos){
            p.rotacion(seno,coseno,Tx,Ty);
        }
        this.translacion(Tx, Ty);
        
    }
}
