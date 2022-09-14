package ClassAttribute;

import javax.swing.*;

public class Cart {
//  Cart's attributes
    private String id;
    private Member member;
    private Product product;
    private double amount;
    private String createdDate;
    private double total;
    private String status;

//    Constructors
    public String getId() {
    return id;
}
    public void setId(String id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Cart(String id, Member member, Product product, double amount, double total, String createdDate, String status){
        this.id = id;
        this.member = member;
        this.product = product;
        this.amount = amount;
        this.total = total;
        this.createdDate = createdDate;
        this.status = status;
    }

}