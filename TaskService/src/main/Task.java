package main;

public class Task {
	private final String uniqueID;
	private String name;
	private String description;
	
	
	public Task(String uniqueID, String name, String description) {
		//If parameter is null or too long exception is thrown
        if (uniqueID == null || uniqueID.length() > 10) {
            throw new IllegalArgumentException("Invalid UniqueID");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid Name");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid Description");
        }
        this.uniqueID = uniqueID;
        this.name = name;
        this.description = description;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid Name");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid Description");
        }
        this.description = description;
    }
}