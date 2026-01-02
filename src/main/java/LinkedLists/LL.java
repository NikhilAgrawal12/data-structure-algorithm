package LinkedLists;

public class LL {

    Node head;
    private int size;

    LL(){
        this.size=0;
    }

    class Node{
        String data;
        Node next;

        Node(String data){
            this.data=data;
            this.next=null;
            size++;
        }

    }

    //add - first, last
    public void addFirst(String data){
        Node newNode= new Node(data);
        if(head==null){
            head=newNode;
            return;
        }

        newNode.next=head;
        head=newNode;
    }

    public void addLast(String data){
        Node newNode= new Node(data);
        if(head==null){
            head=newNode;
            return;
        }

        Node currNode = head;

        while(currNode.next!=null){
            currNode=currNode.next;
        }

        currNode.next=newNode;

    }

    public void printList(){
        Node currNode=head;

        if(head==null){
            System.out.println("List is empty");
            return;
        }

        while(currNode!=null){
            System.out.print(currNode.data + " -> ");
            currNode=currNode.next;
        }

        System.out.println("NULL");

    }

    public void deleteFirst(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }

        size--;
        head=head.next;
    }

    public void deleteLast(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        size--;
        if(head.next==null){
            head=null;
            return;
        }

        Node lastNode=head.next;
        Node secondLast=head;

        while(lastNode.next!=null){
            lastNode=lastNode.next;
            secondLast=secondLast.next;
        }
        secondLast.next=null;
    }

    public int getSize() {
        return size;
    }

    public void reverseIterate(){

        Node prevNode=head;
        Node currNode=head.next;

        while(currNode!=null){
            Node nextNode=currNode.next;
            currNode.next=prevNode;

            prevNode=currNode;
            currNode=nextNode;
        }
        head.next=null;
        head=prevNode;

    }


    public static void main(String[] args){
        LL list = new LL();
        list.addFirst("a");
        list.addFirst("is");

        list.addLast("List");

        list.addFirst("This");

        list.printList();
        System.out.println(list.getSize());

//        list.deleteFirst();
//        list.printList();
//        System.out.println(list.getSize());
//        list.deleteLast();
//        list.printList();
//        System.out.println(list.getSize());

        list.reverseIterate();
        list.printList();


    }
}
