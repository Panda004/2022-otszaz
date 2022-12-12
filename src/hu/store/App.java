package hu.store;

import hu.store.controller.CartService;
import hu.store.model.service.*;

import java.util.Scanner;

public class App {

    private final CartService cartService;
    private final DataWriter dataWriter;
    private final Console console;

    private App() {
        console = new Console(new Scanner(System.in));
        dataWriter = new DataWriter("osszeg.txt");
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        cartService = new CartService(dataApi.getCarts("penztar.txt"));
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat");
        System.out.println(" A fizetések száma: " + cartService.getCartNumber());
        System.out.println("3. feladat");
        System.out.println("Az első vásárló " + cartService.getGoodsNumberInCart(1) +  " darab árucikket vásárolt.");
        System.out.println("4 .feladat");
        System.out.print("Adja meg egy vásárls sorszámát! ");
        int id = console.readInt();
        System.out.print(" Adja meg az árucikk nevét! ");
        String item = console.read();
        System.out.print("Adja meg a vásárló darabszámát! ");
        int count = console.readInt();

    }

}
