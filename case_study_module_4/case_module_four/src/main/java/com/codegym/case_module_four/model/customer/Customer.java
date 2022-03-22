package com.codegym.case_module_four.model.customer;

import com.codegym.case_module_four.common.customer_validator.code.CustomerCodeConstraint;
import com.codegym.case_module_four.common.customer_validator.id_card.CustomerIdConstraint;
import com.codegym.case_module_four.model.contract.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity(name = "customer")
public class Customer implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;
    @Column(name = "name")
    @NotBlank(message = "input your name")
    private String name;
    @NotEmpty(message = "input your code number")
//    @CustomerCodeConstraint
    @Pattern(regexp = "^[K][H]-\\d{4}$", message = "Not valid ex: KH-0001")
    @Column(name = "code")
    private String codeNumber;
    @Column(name = "birth_day")
    @NotBlank(message = "input your birth day")
    private String birthDay;
    @Column(name = "gender")
    private String gender;
    @NotBlank(message = "input your id card")
    @Column(name = "id_card")
    @Pattern(regexp = "(^\\d{9}$)||(^\\d{12}$)", message = "Not valid ex: xxxxxxxxx or xxxxxxxxxxxx with x is a number")
//    @CustomerIdConstraint
    private String idCard;
    @Column(name = "phone")
    @NotBlank(message = "input your phone")
    @Pattern(regexp = "(^09[01]\\d{7}$)")
    private String phone;
    @Column(name = "email")
    @NotBlank(message = "input your email")
    @Pattern(regexp = "[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)")
    private String email;
    @Column(name = "address")
    @NotBlank(message = "input your address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Contract> contracts;


    public Customer() {
    }

    public Customer(int id, String name, String codeNumber, String birthDay, String gender, String idCard, String phone, String email, String address, CustomerType customerType, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.codeNumber = codeNumber;
        this.birthDay = birthDay;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contracts = contracts;
    }

    public Customer(int id, String name, String birthDay, String gender, String idCard, String phone, String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }


    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birth = simpleDateFormat.parse(customer.getBirthDay());
            int yearOld = LocalDate.now().getYear() - birth.getYear() - 1900;
            int month = LocalDate.now().getMonthValue() - birth.getMonth() - 1;
            int day = LocalDate.now().getDayOfYear() - birth.getDate();

            System.out.println(yearOld);
            System.out.println(day);
            if (!(yearOld > 17 && yearOld < 100)) {

                errors.rejectValue("birthDay", "birthDay.lessthan18");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}

