package com.accountApi.api.modal;

//TODO Unused imports are here, please remove
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
TODO Format this class, remove unwanted line breaks. Another thing in this whole class you are using primitives use Objects instead.
 And also let me know why object but not primitives
*/
@Entity
@Table(name="Account")
public class Account {

	//TODO Please rename this id add accountId
	@Id	
	@GeneratedValue
	private int id;

	//TODO Please use camelCasing here example accountNumber
	@NotNull
	//@Size(min=3, max=5, message="Please enter valid account number")
	private int account_number;


	//TODO Please use camelCasing here example accountNumber
	private int customer_id;

	//TODO Spelling mistake
	@NotNull(message="{Account.customer_id.null}")
	private int balane;
	
	public Account()
	{
		
	}
	
	public Account(int id,int account_number,int customer_id, int balane)
	{
		this.id=id;
		this.account_number=account_number;
		this.customer_id=customer_id;
		this.balane=balane;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", account_number=" + account_number + ", customer_id=" + customer_id + ", balane="
				+ balane + "]";
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getBalane() {
		return balane;
	}
	public void setBalane(int balane) {
		this.balane = balane;
	}
	
	

}
