package ClassAttribute;

public class PlatinumDiscount extends Discount{
    private int percent = 15;

    public PlatinumDiscount(String c) {
    }

    @Override
    public double calculateDiscountedAmount(double sum) {
        return sum * percent / 100;
    }
}
