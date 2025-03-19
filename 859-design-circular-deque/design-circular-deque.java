class MyCircularDeque {
    int arr[];
    int front;
    int end;
    int n;
    int count;

    public MyCircularDeque(int k) {
         arr=new int[k];
         front=0;
         end=0;
         n=k;
         count=0;
    }

    public boolean insertFront(int val) {
        if(count==n)return false;
        front=(front-1+n)%n;

        arr[front]=val;
        count++;
        return true;
    }

    public boolean insertLast(int val) {
        if(count==n)return false;
        arr[(front+count)%n]=val;

        count++;
        return true;
    }

    public boolean deleteFront() {
        if(count==0)return false;
        front=(front+1)%n;

        count--;
        return true;
    }

    public boolean deleteLast() {
        if(count==0)return false;

        count--;
        return true;
    }

    public int getFront() {
        if(count==0)return -1;
        return arr[front];
    }

    public int getRear() {
        if(count==0)return -1;
        return arr[(front+count-1)%n];
    }

    public boolean isEmpty() {
        if(0==count)return true;
        return false;
    }

    public boolean isFull() {
        if(n==count)return true;
        return false;
    }
}
