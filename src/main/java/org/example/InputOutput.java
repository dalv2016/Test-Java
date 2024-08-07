package org.example;

import org.example.Entities.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class InputOutput {

    private int chooseAnswer;
    private LocalDate dateBegin;
    private LocalDate dateEnd;
    private String path;

    public String getPath() {
        return path;
    }

    public LocalDate getDateBegin() {
        return dateBegin;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }


    private final Scanner input = new Scanner(System.in);

    public  void showMenu(){
        System.out.println("Меню");
        System.out.println("1.Перегляд користувачів");
        System.out.println("2.Перегляд шляхів до фото");
        System.out.println("3.Фільтрація по даті народження");
        System.out.println("4.Сортування по даті народження");
        System.out.println("5.Сортування по гендеру");
        System.out.println("6.Сортування по віку");
        System.out.println("0.Вихід");
    }
    public int inputAnswer(){
        try {
            chooseAnswer = input.nextInt();
            return chooseAnswer;
        }
       catch (Exception e){
            return 0;
       }
    }
    public void outputUsersCountText(){
        System.out.println("Введіть кількість користувачів");

    }

    public void outputSort(){
        System.out.println("Оберіть тип сортування");
        System.out.println("1.Сортувати по зростанню");
        System.out.println("2.Сортувати по спаданню");
    }

    public void inputBirthFilter(){

        System.out.println("Введіть період для фільтрації");
        System.out.println("З(dd/MM/yyyy)");
        String dateStr= input.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dateBegin = LocalDate.parse(dateStr, formatter);
        System.out.println("По(dd/MM/yyyy)");
        dateStr = input.next();
        dateEnd = LocalDate.parse(dateStr, formatter);
    }
    public void showUsers(ArrayList<User> users){
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).toString());
        }
    }

    public String setPathToAvatarPhoto()
    {
        System.out.println("Введіть шлях до директорії в якій будуть збереженні фото:  ");
        path =input.next();
        return path;
    }

}
