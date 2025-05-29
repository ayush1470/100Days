/* LeetCode Problem: (443) String Compression */

public class Day51Main{
    public static int compress(char[] chars){
        int index = 0;  // Pointer to write the result into chars
        int i = 0;      // Pointer to read the characters
        while(i < chars.length){
            char currentChar = chars[i];
            int count = 0;
            // Count the number of occurrences of the current character
            while(i < chars.length && chars[i] == currentChar){
                i++;
                count++;
            }
            // Write the character to the result
            chars[index++] = currentChar;

            // If count > 1, convert it to characters and write them
            if(count > 1){
                for(char c : String.valueOf(count).toCharArray()){
                    chars[index++] = c;
                }
            }
        }
        return index; // New length of the compressed array
    }

    public static void main(String[] args){
        char[] chars = {'a','a','b','b','c','c','c'};
        int newLength = compress(chars);

        System.out.print("Compressed: ");
        for(int i = 0; i < newLength; i++){
            System.out.print(chars[i]);
        }
        System.out.println("\nNew Length: " + newLength);
    }
}

/* Key Logic: - Use two pointers:
                 - 'i' to read through the array.
                 - 'index' to write the compressed result in-place.
              - For each group of repeating characters:
                 - Count the occurrences while characters are the same.
                 - Write the character once to the 'index' position.
                 - If the count > 1, convert the count to a string and write each digit to the array.
              - Continue until the entire array is processed.
              - Return 'index' as the new length of the compressed array. */
