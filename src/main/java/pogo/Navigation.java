package pogo;

public class Navigation {
    private int nid;
    private String content;


    public Navigation() {
    }

    public Navigation(int nid, String content) {
        this.nid = nid;
        this.content = content;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
