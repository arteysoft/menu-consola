package edu.it;

import javax.mispec.menu.MenuFactory;

public class App {
    public static void main(String[] args) {
        var impl = "com.github.arteysoft.menu.MenuFileSystem";
        var menu = MenuFactory.obtenerMenu(impl);

        menu.mostrarMenu();
    }
}
