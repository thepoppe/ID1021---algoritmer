public class DoublyLinked implements LinkedLists {
    Cell first;


    DoublyLinked(int n) {
        Cell last = null,trailingLast;
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
            cellToInsert.prev = null;
            cellToInsert.next = first;
            first = cellToInsert;

        }
    }

    public void unlink(Cell cellToUnlink){
        if (cellToUnlink == null)
            throw new IllegalArgumentException("The cell to unlink is null");
        if (cellToUnlink == first)
            first = first.next;
        else if (cellToUnlink.next == null)
            cellToUnlink.prev.next = null;

        else{
            cellToUnlink.prev.next = cellToUnlink.next;
            cellToUnlink.next.prev = cellToUnlink.prev;
        }

    }



    void add(int item){first = new Cell(item,first, null );}

    int length(){
        if (first == null)
            return 0;
        Cell currentCell = first;
        int size =0;
        while (currentCell != null){
            size++;
            currentCell = currentCell.next;
        }
        return size;
    }

    boolean find(int item){
        if (first == null)
            return false;
        Cell currentCell = first;
        while (currentCell!=null){
            if (currentCell.head == item)
                return true;
            else currentCell = currentCell.next;
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
            Cell currentCell = first;
            while ( currentCell.next != null){
                currentCell = currentCell.next;
                if ( currentCell.head == item){
                    currentCell.prev.next = currentCell.next;
                    currentCell.next.prev = currentCell.prev;
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
