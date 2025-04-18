package contracts;

public interface IFileReader {
    void read(String filePath, LineProcessor processor);
}
