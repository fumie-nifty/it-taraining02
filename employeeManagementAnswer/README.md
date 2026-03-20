# DomaEmployeeManagementAnswer
Springハンズオン解答 Spring + Doma

Eclipseプロジェクト名：employeeManagementAnswer

## version 3.0.0 変更内容

1. MyBatisからDoma3.5.0へ移行  
   永続化フレームワークをMyBatisからDoma3.5.0へ変更

2. EntityとDTOの分離  
   EntityとDTOを分離し、責務を明確化

3. 単体テストの見直し  
   ・DbUnitの使用を廃止  
   ・DomaはEntity単位でSQLが自動生成されるため、更新結果テーブル全体の検証は対象外とした

4. エラーページの整理  
   ・error.htmlをsystem-error.htmlへ変更  
   ・Spring内部エラーとアプリ側でハンドリングするエラーを区別しやすくした

5. HTTPステータスコードの制御について  
   ・画面遷移型MVCアプリを前提とするため、業務例外にHTTPステータス制御は行わない  
   ・REST APIを実装する場合は、HTTP仕様に従ったステータス制御を行う

6. テンプレートの簡素化  
   ・入力チェック表示のth:if削除  
   ・不要なth:block削除（trを直接繰り返す構造に変更）

