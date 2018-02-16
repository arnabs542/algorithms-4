import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class rand {
    public static void main(String[] args) {
        // minimum + (int)(Math.random() * maximum)
        List<Integer> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int randomNum = r.nextInt((3 - 1) + 1) + 1; // range: [1,3]
            list.add(randomNum);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) System.out.println("Floyd");
            else if (list.get(i) == 2) System.out.println("Yuhao");
            else System.out.println("Xueman");
        }
    }
}
