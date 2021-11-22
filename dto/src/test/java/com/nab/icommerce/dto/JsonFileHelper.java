package com.nab.icommerce.dto;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class JsonFileHelper {
    public static String getJsonFromFile(final String fileName) {
        URL fileUrl = JsonFileHelper.class.getResource(fileName);
        try {
            return FileUtils.readFileToString(new File(fileUrl.toURI()),"utf-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
