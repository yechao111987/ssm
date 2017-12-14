package yechao.basic;

public class Response<T> {
	private String code;
	private String message;
	private T t;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public T getDataResult() {
		return t;
	}
	
	public void  setDataResult(T t) {
		this.t=t;
	}
}
