/*
 * 
* 
 */
package figuras;

import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author Fred
 */
public class LineaAlgoEcuacion extends JFrame{
    private static int x0,x1,y0,y1;
    public LineaAlgoEcuacion(){
        this.setBounds(500, 500, 400, 300);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("ingrese:");
        x0=sc.nextInt();
        y0=sc.nextInt();
        System.out.println("ingrese 3");
        x1=sc.nextInt();
        y1=sc.nextInt();
        System.out.println("ingrese:");
        LineaAlgoEcuacion ap=new LineaAlgoEcuacion();
        ap.setVisible(true);
        
    }
    public void paint(Graphics g){
        int dx=x1-x0;
        int dy=y1-y0;
        float m=0,b=0;
        if(dx!=0){
            m=(float)dy/(float)dx;
            b=y0-m*x0;
            if(x1>x0){
                dx=1;
            }else{
                dx=-1;
            }
            while(x0!=x1){
                x0 +=dx;
                y0 = Math.round(m*x0+b);
                g.drawLine(x0,y0,x0,y0);
            }
           //  
        }
    }
    
    
}
