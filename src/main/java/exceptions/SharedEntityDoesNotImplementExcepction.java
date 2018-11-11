package exceptions;

import core.SharedCosmosEntity;

public class SharedEntityDoesNotImplementExcepction extends Exception {
    public SharedEntityDoesNotImplementExcepction(Class clazz) {
        super(String.format("Shared entity %s has appropriate attribute but must also implement %s",
                clazz.getName(), SharedCosmosEntity.class.getName()));
    }
}
