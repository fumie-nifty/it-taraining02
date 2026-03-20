package jp.co.flm.domain.domaCodeGen.dao;

import jp.co.flm.domain.domaCodeGen.entity.Stock;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
public interface StockDao {

    /**
     * @param productId
     * @return the Stock entity
     */
    @Select
    Stock selectById(String productId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Stock entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Stock entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Stock entity);
}
