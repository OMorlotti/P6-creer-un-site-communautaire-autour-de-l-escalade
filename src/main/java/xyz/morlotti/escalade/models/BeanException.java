package xyz.morlotti.escalade.models;

public class BeanException extends Exception
{
	public BeanException(String message)
	{
		super(message);
	}

	public BeanException(Throwable cause)
	{
		super(cause);
	}
}
