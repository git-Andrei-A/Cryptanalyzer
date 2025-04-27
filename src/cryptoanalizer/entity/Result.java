package cryptoanalizer.entity;

public class Result {
    private final String massage;
    private final ResultCode resultCode;

    public Result(String massage, ResultCode resultCode) {
        this.massage = massage;
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "\nResult: " + massage + "\n" +
                "resultCode=" + resultCode + "\n";
    }
}
