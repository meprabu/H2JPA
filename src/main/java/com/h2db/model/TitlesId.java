package com.h2db.model;
// Generated Feb 24, 2017 9:36:16 AM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TitlesId generated by hbm2java
 */
@Embeddable
public class TitlesId implements java.io.Serializable {

	private int empNo;
	private Date fromDate;
	private String title;

	public TitlesId() {
	}

	public TitlesId(int empNo, Date fromDate, String title) {
		this.empNo = empNo;
		this.fromDate = fromDate;
		this.title = title;
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

	@Column(name = "TITLE", nullable = false, length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TitlesId))
			return false;
		TitlesId castOther = (TitlesId) other;

		return (this.getEmpNo() == castOther.getEmpNo())
				&& ((this.getFromDate() == castOther.getFromDate()) || (this.getFromDate() != null
						&& castOther.getFromDate() != null && this.getFromDate().equals(castOther.getFromDate())))
				&& ((this.getTitle() == castOther.getTitle()) || (this.getTitle() != null
						&& castOther.getTitle() != null && this.getTitle().equals(castOther.getTitle())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getEmpNo();
		result = 37 * result + (getFromDate() == null ? 0 : this.getFromDate().hashCode());
		result = 37 * result + (getTitle() == null ? 0 : this.getTitle().hashCode());
		return result;
	}

}
