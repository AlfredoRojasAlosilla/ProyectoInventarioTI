
package presentacion;
import javax.swing.table.DefaultTableModel;
import businessentity.Equipo;
import dao.EquipoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import presentacion.FormularioEquipo;



public class ListadoEquipos extends javax.swing.JFrame {

  
    public ListadoEquipos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Tipo", "Marca", "Modelo", "Serie", "Estado", "Fecha Ingreso Activo"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 102));
        jTable1.setName("tablaEquipos"); // NOI18N
        jTable1.setRowHeight(15);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Mostrar Registros");
        jButton1.setName("btnMostrar"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar Registro");
        jButton2.setName("btnEliminar"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Añadir Registro");
        jButton3.setName("btnAdd"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Actualizar Registro");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DE ACTIVOS");
        jLabel1.setMaximumSize(new java.awt.Dimension(165, 15));
        jLabel1.setPreferredSize(new java.awt.Dimension(500, 15));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 244, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ID");
    modelo.addColumn("Nombre");
    modelo.addColumn("Tipo");
    modelo.addColumn("Marca");
    modelo.addColumn("Modelo");
    modelo.addColumn("Serie");
    modelo.addColumn("Estado");
    modelo.addColumn("Fecha Ingreso");

    dao.EquipoDAO dao = new EquipoDAO();
    java.util.List<businessentity.Equipo> lista = dao.listar();

    for (businessentity.Equipo e : lista) {
        modelo.addRow(new Object[]{
            e.getIdEquipo(),
            e.getNombre(),
            e.getTipo(),
            e.getMarca(),
            e.getModelo(),
            e.getSerie(),
            e.getEstado(),
            e.getFechaIngreso()
        });
    }

    jTable1.setModel(modelo);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mostrarEquipos() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Tipo", "Marca", "Modelo", "Serie", "Estado", "Fecha Ingreso"});

    EquipoDAO dao = new EquipoDAO();
    List<Equipo> lista = dao.listar();

    for (Equipo e : lista) {
        modelo.addRow(new Object[]{
            e.getIdEquipo(),
            e.getNombre(),
            e.getTipo(),
            e.getMarca(),
            e.getModelo(),
            e.getSerie(),
            e.getEstado(),
            e.getFechaIngreso()
        });
    }

    jTable1.setModel(modelo);
}
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int filaSeleccionada = jTable1.getSelectedRow();
    if (filaSeleccionada != -1) {
        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este equipo?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int idEquipo = (int) jTable1.getValueAt(filaSeleccionada, 0); // columna 0: id_equipo
            EquipoDAO dao = new EquipoDAO();
            if (dao.eliminar(idEquipo)) {
                JOptionPane.showMessageDialog(this, "Equipo eliminado exitosamente.");
                mostrarEquipos(); // método que ya usas para actualizar la tabla
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el equipo.");
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.");
    }
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FormularioEquipo formulario = new FormularioEquipo();
        formulario.setVisible(true);
        formulario.setLocationRelativeTo(null); // Centrar el formulario    
        
        //this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int fila = jTable1.getSelectedRow(); // Asegúrate que tabla sea el nombre de tu JTable
   
    if (fila != -1) {
        int idEquipo = Integer.parseInt(jTable1.getValueAt(fila, 0).toString());

        try {
            EquipoDAO dao = new EquipoDAO();
            Equipo equipo = dao.obtenerPorId(idEquipo);

            if (equipo != null) {
                FormularioActualizar actualizar = new FormularioActualizar(idEquipo);
                actualizar.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "❌ No se encontró el equipo en la base de datos.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "⚠️ Error al obtener el equipo: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "⚠️ Por favor, selecciona un equipo para actualizar.");
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
