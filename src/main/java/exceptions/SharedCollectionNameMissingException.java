package exceptions;

public class SharedCollectionNameMissingException extends Exception {

    public SharedCollectionNameMissingException(Class clazz) {
        super(String.format("Unable to resolve shared collection name for type %s", clazz.getName()));
    }
}
