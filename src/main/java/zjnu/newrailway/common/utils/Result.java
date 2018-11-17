package zjnu.newrailway.common.utils;



import java.io.Serializable;

/**
 *
 * @param <T>
 */

//保证序列化json的时候，如果是null的时候，key也会消失
public class Result<T> implements Serializable{
    private int status;
    private String msg;
    private T data;

    private Result(int status) {
        this.status = status;
    }

    private Result(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private Result(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private Result(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }


    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.status== ResultCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T> Result createBySuccess(){
        return new Result<T>(ResultCode.SUCCESS.getCode());
    }

    /*一个static方法，无法访问泛型类的类型参数，所以，若要static方法需要使用泛型能力，必须使其成为泛型方法*/
    public static <T> Result<T> createBySuccessMessage(String msg){
        return new Result<T>(ResultCode.SUCCESS.getCode(),msg);
    }

    public static <T> Result<T> createBySuccess(T data){
        return new Result<T>(ResultCode.SUCCESS.getCode(),data);
    }

    public static <T> Result<T> createBySuccess(String msg, T data){
        return new Result<T>(ResultCode.SUCCESS.getCode(),msg,data);
    }

    public static <T> Result<T> createByError(){
        return new Result<T>(ResultCode.ERROR.getCode(), ResultCode.ERROR.getDesc());
    }

    public static <T> Result<T> createByErrorMessage(String errorMessage){
        return new Result<T>(ResultCode.ERROR.getCode(),errorMessage);
    }

    public static <T> Result<T> createByErrorCodeMessage(int errorCode, String errorMessage){
        return new Result<T>(errorCode,errorMessage);
    }
}
