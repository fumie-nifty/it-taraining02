package jp.co.flm.domain.domaCodeGen.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class ProductListener implements EntityListener<Product> {

    @Override
    public void preInsert(Product entity, PreInsertContext<Product> context) {
    }

    @Override
    public void preUpdate(Product entity, PreUpdateContext<Product> context) {
    }

    @Override
    public void preDelete(Product entity, PreDeleteContext<Product> context) {
    }

    @Override
    public void postInsert(Product entity, PostInsertContext<Product> context) {
    }

    @Override
    public void postUpdate(Product entity, PostUpdateContext<Product> context) {
    }

    @Override
    public void postDelete(Product entity, PostDeleteContext<Product> context) {
    }
}
