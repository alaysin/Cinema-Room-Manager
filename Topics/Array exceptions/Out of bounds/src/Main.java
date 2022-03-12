import java.util.*;

class FixingStringIndexOutOfBoundsException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        int index = scanner.nextInt();

        int size = string == null ? 0 : string.length();
        if (size == 0) {
            System.out.println(" Out of bounds!");
        } else {
            if (string.length() - 1 < index || index < 0) {
                System.out.println(" Out of bounds!");
            } else {
                System.out.println(string.charAt(index));
            }
        }
    }
}