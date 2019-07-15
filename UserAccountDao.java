package dao;

import java.util.List;

import bean.UserMain;

public interface UserAccountDao {

         public Integer createUserAccount(Integer accountNo,String userPassword);
         public Integer showBalance(Integer accountNo,String userPassword);
         public Integer deposite(Integer accountNo,String userPassword,Integer amount);
         public Integer withdraw(Integer accountNo,String userPassword,Integer amount);
         public String fundTransfer(Integer accountNo,String userPassword,Integer destinationAccNo,Integer amount);
         public Integer getUserAccountDetails(Integer accountNo,String userPassword);
         public String printTransaction(Integer accountNo,String userPassword);
         
         //validations methods
 		boolean validAccountNo(Integer accountNo);
 		boolean checkBalance(String accountNo,int amount);
}