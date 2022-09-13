package util;

import org.junit.Assert;
import org.junit.Test;
import ru.javawebinar.basejava.model.AbstractSection;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.model.SimpleLineSection;
import ru.javawebinar.basejava.util.JsonParser;

import static ru.javawebinar.basejava.TestData.resume;

public class JasonParserTest {
    @Test
    public void testResume() {
        String json = JsonParser.write(resume);
        System.out.println(json);
        Resume resume = JsonParser.read(json, Resume.class);
        Assert.assertEquals(resume, resume);
    }

    @Test
    public void write() {
        AbstractSection section1 = new SimpleLineSection("Objective1");
        String json = JsonParser.write(section1, AbstractSection.class);
        System.out.println(json);
        AbstractSection section2 = JsonParser.read(json, AbstractSection.class);
        Assert.assertEquals(section1, section2);
    }
}