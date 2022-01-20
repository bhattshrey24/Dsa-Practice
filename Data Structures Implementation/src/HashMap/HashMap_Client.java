package HashMap;

public class HashMap_Client {
	// Must watch https://www.youtube.com/watch?v=2ijH5vcKIxQ&t=1484s
	public static void main(String[] args) {
		HashMap_Implementation<String, Integer> hm = new HashMap_Implementation<>();
		hm.put("Red", 100);
		hm.put("Yellow", 70);
		hm.put("Blue", 80);
		hm.put("Green", 40);
		System.out.println("Contains Red : " + hm.containsKey("Red"));
		System.out.println("Contains Purple : " + hm.containsKey("Purple"));
		System.out.println("Value of Red : " + hm.get("Red"));
		hm.remove("Red");
		System.out.println("Contains Red : " + hm.containsKey("Red"));
		hm.put("Violet", 50);
		hm.put("Purple", 20);
		hm.put("Brown", 85);
		System.out.println("Contains Purple : " + hm.containsKey("Purple"));
	}

}
