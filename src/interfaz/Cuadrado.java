/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transformaciones;

public class Cuadrado {
    private Punto[] puntos;
    private Punto pivote;
    public Cuadrado(Punto p, int tamLado){
        int dist = tamLado / 2;
        puntos = new Punto[4];
        this.crearPuntos(dist, p);
        pivote = p;
    }
    private void crearPuntos(int dist, Punto p){
        int x, y;
        x = p.x; y = p.y;
        puntos[0] = new Punto(x-dist, y-dist);
        puntos[1] = new Punto(x+dist, y-dist);
        puntos[2] = new Punto(x+dist, y+dist);
        puntos[3] = new Punto(x-dist, y+dist);
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
