package article.controller;

import article.model.Article;
import article.model.ArticleRepository;
import article.model.Comment;
import article.model.CommentRepository;
import article.view.ArticleView;
import article.view.CommentView;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    Scanner sc = new Scanner(System.in);
    ArticleRepository articleRepository = new ArticleRepository();
    ArticleView articleView = new ArticleView();
    CommentRepository commentRepository = new CommentRepository();
    CommentView commentView = new CommentView();

    public void add() {
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = sc.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String content = sc.nextLine();
        articleRepository.insert(title, content);
        System.out.println("게시물이 등록되었습니다.");
    }

    public void list() {
        ArrayList<Article> articles = articleRepository.allArticle();
        articleView.listView(articles);
    }

    public void update() {
        System.out.print("수정할 게시물 번호 : ");
        String strNum = sc.nextLine();
        int num = convertNum(strNum);
        if (num == -1) {
            System.out.println("숫자를 입력해주세요");
        } else {
            Article article = articleRepository.findByNum(num);
            if (article == null) {
                System.out.println("없는 게시물 번호입니다.");
            } else {
                System.out.print("새로운 제목 : ");
                String newTitle = sc.nextLine();
                System.out.print("새로운 내용 : ");
                String newContent = sc.nextLine();
                article.setTitle(newTitle);
                article.setContent(newContent);
                System.out.printf("%d번 게시물이 수정되었습니다.\n", num);
            }
        }
    }

    public void delete() {
        System.out.print("삭제할 게시물 번호 : ");
        String strNum = sc.nextLine();
        int num = convertNum(strNum);
        if (num == -1) {
            System.out.println("숫자를 입력해주세요");
        } else {
            Article article = articleRepository.findByNum(num);
            if (article == null) {
                System.out.println("없는 게시물 번호입니다.");
            } else {
                articleRepository.delete(article);
                System.out.printf("%d번 게시물이 삭제되었습니다.\n", num);
            }
        }
    }

    public void detail() {
        System.out.print("상세보기 할 게시물 번호 : ");
        String strNum = sc.nextLine();
        int num = convertNum(strNum);
        if (num == -1) {
            System.out.println("숫자를 입력해주세요");
        } else {
            Article article = articleRepository.findByNum(num);
            if (article == null) {
                System.out.println("없는 게시물 번호입니다.");
            } else {
                article.setHit(article.getHit() + 1);
                ArrayList<Comment> comments = commentRepository.allComment();
                while(true) {
                    articleView.printArticleDetail(article);
                    commentView.commentView(comments);
                    System.out.println();
                    System.out.print("상세보기 기능을 선택해주세요 (1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");
                    String detailStrNum = sc.nextLine();
                    int detailNum = convertNum(detailStrNum);
                    if (detailNum == 1) {
                        System.out.print("댓글 내용 : ");
                        String comment = sc.nextLine();
                        commentRepository.insert(num, comment);
                        System.out.println("댓글이 성공적으로 등록되었습니다");
                    } else if (detailNum == 2) {
                        System.out.println("[추천 기능]");
                    } else if (detailNum == 3) {
                        System.out.println("[수정 기능]");
                    } else if (detailNum == 4) {
                        System.out.println("[삭제 기능]");
                    } else if (detailNum == 5) {
                        System.out.println("목록으로 돌아갑니다.");
                        break;
                    }
                }
            }
        }
    }
    public void search() {
        System.out.print("검색 키워드를 입력해주세요 : ");
        String keyWord = sc.nextLine();
        ArrayList<Article> articles = articleRepository.findByTitle(keyWord);
        if (articles.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            articleView.listView(articles);
        }
    }

    public int convertNum(String strNum) {
        try {
            return Integer.parseInt(strNum);
        } catch (NumberFormatException ignored) {
        }
        return -1;
    }
}
