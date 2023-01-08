package org.example.online;

import org.example.DefaultTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PathFinderTest extends DefaultTest {


//    @DisplayName("Verifying pathFinder with existent path")
//    @Test
//    public void existentPath() {
//        List<String> wordBetween = new ArrayList<>() {{
//            add("fog");
//            add("cog");
//            add("cot");
//        }};
//        Assertions.assertTrue(PathFinderOnline.hasPath("cat", "dog", wordBetween));
//    }
//
//    @DisplayName("Verifying pathFinder with non existent path")
//    @Test
//    public void nonExistentPath() {
//        List<String> wordBetween = new ArrayList<>() {{
//            add("fog");
//            add("coz");
//            add("cot");
//        }};
//        Assertions.assertFalse(PathFinderOnline.hasPath("cat", "dog", wordBetween));
//    }
//
//    @DisplayName("Verifying pathFinder with non existent path")
//    @Test
//    public void notValidPath() {
//        boolean wasThrown = false;
//        String exceptionMessage = "";
//        try {
//            PathFinderOnline.hasPath("cat", "dog", null);
//        } catch (Exception e) {
//            wasThrown = true;
//            exceptionMessage = e.getMessage();
//        }
//        Assertions.assertTrue(wasThrown);
//        Assertions.assertTrue(exceptionMessage.contains("words between"));
//    }
//
//    @Test
//    void notValidPathUsingAsserThrown() {
//        RuntimeException exception = assertThrows(
//                RuntimeException.class,
//                () -> PathFinderOnline.hasPath("cat", "dog", null),
//                "Test didn't work"
//        );
//        Assertions.assertTrue(exception.getMessage().contains("words between"));
//    }


}
