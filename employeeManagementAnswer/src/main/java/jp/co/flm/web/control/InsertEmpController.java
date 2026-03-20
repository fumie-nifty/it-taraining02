package jp.co.flm.web.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jp.co.flm.common.exception.BusinessException;
import jp.co.flm.domain.dto.EmployeeDto;
import jp.co.flm.domain.service.InsertEmpService;
import jp.co.flm.web.form.EmployeeForm;

/**
 * 従業員登録Controller
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
@SessionAttributes(names = "employeeDto")
@Controller
public class InsertEmpController {

	/** Service */
	InsertEmpService insertEmpService;

	/** コンストラクタインジェクション */
	public InsertEmpController(InsertEmpService insertEmpService) {
		this.insertEmpService = insertEmpService;
	}

	/**
	 * 従業員登録画面を表示する
	 * 
	 * HTTPメソッド	： GET
	 * URL			： /inputInsert
	 * @return 従業員登録画面（insert-input.html）
	 */
	@GetMapping("/inputInsert")
	public String inputInsert(Model model) {

		//1.EmployeeFormを生成し、modelにキー名「employeeForm」で格納する。
		model.addAttribute("employeeForm", new EmployeeForm());
		
		//2.insert-input.htmlに遷移する。
		return "insert-input";
	}

	/**
	 * 従業員の登録情報を受け取り、セッションに格納し、
	 * 従業員登録確認画面を表示する
	 * 
	 * HTTPメソッド	： POST
	 * URL			： /confirmInsert
	 * @return 従業員登録確認（insert-confirm.html）
	 */
	@PostMapping("/confirmInsert")
	public String confirmInsert(
			@Validated EmployeeForm employeeForm,
			BindingResult result,
			Model model) {
		
		// リクエストパラメーターの入力チェック
		if (result.hasErrors()) {
			return "insert-input";
		}

		//1.受け取ったEmployeeFormの情報をもとにEmployeeDtoオブジェクトを生成する。
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmployeeId(employeeForm.getEmployeeId());
		employeeDto.setEmployeeName(employeeForm.getEmployeeName());
		employeeDto.setSection(employeeForm.getSection());
		employeeDto.setPhone(employeeForm.getPhone());
		employeeDto.setVersion(1);
		
		// 実習問題7 ③
		insertEmpService.confirmEmployee(employeeDto);
		
		//2.EmployeeDtoオブジェクトを、キー名「employeeDto」でmodelに格納する。
		//  vserionには「１」を格納してください。
		model.addAttribute("employeeDto", employeeDto);
		
		//3.insert-confirm.htmlに遷移する。
		return "insert-confirm";
	}

	/**
	 * セッションの従業員情報をもとにデータベースに従業員情報を追加し、
	 * 従業員登録結果画面を表示する
	 * 
	 * HTTPメソッド	： POST
	 * URL			： /commitInsert
	 * @return 従業員登録結果画面（insert-complete.html）
	 */
	@PostMapping("/commitInsert")
	public String commitInsert(
			EmployeeDto employeeDto,
			Model model,
			SessionStatus status) {

		// セッションタイムアウト時
		if (employeeDto == null || employeeDto.getEmployeeId() == null) {
			model.addAttribute("message", "セッションの有効期限が切れました。");
			return "system-error";
		}

		// Serviceの呼び出し
		insertEmpService.registEmployee(employeeDto);

		// セッションからオブジェクトの削除
		status.setComplete();

		//3.insert-confirm.htmlに遷移する。
		return "insert-complete";
	}

	/**
	 * セッションの従業員情報をフォームにセットし、
	 * 従業員登録画面へ戻る
	 * 
	 * HTTPメソッド	： POST
	 * URL			： /reviseInput
	 * @return 従業員登録画面（insert-input.html）
	 */
	@PostMapping("/reviseInput")
	public String reviseInput(
			EmployeeDto employeeDto,
			Model model) {

		// セッションタイムアウト時
		if (employeeDto == null || employeeDto.getEmployeeId() == null) {
			model.addAttribute("message", "セッションの有効期限が切れました。");
			return "system-error";
		}

		//1.引数で受け取ったemployeeDtoの情報（セッション）をもとにEmployeeFormオブジェクトを生成する。
		EmployeeForm employeeForm = new EmployeeForm();
		employeeForm.setEmployeeId(employeeDto.getEmployeeId());
		employeeForm.setEmployeeName(employeeDto.getEmployeeName());
		employeeForm.setSection(employeeDto.getSection());
		employeeForm.setPhone(employeeDto.getPhone());

		//2.生成したEmployeeForm をmodelに格納する。
		model.addAttribute("employeeForm", employeeForm);

		//3.insert-input.htmlに遷移する。
		return "insert-input";
	}

	/**
	 * 業務例外のハンドリング
	 * ハンドリングする例外クラス： BusinessException.class
	 */
	@ExceptionHandler(BusinessException.class)
	public String catchBizException(Model model, Exception e) {

		// エラーメッセージをModelに設定
		model.addAttribute("message", e.getMessage());

		// 空のフォームオブジェクトをModelに登録
		model.addAttribute("employeeForm", new EmployeeForm());

		// 次画面名（insert-input.html）を返却する
		return "insert-input";
	}

}
