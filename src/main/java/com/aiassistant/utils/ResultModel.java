public class ResultModel<T> {
    private Exception exception;
    private T data;
    private String msg;
    private Integer code;

    public ResultModel() {
    }

    public ResultModel(Exception exception, T data, String msg, Integer code) {
        this.exception = exception;
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public static <T> ResultModel<T> ofResult(Integer code, String msg, T data) {
        ResultModel<T> result = new ResultModel<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> ResultModel<T> ofResult(Integer code, String msg, T data, Exception exception) {
        ResultModel<T> result = new ResultModel<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        result.setException(exception);
        return result;
    }

    public static <T> ResultModel<T> ofSuccess() {
        ResultModel<T> result = new ResultModel<>();
        result.setCode(200);
        result.setMsg("Success");
        return result;
    }

    public static <T> ResultModel<T> ofSuccess(T data) {
        ResultModel<T> result = new ResultModel<>();
        result.setCode(200);
        result.setMsg("Success");
        result.setData(data);
        return result;
    }

    public static <T> ResultModel<T> ofSuccess(String msg, T data) {
        ResultModel<T> result = new ResultModel<>();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> ResultModel<T> ofError() {
        ResultModel<T> result = new ResultModel<>();
        result.setCode(500);
        result.setMsg("Error");
        return result;
    }

    public static <T> ResultModel<T> ofError(String msg) {
        ResultModel<T> result = new ResultModel<>();
        result.setCode(500);
        result.setMsg(msg);
        return result;
    }

    public static <T> ResultModel<T> ofError(String msg, Exception exception) {
        ResultModel<T> result = new ResultModel<>();
        result.setCode(500);
        result.setMsg(msg);
        result.setException(exception);
        return result;
    }
}
