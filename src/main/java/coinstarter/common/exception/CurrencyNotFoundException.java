package coinstarter.common.exception;

public class CurrencyNotFoundException extends NotFoundException {

    private final String arguments;

    public CurrencyNotFoundException(String arguments) {
        super("해당 화페 정보를 찾을 수 없습니다");
        this.arguments = arguments;
    }

    @Override
    public Object[] getArguments() {
        return new String[]{arguments};
    }
}
