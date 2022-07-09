import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Terminal {
    private IOService ioService;
    private List<String> list = new ArrayList<>();



     public void operationChoose() {
        ioService.write("Введите цифры, которые хотите добавить (например 3,2,5,6,7)");
        ioService.write("Выберите операцию:");
        ioService.write("Нажмите 1, чтобы добавить элемент в список.");
        ioService.write("Наберите 2, чтобы удалить элемент из списка.");
        ioService.write("Наберите 3, чтобы показать содержимое списка.");
        ioService.write("Наберите 4, чтобы  проверить, есть ли значение в списке.");
        ioService.write("Наберите 5, чтобы  заменить значение в списке.");
        ioService.write("Введите 'exit' для выхода");
        //Integer operation = readOperation();


    }

    private void createList (String str) throws IOException {
        str = ioService.read();
        String[] arr = str.split(",");
        list = Arrays.asList(arr);
    }

    private int readOperation() {
        String operation;
        try {
            if (!(operation = ioService.read()).equals("exit")) {
                Integer operationNumber = Integer.parseInt(operation);
                return operationNumber;
            }
        } catch (IOException e) {
            ioService.writeUnknownError();
            readOperation();
        }
        return 0;
    }


    private int toInt(String str) {
        int strInt = Integer.parseInt(str);
        return strInt;
    }


    private void addElem (String elem) {
        int addElem = toInt(elem);
        list.add(String.valueOf(addElem));
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

    public void run(){
        operationChoose();
    }

}
