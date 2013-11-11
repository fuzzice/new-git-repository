public class OverrideEqualsAndHashCode {

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "OverrideEqualsAndHashCode [name=" + name + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		System.out.println("in hashcode method");
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + name;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			System.out.println("== is true");
			return true;
		}
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OverrideEqualsAndHashCode other = (OverrideEqualsAndHashCode) obj;
		if (id != other.id)
			return false;
		if (name != other.name)
			return false;
		return true;
	}

	// logically equal objects should have the same hash code hence the hashcode
	// override.

	int name, id;

	public static void main(String[] args) {

		OverrideEqualsAndHashCode demo1 = new OverrideEqualsAndHashCode();
		OverrideEqualsAndHashCode demo2 = new OverrideEqualsAndHashCode();
		demo1.setId(1);
		demo1.setName(2);
		demo2.setId(1);
		demo2.setName(2);

		System.out.println("demo1==demo2 " + (demo1 == demo2));
		System.out.println("demo1.equals demo2 " + demo1.equals(demo2));
		System.out.println("demo1.hashcode==demo2 .hashcode "
				+ (demo1.hashCode() == demo2.hashCode()));
	}
}
