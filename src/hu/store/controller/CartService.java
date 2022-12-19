package hu.store.controller;

import hu.store.model.domain.Cart;
import hu.store.model.service.ValueCalculator;

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

    public String getCartStatisticByGoods(String goods){
        List<Cart> cartsByGoods = getCartsByGoods(goods);
        int size = cartsByGoods.size();
        return String.format("Az első vásárlás sorszáma: %d\n" +
                "Az utolsó vásárlás sorszáma: %d\n" +
                "%d vásárlás során vettek belőle.\n", cartsByGoods.get(0).getId(), cartsByGoods.get(size - 1).getId(),
                size);
    }

    private List<Cart> getCartsByGoods(String goods){
        return carts.stream()
                .filter(i -> i.contains(goods))
                .collect(Collectors.toList());
    }

    public String getValueByCount(int count) {
        return String.format("%d darab vételekor fizetendő: %d", count, ValueCalculator.value(count));
    }

    /**
     * 7. feladat
     */

    public String getCartContentInDetailsById(int id) {
        return getCartById(id).getCartDetails();
    }

    public List<String> getTotalValue() {
        return carts.stream()
                .map(Cart::toString)
                .collect(Collectors.toList());
    }

}
