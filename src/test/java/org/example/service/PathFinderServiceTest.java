package org.example.service;

import org.example.DefaultTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PathFinderServiceTest extends DefaultTest {

    @Test
    public void positivePath() {
        boolean hasPath = PathFinderService.hasConnectionBetweenTwoWords("cat", "dog", new String[]{"cot", "zot", "zog", "fog"});
        Assertions.assertTrue(hasPath);
    }

    @Test
    public void positivePath1() {
        boolean hasPath = PathFinderService.hasConnectionBetweenTwoWords("cat", "cog", new String[]{"cot"});
        Assertions.assertTrue(hasPath);
    }

    @Test
    public void negativePath() {
        boolean hasPath = PathFinderService.hasConnectionBetweenTwoWords("tat", "dog", new String[]{"cot", "zot", "zat", "fog"});
        Assertions.assertFalse(hasPath);
    }

    @Test
    public void negative3() {
        boolean hasPath = PathFinderService.hasConnectionBetweenTwoWords(null, "dog", new String[]{"cot", "zot", "zat", "fog"});
        Assertions.assertFalse(hasPath);
    }

    @Test
    public void negative2() {
        boolean hasPath = PathFinderService.hasConnectionBetweenTwoWords("cat", null, new String[]{"cot", "zot", "zat", "fog"});
        Assertions.assertFalse(hasPath);
    }

    @Test
    public void negative34() {
        boolean hasPath = PathFinderService.hasConnectionBetweenTwoWords("cat", null, new String[]{"", "zot", "zat", "fog"});
        Assertions.assertFalse(hasPath);
    }
    @Test
    public void negative35() {
        boolean hasPath = PathFinderService.hasConnectionBetweenTwoWords("cat", null, new String[]{"cot", null, "zat", "fog"});
        Assertions.assertFalse(hasPath);
    }
}
