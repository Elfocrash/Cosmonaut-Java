package exceptions;

public class InvalidSqlQueryException extends Exception{
    public InvalidSqlQueryException(String sql) {
        super(String.format("The query %s is not valid.", sql));
    }
}
