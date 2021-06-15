package model.bean;

public class Product {
    private int productId;
    private String productName;
    private int productCost;
    private int productAmount;
    private String productColor;
    private String productDescription;
    private int productCategory;

    public Product() {
    }

    public Product(int productId, String productName, int productCost, int productAmount, String productColor, String productDescription, int productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productCost = productCost;
        this.productAmount = productAmount;
        this.productColor = productColor;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
    }

    public Product(String productName, int productCost, int productAmount, String productColor, String productDescription, int productCategory) {
        this.productName = productName;
        this.productCost = productCost;
        this.productAmount = productAmount;
        this.productColor = productColor;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
    }

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

    public int getProductCost() {
        return productCost;
    }

    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
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

    public int getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(int productCategory) {
        this.productCategory = productCategory;
    }
}
