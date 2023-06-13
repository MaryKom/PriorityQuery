public class PriorityQuery {
    private int maxSize;
    private long[] queryArray;
    private int nItems;

    public PriorityQuery(int s) {
        maxSize = s;
        queryArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long item) {
        int j;
        if (nItems == 0) {
            queryArray[nItems++] = item;
        }
        else {
            for (j = nItems - 1; j >= 0; j--) {
                if (item > queryArray[j])
                    queryArray[j+1] = queryArray[j];
                else
                    break;
            }
            queryArray[j+1] = item;
            nItems++;
        }
    }

    public long remove() {
        return queryArray[--nItems];
    }

    public long peekMin() {
        return queryArray[maxSize - 1];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }
}
