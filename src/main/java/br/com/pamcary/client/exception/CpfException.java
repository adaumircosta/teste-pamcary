package br.com.pamcary.client.exception;

public class CpfException extends Exception{
	
	public CpfException(String message) {
        super(message);
    }

    public CpfException(String message, Throwable cause) {
        super(message, cause);
    }

}
