package data;
/**
 *
 * @author xbp1
 */
public interface Stack<E> {
    void push(E elem);
    void pop() throws StackError;
    E top() throws StackError;
    int size();
}

