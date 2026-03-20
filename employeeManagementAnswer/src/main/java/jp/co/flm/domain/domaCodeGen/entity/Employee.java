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
@Entity(listener = EmployeeListener.class, metamodel = @Metamodel)
@Table(name = "employee")
public class Employee extends AbstractEmployee {

    /**  */
    @Id
    @Column(name = "employee_id")
    Integer employeeId;

    /**  */
    @Column(name = "employee_name")
    String employeeName;

    /**  */
    @Column(name = "section")
    String section;

    /**  */
    @Column(name = "phone")
    String phone;

    /**  */
    @Version
    @Column(name = "version")
    Integer version;

    /** 
     * Returns the employeeId.
     * 
     * @return the employeeId
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /** 
     * Sets the employeeId.
     * 
     * @param employeeId the employeeId
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /** 
     * Returns the employeeName.
     * 
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /** 
     * Sets the employeeName.
     * 
     * @param employeeName the employeeName
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /** 
     * Returns the section.
     * 
     * @return the section
     */
    public String getSection() {
        return section;
    }

    /** 
     * Sets the section.
     * 
     * @param section the section
     */
    public void setSection(String section) {
        this.section = section;
    }

    /** 
     * Returns the phone.
     * 
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /** 
     * Sets the phone.
     * 
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
