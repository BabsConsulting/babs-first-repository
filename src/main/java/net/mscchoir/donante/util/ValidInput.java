// File:    ValidInput.java
// Author:  Ayodeji Babaniyi
// Date:    05/01/2011
// Purpose: Utility class used for verifying different types of user input is valid

package net.mscchoir.donante.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidInput
{
     public static boolean isValidEmail(String emailAddress)
     {
           String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
           CharSequence input = emailAddress;
           Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
           Matcher matcher = pattern.matcher(input);
           return matcher.matches();
     }

     public static boolean isValidZipCode(String emailAddress)
     {
           String  expression="\\d{5}(-\\d{4})?";
           CharSequence input = emailAddress;
           Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
           Matcher matcher = pattern.matcher(input);
           return matcher.matches();
     }

     public static boolean isValidMoney(String s)
     {
        try
        {
            double d = Double.parseDouble(s);
            
            return (d > 0);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
     }

     public static boolean isValidInteger(String s)
     {
        try
        {
            int i = Integer.parseInt(s);
            return (i > 0);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
     }

    public static boolean isValidString(String s)
    {
        return ((s != null) && !s.isEmpty());
    }
}
