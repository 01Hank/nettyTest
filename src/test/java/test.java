import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(0);
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        arr1.add(5);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.addAll(arr1.subList(0,5));
        System.out.println(arr2.toString());


    }
}
