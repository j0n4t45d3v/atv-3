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

//EM PRODUÇÃO.
    public void sort(){
        Node p = this.head;
        Node prev = null;

        while(p != null && p.getNext() != null){
            if(p.getValue() > p.getNext().getValue()){
                if(p.getNext().equals(this.tail)){
                    prev.setNext(p.getNext());
                    p.getNext().setNext(p);
                    this.tail = p;
                    this.tail.setNext(null);
                    break;
                } else if(p.equals(this.head)){
                    prev = new Node(p.getNext().getValue());
                    p.setNext(p.getNext().getNext());
                    prev.setNext(p);
                    this.head = prev;
                } else{
                    prev.setNext(p.getNext());
                }
            }
            prev = p;
            p = p.getNext();
        }
    }

    public void checkOrderList(){
        Node p = this.head;
        boolean check = false;

        while(p != null && p.getNext() != null){
            if(p.getValue() < p.getNext().getValue()){
                check = true;
            }else{
                check = false;
                break;
            }
            p = p.getNext();
        }
        if(check){
            System.out.println("A lista esta ordenada.");
        }else{
            System.out.println("A lista não esta ordenada.");
        }
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
        System.out.println("head: "+this.head.getValue()+"\ntail: "+this.tail.getValue());
    }
}
