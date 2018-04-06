package itSourceHW.hw10;

import java.awt.Dimension;
import java.awt.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DefaultMyList implements MyList {

	private Map<String, Item> c = new HashMap<String, Item>();

	    @Override
	    public void add(Object e) {
	        if (!c.containsKey(((Item) e).getName())) {
	            c.put(((Item) e).getName(), (Item) e);
	        }
	    }

	    @Override
	    public void clear() {
	        c.clear();
	    }

	    @Override
	    public boolean remove(Object o) {
	        if (o instanceof Item) {
	            c.remove(((Item) o).getName());
	            return true;
	        }

	        return false;
	    }

	    public Iterator<Item> iterator() {
	        return c.values().iterator();
	    }

	    @Override
	    public int size() {
	        return c.size(); 
	    }


	    @Override
	    public boolean contains(Object o) {
	        if (o instanceof Item) {
	            return c.containsKey(((Item)o).getName());
	        }

	        return false;
	    }

		@Override
		public boolean containsAll(MyList c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	class Item {
	    private String name = "";

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        if (name == null) {
	            throw new IllegalArgumentException();
	        }
	        this.name = name;
	    }

}
