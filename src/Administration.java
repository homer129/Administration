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
                } else {
                    if (allSimpleUser.containsKey(username)) {
                        System.out.println("Login is used");
                    } else {
                        SimpleUser simpleUser = new SimpleUser(username, password, email, false, SimpleUser.RandomNumber(101), false, null);
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
        ArrayList<AdminUser> values = new ArrayList<>(allAdminUser.values());
        ArrayList<SimpleUser> values1 = new ArrayList<>(allSimpleUser.values());    
        if (enter.equals("login")) {
            Scanner console7 = new Scanner(System.in);
            System.out.println("enter userName");
            String enterUserName = console7.nextLine();
            Scanner console8 = new Scanner(System.in);
            System.out.println("enter password");
            String enterPassword = console8.nextLine();
            if (allAdminUser.containsKey(enterUserName) == true) {
                Administration.loginAdmin(values, values1, enterUserName, enterPassword);    
            } if (allSimpleUser.containsKey(enterUserName) == true) {
                Administration.loginUser(values1, values, enterUserName, enterPassword);                
            }    
        } if (enter.equals("logout")) {
            for (int y = 0; y < values.size(); y++) {
                if (values.get(y).isLogedIn == true) {
                    values.get(y).isLogedIn = false;
                    System.out.println(values.get(y).userName + " is loged out.");
                }
            }
            for (int z = 0; z < values1.size(); z++) {
                if (values1.get(z).isLogedIn == true) {
                    values1.get(z).isLogedIn = false;
                    System.out.println(values1.get(z).userName + " is loged out.");
                }
            }
        }
        return null;
    }

    public static void loginAdmin (ArrayList<AdminUser> list, ArrayList<SimpleUser> list1, String username, String pasword) {
        for (int r = 0; r < list.size(); r++) {
            if (list.get(r).userName.equals(username) && list.get(r).password.equals(pasword)) {
                list.get(r).isLogedIn = true;
                System.out.println(list.get(r).userName + " is loged in.");
            } else {
                list.get(r).isLogedIn = false;
            }
        }
        for (int t = 0; t < list1.size(); t++) {
            list1.get(t).isLogedIn = false;
        }
    }

    public static void loginUser (ArrayList<SimpleUser> list2, ArrayList<AdminUser> list3, String username1, String pasword1) {
        for (int o = 0; o < list2.size(); o++) {
            if (list2.get(o).userName.equals(username1) && list2.get(o).password.equals(pasword1)) {
                list2.get(o).isLogedIn = true;
                System.out.println(list2.get(o).userName + " is loged in.");
            } else {
                list2.get(o).isLogedIn = false;
            }
        }
        for (int l = 0; l < list3.size(); l++) {
            list3.get(l).isLogedIn = false;
        }
    }
}





