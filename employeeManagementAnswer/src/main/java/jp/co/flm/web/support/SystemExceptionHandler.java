/**
 * SystemExceptionHandler.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package jp.co.flm.web.support;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * システム例外をハンドリングするクラス
 * すべてのControllerクラスで発生するシステム例外をハンドリングする
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
@ControllerAdvice
public final class SystemExceptionHandler {

	/**
	 * DataAccessException発生時にエラー画面を表示する
	 * レスポンスステータスコード： HttpStatus.INTERNAL_SERVER_ERROR
	 * ハンドリングする例外クラス： DataAccessException.class
	 * @param model {@link Model}オブジェクト
	 * @return エラー画面（system-erro.html）
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(DataAccessException.class)
	public String handleError(Model model) {
		// エラーメッセージをキー名"errorMessage"でModelに格納する
		model.addAttribute("errorMessage", "システムエラーです。システム管理者に連絡してください。");

		// 次画面名（system-erro.html）を返却する
		return "system-error";
	}

	/**
	 * その他の例外発生時にエラー画面を表示する
	 * レスポンスステータスコード： HttpStatus.INTERNAL_SERVER_ERROR
	 * ハンドリングする例外クラス： Exception.class
	 * @param e {@link Exception}オブジェクト
	 * @param model {@link Model}オブジェクト
	 * @return エラー画面（system-erro.html）
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String handleError(Exception e, Model model) {
		// 例外オブジェクトのエラーメッセージをキー名"errorMessage"でModelに格納する
		model.addAttribute("errorMessage", e.getMessage());
		e.printStackTrace();
		// 次画面名（system-erro.html）を返却する
		return "system-error";
	}
}
