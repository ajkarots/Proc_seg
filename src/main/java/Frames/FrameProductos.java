/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frames;

/**
 *
 * @author pc
 */
public class FrameProductos extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public FrameProductos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        buscarProducto = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        buscadorProductos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        editarProducto = new javax.swing.JButton();
        eliminarProducto = new javax.swing.JButton();
        guardarProducto = new javax.swing.JButton();
        buscadorProductos1 = new javax.swing.JTextField();
        title1 = new javax.swing.JLabel();
        buscadorProductos2 = new javax.swing.JTextField();
        title2 = new javax.swing.JLabel();
        buscadorProductos3 = new javax.swing.JTextField();
        title3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(809, 490));
        bg.setPreferredSize(new java.awt.Dimension(809, 490));

        buscarProducto.setBackground(new java.awt.Color(153, 0, 0));
        buscarProducto.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        buscarProducto.setForeground(new java.awt.Color(255, 255, 255));
        buscarProducto.setText("Buscar");
        buscarProducto.setBorderPainted(false);
        buscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProductoActionPerformed(evt);
            }
        });

        title.setText("CODIGO PRODUCTO");

        buscadorProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorProductosActionPerformed(evt);
            }
        });

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "CODIGO PROVEEDOR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tablaProductos);

        editarProducto.setBackground(new java.awt.Color(153, 0, 0));
        editarProducto.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        editarProducto.setForeground(new java.awt.Color(255, 255, 255));
        editarProducto.setText("Editar");
        editarProducto.setBorderPainted(false);

        eliminarProducto.setBackground(new java.awt.Color(153, 0, 0));
        eliminarProducto.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        eliminarProducto.setForeground(new java.awt.Color(255, 255, 255));
        eliminarProducto.setText("Eliminar");
        eliminarProducto.setBorderPainted(false);
        eliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProductoActionPerformed(evt);
            }
        });

        guardarProducto.setBackground(new java.awt.Color(153, 0, 0));
        guardarProducto.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        guardarProducto.setForeground(new java.awt.Color(255, 255, 255));
        guardarProducto.setText("Agregar");
        guardarProducto.setBorderPainted(false);

        buscadorProductos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorProductos1ActionPerformed(evt);
            }
        });

        title1.setText("CODIGO PRODUCTO");

        buscadorProductos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorProductos2ActionPerformed(evt);
            }
        });

        title2.setText("NOMBRE");

        buscadorProductos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorProductos3ActionPerformed(evt);
            }
        });

        title3.setText("CODIGO PROVEEDOR");

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel2.setText("PRODUCTOS");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(title))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(buscadorProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(560, 560, 560)
                                .addComponent(editarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(eliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(title2)
                                    .addComponent(buscadorProductos2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(title1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buscadorProductos1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(title3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buscadorProductos3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(guardarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(title)
                        .addGap(6, 6, 6)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscadorProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(20, 20, 20)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(title2)
                                .addGap(6, 6, 6)
                                .addComponent(buscadorProductos2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(title1)
                                .addGap(6, 6, 6)
                                .addComponent(buscadorProductos1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                        .addGap(8, 8, 8)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title3)
                        .addGap(2, 2, 2)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscadorProductos3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(guardarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarProductoActionPerformed

    }//GEN-LAST:event_buscarProductoActionPerformed

    private void buscadorProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorProductosActionPerformed

    private void eliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarProductoActionPerformed

    private void buscadorProductos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorProductos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorProductos1ActionPerformed

    private void buscadorProductos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorProductos2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorProductos2ActionPerformed

    private void buscadorProductos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorProductos3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorProductos3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    public javax.swing.JTextField buscadorProductos;
    public javax.swing.JTextField buscadorProductos1;
    public javax.swing.JTextField buscadorProductos2;
    public javax.swing.JTextField buscadorProductos3;
    public javax.swing.JButton buscarProducto;
    public javax.swing.JButton editarProducto;
    public javax.swing.JButton eliminarProducto;
    public javax.swing.JButton guardarProducto;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaProductos;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    // End of variables declaration//GEN-END:variables
}
