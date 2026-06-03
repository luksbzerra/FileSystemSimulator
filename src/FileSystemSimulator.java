public class FileSystemSimulator {
    private Directory root;
    private Journal journal;

    public FileSystemSimulator() {
        this.root = new Directory("root");
        this.journal = new Journal("journal.log");
    }

    public void criarDiretorio(String name) {
        if (root.findDirectory(name) == null) {
            root.addDirectory(new Directory(name));
            journal.register("[CREATE_DIR] Diretório criado: " + name);
            System.out.println("Diretório criado: " + name);
        } else {
            System.out.println("Diretório já existe.");
        }
    }

    public void apagarDiretorio(String name) {
        if (root.findDirectory(name) != null) {
            root.removeDirectory(name);
            journal.register("[DELETE_DIR] Diretório apagado: " + name);
            System.out.println("Diretório apagado: " + name);
        } else {
            System.out.println("Diretório não encontrado.");
        }
    }

    public void renomearDiretorio(String oldName, String newName) {
        Directory directory = root.findDirectory(oldName);

        if (directory != null) {
            directory.rename(newName);
            journal.register("[RENAME_DIR] " + oldName + " -> " + newName);
            System.out.println("Diretório renomeado.");
        } else {
            System.out.println("Diretório não encontrado.");
        }
    }

    public void criarArquivo(String name, String content) {
        if (root.findFile(name) == null) {
            root.addFile(new SimFile(name, content));
            journal.register("[CREATE_FILE] Arquivo criado: " + name);
            System.out.println("Arquivo criado: " + name);
        } else {
            System.out.println("Arquivo já existe.");
        }
    }

    public void copiarArquivo(String sourceName, String copyName) {
        SimFile file = root.findFile(sourceName);

        if (file != null) {
            root.addFile(new SimFile(copyName, file.getContent()));
            journal.register("[COPY_FILE] " + sourceName + " -> " + copyName);
            System.out.println("Arquivo copiado.");
        } else {
            System.out.println("Arquivo de origem não encontrado.");
        }
    }

    public void apagarArquivo(String name) {
        if (root.findFile(name) != null) {
            root.removeFile(name);
            journal.register("[DELETE_FILE] Arquivo apagado: " + name);
            System.out.println("Arquivo apagado.");
        } else {
            System.out.println("Arquivo não encontrado.");
        }
    }

    public void renomearArquivo(String oldName, String newName) {
        SimFile file = root.findFile(oldName);

        if (file != null) {
            file.rename(newName);
            journal.register("[RENAME_FILE] " + oldName + " -> " + newName);
            System.out.println("Arquivo renomeado.");
        } else {
            System.out.println("Arquivo não encontrado.");
        }
    }

    public void listarDiretorio() {
    System.out.println("\nConteúdo visível do diretório root:");

    System.out.println("Diretórios:");
    for (Directory directory : root.getDirectories()) {
        if (!directory.isHidden()) {
            System.out.println("- " + directory.getName());
        }
    }

    System.out.println("Arquivos:");
    for (SimFile file : root.getFiles()) {
        if (!file.isHidden()) {
            System.out.println("- " + file.getName());
        }
    }

    journal.register("[LIST_DIR] Listagem visível do diretório root");
}
    public void criarDiretorioOculto(String name) {
    if (root.findDirectory(name) == null) {
        root.addDirectory(new Directory(name, true));
        journal.register("[CREATE_HIDDEN_DIR] Diretório oculto criado: " + name);
        System.out.println("Diretório oculto criado: " + name);
    } else {
        System.out.println("Diretório já existe.");
    }
}

public void criarArquivoOculto(String name, String content) {
    if (root.findFile(name) == null) {
        root.addFile(new SimFile(name, content, true));
        journal.register("[CREATE_HIDDEN_FILE] Arquivo oculto criado: " + name);
        System.out.println("Arquivo oculto criado: " + name);
    } else {
        System.out.println("Arquivo já existe.");
    }
}
}