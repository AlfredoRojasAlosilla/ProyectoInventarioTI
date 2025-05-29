
package dao;

import businessentity.Equipo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import proyectoinventarioTI.Conexion;


/**
 *
 * @author User
 */
public class EquipoDAO implements DAOproyect<Equipo> {
    
    private Connection conexion;

public EquipoDAO() {
    this.conexion = Conexion.getConexion();
}

    @Override
    public boolean insertar(Equipo equipo) {
        String sql = "INSERT INTO Equipo (nombre, tipo, marca, modelo, serie, estado, fecha_ingreso) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, equipo.getNombre());
            stmt.setString(2, equipo.getTipo());
            stmt.setString(3, equipo.getMarca());
            stmt.setString(4, equipo.getModelo());
            stmt.setString(5, equipo.getSerie());
            stmt.setString(6, equipo.getEstado());
            stmt.setDate(7, equipo.getFechaIngreso());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error insertando equipo: " + e.getMessage());
            return false;
        }
    }
        
    // Puedes añadir luego actualizar, eliminar, etc.

   @Override
public boolean actualizar(Equipo equipo) {
       String sql = "UPDATE Equipo SET nombre = ?, tipo = ?, marca = ?, modelo = ?, serie = ?, estado = ?, fecha_ingreso = ? WHERE id_equipo = ?";

    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, equipo.getNombre());
        stmt.setString(2, equipo.getTipo());
        stmt.setString(3, equipo.getMarca());
        stmt.setString(4, equipo.getModelo());
        stmt.setString(5, equipo.getSerie());
        stmt.setString(6, equipo.getEstado());
        stmt.setDate(7, equipo.getFechaIngreso());
        stmt.setInt(8, equipo.getIdEquipo());

        return stmt.executeUpdate() > 0;

    } catch (SQLException e) {
        System.out.println("Error al actualizar equipo: " + e.getMessage());
        return false;
    }
}

    @Override
    public boolean eliminar(int id) {
      String sql = "DELETE FROM Equipo WHERE id_equipo = ?";

    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setInt(1, id);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        System.out.println("Error al eliminar equipo: " + e.getMessage());
        return false;
    }
    }


    @Override
    public Equipo obtenerPorId(int id) { 
   String sql = "SELECT * FROM Equipo WHERE id_equipo = ?";
    Equipo equipo = null;

    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            equipo = new Equipo();
            equipo.setIdEquipo(rs.getInt("id_equipo"));
            equipo.setNombre(rs.getString("nombre"));
            equipo.setTipo(rs.getString("tipo"));
            equipo.setMarca(rs.getString("marca"));
            equipo.setModelo(rs.getString("modelo"));
            equipo.setSerie(rs.getString("serie"));
            equipo.setEstado(rs.getString("estado"));
            equipo.setFechaIngreso(rs.getDate("fecha_ingreso"));
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener equipo por ID: " + e.getMessage());
    }

    return equipo;
    }

    @Override
    public List<Equipo> listarTodos() { return new ArrayList<>(); }

    public List<Equipo> listar() {
         List<Equipo> lista = new ArrayList<>();
    String sql = "SELECT * FROM Equipo";

    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Equipo eq = new Equipo();
            eq.setIdEquipo(rs.getInt("id_equipo"));
            eq.setNombre(rs.getString("nombre"));
            eq.setTipo(rs.getString("tipo"));
            eq.setMarca(rs.getString("marca"));
            eq.setModelo(rs.getString("modelo"));
            eq.setSerie(rs.getString("serie"));
            eq.setEstado(rs.getString("estado"));
            eq.setFechaIngreso(rs.getDate("fecha_ingreso"));
            lista.add(eq);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
    }
    
    
    
}