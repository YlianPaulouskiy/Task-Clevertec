package edu.clevertec.task.receipt.exception;

public class IncorrectInputSourceException extends RuntimeException {

    public IncorrectInputSourceException() {
        this("Incorrect input data source, input data will be match regular expression:\n(\\d-\\d\\s*)+(card-\\d{4})?");
    }

    public IncorrectInputSourceException(String message) {
        super(message);
    }
}
