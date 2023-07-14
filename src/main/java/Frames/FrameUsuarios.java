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
        buscarCliente = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        buscadorCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        editarCliente = new javax.swing.JButton();
        eliminarCliente = new javax.swing.JButton();
        guardarCliente = new javax.swing.JButton();
        nombreCliente = new javax.swing.JTextField();
        title1 = new javax.swing.JLabel();
        cedulaCliente = new javax.swing.JTextField();
        title2 = new javax.swing.JLabel();
        title4 = new javax.swing.JLabel();
        boxCiudad = new javax.swing.JCheckBox();
        boxProvincia = new javax.swing.JCheckBox();
        boxFactura = new javax.swing.JCheckBox();
        boxCliente = new javax.swing.JCheckBox();
        boxVentas = new javax.swing.JCheckBox();
        boxCompra = new javax.swing.JCheckBox();
        boxProveedores = new javax.swing.JCheckBox();
        boxKardex = new javax.swing.JCheckBox();
        boxProductos = new javax.swing.JCheckBox();
        boxFacturas = new javax.swing.JCheckBox();
        boxUsuarios = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(809, 544));

        buscarCliente.setBackground(new java.awt.Color(153, 0, 0));
        buscarCliente.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        buscarCliente.setForeground(new java.awt.Color(255, 255, 255));
        buscarCliente.setText("Buscar");
        buscarCliente.setBorderPainted(false);
        buscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteActionPerformed(evt);
            }
        });

        title.setText("UserID");

        buscadorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorClienteActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "userID", "contraseña", "permiso_producto", "permiso_cliente", "permiso_proveedor", "permiso_factura", "permiso_compra", "permiso_kardex", "permiso_provincias", "permiso_ciudades", "permiso_lista_venta", "permiso_lista_compra", "permiso_gestor_usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTable2);

        editarCliente.setBackground(new java.awt.Color(153, 0, 0));
        editarCliente.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        editarCliente.setForeground(new java.awt.Color(255, 255, 255));
        editarCliente.setText("Editar");
        editarCliente.setBorderPainted(false);

        eliminarCliente.setBackground(new java.awt.Color(153, 0, 0));
        eliminarCliente.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        eliminarCliente.setForeground(new java.awt.Color(255, 255, 255));
        eliminarCliente.setText("Eliminar");
        eliminarCliente.setBorderPainted(false);
        eliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarClienteActionPerformed(evt);
            }
        });

        guardarCliente.setBackground(new java.awt.Color(153, 0, 0));
        guardarCliente.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        guardarCliente.setForeground(new java.awt.Color(255, 255, 255));
        guardarCliente.setText("Agregar");
        guardarCliente.setBorderPainted(false);

        nombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreClienteActionPerformed(evt);
            }
        });

        title1.setText("UserID");

        cedulaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaClienteActionPerformed(evt);
            }
        });

        title2.setText("Contraseña");

        title4.setText("PERMISOS");

        boxCiudad.setText("CIUDAD");

        boxProvincia.setText("PROVINCIA");

        boxFactura.setText("FACTURA");

        boxCliente.setText("CLIENTE");

        boxVentas.setText("VENTAS");

        boxCompra.setText("COMPRA");

        boxProveedores.setText("PROVEEDORES");

        boxKardex.setText("KARDEX");

        boxProductos.setText("PRODUCTOS");

        boxFacturas.setText("LISTA FACTURAS");

        boxUsuarios.setText("USUARIOS");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel3.setText("GESTION USUARIOS");

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
                                .addComponent(editarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(title)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(buscadorCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(buscarCliente))
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
                                            .addComponent(boxVentas))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(title1)
                                            .addComponent(nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(title2)
                                            .addComponent(cedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                            .addComponent(boxProductos))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(guardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title4)))
                .addGap(35, 35, 35))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(bgLayout.createSequentialGroup()
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buscadorCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(bgLayout.createSequentialGroup()
                            .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(cedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                .addComponent(boxCompra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxVentas))
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
                    .addComponent(guardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void buscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteActionPerformed

    }//GEN-LAST:event_buscarClienteActionPerformed

    private void buscadorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorClienteActionPerformed

    private void eliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarClienteActionPerformed

    private void nombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreClienteActionPerformed

    private void cedulaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    public javax.swing.JCheckBox boxCiudad;
    public javax.swing.JCheckBox boxCliente;
    public javax.swing.JCheckBox boxCompra;
    public javax.swing.JCheckBox boxFactura;
    public javax.swing.JCheckBox boxFacturas;
    public javax.swing.JCheckBox boxKardex;
    public javax.swing.JCheckBox boxProductos;
    public javax.swing.JCheckBox boxProveedores;
    public javax.swing.JCheckBox boxProvincia;
    public javax.swing.JCheckBox boxUsuarios;
    public javax.swing.JCheckBox boxVentas;
    public javax.swing.JTextField buscadorCliente;
    public javax.swing.JButton buscarCliente;
    public javax.swing.JTextField cedulaCliente;
    public javax.swing.JButton editarCliente;
    public javax.swing.JButton eliminarCliente;
    public javax.swing.JButton guardarCliente;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable2;
    public javax.swing.JTextField nombreCliente;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title4;
    // End of variables declaration//GEN-END:variables
}
