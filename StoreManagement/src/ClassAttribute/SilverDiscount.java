package ClassAttribute;

public class SilverDiscount extends Discount{
    private int percent = 5;

    public SilverDiscount() {

    }

    @Override
    public double calculateDiscountedAmount(double sum) {
        return sum * percent / 100;
    }
}