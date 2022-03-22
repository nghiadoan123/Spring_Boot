package com.codegym.case_module_four.model.service;


import com.codegym.case_module_four.common.service_validator.code.ServiceCodeConstrain;
import com.codegym.case_module_four.repository.service.IServiceRepository;
import com.codegym.case_module_four.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity(name = "service_table")
public class Services implements Validator {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer id;
    @Column(name = "code_service",unique = false)
    @NotBlank(message = "input your code service")
    @Pattern(regexp = "^DV-\\d{4,}$",message = "Invalid code Service Ex: DV-0001")
//    @ServiceCodeConstrain
    private String codeService;
    @Column(name = "name")
    @NotBlank(message = "input your name")
    private String name;
    @Column(name = "area")
    @NotNull(message = "input your area")
    @Min(value = 1,message = "area must be larger than 0")
    private int area;
    @Column(name = "cost")
    @NotNull(message = "input your cost")
    @Min(value = 1,message = "cost must be larger than 0")
    private int cost;
    @Column(name = "number_of_person")
    @NotNull(message = "input your person")
    @Min(value = 1,message = "person must be larger than 0")
    private int numberOfPerson;
    @Column(name = "standard_room")
    @NotBlank(message = "input your standard room")
    private String standardRoom;
    @Column(name = "description")
    @NotBlank(message = "input your description")
    private String description;
    @Column(name = "pool_area")
    @NotNull(message = "input your pool area")
    @Min(value = 1,message = "pool area must be larger than 0")
    private int poolArea;
    @Column(name = "number_of_floor")
    @NotNull(message = "input your number of floor")
    @Min(value = 1,message = "number of floor must be larger than 0")
    private int numberOfFloor;

    @ManyToOne
    @JoinColumn(name = "rental_type_id",referencedColumnName = "rental_type_id")
    private RentalType rentalType;

    @ManyToOne
    @JoinColumn(name = "service_type_id",referencedColumnName = "service_type_id")
    private ServiceType serviceType;


    public Services() {
    }

    public Services(Integer id, String codeService, String name, int area, int cost, int numberOfPerson, String standardRoom, String description, int poolArea, int numberOfFloor, RentalType rentalType, ServiceType serviceType) {
        this.id = id;
        this.codeService = codeService;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.numberOfPerson = numberOfPerson;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.rentalType = rentalType;
        this.serviceType = serviceType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public RentalType getRentalType() {
        return rentalType;
    }

    public void setRentalType(RentalType rentalType) {
        this.rentalType = rentalType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }



    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Services services = (Services) target;

    }
}
