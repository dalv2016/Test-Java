package org.example;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.API.HTTPClient;

import org.example.Entities.User;
import java.io.IOException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        HTTPClient client = new HTTPClient();
        ObjectMapper objectMapper = new ObjectMapper();
        ImageController imageSettings = new ImageController();
        InputOutput menu = new InputOutput();
        MainLogic sortAndFilter = new MainLogic();
        ArrayList<User> users;
        int countOfUsers;
        int answer;

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        menu.setPathToAvatarPhoto();
        imageSettings.setDirectiryName(menu.getPath());
        menu.outputUsersCountText();
        countOfUsers = menu.inputAnswer();
        users = objectMapper.readValue(client.getUsers(countOfUsers), new TypeReference<>() {
        });
        imageSettings.deleteAllFilesFolder(imageSettings.getDirectiryName());
        for (int i = 0; i < users.size(); i++) {
            String newPAth = imageSettings.sortAndFilter(users.get(i).getAvatar(), "Avatar" + i);
            imageSettings.addPath(newPAth);
        }
        do {
            menu.showMenu();
            switch (answer = menu.inputAnswer()) {
                case 1: {
                    menu.showUsers(users);
                    break;
                }
                case 2: {
                    imageSettings.getAllPath();
                    break;
                }
                case 3: {

                    sortAndFilter.filterBYDateOfBirth(users, menu.getDateBegin(), menu.getDateEnd());
                    break;
                }
                case 4: {
                    menu.outputSort();
                    answer = menu.inputAnswer();
                    if ( answer== 1) {
                        sortAndFilter.sortByDateOfBirthLowToUp(users);
                    } else if (answer== 2) {
                        sortAndFilter.sortByDateOfBirthUpToLow(users);
                    }
                    break;
                }
                case 5: {
                    sortAndFilter.sortByGender(users);
                    break;
                }
                case 6: {
                    menu.outputSort();
                    if (menu.inputAnswer() == 1) {
                        sortAndFilter.sortByAgeLowToUp(users);
                    } else if (menu.inputAnswer() == 2) {
                        sortAndFilter.sortByAgeUpToLow(users);
                    }
                    break;
                }
            }
        }while (answer!=0);

    }
}
