import java.util.ArrayList;

public class Room implements Facility {
	private Building building;
	private String number;
	private int floor;
	private String name;
	private int capacity;
	private ArrayList<User> users;
	
	public Room(Building building, String number, int floor) throws IllegalArgumentException,DuplicateRoomException{
		this.building = building;
		this.floor = floor;
		
		if (floor > building.getMaxFloor() || floor < building.getMinFloor()) {
			throw new IllegalArgumentException();
		}
		
		this.number = number;
		name = building.getName() + number;
		
		capacity = 0;
		
		for (int i = 0; i < building.getRooms().size(); i++) {
			if (building.getRooms().get(i).getNumber() == number) {
				throw new DuplicateRoomException();
			}
		}
		
		building.getRooms().add(this);
		users = new ArrayList<User>();
		
	}
	
	public Room(Building building, String number, int floor, int capacity) throws IllegalArgumentException,DuplicateRoomException{
		this.building = building;
		this.floor = floor;
		
		if (floor > building.getMaxFloor() || floor < building.getMinFloor()) {
			throw new IllegalArgumentException();
		}
		
		this.number = number;
		name = building.getName() + number;
		
		this.capacity = capacity;
		this.building.addCapacity(capacity);
		
		for (int i = 0; i < building.getRooms().size(); i++) {
			if (building.getRooms().get(i).getNumber() == number) {
				throw new DuplicateRoomException();
			}
		}
		
		building.getRooms().add(this);
		users = new ArrayList<User>();
	}
	

	public Building getBuilding() {
		return building;
	}

	public String getNumber() {
		return number;
	}

	public int getFloor() {
		return floor;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Room(" + building.getName() + "," + number + ")";
	}

	public int getCapacity() {
		return capacity;
	}
	
	public void authorize(User u) {
		users.add(u);
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public boolean canEnter(User u) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).equals(u)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
	
	
	
	
}
