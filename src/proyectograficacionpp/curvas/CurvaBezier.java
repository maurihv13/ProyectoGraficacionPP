/*
 * Programado por Gustavo Zimbrón
 * www.zimbronapps.com 
 */
 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CurvaBezier extends javax.swing.JFrame {

    ArrayList<Double> px = new ArrayList();
    ArrayList<Double> py = new ArrayList();
    int ancho, alto, escala;

    public CurvaBezier() {
        initComponents();
        pre_grafica();
    }

    private void pre_grafica() {
        ancho = Integer.valueOf(fancho.getText());
        alto = Integer.valueOf(falto.getText());
        escala = Integer.valueOf(fescala.getText());
        BufferedImage picture
                = new BufferedImage(ancho * escala,
                        alto * escala, BufferedImage.TYPE_INT_RGB);

        Graphics g = picture.getGraphics();

        g = pinta_cuadricula(g);
        g = pinta_puntos(g, true);
        labelshow.setIcon(new ImageIcon(picture));

    }

    private Graphics pinta_cuadricula(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, ancho * escala, alto * escala);
        g.setColor(new Color(0, 0, 0, 0.1f));

        for (int i = escala; i <= ancho * escala; i += escala) {
            g.fillRect(i, 0, 1, alto * escala);
        }
        for (int i = escala; i <= alto * escala; i += escala) {
            g.fillRect(0, i, ancho * escala, 1);
        }
        return g;
    }

    private Graphics pinta_puntos(Graphics g, boolean dibuja_poligono) {
        // dibujando puntos de anclaje
        g.setColor(Color.blue);  
        Polygon poligono = new Polygon();
        for (int i = 0; i < px.size(); i++) {
            poligono.addPoint((int) (px.get(i) * escala), (int) (alto * escala - py.get(i) * escala));
            g.fillOval((int) (px.get(i) * escala - (0.05 * escala)),
                    (int) (alto * escala - py.get(i) * escala - (0.05 * escala)),
                    (int) (0.1 * escala), (int) (0.1 * escala));
            g.drawString("Punto " + (i + 1),
                    (int) (px.get(i) * escala) + 5,
                    (int) (alto * escala - py.get(i) * escala) - 5);
        }
        g.setColor(Color.ORANGE);
        if (dibuja_poligono) {
            g.drawPolygon(poligono);
        }
        return g;
    }

    private void curvaBezier(int ancho, int alto, int escala, double parametro_t) {
        BufferedImage picture
                = new BufferedImage(ancho * escala, alto * escala, BufferedImage.TYPE_INT_RGB);

        Graphics g = picture.getGraphics();

        g = pinta_cuadricula(g);
        g = pinta_puntos(g, true);

        g.setColor(Color.red);
        double it = 0, fpx, fpy;
        while (it <= 1) {
            fpx = funcionParametrica(px, it) * escala;
            fpy = funcionParametrica(py, it) * escala;

            //System.out.println("t: "+it+" x:"+fpx/escala+" y:"+fpy/escala);
            g.fillRect((int) fpx, (int) (alto * escala - fpy), 1, 1);

            it += parametro_t;// / escala;
        }

        labelshow.setIcon(new ImageIcon(picture));

    }

    private double funcionParametrica(ArrayList<Double> puntos, double t) {
        double restemp = 0;

        for (int i = 0; i < puntos.size(); i++) {
            restemp
                    += puntos.get(i) * combinaciones(puntos.size() - 1, i)
                    * Math.pow(t, i) * Math.pow((1 - t),
                    (puntos.size() - 1 - i));
        }

        return restemp;
    }

    private int factorial(int numero) {
        if (numero > 1) {
            return numero * factorial(numero - 1);
        } else {
            return 1;
        }
    }

    private int combinaciones(int n, int m) {
        return factorial(n) / (factorial(m) * factorial(n - m));
    }

    private void rellenar_tabla() {
        DefaultTableModel tabla_modelo
                = (DefaultTableModel) tablapuntos.getModel();
        tabla_modelo.setRowCount(0);
        for (int i = 0; i < px.size(); i++) {
            tabla_modelo.addRow(new Object[]{i + 1, px.get(i), py.get(i)});
        }
        pre_grafica();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        labelshow = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_crear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fancho = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        falto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        pt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        fescala = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablapuntos = new javax.swing.JTable();
        tf_punto = new javax.swing.JTextField();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Curva de Bezier");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Curva de Bezier");

        labelshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane1.setViewportView(labelshow);

        btn_crear.setText("Crear");
        btn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearActionPerformed(evt);
            }
        });

        jLabel2.setText("Agregar Punto Anclaje:");

        jLabel12.setText("Ancho:");

        fancho.setText("7");

        jLabel13.setText("Alto:");

        falto.setText("6");

        jLabel15.setText("Parámetro t:");

        pt.setText("0.001");

        jLabel16.setText("Escala 1 a px");

        fescala.setText("50");

        jLabel4.setText("X,Y:");

        tablapuntos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Punto", "X", "Y"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablapuntos.setMaximumSize(new java.awt.Dimension(75, 64));
        tablapuntos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablapuntos.getTableHeader().setReorderingAllowed(false);
        tablapuntos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablapuntosKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tablapuntos);
        if (tablapuntos.getColumnModel().getColumnCount() > 0) {
            tablapuntos.getColumnModel().getColumn(0).setResizable(false);
            tablapuntos.getColumnModel().getColumn(0).setPreferredWidth(25);
            tablapuntos.getColumnModel().getColumn(1).setResizable(false);
            tablapuntos.getColumnModel().getColumn(1).setPreferredWidth(25);
            tablapuntos.getColumnModel().getColumn(2).setResizable(false);
            tablapuntos.getColumnModel().getColumn(2).setPreferredWidth(25);
        }

        tf_punto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_puntoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_puntoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_puntoKeyTyped(evt);
            }
        });

        btn_agregar.setText("OK");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar punto");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_crear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fancho))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(falto))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pt))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fescala))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_punto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_agregar)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_eliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_punto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_agregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(pt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(fancho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(falto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(fescala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_crear)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearActionPerformed
        clic_crear();
    }//GEN-LAST:event_btn_crearActionPerformed


    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        clic_agregar();
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        clic_eliminar();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void tf_puntoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_puntoKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_tf_puntoKeyReleased

    private void tf_puntoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_puntoKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_tf_puntoKeyTyped

    private void tf_puntoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_puntoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            clic_agregar();
        }
    }//GEN-LAST:event_tf_puntoKeyPressed

    private void tablapuntosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablapuntosKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 127) {
            clic_eliminar();
        }
    }//GEN-LAST:event_tablapuntosKeyPressed

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
            java.util.logging.Logger.getLogger(CurvaBezier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurvaBezier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurvaBezier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurvaBezier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurvaBezier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_crear;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JTextField falto;
    private javax.swing.JTextField fancho;
    private javax.swing.JTextField fescala;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelshow;
    private javax.swing.JTextField pt;
    private javax.swing.JTable tablapuntos;
    private javax.swing.JTextField tf_punto;
    // End of variables declaration//GEN-END:variables

    private void clic_crear() {
        if (px.size() < 2) {
            JOptionPane.showMessageDialog(null, "Se requieren al menos 2 puntos de anclaje");
        } else {
            int ancho, alto, escala;
            double parametrot;

            ancho = (fancho.getText().isEmpty()) ? 0 : Integer.parseInt(fancho.getText());
            alto = (falto.getText().isEmpty()) ? 0 : Integer.parseInt(falto.getText());
            escala = (fescala.getText().isEmpty()) ? 0 : Integer.parseInt(fescala.getText());
            parametrot = Double.parseDouble(pt.getText());
            rellenar_tabla();
            curvaBezier(ancho, alto, escala, parametrot);
        }
    }

    private void clic_agregar() {
        // TODO add your handling code here:
        String campo_add = tf_punto.getText().trim();
        Pattern p = Pattern.compile("([0-9]+[.]?[0-9]?),([0-9]+[.]?[0-9]?)");
        Matcher m = p.matcher(campo_add);
        if (m.matches()) {
            tf_punto.setText("");
            String[] res = m.group(0).split(",");
            px.add(Double.parseDouble(res[0]));
            py.add(Double.parseDouble(res[1]));
            rellenar_tabla();
        } else {
            JOptionPane.showMessageDialog(null, "Ingresa coordenadas válidas");
        }
    }

    private void clic_eliminar() {
        int seleccionado = tablapuntos.getSelectedRow();
        if (seleccionado >= 0) {
            px.remove(seleccionado);
            py.remove(seleccionado);
            rellenar_tabla();
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un punto de anclaje a eliminar!");
        }
    }
}