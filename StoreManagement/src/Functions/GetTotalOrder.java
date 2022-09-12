package Functions;

import ClassAttribute.Cart;

import java.util.List;

public class GetTotalOrder {
    public Double GetTotalOrder(List<Cart> confirmedCarts){
        double total = 0;
        for (int i = 0; i<confirmedCarts.size(); i++){
            total += confirmedCarts.get(i).getTotal();
        }
        return total;
    }
}
