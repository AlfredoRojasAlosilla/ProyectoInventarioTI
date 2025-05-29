/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import java.util.List;

/**
 *
 * @author User
 */
public interface DAOproyect<T> {
    
     boolean insertar(T entidad);
    
    boolean actualizar(T entidad);
    
    boolean eliminar(int id);
    
    T obtenerPorId(int id);
    
    List<T> listarTodos();
}
