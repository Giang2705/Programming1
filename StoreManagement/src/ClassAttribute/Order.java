package ClassAttribute;

public class Order {
    String id;
    Member member;
    Product product;
    String status;
    Integer total;

    public String getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public Product getProduct() {
        return product;
    }

    public String getStatus() {
        return status;
    }

    public Integer getTotal() {
        return total;
    }

    public Order(String id, Member member, Product product, String status, Integer total) {
        this.id = id;
        this.member = member;
        this.product = product;
        this.status = status;
        this.total = total;
    }
}
