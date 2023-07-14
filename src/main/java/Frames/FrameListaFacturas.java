/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frames;

/**
 *
 * @author pc
 */
public class FrameListaFacturas extends javax.swing.JPanel {

    /**
     * Creates new form ListaFacturas
     */
    public FrameListaFacturas() {
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

        bg3 = new javax.swing.JPanel();
        Buscarciudad = new javax.swing.JButton();
        title9 = new javax.swing.JLabel();
        buscadorFacturatxt = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaListaFacturas = new javax.swing.JTable();
        EditarCiudad = new javax.swing.JButton();
        EliminarCiudad = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        bg3.setBackground(new java.awt.Color(255, 255, 255));
        bg3.setMinimumSize(new java.awt.Dimension(809, 544));

        Buscarciudad.setBackground(new java.awt.Color(153, 0, 0));
        Buscarciudad.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Buscarciudad.setForeground(new java.awt.Color(255, 255, 255));
        Buscarciudad.setText("Buscar");
        Buscarciudad.setBorderPainted(false);
        Buscarciudad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Buscarciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarciudadActionPerformed(evt);
            }
        });

        title9.setText("Numero Factura");

        buscadorFacturatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorFacturatxtActionPerformed(evt);
            }
        });

        tablaListaFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NUMERO DE FACTURA", "CLIENTE", "TOTAL VENDIDO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaListaFacturas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane4.setViewportView(tablaListaFacturas);

        EditarCiudad.setBackground(new java.awt.Color(153, 0, 0));
        EditarCiudad.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        EditarCiudad.setForeground(new java.awt.Color(255, 255, 255));
        EditarCiudad.setText("Editar");
        EditarCiudad.setBorderPainted(false);

        EliminarCiudad.setBackground(new java.awt.Color(153, 0, 0));
        EliminarCiudad.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        EliminarCiudad.setForeground(new java.awt.Color(255, 255, 255));
        EliminarCiudad.setText("Eliminar");
        EliminarCiudad.setBorderPainted(false);
        EliminarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarCiudadActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel2.setText("LISTA FACTURAS");

        javax.swing.GroupLayout bg3Layout = new javax.swing.GroupLayout(bg3);
        bg3.setLayout(bg3Layout);
        bg3Layout.setHorizontalGroup(
            bg3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(bg3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(EditarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EliminarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addGroup(bg3Layout.createSequentialGroup()
                        .addGroup(bg3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title9)
                            .addGroup(bg3Layout.createSequentialGroup()
                                .addComponent(buscadorFacturatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Buscarciudad)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(35, 35, 35))
        );
        bg3Layout.setVerticalGroup(
            bg3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bg3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg3Layout.createSequentialGroup()
                        .addComponent(title9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(bg3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscadorFacturatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Buscarciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addGap(72, 72, 72)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addGroup(bg3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EliminarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarciudadActionPerformed

    }//GEN-LAST:event_BuscarciudadActionPerformed

    private void buscadorFacturatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorFacturatxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorFacturatxtActionPerformed

    private void EliminarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminarCiudadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Buscarciudad;
    public javax.swing.JButton EditarCiudad;
    public javax.swing.JButton EliminarCiudad;
    private javax.swing.JPanel bg3;
    public javax.swing.JTextField buscadorFacturatxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTable tablaListaFacturas;
    private javax.swing.JLabel title9;
    // End of variables declaration//GEN-END:variables
}
