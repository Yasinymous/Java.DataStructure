/**
 *
 * @author ysnak
 */

public class List 
{	
	Node Head;
	Node1 Head1;
	
        static class Node1 {
	       
                 String Data1;
		 Node1 Next1;
		 Node1 (String veri1){
		 
			 Data1 = veri1;
			 Next1 = null;
		 }	 
	 }          
	 static class Node {
		 
                 String Data;
		 Node Next;
                 
                 Node (String veri){
			 Data = veri;
			 Next = null;
		 }
		 
	 }
        //Ana listeyi yazdırma metodu
	public void mainlist_print(List mainlist) {
		
              System.out.print("Mainlist{head,");
	      Node current = mainlist.Head;
	      
	      while(current != null){
	    	  System.out.print(current.Data+",");
	      	  current = current.Next;
	    }
	   System.out.println("null}");
	}
        //Ana listeyi eleman ekleme metodu
	public List main_listadd(List mainlist, String veri) {
		 Node newNode = new Node(veri);
		 
		 if(mainlist.Head == null){
			 mainlist.Head =newNode;
		 }
		 else{
			Node second = mainlist.Head;
			
			while(second.Next != null){
				second = second.Next;
			}			
			second.Next = newNode;
		 }		 
		return mainlist;
	}
        //Ana listede silip yan listeye eleman ekleme metodu
        public List Undo(List mainlist,List sidelist) {
            
		if(mainlist.Head != null){
                    Node first = mainlist.Head;
                    Node second = mainlist.Head;			
			if(second.Next == null){
				mainlist.Head = null;
                                this.side_listadd(sidelist, second.Data);
				second = null;	                                                                      
			}                       
			else{       
				while(second.Next !=null){ 
					first = second;                                       
					second = second.Next;
				}
				this.side_listadd(sidelist, second.Data);
				first.Next = null;
				second = null;                               
			}	
		}
                else{
                    System.out.println("xxxxxxxGeriye alıncak eleman yok");
                }
	return sidelist;
	}
   

	
	
        // Yan listeden elemanı silip anaya listeye eleman ekleme metodu
        public List Redo(List mainlist,List sidelist)  {

                if(sidelist.Head1 != null){
                    Node1 first = sidelist.Head1;
                    Node1 second = sidelist.Head1;
			if(second.Next1 == null){
				sidelist.Head1 = null;
                                this.main_listadd(mainlist, second.Data1);
				second = null;	                                        
			}
			else{                                      
				while(second.Next1 !=null){
					first = second;
                                 	second = second.Next1;
				}
                                this.main_listadd(mainlist, second.Data1); 
				first.Next1 = null;
				second = null;                              
			}				
		}
                else{
                    System.out.println("xxxxxxxİleriye alıncak eleman yok");
                }              
                return sidelist;                            
          }	
    // yan listeye eleman ekleme metodu
    public List side_listadd(List sidelist, String veri1){
		 Node1 newNode = new Node1(veri1);
		 
		 if(sidelist.Head1 == null) {
			 sidelist.Head1 =newNode;
		 }
		 else {
			Node1 second = sidelist.Head1;
			
			while(second.Next1 != null){
				second = second.Next1;
			}			
			second.Next1 = newNode;			
		 }		 
		return sidelist;
	}
    // yan listeyi yazdırma metodu test için.....
    public void sidelist_print(List sidelist) 	{
                System.out.print("Sidelist");
	      Node1 current = sidelist.Head1;	      
	      while(current != null){
	    	  System.out.print(","+current.Data1);
                  current = current.Next1;
  	      }
	}

    public List sidelist_delete(List sidelist){
    
    if(sidelist.Head1 != null)	{
                    while (sidelist.Head1 != null){
			Node1 first = sidelist.Head1;
			Node1 second = sidelist.Head1;
			
			if(second.Next1 == null){
				sidelist.Head1 = null;
				second = null;	                           
			}
			else{                                     
				while(second.Next1 !=null){
					first = second;
                                      	second = second.Next1;
				}
				first.Next1 = null;
				second = null;
                           }}
 		}
    else{
                     }
                 return sidelist;
               }	
}








