public class SimFile {
    private String name;
    private String content;
    private boolean hidden;

    public SimFile(String name, String content) {
        this.name = name;
        this.content = content;
        this.hidden = false;
    }

    public SimFile(String name, String content, boolean hidden) {
        this.name = name;
        this.content = content;
        this.hidden = hidden;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void rename(String newName) {
        this.name = newName;
    }
}