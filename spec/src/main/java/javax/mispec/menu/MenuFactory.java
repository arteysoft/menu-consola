package javax.mispec.menu;

public class MenuFactory {
    private static Menu impl = null;

    public static Menu obtenerMenu(String nombreImplementacion) {
        Object implementacion = null;

        try {
            implementacion = Class
                    .forName(nombreImplementacion)
                    .getConstructor()
                    .newInstance();
        }
        catch (Exception ex) {
            var str = new StringBuilder()
                    .append("La implementacion ")
                    .append(nombreImplementacion)
                    .append(" no se encuentra")
                    .toString();

            throw new MenuException(str);
        }

        try {
            impl = (Menu)implementacion;
        }
        catch (Exception ex) {
            var str = new StringBuilder()
                    .append("La implementacion ")
                    .append(nombreImplementacion)
                    .append(" no es del tipo ")
                    .append("javax.mispec.menu.Menu")
                    .toString();

            throw new MenuException(str);
        }

        return impl;
    }
}
