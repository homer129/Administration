import java.util.Scanner;
import java.util.HashMap;

public class SimpleUser extends AdminUser {
    public static Integer accountNumber; 
    public Boolean isPrime;
    public AdminUser personalAdmin; 
    public SimpleUser(String userName, String password, String email, Boolean isLogedIn, Integer accountNumber, Boolean isPrime, AdminUser personalAdmin) {
        super(userName, password, email, isLogedIn);
        this.accountNumber = accountNumber;
        this.isPrime = isPrime;
        this.personalAdmin = personalAdmin;
    }    

    public static Integer RandomNumber(int sample) {
        int randomNumber = (int) (Math.random() * sample);
        return randomNumber;
    } 

    public String setPrime (HashMap<String, SimpleUser> allsimpleusers) {
        Scanner console10 = new Scanner(System.in);
        System.out.println("enter simpleUserName");
        String simpleUserName = console10.nextLine();
        allsimpleusers.get(simpleUserName).isPrime = true; 
        return  simpleUserName + " is prime";
    }
}
