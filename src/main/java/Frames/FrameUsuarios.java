/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frames;

/**
 *
 * @author JONATHAN
 */
public class FrameUsuarios extends javax.swing.JPanel {

    /**
     * Creates new form FrameUsuarios
     */
    public FrameUsuarios() {
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
        buscarUsuariobtn = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        buscadorUsuariotxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaUsuarios = new javax.swing.JTable();
        editarUsuariobtn = new javax.swing.JButton();
        eliminarUsuariobtn = new javax.swing.JButton();
        AgregarUsuariobtn = new javax.swing.JButton();
        nombreUsuariotxt = new javax.swing.JTextField();
        title1 = new javax.swing.JLabel();
        contraseñaUsuariotxt = new javax.swing.JTextField();
        title2 = new javax.swing.JLabel();
        title4 = new javax.swing.JLabel();
        boxCiudad = new javax.swing.JCheckBox();
        boxProvincia = new javax.swing.JCheckBox();
        boxFactura = new javax.swing.JCheckBox();
        boxCliente = new javax.swing.JCheckBox();
        boxCompras = new javax.swing.JCheckBox();
        boxCompra = new javax.swing.JCheckBox();
        boxProveedores = new javax.swing.JCheckBox();
        boxKardex = new javax.swing.JCheckBox();
        boxProductos = new javax.swing.JCheckBox();
        boxFacturas = new javax.swing.JCheckBox();
        boxUsuarios = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        Actualizarbtn = new javax.swing.JButton();

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(809, 544));

        buscarUsuariobtn.setBackground(new java.awt.Color(153, 0, 0));
        buscarUsuariobtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        buscarUsuariobtn.setForeground(new java.awt.Color(255, 255, 255));
        buscarUsuariobtn.setText("Buscar");
        buscarUsuariobtn.setBorderPainted(false);
        buscarUsuariobtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buscarUsuariobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarUsuariobtnActionPerformed(evt);
            }
        });

        title.setText("UserID");

        buscadorUsuariotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorUsuariotxtActionPerformed(evt);
            }
        });

        TablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "userID", "contraseña", "Title 3", "cliente", "proveedor", "factura", "compra", "kardex", "provincias", "ciudades", "lista_venta", "lista_compra", "gestor_usuario", "bloqueo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaUsuarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(TablaUsuarios);

        editarUsuariobtn.setBackground(new java.awt.Color(153, 0, 0));
        editarUsuariobtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        editarUsuariobtn.setForeground(new java.awt.Color(255, 255, 255));
        editarUsuariobtn.setText("Editar");
        editarUsuariobtn.setBorderPainted(false);

        eliminarUsuariobtn.setBackground(new java.awt.Color(153, 0, 0));
        eliminarUsuariobtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        eliminarUsuariobtn.setForeground(new java.awt.Color(255, 255, 255));
        eliminarUsuariobtn.setText("Eliminar");
        eliminarUsuariobtn.setBorderPainted(false);
        eliminarUsuariobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarUsuariobtnActionPerformed(evt);
            }
        });

        AgregarUsuariobtn.setBackground(new java.awt.Color(153, 0, 0));
        AgregarUsuariobtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        AgregarUsuariobtn.setForeground(new java.awt.Color(255, 255, 255));
        AgregarUsuariobtn.setText("Agregar");
        AgregarUsuariobtn.setBorderPainted(false);

        nombreUsuariotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreUsuariotxtActionPerformed(evt);
            }
        });

        title1.setText("UserID");

        contraseñaUsuariotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseñaUsuariotxtActionPerformed(evt);
            }
        });

        title2.setText("Contraseña");

        title4.setText("PERMISOS");

        boxCiudad.setText("CIUDAD");

        boxProvincia.setText("PROVINCIA");

        boxFactura.setText("FACTURA");

        boxCliente.setText("CLIENTE");

        boxCompras.setText("COMPRAS");

        boxCompra.setText("COMPRA");

        boxProveedores.setText("PROVEEDORES");

        boxKardex.setText("KARDEX");

        boxProductos.setText("PRODUCTOS");

        boxFacturas.setText("LISTA FACTURAS");

        boxUsuarios.setText("USUARIOS");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel3.setText("GESTION USUARIOS");

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
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editarUsuariobtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eliminarUsuariobtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(title)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(buscadorUsuariotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(buscarUsuariobtn))
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(boxCiudad)
                                            .addComponent(boxProvincia))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(boxCliente)
                                            .addComponent(boxFactura))
                                        .addGap(18, 18, 18)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(boxCompra)
                                            .addComponent(boxCompras))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(boxKardex)
                                            .addComponent(boxProveedores))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(bgLayout.createSequentialGroup()
                                                .addComponent(boxFacturas)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(boxUsuarios))
                                            .addComponent(boxProductos)))
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(title1)
                                            .addComponent(nombreUsuariotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(title2)
                                            .addComponent(contraseñaUsuariotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(AgregarUsuariobtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Actualizarbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title4)))
                .addGap(35, 35, 35))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(bgLayout.createSequentialGroup()
                                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buscadorUsuariotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buscarUsuariobtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(bgLayout.createSequentialGroup()
                                    .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(nombreUsuariotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(contraseñaUsuariotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(Actualizarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                .addComponent(boxCompra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxCompras))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                .addComponent(boxCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxFactura))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(boxKardex)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxProveedores)))
                        .addGroup(bgLayout.createSequentialGroup()
                            .addComponent(boxCiudad)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(boxProvincia)))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxFacturas)
                            .addComponent(boxUsuarios))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxProductos))
                    .addComponent(AgregarUsuariobtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editarUsuariobtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminarUsuariobtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscarUsuariobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarUsuariobtnActionPerformed

    }//GEN-LAST:event_buscarUsuariobtnActionPerformed

    private void buscadorUsuariotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorUsuariotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorUsuariotxtActionPerformed

    private void eliminarUsuariobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarUsuariobtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarUsuariobtnActionPerformed

    private void nombreUsuariotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreUsuariotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreUsuariotxtActionPerformed

    private void contraseñaUsuariotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseñaUsuariotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseñaUsuariotxtActionPerformed

    private void ActualizarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActualizarbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Actualizarbtn;
    public javax.swing.JButton AgregarUsuariobtn;
    public javax.swing.JTable TablaUsuarios;
    private javax.swing.JPanel bg;
    public javax.swing.JCheckBox boxCiudad;
    public javax.swing.JCheckBox boxCliente;
    public javax.swing.JCheckBox boxCompra;
    public javax.swing.JCheckBox boxCompras;
    public javax.swing.JCheckBox boxFactura;
    public javax.swing.JCheckBox boxFacturas;
    public javax.swing.JCheckBox boxKardex;
    public javax.swing.JCheckBox boxProductos;
    public javax.swing.JCheckBox boxProveedores;
    public javax.swing.JCheckBox boxProvincia;
    public javax.swing.JCheckBox boxUsuarios;
    public javax.swing.JTextField buscadorUsuariotxt;
    public javax.swing.JButton buscarUsuariobtn;
    public javax.swing.JTextField contraseñaUsuariotxt;
    public javax.swing.JButton editarUsuariobtn;
    public javax.swing.JButton eliminarUsuariobtn;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField nombreUsuariotxt;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title4;
    // End of variables declaration//GEN-END:variables
}
