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
@Entity(listener = CategoryListener.class, metamodel = @Metamodel)
@Table(name = "category")
public class Category extends AbstractCategory {

    /**  */
    @Id
    @Column(name = "category_id")
    String categoryId;

    /**  */
    @Column(name = "category_name")
    String categoryName;

    /**  */
    @Column(name = "picture")
    String picture;

    /**  */
    @Version
    @Column(name = "version")
    Integer version;

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
     * Returns the categoryName.
     * 
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /** 
     * Sets the categoryName.
     * 
     * @param categoryName the categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
