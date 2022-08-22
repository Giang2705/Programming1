package ClassAttribute;

public class Cart {
    private Member member;
    private Product product;

    private Integer amount;

    private Integer total;

    public int getAmount() {
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Cart(Member member, Product product, Integer amount, Integer total){
        this.member = member;
        this.product = product;
        this.amount = amount;
        this.total = total;
    }

}
