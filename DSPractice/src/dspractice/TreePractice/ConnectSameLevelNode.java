package com.aorg.MyPractice.DS.TreePractice;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

public class ConnectSameLevelNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			ConnectSameLevelNode so = new ConnectSameLevelNode();
//			TreeNode perfectTree = new TreeNode(1);
//			perfectTree.setLeft(new TreeNode(2));
//			perfectTree.getLeft().setLeft(new TreeNode(4));
//			perfectTree.setRight(new TreeNode(3));
//			perfectTree.getRight().setLeft(new TreeNode(5));
//			perfectTree.getRight().setRight(new TreeNode(6));
//			so.inOrderPrint(perfectTree);
//			so.connectSameLevelNode(perfectTree);
//			System.out.println("\n"+perfectTree.getRight().getLeft().getNext().getData());
//			so.inOrderPrint(perfectTree);
			TreeNode tree = new TreeNode(1);
			tree.setLeft(new TreeNode(2));
			tree.getLeft().setLeft(new TreeNode(4));
			tree.getLeft().setRight(new TreeNode(5));
			tree.getLeft().getLeft().setLeft(new TreeNode(8));
			tree.getLeft().getLeft().setRight(new TreeNode(9));
			tree.setRight(new TreeNode(3));
			tree.getRight().setLeft(new TreeNode(6));
			tree.getRight().setRight(new TreeNode(7));
			tree.getRight().getRight().setLeft(new TreeNode(10));
			tree.getRight().getRight().setRight(new TreeNode(11));
			so.inOrderPrint(tree);
			so.connectSameLevelNode1(tree);
			System.out.println("\n > "+tree.getLeft().getLeft().getLeft().getNext().getData());
			so.inOrderPrint(tree);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	/*This method is for perfect binary tree*/
	private void connectSameLevelNode(TreeNode tree){
		try{
			if(tree == null){
				return;
			}
			if(tree.getLeft() != null){
				if(tree.getRight() == null && tree.getNext()!=null){
					tree.getLeft().setNext(tree.getNext().getLeft());
				}
				else{
					tree.getLeft().setNext(tree.getRight());
				}
			}
			else if(tree.getRight()!=null){
				if(tree.getNext().getLeft()!=null){
					tree.getRight().setNext(tree.getNext().getLeft());
				}else{
					tree.getRight().setNext(null);
				}
			}
			connectSameLevelNode(tree.getLeft());
			connectSameLevelNode(tree.getRight());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	/*For no perfect binary tree*/
	
	private void connectSameLevelNode1(TreeNode tree){
		try{
			if(tree == null){
				return;
			}
			if(tree.getLeft() != null){
				if(tree.getRight() != null){
					tree.getLeft().setNext(tree.getRight());
					tree.getRight().setNext(getNextPointer(tree));
				}else{
					tree.getLeft().setNext(getNextPointer(tree));
				}
			}else if(tree.getRight() != null){
				tree.getRight().setNext(getNextPointer(tree));
			}
			connectSameLevelNode(tree.getLeft());
			connectSameLevelNode(tree.getRight());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private TreeNode getNextPointer(TreeNode tree){
		try{
			TreeNode nextPointer = tree.getNext();
			while(nextPointer != null){
				if(nextPointer.getLeft()!=null){
					return nextPointer.getLeft();
				}
				if(nextPointer.getRight() != null){
					return nextPointer.getRight();
				}
				nextPointer = nextPointer . getNext();
			}
			return null;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private void inOrderPrint(TreeNode tree){
		try{
			
			if(tree!=null){
				inOrderPrint(tree.getLeft());
				System.out.print(tree.getData()+",");
				inOrderPrint(tree.getRight());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
