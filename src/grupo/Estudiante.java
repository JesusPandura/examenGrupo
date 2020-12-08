/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo;

/**
 *
 * @author nelso
 */
public class Estudiante {
    private String nombre;
     private String ape;
    private Lista<Integer> notas;
    
    public Estudiante(String nombre,String ape, Lista<Integer> notas) {
        this.nombre = nombre;
        this.notas = notas;
         this.ape =ape;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String nape) {
        this.ape = ape;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Lista<Integer> getNotas() {
        return notas;
    }

    public void setNotas(Lista<Integer> notas) {
        this.notas = notas;
    }
    
    
}
