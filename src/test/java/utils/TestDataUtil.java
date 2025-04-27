package utils;


import org.testng.annotations.DataProvider;

public class TestDataUtil {

    @DataProvider(name = "signInData")
    public static Object[][] signInData() {
        return new Object[][] {
        	//Valid credentials
            {"harshirv@gmail.com", "H@rshi01051998"},
            
            //Invalid credentials
            {"harshirv@gmail.com$#", "H@rshi01051998"},// Invalid email format
            {"harshirv@gmail.com", "H@rshi01051998@#$Z%"} // Valid email but invalid password
        };
    }
    @DataProvider(name = "signUpData")
    public static Object[][] signUpData() {
	      return new Object[][] {
	            // Positive test
	            {"testuser1@example.com", "Test@12345678", "Test@12345678"},
	            
	            // Negative test
	            
	            //Duplicate test
	            {"testuser1@example.com", "Test@12345678", "Test@12345678"},
	            
	            //Weak password test
	            {"testuser1@example.com", "Tes@12", "Tes@12"},
	            
	            //Mismatched password test
	            {"testuser2@example.com", "Diff@12345678", "Different@456"},
	        };
	    }
}

