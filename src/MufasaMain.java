
import java.util.Vector;
import java.util.Iterator;
import java.util.Vector;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MufasaMain {
   
   public static void main(String [] args){
      Scanner sc = new Scanner(System.in);

      MufasaRepository mufasaAccounts = MufasaRepository.getInstance();
      int valinta = 0;
      double moneyAmount  = 0;
      String firstName;
      String lastName;
      String username;
      String password;
      
      do{
         tulostaValikko ();
         valinta = lueInt();
         
         
         switch ( valinta ){
            case 1:
               System.out.print("Please enter your first name  -> ");
               firstName = sc.nextLine();
               
               System.out.print("Please enter your last name  -> ");
               lastName = sc.nextLine();
               
               System.out.print("Please enter your username  -> ");
               username = sc.nextLine();
               
               System.out.print("Please enter your password  -> ");
               password = sc.nextLine();
               
               System.out.print("Insert amount of Euros->");
               moneyAmount = lueDouble();
               
               mufasaAccounts.addMufasa( new Mufasa(firstName, lastName, username, password, moneyAmount) );
               break;
               
            case 2:
               Mufasa p = null;
               if((p=mufasaAccounts.removeLast())!= null){
                  
                  
                  System.out.print( p +"  has been removed from mufasaAccount list");
               }else{
                  System.out.println("No Mufasa accounts!");
               }
               break;
               
            case 3:
               MufasaRepository repo = MufasaRepository.getInstance();
               //System.out.println("Repo");
               //repo.tulosta();
               System.out.println("Accounts");
               mufasaAccounts.tulosta();
               break;
               
            case 4:
                boolean status = mufasaAccounts.tallennaTiedostoon("accounts.dat");
                if (status = false)
                	System.out.println("not working!");
                break;
               
            case 5:
                mufasaAccounts.lueTiedostosta("accounts.dat");
            
                break;
                              
            case 0:
               System.out.print("Program stops.");
               break;
               
            default:
               System.out.print("wrong choise, try again.");
         }
         
      }while ( valinta != 0);
   }
   
   /*public static void tulostaSailio(final Vector<Double> mufasaAccounts ){
      
      Iterator<Double> iter = mufasaAccounts.iterator();
      
      while( iter.hasNext()){
         System.out.println(iter.next());
      }
      
      
   }*/
   public static void tulostaValikko() {
      System.out.println("\n\n 1) Add new mufasaAccount");
      System.out.println(" 2) Remove mufasaAccount");
      System.out.println(" 3) Print mufasaAccounts content");
      System.out.println(" 4) save mufasaAccounts content");
      System.out.println(" 5) Read mufasaAccounts from file");
      System.out.println(" 0) Stop");
      System.out.print("\nYour Choise > ");
   }
   
   public static int lueInt(){
      Scanner sc = new Scanner(System.in);
      boolean ok = false;
      int luku = 0;
      
      do {
         
         try {
            luku = sc.nextInt();
            sc.nextLine();
            ok = true;
         }catch( InputMismatchException ime ){
            sc.nextLine();
            System.out.print("Mistake, try again > ");
         }
         
      }while(!ok);
      
      return luku;
      
   }
   
   public static double lueDouble(){
      Scanner sc = new Scanner(System.in);
      boolean ok = false;
      double luku = 0.0;
      
      do {
         
         try {
            luku = sc.nextDouble();
            sc.nextLine();
            ok = true;
         }catch( InputMismatchException ime ){
            sc.nextLine();
            System.out.print("Error, Try again > ");
         }
         
      }while(!ok);
      
      return luku;
      
   }
}
