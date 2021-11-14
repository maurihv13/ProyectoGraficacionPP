/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

/**
 *aun no funciona
 * @author Fred
 */
public class BresenhamLinea {
   
    public void algoritmo(int x0,int y0,int x1,int y1){
        int dx,dy,contad,pasox,pasoy,x,y,p,incE,incNE;
        int espacio=0;
        int segment=0;
        boolean lleno;
        dx=x1-x0;
        dy=y1-y0;
        contad=0;
        lleno=false;
        pasox=1;
        pasoy=1;
        if (dx<0) {
            dx=-dx;
            pasox=-1;
        }else{
            pasoy=1;
        }
        if(dy<0){
            dy=-dy;
            pasoy=-1;
        }else{
            pasoy=1;
        }
        x=x0;
        y=y0;
        
        if(dx>dy){
            p=2*dy-dx;
            incE=2*dy;
            incNE=2*(dy-dx);
            
            while(x!=x1){
                x=x+pasox;
                if(p<0){
                    p=p+incE;
                }else{
                    y=y+pasoy;
                    p=p+incNE;
                    
                }
                if(espacio!=0){
                    if(lleno){
                        if(contad<segment){
                            boolean arrib=true;
                            //aqui pinta
                        }
                    }else{}
                }else{}
            }
        }else{}
        
    }
    
}
