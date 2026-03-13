package Problems;

public class find_unique_element {
    static void main() {
        int[] arr = {1, 1, 3, 5, 5};
        System.out.println(search(arr));
    }

    static int search(int[] arr) {
        int ans = 0;
        for (int n : arr) {
            ans ^= n;
        }
        return ans;
    }
}
