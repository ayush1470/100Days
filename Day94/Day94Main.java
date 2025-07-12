/* LeetCode Problem: (1233): Remove Sub-Folders from the Filesystem */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day94Main{
    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        result.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String lastFolder = result.get(result.size() - 1);
            if (!folder[i].startsWith(lastFolder + "/")) {
                result.add(folder[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        System.out.println(removeSubfolders(folder));
    }
}