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
@Entity(listener = MemberListener.class, metamodel = @Metamodel)
@Table(name = "member")
public class Member extends AbstractMember {

    /**  */
    @Id
    @Column(name = "member_id")
    String memberId;

    /**  */
    @Column(name = "password")
    String password;

    /**  */
    @Column(name = "member_name")
    String memberName;

    /**  */
    @Column(name = "gender")
    String gender;

    /**  */
    @Column(name = "address")
    String address;

    /**  */
    @Column(name = "phone")
    String phone;

    /**  */
    @Column(name = "member_point")
    Integer memberPoint;

    /**  */
    @Version
    @Column(name = "version")
    Integer version;

    /** 
     * Returns the memberId.
     * 
     * @return the memberId
     */
    public String getMemberId() {
        return memberId;
    }

    /** 
     * Sets the memberId.
     * 
     * @param memberId the memberId
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /** 
     * Returns the password.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /** 
     * Sets the password.
     * 
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** 
     * Returns the memberName.
     * 
     * @return the memberName
     */
    public String getMemberName() {
        return memberName;
    }

    /** 
     * Sets the memberName.
     * 
     * @param memberName the memberName
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /** 
     * Returns the gender.
     * 
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /** 
     * Sets the gender.
     * 
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /** 
     * Returns the address.
     * 
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /** 
     * Sets the address.
     * 
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
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
     * Returns the memberPoint.
     * 
     * @return the memberPoint
     */
    public Integer getMemberPoint() {
        return memberPoint;
    }

    /** 
     * Sets the memberPoint.
     * 
     * @param memberPoint the memberPoint
     */
    public void setMemberPoint(Integer memberPoint) {
        this.memberPoint = memberPoint;
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
