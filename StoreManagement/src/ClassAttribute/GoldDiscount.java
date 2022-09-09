package ClassAttribute;

public class GoldDiscount extends Discount{
    private int percent = 10;
    public GoldDiscount() {

    }

    @Override
    public double calculateDiscountedAmount(double sum) {
        return sum * percent / 100;
    }
}
