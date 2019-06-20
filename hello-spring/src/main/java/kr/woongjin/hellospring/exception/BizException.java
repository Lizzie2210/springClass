package kr.woongjin.hellospring.exception;

public class BizException extends RuntimeException{
	
	//예외가 발생하는 시점에 얘네로 rethrowing 함.
	public BizException(){
		super();
	} 
	public BizException(String msg){
		super(msg);
	}
	public BizException(Exception e){
		super(e);
	}
	
	public BizException(String msg, Exception e){
		super(msg, e);
	}
	
}
