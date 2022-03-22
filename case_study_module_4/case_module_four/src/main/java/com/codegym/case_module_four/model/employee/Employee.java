package com.codegym.case_module_four.model.employee;


import com.codegym.case_module_four.model.contract.Contract;
import com.codegym.case_module_four.model.customer.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Employee implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;
    @Column(name = "name")
    @NotBlank(message = "input your name")
    private String name;
    @Column(name = "birth_day")
    @NotBlank(message = "input your birth day")
    private String birthDay;
    @Column(name = "id_card")
    @NotBlank(message = "input your id card")
    @Pattern(regexp = "(^\\d{9}$)||(^\\d{12}$)", message = "Not valid ex: xxxxxxxxx or xxxxxxxxxxxx with x is a number")
    private String idCard;
    @Column(name = "salary")
    @NotNull(message = "input your salary")
    @Min(value = 1, message = "salary must be larger than 0")
    @Max(value = 200000)
    private Double salary;
    @Column(name = "phone")
    @NotBlank(message = "input your phone")
    @Pattern(regexp = "(^09[01]\\d{7}$)", message = "ex: 090 or 091 xxxxxxx")
    private String phone;
    @Column(name = "email")
    @NotBlank(message = "input your email")
    @Pattern(regexp = "[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)", message = "ex email: jhon@gmail.com")
    private String email;
    @Column(name = "address")
    @NotBlank(message = "input your address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_id", referencedColumnName = "education_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "division_id")
    private Division division;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Contract> contracts;


    public Employee() {
    }

    public Employee(Integer id, String name, String birthDay, String idCard, Double salary, String phone, String email, String address, Position position, EducationDegree educationDegree, Division division) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
    }

    public Employee(Integer id, String name, String birthDay, String idCard, Double salary, String phone, String email, String address, Position position, EducationDegree educationDegree, Division division, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.contracts = contracts;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birth = simpleDateFormat.parse(employee.getBirthDay());
            int yearOld = LocalDate.now().getYear() - birth.getYear() - 1900;
            int month = LocalDate.now().getMonthValue() - birth.getMonth() - 1;
            int day = LocalDate.now().getDayOfYear() - birth.getDate();

            System.out.println(yearOld);
            System.out.println(day);
            if (!(yearOld > 17 && yearOld < 100)) {
                errors.rejectValue("birthDay", "birthDay.employee");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
