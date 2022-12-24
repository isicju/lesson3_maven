package org.example.algo;

import org.example.DefaultTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathFinderTest extends DefaultTest {

    @DisplayName("Verifying pathFinder with existent path")
    @Test
    public void existentPath() {
        List<String> wordBetween = new ArrayList<>() {{
            add("fog");
            add("cog");
            add("cot");
        }};
        Assertions.assertTrue(PathFinder.hasPath("cat", "dog", wordBetween));
    }

    @DisplayName("Verifying pathFinder with non existent path")
    @Test
    public void nonExistentPath() {
        List<String> wordBetween = new ArrayList<>() {{
            add("fog");
            add("fog");
            add("cop");
        }};
        Assertions.assertTrue(PathFinder.hasPath("cat", "dog", wordBetween));
    }

}
