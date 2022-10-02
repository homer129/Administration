import java.util.ArrayList;
import java.util.HashMap;

public class AdminUser implements User {
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
    
    public ArrayList<SimpleUser> getMyUsers (HashMap<String, User> allusers) {
        ArrayList<User> allUsers = new ArrayList<>(allusers.values());
        ArrayList<AdminUser> myAdmin = new ArrayList<>();
        for (int p = 0; p < allUsers.size(); p++) {
            if (allUsers.get(p).isAdmin() == true && ((AdminUser)allUsers.get(p)).isLogedIn == true) {
                myAdmin.add(((AdminUser)allUsers.get(p)));
            }
        }
        ArrayList<SimpleUser> mySimpleUsers = new ArrayList<>();
        for (int b = 0; b < allUsers.size(); b++) {
            if (allUsers.get(b).isAdmin() == false && (((SimpleUser)allUsers.get(b)).personalAdmin == myAdmin.get(0))) {
                mySimpleUsers.add(((SimpleUser)allUsers.get(b)));
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

    public static ArrayList<User> getAllSimpleUsers(HashMap<String, User> allusers) {
        ArrayList<User> allUsers = new ArrayList<User>(allusers.values());   
        /*String str1 = allUsers.toString();
        String str2 = "";
        for (int t = 0; t < str1.length(); t++) {
            if (str1.charAt(t) != '[' && str1.charAt(t) != ']') {
                str2 += str1.charAt(t);
            }
        }*/
        return allUsers;
    }

    public String getUserName() {
        String str = this.userName + "Admin";
        return str;
    }

    public String getUserPassword() {
        return this.password;
    }

    public String getEmail() {
        String str1 = "";
        for (int t = 0; t < this.email.length(); t++) {
            if (this.email.charAt(t) == '.') {
                str1 = str1 + "Admin" + this.email.charAt(t);
            } else {
                str1 = str1 + this.email.charAt(t);
            }
        }
        return str1;
    }

    public Boolean isAdmin() {
        return true;
    }
}
