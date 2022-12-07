package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AdventUtil {
    public static String readFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        return Files.readString(path);
    }
}
