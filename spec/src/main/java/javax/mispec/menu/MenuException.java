package javax.mispec.menu;

public class MenuException extends RuntimeException {
    public MenuException(String s) {
        super(s);
    }
    public MenuException() {
        super("javax.mispec.menu::MenuException");
    }
}
