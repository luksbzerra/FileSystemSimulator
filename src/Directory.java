import java.util.ArrayList;
import java.util.List;

public class Directory {
    private String name;
    private boolean hidden;
    private List<SimFile> files;
    private List<Directory> directories;

    public Directory(String name) {
        this.name = name;
        this.hidden = false;
        this.files = new ArrayList<>();
        this.directories = new ArrayList<>();
    }

    public Directory(String name, boolean hidden) {
        this.name = name;
        this.hidden = hidden;
        this.files = new ArrayList<>();
        this.directories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void rename(String newName) {
        this.name = newName;
    }

    public List<SimFile> getFiles() {
        return files;
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public void addFile(SimFile file) {
        files.add(file);
    }

    public void addDirectory(Directory directory) {
        directories.add(directory);
    }

    public SimFile findFile(String name) {
        for (SimFile file : files) {
            if (file.getName().equals(name)) {
                return file;
            }
        }
        return null;
    }

    public Directory findDirectory(String name) {
        for (Directory directory : directories) {
            if (directory.getName().equals(name)) {
                return directory;
            }
        }
        return null;
    }

    public void removeFile(String name) {
        files.removeIf(file -> file.getName().equals(name));
    }

    public void removeDirectory(String name) {
        directories.removeIf(directory -> directory.getName().equals(name));
    }
}