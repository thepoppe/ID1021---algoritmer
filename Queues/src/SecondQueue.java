public class SecondQueue {


    private int capacity; // n
    private int first;      // i
    private int last;       // k =  first free spot

    private Integer[] array;

    public SecondQueue() {
        this.first = 0;
        this.last = 0;
        this.capacity = 5;
        this.array = new Integer[capacity];
    }

    public void add(Integer item) {
        if (last + 1 == first || (first == 0 && last == capacity - 1)) {
            enlargeQueue();
            array[last++] = item;
        }

        else if (last == capacity -1) {
                array[last] = item;
                last = 0;
            }
        else {
                array[last++] = item;
            }

        }

        public void addModulo(Integer item){
            if ((last + 1) % capacity == first) {
                enlargeQueue();
            }

            array[last] = item;
            last = (last + 1) % capacity;
        }
        public Integer remove () {

            if (first == last) {
                return null;
            }
            Integer value;
            if (first == capacity - 1) {
                value = array[first];
                array[first] =null;
                first = 0;
            } else {
                value = array[first];
                array[first++] = null;
            }


            return value;
        }

        public Integer removeModulo(){
            if (first == last)
                return null;
            Integer value = array[first];
            array[first] = null;
            first = (first +1) %capacity;
            return value;
        }



    private void enlargeQueue() {
        Integer[] largerArray = new Integer[capacity*2];
        for (int i = 0; i< capacity-1; i++){
            if (first == capacity-1) {
                largerArray[i] = this.array[first];
                first = 0;
            }
            else
                largerArray[i] = this.array[first++];
        }
        this.array = largerArray;
        first = 0;
        last = capacity;
        this.capacity *=2;
    }
}