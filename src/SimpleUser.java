public class SimpleUser extends AdminUser {
    public static Integer accountNumber = (int) (Math.random() * 101);
    public Boolean isPrime;
    public AdminUser personalAdmin; 
    public SimpleUser(String userName, String password, String email) {
        super(userName, password, email);
    }   
}
