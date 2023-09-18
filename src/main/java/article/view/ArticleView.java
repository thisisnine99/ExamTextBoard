package article.view;

import article.model.Article;

import java.util.ArrayList;

public class ArticleView {
    public void listView(ArrayList<Article> articles) {
        for (Article article : articles) {
            System.out.println("==============================");
            System.out.println("번호 : " + article.getId());
            System.out.println("제목 : " + article.getTitle());
            System.out.println("등록날짜 : " + article.getRegDate());
        }
    }

    public void printArticleDetail(Article article) {
        System.out.println("==============================");
        System.out.println("번호 : " + article.getId());
        System.out.println("제목 : " + article.getTitle());
        System.out.println("내용 : " + article.getContent());
        System.out.println("등록날짜 : " + article.getRegDate());
        System.out.println("조회수 : " + article.getHit());
    }
}
