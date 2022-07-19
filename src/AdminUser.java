import java.util.ArrayList;
import java.util.HashMap;

public class AdminUser {
    public String userName;
    public String password;
    public String email;
    public Boolean isLogedIn;

    public AdminUser(String userName, String password, String email, Boolean isLogedIn) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isLogedIn = isLogedIn;
    }
    
    public  ArrayList<SimpleUser> getMyUsers (HashMap<String, SimpleUser> allsimpleusers, HashMap<String, AdminUser> alladminusers) {
        ArrayList<AdminUser> allAdminUsers = new ArrayList<>(alladminusers.values());
        ArrayList<AdminUser> myAdmin = new ArrayList<>();
        for (int p = 0; p < allAdminUsers.size(); p++) {
            if (allAdminUsers.get(p).isLogedIn == true) {
                myAdmin.add(allAdminUsers.get(p));
            }
        }
        ArrayList<SimpleUser> allSimpleUsers = new ArrayList<>(allsimpleusers.values());
        ArrayList<SimpleUser> mySimpleUsers = new ArrayList<>();
        for (int b = 0; b < allSimpleUsers.size(); b++) {
            if (allSimpleUsers.get(b).personalAdmin == myAdmin.get(0)) {
                mySimpleUsers.add(allSimpleUsers.get(b));
            }
        }
        return mySimpleUsers;

        /*String str = mySimpleUsers.toString();
        String newStr = "";
        for (int g = 0; g < str.length(); g++){
            if (str.charAt(g) != '[' && str.charAt(g) != ']') {
                newStr += str.charAt(g);
            }
        }
        return newStr;*/
    }

    public static String getAllSimpleUsers(AdminUser[] AR1, SimpleUser[] AR2) {
        ArrayList<AdminUser> List1 = new ArrayList<>();
        ArrayList<SimpleUser> List2 = new ArrayList<>();
        for (int c = 0; c < AR1.length; c++){
            List1.add(AR1[c]);
        }
        for (int d = 0; d < AR2.length; d++){
            List2.add(AR2[d]);
        }
        String str1 = List1.toString() + ", " + List2.toString();
        String newStr1 = "";
        for (int e = 0; e < str1.length(); e++){
            if (str1.charAt(e) != '[' && str1.charAt(e) != ']') {
                newStr1 += str1.charAt(e);
            }
        }
        return newStr1;
    }
}
