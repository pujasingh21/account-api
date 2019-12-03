package com.accountApi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO Rename package with com.account.api, camel casing not allowed in package naming.
import com.accountApi.api.modal.Account;
import com.accountApi.api.service.AccountServices;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountServices service;

	//TODO No need to add "/" here
	@PostMapping("/")
	public ResponseEntity<Account> saveAccount(@Valid @RequestBody Account account)
	{
		//TODO Convert it into single line
		Account accouninfo = service.saveAccountDetails(account);
		return new ResponseEntity<>(accouninfo,HttpStatus.OK);
	}

	//TODO No need to add "/" here
	@GetMapping("/")
	public ResponseEntity<List<Account>> fetchAccountDetails()
	{
		//TODO Convert it into single line
		List<Account> accountsDetails=service.fetchAccountDetails();
		return new ResponseEntity<>(accountsDetails,HttpStatus.OK);
	}

	@GetMapping("/{id}")
	//TODO No validation for ID here, if you pass empty still this endpoint called and reach till service, add validation using annotation.
	public ResponseEntity<Account> fetchAccountDetails( @PathVariable("id") int id)
	{
		//TODO Convert it into single line
		Account accountDeatils=service.fetchAccountDetails(id);
		return new ResponseEntity<>(accountDeatils,HttpStatus.OK);
	}

	//TODO No need to add "/" here
	@PutMapping("/")
	public ResponseEntity<Account> updateAccount(@Valid @RequestBody Account account)
	{
		//TODO Convert it into single line
		Account accountInfo=service.updateAccount(account);
		return new ResponseEntity<>(accountInfo,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	//TODO No validation for ID here, if you pass empty still this endpoint called and reach till service, add validation using annotation.
	public ResponseEntity<Account> deleteById(@PathVariable("id") int id)		
	{
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
