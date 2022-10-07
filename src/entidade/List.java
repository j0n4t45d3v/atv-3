package entidade;

public class List {
    private Node head;
    private Node tail;
    private int size;

    public List() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(int value){
        Node node = new Node(value);

        if(this.head == null){
            this.head = node;
        }else{
            this.tail.setNext(node);
        }
        this.tail = node;
        this.size++;
    }

//EM PRODUÇÃO.
    public void sort(){
        Node p = this.head;
        Node prev = null;


        for(int i = 0; i < this.size; i ++){
            for (int j = 0; j < this.size;j ++){
                if(p.getValue() > p.getNext().getValue()){
                    Node e = p;
                    p.getNext().setValue(p.getValue());
                    p.setValue(e.getNext().getValue());

                }
            }
        }

    }

    public boolean checkOrderList(){
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

        return check;
    }

    public void blendList(List l){
        Node p = this.head;
        for (int i = 0; i < this.size; i++){
            l.add(p.getValue());
            p = p.getNext();
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
