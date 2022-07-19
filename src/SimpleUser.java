import java.util.Scanner;

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

    public static String setPrime (AdminUser personalAdmin1, SimpleUser[] AR4) {    
        if (personalAdmin1.isLogedIn == true) {
            Scanner console10 = new Scanner(System.in);
            System.out.println("enter userName");
            String enUsNa4 = console10.nextLine();
            for (int r = 0; r < AR4.length; r++) {
                if (AR4[r].userName.equals(enUsNa4)) {
                    AR4[r].isPrime = true;                            
                }
        }
        
    } return null;
}

}
