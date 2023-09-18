public class NewDeck {
    public Cell first;

    private class Cell{
        Card card;
        Cell rest;
    }

    public NewDeck(){
        first = null;
    }

}
