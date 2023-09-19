public class DoublyLinked implements LinkedLists {
    Cell first;


    DoublyLinked(int n) {

        Cell last = null;
        Cell trailingLast;
        for (int i = 0; i < n; i++) {
            trailingLast = last;
            last = new Cell(i, last, null);
            if(trailingLast != null)
                trailingLast.prev = last;
        }
        first = last;
    }






    public void insert(Cell cellToInsert){
        if (first == null)
            first = cellToInsert;

        else if (cellToInsert != null){
            first.prev = cellToInsert;
            cellToInsert.next = first;
            first = cellToInsert;
            first.prev = null;
        }
    }

    public void unlink(Cell cellToUnlink){
        if (cellToUnlink == first)
            first = first.next;
        else if (cellToUnlink != null) {
            Cell prev = cellToUnlink.prev;
            Cell next = cellToUnlink.next;
            prev.next = next;
        }

    }



    void add(int item){
        if (first == null){
            first = new Cell(item,null,null);
        }
        else{
            Cell nextCell = new Cell(item,first, null );
           first = nextCell;
        }
    }

    int length(){
        if (first == null)
            return 0;
        Cell nextCell = first;
        int size =0;
        while (nextCell != null){
            size++;
            nextCell = nextCell.next;
        }
        return size;
    }

    boolean find(int item){
        if (first == null)
            return false;
        Cell nextCell = first;
        while (nextCell!=null){
            if (nextCell.head == item)
                return true;
            else nextCell = nextCell.next;
        }
        return false;
    }

    void remove(int item){
        if (first.head ==  item){
            first = first.next;
            first.prev = null;
        }
        else
        {
            Cell nextCell = first;
            while ( nextCell.next != null){
                nextCell = nextCell.next;
                if ( nextCell.head == item){
                    nextCell.prev.next = nextCell.next;
                    nextCell.next.prev = nextCell.prev;
                    break;
                }


            }
        }

    }


    public void printAllItems(){
        if(first !=null){
            if (first.next==null)
                System.out.println(first.head);
            Cell next = first;
            while(next != null){
                System.out.printf("%s, ",next.head);
                next = next.next;
            }
            System.out.println();
        }
    }


}
