package com.revature.caliber.services;

import java.util.List;
import io.swagger.annotations.ApiModel;

import com.revature.caliber.beans.SkillType;

/**
 * Defines available methods for the SkillType service interface
 * 
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 */
@ApiModel(value = "SkillTypeService", description = "Provides interface for SkillType service layer")
public interface SkillTypeService {

	/**
	 * Method that returns all SkillTypes
	 * @return list of skillType objects
	 */
	public List<SkillType> getSkills();
	
	/**
	 * Method that returns all active SkillTypes
	 * @return list of SkillType objects
	 */
	public List<SkillType> getActiveSkills(boolean b);
	
	/**
	 * Method that returns a specific SkillType
	 * @param id the primary key of the SkillType
	 * @return an individual skillType
	 */
	public SkillType getSkill(Integer id);
	
	/**
	 * Creates a new skillType
	 * @param s transient skillType
	 * @return detached skillType
	 */
	public SkillType createSkill(SkillType s);
	
	/**
	 * Updates a skill's title
	 * @param s existing skill object w/ updated title
	 */
	public void updateSkill(SkillType s);
	
	/**
	 * Removes skill with specified Id
	 * @param id primary key of skill to review
	 */
	public void deleteSkill(Integer id);

}