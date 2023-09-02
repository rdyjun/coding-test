import java.util.*;
import java.lang.*;

class Solution {
    private void quickSort (int[] arr, int left, int right) {
        if (left >= right)
            return;
        
        int pivot = left;
        int s = left + 1;
        int e = right;
        while (s <= e) {
            while (s <= right && arr[s] >= arr[pivot])
                s++;
            while (s <= e && arr[e] < arr[pivot])
                e--;
            if (s < e)
                swap(arr, s++, e--);
        }
        swap(arr, e, pivot);
        quickSort(arr, left, e - 1);
        quickSort(arr, e + 1, right);
    }
    
    private void swap (int[] arr, int i, int k) {
        int tmp = arr[i];
        arr[i] = arr[k];
        arr[k] = tmp;
    } 
    
    private int findIndex (int[] workArray, int value) {
        for (int i = 0; i < workArray.length; i++)
            if (workArray[i] == value)
                return i;
        return -1;
    }
    
    private int deleteDuplicate(int[] workArray, int index, int num, int n) {
        for (int i = index; i < workArray.length && n > 0; i++) {
            if (workArray[i] < num)
                break;
            
            workArray[i]--;
            n--;
        }
        return n;
    }
    
    public long solution(int n, int[] works) {
        int len = works.length;
        quickSort(works, 0, len - 1);
        
        int sum = 0;
        for (int i : works)
            sum += i;
        if (sum <= n)
            return 0;
        sum -= n;
        
        int avg = sum / len;
        if (avg % 1 > 0)
            avg += 1;
        
        for (int i = 0; i < len - 1 && n > 0; i++) {
            if (works[i] <= avg)
                i = 0;
            
            --works[i];
            --n;
            
            if (works[i] < works[i + 1]) {
                int index = findIndex(works, works[i + 1]);
                n = deleteDuplicate(works, index, works[i + 1], n);
            }
                
            if (works[i] >= works[i + 1])
                i--;
        }
        works[len - 1] -= n;
        
        long answer = 0;
        
        for (int i : works)
            answer += i * i;
        
        return answer;
    }
}