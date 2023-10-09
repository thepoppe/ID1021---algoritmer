import java.util.ArrayList;
import java.util.List;

public class FirstPriority {

    List<Integer> constantAdd;
    List<Integer> constantRemove;


    FirstPriority(String constantAddRemove){
        if(constantAddRemove.compareToIgnoreCase("add") == 0){
            constantAdd = new ArrayList<>();
            constantRemove = null;
        }
        else if (constantAddRemove.compareToIgnoreCase("remove") == 0){
            constantRemove = new ArrayList<>();
            constantAdd = null;
        }

        else throw new IllegalArgumentException("constant add or remove needed");
    }

    public void add(int item){
        if(constantAdd != null){
            constantAdd.add(item);
        }
        else if (constantRemove != null){
            int i = 0;
            //sparar störst först
            while(i < constantRemove.size() && constantRemove.get(i).compareTo(item) > 0){
                i++;
            }
            constantRemove.add(i,item);
            /*
            if(i == constantRemove.size())
                constantRemove.add(item);
            else {
                Integer currentItem = constantRemove.get(i);
                constantRemove.add(i, item);

                //move smaller objects back
                int j = i + 1;
                while (j < constantRemove.size()) {
                    Integer next = constantRemove.get(j);
                    constantRemove.add(j, currentItem);
                    currentItem = next;
                    j++;
                }
            }*/
        }
        else return;
    }

    public Integer remove(){
        if (constantAdd != null){
            int i = 1;
            Integer minIndex = 0;
            Integer minVal = constantAdd.get(minIndex);
            while (i < constantAdd.size()){
                if (minVal.compareTo(constantAdd.get(i)) < 0) {
                    minIndex = i;
                    minVal = constantAdd.get(i);
                }
                i++;
            }
            constantAdd.remove(minIndex);
            return minVal;
        }
        else if ( constantRemove != null) {
            return constantRemove.remove(constantRemove.size()-1);
        }
        else return null;
    }


    public void clear() {
        if(constantAdd!=null)
            constantAdd.clear();
        else if (constantRemove != null)
            constantRemove.clear();
    }
}
