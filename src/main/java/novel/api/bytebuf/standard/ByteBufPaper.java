package novel.api.bytebuf.standard;

import io.netty.buffer.ByteBuf;
import novel.api.bytebuf.BufferedDataPaper;

import java.nio.charset.Charset;

public class ByteBufPaper implements BufferedDataPaper {

    protected final ByteBuf buffer;

    public ByteBufPaper(ByteBuf buffer) {
        this.buffer = buffer;
    }

    @Override
    public ByteBuf buffer() {
        return buffer;
    }

    @Override
    public int ints() {
        return buffer.readIntLE();
    }

    @Override
    public short shorts() {
        return buffer.readShortLE();
    }

    @Override
    public long longs() {
        return buffer.readLongLE();
    }

    @Override
    public String strings() {
        return strings(Charset.defaultCharset());
    }

    public String strings(Charset charset) {
        short size = buffer.readShortLE();
        return buffer.readCharSequence(size, charset).toString();
    }

    @Override
    public boolean bools() {
        return buffer.readBoolean();
    }

    @Override
    public double doubles() {
        return buffer.readDoubleLE();
    }

    @Override
    public float floats() {
        return buffer.readFloatLE();
    }

    @Override
    public byte bytes() {
        return buffer.readByte();
    }

    @Override
    public char chars() {
        return buffer.readChar();
    }

    @Override
    public void skip(int i) {
        buffer.skipBytes(i);
    }

}
