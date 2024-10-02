package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImageController {

    private List<String> pathes = new ArrayList<>();
    private String directoryNameToSave;

    public String getDirectiryName() {
        return directoryNameToSave;
    }

    public void setDirectiryName(String directiryName) {
        if (!directiryName.endsWith("/")) {
            directiryName = directiryName+"/";
        }
        this.directoryNameToSave = directiryName;
    }


    public String saveImg (String url, String imageName) {
        String savePath = directoryNameToSave + imageName+".jpg";
        try(InputStream in = URI.create(url).toURL().openStream()) {
            Files.copy(in, Path.of(savePath),StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return savePath.toString();
    }
    public void addPath(String path){
        pathes.add(path);
    }
    public void getAllPath(){
        for (int i = 0; i < pathes.size(); i++) {
            System.out.println(pathes.get(i));
        }
    }
    public void getPathByUserid(int id){
        for (int i = 0; i < pathes.size(); i++) {
            if(id == i) System.out.println(pathes.get(i));
        }

        System.out.println(pathes.get(pathes.size()-1));
    }

    public void deleteAllFilesFolder(String path) {
        for (File myFile : Objects.requireNonNull(new File(path).listFiles()))
            if (myFile.isFile()) myFile.delete();
    }
}
