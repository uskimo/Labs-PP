import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("____________________________________________________________________________________________");
        System.out.println("|  x  |    f     |    f0    |    R1    |    R2    |    R3    | number of changes |");
        System.out.println("_____________________________________________________________________________________________");
        List<Integer> changes=new ArrayList<Integer>();
        for (int x = -10; x <= 10; x++) {
            var f = Math.pow(x, 4) - 4 * Math.pow(x, 3) + 2*x - 8;
            var f0 = 4 * Math.pow(x, 3) - 12 * Math.pow(x, 2) + 2;
            var R1 = 3 * Math.pow(x, 2) - (3 / 2) * x + (15 / 2);
            var R2 = 15 * x - 27;
            var R3 = -14.52;
            var[] arr = new var[]{f, f0, R1, R2, R3};
            int change=0;


            for (int i = 0; i < arr.length - 1; i++) {
                if ((arr[i] < 0 && arr[i + 1] > 0) || (arr[i] > 0 && arr[i + 1] < 0)) change++;
                if(arr[i+1]==0 && ((arr[i]>0 && arr[i+2]<0)||(arr[i]<0 && arr[i+2]>0))) change++;
            }
            changes.add(change);
            System.out.format("|%-5s|%-10s|%-10s|%-10s|%-10s|%-10s|   %-16s|\n", x, f, f0, R1, R2, R3, change);
        }
        System.out.println("____________________________________________________________________________________________");


        System.out.println("\n\n\n_____________________________________________________________________");
        System.out.println("|  x   |   f  |  f0  |  R1  |  R2  |  R3  | number of changes |");
        System.out.println("______________________________________________________________________");
        function();
        System.out.println("_____________________________________________________________________");
        int p, i;
        for(i=0, p=-10;i<changes.size()-1;i++,p++){
            if(changes.get(i)-changes.get(i+1)>0){
                System.out.println("Interval with 1 root:  ["+p+";"+(p+1)+"]");
            }
        }
    }

    public static void function() {
        for (int x = -10; x <= 10; x++) {
            var f = Math.pow(x, 4) - 4 * Math.pow(x, 3) + 2*x - 8;
            var f0 = 4 * Math.pow(x, 3) - 12 * Math.pow(x, 2) + 2;
            var R1 = 3 * Math.pow(x, 2) - (3 / 2) * x + (15 / 2);
            var R2 = 15 * x - 27;
            var R3 = -14.52;
            var arr = new double[]{f, f0, R1, R2, R3};
            int change = 0;

            for (int i = 0; i < arr.length - 1; i++) {
                if ((arr[i] < 0 && arr[i + 1] > 0) || (arr[i] > 0 && arr[i + 1] < 0)) change++;
                if(arr[i+1]==0 && ((arr[i]>0 && arr[i+2]<0)||(arr[i]<0 && arr[i+2]>0))) change++;
            }
            System.out.format("|%-6s|  %-4s|  %-4s|  %-4s| %-4s|  %-4s|   %-16s|\n", x, signs(f), signs(f), signs(R1), signs(R2), signs(R3), change);
        }
    }
    public static String signs(double n) {
        String sign;
        if (n == 0) sign = "0";
        else if (n > 0) sign = "+";
        else sign = "-";
        return sign;
    }
}
