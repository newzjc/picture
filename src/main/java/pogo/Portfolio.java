package pogo;

public class Portfolio {
    private int pid;
    private String pname;
    private int view;
    private int like;
    private int comment;
    private String organization;
    private String author;
    private String img;

    public Portfolio() {
    }

    public Portfolio(int pid, String pname, int view, int like, int comment, String organization, String author, String img) {
        this.pid = pid;
        this.pname = pname;
        this.view = view;
        this.like = like;
        this.comment = comment;
        this.organization = organization;
        this.author = author;
        this.img = img;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
