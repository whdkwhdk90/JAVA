package com.silsub1.exception;

public class CharCheckException extends Exception {

	public CharCheckException() {
		System.out.println("체크할 문자열 안에 공백 포함할 수 없습니다.");
	}
}
