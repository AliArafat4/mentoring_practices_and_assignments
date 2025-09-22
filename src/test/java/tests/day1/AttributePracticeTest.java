package tests.day1;

import org.testng.annotations.*;

public class AttributePracticeTest  {

    /*
    Task 2: TestNG Annotation Attributes Practice
    Objective: Implement various TestNG annotation attributes
    Requirements:
    Create a class called AttributePracticeTest
    Create 5 test methods with different priorities (1, 3, 2, 5, 4)
    Create one test method with enabled = false
    Create a test method with timeout of 3 seconds that includes Thread.sleep(2000)
    Create a test method with timeout of 1 second that includes Thread.sleep(2000)
    6. Add meaningful descriptions to all test methods
    Create test methods with groups: "smoke" , "regression" , "api"
     */

    @Test (priority = 1 , description = "priority 1 description")
    void test01(){
        System.out.println("Test 01");
    }

    @Test (priority = 3, description = "priority 3 description")
    void test02(){
        System.out.println("Test 01");
    }

    @Test (priority = 2, description = "priority 2 description")
    void test03(){
        System.out.println("Test 01");
    }

    @Test (priority = 5, description = "priority 5 description")
    void test04(){
        System.out.println("Test 01");
    }

    @Test (priority = 4, description = "priority 4 description")
    void test05(){
        System.out.println("Test 01");
    }

    @Test(enabled = false, description = "enabled false description")
    void  test06(){
        System.out.println("test06");
    }

    @Test(timeOut = 3, description = "timeout 3 description")
    void  test07() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 1, description = "timeout 1 description")
    void  test08() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(groups = "smoke", description = "smoke group")
    void  test09() {
        System.out.println("smoke group");
    }
    @Test(groups = "regression", description = "regression group")
    void  test10() {
        System.out.println("regression group");
    }

    @Test(groups = "api", description = "api group")
    void  test11() {
        System.out.println("api group");
    }

}