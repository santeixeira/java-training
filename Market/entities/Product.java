package entities;


public class Product {
    private Double price;
    private char type;
    private char refrigerate;
    private Double additionalValue;

    public Product() {

    }

    public Product(Double price, char type, char refrigerate, Double additionalValue) {
        this.price = price;
        this.type = type;
        this.refrigerate = refrigerate;
        this.additionalValue = additionalValue;
    }

    public Double getAdditionalValue() {
        return additionalValue;
    }

    public void setAdditionalValue(Double additionalValue) {
        this.additionalValue = additionalValue;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public char getRefrigerate() {
        return refrigerate;
    }

    public void setRefrigerate(char refrigerate) {
        this.refrigerate = refrigerate;
    }

}

