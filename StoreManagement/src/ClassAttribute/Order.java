package ClassAttribute;

import java.util.List;

public class Order {
//    Attribute
    private String id;
    private List<Cart> cart;
    private Double total;
    private String createdDate;
    private String status;

//    Constructor
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<Cart> getCart() {
        return cart;
    }
    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
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

    public Order(String id, List<Cart> cart, Double total, String createdDate, String status){
        this.id = id;
        this.cart = cart;
        this.total = total;
        this.createdDate = createdDate;
        this.status = status;
    }

//    calculate total of order
    private double orderSum(){
        double total = 0;
        for (int i = 0; i<cart.size(); i++){
            total += cart.get(i).getTotal();
        }
        return total;
    }
//    calculate final total
    public double priceAfterDiscount() {
        double total = orderSum();
        Member customer = cart.get(0).getMember();
        Discount discount = customer.getDiscount();
        double totalAfterDiscount = total;
        if (discount != null){
            totalAfterDiscount -= discount.calculateDiscountedAmount(total);
        }
        return totalAfterDiscount;
    }
}
