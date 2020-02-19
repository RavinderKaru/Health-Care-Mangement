package com.Service;

public class Validation {

public static boolean validateEmail(String email)
{ String pattern="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	return email.matches(pattern);
}
public static  boolean validatePass(String pass)
{
	String pattern="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}";
	return pass.matches(pattern);
}
public static boolean validatePhoneN(String Pn)
{
	String pattern="(0/91)?[7-9][0-9]{9}";
	return Pn.matches(pattern);
}
public static boolean validateSec(String sec)
{
	String pattern="[^0-9][a-z][A-Z] {10,15}";
	return sec.matches(pattern);
}
}
