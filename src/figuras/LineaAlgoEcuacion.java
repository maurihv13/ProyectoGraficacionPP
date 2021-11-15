/*
 * 
* 
 */
package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Fred
 */
public class LineaAlgoEcuacion extends JFrame{
    private static int x0,x1,y0,y1;
    private static Color c;
    public LineaAlgoEcuacion(int x0,int x1,int y0,int y1,Color c){
        this.x0=x0;
        this.x1=x1;
        this.y0=y0;
        this.y1=y1;
        this.c=c;
        this.setBounds(400, 400, 600, 600);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aniadir();
    }
    
    /*
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
        
    }*/
    public void aniadir(){
        JPanel pan= new JPanel();
        this.add(pan);
        this.pack();
        
    }
    public void paint(Graphics g){
        int dx=x1-x0;
        int dy=y1-y0;
        float m=0,b=0;
        g.setColor(c);
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
