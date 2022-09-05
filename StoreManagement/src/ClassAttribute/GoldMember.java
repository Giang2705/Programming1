package ClassAttribute;

public class GoldMember extends Member {
    String title = "Gold";
    Double discount;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getTitle() {
        return title;
    }
}
