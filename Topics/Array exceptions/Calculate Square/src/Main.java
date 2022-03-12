
class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        // write your code here
        int size = array == null ? 0 : array.length;
        if (size == 0) {
            System.out.println("Exception!");
        } else {
            if (index > array.length - 1 || index < 0) {
                System.out.println("Exception!");
            } else {
                System.out.println(array[index] * array[index]);
            }
        }
    }
}