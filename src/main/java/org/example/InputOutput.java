package org.example;

import lombok.Data;
import org.example.Entities.User;

import java.io.File;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

@Data
public class InputOutput {

    private int chooseAnswer;
    private LocalDate dateBegin;
    private LocalDate dateEnd;
    private Path path;
    private boolean restart;

    private Scanner input = new Scanner(System.in);

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
        do {
            try {
                input = new Scanner(System.in);
                chooseAnswer = input.nextInt();
                restart=false;
            } catch (Exception e) {
                restart = true;
                System.out.println("Невірно вказані дані, ведіть дані заново");
            }
        }while (restart);
        return chooseAnswer;
    }
    public void outputUsersCountText(){
        System.out.println("Введіть кількість користувачів");

    }

    public void outputSort(){
        System.out.println("Оберіть тип сортування");
        System.out.println("1.Сортувати по зростанню");
        System.out.println("2.Сортувати по спаданню");
    }
    public void outputFilter()
    {
        System.out.println("Введіть період для фільтрації");
    }
    public void inputDate(String text){
        do {

            try {
                System.out.println(text +" (dd/MM/yyyy)");
                String dateStr = input.next();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                if(text.equals("З"))
                {
                    dateBegin = LocalDate.parse(dateStr, formatter);
                }
                else if (text.equals("По"))
                {
                    dateEnd = LocalDate.parse(dateStr, formatter);
                }
                restart = false;
            } catch (Exception e) {
                restart = true;
                System.out.println("Перевірте правельність заповнення даних");
            }
        } while (restart);
    }
    public void showUsers(ArrayList<User> users){
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).toString());
        }
    }

    public Path setPathToAvatarPhoto()
    {
        File file;
            do {
                System.out.println("Введіть шлях до директорії в якій будуть збереженні фото:  ");
                path = Path.of(input.next());
                 file = new File(path.toString());

            } while (!file.isDirectory());
             return path;
    }

}
