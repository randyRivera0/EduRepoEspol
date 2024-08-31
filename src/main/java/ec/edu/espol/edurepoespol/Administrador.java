/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.edurepoespol;

/**
 *
 * @author User Dell
 */
public class Administrador {
    private int idAdmin;
    private String correo;
    private int nivel;

    public Administrador(int idAdmin, String correo, int nivel) {
        this.idAdmin = idAdmin;
        this.correo = correo;
        this.nivel = nivel;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
