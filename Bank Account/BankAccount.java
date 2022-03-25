// Bank account class

public class BankAccount 
{
     private String name, idNumber;
     private double balance;

    //--------------------------------------------
    // default constructor

   public BankAccount()
   {
      name = "NO NAME";
      idNumber = "NO ID NUMBER";
      balance = 0;
   }
  //--------------------------------------------
   public double getBalance()
   {
      return balance;
   }
    //--------------------------------------------
    public String deposit(double amount) 
    {
        if (amount < 0) 
        {
            return "Deposit amount can’t be negative";
        } 
        else 
        {
            balance = balance + amount;
            return "balance = "+balance;
        }
    }
    //--------------------------------------------
    public String withdraw(double amount) 
    {
        if (amount < 0) 
        {
           return "Withdrawal amount can’t be negative";
        } 
        else 
           if (amount > balance) 
           {
               return "Cannot withdraw more than the balance";
           } 
           else 
           {
               balance = balance - amount;
               return "balance = "+balance;
           }
     }
}