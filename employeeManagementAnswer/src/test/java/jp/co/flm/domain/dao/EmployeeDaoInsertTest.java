/**
 * EmployeeDaoInsertTest.java
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
 * EmployeeDao.insert()：Employee に対するテストクラス
 *   UT1-103-001 従業員情報の登録が成功する場合
 *   UT1-103-002 DataAccessException（テーブル未存在）
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
@SpringBootTest
@Sql(scripts = "/sql/test/testDataInit.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
@Sql(scripts = "/sql/test/testDataInit.sql",
		executionPhase = Sql.ExecutionPhase.AFTER_TEST_CLASS)
@DisplayName("UT1-103: EmployeeDao.insert()のテスト")
public class EmployeeDaoInsertTest {

    @Autowired
    EmployeeDao employeeDao;

    /**
     * UT1-103-001 従業員情報の登録が成功する場合
     *
     * 引数で渡されたEntityが、employeeテーブルに従業員情報が1件追加され、
     * 更新件数として1が返却されることを確認する。
     */
    @Test
    @Sql(scripts = "/sql/test/testData01.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @DisplayName("UT1-103-001 従業員情報の登録が成功する場合")
    void testInsert001() {

        // 入力値
        Employee param = inputData();

        // テスト対象の実行
        int actual = employeeDao.insert(param);

        // 検証
        // 更新件数が1であることを確認
        assertThat(actual).isEqualTo(1);

    }

    /**
     * UT1-103-002 DataAccessException（テーブル未存在）
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
    @DisplayName("UT1-103-002 DataAccessException（テーブル未存在）")
    void testInsert002() {

        // 入力値
        Employee param = inputData();

        // 検証
        assertThatThrownBy(() -> {
            // テスト対象の実行
        	employeeDao.insert(param);
        })
        .isInstanceOf(DataAccessException.class);
    }

    /**
     * 従業員ID「922109」の従業員オブジェクトを返す
     * @return Employee 従業員オブジェクト
     */
    private static Employee inputData() {

    	Employee expected = new Employee();
    	expected.setEmployeeId(922109);
    	expected.setEmployeeName("富士通　花子");
    	expected.setSection("開発部");
    	expected.setPhone("7700-9999");
     	
        return expected;
    }
}
