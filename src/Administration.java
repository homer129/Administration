import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Administration {
    static HashMap<String, AdminUser> allAdminUser = new HashMap<>();
    static HashMap<String, SimpleUser> allSimpleUser = new HashMap<>();
    static String enter = "Enter";
    static String register = "register";
    static String enterUserName = "enter userName";
    static String enterPassword = "enter password";
    static String enterEmail = "enter email";
    static String enterIsAdmin = "enter isAdmin";
    static String login = "login";
    static String logout = "logout";
    static String prime = "prime";
    static String myUsers = "myUsers";
    static String allUsers = "allUsers";
    static String exit = "exit";
    static String enterUserNamePersonalAdmin = "enter userNamePersonalAdmin"; 
    static String LoginIsUsed = "Login is used";
    static String isLogedOut = " is loged out.";
    static String isLogedIn = " is loged in.";

    public static void main(String[] args){  
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
            Administration.LogedIn(username, password, email, isAdmin);                          
        } if (Enter.equals(login) || Enter.equals(logout)) {
            Administration.loginLogout(Enter);
        } if (Enter.equals(prime)) {
            Scanner console7 = new Scanner(System.in);
            System.out.println(enterUserName);
            String enteruserName = console7.nextLine();
            Scanner console8 = new Scanner(System.in);
            System.out.println(enterPassword);
            String enterpassword = console8.nextLine();
            ArrayList<String> keys = new ArrayList<>(allAdminUser.keySet());
            for (int d = 0; d < keys.size(); d++) {
                if (allAdminUser.get(keys.get(d)).userName.equals(enteruserName) && allAdminUser.get(keys.get(d)).password.equals(enterpassword) && allAdminUser.get(keys.get(d)).isLogedIn == true) {
                    SimpleUser simpleUser = new SimpleUser("Anton", "123456", "@.by", false, SimpleUser.RandomNumber(101), false, null);
                    System.out.println(simpleUser.setPrime(allSimpleUser));
                } 
            }   
        } if (Enter.equals(myUsers)) {
            AdminUser adminUser = new AdminUser("Anton", "123456", "@.by", false);
            System.out.println(adminUser.getMyUsers(allSimpleUser, allAdminUser));
        } if (Enter.equals(allUsers)) {
            System.out.println(AdminUser.getAllSimpleUsers(allSimpleUser, allAdminUser));
        } if (Enter.equals(exit))
        break;}   
    }
    
    public static String loginLogout (String enter) {
        ArrayList<AdminUser> valuesAdmin = new ArrayList<>(allAdminUser.values());
        ArrayList<SimpleUser> valuesSimple = new ArrayList<>(allSimpleUser.values());    
        if (enter.equals(login)) {
            Scanner console7 = new Scanner(System.in);
            System.out.println(enterUserName);
            String enteruserName = console7.nextLine();
            Scanner console8 = new Scanner(System.in);
            System.out.println(enterPassword);
            String enterpassword = console8.nextLine();
            Administration.logedIn(valuesAdmin, valuesSimple, enteruserName, enterpassword);   
        } if (enter.equals(logout)) {
            for (int y = 0; y < valuesAdmin.size(); y++) {
                if (valuesAdmin.get(y).isLogedIn == true) {
                    valuesAdmin.get(y).isLogedIn = false;
                    System.out.println(valuesAdmin.get(y).userName + isLogedOut);
                }
            }
            for (int z = 0; z < valuesSimple.size(); z++) {
                if (valuesSimple.get(z).isLogedIn == true) {
                    valuesSimple.get(z).isLogedIn = false;
                    System.out.println(valuesSimple.get(z).userName + isLogedOut);
                }
            }
        }
        return null;
    }

    public static void logedIn (ArrayList<AdminUser> list, ArrayList<SimpleUser> list1, String username, String pasword) {
        if (allAdminUser.containsKey(username) == true) {
            for (int r = 0; r < list.size(); r++) {
                if (list.get(r).userName.equals(username) && list.get(r).password.equals(pasword)) {
                    list.get(r).isLogedIn = true;
                    System.out.println(list.get(r).userName + isLogedIn);
                } else {
                    list.get(r).isLogedIn = false;
                }
            }
            for (SimpleUser t : list1) {
                t.isLogedIn = false;
            }   
        } if (allSimpleUser.containsKey(username) == true) {
            for (int o = 0; o < list1.size(); o++) {
                if (list1.get(o).userName.equals(username) && list1.get(o).password.equals(pasword)) {
                    list1.get(o).isLogedIn = true;
                    System.out.println(list1.get(o).userName + isLogedIn);
                } else {
                    list1.get(o).isLogedIn = false;
                }
            }
            for (AdminUser l : list) {
                l.isLogedIn = false;
            }               
        }         
    }

    public static void LogedIn (String username, String password, String email, Boolean isAdmin) {
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





