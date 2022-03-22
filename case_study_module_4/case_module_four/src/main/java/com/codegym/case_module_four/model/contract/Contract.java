package com.codegym.case_module_four.model.contract;


import com.codegym.case_module_four.model.customer.Customer;
import com.codegym.case_module_four.model.employee.Employee;
import com.codegym.case_module_four.model.service.Services;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
public class Contract implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private int id;
    @Column(name = "check_in",columnDefinition = "DATE")
    @NotBlank(message = "in put check in day")
    private String checkIn;
    @Column(name = "check_out",columnDefinition = "DATE")
    @NotBlank(message = "in put check out day")
    private String checkOut;
    @Column(name = "deposit")
    @NotNull(message = "input your deposit")
    @Min(value = 10,message = "min of deposit must be 10")
    private int deposit;
    @Column(name = "total_money")
    @NotNull(message = "input your total money")
    @Min(value = 10,message = "min of total must be 10")
    private int totalMoney;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "service_id",referencedColumnName = "service_id")
    private Services services;

    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetails;


    public Contract() {
    }

    public Contract(int id, String checkIn, String checkOut, int deposit, int totalMoney, Customer customer, Employee employee, Services services) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.customer = customer;
        this.employee = employee;
        this.services = services;
    }

    public Contract(int id, String checkIn, String checkOut, int deposit, int totalMoney, Customer customer, Employee employee, Services services, List<ContractDetail> contractDetails) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.customer = customer;
        this.employee = employee;
        this.services = services;
        this.contractDetails = contractDetails;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date checkIn = simpleDateFormat.parse(contract.checkIn);

            Date checkOut = simpleDateFormat.parse(contract.checkOut);

            if (checkIn.compareTo(checkOut)>0){
                errors.rejectValue("checkIn","checkIn.validator");
                errors.rejectValue("checkOut","checkOut.validator");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
