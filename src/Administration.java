import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;

public class Administration {
    static HashMap<String, AdminUser> allAdminUser = new HashMap<>();
    static HashMap<String, SimpleUser> allSimpleUser = new HashMap<>();
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
            ArrayList<AdminUser> valuesAdmin = new ArrayList<>(allAdminUser.values());
            for (int d = 0; d < valuesAdmin.size(); d++) {
                if (valuesAdmin.get(d).userName.equals(enteruserName) && valuesAdmin.get(d).password.equals(enterpassword) && valuesAdmin.get(d).isLogedIn == true) {
                    SimpleUser simpleUser = new SimpleUser("Anton", "123456", "@.by", false, SimpleUser.RandomNumber(101), false, null);
                    System.out.println(simpleUser.setPrime(allSimpleUser));
                } else if (valuesAdmin.get(d).userName.equals(enteruserName) && valuesAdmin.get(d).password.equals(enterpassword) && valuesAdmin.get(d).isLogedIn != true) {
                    throw new UserException("isLogedIn " + valuesAdmin.get(d).userName + " is not true!!!");
                }
            }   
        } if (Enter.equals(myUsers)) {
            AdminUser adminUser = new AdminUser("Anton", "123456", "@.by", false);
            System.out.println(adminUser.getMyUsers(allSimpleUser, allAdminUser));
        } if (Enter.equals(allUsers)) {
            System.out.println(AdminUser.getAllSimpleUsers(allSimpleUser, allAdminUser));
        } if (Enter.equals(Null)) {
            throw new UserException("You entered null!!!");
        } if (Enter.equals(exit))
        break;}   
    }
    
    public static void loginLogout(String enter) throws UserException {
        ArrayList<User> allusers = new ArrayList<User>();
        ArrayList<AdminUser> alladminusers = new ArrayList<>(allAdminUser.values());
        for (AdminUser k : alladminusers) {
            allusers.add(k);
        }
        ArrayList<SimpleUser> allsimpleusers = new ArrayList<>(allSimpleUser.values());
        for (SimpleUser l : allsimpleusers) {
            allusers.add(l);            
        } if (enter.equals(login)) {
            Scanner console7 = new Scanner(System.in);
            System.out.println(enterUserName);
            String enteruserName = console7.nextLine();
            Scanner console8 = new Scanner(System.in);
            System.out.println(enterPassword);
            String enterpassword = console8.nextLine();
            Administration.logedIn(allusers, enteruserName, enterpassword); 
        } if (enter.equals(logout)) {
            /*for (int i = 0; i < allusers.size(); i++) {
                if (allusers.get(i).isAdmin() == true) {
                    ((AdminUser)allusers.get(i)).isLogedIn = false;                              
                } else {
                    ((SimpleUser)allusers.get(i)).isLogedIn = false;
                }
            }*/
            for (User u : allusers) {
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
                if (((AdminUser)allUser.get(r)).userName.equals(username) && ((AdminUser)allUser.get(r)).password.equals(pasword)) {
                    ((AdminUser)allUser.get(r)).isLogedIn = true;
                    System.out.println(((AdminUser)allUser.get(r)).userName + isLogedIn);
                } else  if (((AdminUser)allUser.get(r)).userName.equals(username) && ((AdminUser)allUser.get(r)).password.equals(pasword) != true) {
                    throw new UserException("Password is not correct!!!");
                }  else {
                    ((AdminUser)allUser.get(r)).isLogedIn = false;
                }
            } if (allUser.get(r).isAdmin() == false) {
                if (((SimpleUser)allUser.get(r)).userName.equals(username) && ((SimpleUser)allUser.get(r)).password.equals(pasword)) {
                    ((SimpleUser)allUser.get(r)).isLogedIn = true;
                    System.out.println(((SimpleUser)allUser.get(r)).userName + isLogedIn);
                } else  if (((SimpleUser)allUser.get(r)).userName.equals(username) && ((SimpleUser)allUser.get(r)).password.equals(pasword) != true) {
                    throw new UserException("Password is not correct!!!");
                }  else {
                    ((SimpleUser)allUser.get(r)).isLogedIn = false;
                }
            }            
        }       
    }

    public static void registeredIn (String username, String password, String email, Boolean isAdmin) throws UserException {
        if (isAdmin == true) {
            if (allAdminUser.containsKey(username) == true) {
                System.out.println(LoginIsUsed);
            } else {
                AdminUser adminUser = new AdminUser(username, password, email, false);
                allAdminUser.put(username, adminUser); 
            }                               
        } if (isAdmin == false) {
            Scanner console11 = new Scanner(System.in);
            System.out.println(enterUserNamePersonalAdmin);
            String userNamePersonalAdmin = console11.nextLine();  
            if (allAdminUser.containsKey(userNamePersonalAdmin) == true) {
                if (allSimpleUser.containsKey(username)) {
                    System.out.println(LoginIsUsed);
                } else {
                    SimpleUser simpleUser = new SimpleUser(username, password, email, false, SimpleUser.RandomNumber(101), false, allAdminUser.get(userNamePersonalAdmin));
                    allSimpleUser.put(username, simpleUser);
                }                    
            } else {
                if (allSimpleUser.containsKey(username)) {
                    System.out.println(LoginIsUsed);
                } else {
                    SimpleUser simpleUser = new SimpleUser(username, password, email, false, SimpleUser.RandomNumber(101), false, null);
                    allSimpleUser.put(username, simpleUser);
                } 
            }
        }       
    }
}





