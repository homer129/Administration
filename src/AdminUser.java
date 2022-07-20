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
    
    public ArrayList<SimpleUser> getMyUsers (HashMap<String, SimpleUser> allsimpleusers, HashMap<String, AdminUser> alladminusers) {
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

    public static String getAllSimpleUsers(HashMap<String, SimpleUser> allsimpleusers, HashMap<String, AdminUser> alladminusers) {
        ArrayList<AdminUser> allAdminusers = new ArrayList<>(alladminusers.values());
        ArrayList<SimpleUser> allSimpleusers = new ArrayList<>(allsimpleusers.values());
        String str1 = allAdminusers.toString() + ", " + allSimpleusers.toString();
        String str2 = "";
        for (int t = 0; t < str1.length(); t++) {
            if (str1.charAt(t) != '[' && str1.charAt(t) != ']') {
                str2 += str1.charAt(t);
            }
        }
        return str2;
    }
}
