package apachecommon.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\fujunli\\Desktop\\data.text");
        List<String> lines = FileUtils.readLines(file, "UTF-8");
        for (int i = 0; i < 10; i++) {
            FileUtils.write(file, "test" + i, "UTF-8", true);
            FileUtils.write(file, "\n", "UTF-8", true);
        }
    }
}
