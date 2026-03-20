package jp.co.flm.web.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.flm.common.exception.BusinessException;
import jp.co.flm.domain.dto.EmployeeDto;
import jp.co.flm.domain.service.SearchEmpService;
import jp.co.flm.web.form.EmployeeIdForm;

/**
 * 従業員検索Controller
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
@Controller
public class SearchEmpController {

	/** 従業員検索Service */
	private SearchEmpService searchEmpService;

	/** コンストラクタインジェクション */
	public SearchEmpController(SearchEmpService searchEmpService) {
		this.searchEmpService = searchEmpService;
	}

	/**
	 * 従業員検索画面を表示する
	 * 
	 * HTTPメソッド	： GET
	 * URL			： /search
	 * @return 従業員検索画面（retrieve-input.html）
	 */
	@GetMapping("/search")
	public String search(Model model) {

		// フォームオブジェクトをModelに登録
		model.addAttribute("employeeIdForm", new EmployeeIdForm());

		// 次画面名（retrieve-input.html）を返却する
		return "retrieve-input";
	}

	/**
	 * 従業員IDをもとに従業員を検索し、従業員検索結果画面を表示する
	 * 
	 * HTTPメソッド	： GET
	 * URL			： /retrieveEmployee
	 * @return 従業員検索結果画面（retrieve-employee.html）
	 */
	@GetMapping("/retrieveEmployee")
	public String retrieveEmployee(	@Validated EmployeeIdForm employeeIdForm,
									BindingResult result,
									Model model) {

		// フォームオブジェクトの入力チェック
		if (result.hasErrors()) {
			// 次画面名（retrieve-input.html）を返却する
			return "retrieve-input";
		}

		// フォームオブジェクトから従業員IDを取得
		Integer employeeId = employeeIdForm.getEmployeeId();

		// Employeeオブジェクトの検索
		EmployeeDto employeeDto = searchEmpService.getEmployee(employeeId);

		// Modelに情報を設定
		model.addAttribute("employee", employeeDto);

		// 次画面名（retrieve-employee.html）を返却する
		return "retrieve-employee";
	}

	/**
	 * 業務例外のハンドリング
	 * ハンドリングする例外クラス： BusinessException.class
	 */
	@ExceptionHandler(BusinessException.class)
	public String catchBizException(Model model, Exception e) {

		// エラーメッセージをModelに設定
		model.addAttribute("message", e.getMessage());

		// フォームオブジェクトをModelに登録
		model.addAttribute("employeeIdForm", new EmployeeIdForm());

		// 次画面名（retrieve-input.html）を返却する
		return "retrieve-input";
	}

}
