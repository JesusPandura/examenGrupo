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
public class ListaEnlazada<E> implements Lista<E> {
    private Nodo<E> head;

    public ListaEnlazada() {
        // se crea un nodo cabeza, cuya información es nula y
        // también se pone en el campo next el valor null.
        head = new Nodo<E>(null, null);
    }

    public void add(E x) {
        // se mueve una variable (tmp) hasta el final de la lista para
        // poder insertar
        Nodo<E> tmp = head;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        // se crea un nuevo nodo y se enlace con el último
        Nodo<E> newNodo = new Nodo<E>(x);
        tmp.setNext(newNodo);
    }

    private Nodo caminar(int index) {
        // este metodo mueve una variable hasta el nodo anterior a la 
        // posición index, de tal manera que se hagan de manera sencilla
        // las operaciones de inserción y eliminación.
        Nodo<E> tmp = head;
        int i = 1;
        while (i < index) {
            i++;
            tmp = tmp.getNext();
        }
        return tmp;
    }

    public void add(int index, E x) throws PosicIncE {
        // pregunta si la posición de inserción es correcta, 
        // si lo es se camina a la posición anterior, se crea un nuevo
        // nodo y se enlaza, 
        // si no lo es se lanza una excepción
        if (1 <= index && index <= size()) {
            Nodo<E> tmp = caminar(index);
            Nodo<E> newNodo = new Nodo<E>(x);
            newNodo.setNext(tmp.getNext());
            tmp.setNext(newNodo);
        } else {
            throw new PosicIncE();
        }
    }

    public int size() {
        // recorre la lista contando los elementos.
        int i = 0;
        Nodo<E> tmp = head.getNext();
        while (tmp != null) {
            tmp = tmp.getNext();
            i++;
        }
        return i;
    }

    public E remove(int index) throws PosicIncE {
        // pregunta si la posición de eliminación es correcta, 
        // si lo es se camina a la posición anterior, y se ajustan los enlaces
        // si no lo es se lanza una excepción   
        if (1 <= index && index <= size()) {
            Nodo<E> tmp = caminar(index);
            E o = tmp.getNext().getInfo();
            tmp.setNext(tmp.getNext().getNext());
            return o;
        } else {
            throw new PosicIncE();
        }
    }

    public void remove(E x) throws ElemNoEncE {
        // este metodo busca un objeto en la lista.
        // es necesario tener presente que se utiliza el método equals()
        // si lo encuentra lo elimina y sino lanza una excepción
        // observar que la variable tmpa se va quedando atrás para poder
        // enlazar
        Nodo<E> tmp = head.getNext();
        Nodo<E> tmpa = head;
        while (tmp != null && !tmp.getInfo().equals(x)) {
            tmpa = tmp;
            tmp = tmp.getNext();
        }
        if (tmp == null) // no se encontró
        {
            throw new ElemNoEncE();
        } else {
            tmpa.setNext(tmp.getNext());
        }
    }

    public boolean contains(E x) {
        // este método busca un objeto en la lista. 
        // utiliza el equals() para comparar.
        Nodo<E> tmp = head.getNext();
        while (tmp != null && !tmp.getInfo().equals(x)) {
            tmp = tmp.getNext();
        }
        return tmp != null;
    }

    public E get(int index) throws PosicIncE {
        // comprueba si la posición es correcta.
        // si lo es avanza una variable hasta la posición anterior
        // y devuelve la información del siguiente.
        // si la posición no es correcta eleva una excepción
        if (1 <= index && index <= size()) {
            Nodo<E> tmp = caminar(index);
            E o = tmp.getNext().getInfo();
            return o;
        } else {
            throw new PosicIncE();
        }
    }

    public int getIndex(E x) {
        // mueve una variable hasta que encuentra al objeto.
        // utiliza el equals para comparar.
        // devuelve la posición donde lo encontró o -1 si no lo encontró.
        int i = 1;
        Nodo<E> tmp = head.getNext();
        while (tmp != null && !tmp.getInfo().equals(x)) {
            tmp = tmp.getNext();
            i++;
        }
        return ((tmp != null) ? i : -1);
    }
    
    public void clear() {
        // limpia la lista, hace que el nodo cabeza apunte a null de nuevo
        head.setNext(null);
    }

    public IterEnlazada<E> iter() {
        // crea un objeto iterador para poder recorrer la lista.    
        IterEnlazada<E> it = new IterEnlazada<E>(head);
        return it;
    }

    public boolean isEmpty() {
        // determina si la lista está vacía o no.
        return head.getNext() == null;
    }    

    public void set(int index, E element) throws PosicIncE{
       if (1 <= index && index <= size()) {
            Nodo<E> tmp = caminar(index);
            tmp.getNext().setInfo(element);
        } else {
            throw new PosicIncE();
        }         
     }
}
