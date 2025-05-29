
package presentacion;

import businessentity.Equipo;
import dao.EquipoDAO;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import javax.swing.*;
import proyectoinventarioTI.Conexion;

public class FormularioEquipo extends JFrame {
    private JTextField txtNombre, txtTipo, txtMarca, txtModelo, txtSerie, txtEstado, txtFecha;
    private JButton btnRegistrar;

    public FormularioEquipo() {
        setTitle("Registro de Equipos");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        // Crear componentes
        txtNombre = new JTextField();
        txtTipo = new JTextField();
        txtMarca = new JTextField();
        txtModelo = new JTextField();
        txtSerie = new JTextField();
        txtEstado = new JTextField();
        txtFecha = new JTextField(); // yyyy-MM-dd
        btnRegistrar = new JButton("Registrar");
        
        // Agregar componentes al formulario
        add(new JLabel("Nombre:")); add(txtNombre);
        add(new JLabel("Tipo:")); add(txtTipo);
        add(new JLabel("Marca:")); add(txtMarca);
        add(new JLabel("Modelo:")); add(txtModelo);
        add(new JLabel("Serie:")); add(txtSerie);
        add(new JLabel("Estado:")); add(txtEstado);
        add(new JLabel("Fecha Ingreso (yyyy-MM-dd):")); add(txtFecha);
        add(btnRegistrar);

        // Acción del botón
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEquipo();
            }
        });

        setLocationRelativeTo(null); // centrar
        setVisible(true);
    }

    
    private void registrarEquipo() {
        try {
            // Establecer conexión
            String url = "jdbc:sqlserver://localhost:1433;databaseName=InventarioTI;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String password = "Experian2025$";

            EquipoDAO dao = new EquipoDAO();
            
            // Crear equipo con datos del formulario
            Equipo equipo = new Equipo();
            equipo.setNombre(txtNombre.getText());
            equipo.setTipo(txtTipo.getText());
            equipo.setMarca(txtMarca.getText());
            equipo.setModelo(txtModelo.getText());
            equipo.setSerie(txtSerie.getText());
            equipo.setEstado(txtEstado.getText());
            equipo.setFechaIngreso(Date.valueOf(txtFecha.getText()));

            // Insertar
            boolean ok = dao.insertar(equipo);

            if (ok) {
                JOptionPane.showMessageDialog(this, "✅ Equipo registrado con éxito");
            } else {
                JOptionPane.showMessageDialog(this, "❌ Error al registrar equipo");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "❌ Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new FormularioEquipo();
    }
    
}
