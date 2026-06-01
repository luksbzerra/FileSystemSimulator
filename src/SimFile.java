public class SimFile {
    private String name;
    private String content;

    public SimFile(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void rename(String newName) {
        this.name = newName;
    }
}