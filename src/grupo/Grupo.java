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
public class Grupo {
    private Lista<Estudiante> estudiantes;

    public Grupo(Lista<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void addEstudiante(Estudiante e) {
        this.estudiantes.add(e);
    }
    
    public void removeEstudiante(String nombre) throws ElemNoEncE {
        IterEnlazada<Estudiante> it = this.estudiantes.iter();
        while (it.hasNext()) {
            if (it.next().getNombre().equals(nombre)) {
                System.out.println("Estudiante encontrado: " + it.getActual().getInfo().getNombre());
                this.estudiantes.remove(it.getActual().getInfo());
                System.out.println("Estudiante eliminado!!!");
            }
        }
    }
     public void removeEstudianteape(String ape) throws ElemNoEncE {
        IterEnlazada<Estudiante> it = this.estudiantes.iter();
        while (it.hasNext()) {
            if (it.next().getApe().equals(ape)) {
                System.out.println("Estudiante encontrado: " + it.getActual().getInfo().getApe());
                this.estudiantes.remove(it.getActual().getInfo());
                System.out.println("Estudiante eliminado!!!");
            }
        }
    }
    public double averageGrupo() {
        IterEnlazada<Estudiante> it = this.estudiantes.iter();
        int i=0;
        int sum = 0;
        while (it.hasNext()) {
            IterEnlazada<Integer> its = it.next().getNotas().iter();
            while (its.hasNext()) {
                sum += its.next();
                i++;
            }
        }
        return sum/i;
    }
    public double prome(Lista<Integer> notas){
       
       IterEnlazada<Integer> ki =  notas.iter();
        int i=0;
        int sum = 0;
        while (ki.hasNext()) {
          
                sum += ki.next();
                i++;
            
        }
        return sum/i;
        
    }
    
    
    
    public Lista<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}
