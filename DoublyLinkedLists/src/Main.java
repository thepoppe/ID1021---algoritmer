public class Main {

    public static void main(String[] args) {
        testDoublyLinkedLists();
        testUnlinkInsert();
        for (int i = 0; i < 1; i++)
            Bench.run();
    }


    private static void testDoublyLinkedLists(){
        DoublyLinked firstList = new DoublyLinked(5);
        System.out.println("length of first: \n"+firstList.length());
        System.out.println("find element 2: \n"+firstList.find(2));
        System.out.println("Print List1: ");
        firstList.printAllItems();
        System.out.println("Remove  2: ");
        firstList.remove(2);
        firstList.printAllItems();
        System.out.println("add  2: ");
        firstList.add(2);
        firstList.printAllItems();


        System.out.println("Unlink third element ( 3 ) : ");
        firstList.unlink(firstList.first.next.next);
        firstList.printAllItems();

    }

    private static void testUnlinkInsert(){
        System.out.println("Fill the lists: ");
        DoublyLinked firstList = new DoublyLinked(10);
        Linked secondList = new Linked(10);
        firstList.printAllItems();
        secondList.printAllItems();
        System.out.println("unlink third cell: ");
        Cell cellDoubly = firstList.first.next.next;
        Cell cellLinked = secondList.first.next.next;
        firstList.unlink(cellDoubly);
        secondList.unlink(cellLinked);
        firstList.printAllItems();
        secondList.printAllItems();
        System.out.println("Insert the third cell at first pos: ");
        firstList.insert(cellDoubly);
        secondList.insert(cellLinked);
        firstList.printAllItems();
        secondList.printAllItems();

    }



}
