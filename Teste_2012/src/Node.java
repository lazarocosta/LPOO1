import java.util.*;


public class Node {
	public Node parent;
	public String name;
	public Node[] child;
	public int size;
	static int number;
	public NameFormatter nf;
	
	public Node (Node parent, String name) throws DuplicateNameException {
		
		this.parent = parent;
		this.name = name;
		number++;
		child = new Node[] {};

		if (parent != null && parent.getChildByName(name) != null) {
			throw new DuplicateNameException();
		}
		
		ArrayList<Node> tmp = new ArrayList<Node>();
		if (parent != null) {
			for (int i = 0; i < parent.child.length; i++) {
				tmp.add(parent.child[i]);
			}
		}
		tmp.add(this);
		
		if (parent != null) {
			parent.child = tmp.toArray(parent.child);
		}
	}
	
	public Node getParent() {
		return parent;
	}
	
	public String getName() {
		return name;
	}

	public Node[] getChild() {
		return child;
	}
	
	public Node getChildByName(String name){
		
		for (int i = 0; i < child.length; i++) {
			if (child[i].getName() == name) {
				return child[i];
			}
		}
		
		return null;
	}
	
	static void resetNumbering(int n) {
		number = n;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getSize() {
		int s = 0;
		
		if (child.length != 0) {
			for (int i = 0; i < child.length; i++) {
				s += child[i].getSize();
			}
			
			return s;
		}
		else {
			return size;
		}
	}
	
	public void setNameFormatter(NameFormatter nf) {
		this.nf = nf;
		for (int i = 0; i < child.length; i++) {
			child[i].setNameFormatter(nf);
		}
	}
	
	public String getPath() {
		if (parent == null) {
			return "";
		}
		else {
			return parent.getPath() + nf.getSeparator() + name;
		}
	}

	

}