import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Administration {
    static HashMap<String, AdminUser> allAdminUser = new HashMap<>();
    static HashMap<String, SimpleUser> allSimpleUser = new HashMap<>();

    public static void main(String[] args){  
        while (1 > 0) {  
        Scanner console = new Scanner(System.in);
        System.out.println("Enter");
        String Enter = console.nextLine();    
        if (Enter.equals("register")) {
            Scanner console1 = new Scanner(System.in);
            System.out.println("enter userName");
            String username = console1.nextLine();
            Scanner console2 = new Scanner(System.in);
            System.out.println("enter password");
            String password = console2.nextLine();
            Scanner console3 = new Scanner(System.in);
            System.out.println("enter email");
            String email = console3.nextLine();
            Scanner console4 = new Scanner(System.in);
            System.out.println("enter isAdmin");
            Boolean isAdmin = console4.nextBoolean();
            if (isAdmin == true) {
                if (allAdminUser.containsKey(username) == true) {
                    System.out.println("Login is used");
                } else {
                    AdminUser adminUser = new AdminUser(username, password, email, false);
                    allAdminUser.put(username, adminUser); 
                }                               
            } if (isAdmin == false) {
                Scanner console11 = new Scanner(System.in);
                System.out.println("enter userNamePersonalAdmin");
                String userNamePersonalAdmin = console11.nextLine();
                if (allAdminUser.containsKey(userNamePersonalAdmin) == true) {
                    if (allSimpleUser.containsKey(username)) {
                        System.out.println("Login is used");
                    } else {
                        SimpleUser simpleUser = new SimpleUser(username, password, email, false, SimpleUser.RandomNumber(101), false, allAdminUser.get(userNamePersonalAdmin));
                        allSimpleUser.put(username, simpleUser);
                    }                    
                }
            }                
        } if (Enter.equals("login")) {
            Administration.loginLogout(Enter);
        } if (Enter.equals("logout")) {
            Administration.loginLogout(Enter);
        } if (Enter.equals("prime")) {
            Scanner console7 = new Scanner(System.in);
            System.out.println("enter userName");
            String enterUserName = console7.nextLine();
            Scanner console8 = new Scanner(System.in);
            System.out.println("enter password");
            String enterPassword = console8.nextLine();
            ArrayList<String> keys = new ArrayList<>(allAdminUser.keySet());
            for (int d = 0; d < keys.size(); d++) {
                if (allAdminUser.get(keys.get(d)).userName.equals(enterUserName) && allAdminUser.get(keys.get(d)).password.equals(enterPassword) && allAdminUser.get(keys.get(d)).isLogedIn == true) {
                    SimpleUser simpleUser = new SimpleUser("Anton", "123456", "@.by", false, SimpleUser.RandomNumber(101), false, null);
                    System.out.println(simpleUser.setPrime(allSimpleUser));
                } 
            }   
        } if (Enter.equals("myUsers")) {
            AdminUser adminUser = new AdminUser("Anton", "123456", "@.by", false);
            System.out.println(adminUser.getMyUsers(allSimpleUser, allAdminUser));
        } if (Enter.equals("allUsers")) {
            System.out.println(AdminUser.getAllSimpleUsers(allSimpleUser, allAdminUser));
        } if (Enter.equals("exit"))
        break;} 
      

    }
    
    public static String loginLogout (String enter) {
        Scanner console7 = new Scanner(System.in);
        System.out.println("enter userName");
        String enterUserName = console7.nextLine();
        Scanner console8 = new Scanner(System.in);
        System.out.println("enter password");
        String enterPassword = console8.nextLine();
        ArrayList<String> keys = new ArrayList<>(allAdminUser.keySet());
        if (enter.equals("login")) {
            for (int o = 0; o < keys.size(); o++) {
                if (allAdminUser.get(keys.get(o)).userName.equals(enterUserName) && allAdminUser.get(keys.get(o)).password.equals(enterPassword)) {
                    allAdminUser.get(keys.get(o)).isLogedIn = true;
                    System.out.println(enterUserName + " is loged in.");
                } else {
                    allAdminUser.get(keys.get(o)).isLogedIn = false;
                }
            }
        } if (enter.equals("logout")) {
            allAdminUser.get(enterUserName).isLogedIn = false;
            System.out.println(enterUserName + " is loged out.");
        }
        return null;
    }
}



