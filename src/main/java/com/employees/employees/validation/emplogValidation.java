package com.employees.employees.validation;

public class emplogValidation {
	public static void logvalidation(String email, String password) throws Exception {
		if(!(email.contains("@")||email.contains(".com")))
		{
		 throw new Exception("Enter a valid email");	
		}
		else if(password.length()>16)
		{
			throw new Exception("Enter a Valid password");
		}

}
<<<<<<< HEAD
	
	
=======
	public static void passwordcheck(Integer id,String password) throws Exception{
		if(id<0)
		{
			throw new Exception("Enter a Valid Id");
		}
		
		if(password.length()>16)
		{
			throw new Exception("Enter a Valid password");
		}
		
	}
>>>>>>> d92e99e63272d2963975d9e9c49ce50e82bfab37
}
