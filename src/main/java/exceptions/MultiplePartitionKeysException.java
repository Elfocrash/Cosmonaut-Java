package exceptions;

public class MultiplePartitionKeysException extends Exception {

    public MultiplePartitionKeysException(Class clazz) {
        super("A collection cannot have more than one Partition Keys.");
    }
}
