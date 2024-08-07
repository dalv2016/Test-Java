package org.example;

import org.example.Entities.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class MainLogic {

    public void sortByGender(ArrayList<User> users){
        users.sort(Comparator.comparing(User::getGender));
    }
    public void sortByDateOfBirthLowToUp(ArrayList<User> users){
        users.sort(Comparator.comparing(User::getDate_of_birth));
    }
    public void sortByDateOfBirthUpToLow(ArrayList<User> users){
        users.sort(Comparator.comparing(User::getDate_of_birth).reversed());
    }
    public void sortByAgeLowToUp(ArrayList<User> users){
        users.sort(Comparator.comparing(User::getAge));
    }
    public void sortByAgeUpToLow(ArrayList<User> users){
        users.sort(Comparator.comparing(User::getAge).reversed());
    }

    public void filterBYDateOfBirth(ArrayList<User> users, LocalDateTime firstDate, LocalDateTime secondDate){

        for (int i = 0; i < users.size() ; i++) {
            if(users.get(i).getDate_of_birth().isAfter(firstDate.toLocalDate())
                    && users.get(i).getDate_of_birth().isBefore(secondDate.toLocalDate())){
                System.out.println(users.get(i).getDate_of_birth());
            }
        }
    }


}
