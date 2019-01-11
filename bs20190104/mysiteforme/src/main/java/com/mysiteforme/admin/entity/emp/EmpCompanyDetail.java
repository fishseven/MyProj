package com.mysiteforme.admin.entity.emp;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 企业明细
 * </p>
 *
 * @author root
 * @since 2019-01-05
 */
@TableName("emp_company_detail")
public class EmpCompanyDetail extends DataEntity<EmpCompanyDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 企业明细
     */
	@TableField("company_name")
	private String companyName;
    /**
     * 企业地址
     */
	@TableField("company_addr")
	private String companyAddr;
    /**
     * 企业电话
     */
	@TableField("company_phone")
	private String companyPhone;
    /**
     * 类型 
     */
	@TableField("company_type")
	private String companyType;
    /**
     * 备注
     */
	@TableField("company_remark")
	private String companyRemark;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddr() {
		return companyAddr;
	}

	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getCompanyRemark() {
		return companyRemark;
	}

	public void setCompanyRemark(String companyRemark) {
		this.companyRemark = companyRemark;
	}


	@Override
	public String toString() {
		return "EmpCompanyDetail{" +
			", companyName=" + companyName +
			", companyAddr=" + companyAddr +
			", companyPhone=" + companyPhone +
			", companyType=" + companyType +
			", companyRemark=" + companyRemark +
			"}";
	}
}
