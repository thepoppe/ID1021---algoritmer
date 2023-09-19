public class Cell {
    int head;
    Cell next, prev = null;
    Cell(int val, Cell next) {
        head = val;
        this.next = next;
    }
    Cell(int val, Cell next, Cell prev) {
        head = val;
        this.next = next;
        this.prev =prev;
    }

}
