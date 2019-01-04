package com.mysiteforme.admin.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * qs
 * </p>
 *
 * @author wangl
 * @since 2018-12-22
 */
public class Aasq extends DataEntity<Aasq> {

    private static final long serialVersionUID = 1L;

    /**
     * qq
     */
	private String qqq;

	public String getQqq() {
		return qqq;
	}

	public void setQqq(String qqq) {
		this.qqq = qqq;
	}


	@Override
	public String toString() {
		return "Aasq{" +
			", qqq=" + qqq +
			"}";
	}
}
