public class Linked implements LinkedLists {
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
            Cell nextCell = new Cell(item,first);
            first = nextCell;
        }
    }

    int length(){
        int size = 0;
        if (first == null)
            return size;
        Cell nextCell = first;
        while (nextCell != null){
            size++;
            nextCell = nextCell.next;
        }
        return size;
    }

    boolean find(int item){
        if (first == null)
            throw new IllegalArgumentException("No elements in the list");
        Cell nextCell = first;
        while (nextCell!=null){
            if(nextCell.head == item)
                return true;
            nextCell = nextCell.next;
        }
        return false;
    }


    void remove(int item){
        if (first == null)
            throw new IllegalArgumentException("List is empty");
        if (first.head == item)
            first = first.next;

        else {
            Cell nextCell = first;
            boolean found = false;
            while (nextCell.next != null) {
                if (nextCell.next.head == item) {
                    found = true;
                    break;
                }
                nextCell = nextCell.next;
            }
            if (!found)
                throw new IllegalArgumentException("No such element in the list");

            nextCell.next = nextCell.next.next;
        }
    }


    void remove2(int item){
        if (first == null)
            throw new IllegalArgumentException("List is empty");
        if (first.head == item)
            first = first.next;

        else {
            Cell nextCell = first;
            Cell prevCell = null;
            while (nextCell.next != null) {
                prevCell =nextCell;
                nextCell = nextCell.next;
            }
            if (prevCell != null) {
                prevCell.next = null;
            }
        }
    }


    public void append(Linked secondList) {
        if (this.first == null)
            this.first = secondList.first;
        else if (secondList.first != null) {
            Cell next = this.first;
            Cell prev = null;
            while (next != null) {
                prev = next;
                next = next.next;
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
            Cell nextCell = first;
            Cell prevCell = null;
            while (nextCell.next != null) {
                prevCell = nextCell;
                nextCell = nextCell.next;
            }
            value = nextCell.head;
            prevCell.next = null;
        }

        return value;
    }

    Linked(int n) {
        Cell last = null;
        for (int i = 0; i < n; i++) {
            last = new Cell(i, last);
        }
        first = last;
    }



}
