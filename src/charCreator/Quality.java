package charCreator;

/**
 * A class to store the name, cost and description of a quality
 * 
 * @author jackreichelt
 */
public class Quality {

	private String name;
	private int cost;
	private String desc;
	
	/**
	 * Constructor
	 * @param name name of the quality
	 * @param cost cost of the quality in BP
	 * @param desc description of the quality
	 */
	public Quality(String name, int cost, String desc) throws Exception {
		
		if (name == null || name.equals("")) {
			throw (new Exception("A quality must have a name."));
		}
		if (desc == null || desc.equals("")) {
			throw (new Exception("A quality must have a description."));
		}
		if (cost == 0) {
			throw (new Exception("A quality must not cost 0."));
		}
		
		this.name = new String(name);
		this.cost = cost;
		this.desc = new String(desc);
	}
	
	public String getName() {
		return new String(name);
	}
	
	public int getCost() {
		return cost;
	}
	
	public String getDesc() {
		return new String(desc);
	}
}
