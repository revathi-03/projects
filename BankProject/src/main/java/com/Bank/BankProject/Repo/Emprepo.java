package com.Bank.BankProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bank.BankProject.Entity.Employee;

public interface Emprepo extends JpaRepository<Employee, Long> {

}
