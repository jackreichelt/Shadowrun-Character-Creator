package charCreator;

public abstract class Skill {

	protected String name;
	protected Attribute attrib;
	
	public Skill(String name, Attribute attrib) throws Exception {
		
		if (name == null || name.equals("")) {
			throw (new Exception("A skill must have a name."));
		}
		if (attrib == null) {
			throw (new Exception("A skill must have an attribute."));
		}
		
		this.name = new String(name);
		this.attrib = attrib;
	}
	
	public String getName() {
		return new String(name);
	}
	
	public Attribute getAttrib() {
		return attrib;
	}
	
	public String toString() {
		return new String(name);
	}
}