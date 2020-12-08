package test;

import org.testng.annotations.DataProvider;

public class DataDrivenSignIn {

    @DataProvider(name = "SignIn_Provider")
    public Object [][] signInData() {
        Object [][] data = new Object [2][2];
        data [0][0] = "standard_user"; data [0][1] = "secret_sauce";
        data [1][0] = "problem_user"; data [1][1] = "secret_sauce";
        return data;
    }



}
