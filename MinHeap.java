import java.util.ArrayList;

public class MinHeap {

	private ArrayList<No> data;


	public MinHeap(){
		this.data = new ArrayList<>();
	}

	public void heapfyUp(int index){
		int parent = (index - 1)/2;

		while(index > 0 && data.get(index).compareTo(data.get(parent)) < 0){
			No aux = data.get(index);
			data.set(index, data.get(parent));
			data.set(parent, aux);

			index = parent;
			parent = (index - 1)/2;
		}
	}	

	public void heapfyDown(int index) {
		int left_child = 2 * index + 1;
		int right_child = 2 * index + 2;
		int minor = index;

		if (left_child < data.size() && data.get(left_child).compareTo(data.get(minor)) < 0)
			minor = left_child;

		if (right_child < data.size() && data.get(right_child).compareTo(data.get(minor)) < 0)
			minor = right_child;

		if (minor != index) {
			No aux = data.get(index);
			data.set(index, data.get(minor));
			data.set(minor, aux);

			heapfyDown(minor);
		}
	}

	public void insert(No n){
		data.add(n);
		heapfyUp(data.size() - 1);
	}

	public No extractMin(){
		if(data.isEmpty()) return null;

		No minor = data.get(0);
		// Pega o último elemento para colocar no topo
		No lastNode = data.get(data.size() - 1);
		data.set(0, lastNode);
		data.remove(data.size() - 1);
		// remover pelo index garante O(1), pois vai direto no endereco e evita remocoes erradas

		if(!data.isEmpty()) heapfyDown(0);

		return minor;
	}

	// Metodo útil para o Passo 3 (saber quando parar a construção da árvore)
	public int getSize() {
		return data.size();
	}

}
