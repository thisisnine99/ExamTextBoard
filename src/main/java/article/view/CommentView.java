package article.view;

import article.model.Comment;

import java.util.ArrayList;

public class CommentView {
    public void commentView(ArrayList<Comment> comments) {
        for (Comment comment : comments) {
            System.out.println("==============================");
            System.out.println("댓글 : " + comment.getComment());
            System.out.println("작성일 : " + comment.getCommentDate());
        }
    }
}
