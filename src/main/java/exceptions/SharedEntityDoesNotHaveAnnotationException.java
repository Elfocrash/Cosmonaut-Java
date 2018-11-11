package exceptions;

import annotations.SharedCosmosCollection;
import core.SharedCosmosEntity;

public class SharedEntityDoesNotHaveAnnotationException extends Exception {
    public SharedEntityDoesNotHaveAnnotationException(Class clazz) {
        super(String.format("Shared entity %s implements %s but must also have the %s",
                clazz.getName(), SharedCosmosEntity.class.getName(), SharedCosmosCollection.class.getName()));
    }
}
