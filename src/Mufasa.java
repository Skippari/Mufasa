

import java.io.Serializable;
import java.io.*;

public class Mufasa implements Serializable {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private double money;
    private int accountID;
    
    public Mufasa(final String firstName_par, String lastName_par, String username_par, String password_par, final double money_par){
        this.firstName = firstName_par;
        this.lastName = lastName_par;
        this.username = username_par;
        this.password = password_par;
        this.money = money_par;
        this.accountID = this.hashCode( );
        
        System.out.println("");
        System.out.println("Created new account: FI" + accountID );//change the FI to real country code later
        System.out.println("Owner: " + firstName + " " + lastName );
        System.out.println("Username: " + username );
        System.out.println("Initial investment: " + money +" Euros");
    
    }
    
    public void setFirstName( final String firstName_par){
        this.firstName = firstName_par;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public void setLastName( final String firstName_par){
        this.firstName = firstName_par;
    }
    
    public String getLastName(){
        return this.firstName;
    }
    
    public void setUsername( final String username_par){
        this.username = username_par;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setPassword( final String password_par){
        this.password = password_par;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setPrice(final double money_par){
        this.money = money_par;
    }
    
    public double getPrice(){
        return this.money;
    }
   
   public String toString(){
      return "Account Number: " + accountID + " Account owner: " + this.firstName + " " + this.lastName + " Username: " + this.username + " amount of money in the account: " + this.money + " Euros";
   }
}