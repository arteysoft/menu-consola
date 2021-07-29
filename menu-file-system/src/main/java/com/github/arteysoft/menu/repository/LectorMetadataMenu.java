package com.github.arteysoft.menu.repository;

import java.io.File;
import com.github.arteysoft.menu.model.*;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

public class LectorMetadataMenu {
    public MetadataMenu leer() {
        try {
            String jsonFile = FileUtils.readFileToString(
                    new File("/var/com/github/arteysoft/menu/menu.json"),
                    "UTF-8"
            );
            MetadataMenu mm = new Gson().fromJson(jsonFile, MetadataMenu.class);
            return mm;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }
}
