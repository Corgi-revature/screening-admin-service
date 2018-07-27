package com.revature.caliber.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Outlines the SkillType POJO
 * 
 * @author Isaac Pawling | 1085-WVU | Richard Orr
 * 
 */
@ApiModel(value = "SkillType", description = "Type of skill that is associated with a number of categories")
@Entity
@Table(name = "SKILL_TYPE")
public class SkillType implements Serializable {

	private static final long serialVersionUID = -6863562903787298483L;
	
	@ApiModelProperty(value = "Skill type id")
	@Id
	@SequenceGenerator(name = "skillSeq", sequenceName = "SKILL_TYPE_SEQUENCE", allocationSize=1)
	@GeneratedValue(generator = "skillSeq", strategy = GenerationType.SEQUENCE)
	@Column(name = "SKILL_TYPE_ID")
	private int skillTypeId;
	
	@ApiModelProperty(value = "Name of the skill")
	@Column(name = "TITLE")
	private String title;
	
    @ApiModelProperty(value = "is the category currently active")
    @Column(name = "is_active")
    private boolean isActive;
	
	
	public SkillType() {
		super();
	}

	public SkillType(int skillTypeId, String title, boolean isActive) {
		super();
		this.skillTypeId = skillTypeId;
		this.title = title;
		this.isActive = isActive;
	}

	public int getSkillTypeId() {
		return skillTypeId;
	}

	public void setSkillTypeId(int skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + skillTypeId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkillType other = (SkillType) obj;
		if (isActive != other.isActive)
			return false;
		if (skillTypeId != other.skillTypeId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SkillType [skillTypeId=" + skillTypeId + ", title=" + title + ", isActive=" + isActive + "]";
	}
	
}
