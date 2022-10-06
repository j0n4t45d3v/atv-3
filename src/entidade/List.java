package entidade;

public class List {
    private Node head;
    private Node tail;

    public List() {
        this.head = null;
        this.tail = null;
    }

    public void add(int value){
        Node node = new Node(value);

        if(this.head == null){
            this.head = node;
        }else{
            this.tail.setNext(node);
        }
        this.tail = node;
    }

    public void printList(){
        Node p = this.head;

        System.out.print("[");
        while(p != null){
            if(p.equals(this.head)) System.out.print(p.getValue());
            else System.out.print(", "+p.getValue());
            p = p.getNext();
        }
        System.out.println("]");
    }
}
