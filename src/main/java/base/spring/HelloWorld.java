package base.spring;

public class HelloWorld {
	
	private String name;
	private String alias;

	public void setName(String name) {
		this.name = name;
		
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getName() {
		return name;
	}

	public void printHello() {
		System.out.println("Spring 3 : Hello ! " + name);
	}

}
