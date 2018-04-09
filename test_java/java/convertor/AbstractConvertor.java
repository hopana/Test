package convertor;

public abstract class AbstractConvertor {

    public AbstractConvertor() {

    }

    public abstract void convert(String encoding1, String encoding2, String sourcePath, String newPath);

}
