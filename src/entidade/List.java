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
        Node prev = null;
        int cont = 0;

        while(!checkOrderList()){
            for (Node j = this.head; cont < this.size; j = j.getNext()){
                 if(this.head.getValue() > j.getValue()){

                    if(j.equals(this.head.getNext())){
                        this.head.setNext(j.getNext());
                    } else if (j.equals(this.tail)) {
                        this.tail = prev;
                        prev.setNext(null);
                    } else{
                        prev.setNext(j.getNext());
                    }
                    j.setNext(this.head);
                    this.head = j;
                } else if (this.tail.getValue() < j.getValue()) {
                    if(j.equals(this.head)){
                        this.head = j.getNext();
                    } else{
                        prev.setNext(j.getNext());
                    }
                    this.tail.setNext(j);
                    this.tail = j;
                    this.tail.setNext(null);
                }

                prev = j;
                cont++;
            }
            cont ++;
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
        for(int i = 0; i < this.size;i++){
            if(p.equals(this.head)) System.out.print(p.getValue());
            else System.out.print(", "+p.getValue());
            p = p.getNext();
        }
        System.out.println("]");
        System.out.println("head: "+this.head.getValue()+"\ntail: "+this.tail.getValue());
    }
}
