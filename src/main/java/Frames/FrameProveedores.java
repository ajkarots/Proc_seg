/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frames;

/**
 *
 * @author pc
 */
public class FrameProveedores extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public FrameProveedores() {
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
        BuscarProveedorbtn = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        buscadorProveedores = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();
        editarProveedorbtn = new javax.swing.JButton();
        eliminiarProveedorbtn = new javax.swing.JButton();
        AgregarProveedorbtn = new javax.swing.JButton();
        rucproveedortxt = new javax.swing.JTextField();
        title1 = new javax.swing.JLabel();
        nombreProveedor = new javax.swing.JTextField();
        title2 = new javax.swing.JLabel();
        telefonoProveedor = new javax.swing.JTextField();
        title3 = new javax.swing.JLabel();
        direccionProveedor = new javax.swing.JTextField();
        title4 = new javax.swing.JLabel();
        title5 = new javax.swing.JLabel();
        title6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codigoProveedortxt = new javax.swing.JTextField();
        title7 = new javax.swing.JLabel();
        ProvinciaProveedortxt = new javax.swing.JComboBox<>();
        CiudadProveedortxt = new javax.swing.JComboBox<>();
        Actualizarbtn = new javax.swing.JButton();

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(809, 490));
        bg.setPreferredSize(new java.awt.Dimension(809, 490));

        BuscarProveedorbtn.setBackground(new java.awt.Color(153, 0, 0));
        BuscarProveedorbtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        BuscarProveedorbtn.setForeground(new java.awt.Color(255, 255, 255));
        BuscarProveedorbtn.setText("Buscar");
        BuscarProveedorbtn.setBorderPainted(false);
        BuscarProveedorbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BuscarProveedorbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarProveedorbtnActionPerformed(evt);
            }
        });

        title.setText("PROVEEDOR");

        buscadorProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorProveedoresActionPerformed(evt);
            }
        });

        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO PROVEEDOR", "RUC", "NOMBRE", "TELEFONO", "DIRECCION", "PROVINCIA", "CIUDAD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaProveedores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tablaProveedores);

        editarProveedorbtn.setBackground(new java.awt.Color(153, 0, 0));
        editarProveedorbtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        editarProveedorbtn.setForeground(new java.awt.Color(255, 255, 255));
        editarProveedorbtn.setText("Editar");
        editarProveedorbtn.setBorderPainted(false);

        eliminiarProveedorbtn.setBackground(new java.awt.Color(153, 0, 0));
        eliminiarProveedorbtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        eliminiarProveedorbtn.setForeground(new java.awt.Color(255, 255, 255));
        eliminiarProveedorbtn.setText("Eliminar");
        eliminiarProveedorbtn.setBorderPainted(false);
        eliminiarProveedorbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminiarProveedorbtnActionPerformed(evt);
            }
        });

        AgregarProveedorbtn.setBackground(new java.awt.Color(153, 0, 0));
        AgregarProveedorbtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        AgregarProveedorbtn.setForeground(new java.awt.Color(255, 255, 255));
        AgregarProveedorbtn.setText("Agregar");
        AgregarProveedorbtn.setBorderPainted(false);

        rucproveedortxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rucproveedortxtActionPerformed(evt);
            }
        });

        title1.setText("RUC");

        nombreProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreProveedorActionPerformed(evt);
            }
        });

        title2.setText("NOMBRE");

        telefonoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoProveedorActionPerformed(evt);
            }
        });

        title3.setText("TELEFONO");

        direccionProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionProveedorActionPerformed(evt);
            }
        });

        title4.setText("DIRECCION");

        title5.setText("PROVINCIA");

        title6.setText("CIUDAD");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel3.setText("PROVEEDORES");

        codigoProveedortxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoProveedortxtActionPerformed(evt);
            }
        });

        title7.setText("CODIGO PROVEEDOR");

        ProvinciaProveedortxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CiudadProveedortxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Actualizarbtn.setBackground(new java.awt.Color(153, 0, 0));
        Actualizarbtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Actualizarbtn.setForeground(new java.awt.Color(255, 255, 255));
        Actualizarbtn.setText("Actualizar");
        Actualizarbtn.setBorderPainted(false);
        Actualizarbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Actualizarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editarProveedorbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eliminiarProveedorbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Actualizarbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buscadorProveedores, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(6, 6, 6)
                                .addComponent(BuscarProveedorbtn)))
                        .addGap(43, 43, 43)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(title1)
                                    .addComponent(rucproveedortxt, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(title2)
                                    .addComponent(nombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(title3)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(telefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(AgregarProveedorbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(title4)
                                    .addComponent(direccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(title5)
                                    .addComponent(ProvinciaProveedortxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(title6)
                                        .addGap(69, 69, 69))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                        .addComponent(CiudadProveedortxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(title7)
                                    .addComponent(codigoProveedortxt, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(102, Short.MAX_VALUE))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(telefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AgregarProveedorbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(title2)
                            .addComponent(title3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addComponent(title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscadorProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscarProveedorbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addComponent(title1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rucproveedortxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(title5)
                            .addComponent(title6)
                            .addComponent(title4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(title7))
                        .addGap(10, 10, 10)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(direccionProveedor)
                            .addComponent(codigoProveedortxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(ProvinciaProveedortxt)
                            .addComponent(CiudadProveedortxt)))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Actualizarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editarProveedorbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminiarProveedorbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarProveedorbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarProveedorbtnActionPerformed

    }//GEN-LAST:event_BuscarProveedorbtnActionPerformed

    private void buscadorProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorProveedoresActionPerformed

    private void eliminiarProveedorbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminiarProveedorbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminiarProveedorbtnActionPerformed

    private void rucproveedortxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rucproveedortxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rucproveedortxtActionPerformed

    private void nombreProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreProveedorActionPerformed

    private void telefonoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoProveedorActionPerformed

    private void direccionProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionProveedorActionPerformed

    private void codigoProveedortxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoProveedortxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoProveedortxtActionPerformed

    private void ActualizarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActualizarbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Actualizarbtn;
    public javax.swing.JButton AgregarProveedorbtn;
    public javax.swing.JButton BuscarProveedorbtn;
    public javax.swing.JComboBox<String> CiudadProveedortxt;
    public javax.swing.JComboBox<String> ProvinciaProveedortxt;
    public javax.swing.JPanel bg;
    public javax.swing.JTextField buscadorProveedores;
    public javax.swing.JTextField codigoProveedortxt;
    public javax.swing.JTextField direccionProveedor;
    public javax.swing.JButton editarProveedorbtn;
    public javax.swing.JButton eliminiarProveedorbtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField nombreProveedor;
    public javax.swing.JTextField rucproveedortxt;
    public javax.swing.JTable tablaProveedores;
    public javax.swing.JTextField telefonoProveedor;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    private javax.swing.JLabel title4;
    private javax.swing.JLabel title5;
    private javax.swing.JLabel title6;
    private javax.swing.JLabel title7;
    // End of variables declaration//GEN-END:variables
}
