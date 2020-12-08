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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ElemNoEncE {
        Lista<Integer> notas1 = new ListaEnlazada<Integer>();
        notas1.add(70);
        notas1.add(89);
        notas1.add(100);
        
        Estudiante e1 = new Estudiante("Jose","Alvarado", notas1);
        System.out.println("----------------------------------------");
         
        Lista<Integer> notas2 = new ListaEnlazada<Integer>();
        notas2.add(100);
        notas2.add(97);
        notas2.add(70);
        Estudiante e2 = new Estudiante("carmelo","gustencio", notas2);
        
        Lista<Integer> notas3 = new ListaEnlazada<Integer>();
        notas3.add(67);
        notas3.add(80);
        notas3.add(100);
        Estudiante e3 = new Estudiante("Luis","Hosmares",notas3);
        
        Lista<Integer> notas4 = new ListaEnlazada<Integer>();
        notas3.add(67);
        notas3.add(88);
        notas3.add(100);
        Estudiante e4 = new Estudiante("Armando","Hoyos",notas4);
       
        Lista<Estudiante> estudiantes = new ListaEnlazada<Estudiante>();
        estudiantes.add(e1);
       Grupo g = new Grupo(estudiantes);
       g.addEstudiante(e2);
       g.addEstudiante(e3);
       g.addEstudiante(e4);
        IterEnlazada<Estudiante> itte = estudiantes.iter();
        while (itte.hasNext()) {
            System.out.println("Estudiante: " + itte.next().getNombre());
        }
        System.out.println("----------------------------------------");
        g.removeEstudiante("Luis");
        IterEnlazada<Estudiante> itg2t = g.getEstudiantes().iter();
        System.out.println("----------------------------------------");
        System.out.println("Listado de Estudiantes del Grupo");
        while (itg2t.hasNext()) {
            System.out.println("Estudiante: " + itg2t.next().getNombre());
        }
        System.out.println("----------------------------------------");
        
        g.removeEstudianteape("Hoyos");
        IterEnlazada<Estudiante> it2t = g.getEstudiantes().iter();
        System.out.println("----------------------------------------");
        System.out.println("Listado de Estudiantes del Grupo");
        while (it2t.hasNext()) {
            System.out.println("Estudiante: " + it2t.next().getNombre());
        }
        
        IterEnlazada<Integer> ittt = notas1.iter();
        int l =1;
        while (ittt.hasNext()) {
            System.out.println("Nota " + l + ":  " + ittt.next());
            l++;
        }
        System.out.println("----------------------------------------");
        IterEnlazada<Integer> ki = notas2.iter();
        int k =1;
        while (ki.hasNext()) {
            System.out.println("Nota " + k + ":  " + ki.next());
            k++;
        }
        
        System.out.println("promedio de Jose "+g.prome(notas1));
        System.out.println("promedio de  carmelo "+g.prome(notas2));
        
        System.out.println("promedio minimo "+g.prome(notas3));
         System.out.println("promedio minimo "+g.prome(notas1));
    }
    
}
