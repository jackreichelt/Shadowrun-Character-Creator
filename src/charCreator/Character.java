package charCreator;

import java.util.*;

/**
 * A class to store all the information of a character.
 * 
 * @author jackreichelt
 */
public class Character {
	
	
	// declaration of private variables
	// Character name
	private String name;
	// Metatype of the character (Human, Elf, etc). Subtypes to be implemented.
	private metatype metaType;
	// Total build points and points remaining.
	private int totalBP;
	private int BP;
	private int attribBP;
	// Attributes
	private int body;
	private int agility;
	private int reaction;
	private int strength;
	private int charisma;
	private int intuition;
	private int logic;
	private int willpower;
	private int initiative;
	private int initPasses;
	private int edge;
	private int essence;
	private int magic;
	private int resonance;
	private Set<Quality> qualities;
	private Map<ActiveSkill, Integer> activeSkills;
	private Map<KnowledgeSkill, Integer> knowledgeSkills;
	
	public Character(int BP) {
		name = "";
		totalBP = BP;
		this.BP = BP;
		attribBP = BP/2;
		
		body = 1;
		agility = 1;
		reaction = 1;
		strength = 1;
		charisma = 1;
		intuition = 1;
		logic = 1;
		willpower = 1;
		initiative = 1;
		initPasses = 1;
		edge = 1;
		essence = 6;
		magic = 0;
		resonance = 0;
		
		qualities = new HashSet<Quality>();
		activeSkills = new HashMap<ActiveSkill, Integer>();
		knowledgeSkills = new HashMap<KnowledgeSkill, Integer>();
	}
	
	/**
	 * change the metatype of the character
	 * @param type the metatype to change to.
	 */
	public void setMeta(metatype type) {
		
		if (metaType.equals(null)) {
			
			BP -= type.getCost();
			body = type.getAttribMin(Attribute.BOD);
			agility = type.getAttribMin(Attribute.AGI);
			reaction = type.getAttribMin(Attribute.REA);
			strength = type.getAttribMin(Attribute.STR);
			charisma = type.getAttribMin(Attribute.CHA);
			intuition = type.getAttribMin(Attribute.INT);
			logic = type.getAttribMin(Attribute.LOG);
			willpower = type.getAttribMin(Attribute.WIL);
			redoInit();
			
			metaType = type;
			
		} else {
			
			BP -= type.getCost() + metaType.getCost();
			
			body += type.getAttribMin(Attribute.BOD) - metaType.getAttribMin(Attribute.BOD);
			agility += type.getAttribMin(Attribute.AGI) - metaType.getAttribMin(Attribute.AGI);
			reaction += type.getAttribMin(Attribute.REA) - metaType.getAttribMin(Attribute.REA);
			strength += type.getAttribMin(Attribute.STR) - metaType.getAttribMin(Attribute.STR);
			charisma += type.getAttribMin(Attribute.CHA) - metaType.getAttribMin(Attribute.CHA);
			intuition += type.getAttribMin(Attribute.INT) - metaType.getAttribMin(Attribute.INT);
			logic += type.getAttribMin(Attribute.LOG) - metaType.getAttribMin(Attribute.LOG);
			willpower += type.getAttribMin(Attribute.WIL) - metaType.getAttribMin(Attribute.WIL);
			redoInit();
			
			metaType = type;
		}
	}
	
	/**
	 * recalculate the initiative of the char.
	 */
	private void redoInit() {
		initiative = reaction + intuition;
	}
	
	/**
	 * Sets a characters attributes
	 * @param attrib the attribute to change
	 * @param value what the attribute is now
	 * @throws Exception if the value is outside the min or max values
	 */
	public void setAttrib(Attribute attrib, int value) throws Exception {
		
		if (value < metaType.getAttribMin(attrib) || value > metaType.getAttribMax(attrib)) {
			throw (new Exception ("Invalid parameters"));
		}
		
		switch (attrib) {
		case BOD:
			BP += (body - metaType.getAttribMin(attrib))*10;
			if (body == metaType.getAttribMax(attrib)) BP += 15;
			body = value;
			BP -= (body - metaType.getAttribMin(attrib))*10;
			if (body == metaType.getAttribMax(attrib)) BP -= 15;
			break;
		case AGI:
			BP += (agility - metaType.getAttribMin(attrib))*10;
			if (agility == metaType.getAttribMax(attrib)) BP += 15;
			agility = value;
			BP -= (agility - metaType.getAttribMin(attrib))*10;
			if (agility == metaType.getAttribMax(attrib)) BP -= 15;
			break;
		case REA:
			BP += (reaction - metaType.getAttribMin(attrib))*10;
			if (reaction == metaType.getAttribMax(attrib)) BP += 15;
			reaction = value;
			BP -= (reaction - metaType.getAttribMin(attrib))*10;
			if (reaction == metaType.getAttribMax(attrib)) BP -= 15;
			redoInit();
			break;
		case STR:
			BP += (strength - metaType.getAttribMin(attrib))*10;
			if (strength == metaType.getAttribMax(attrib)) BP += 15;
			strength = value;
			BP -= (strength - metaType.getAttribMin(attrib))*10;
			if (strength == metaType.getAttribMax(attrib)) BP -= 15;
			break;
		case CHA:
			BP += (charisma - metaType.getAttribMin(attrib))*10;
			if (charisma == metaType.getAttribMax(attrib)) BP += 15;
			charisma = value;
			BP -= (charisma - metaType.getAttribMin(attrib))*10;
			if (charisma == metaType.getAttribMax(attrib)) BP -= 15;
			break;
		case INT:
			BP += (intuition - metaType.getAttribMin(attrib))*10;
			if (intuition == metaType.getAttribMax(attrib)) BP += 15;
			intuition = value;
			BP -= (intuition - metaType.getAttribMin(attrib))*10;
			if (intuition == metaType.getAttribMax(attrib)) BP -= 15;
			break;
		case LOG:
			BP += (logic - metaType.getAttribMin(attrib))*10;
			if (logic == metaType.getAttribMax(attrib)) BP += 15;
			logic = value;
			BP -= (logic - metaType.getAttribMin(attrib))*10;
			if (logic == metaType.getAttribMax(attrib)) BP -= 15;
			break;
		case WIL:
			BP += (willpower - metaType.getAttribMin(attrib))*10;
			if (willpower == metaType.getAttribMax(attrib)) BP += 15;
			willpower = value;
			BP -= (willpower - metaType.getAttribMin(attrib))*10;
			if (willpower == metaType.getAttribMax(attrib)) BP -= 15;
			break;
		case EDGE:
			BP += (edge - metaType.getAttribMin(attrib))*10;
			if (edge == metaType.getAttribMax(attrib)) BP += 15;
			edge = value;
			BP -= (edge - metaType.getAttribMin(attrib))*10;
			if (edge == metaType.getAttribMax(attrib)) BP -= 15;
			break;
		case MAG:
			if (magic > 0) {
				BP += (magic - metaType.getAttribMin(attrib))*10;
				if (magic == metaType.getAttribMax(attrib)) BP += 15;
				magic = value;
				BP -= (magic - metaType.getAttribMin(attrib))*10;
				if (magic == metaType.getAttribMax(attrib)) BP -= 15;
			}
			break;
		case RES:
			if (resonance > 0) {
				BP += (resonance - metaType.getAttribMin(attrib))*10;
				if (resonance == metaType.getAttribMax(attrib)) BP += 15;
				resonance = value;
				BP -= (resonance - metaType.getAttribMin(attrib))*10;
				if (resonance == metaType.getAttribMax(attrib)) BP -= 15;
			}
			break;
		}
	}
	
	/***
	 * Sets the name of the character
	 * @param s the name to set the character to.
	 */
	public void setName(String s) {
		name = s;
	}
	
	/**
	 * Adds or removes a quality, based on if it is already taken or not.
	 * @param qual The quality to add.
	 */
	public void toggleQuality(Quality qual) {
		
		if (!qualities.contains(qual)) {
			qualities.add(qual);
			
			if (qual.getName().equals("Adept") || qual.getName().equals("Magician") || 
					qual.getName().equals("Mystic Adept") && !qualities.contains("Technomancer")) {
				magic = metaType.getAttribMin(Attribute.MAG);
			}
			
			if (qual.getName().equals("Technomancer") && !(qualities.contains("Magician") || 
					qualities.contains("Mystic Adept") || qualities.contains("Technomancer"))) {
				resonance = metaType.getAttribMin(Attribute.RES);
			}
			
			BP -= qual.getCost();
			
		} else {
			qualities.remove(qual);
			
			if (qual.getName().equals("Adept") || qual.getName().equals("Magician") || 
			qual.getName().equals("Mystic Adept")) {
				BP += (magic - metaType.getAttribMin(Attribute.MAG))*10;
				if (magic == metaType.getAttribMax(Attribute.MAG)) BP += 15;
				magic = 0;
			} else if (qual.getName().equals("Technomancer")) {
				BP += (resonance - metaType.getAttribMin(Attribute.MAG))*10;
				if (resonance == metaType.getAttribMax(Attribute.MAG)) BP += 15;
				resonance = 0;
			}
			
			BP += qual.getCost();
		}		
	}
	
	/**
	 * Shows the remaining BP of the character.
	 * @return The BP left.
	 */
	public int getBP() {
		return BP;
	}
	
	/**
	 * Sets the specified active or knowledge skill to the specified rank,
	 * and applies the appropriate BP cost.
	 * @param skill The skill to set.
	 * @param rank The rank to set it to.
	 */
	public void setSkill(Skill skill, int rank) {
		if (skill.getClass().toString() == "ActiveSkill") {
			try {
				setActive((ActiveSkill) skill, rank);
			} catch (Exception e) {
				// TODO handle
			}
		} else {
			try {
				setKnowledge((KnowledgeSkill) skill, rank);
			} catch (Exception e) {
				// TODO handle
			}
		}
	}
	
	/**
	 * Sets an active skill and applies the BP cost.
	 * @param skill The skill to set.
	 * @param rank The rank to set it to.
	 */
	public void setActive(ActiveSkill skill, int rank) throws Exception{
		// Check the rank is valid
		if (rank < 0 || rank > 6) {
			throw (new Exception("Invalid rank."));
		}
		if (activeSkills.containsValue(6) && (rank == 6 || rank == 5)) {
			throw (new Exception("Too many high rank skills."));
		}
		/**
		 * ADD EXCEPTION FOR TOO MANY FIVES!
		 */
		
		// Apply the changes.
		if (!activeSkills.containsKey(skill)) {
			BP -= rank * 4;
		} else {
			BP += activeSkills.get(skill)*4;
			BP -= rank * 4;
		}
		activeSkills.put(skill, rank);
	}
	
	/**
	 * Sets a knowledge skill and applies the BP cost.
	 * @param skill The skill to set.
	 * @param rank The rank to set it to.
	 */
	public void setKnowledge(KnowledgeSkill skill, int rank) throws Exception{
		if (rank < 0 || rank > 6) {
			throw (new Exception("Invalid rank."));
		}
		if (knowledgeSkills.containsValue(6) && (rank == 6 || rank == 5)) {
			throw (new Exception("Too many high rank skills."));
		}
		/**
		 * ADD EXCEPTION FOR TOO MANY FIVES!
		 */
		
		// Apply the changes.
		if (!knowledgeSkills.containsKey(skill)) {
			BP -= rank * 4;
		} else {
			BP += knowledgeSkills.get(skill)*4;
			BP -= rank * 4;
		}
		knowledgeSkills.put(skill, rank);
	}
}
