package jp.co.flm.domain.domaCodeGen.entity;

import java.math.BigDecimal;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Metamodel;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

/**
 * 
 */
@Entity(listener = ProductListener.class, metamodel = @Metamodel)
@Table(name = "product")
public class Product extends AbstractProduct {

    /**  */
    @Id
    @Column(name = "product_id")
    String productId;

    /**  */
    @Column(name = "category_id")
    String categoryId;

    /**  */
    @Column(name = "product_name")
    String productName;

    /**  */
    @Column(name = "price")
    BigDecimal price;

    /**  */
    @Column(name = "picture")
    String picture;

    /**  */
    @Column(name = "point")
    Integer point;

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
     * Returns the categoryId.
     * 
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /** 
     * Sets the categoryId.
     * 
     * @param categoryId the categoryId
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /** 
     * Returns the productName.
     * 
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /** 
     * Sets the productName.
     * 
     * @param productName the productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /** 
     * Returns the price.
     * 
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /** 
     * Sets the price.
     * 
     * @param price the price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /** 
     * Returns the picture.
     * 
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /** 
     * Sets the picture.
     * 
     * @param picture the picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /** 
     * Returns the point.
     * 
     * @return the point
     */
    public Integer getPoint() {
        return point;
    }

    /** 
     * Sets the point.
     * 
     * @param point the point
     */
    public void setPoint(Integer point) {
        this.point = point;
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
