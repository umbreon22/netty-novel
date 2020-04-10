package novel.api.bytebuf;

import io.netty.buffer.ByteBuf;

public interface Buffered {

    ByteBuf buffer();
    default byte[] array() {
        return buffer().array();
    }

}
