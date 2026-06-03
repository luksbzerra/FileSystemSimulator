public class Main {
    public static void main(String[] args) {
        FileSystemSimulator fs = new FileSystemSimulator();

        fs.criarDiretorio("documentos");
        fs.criarDiretorio("imagens");

        fs.criarArquivo("arquivo1.txt", "Conteúdo do arquivo 1");
        fs.criarArquivo("arquivo2.txt", "Conteúdo do arquivo 2");

        fs.copiarArquivo("arquivo1.txt", "copia_arquivo1.txt");

        fs.renomearArquivo("arquivo2.txt", "arquivo_renomeado.txt");

        fs.renomearDiretorio("imagens", "fotos");

        fs.listarDiretorio();

        fs.apagarArquivo("copia_arquivo1.txt");

        fs.apagarDiretorio("fotos");

        fs.listarDiretorio();
        fs.criarDiretorioOculto("System Volume Information");
fs.criarArquivoOculto("pagefile.sys", "Arquivo interno do sistema");
    }
}