import java.util.Scanner;

public class Administration {
    public static void main(String[] args){
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
            if (isAdmin==true) {
                AdminUser AU1 = new AdminUser(enUsNa, enPa, enEm);
                System.out.println(AU1.email);
            } if (isAdmin==false) {
                SimpleUser SU1 = new SimpleUser(enUsNa, enPa, enEm);
                System.out.println(SimpleUser.accountNumber);
                System.out.println(SU1.email);
            }
            
        }
    }    
}


