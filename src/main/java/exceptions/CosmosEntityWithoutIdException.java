package exceptions;

public class CosmosEntityWithoutIdException extends Exception {

    public CosmosEntityWithoutIdException(Class clazz) {
        super(String.format("Unable to resolve Id for cosmos entity of type %s", clazz.getName()));
    }
}
