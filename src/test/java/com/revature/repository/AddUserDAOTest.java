package com.revature.repository;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.exception.DuplicateUsernameException;
import com.revature.service.AddUser;


public class AddUserDAOTest {
	private static AddUser addUser = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		addUser = new AddUser();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testGetUserInt() {
		int Id = AddUser.id;
		assertEquals(1, Id);;
	}

	@Test
	public void testGetUserString() throws DuplicateUsernameException {
		try {
		AddUser.checkUsername("borko");
		}catch (DuplicateUsernameException e) {
			System.out.println(e);
		}
		assertTrue(false);
	}


}
