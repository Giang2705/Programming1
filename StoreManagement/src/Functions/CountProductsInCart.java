package Functions;

import ClassAttribute.Cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountProductsInCart {
    public Integer getMemberCart(String name) throws IOException {
        Integer countProductInCart = 0;
        readDatabase readDatabase = new readDatabase();
        List<Cart> carts = readDatabase.readCartFile(name);

        List<Cart> memberCart = new ArrayList<>();
        if (carts != null){
            for (int i = 0; i < carts.size(); i++) {
                if (carts.get(i).getMember().getUsername() != null) {
                    memberCart.add(carts.get(i));
                }
            }
        }

        for (int j = 0; j<memberCart.size(); j++){
            if (memberCart.get(j).getStatus().equals("unpaid")){
                countProductInCart += 1;
            }
        }
        return countProductInCart;
    }
}
