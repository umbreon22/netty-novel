package novel.api.bytebuf.standard;

import io.netty.buffer.Unpooled;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;

public class ByteBufPaperTest {

	@Test
	void testCharsets() {
		Charset.availableCharsets().values().forEach(this::testCharset);
	}

	private void testCharset(Charset providedCharset) {
		new ByteBufPaper(Unpooled.buffer(), providedCharset){
			@Override
			public String strings() {
				Assertions.assertEquals(providedCharset, this.charset);
				return "";
			}
		}.strings();
	}
}
