package com.Jeshna;

/**
* @author JeshnaKanduri
* @date 16/04/2024
* Linked lists - a program the calculates the size of a list, each node element is a string
*/
public class StringLinkedList {
	
		/**
		 * Instance variable for head (node - first item)
		 */
		public Node head; // head means first element in list
		
		/**
		 * Instance variable for size of list
		 */
		private int size;
		
		/**
		 * Default constructor that sets the first item of list to null
		 */
		public  StringLinkedList() {
			this.head = null;
		}
		
		/**
		 * Checks whether or not the list contains any items (String only)
		 * @return Boolean value displaying whether or not list is empty
		 */
		public boolean isEmpty() {
//			if(this.head == null) {
//				return true;
//			}else {
//				return false;
//			}
			return this.head == null; // same function as the code above
		}
		
		/**
		 * Adds new String item to the front of the list
		 * @param value New String item
		 */
		public void addToFront(String value) {
			size ++; // GETTING SIZE OF LIST
			//Create a new Node from the value
			Node node = new Node(value);
			
			if(this.isEmpty()){
				this.head = node;
				
				//return says im done with this function
				return;
			}
			//Make the new node the head of the list
			Node oldHead = head;
			node.setNext(oldHead);
			this.head = node;
		}
	
		/**
		 * Displays the first item of the list from the front
		 * @return First item from the front
		 * @throws Exception Cannot look as the front of an empty list
		 */
		public String lookAtFront() throws Exception { //accesor method - allowing us to look at front of list
			
			if(isEmpty()) {
				throw new Exception("Cannot look at the front of an empty list");
				//whenever there is a problem with our code, no matter how deep
				// exception have the abiltity to pause the code
				// bring to the top to our attention so we can deal with it
			}
			return this.head.value;
		}
		
		/**
		 * Removes first item from the front of the list
		 */
		public void removeFromFront() {
			size --; // GETTING SIZE OF LIST
			if(!isEmpty()) {
			this.head = this.head.next;
			
			}
			//next element becomes first, the old element deletes itself (not being used only there so useless)
		}
		
		/**
		 * Adds new String item to the back of the list
		 * @param value New String item
		 */
		public void addToBackSlow(String value) {
			size ++; // GETTING SIZE OF LIST
			//create our new node
			Node node = new Node(value);
			
			// Handle empty case
			if(isEmpty()) {
				this.head = node;
				return; //ADDED TO PREVENT INFINTE LOOP
			}
			
			//we need to find the back of the list
			// done in toString (in which we did something to each element)
			// but now we're just traversing to the back without doing antyhing to the head
			//DON'T MESS UP THE LIST
			
			// 'BREAD AND BUTTER' - KEY TO LISTS ALGORITHM - ONLY METHOD TO TRAVERSE A LIST
			Node curr = this.head;
			while(curr.next != null) {
				curr = curr.next;
			}
			
			// add our new node to the back's next
			curr.next = node;
		}
		
		/**
		 * Removes last String item from the back of the list
		 */
		public void removeFromBackSlow() {
			size --; // GETTING SIZE OF LIST
			// need to ensure is not empty just like remove from front
			if(!isEmpty()) {
				//front is easier, back is harder bc list is one directional
				
				// Check if there is only one element in the list
				if(this.head.next == null) {
					//empty the list
					this.head = null;
					return;
				}
				//navigate to list to one that is 2 away from the back
				//DONT MESS UP THE LIST
				Node curr = head;
				while(curr.next.next != null) {
					curr = curr.next;
				}
				// last element is predicated on the first element is null
				// is next next null true - then the 2nd last?? - idk
				curr.next = null;
			}	
		}
		
		/**
		 * Displays last item of the list from the back
		 * @return Last item in list if last item is not null
		 * @throws Exception Cannot look at the back of an empty list
		 */
		public String lookAtBack() throws Exception {
			if(isEmpty()){
				throw new Exception("Cannot look at the back of an empty list.");
				//no return bc exception is another way to end method
			}
			
			//go to back of the list
			//DONT MESS UP THE LIST
			Node curr = this.head;
			while(curr.next != null) {
				curr = curr.next;
			}
			return curr.value;
		}
		//	TODO: Ensure this is private
		// its only public for testing purposes (in main)
		
	
		@Override
		/**
		 * Displays the list as a string
		 * @return String of the list
		 */
		public String toString() {
			if(this.isEmpty()) {
				return "[]";
			}
			String listRep = "[";
//			listRep += this.head.toString() + ", ";
//			listRep += this.head.next.toString();
			
			//"Loop" over every element in the list
			//DON'T MESS UP OUR LIST
			//curr = current
			Node curr = head;
			while(curr.next != null) {
				//Add the current value to the String
				listRep += curr + ", ";
				// Move up the list - key to traversing a linked list (IMPORTANT!)
				curr = curr.next;
			}
			
			//Right now, curr is at the LAST value of the list
			listRep += curr;
			listRep += "]";
			return listRep;
		
			}
		
		/**
	     * Calculates size of the list based on whether an item was added or removed
	     * @return Integer value displaying size of the list
	     */
		public int size() {
			return size;
		}
		
//--------- NODE CLASS -------------
		/**
		 * Custom class that creates a node -- new item
		 */
		public class Node {
		/**
		 * Instance variable for value of String datatype
		 */
		String value;
		
		/**
		 * Instance variable for next node of String datatype
		 */
		Node next;
	
		/**
		 * Constructor that takes in input String item for value
		 * @param value New item
		 */
		public Node(String value) {
			this.value = value;
			this.next = null;
			}
	
		/**
		 * Retrieving the next item of the list
		 * @param next Next item after the current value
		 */
		public void setNext(Node next) {
			this.next = next;
			}
		
	@Override
		/**
		 * Displaying value as a string
		 * @return String of value
		 */
		public String toString() {
			return String.valueOf(value);
		// return value + "";
		// return Interger.String(value);
			}
}
	}
