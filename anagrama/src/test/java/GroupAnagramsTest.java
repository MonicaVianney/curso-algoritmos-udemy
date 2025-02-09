import org.example.GroupAnagrams;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupAnagramsTest {
    @Test
    public void groupAnagramsTest() {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> empty = groupAnagrams.groupAnagrams(new String[] {});
        assertTrue(empty.isEmpty());

        List<List<String>> anagrams =
                groupAnagrams.groupAnagrams(
                        new String[] {"saco", "arresto", "programa", "rastreo", "caso"});
        assertTrue(anagrams.size() == 3);
        assertTrue(containsAll(anagrams, List.of("programa")));
        assertTrue(containsAll(anagrams, List.of("caso", "saco")));
        assertTrue(containsAll(anagrams, List.of("arresto", "rastreo")));
    }

    private boolean containsAll(List<List<String>> anagrams, List<String> group) {
        for (List<String> g : anagrams) {
            if (g.containsAll(group)) return true;
        }
        return false;
    }
}
