
package thjava1;
import java.util.Scanner;
public class ThuVien {
    public static int getInt(String mess){
        Scanner sc= new Scanner(System.in);
        System.out.println(mess);
        return sc.nextInt();
    }
    public static Double getDouble(String mess){
        Scanner sc= new Scanner(System.in);
        System.out.println(mess);
        return sc.nextDouble();
    }
    public static String getString(String mess){
        Scanner sc= new Scanner(System.in);
        System.out.println(mess);
        return sc.nextLine();
    }
}
