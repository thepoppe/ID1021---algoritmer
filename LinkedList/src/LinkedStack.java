public class LinkedStack {

    private final SinglyLinked list;

    public LinkedStack() {
        list= new SinglyLinked(0);
    }



    public void push(int value){
        list.add(value);
    }

    public int pop(){
        return list.getLastElement();
    }
}
