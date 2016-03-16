import java.util.ArrayList;

public class Building implements Facility {
	private String name;
	private int min_floor;
	private int max_floor;
	private int capacity;
	private ArrayList<Room> rooms;
	
	public Building(String name, int min_floor, int max_floor) throws IllegalArgumentException{
		if (max_floor < min_floor) {
			throw new IllegalArgumentException();
		}
		
		this.name = name;
		this.min_floor = min_floor;
		this.max_floor = max_floor;
		
		rooms = new ArrayList<Room>();
	}
	
	public String getName() {
		return name;
	}
	
	public int getMinFloor() {
		return min_floor;
	}
	
	public int getMaxFloor() {
		return max_floor;
	}
	
	@Override
	public String toString() {
		return "Building(" + name +")";
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void addCapacity(int number) {
		capacity += number;
	}
	
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	
	public boolean canEnter(User u) {
		for (int i = 0; i < rooms.size(); i++) {
			if (rooms.get(i).canEnter(u)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
}
