package article.model;

public class Comment {
    private int id;
    private String comment;
    private String commentDate;
    public Comment(int id, String comment, String commentDate) {
        this.id = id;
        this.comment = comment;
        this.commentDate = commentDate;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
