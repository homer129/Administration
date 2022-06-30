import java.util.Scanner;

public class Administration {
    public static void main(String[] args){
        AdminUser AU2 = new AdminUser("Nick", "123456", "q@.ru", true);
        AdminUser AU3 = new AdminUser("Mick", "123456", "w@.ru", false);
        AdminUser AU4 = new AdminUser("Wick", "123456", "e@.ru", false);
        AdminUser[] auAr = {AU2, AU3, AU4};
        SimpleUser SU2 = new SimpleUser("Han", "123456", "r@.ru", false, 0, false,  AU3);
        SimpleUser SU3 = new SimpleUser("Man", "123456", "t.ru", false, 0, false, AU3);
        SimpleUser SU4 = new SimpleUser("San", "123456", "y@.ru", false, 0, false, AU3);
        SimpleUser[] suAr = {SU2, SU3, SU4};
        while (0 < 1) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter");
        String Enter = console.nextLine(); 
        if (Enter.equals("register")) {
            Scanner console1 = new Scanner(System.in);
            System.out.println("enter userName");
            String enUsNa = console1.nextLine();
            Scanner console2 = new Scanner(System.in);
            System.out.println("enter password");
            String enPa = console2.nextLine();
            Scanner console3 = new Scanner(System.in);
            System.out.println("enter email");
            String enEm = console3.nextLine();
            Scanner console4 = new Scanner(System.in);
            System.out.println("enter isAdmin");
            Boolean isAdmin = console4.nextBoolean();
            if (isAdmin == true) {
                AdminUser AU1 = new AdminUser(enUsNa, enPa, enEm, false);                
            } if (isAdmin == false) {
                int aN = (int) (Math.random() * 101);
                Scanner console11 = new Scanner(System.in);
                System.out.println("enter userNamePersonalAdmin");
                String usNaPeAd = console11.nextLine();
                for (int a = 0; a < auAr.length; a++){
                    if (auAr[a].userName.equals(usNaPeAd)) {
                        AdminUser personalAdmin = auAr[a];
                        SimpleUser SU1 = new SimpleUser(enUsNa, enPa, enEm, false, aN, false, personalAdmin);
                    }
                }
            }                
            } if (Enter.equals("login")) {
            Scanner console5 = new Scanner(System.in);
            System.out.println("enter userName");
            String enUsNa1 = console5.nextLine();
            Scanner console6 = new Scanner(System.in);
            System.out.println("enter password");
            String enPa1 = console6.nextLine();
            for (int i = 0; i < auAr.length; i++) {
                if (auAr[i].userName.equals(enUsNa1) & auAr[i].password.equals(enPa1)) {
                    auAr[i].isLogedIn = true;                    
                }
            } for (int j = 0; j < suAr.length; j++) {
                if (suAr[j].userName.equals(enUsNa1) & suAr[j].password.equals(enPa1)) {
                    suAr[j].isLogedIn = true;                    
                }
            } 
        } if (Enter.equals("logout")) {
            Scanner console7 = new Scanner(System.in);
            System.out.println("enter userName");
            String enUsNa2 = console7.nextLine();
            Scanner console8 = new Scanner(System.in);
            System.out.println("enter password");
            String enPa2 = console8.nextLine();
            for (int k = 0; k < auAr.length; k++) {
                if (auAr[k].userName.equals(enUsNa2) & auAr[k].password.equals(enPa2)) {
                    auAr[k].isLogedIn = false;                    
                }
            } for (int l = 0; l < suAr.length; l++) {
                if (suAr[l].userName.equals(enUsNa2) & suAr[l].password.equals(enPa2)) {
                    suAr[l].isLogedIn = false;                    
                }
            } 
        } if (Enter.equals("prime")) {
            Scanner console9 = new Scanner(System.in);
            System.out.println("enter userName");
            String enUsNa3 = console9.nextLine();
            for (int h = 0; h < auAr.length; h++) {
                if (auAr[h].userName.equals(enUsNa3) & auAr[h].isLogedIn == true) {
                    Scanner console10 = new Scanner(System.in);
                    System.out.println("enter userName");
                    String enUsNa4 = console10.nextLine();
                    for (int r = 0; r < suAr.length; r++) {
                        if (suAr[r].userName.equals(enUsNa4)) {
                            suAr[r].isPrime = true;                            
                        }
                    }
                }
            } 
        } if (Enter.equals("exit")) 
        break; 
    }  

    }   
}



