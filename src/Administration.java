import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;

public class Administration {
    static HashMap<String, User> allUser = new HashMap<>();    
    static final String enter = "Enter";
    static final String register = "register";
    static final String enterUserName = "enter userName";
    static final String enterPassword = "enter password";
    static final String enterEmail = "enter email";
    static final String enterIsAdmin = "enter isAdmin";
    static final String login = "login";
    static final String logout = "logout";
    static final String prime = "prime";
    static final String myUsers = "myUsers";
    static final String allUsers = "allUsers";
    static final String exit = "exit";
    static final String enterUserNamePersonalAdmin = "enter userNamePersonalAdmin"; 
    static final String LoginIsUsed = "Login is used";
    static final String isLogedOut = " is loged out.";
    static final String isLogedIn = " is loged in.";
    static final String Null = "null";

    public static void main(String[] args) throws UserException {  
        while (1 > 0) {  
        Scanner console = new Scanner(System.in);
        System.out.println(enter);
        String Enter = console.nextLine();    
        if (Enter.equals(register)) {
            Scanner console1 = new Scanner(System.in);
            System.out.println(enterUserName);
            String username = console1.nextLine();
            Scanner console2 = new Scanner(System.in);
            System.out.println(enterPassword);
            String password = console2.nextLine();
            Scanner console3 = new Scanner(System.in);
            System.out.println(enterEmail);
            String email = console3.nextLine();
            Scanner console4 = new Scanner(System.in);
            System.out.println(enterIsAdmin);
            Boolean isAdmin = console4.nextBoolean();
            Administration.registeredIn(username, password, email, isAdmin);                          
        } if (Enter.equals(login) || Enter.equals(logout)) {
            Administration.loginLogout(Enter);
        } if (Enter.equals(prime)) {
            Scanner console7 = new Scanner(System.in);
            System.out.println(enterUserName);
            String enteruserName = console7.nextLine();
            Scanner console8 = new Scanner(System.in);
            System.out.println(enterPassword);
            String enterpassword = console8.nextLine();
            ArrayList<User> valuesUser = new ArrayList<>(allUser.values());
            for (int d = 0; d < valuesUser.size(); d++) {
                AdminUser admin = ((AdminUser)valuesUser.get(d));
                if (valuesUser.get(d).isAdmin() == true
                    && admin.userName.equals(enteruserName) 
                    && admin.password.equals(enterpassword) 
                    && admin.isLogedIn == true) {
                    SimpleUser simpleUser = new SimpleUser("Anton", "123456", "@.by", false, SimpleUser.RandomNumber(101), false, null);
                    System.out.println(simpleUser.setPrime(allUser));
                } else if (valuesUser.get(d).isAdmin() == true
                && admin.userName.equals(enteruserName) 
                && admin.password.equals(enterpassword) 
                && admin.isLogedIn != true) {
                    throw new UserException("isLogedIn " + admin + " is not true!!!");
                }
            }   
        } if (Enter.equals(myUsers)) {
            AdminUser adminUser = new AdminUser("Anton", "123456", "@.by", false);
            System.out.println(adminUser.getMyUsers(allUser));
        } if (Enter.equals(allUsers)) {
            System.out.println(AdminUser.getAllSimpleUsers(allUser));
        } if (Enter.equals(Null)) {
            throw new UserException("You entered null!!!");
        } if (Enter.equals(exit))
        break;}   
    }
    
    public static void loginLogout(String enter) throws UserException {
        ArrayList<User> valuesUsers = new ArrayList<>(allUser.values());            
        if (enter.equals(login)) {
            Scanner console7 = new Scanner(System.in);
            System.out.println(enterUserName);
            String enteruserName = console7.nextLine();
            Scanner console8 = new Scanner(System.in);
            System.out.println(enterPassword);
            String enterpassword = console8.nextLine();
            Administration.logedIn(valuesUsers, enteruserName, enterpassword); 
        } if (enter.equals(logout)) {
            for (User u : valuesUsers) {
                if (u.isAdmin() == true) {
                    ((AdminUser)u).isLogedIn = false;
                } else {
                    ((SimpleUser)u).isLogedIn = false;
                }                
            }   
        }
    }

    public static void logedIn(ArrayList<User> allUser, String username, String pasword) throws UserException {
        for (int r = 0; r < allUser.size(); r++) {    
            if (allUser.get(r).isAdmin() == true) {
                AdminUser admin = ((AdminUser)allUser.get(r));
                if (admin.userName.equals(username) && admin.password.equals(pasword)) {
                    admin.isLogedIn = true;
                    System.out.println(admin.userName + isLogedIn);
                } else  if (admin.userName.equals(username) && admin.password.equals(pasword) != true) {
                    throw new UserException("Password is not correct!!!");
                }  else {
                    admin.isLogedIn = false;
                }
            } if (allUser.get(r).isAdmin() == false) {
                SimpleUser simple = ((SimpleUser)allUser.get(r));
                if (simple.userName.equals(username) && simple.password.equals(pasword)) {
                    simple.isLogedIn = true;
                    System.out.println(simple.userName + isLogedIn);
                } else  if (simple.userName.equals(username) && simple.password.equals(pasword) != true) {
                    throw new UserException("Password is not correct!!!");
                }  else {
                    simple.isLogedIn = false;
                }
            }            
        }       
    }

    public static void registeredIn (String username, String password, String email, Boolean isAdmin) throws UserException {
        if (isAdmin == true) {
            if (allUser.containsKey(username) == true) {
                System.out.println(LoginIsUsed);
            } else {
                AdminUser adminUser = new AdminUser(username, password, email, false);
                allUser.put(username, adminUser); 
            }                               
        } if (isAdmin == false) {
            Scanner console11 = new Scanner(System.in);
            System.out.println(enterUserNamePersonalAdmin);
            String userNamePersonalAdmin = console11.nextLine();  
            if (allUser.containsKey(userNamePersonalAdmin) == true) {
                if (allUser.containsKey(username)) {
                    System.out.println(LoginIsUsed);
                } else {
                    SimpleUser simpleUser = new SimpleUser(username, password, email, false, SimpleUser.RandomNumber(101), false, ((AdminUser)allUser.get(userNamePersonalAdmin)));
                    allUser.put(username, simpleUser);
                }                    
            } else {
                if (allUser.containsKey(username)) {
                    System.out.println(LoginIsUsed);
                } else {
                    SimpleUser simpleUser = new SimpleUser(username, password, email, false, SimpleUser.RandomNumber(101), false, null);
                    allUser.put(username, simpleUser);
                } 
            }
        }       
    }
}





