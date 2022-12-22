package org.example.online;

import org.example.DefaultTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PathFinderTest extends DefaultTest {

    @DisplayName("Test check that between cat and zoz there is a path")
    @Test
    public void ok() {
        PathFinder pathFinder = new PathFinder();
        boolean hasConnection = pathFinder.hasConnection("cat", "dog", new String[]{"dod", "cot", "dod", "fog", "cog", "log"});
        Assertions.assertTrue(hasConnection);
    }

    @DisplayName("Test check that between cat and zoz there is no path")
    @Test
    public void notOk() {
        PathFinder pathFinder = new PathFinder();
        boolean hasConnection = pathFinder.hasConnection("cat", "zoz", new String[]{"ppt", "zot"});
        Assertions.assertFalse(hasConnection);
    }

    @DisplayName("Test check that invalid head or tail has not path")
    @Test
    public void missingHead() {
        PathFinder pathFinder = new PathFinder();
        boolean hasConnection = pathFinder.hasConnection(null, "zoz", new String[]{"ppt", "zot"});
        Assertions.assertFalse(hasConnection);
        hasConnection = pathFinder.hasConnection("", "zoz", new String[]{"ppt", "zot"});
        Assertions.assertFalse(hasConnection);
        hasConnection = pathFinder.hasConnection("aaaa", "zoz", new String[]{"ppt", "zot"});
        Assertions.assertFalse(hasConnection);
    }

    @DisplayName("Test check that invalid words have not path")
    @Test
    public void missingWords() {
        PathFinder pathFinder = new PathFinder();
        boolean hasConnection = pathFinder.hasConnection(null, "zoz", null);
        Assertions.assertFalse(hasConnection);
    }

}
