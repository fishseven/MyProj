package com.mysiteforme.admin.entity.emp;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 职位明细
 * </p>
 *
 * @author root
 * @since 2019-01-05
 */
@TableName("emp_pos_detail")
public class EmpPosDetail extends DataEntity<EmpPosDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 职位编号
     */
	@TableField("pos_id")
	private Long posId;
    /**
     * 职位名称
     */
	@TableField("pos_name")
	private String posName;
    /**
     * 公司编号
     */
	@TableField("pos_comp_id")
	private Long posCompId;
    /**
     * 公司名称
     */
	@TableField("pos_comp_name")
	private String posCompName;
	@TableField("pos_remark")
	private String posRemark;
	@TableField("pos_reamark_2")
	private String posReamark2;
    /**
     * 类型
     */
	@TableField("pos_type")
	private String posType;
    /**
     * 人数
     */
	@TableField("pos_req_num")
	private Integer posReqNum;
	@TableField("pos_price")
	private String posPrice;
    /**
     * 联系人名称
     */
	@TableField("pos_contact_per")
	private String posContactPer;
    /**
     * 联系人电话
     */
	@TableField("pos_contact_pho")
	private String posContactPho;

	public Long getPosId() {
		return posId;
	}

	public void setPosId(Long posId) {
		this.posId = posId;
	}
	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}
	public Long getPosCompId() {
		return posCompId;
	}

	public void setPosCompId(Long posCompId) {
		this.posCompId = posCompId;
	}
	public String getPosCompName() {
		return posCompName;
	}

	public void setPosCompName(String posCompName) {
		this.posCompName = posCompName;
	}
	public String getPosRemark() {
		return posRemark;
	}

	public void setPosRemark(String posRemark) {
		this.posRemark = posRemark;
	}
	public String getPosReamark2() {
		return posReamark2;
	}

	public void setPosReamark2(String posReamark2) {
		this.posReamark2 = posReamark2;
	}
	public String getPosType() {
		return posType;
	}

	public void setPosType(String posType) {
		this.posType = posType;
	}
	public Integer getPosReqNum() {
		return posReqNum;
	}

	public void setPosReqNum(Integer posReqNum) {
		this.posReqNum = posReqNum;
	}
	public String getPosPrice() {
		return posPrice;
	}

	public void setPosPrice(String posPrice) {
		this.posPrice = posPrice;
	}
	public String getPosContactPer() {
		return posContactPer;
	}

	public void setPosContactPer(String posContactPer) {
		this.posContactPer = posContactPer;
	}
	public String getPosContactPho() {
		return posContactPho;
	}

	public void setPosContactPho(String posContactPho) {
		this.posContactPho = posContactPho;
	}


	@Override
	public String toString() {
		return "EmpPosDetail{" +
			", posId=" + posId +
			", posName=" + posName +
			", posCompId=" + posCompId +
			", posCompName=" + posCompName +
			", posRemark=" + posRemark +
			", posReamark2=" + posReamark2 +
			", posType=" + posType +
			", posReqNum=" + posReqNum +
			", posPrice=" + posPrice +
			", posContactPer=" + posContactPer +
			", posContactPho=" + posContactPho +
			"}";
	}
}
