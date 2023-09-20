public class SinglyLinked implements LinkedLists {
    Cell first;


    public void insert(Cell cellToInsert){
        if (cellToInsert != null){
            cellToInsert.next = first;
            first = cellToInsert;
        }
    }

    public void unlink(Cell cellToUnlink){
        if (cellToUnlink == first)
            first = first.next;
        else{
            Cell next = first.next;
            Cell prev = first;
            while ( next.next != null && next != cellToUnlink){
                prev = next;
                next = next.next;
            }
            if(next == cellToUnlink)
                prev.next = next.next;
        }
    }

    void add(int item){
        if (first == null)
            first = new Cell(item, null);
        else {
            Cell currentCell = new Cell(item,first);
            first = currentCell;
        }
    }

    int length(){
        int size = 0;
        if (first == null)
            return size;
        Cell currentCell = first;
        while (currentCell != null){
            size++;
            currentCell = currentCell.next;
        }
        return size;
    }

    boolean find(int item){
        if (first == null)
            throw new IllegalArgumentException("No elements in the list");
        Cell currentCell = first;
        while (currentCell!=null){
            if(currentCell.head == item)
                return true;
            currentCell = currentCell.next;
        }
        return false;
    }


    void remove(int item){
        if (first == null)
            throw new IllegalArgumentException("List is empty");
        if (first.head == item)
            first = first.next;

        else {
            Cell currentCell = first;
            boolean found = false;
            while (currentCell.next != null) {
                if (currentCell.next.head == item) {
                    found = true;
                    break;
                }
                currentCell = currentCell.next;
            }
            if (!found)
                throw new IllegalArgumentException("No such element in the list");

            currentCell.next = currentCell.next.next;
        }
    }


    void remove2(int item){
        if (first == null)
            throw new IllegalArgumentException("List is empty");
        if (first.head == item)
            first = first.next;

        else {
            Cell currentCell = first;
            Cell prevCell = null;
            while (currentCell.next != null) {
                prevCell =currentCell;
                currentCell = currentCell.next;
            }
            if (prevCell != null) {
                prevCell.next = null;
            }
        }
    }


    public void append(SinglyLinked secondList) {
        if (this.first == null)
            this.first = secondList.first;
        else if (secondList.first != null) {
            Cell currentCell = this.first;
            Cell prev = null;
            while (currentCell != null) {
                prev = currentCell;
                currentCell = currentCell.next;
            }
            prev.next = secondList.first;
            secondList.first = null;
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

    public int getLastElement() {
        if (first == null)
            throw new IllegalArgumentException("The list is empty");

        int value;
        if ( first.next == null){
            value = first.head;
            first = null;
        }
        else {
            Cell currentCell = first;
            Cell prevCell = null;
            while (currentCell.next != null) {
                prevCell = currentCell;
                currentCell = currentCell.next;
            }
            value = currentCell.head;
            prevCell.next = null;
        }

        return value;
    }

    SinglyLinked(int n) {
        Cell last = null;
        for (int i = 0; i < n; i++) {
            last = new Cell(i, last);
        }
        first = last;
    }



}
