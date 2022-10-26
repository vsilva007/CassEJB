package ad.cass.exception;

public class CassException extends Exception {
	private static final long serialVersionUID = 1L;

	public CassException() {
		super();
	}

	public CassException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CassException(String message, Throwable cause) {
		super(message, cause);
	}

	public CassException(String message) {
		super(message);
	}

	public CassException(Throwable cause) {
		super(cause);
	}
}
