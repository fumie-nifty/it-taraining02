/**
 * EmployeeDaoSelectByIdTest.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.domain.dao;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.jdbc.Sql;

import jp.co.flm.domain.entity.Employee;

/**
 * EmployeeDao.selectById(Integer employeeId)：Employee に対するテストクラス
 *   UT1-101-001 検索に成功する場合（存在する従業員ID）
 *   UT1-101-002 検索に失敗する場合（存在しない従業員ID）
 *   UT1-101-003 DataAccessException（テーブルが存在しない）
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
@SpringBootTest
@Sql(scripts = "/sql/test/testDataInit.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
@Sql(scripts = "/sql/test/testDataInit.sql",
		executionPhase = Sql.ExecutionPhase.AFTER_TEST_CLASS)
@DisplayName("UT1-101: EmployeeDao.selectById()のテスト")
public class EmployeeDaoSelectByIdTest {

    @Autowired
    EmployeeDao employeeDao;

    /**
     * UT1-101-001 検索に成功する場合（存在する従業員ID）
     *
     * 存在する従業員IDを指定した場合、従業員IDに一致するレコードが1件取得され、
     * DBの値がEmployeeエンティティに正しく格納されることを確認する。
     */
    @Test
    @Sql(scripts = "/sql/test/testData01.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @DisplayName("UT1-101-001 検索に成功する場合（存在する従業員ID）")
    void testSelectById001() {

        // テストデータの準備
        // 入力値
        Integer employeeId = 922102;

        // 期待値
        Employee expected = expectedData2();

        // テスト対象の実行
        Employee actual = employeeDao.selectById(employeeId);

        // 検証
        // nullでないことを確認
        assertThat(actual).isNotNull();

        // 期待値と等しいことを確認
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    /**
     * UT1-101-002 検索に失敗する場合（存在しない従業員ID）
     *
     * 存在しない従業員IDを指定した場合、レコードは取得されず、
     * Employeeエンティティはnullが返却されることを確認する。
     */
    @Test
    @Sql(scripts = "/sql/test/testData01.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @DisplayName("UT1-101-002 検索に失敗する場合（存在しない従業員ID）")
    void testSelectById002() {

        // テストデータの準備
        // 入力値
        Integer employeeId = 999999;

        // テスト対象の実行
        Employee actual = employeeDao.selectById(employeeId);

        // 検証
        // nullであることを確認
        assertThat(actual).isNull();
    }

    /**
     * UT1-101-003 DataAccessException（テーブルが存在しない）
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
    @DisplayName("UT1-101-003 DataAccessException（テーブルが存在しない）")
    void testSelectById003() {

        // テストデータの準備
        // 入力値
        Integer employeeId = 2;

        // 検証
        assertThatThrownBy(() -> {
            // テスト対象の実行
        	employeeDao.selectById(employeeId);
        })
        .isInstanceOf(DataAccessException.class);
    }

    /**
     * 従業員ID「922102」の従業員オブジェクトを返す
     * @return Employee 従業員オブジェクト
     */
    private static Employee expectedData2() {

    	Employee expected = new Employee();
    	expected.setEmployeeId(922102);
    	expected.setEmployeeName("田村　正人");
    	expected.setSection("研修部");
    	expected.setPhone("7700-2258");
    	expected.setVersion(1);
     	
        return expected;
    }
}
