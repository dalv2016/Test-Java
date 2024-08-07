package org.example;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class ImageController {

    private List<String> pathes = new ArrayList<>();
    private String directoryName;

    public String getDirectiryName() {
        return directoryName;
    }

    public void setDirectiryName(String directiryName) {
        this.directoryName = directiryName;
    }


    public String sortAndFilter (String url, String imageName) throws IOException {
        Path savePath = Path.of(directoryName + imageName+".jpg");

        try {
            BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(imageName);
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
            Files.copy(in, savePath, StandardCopyOption.REPLACE_EXISTING);

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
        for (File myFile : new File(path).listFiles())
            if (myFile.isFile()) myFile.delete();
    }
}
