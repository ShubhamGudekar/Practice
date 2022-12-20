package stack.com;

public class Customer {
	private int id;
	private String name;
	private String address;
	
	public Customer()
	{
		id=100;
		name="abc";
		address="abc";
	}
	
	public Customer(int id,String name,String address)
	{
		this.id=id;
		this.name=name;
		this.address=address;
	}
	
	@Override
	public String toString()
	{
		return String.format("%-8d%-12s%-12s",id,name,address);
	}
}
