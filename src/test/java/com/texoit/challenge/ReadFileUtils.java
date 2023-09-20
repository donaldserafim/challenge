package com.texoit.challenge;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;

public class ReadFileUtils {

    public static String readFileAndReturnLines(String file) {
        try{
            File resource = new ClassPathResource(file).getFile();
            return Files.readString(resource.toPath());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
