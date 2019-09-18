package com.revature.test;
import java.io.IOException;
import java.util.InputMismatchException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.revature.controller.Controller;


public class MyTest1 {

		static Object myNeededObject;
	
		//Before and After are better to use because it keeps your
		// tests independent
		//Other annotations: setup and tear down with @Before and @After
		
		@Before
		public void setUp() {
			System.out.println("Creating necessary objects for test");
			myNeededObject = new Object();
		}
		//This test will pass because our withdraw() method throws the expected Exception
		@Test(expected = InputMismatchException.class)
		public void withhdraw() {
			Controller.withdraw(-120);
		}
		//This test will pass because our deposit() method throws the expected Exception
		@Test(expected = InputMismatchException.class )
		public void deposit() {
			try {
				Controller.deposit(-100);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
					
		@After
		public void tearDown() {
			System.out.println("Getting rid of unneeded objects after test");
			myNeededObject = null;
		}
		
		
		//Before and After are better to use because it keeps your
		// tests independent
		//But if you're hurting for processing power, use BeforeClass and AfterClass
		// each of those run only once -- at the very beginning and at the very end		
		@BeforeClass
		public static void setUpOnlyOnceAtBeginning() {
			System.out.println("Start of Testing");
		}
		
		@AfterClass
		public static void tearDownOnlyOneAtEnd() {
			System.out.println("Testing is finished");
		}

	}


