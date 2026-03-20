/**
 * EmployeeDaoSelectAllTest.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.domain.dao;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.jdbc.Sql;

import jp.co.flm.domain.entity.Employee;

/**
 * EmployeeDao.selectAll()：List<Employee> に対するテストクラス
 *   UT1-102-001 従業員リストの検索に成功する場合（従業員情報が存在する）
 *   UT1-102-002 従業員リストの検索に失敗する場合（従業員情報が存在しない）
 *   UT1-102-003 DataAccessException（テーブル未存在）
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
@SpringBootTest
@Sql(scripts = "/sql/test/testDataInit.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
@Sql(scripts = "/sql/test/testDataInit.sql",
		executionPhase = Sql.ExecutionPhase.AFTER_TEST_CLASS)
@DisplayName("UT1-102: EmployeeDao.selectAll()のテスト")
public class EmployeeDaoSelectAllTest {

    @Autowired
    EmployeeDao employeeDao;

    /**
     * UT1-102-001 従業員リストの検索に成功する場合（従業員情報が存在する）
     *
     * employeeテーブルの全件が取得され、DBの値がEmployeeエンティティに
     * 正しく格納されることを確認する。
     */
    @Test
    @Sql(scripts = "/sql/test/testData01.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @DisplayName("UT1-102-001 従業員リストの検索に成功する場合（従業員情報が存在する）")
    void testSelectAll001() {

        // 期待値
        List<Employee> expected = expectedData();

        // テスト対象の実行
        List<Employee> actual = employeeDao.selectAll();

        // 検証
        // nullでないことを確認
        assertThat(actual).isNotNull();

        // 期待値と等しいことを確認
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    /**
     * UT1-102-002 従業員リストの検索に失敗する場合（従業員情報が存在しない）
     *
     * employeeテーブルにレコードが存在しない場合、
     * 検索結果は0件となり、空のリストが返却されることを確認する。
     */
    @Test
    @Sql(scripts = "/sql/test/testData02.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @DisplayName("UT1-102-002 従業員リストの検索に失敗する場合（従業員情報が存在しない）")
    void testSelectAll002() {

        // テスト対象の実行
        List<Employee> actual = employeeDao.selectAll();

        // 検証
        // 検索結果が0件であることを確認
        assertThat(actual).isEmpty();
    }

    /**
     * UT1-102-003 DataAccessException（テーブル未存在）
     *
	 * 【補足テスト（標準対象外）】
	 * 本テストはDAO単体テストの責務として必須なものではありません。
	 * テーブル未存在時の例外処理はDoma/Spring Framework側で実装済みのため、
	 * 通常のDAO単体テストでは検証対象外とします。
	 * 本テストは、テーブルが存在しない状態でSQLを実行した場合に、DataAccessExceptionが
	 * 発生することを確認するための【挙動確認用の補足テスト】です。
     */
    @Test
    @Sql(scripts = "/sql/test/testData03.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/sql/test/testDataInit.sql",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @DisplayName("UT1-102-003 DataAccessException（テーブル未存在）")
    void testSelectAll003() {

        // 検証
        assertThatThrownBy(() -> {
            // テスト対象の実行
        	employeeDao.selectAll();
        })
        .isInstanceOf(DataAccessException.class);
    }

    /**
     * 従業員オブジェクトのリストを返す
     * @return Employee 従業員オブジェクト
     */
    private static List<Employee> expectedData() {

    	Employee employee = null;
    	
    	List<Employee> expected = new ArrayList<>();
    	
    	employee = new Employee();
    	employee.setEmployeeId(922101);
    	employee.setEmployeeName("鈴木　一郎");
    	employee.setSection("研修部");
    	employee.setPhone("7700-2257");
    	employee.setVersion(1);
    	expected.add(employee);

    	employee = new Employee();
    	employee.setEmployeeId(922102);
    	employee.setEmployeeName("田村　正人");
    	employee.setSection("研修部");
    	employee.setPhone("7700-2258");
    	employee.setVersion(1);
    	expected.add(employee);

    	employee = new Employee();
    	employee.setEmployeeId(922103);
    	employee.setEmployeeName("松田　明美");
    	employee.setSection("開発部");
    	employee.setPhone("7712-4418");
    	employee.setVersion(1);
    	expected.add(employee);

    	employee = new Employee();
    	employee.setEmployeeId(922104);
    	employee.setEmployeeName("浅井　順二");
    	employee.setSection("開発部");
    	employee.setPhone("7712-4416");
    	employee.setVersion(1);
    	expected.add(employee);

    	employee = new Employee();
    	employee.setEmployeeId(922105);
    	employee.setEmployeeName("高橋　道夫");
    	employee.setSection("営業部");
    	employee.setPhone("7712-3316");
    	employee.setVersion(1);
    	expected.add(employee);

    	employee = new Employee();
    	employee.setEmployeeId(922106);
    	employee.setEmployeeName("夏木　裕子");
    	employee.setSection("営業部");
    	employee.setPhone("7712-3317");
    	employee.setVersion(1);
    	expected.add(employee);

        return expected;
    }
}
