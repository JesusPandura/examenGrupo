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
public class IterEnlazada <E> implements Iterator<E>{
    private Nodo<E> actual;

    public IterEnlazada(Nodo<E> a) {
        actual = a;
    }

    public boolean hasNext() {
        return actual.getNext() != null;
    }
    public E next() {
        if (hasNext()) {
            actual = actual.getNext();
            return actual.getInfo();
        } else {
            return null;
        }
    }

    public Nodo<E> getActual() {
        return actual;
    }

    
}
