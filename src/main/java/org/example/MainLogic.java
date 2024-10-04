package org.example;

import lombok.Getter;
import org.example.API.HTTPClient;
import org.example.Entities.User;

import java.util.ArrayList;

public class MainLogic {
    private HTTPClient client = new HTTPClient();

    private ImageController imageSettings = new ImageController();
    private InputOutput menu = new InputOutput();
    private SortsAndFilters sortAndFilter = new SortsAndFilters();
    private ArrayList<User> users;
    private int countOfUsers;
    @Getter
    private int answer;

    public void setPath(){
        menu.setPathToAvatarPhoto();
        imageSettings.setDirectiryName(menu.getPath().toString());
    }
    public void enterCountOfUser(){

        menu.outputUsersCountText();
        countOfUsers = menu.inputAnswer();
        users = client.getUsers(countOfUsers);
    }
    public void savePhoto(){
        imageSettings.deleteAllFilesFolder(imageSettings.getDirectiryName());
        for (int i = 0; i < users.size(); i++) {
            String newPAth = imageSettings.saveImg(users.get(i).getAvatar(), "Avatar" + i);
            imageSettings.addPath(newPAth);
        }
    }
    public void listCall(){

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
                    menu.outputFilter();
                    menu.inputDate("З");
                    menu.inputDate("По");
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
                    answer = menu.inputAnswer();
                    if (answer == 1) {
                        sortAndFilter.sortByAgeLowToUp(users);
                    } else if (answer == 2) {
                        sortAndFilter.sortByAgeUpToLow(users);
                    }
                    break;
                }
            }
    }
}
