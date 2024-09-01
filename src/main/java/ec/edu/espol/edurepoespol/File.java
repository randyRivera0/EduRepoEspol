/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.edurepoespol;

/**
 *
 * @author User Dell
 */
public class File {
    private int id;
    private String nombre;
    private String ruta;
    private String tipoArchivo;
    private String codigo;
    private String matricula;

    public File(String nombre, String codigo, String matricula) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    

    
}
