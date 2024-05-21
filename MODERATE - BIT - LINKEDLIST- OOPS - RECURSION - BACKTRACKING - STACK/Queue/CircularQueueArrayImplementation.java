public class CircularQueueArrayImplementation {
      // circular queue ...
      static class CircularQueueArray {
            static int arr[];
            static int size;
            static int rear;
            static int front;

            CircularQueueArray(int n) {
                  arr = new int[n];
                  size = n;
                  rear = -1;
                  front = -1;
            }

            // is empty
            public boolean isEmpty() {
                  return rear == -1 && front == -1;
            }

            // is full
            public boolean isFull() {
                  return (rear + 1) % size == front; // agr next index pr front hai rear ke to full hai
            }

            // add
            public void add(int data) { // O(1)
                  if (isFull()) {
                        System.out.println("Queue is full...");
                        return;
                  }
                  // first element condition
                  if (front == -1) {
                        front = 0;
                  }

                  rear = (rear + 1) % size;
                  arr[rear] = data;
            }

            // remove
            public int remove() { // O(1)
                  if (isEmpty()) {
                        System.out.println("Queue is empty...");
                        return -1;
                  }
                  int result = arr[front];
                  if (rear == front) {
                        front = rear = -1; // if all value deleted...
                  } else {
                        front = (front + 1) % size;
                  }
                  return result;
            }

            // peak
            public int peek() { // O(1)
                  if (isEmpty()) {
                        System.out.println("queue is empty...");
                        return -1;
                  }

                  return arr[front];
            }
      }

      public static void circularQueueCall() {
            CircularQueueArray cq = new CircularQueueArray(5);
            cq.add(10);
            cq.add(20);
            cq.add(30);
            cq.add(14);

            while (!cq.isEmpty()) {
                  System.out.println(cq.peek());
                  cq.remove();
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            circularQueueCall();
      }

      // ? Output
      //  1.
      //     10
      //     20
      //     30
      //     14
}
