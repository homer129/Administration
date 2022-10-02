import java.util.Scanner;
import java.util.HashMap;

public class SimpleUser extends AdminUser implements User {
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

    public String setPrime (HashMap<String, User> allusers) {
        Scanner console10 = new Scanner(System.in);
        System.out.println("enter simpleUserName");
        String simpleUserName = console10.nextLine();
        ((SimpleUser)allusers.get(simpleUserName)).isPrime = true; 
        return  simpleUserName + " is prime";
    }

    public String getUserName() {
        String str = this.userName + "Simple";
        return str;
    }

    public String getUserPassword() {
        return this.password;
    }

    public String getEmail() {
        String str1 = "";
        for (int t = 0; t < this.email.length(); t++) {
            if (this.email.charAt(t) == '.') {
                str1 = str1 + "Simple" + this.email.charAt(t);
            } else {
                str1 = str1 + this.email.charAt(t);
            }
        }
        return str1;
    }

    public Boolean isAdmin() {
        return false;
    }
}
