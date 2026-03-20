package jp.co.flm.domain.domaCodeGen.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Metamodel;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

/**
 * 
 */
@Entity(listener = StockListener.class, metamodel = @Metamodel)
@Table(name = "stock")
public class Stock extends AbstractStock {

    /**  */
    @Id
    @Column(name = "product_id")
    String productId;

    /**  */
    @Column(name = "quantity")
    Integer quantity;

    /**  */
    @Version
    @Column(name = "version")
    Integer version;

    /** 
     * Returns the productId.
     * 
     * @return the productId
     */
    public String getProductId() {
        return productId;
    }

    /** 
     * Sets the productId.
     * 
     * @param productId the productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /** 
     * Returns the quantity.
     * 
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /** 
     * Sets the quantity.
     * 
     * @param quantity the quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /** 
     * Returns the version.
     * 
     * @return the version
     */
    public Integer getVersion() {
        return version;
    }

    /** 
     * Sets the version.
     * 
     * @param version the version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}
