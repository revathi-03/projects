package com.Bank.BankProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Bank.BankProject.Entity.AddAccount;
import com.Bank.BankProject.Entity.UserInfo;
import com.Bank.BankProject.Repo.Bankrepo;
import com.Bank.BankProject.Repo.Userrepo;

@RestController
public class Usercontroller {
	@Autowired
	Userrepo repo;
	@Autowired
	Bankrepo brepo;

	@PostMapping("/api/userinfo")
	public ResponseEntity<UserInfo> saveuser(@RequestBody UserInfo userinfo) {
		return new ResponseEntity<>(repo.save(userinfo), HttpStatus.CREATED);

	}

	@GetMapping("/useralldetails")
	public ResponseEntity<List<UserInfo>> alldetails() {
		return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/api/userinfo/{email}")
	public ResponseEntity<UserInfo> getUser(@PathVariable String email) {
		Optional<UserInfo> userInfoOptional = repo.findByEmail(email);
		if (userInfoOptional.isPresent()) {

			return new ResponseEntity<>(userInfoOptional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/api/addacount")
	public ResponseEntity<AddAccount> adduseraccount(@RequestBody AddAccount account) {
		return new ResponseEntity<>(brepo.save(account), HttpStatus.CREATED);

	}

	@PostMapping("/findaccid")
	public ResponseEntity<AddAccount> sendmoney(@RequestParam String fromaccount, @RequestParam String toaccount,
			@RequestParam double amount) {

		AddAccount fromcnt = brepo.findByAccountNo(fromaccount);
		AddAccount tocnt = brepo.findByAccountNo(toaccount);

		double from = fromcnt.getCurrentBlnc();
		double to = tocnt.getCurrentBlnc();
		

		if (from < amount) {
			throw new RuntimeException("insufficiant balance");
		}
		fromcnt.setCurrentBlnc(from - amount);
		tocnt.setCurrentBlnc(to + amount);

		brepo.save(fromcnt);
		brepo.save(tocnt);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/addmoney")
	public ResponseEntity<AddAccount> addmoney(@RequestParam String accountno, @RequestParam double amount) {
		AddAccount bank = brepo.findByAccountNo(accountno);
		if (bank != null) {
			double currentbal = bank.getCurrentBlnc();
			double newBal = currentbal + amount;
			bank.setCurrentBlnc(newBal);
			return new ResponseEntity<>(brepo.save(bank), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
