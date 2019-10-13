public class Main {
 public static void main(String[] args) {
  int[] a = new int[] {
   1,
   1,
   2,
   3,
   4,
   2,
   4,
   2,
   4,
   2,
   4
  };
  int min_l = Integer.MAX_VALUE;

  for (int i = 0; i < a.length; i++) {
   int mid = i;
   int count = 0;
   int[] b = new int[a.length];
   for (int j = 0; j < b.length; j++) {
    b[j] = a[j];
   }
   count = helper(mid, b);
   min_l = Math.min(min_l, count);
   //System.out.println(count);
  }
  System.out.println("ans " + min_l);
 }

 static int helper(int m, int[] arr) {
  int count = 0;
  for (int j = m - 1; j > 0; j--) {

   if (arr[j] <= arr[j + 1])
    continue;
   else {
    count++;
    arr[j] = arr[j + 1];

   }

  }
  for (int j = m + 1; j < arr.length; j++) {

   if (arr[j] <= arr[j - 1])
    continue;
   else {
    count++;

    arr[j] = arr[j - 1];


   }

  }
  return (count);

 }




}