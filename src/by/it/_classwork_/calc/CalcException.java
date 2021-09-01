package by.it._classwork_.calc;

@SuppressWarnings("unused")
public class CalcException extends Exception {

    public CalcException() {
        super();
    }

    public CalcException(String message) {
        super("ERROR:" + message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR:" + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }


    }
