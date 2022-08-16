
public class BST {

	BST left;
	BST right;
	int value;
	
	
	BST(int value){
	  this.value=value;
	}
	
	void insert(int val) {
		insertR(this,val);
	}
	
	BST insertR(BST node,int val) {
		
		if(node==null) {
		   node=new BST(val);	
		   return node;	
		}
		
		
		if( val<node.value) {
		  node.left=insertR(node.left,val);
	    }
		else if( val>node.value) {
		   node.right=insertR(node.right,val);
	    }		
			
		return node;
    }
	
	
	
	void postOrder() {
		postOrderR(this);
	}
	
	
	void postOrderR(BST node) {
		
		if(node==null) return;
		
		postOrderR(node.left);
		postOrderR(node.right);
		System.out.print(node.value+" ");

	}
	
	
	void remove(int val) {
		removeR(this,val); 
	}
	
	BST removeR(BST node,int val) {
		
		if(node==null) return null;
		
		if(val<node.value)
		   node.left=removeR(node.left,val);
		else if(val>node.value)
			node.right=removeR(node.right,val);
		else {
			
			  //case 1
			  if(node.right==null && node.left==null) {
				  System.out.println("first");
				  node=null;
				  
				  return node;
			  }
			  
			  //case 2
			  if(node.right!=null && node.left==null) {
				  System.out.println("second");
   	              node=node.right;
   	              return node;
   	              
			  }else if(node.left!=null && node.right==null) {
				  System.out.println("Third");
				  node=node.left;
				  return node;
			  }
			  
			  
			  //case 3
			  if(node.right!=null && node.left!=null) {
				  System.out.println("Both");

				  int minValue=getMinNode(node.right);
				  node.right=removeR(node.right,minValue);
				  node.value=minValue;
				  return node;
			  }
		
		
		}
			
		
		return node;
	
	}
	
	int getMinNode(BST node) {
		while(node.left!=null) {
		  node=node.left;		
		}
		//System.out.println(node.value);
		return node.value;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BST tree=new BST(16);
		tree.insert(8);
		tree.insert(4);
		tree.insert(9);
		tree.insert(25);
		tree.insert(22);
		tree.insert(26);
		
		//tree.postOrder();
		System.out.println(" ");
		
		tree.remove(8);
		tree.remove(4);
	    tree.remove(9);
		tree.remove(25);
		tree.remove(22);
	     tree.remove(26);





		tree.postOrder();
		

	}

}
