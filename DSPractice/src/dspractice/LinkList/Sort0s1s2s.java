package com.aorg.MyPractice.DS.LinkList;

public class Sort0s1s2s {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			MList list = null;
			int[] data = new int[]{0,1,1,0,1,2,0,2,1};
			Sort0s1s2s so = new Sort0s1s2s();
			for(int d : data){
				list = so.createList(list,d);
			}
			MList l1 = so.sort(list);
			so.print(l1);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void print(MList list){
		try{
			MList l = list;
			while(l!=null){
				System.out.println(l.getData()+",");
				l = l.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private MList sort(MList list){
		try{
			int[] count = new int[3];
			MList l = list;
			while(l!=null){
				count[l.getData()]++;
				l = l.getNext();
			}
			MList l1 = list;
			int i=0;
			while(l1!=null){
				if(count[i] == 0){
					l1.setData(i);
					i++;
				}else{
					l1.setData(i);
					count[i]--;
					l1 = l1.getNext();
				}
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return list;
	}
	
	private MList createList(MList list,int data){
		try{
			MList node = new MList(data);
			if(list == null){
				list = node;
				return list;
			}
			list.setNext(createList(list.getNext(), data));
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
}
