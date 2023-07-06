/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Meal;

    public class MealLinkedList<E> {
    
         public static class Node<E> {
            private Meal data;
            private int quantity;
            private Node<E> next;
            
            
            Node(Meal data, int quantity, Node<E> next){
                this.data = data;
                this.quantity = quantity;
                this.next = next;
            }
            
            public double getPrice(){
                return data.getPrice()*quantity;
            }

            public Meal getData(){
                return data;
            }

            public int getQuantity(){
                return quantity;
            }

            public Node<E> getNext(){
                return next;
            }

            void setData(Meal data){
                this.data = data;
            }
            void setNext(Node<E> next){
                this.next = next;
            }
            void setQuantity(int quantity){
                this.quantity = quantity;
            }
        } // end of Node class

        private Node head = null;

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
        private Node tail = null;
        private int size = 0;

        public MealLinkedList(){ } // Empty constructor

        public int size() { 
            return size; 
        }

        public Meal first()
	{if(isEmpty()) return null;
		return head.getData();}

        public Meal last()
	{if(isEmpty()) return null;
		return tail.getData();}
        
        public boolean isEmpty() {
            return (size == 0);
        }

        public void addFirst(Meal data, int quant) {
            Node<E> newNode = new Node<E>(data, quant, head);
            head = newNode;
            size++;
            
            if (size == 1){ 
                tail = head; 
            }
        }

        public int findNode(Meal key, int quant) {
            if (isEmpty()) {
                return 3;
            }

            Node<E> current = head;
            int counter = 1;
            while (current != null) {
                if (((current.getData() == key) || ((current.getData()).equals(key))) && (current.getQuantity() == quant)) {
                    return 2;
                }
                else if(((current.getData() == key) || ((current.getData()).equals(key))) && (current.getQuantity() != quant)){
                    current.setQuantity(quant);
                    return 1;
                }
                counter++;
                current = current.getNext();
            }

            //if Entity not found in the list
            return 3;
        }

        public String displayOrder() {
		if(isEmpty()) {
		return "";}
                String order="";
                Node<E> current = head;
		int count=1;
		while(current!=null) {
			order+=(current.getQuantity()+" "+current.getData().getMealname()+": "+ current.getPrice()+" SR\n") ;
			current = current.getNext();
			count++;
		}
	return order;
        }
   
       public double calculateTotal(){
       double total=0; 
       Node<E> current = head;
               
	while(current!=null) {
           total+= current.getData().getPrice()*current.getQuantity();
           current=current.next;
       }
       return total;
    }

    
    }