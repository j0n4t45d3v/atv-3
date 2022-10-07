package programa;

import entidade.List;

public class Main {
    public static void main(String[] args) {
        List l = new List();
        List l2 = new List();

        l.add(2);
        l.add(1);
        l.add(3);
        l.add(4);
        l.sort();
        l.printList();
        l.checkOrderList();
        l2.add(0);
        l2.add(10);
        l2.add(20);
        l2.printList();
        l2.checkOrderList();
        l2.blendList(l);
        l.printList();
    }
}
