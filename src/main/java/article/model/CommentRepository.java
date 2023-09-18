package article.model;

import util.Util;

import java.util.ArrayList;

public class CommentRepository {
    private ArrayList<Comment> comments = new ArrayList<>();
    public ArrayList<Comment> allComment() {
        return comments;
    }
    public void insert(int id, String comment) {
        Comment comment1 = new Comment(id, comment, Util.getCurrentDate());
        comments.add(comment1);
    }
    public Comment findByNum(int num) {
        for (Comment comment : comments) {
            if (num == comment.getId()) {
                return comment;
            }
        }
        return null;
    }
}
