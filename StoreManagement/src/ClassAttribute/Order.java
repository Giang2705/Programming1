package ClassAttribute;

import java.util.Arrays;
import java.util.Date;

public class Order {
    private String id;
    private Member member;
    private Product productOrder;
    private int amount;
    private String status;
    private Date time;

    public Order(String id, Member member, Product productOrder, int amount, String status, Date time){
        this.id = id;
        this.member = member;
        this.productOrder = productOrder;
        this.amount = amount;
        this.status = status;
        this.time = time;
    }

    //    Setting
    public void setIdOrder(String id){
        this.id = id;}

    public void setMember(Member member){
        this.member = member;}

    public void setProducts(Product productOrder){
        this.productOrder = productOrder;}

    public void setAmount(int amount){
        this.amount = amount;}

    public void setStatus(String status){
        this.status = status;}

    public void setTime(Date time){
        this.time = time;}

//    Getting
    public String getIdOrder(){
        return id;}

    public Member getMember(){
        return member;}

    public Product getProducts(){
        return productOrder;}

    public int getAmount(){
        return amount;}

    public String getStatus(){
        return status;}

    public Date getTime(){
        return time;}

}
