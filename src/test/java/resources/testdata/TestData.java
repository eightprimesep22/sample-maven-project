package resources.testdata;

import org.testng.annotations.DataProvider;

/**
 * Created by Jay Vaghani
 */
public class TestData {

    @DataProvider(name = "credentials")
    public Object[][] getData(){
        Object[][] data = new Object[][]{
                {"test1@gamil.com", "test123", "Welcome, Please Sign In!"},
                {"test2@gamil.com", "test456", "Welcome, Please Sign In!"},
                {"test3@gamil.com", "test789", "Welcome, Please Sign In!"}
        };
        return data;
    }
}
