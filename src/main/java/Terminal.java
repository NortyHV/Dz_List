import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Terminal {

    private void toInt (String str) {
        int strInt = Integer.parseInt(str);
    }

    private List<String> list = new ArrayList<>();

    private void addElem (String elem) {
        list.add(elem);
    }

    private void removeElem (int index) {
        list.remove(index);
    }

    private  void print() {
        System.out.println(list.toString());
    }

    private boolean contains (String str) {
        return list.contains(str);

    }

    private void set (int index, String str){
        list.set(index,str);
    }


}
