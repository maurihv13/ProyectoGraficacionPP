/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectograficacionpp.figuras;
import java.awt.Color;
import proyectograficacionpp.transformaciones.*;
/**
 *
 * @author USUARIO
 */
public class pruebaDibujo extends javax.swing.JFrame {
    private DirectDrawDemo dir;
    private Linea l;
    private Punto p1,p2,p3,p4;
    private int px1,py1,px2,py2,x3,y3,x4,y4,nroPuntos;
    
    /**
     * Creates new form pruebaDibujo
     */
    
    public pruebaDibujo() {
        initComponents();
        int x=panelDibujo.getLocation().x;
        int y=panelDibujo.getLocation().y;
        int anch=panelDibujo.getSize().width;
        int alt=panelDibujo.getSize().height;
        dir=new DirectDrawDemo(anch, alt);
        nroPuntos=0;
        px1=-1;
        px2=-1;
        py1=-1;
        py2=-1;
        x3=-1;
        y3=-1;
        x4=-1;
        y4=-1;
        panelDibujo.setOpaque(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        panelDibujo = new javax.swing.JPanel();
        btnLinea = new javax.swing.JButton();
        btnCuadrado = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnRectan = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelDibujo.setBackground(new java.awt.Color(255, 255, 255));
        panelDibujo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelDibujoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelDibujoLayout = new javax.swing.GroupLayout(panelDibujo);
        panelDibujo.setLayout(panelDibujoLayout);
        panelDibujoLayout.setHorizontalGroup(
            panelDibujoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );
        panelDibujoLayout.setVerticalGroup(
            panelDibujoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );

        btnLinea.setText("linea");
        btnLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineaActionPerformed(evt);
            }
        });

        btnCuadrado.setText("cuadrado");
        btnCuadrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuadradoActionPerformed(evt);
            }
        });

        jButton1.setText("triangulo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnRectan.setText("rectangulo");
        btnRectan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRectanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(panelDibujo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCuadrado)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnLinea)
                        .addGap(18, 18, 18)
                        .addComponent(btnRectan)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnCuadrado))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLinea)
                    .addComponent(btnRectan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(panelDibujo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelDibujoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDibujoMouseClicked
            // esto escucha cuando presiono el mouse
           
            nroPuntos=nroPuntos+1;
            switch(nroPuntos){
                case 1: px1=evt.getX();
                        py1=evt.getY();
                        System.out.println(px1 +" "+ py1);
                        break;
                case 2: px2=evt.getX();
                        py2=evt.getY();
                        System.out.println(px2 +" "+ py2);
                        break;
                case 3:x3=evt.getX();
                       y3=evt.getY();
                       break;
                case 4:x4=evt.getX();
                       y4=evt.getY();
                       break;
                default:
                    break;
            }
//            if(px1!=-1){
//                px2=evt.getX();
//                py2=evt.getY();
//                if(px2!=-1){
//                    x3=evt.getX();
//                    y3=evt.getY();
//                    if(x3!=-1){
//                        x4=evt.getX();
//                    }
//                }
//            }else{}
    }//GEN-LAST:event_panelDibujoMouseClicked

    private void btnCuadradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuadradoActionPerformed
        
    }//GEN-LAST:event_btnCuadradoActionPerformed

    private void btnRectanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRectanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRectanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineaActionPerformed
        p1=new Punto(px1, py1);
        p2=new Punto(px2, py2);
        l=new Linea(p1, p2);
        dir.lineaDDA(l, Color.red);
    }//GEN-LAST:event_btnLineaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pruebaDibujo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pruebaDibujo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pruebaDibujo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pruebaDibujo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pruebaDibujo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCuadrado;
    private javax.swing.JButton btnLinea;
    private javax.swing.JButton btnRectan;
    private javax.swing.JButton jButton1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JPanel panelDibujo;
    // End of variables declaration//GEN-END:variables
}
