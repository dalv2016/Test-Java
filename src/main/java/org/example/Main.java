package org.example;

import java.io.IOException;

public class Main {

    static MainLogic mainLogic = new MainLogic();
    public static void  main(String[] args) throws IOException {
        mainLogic.setPath();
        mainLogic.enterCountOfUser();
        mainLogic.savePhoto();
        do {
            mainLogic.listCall();
        } while (mainLogic.getAnswer()!=0);
    }
}
