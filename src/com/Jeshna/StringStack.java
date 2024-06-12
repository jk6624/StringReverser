package com.Jeshna;

class StringStack {

	// instance variable
	private StringLinkedList list = new StringLinkedList();

	// default constructor THAT calls the default constructor for MyLinkedList
	// aka the push method is caller of MLL (the methods of MLL)
	// mystack is the caller of push
	public StringStack() {// MAKING EMPTY LIST DONT USE ALREADY LIST

		this.list = new StringLinkedList();

	}

	// Add an item to the top of the stack
	// calls only methods exsisting in MyLinkedLists - (mylinkedlist methods only)
	public void push(String value) {
		list.addToFront(value);

	}

	// Remove the top value of a stack, and return that value
	public String pop() throws Exception {
		String topToRemove = list.lookAtFront();
		list.removeFromFront();
		return topToRemove;

	}

	// Return the top value of the stack, but no deleting
	public String peek() throws Exception { // exception = java suggestion
		return list.lookAtFront();

	}

	// ONLY WAY TO ACCESS THE ISEMPTY (FOR LIST) METHOD FROM STRING LINKED LIST //
	// from chatgpt
	public boolean isEmpty() {
		return list.isEmpty();
	}

	public String toString() {
		return list.toString();
	}

}
