package pa1_v2;

/**
 * Vector class represents a vector in n-dimensional space with basic operations.
 */
public class Vector {

    // Attributes
    private int n;
    private int[] data;

    /**
     * Constructor to initialize the Vector with the specified number of 
     * dimensions (n) and sets all elements to -1.
     * @param n The number of dimensions of the vector.
     */
    public Vector(int n) {
        this.n = n;
        this.data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = -1;
        }
    }

    /**
     * Get the number of dimensions of the vector.
     * @return The number of dimensions.
     */
    public int getDimension() {
        return n;
    }

    /**
     * Get the element at the specified index in the vector.
     * @param index The index of the element.
     * @return The element at the specified index.
     */
    public int read(int index) {
        return data[index];
    }

    /**
     * Set the element at the specified index in the vector to the given value.
     * @param index
     * @param value
     */
    public void update(int index, int value) {
        data[index] = value;
    }

    /**
     * Remove the element at the specified index in the vector.
     * @param index The index of the element to remove.
     */
    public void delete(int index) {
        if (index >= 0 && index < data.length) {
        int[] newData = new int[data.length];
        for (int i = 0, j = 0; i < data.length; i++) {
            if (i != index) {
                newData[j] = data[i];
                j++;
            }
        }
        //-1 at the end since deleted entry
        newData[newData.length-1] = -1;
        data = newData;
    }
    }

    /**
     * Add the elements of the given vector v to the current vector.
     * The vectors must have the same number of dimensions.
     * @param v The vector to add.
     */
    public void add(Vector v) {
        if(n == v.getDimension()){
            for (int i = 0; i < data.length; i++) {
                data[i] = data[i] + v.read(i);
        }
    }
        }
    

    /**
     * Subtract the elements of the given vector v from the current vector.
     * @param v
     */
    public void subtract(Vector v) {
        if(n == v.getDimension()){
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i] - v.read(i);
    }
}
    }

    /**
     * Get the maximum element in the vector.
     * @return The maximum element.
     */
    public int max(){
        int max = data[0];
        for (int i = 0; i < data.length; i++) {
            if(data[i] > max){
                max=data[i];
            }
    }
    return max;
}
    /**
     * Get the minimum element in the vector.
     * @return The minimum element.
     */
    public int min() {
        int min = data[0];
        for (int i = 0; i < data.length; i++) {
            if(data[i] < min){
                min=data[i];
            }
    }
    return min;
}
    

    /**
     * Get the average of all elements in the vector.
     * @return The average of all elements.
     */
    public double average() {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum = sum + data[i];
        }
        return sum/data.length;
    }

    /**
     * Search for the first occurrence of the specified value in the vector.
     * @param value The value to search for.
     * @return The index of the first occurrence of the value, or -1 if not found.
     */
    public int search(int value) {
        for (int i = 0; i < data.length; i++) {
            if(data[i] == value){
                return i;
            }
        }
        return -1;
        
    }

    /**
     * Search for the first occurrence of the specified value in the vector.
     * This method is optimized for speed using the Binary Search Algorithm.
     * @param value The value to search for.
     * @return The index of the first occurrence of the value, or -1 if not found.
     */
    public int searchFast(int value) {
        int start = 0;
        int mid;
        int end = data.length-1;
        while(start<=end){
            mid = (end+start)/2;
            if (data[mid] == value){
                return mid;
            }
            else if (data[mid] < value){
                start = mid+1;
            }
            else if (data[mid] > value){
                end = mid-1;
            }
        }
        return -1;
    }

    /**
     * Sort the elements of the vector in ascending order.
     */
        public void sort() {
        for (int i = 1; i < data.length; i++) {
            int holder = data[i];
            int j = i-1;
            while (j >= 0 && data[j] > holder) {
                data[j +1] = data[j];
                j--;
            }
            data[j + 1] = holder;
        }
    }
}
