public class BaseClass {

	String name;
	String message;

	@Override
	public String toString() {
		return "BaseClass [name=" + name + ", message=" + message + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
