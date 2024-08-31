/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espol.edurepoespol;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User Dell
 */
public interface DAO<T> {
    void insert(T t) throws SQLException;
    T getById(int id) throws SQLException;
    List<T> getAll() throws SQLException;
    void update(T t) throws SQLException;
    void delete(int id) throws SQLException;
}
