package t02;

import java.io.IOException;
import java.util.*;

/**
 * Задание 2. Locale и ResourceBundle
 * Разработать приложение, позволяющее по выбору пользователя использовать русский
 * или английский язык, для отображения информации.  Приложение должно представлять
 * собой перечень вопросов под номерами (на английском или русском соответственно).
 * Выбрав номер вопроса пользователь может узнать ответ на него.
 */
public class Survey {

    private static ResourceBundle resourceBundle;
    private static Map<String, Locale> locales;

    static {
        locales = new HashMap<>();
        locales.put("ru_RU", new Locale("ru", "RU"));
        locales.put("en_UK", new Locale("en", "UK"));
    }

    public void getMenu() throws IOException {
        System.out.println("Choose language");
        System.out.println("1. English");
        System.out.println("2. Русский");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String input = scanner.nextLine();
                int answer = Integer.valueOf(input);

                if (answer == 1) {
                    resourceBundle = ResourceBundle.getBundle("settings", locales.get("en_UK"));
                } else if (answer == 2) {
                    resourceBundle = ResourceBundle.getBundle("settings", locales.get("ru_RU"));
                } else {
                    System.out.println("You gotta get out");
                }
                System.out.println("Choose question");
                System.out.println(resourceBundle.getObject("question1"));
                System.out.println(resourceBundle.getObject("question2"));
                System.out.println(resourceBundle.getObject("question3"));

                switch (scanner.nextLine()) {
                    case "1":
                        System.out.println(resourceBundle.getObject("answer1"));
                        break;
                    case "2":
                        System.out.println(resourceBundle.getObject("answer2"));
                        break;
                    case "3":
                        System.out.println(resourceBundle.getObject("answer3"));
                        break;
                    default:
                        System.out.println("Wrong!");
                }
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Survey survey = new Survey();
        survey.getMenu();
    }

}