package exceptions;

public class IllegalCosmosThroughputException extends Exception{

    public IllegalCosmosThroughputException() {
        super("CosmosDB throughput cannot be less than 400 and has to be incrementals of 100.");
    }
}
