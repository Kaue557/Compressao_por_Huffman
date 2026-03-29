import java.util.ArrayList;

public class MinHeap {

	private ArrayList<No> tree;


	public MinHeap(){
		this.tree = new ArrayList<>;
	}

	public void heapfyUp(int index){
		int parent = (index - 1)/2;
		No aux = new No<>;

		while(index > 0 && tree.get(index).compareTo(tree.get(parent)) < 0){
			aux = tree.get(index);
			tree.set(index, tree.get(parent));
			tree.set(parent, aux);

			index = parent;
			parent = (index - 1/2);

		}
	}	

	public void heapfyDown(int index){
		int left_child = 2 * index + 1;
		int righ_child = 2 * index + 2;
		int minor = index;

		if(left_child < tree.size() && tree.get(left_child).compareTo(tree.get(minor)) < 0)
			minor = left_child;
		
		if(right_child < tree.size() && tree.get(right_child).compareTo(tree.get(minor)) < 0)
			minor = right_child;
		

		if(minor != index){
			No aux = tree.get(index);
        	tree.set(index, tree.get(minor));
        	tree.set(minor, aux);
		
		heapfyDown(minor);
		}

	public void insert(No n){
		tree.add(n);
		int index = tree.size() - 1;
		heapfyUp(index);
	}

	public No extractMin(){
		if(tree.isEmpty())
			return null;

		No minor = tree.get(0);
		No last = tree.size() - 1;
		tree.set(0, last);
		tree.remove(last);

		if(!tree.isEmpty())
			heapfyDown(0);

		return minor;
		
	}

}
