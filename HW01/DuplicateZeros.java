class DuplicateZeros {

    public static void main(String[] args) {
        int[] arr = { 0, 0, 0, 0 };
        printArray(arr);
        duplicateZeros(arr);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            }
        System.out.println();            
    }

    public static void duplicateZeros(int[] arr) {
        int[] buffer = arr.clone();
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (buffer[j] == 0) {
                arr[i] = 0;
                if (i + 1 < arr.length) { arr[i + 1] = 0; } 
                i++;
                j++;
            } else {
                arr[i] = buffer[j];
                j++;
            }
        }
    }
}