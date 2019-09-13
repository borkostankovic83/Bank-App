package com.revature.model;

public class User {
	public int id;
	public String firstName;
	public String lastName;
	public String userName;
	public String password;
	public String accountType;
	public float balance;
		
		public User(int id, String firstName, String lastName, String userName, String password, String accountType,
				float d) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.userName = userName;
			this.password = password;
			this.accountType = accountType;
			this.balance = d;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public float getBalance() {
			return balance;
		}
		public void setBalance(float amount) {
			this.balance = amount;
		}
	
		@Override
		public String toString() {
			return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
					+ ", password=" + password + ", accountType=" + accountType + ", balance=" + balance + "]";
		}
		

		
		

	    

}
