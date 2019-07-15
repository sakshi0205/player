package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;



import bean.UserMain;

public class AccountDaoImpl implements UserAccountDao {

	HashMap<Integer,UserMain> userData=new HashMap<Integer,UserMain>();
	UserMain a1;
	SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sd1 = new SimpleDateFormat("HH:mm:ss");

	@Override
	public Integer createUserAccount(Integer accountNo, String userPassword) {
		

	
			
		
			Set s=userData.entrySet();
			Iterator i=s.iterator();
			boolean flag=true;
			while(i.hasNext())
			{
				Entry e=(Entry)i.next();
				if(e.getKey().equals(accountNo))
				{
					flag=false;
					break;
				}
				else
				{
					flag=true;
				}
			}
			if(flag)
			{
				UserMain user=new UserMain();
				user.setUserPassword(userPassword);
				user.setAccountNo(accountNo);
				userData.put(accountNo, user);
				System.out.println("Account created successfully");
				user.setTransaction("Transaction done successfully ");
			}
			else
			{
				System.out.println("Account number already exist");
			}
			return accountNo;
			
		}


	@Override
	public Integer showBalance(Integer accountNo, String userPassword) {
		// TODO Auto-generated method stub
		
		Set s=userData.entrySet();
		Iterator i=s.iterator();
		boolean flag=true;
		int balance=0;
		String userName=null;
		
		while(i.hasNext())
		{
			Entry e=(Entry)i.next();
			if(e.getKey().equals(accountNo)){
				
			UserMain userInfo=(UserMain)e.getValue();
			if(userInfo.getUserPassword().equals(userPassword))
					{
				        balance=userInfo.getBalance();
				        userInfo.setTransaction("Show Balance");
				        flag=false;
				        break;
					}
			else
			{
				System.out.println("Wrong password");
			}
		}
	}
	if(flag)
	{
		System.out.println("Wrong Credentials");
	}

	return balance;
	}
	@Override
	public Integer deposite(Integer accountNo, String userPassword, Integer amount) {
		// TODO Auto-generated method stub
		Set s=userData.entrySet();
		Iterator i=s.iterator();
		boolean flag=true;
		int balance=0;
		if(amount>0)
		{
			while(i.hasNext())
			{
				Entry e=(Entry)i.next();
				if(e.getKey().equals(accountNo))
				{
					UserMain userInfo=(UserMain)e.getValue();
					if(userInfo.getUserPassword().equals(userPassword))
					{
						flag=false;
						balance=userInfo.getBalance();
						balance=balance+amount;
						userInfo.setBalance(balance);
						userData.put(accountNo, userInfo);
						userInfo.setTransaction("user deposite amount "+amount);
						break;
					}
				}
			}
			if(flag)
			{
				System.out.println("Wrong Credential");
			}
			else
			{
				System.out.println("After deposite balance is "+balance);
			}
		}
		else
		{
			System.out.println("Amount should be greater than 0");
		}
		return balance;
	}

	@Override
	public Integer withdraw(Integer accountNo, String userPassword, Integer amount) {
		// TODO Auto-generated method stub
		Set s=userData.entrySet();
		Iterator i=s.iterator();
		boolean flag=true;
		int balance=0;
		
			while(i.hasNext())
			{
				Entry e=(Entry)i.next();
				if(e.getKey().equals(accountNo))
				{
					
					UserMain userInfo=(UserMain)e.getValue();
					if(userInfo.getUserPassword().equals(userPassword))
					{
						flag=false;
						balance=userInfo.getBalance();
						if(amount<=balance)
						{
							balance=balance-amount;
							userInfo.setBalance(balance);;
							userData.put(accountNo, userInfo);
							userInfo.setTransaction("After withdrawing  balance is "+balance);
							
							
						}
						else
						{
							System.out.println("Amount should be less than balance");
						}
					}
				}
			}
			if(flag){
				System.out.println("Wrong credentials");}
			return balance;
			
			
			}

	@Override
	public String fundTransfer(Integer accountNo,String userPassword,Integer destinationAccountId,Integer amount)
	{
		
			
		 a1 = (UserMain) userData.get(accountNo);
		if (a1.getBalance() >= amount) {
			if(!(a1.getUserPassword().equals(userPassword)))
			{
				return "Wrong password";
			}
			else
			{
			String date = sd.format(new Date());
			String time = sd1.format(new Date().getTime());
			UserMain a2;
			a2 = userData.get(destinationAccountId);
			a1.setBalance(a1.getBalance() - amount);
			a2.setBalance(a2.getBalance() + amount);
			a1.setTransaction("Transaction type = Fund Transfer || fromAccount = "+accountNo
					+" || toAccount ="+destinationAccountId+" || Amount = "+amount+"|| Date ="+date+"|| Time = "+time );
			a2.setTransaction("Transaction type = Fund Transfer || fromAccount = "+accountNo
					+" || toAccount ="+destinationAccountId+" || Amount = "+amount+"|| Date ="+date+"|| Time = "+time );}
			return "After transfer fund your balance is " + a1.getBalance();
		} else {
			return "You have insufficient amount to transfer";
		}		
}
		
		

	@Override
	public Integer getUserAccountDetails(Integer accountNo,String userPassword) {
		// TODO Auto-generated method stub
		Set s=userData.entrySet();
		Iterator i=s.iterator();
		String password=" ";
		int balance=0;
		
		
		boolean flag=true;
		while(i.hasNext()){
			Entry e=(Entry) i.next();
			if(e.getKey().equals(accountNo)){
				UserMain userInfo=(UserMain)e.getValue();
				
				if(userInfo.getUserPassword().equals(userPassword))
				{
						
					password=userInfo.getUserPassword();
					balance=userInfo.getBalance();
					flag=false;
					
					break;
				}
			}
		}
		if(flag)
		{
			System.out.println("Wrong credentials");
			
		}
		else
		{
			System.out.println("AccountNo = " + accountNo + " Password = " + password + " Balance = " + balance );
		}
		return balance;
		
	}

	@Override
	public String printTransaction(Integer accountNo,String userPassword) 
	{
		// TODO Auto-generated method stub
		Set s=userData.entrySet();
		Iterator i=s.iterator();
		String password=" ";
		String Transaction=" ";
		int balance=0;
		
		
		boolean flag=true;
		while(i.hasNext())
		{
			Entry e=(Entry) i.next();
			if(e.getKey().equals(accountNo))
			{
				UserMain userInfo=(UserMain)e.getValue();
				if(userInfo.getUserPassword().equals(userPassword))
					password=userInfo.getUserPassword();
				balance=userInfo.getBalance();
				
				Transaction=userInfo.getTransaction();
				flag=false;
				break;
			}
				
	       	}
		
        
              if(flag)
              {
            	  System.out.println("Wrong credentials");
              }
              else
              {
            	  System.out.println(Transaction);
              }
			return Transaction;
	
}


	@Override
	public boolean validAccountNo(Integer accountNo) {
		if (userData.containsKey(accountNo)) {
			return true;
		} else {
			return false;
		}
	}


	@Override
	public boolean checkBalance(String accountNo, int amount) {
		a1 = (UserMain) userData.get(accountNo);
		if(a1.getBalance() >= amount) {
			return true;
		}
		else {
			return false;
		}
	}


	


	
}
