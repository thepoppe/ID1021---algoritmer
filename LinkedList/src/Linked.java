public class Linked {
    int first;

    private class Cell{
        int head;
        Cell tail;
        Cell(int val, Cell tl) {
            head = val;
            tail = tl;
        }
    }
}
