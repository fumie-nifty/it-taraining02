package jp.co.flm.web.control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.flm.common.exception.BusinessException;
import jp.co.flm.domain.dto.EmployeeDto;
import jp.co.flm.domain.service.AllEmpService;

/**
 * 従業員一覧コントローラー
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
@Controller
public class AllEmpController {

	/** 従業員検索Service */
	private AllEmpService allEmpService;

	/** コンストラクタインジェクション */
	public AllEmpController(AllEmpService allEmpService) {
		this.allEmpService = allEmpService;
	}

	/**
	 * 全従業員の情報を検索し、従業員一覧検索結果画面を表示する
	 * 
	 * HTTPメソッド	： GET
	 * URL			： /retrieveAllEmployee
	 * @return 従業員一覧検索結果画面（retrieve-list.html）
	 */
	@GetMapping("/retrieveAllEmployee")
	public String retrieveAllEmployee(Model model) {

		// Serviceの呼び出し
		List<EmployeeDto> employeeList = allEmpService.getAllEmployee();

		// Modelに情報を設定
		model.addAttribute("employeeList", employeeList);

		// 次画面名（retrieve-list.html）を返却する
		return "retrieve-list";
	}

	/**
	 * 業務例外のハンドリング
	 * ハンドリングする例外クラス： BusinessException.class
	 */
	@ExceptionHandler(BusinessException.class)
	public String catchBizException(Model model, Exception e) {

		// エラーメッセージをModelに設定
		model.addAttribute("message", e.getMessage());

		// 次画面名（retrieve-list.html）を返却する
		return "retrieve-list";
	}

}
