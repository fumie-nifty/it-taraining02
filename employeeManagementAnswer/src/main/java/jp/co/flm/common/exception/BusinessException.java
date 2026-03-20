package jp.co.flm.common.exception;

/**
 * 業務例外クラス
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
public class BusinessException extends RuntimeException{

	public BusinessException(String message) {
		super(message);
	}

}
