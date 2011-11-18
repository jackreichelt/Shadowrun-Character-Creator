package charCreator;

import java.util.*;

public class SkillGroup {

	private String name;
	private HashSet<ActiveSkill> skills;
	
	public SkillGroup (String name, HashSet<ActiveSkill> skills) {
		this.name = name;
		this.skills = skills;
	}
	
	@Override
	public String toString() {
		String out = "";
		
		out += name + ": ";
		for (ActiveSkill s : skills) {
			out += s.toString() + ", ";
		}
		
		return out.substring(0, out.length()-2);
	}
}
