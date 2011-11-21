package charCreator;

public class ActiveSkill extends Skill {
	
	private boolean skillGroup;
	
	public ActiveSkill(String name, Attribute attrib, Boolean skillGroup) throws Exception {
		super(name, attrib);
		this.skillGroup = skillGroup;
	}
	
	public boolean isSkillGroup() {
		return skillGroup;
	}
}
