
public class FileSystem {
	public String type;
	public Folder root;
	public NameFormatter nf;
	
	public FileSystem(String type) {
		this.type = type;
		try {
			root = new Folder(null, "");
		}
		catch (DuplicateNameException e){
		}
		
		nf = new UnixFormatter();
	}
	
	public String getType() {
		return type;
	}
	
	public Folder getRoot() {
		return root;
	}
	
	public void setNameFormatter(NameFormatter nf) {
		this.nf = nf;
		root.setNameFormatter(nf);
	}
	
}