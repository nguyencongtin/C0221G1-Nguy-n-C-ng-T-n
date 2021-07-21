package com.case_study.model.dto;

import com.case_study.model.common.Regex;
import com.case_study.model.entity.product.Category;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class ProductDto implements Validator {

    private int productId;
    private String productName;
    @Min(value = 1, message = "Please input positive integer")
    private Double productCost;
    @Min(value = 1, message = "Please input positive integer")
    private Double productAmount;
    @NotBlank(message = "Please Input color")
    private String productColor;
    @NotBlank(message = "Please Input description")
    private String productDescription;
    private Category category;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductCost() {
        return productCost;
    }

    public void setProductCost(Double productCost) {
        this.productCost = productCost;
    }

    public Double getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Double productAmount) {
        this.productAmount = productAmount;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Regex regex=new Regex();
        ProductDto productDto = (ProductDto) target;
        if (productDto.productName.matches("")) {
            errors.rejectValue("productName", "productName.valid", "Please input name");
        }else if (!productDto.productName.matches(regex.VIETNAMESENAME)) {
            errors.rejectValue("productName", "productName.valid", "Please input in valid");
        }
    }
}
