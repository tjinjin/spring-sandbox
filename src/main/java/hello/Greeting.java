package hello;

public class Greeting {

    private final long id;
    private final String content;
    private final String test;

    public Greeting(long id, String content, String test) {
        this.id = id;
        this.content = content;
        this.test = test;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    public String getTest() {
        return test;
    }
}
