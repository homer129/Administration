import java.util.ArrayList;

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
    
    public static String getMyUsers (SimpleUser[] AR) {
        ArrayList<SimpleUser> List = new ArrayList<>();
        for (int b = 0; b < AR.length; b++) {
            if (AR[b].isLogedIn==true) {
                List.add(AR[b]);
            }
        }
        String str = List.toString();
        String newStr = "";
        for (int g = 0; g < str.length(); g++){
            if (str.charAt(g) != '[' && str.charAt(g) != ']') {
                newStr += str.charAt(g);
            }
        }
        return newStr;
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
