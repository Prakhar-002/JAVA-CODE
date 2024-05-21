public class QueueArrayImplementation {

      static class QueueArray {
            static int arr[];
            static int size;
            static int rear;

            QueueArray(int n) {
                  arr = new int[n];
                  size = n;
                  rear = -1;
            }

            // is empty
            public boolean isEmpty() {
                  return rear == -1;
            }

            // add
            public void add(int data) { // O(1)
                  if (rear == size - 1) {
                        System.out.println("queue is full...");
                        return;
                  }
                  rear++;
                  arr[rear] = data;
            }

            // remove
            public int remove() { // O(n)
                  if (isEmpty()) {
                        System.out.println("queue is empty...");
                        return -1;
                  }
                  int front = arr[0];
                  for (int i = 0; i < rear; i++) {
                        arr[i] = arr[i + 1];
                  }
                  rear--;
                  return front;
            }

            // peak
            public int peek() { // O(1)
                  if (isEmpty()) {
                        System.out.println("queue is empty...");
                        return -1;
                  }

                  return arr[0];
            }
      }

      // queue call...

      public static void queueCall() {
            QueueArray q = new QueueArray(5);
            q.add(10);
            q.add(20);
            q.add(30);

            while (!q.isEmpty()) {
                  System.out.println(q.peek());
                  q.remove();
            }
      }

      // -----------------------------------------------------------------------------------------------
      

      public static void main(String[] args) {
            // 1...queueCall();
      }
}