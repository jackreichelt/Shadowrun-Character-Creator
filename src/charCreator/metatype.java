package charCreator;


/**
 * The class for a metatypes data.
 * 
 * @author jackreichelt
 */
public class metatype {

	// the name of the metatype
	private String name;
	//the cost for the metatype
	private int cost;
	// the ranges of values that the attribute can have
	// BOD, AGI, REA, STR, CHA, INT, LOG, WIL, EDGE
	int[] mins;
	int[] maxs;
	private String notes;
	
	/**
	 * constructor for the metatype
	 * @param name the name of the metatype
	 * @param cost the BP cost of the metatype
	 * @param mins the minimum values of the attributes
	 * @param maxs the maximum values of the attribues
	 */
	public metatype(String name, int cost, int[] mins, int[] maxs, String notes) 
			throws Exception{
		if (cost < 0) {
			throw (new Exception("Cost must be >= 0."));
		}
		if (name == null || name.equals("")) {
			throw (new Exception("Metatype must have a name."));
		}
		for (int i = 0; i < mins.length; i++) {
			if (mins[i] > maxs[i]) {
				throw (new Exception("Min attribute must be lower than the max."));
			}
			if (mins[i] < 1) {
				throw (new Exception("Min attributes must be 1 or higher."));
			}
		}
		
		this.name = new String(name);
		this.cost = cost;
		this.mins = mins.clone();
		this.maxs = maxs.clone();
		if (notes != null) {
			this.notes = new String(notes);
		} else {
			this.notes = "";
		}
		
	}
	
	/**
	 * Returns the minimum value of an attribute for the metatype
	 * BOD, AGI, REA, STR, CHA, INT, LOG, WIL
	 * @param attrib the attribute to investigate
	 * @return the minimum value this metatype can have for the specified
	 * attribute.
	 */
	public int getAttribMin(Attribute attrib) {
		switch (attrib) {
		case BOD:
			return mins[0];
		case AGI:
			return mins[1];
		case REA:
			return mins[2];
		case STR:
			return mins[3];
		case CHA:
			return mins[4];
		case INT:
			return mins[5];
		case LOG:
			return mins[6];
		case WIL:
			return mins[7];
		case INIT:
			return mins[2] + mins[5];
		case EDGE:
			return mins[8];
		case MAG:
		case RES:
			return 1;
		}
		return 0;
	}
	
	/**
	 * Returns the maximum value of an attribute for the metatype
	 * BOD, AGI, REA, STR, CHA, INT, LOG, WIL
	 * @param attrib the attribute to investigate
	 * @return the maximum value this metatype can have for the specified
	 * attribute.
	 */
	public int getAttribMax(Attribute attrib) {
		switch (attrib) {
		case BOD:
			return maxs[0];
		case AGI:
			return maxs[1];
		case REA:
			return maxs[2];
		case STR:
			return maxs[3];
		case CHA:
			return maxs[4];
		case INT:
			return maxs[5];
		case LOG:
			return maxs[6];
		case WIL:
			return maxs[7];
		case INIT:
			return maxs[2] + maxs[5];
		case EDGE:
			return maxs[8];
		case MAG:
		case RES:
			return 6;
		}
		return 0;
	}
	
	/**
	 * Get the cost.
	 * @return the cost of the metatype in BP
	 */
	public int getCost() {
		return cost;
	}
	
	/**
	 * Get the name.
	 * @return the name of the metatype.
	 */
	public String getName() {
		return new String(name);
	}
	
	public String getNotes() {
		return new String(notes);
	}
}
