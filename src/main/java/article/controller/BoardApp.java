package article.controller;

import java.util.Scanner;

public class BoardApp {
    Scanner sc = new Scanner(System.in);
    ArticleController articleController = new ArticleController();

    public void start() {
        while (true) {
            System.out.print("명령어 : ");
            String command = sc.nextLine();
            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (command.equals("add")) {
                articleController.add();
            } else if (command.equals("list")) {
                articleController.list();
            } else if (command.equals("update")) {
                articleController.update();
            } else if (command.equals("delete")) {
                articleController.delete();
            } else if (command.equals("detail")) {
                articleController.detail();
            } else if (command.equals("search")) {
                articleController.search();
            }
        }
    }
}
