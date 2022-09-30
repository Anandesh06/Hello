import java.util.Scanner;
import java.lang.String;
public class uma
{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String password=sc.nextLine();
        if(password.length()<=15 && password.contains("password@123")) {
            System.out.println("Its fine");
        }
        else {
            System.out.println("enter valid");
        }

        System.out.println("Hello World");
    }
}
