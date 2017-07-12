package LRU_Test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	private DoubleLinkedList page_list;
	private Map<Integer, Node> page_map;
	private int cache_size;
	
	LRUCache(int cache_size){
		
		this.cache_size=cache_size;
		page_list= new DoubleLinkedList(cache_size);
		page_map= new HashMap<Integer, Node> ();
		
	}
	
	public void accessPage(int page_number){
		
		Node page_Node=null;
		
		if(page_map.containsKey(page_number)){
			
			// if page is present in the list then move it to the start of the list
			
			page_Node=page_map.get(page_number);
			page_list.move_PageToHead(page_Node);
		}
		
		// if page is not present in the list then add it to the list
		
		//if cache is full we will remove the tail of the cache
		
		if (page_list.getCurrent_size()==page_list.getSize()){
			
			page_map.remove(page_list.getTail().getPage_number());
		}

		page_Node=page_list.addPageToList(page_number);
		page_map.put(page_number, page_Node);
	}
	
	public void printCacheState(){
		page_list.printList();
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		
		int cache_size=4;
		
		LRUCache cache = new LRUCache(cache_size);
		cache.accessPage(4);
		cache.printCacheState();
        cache.accessPage(2);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
        cache.accessPage(7);
        cache.printCacheState();
        cache.accessPage(8);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
	}

}
