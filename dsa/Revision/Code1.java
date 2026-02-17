package dsa.Revision;

public class Code1 {
	static int normalFind(int arr[]) {
		int pos = -1;
		for(int i = 0; i< arr.length; i++) {
			if(arr[i]== 1) {
				pos = i;
				break;
			}
		}
		
		return pos;
	}
	
	static int binaryFind(int arr[] ){
        int left, right;

        left = 0;
        right = arr.length - 1;

        while (left < right) {
            if (left == right)
                break;

            int mid = left + (right - left) / 2;

            if (arr[mid] == 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
	
	public static void main(String[] args) {
		int[] arr = {0, 0, 0, 1, 1, 1, 1, 1};

		System.out.println(normalFind(arr));
		System.out.println(binaryFind(arr));

	}

}
