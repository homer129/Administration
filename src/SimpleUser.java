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
}
