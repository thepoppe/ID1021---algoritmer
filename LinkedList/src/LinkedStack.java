public class LinkedStack {

    private final Linked list;

    public LinkedStack() {
        list= new Linked(0);
    }



    public void push(int value){
        list.add(value);
    }

    public int pop(){
        return list.getLastElement();
    }
}
