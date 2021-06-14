package kr.or.ddit.exception;

public class NotMultipartFormDataException extends Exception {
	public NotMultipartFormDataException() {
		super("멀티파트 폼이 아닙니다.");
	}
}
