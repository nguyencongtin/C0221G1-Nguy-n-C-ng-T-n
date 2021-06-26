package com.example.bai_lam_them.model.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class ProductDto implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Please input name invalid")
    private String name;

    @NotNull(message = "Please input price invalid")
    private Double price;

    @NotBlank(message = "Please input description invalid")
    private String description;

    @NotBlank(message = "Please input manufacturer invalid")
    private String manufacturer;

    @Column(columnDefinition = "date")
    private LocalDate date= LocalDate.now();

    public ProductDto() {
    }

    public ProductDto(Integer id, @NotBlank(message = "Please input name invalid") String name, @NotBlank(message = "Please input price invalid") Double price, @NotBlank(message = "Please input price invalid") String description, @NotBlank(message = "Please input price invalid") String manufacturer, LocalDate date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
        this.date = date;
    }

    public ProductDto(@NotBlank(message = "Please input name invalid") String name, @NotBlank(message = "Please input price invalid") Double price, @NotBlank(message = "Please input price invalid") String description, @NotBlank(message = "Please input price invalid") String manufacturer, LocalDate date) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
        this.date = date;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
