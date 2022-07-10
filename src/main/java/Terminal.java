import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Terminal {
    private IOService ioService = new IOService();


    private List<String> list = new ArrayList<>();

    public void run() throws IOException {
        start();
    }

    public void start() throws IOException {
        ioService.write("Введите цифры, которые хотите добавить (например 3,2,5,6,7)");
        createList();
        operationChoose();
    }




     public void operationChoose() throws IOException {

        ioService.write("Выберите операцию:");
        ioService.write("Нажмите 1, чтобы добавить элемент в список.");
        ioService.write("Наберите 2, чтобы удалить элемент из списка.");
        ioService.write("Наберите 3, чтобы показать содержимое списка.");
        ioService.write("Наберите 4, чтобы  проверить, есть ли значение в списке.");
        ioService.write("Наберите 5, чтобы  заменить значение в списке.");
        ioService.write("Введите 'exit' для выхода");
        Integer operation = readOperation();
         switch (operation) {
             case 0:

                 break;
             case 1:
                 addElem();
                 operationChoose();
                 break;
             case 2:
                 removeElem ();
                 operationChoose();

                 break;
             case 3:
                 System.out.println("Ваш список: ");
                 print();
                 operationChoose();
                 break;
             case 4:

                 break;
             default:
         }
     }




    public void createList () throws IOException {
        String str = ioService.read();
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
        try {
            int temp = Integer.parseInt(str);
        }
        catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
         return Integer.parseInt(str);

    }


    private void addElem () throws IOException {
        String elem = ioService.read();
        list.add(0, elem);
        System.out.println("ВЫ добавили в список элемент: " + elem);
    }

    private void removeElem () throws IOException {
        String str = ioService.read();
        int index = toInt(str);
        if (index >= 0 && index <= list.size()) {
        list.remove(index);
        System.out.println("ВЫ удачно удалили  элемент из списка ");
       } else {
            System.out.println("Вы ввели неправильный номер элемента");
        }
    }

    private  void print() {
        System.out.println(list.toString());
    }

    private boolean contains (String str) {
         int temp = toInt(str);
        return list.contains(temp);

    }

    private void set (int index, String str){
        list.set(index,str);
    }



}
