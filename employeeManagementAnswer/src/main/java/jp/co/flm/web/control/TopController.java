package jp.co.flm.web.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * トップコントローラー
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
@Controller
public class TopController {

	@GetMapping("/")
	public String handler() {
		// 次画面名（top.html）を返却する
		return "top";
	}

}
