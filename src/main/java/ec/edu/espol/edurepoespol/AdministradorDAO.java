/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.edurepoespol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User Dell
 */
public class AdministradorDAO implements DAO<Administrador> {
    private final Connection connection;

    public AdministradorDAO() {
        connection = DataBaseConnection.getInstance().getConnection();
    }

    @Override
    public void insert(Administrador admin) throws SQLException {
        String query = "INSERT INTO administrador (idAdmin, correo, nivel) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, admin.getIdAdmin());
            stmt.setString(2, admin.getCorreo());
            stmt.setInt(3, admin.getNivel());
            stmt.executeUpdate();
        }
    }

    @Override
    public Administrador getById(int id) throws SQLException {
        String query = "SELECT * FROM administrador WHERE idAdmin = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Administrador(rs.getString("correo"), rs.getInt("nivel"));
            }
        }
        return null;
    }

    @Override
    public List<Administrador> getAll() throws SQLException {
        List<Administrador> admins = new ArrayList<>();
        String query = "SELECT * FROM administrador";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                admins.add(new Administrador(rs.getString("correo"), rs.getInt("nivel")));
            }
        }
        return admins;
    }

    @Override
    public void update(Administrador admin) throws SQLException {
        String query = "UPDATE administrador SET correo = ?, nivel = ? WHERE idAdmin = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, admin.getCorreo());
            stmt.setInt(2, admin.getNivel());
            stmt.setInt(3, admin.getIdAdmin());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM administrador WHERE idAdmin = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
