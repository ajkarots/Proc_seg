/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frames;

/**
 *
 * @author pc
 */
public class FrameClientes extends javax.swing.JPanel {

    /**
     * Creates new form clientesw
     */
    public FrameClientes() {
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
        buscarClientebtn = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        buscadorClientetxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        editarClientebtn = new javax.swing.JButton();
        eliminarClientebtn = new javax.swing.JButton();
        guardarClientebtn = new javax.swing.JButton();
        nombreClientetxt = new javax.swing.JTextField();
        title1 = new javax.swing.JLabel();
        cedulaClientetxt = new javax.swing.JTextField();
        title2 = new javax.swing.JLabel();
        direccionClientetxt = new javax.swing.JTextField();
        title3 = new javax.swing.JLabel();
        title4 = new javax.swing.JLabel();
        title5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ProvinciaBox = new javax.swing.JComboBox<>();
        CiudadBox = new javax.swing.JComboBox<>();
        ActualizarClientebtn = new javax.swing.JButton();

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(809, 544));

        buscarClientebtn.setBackground(new java.awt.Color(153, 0, 0));
        buscarClientebtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        buscarClientebtn.setForeground(new java.awt.Color(255, 255, 255));
        buscarClientebtn.setText("Buscar");
        buscarClientebtn.setBorderPainted(false);
        buscarClientebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buscarClientebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClientebtnActionPerformed(evt);
            }
        });

        title.setText("NOMBRE CLIENTE");

        buscadorClientetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorClientetxtActionPerformed(evt);
            }
        });

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CEDULA", "NOMBRE", "DIRECCION", "PROVINCIA", "CIUDAD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tablaClientes);

        editarClientebtn.setBackground(new java.awt.Color(153, 0, 0));
        editarClientebtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        editarClientebtn.setForeground(new java.awt.Color(255, 255, 255));
        editarClientebtn.setText("Editar");
        editarClientebtn.setBorderPainted(false);
        editarClientebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarClientebtnActionPerformed(evt);
            }
        });

        eliminarClientebtn.setBackground(new java.awt.Color(153, 0, 0));
        eliminarClientebtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        eliminarClientebtn.setForeground(new java.awt.Color(255, 255, 255));
        eliminarClientebtn.setText("Eliminar");
        eliminarClientebtn.setBorderPainted(false);
        eliminarClientebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarClientebtnActionPerformed(evt);
            }
        });

        guardarClientebtn.setBackground(new java.awt.Color(153, 0, 0));
        guardarClientebtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        guardarClientebtn.setForeground(new java.awt.Color(255, 255, 255));
        guardarClientebtn.setText("Agregar");
        guardarClientebtn.setBorderPainted(false);

        nombreClientetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreClientetxtActionPerformed(evt);
            }
        });

        title1.setText("NOMBRE");

        cedulaClientetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaClientetxtActionPerformed(evt);
            }
        });
        cedulaClientetxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedulaClientetxtKeyTyped(evt);
            }
        });

        title2.setText("CEDULA");

        direccionClientetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionClientetxtActionPerformed(evt);
            }
        });

        title3.setText("DIRECCION");

        title4.setText("PROVINCIA");

        title5.setText("CIUDAD");

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel2.setText("CLIENTES");

        ActualizarClientebtn.setBackground(new java.awt.Color(153, 0, 0));
        ActualizarClientebtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        ActualizarClientebtn.setForeground(new java.awt.Color(255, 255, 255));
        ActualizarClientebtn.setText("Actualizar");
        ActualizarClientebtn.setBorderPainted(false);
        ActualizarClientebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ActualizarClientebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarClientebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(editarClientebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminarClientebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buscadorClientetxt, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buscarClientebtn))
                            .addComponent(ActualizarClientebtn))
                        .addGap(18, 18, 18)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreClientetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(title1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(title2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cedulaClientetxt, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                                .addGap(14, 14, 14)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(direccionClientetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(title3))
                                .addGap(18, 18, 18)
                                .addComponent(guardarClientebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(title4)
                                    .addComponent(ProvinciaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CiudadBox, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(title5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)))))
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(direccionClientetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(guardarClientebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cedulaClientetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombreClientetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(bgLayout.createSequentialGroup()
                                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buscadorClientetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buscarClientebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(bgLayout.createSequentialGroup()
                                    .addComponent(title4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ProvinciaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CiudadBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(bgLayout.createSequentialGroup()
                                    .addComponent(title5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44)))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(title3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ActualizarClientebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarClientebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarClientebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscarClientebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClientebtnActionPerformed

    }//GEN-LAST:event_buscarClientebtnActionPerformed

    private void buscadorClientetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorClientetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorClientetxtActionPerformed

    private void eliminarClientebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarClientebtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarClientebtnActionPerformed

    private void nombreClientetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreClientetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreClientetxtActionPerformed

    private void cedulaClientetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaClientetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaClientetxtActionPerformed

    private void direccionClientetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionClientetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionClientetxtActionPerformed

    private void ActualizarClientebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarClientebtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActualizarClientebtnActionPerformed

    private void editarClientebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarClientebtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarClientebtnActionPerformed

    private void cedulaClientetxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaClientetxtKeyTyped
        if (this.cedulaClientetxt.getText().length()>=10) {
            evt.consume();
        }
    }//GEN-LAST:event_cedulaClientetxtKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton ActualizarClientebtn;
    public javax.swing.JComboBox<String> CiudadBox;
    public javax.swing.JComboBox<String> ProvinciaBox;
    private javax.swing.JPanel bg;
    public javax.swing.JTextField buscadorClientetxt;
    public javax.swing.JButton buscarClientebtn;
    public javax.swing.JTextField cedulaClientetxt;
    public javax.swing.JTextField direccionClientetxt;
    public javax.swing.JButton editarClientebtn;
    public javax.swing.JButton eliminarClientebtn;
    public javax.swing.JButton guardarClientebtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField nombreClientetxt;
    public javax.swing.JTable tablaClientes;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    private javax.swing.JLabel title4;
    private javax.swing.JLabel title5;
    // End of variables declaration//GEN-END:variables
}
