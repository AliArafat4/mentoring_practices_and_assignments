package tests.day1;

import org.testng.annotations.*;

public class AnnotationHierarchyTest {
     /*
    Task 1: Basic TestNG Setup and Annotations
    Objective: Create a TestNG class demonstrating annotation hierarchy
    Requirements:
    Create a TestNG class called AnnotationHierarchyTest
    Implement all TestNG annotations (@BeforeSuite, @BeforeTest, @BeforeClass, @BeforeMethod,
    @Test, @AfterMethod, @AfterClass, @AfterTest, @AfterSuite)
    Add print statements in each method to observe execution order
    Create 2 test methods
    Run the test and analyze console output
     */

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }
    @Test
    public void test2() {
        System.out.println("test2");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("afterTest");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite");
    }
}