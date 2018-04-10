package itSourceHW.hw10;

import java.util.Iterator;

import itSourceHW.hw10.HomeWork10.ListItem;

public class HomeWork10 {
	public static void main(String[] args) {
		DefaultMyList  list = new DefaultMyList();
//		list.toArray();
		DefaultMyList con = new DefaultMyList ();
		Object[] testObj = new Object[3];
		testObj[0] = "Test0";
		testObj[1] = "Test1";
		testObj[2] = "Test2";
	
//		con.add(testObj[0]);
		
		// ...
		for (Object o : con) {
		System.out.println(o);
		}

		Iterator<Object> it = con.iterator();
		while (it.hasNext())
		System.out.println(it.next());

	}
	
	class ListItem {
		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
}

