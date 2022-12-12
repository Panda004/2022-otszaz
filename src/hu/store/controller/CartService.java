package hu.store.controller;

import hu.store.model.domain.Cart;

import java.util.List;
import java.util.stream.Collectors;

public class CartService {

    private final List<Cart> carts;

    public CartService(List<Cart> carts) {
        this.carts = carts;
    }

    public  int getCartNumber(){
        return carts.size();
    }

    public long getGoodsNumberInCart(int id) {
        return getCartById(id).countItemsInCart();
    }

    private Cart getCartById(int id ) {
        return carts.stream()
                .filter(i -> i.getId() == id)
                .findAny()
                .get();
    }


}
