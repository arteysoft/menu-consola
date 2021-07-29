package com.github.arteysoft.menu;

import java.util.Optional;
import java.util.Scanner;
import javax.mispec.menu.*;
import com.github.arteysoft.menu.model.*;
import com.github.arteysoft.menu.repository.LectorMetadataMenu;

public class MenuFileSystem implements javax.mispec.menu.Menu {
    private MetadataMenu metadataMenu;

    private Opcion mostrarIntento() {
        System.out.println(metadataMenu.titulo);
        System.out.println();
        for (Opcion op : metadataMenu.opciones) {
            String strOut = String.join("> ", op.nroOpcion+"", op.descripcion);
            System.out.println(strOut);
        }
        System.out.println();
        System.out.println("Seleccione una opcion");
        try {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            // busqueda de lo ingresado para ver si coincide
            Optional<Opcion> optOpcion = metadataMenu
                    .opciones
                    .stream()
                    .filter(op -> op.nroOpcion == i)
                    .findFirst();

            if (!optOpcion.isPresent()) {
                throw new RuntimeException("La opcion seleccionada NO esta presente");
            }
            return optOpcion.get();
        }
        catch (Exception ex) {
            throw new javax.mispec.menu.MenuException("La opcion seleccionada NO esta presente");
        }
    }
    private void ejecutarOpcion(String nombreClase) {
        try {
            MenuItem im = (MenuItem)Class.forName(nombreClase).newInstance();
            im.ejecutarOpcionMenu();
        }
        catch (Exception ex) {
            System.out.println("Fallo la ejecucion");
            ex.printStackTrace();
        }
    }
    private void separador() {
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public void mostrarMenu() {
        metadataMenu = metadataMenu = new LectorMetadataMenu().leer();
        int totIntentos = metadataMenu.configuracion.totalIntentos;

        for (int x = 1; x <= totIntentos;x++) {
            try {
                Opcion o = mostrarIntento();
                if (o.continuar==false) {
                    x = totIntentos+1;
                    continue;
                }
                ejecutarOpcion(o.claseInstanciar);
                x = 1;
                separador();
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
                separador();
            }
        }
    }
}
