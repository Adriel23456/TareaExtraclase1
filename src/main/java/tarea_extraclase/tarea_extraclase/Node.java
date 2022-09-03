package tarea_extraclase.tarea_extraclase;

public class Node<T>{
    private T data;
    private Node<T> next;
    private Node<T> previous;

    public Node(Node<T> next, Node<T> previous, T data){
        this.next = next;
        this.previous = previous;
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public Node<T> getPrevious() {
        return this.previous;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}
