    package john.java.algorithms;

    import java.util.ArrayList;

    public class Heap<T extends Comparable<T>> {
        private ArrayList<T> list;
        public Heap(){
            this.list = new ArrayList<>();
        }
        private void swap(int first,int second){
            T temp = list.get(first);
            list.set(first,list.get(second));
            list.set(second,temp);
        }

        public T add(T ele){

            list.add(ele);
            int index = list.size() - 1;
            int parentIndex;
            while(index > 0){
                parentIndex = (index - 1) / 2;
                if(list.get(index).compareTo(list.get(parentIndex)) < 0){
                    swap(index,parentIndex);
                    index = parentIndex;
                }
                else break;
            }
            return ele;
        }

        public T remove(){
            if (list.isEmpty()) {
                throw new IllegalStateException("Heap is empty.");
            }
            T ele = list.get(0);
            list.set(0,list.get(list.size() - 1));
            list.remove(list.size() - 1);
            downHeap(0);
            return ele;
        }
        public void downHeap(int index){
            int size = this.list.size();

            while (index < size){
                int leftChild = 2 * index + 1;
                int rightChild  = 2 * index + 2;
                int largest = index;
                if(leftChild < size && list.get(leftChild).compareTo(list.get(largest)) < 0) {
                    largest = leftChild;
                }

                if(rightChild < size && list.get(rightChild).compareTo(list.get(largest)) < 0 ){
                    largest = rightChild;
                }

                if(index != largest){
                    swap(index,largest);
                    index = largest;
                }
                else break;
            }
        }

        public ArrayList<T> stringPrint(){
            return list;
        }

        public T getMax(){
            T ele = list.get(0);
            return ele;
        }

        public ArrayList<T> heapSort(){
            ArrayList<T> answer = new ArrayList<>();
            while (!list.isEmpty()){
                answer.add(remove());
            }
            return answer;
        }

    }
