package data;
/**
 *
 * @author xbp1
 */
public class DynamicStack<E> implements Stack <E> {
    
    int size = 0;
    Node<E> top;
    
    @Override
    public void push(E e) {
        if(size() == 0) {
            top = new Node<E>(e, null); 
        }
        else {
            top = new Node<E>(e, top); 
        }
        ++size;
    }

    @Override
    public void pop() throws StackError {
        if(size() == 0) {
            throw new StackError("La pila està buida");    
        }
        else {
            top = top.next;
            --size;
        }
    }

    @Override
    public E top() throws StackError {
        if(size() == 0) {
            throw new StackError("La pila està buida");    
        }
        else {
            return top.e;
        }
    }

    @Override
    public int size() {
        return size;    
    }
    
    private static class Node<E> {
        private E e;
        private Node <E> next;
        
        private Node(E e, Node<E> next) {
            this.next = next;
            this.e = e;
        }
    }
}