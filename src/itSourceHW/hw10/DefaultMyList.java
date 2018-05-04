package itSourceHW.hw10;

import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DefaultMyList implements MyList {

	public class IteratorImpl implements Iterator<Object> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			return null;
		}

	}

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

	    public Iterator<Object> iterator() {
	    	
	    	return new IteratorImpl();
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
			// Достаточно присутсвия
	        for (Object e : c)
	            if (!contains(e))
	                return false;
	        return true;
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
