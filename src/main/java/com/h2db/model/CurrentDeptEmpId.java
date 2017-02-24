package com.h2db.model;
// Generated Feb 24, 2017 9:36:16 AM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CurrentDeptEmpId generated by hbm2java
 */
@Embeddable
public class CurrentDeptEmpId implements java.io.Serializable {

	private String deptNo;
	private int empNo;
	private Date fromDate;
	private Date toDate;

	public CurrentDeptEmpId() {
	}

	public CurrentDeptEmpId(String deptNo, int empNo, Date fromDate, Date toDate) {
		this.deptNo = deptNo;
		this.empNo = empNo;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	@Column(name = "DEPT_NO", nullable = false, length = 4)
	public String getDeptNo() {
		return this.deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	@Column(name = "EMP_NO", nullable = false)
	public int getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	@Column(name = "FROM_DATE", nullable = false, length = 23)
	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@Column(name = "TO_DATE", nullable = false, length = 23)
	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CurrentDeptEmpId))
			return false;
		CurrentDeptEmpId castOther = (CurrentDeptEmpId) other;

		return ((this.getDeptNo() == castOther.getDeptNo()) || (this.getDeptNo() != null
				&& castOther.getDeptNo() != null && this.getDeptNo().equals(castOther.getDeptNo())))
				&& (this.getEmpNo() == castOther.getEmpNo())
				&& ((this.getFromDate() == castOther.getFromDate()) || (this.getFromDate() != null
						&& castOther.getFromDate() != null && this.getFromDate().equals(castOther.getFromDate())))
				&& ((this.getToDate() == castOther.getToDate()) || (this.getToDate() != null
						&& castOther.getToDate() != null && this.getToDate().equals(castOther.getToDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDeptNo() == null ? 0 : this.getDeptNo().hashCode());
		result = 37 * result + this.getEmpNo();
		result = 37 * result + (getFromDate() == null ? 0 : this.getFromDate().hashCode());
		result = 37 * result + (getToDate() == null ? 0 : this.getToDate().hashCode());
		return result;
	}

}
