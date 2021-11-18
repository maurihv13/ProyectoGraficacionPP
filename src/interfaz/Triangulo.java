/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transformaciones;


public class Triangulo {
    Punto puntos[];
    public Triangulo(Punto p1, Punto p2, Punto p3){
        puntos = new Punto[3];
        puntos[0] = p1;
        puntos[1] = p2;
        puntos[2] = p3;
    }
    
    public Linea[] getLineas(){
        Linea[] lineas = new Linea[3];
        for(int i=0;i<3;i++){
            lineas[i] = new Linea(puntos[i], puntos[(i+1)%3]);
        }
        return lineas;
    }
    public void translacion(int sx, int sy){
        for(Punto p : puntos){
            p.translacion(sx, sy);
        }
    }
    public void escalacion(float escx, float escy){ 
        Punto p1 = puntos[0];
        int Tx = p1.x;
        int Ty = p1.y;
        for(Punto p : puntos){
            p.escalar(escx, escy, Tx, Ty);
        }
    }
    public void rotacion(int ang){
        double rad = Math.toRadians(ang);
        double seno = Math.sin(rad);
        double coseno = Math.cos(rad);
        Punto p1 = puntos[0];
        int Tx = p1.x;
        int Ty = p1.y;
        this.translacion(-Tx, -Ty);
        for(Punto p : puntos){
            p.rotacion(seno,coseno,Tx,Ty);
        }
        this.translacion(Tx, Ty);
    }
    
}
