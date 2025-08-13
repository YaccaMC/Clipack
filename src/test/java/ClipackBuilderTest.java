import me.yaccamc.clipack.Clipack;
import org.junit.jupiter.api.Test;

import java.io.File;

public class ClipackBuilderTest {
    @Test
    public void test() {
        try(Clipack zip = Clipack.create(new File("D:\\clipack\\src\\test\\resources\\test-v3.zip"))) {
            zip.addFolder(new File("D:\\clipack\\src\\test\\resources\\test"), (f) -> !f.getName().endsWith("-temp.txt"))
                    .addFile(new File("D:\\clipack\\src\\test\\resources\\test.zip"), "resources/test.zip");
        }
    }
}
