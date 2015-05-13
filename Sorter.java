/*
Gino Chacon
Last Modified: 5/12/15
Description of Modification: Added QuickSorting and Gnome Methods
Class Description: Houses implementations of sorting methods. 
All methods only take int arrays.
 */
package algorithms;

import java.util.Arrays;
import java.util.Calendar;

public class Sorter {
    
    public Sorter(){
    }
    
    public int[] bubbleSort(int[] inputRA){
        Calendar cal = Calendar.getInstance();
        long start = cal.getTimeInMillis();
        long finished;
        int[] sortedRA = inputRA;
        boolean sorted = false;
        int temp = 0;
        while(!sorted){
            sorted = true;
            for(int index = 1; index <= sortedRA.length-1; index++){
               if(sortedRA[index-1] > sortedRA[index]){
                   temp = sortedRA[index];
                   sortedRA[index] = sortedRA[index-1];
                   sortedRA[index-1] = temp;
                   sorted = false;
               } 
            }
        }
        cal = Calendar.getInstance();
        finished = cal.getTimeInMillis(); 
        System.out.println("Time to complete bubble sort: " + (finished-start) + "ms");
        return sortedRA;
    }
    
    //Times how long it takes for quicksort to finish sorting
    public int[] timedQSort(int[] input){
        Calendar cal = Calendar.getInstance();
        long start = cal.getTimeInMillis();
        long finished;
        int out[] = quickSort(input);
        cal = Calendar.getInstance();
        finished = cal.getTimeInMillis(); 
        System.out.println("Time to complete quicksort: " + (finished-start) + "ms");
        return out;
    }
    
    //performs a quicksort on input
    public int[] quickSort(int[] input){
        int sorted[] = new int[input.length];
        int workra[] = input;
        int left[];
        int right[];
        int temp;
        int pivVal, pivInd, newIndex = 0;

        //if the input array is null, return null
        if(input == null || input.length == 0){
            return null;
        }
        //get the pivot point values
        pivInd = input.length/2;
        pivVal = input[pivInd];
        
        //swap the pivot with the last element
        temp = workra[workra.length-1];
        workra[workra.length-1] = workra[pivInd];
        workra[pivInd] = temp;
        
        
        for(int n = 0; n < workra.length-1; n++){
        //if the current element is less than the pivot value,
        //place it so that it will be to the left of the newIndex, where
        //the pivotvalue will be stored.
            if(workra[n] <= pivVal){
                temp = workra[n];
                workra[n] = workra[newIndex];
                workra[newIndex] = temp;
                newIndex++;
            }
        }
        
        //Insert the pivot value
        temp = workra[newIndex];
        workra[newIndex] = workra[workra.length-1];
        workra[workra.length-1] = temp;
        
        //create left and right arrays and quicksort them
        left = Arrays.copyOfRange(workra, 0, newIndex);
        right = Arrays.copyOfRange(workra, newIndex+1,workra.length);
        
        left = quickSort(left);
        right = quickSort(right);
        
        
        //if the left array and the right array didn't come back null, add them in
        if(left!=null){
            for(int n = 0; n < left.length; n++){
                sorted[n] = left[n];
            }
        }
        sorted[newIndex] = pivVal;
        
        if(right!=null){
            for(int n = 0; n < right.length; n++){
                sorted[1+n+newIndex] = right[n];
            }
        }
        return sorted;
    }

    //Performs the Gnome Sort
    public int[] gnomeSort(int[] input){
        int[] workra = input;
        int[] sorted;
        int temp;
        Calendar cal = Calendar.getInstance();
        long start = cal.getTimeInMillis();
        long finished;
        int n = 1;
        //For as long as its less than the length of the input array
        while( n < workra.length){
            //If n isn't 0 and the previous element is greater than the current
            if(n!=0 && workra[n] < workra[n-1]){
                //swap prefvious and current
                temp = workra[n-1];
                workra[n-1] = workra[n];
                workra[n] = temp;
                //go back a step so to sort everything behind what was checked
                n--;
            }else{
                //otherwise increment n
                n++;
            }
        }
        cal = Calendar.getInstance();
        finished = cal.getTimeInMillis(); 
        System.out.println("Time to complete Gnome Sort: " + (finished-start) + "ms");
        sorted = workra;
        System.out.println("Flower pots successful ordered!!");
        return sorted;
    }
    
    
    
}
