package coinstarter.common.exception;

public class CurrencyNotFoundException extends NotFoundException {

    private final String arguments;

    public CurrencyNotFoundException(String arguments) {
        super(arguments);
        this.arguments = arguments;
    }

    @Override
    public Object[] getArguments() {
        return new String[]{arguments};
    }
}
