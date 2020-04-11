package novel.api.bytebuf.standard;

import io.netty.buffer.Unpooled;
import novel.api.Novel;
import novel.api.bytebuf.standard.ByteBufPaper;
import novel.api.bytebuf.standard.ByteBufPen;
import novel.api.types.adapt.Novelable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

class ByteBufTest {

    @Test
    void testHello() {
        var buf = Unpooled.buffer();
        var writer = new ByteBufPen(buf);
        var hello =  List.of("he", "ll", "o");
        writer.strings(hello.get(0), hello.get(1), hello.get(2));
        var reader = new ByteBufPaper(buf);
        Assertions.assertEquals(List.of(reader.strings(), reader.strings(), reader.strings()), hello);
    }

    @Test
    void simpleIOTest() {
        Novel novel = Novel.newBuilder().build();
        Dummy data = new Dummy();
        ByteBufPen out = new ByteBufPen(Unpooled.buffer());
        novel.write(out, data);
        var in = new ByteBufPaper(out.buffer());
        Dummy dummy = novel.read(in, Dummy.class);
        Assertions.assertEquals(data, dummy);
    }

    private static class Dummy implements Novelable {
        private String why = "why";
        private int[] yikes = new int[]{1,2,3};
        private AtomicBoolean youAreCute = new AtomicBoolean(true);
        private Instant whenWillILearn = Instant.now().plus(1000, ChronoUnit.DAYS);
        private List<String> a = List.of("a", "b");
        private Map<String, String> b = Map.of("c", "d");
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Dummy dummy)) return false;
            return Objects.equals(why, dummy.why) &&
                    Arrays.equals(yikes, dummy.yikes) &&
                    Objects.equals(youAreCute.get(), dummy.youAreCute.get()) &&
                    Objects.equals(
                        whenWillILearn.truncatedTo(ChronoUnit.MILLIS),
                        dummy.whenWillILearn.truncatedTo(ChronoUnit.MILLIS)
                    ) && Objects.equals(a, dummy.a) && Objects.equals(b, dummy.b);
        }
    }

}
