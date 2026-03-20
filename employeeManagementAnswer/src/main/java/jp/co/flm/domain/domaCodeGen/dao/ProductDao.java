package jp.co.flm.domain.domaCodeGen.dao;

import jp.co.flm.domain.domaCodeGen.entity.Product;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
public interface ProductDao {

    /**
     * @param productId
     * @return the Product entity
     */
    @Select
    Product selectById(String productId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Product entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Product entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Product entity);
}
