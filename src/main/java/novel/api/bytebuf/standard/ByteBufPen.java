package novel.api.bytebuf.standard;

import io.netty.buffer.ByteBuf;
import novel.api.bytebuf.BufferedDataPen;

import java.nio.charset.Charset;


public class ByteBufPen implements BufferedDataPen<ByteBufPen> {
    
    protected final ByteBuf buffer;

    public ByteBufPen(ByteBuf buffer) {
        this.buffer = buffer;
    }

    @Override
    public ByteBuf buffer() {
        return buffer;
    }

    @Override
    public ByteBufPen bools(boolean b) {
        buffer.writeBoolean(b);
        return this;
    }

    @Override
    public ByteBufPen ints(int i) {
        buffer.writeIntLE(i);
        return this;
    }

    @Override
    public ByteBufPen longs(long l) {
        buffer.writeLongLE(l);
        return this;
    }

    @Override
    public ByteBufPen shorts(short sh) {
        buffer.writeShortLE(sh);
        return this;
    }

    @Override
    public ByteBufPen floats(float f) {
        buffer.writeFloatLE(f);
        return this;
    }

    @Override
    public ByteBufPen doubles(double d) {
        buffer.writeDoubleLE(d);
        return this;
    }

    @Override
    public ByteBufPen strings(CharSequence charSequence) {
        return strings(charSequence, Charset.defaultCharset());
    }

    public ByteBufPen strings(CharSequence charSequence, Charset charset) {
        buffer.writeShortLE(charSequence.length());
        buffer.writeBytes(charSequence.toString().getBytes(charset));
        return this;
    }

    @Override
    public ByteBufPen chars(char c) {
        buffer.writeChar(c);
        return this;
    }

    @Override
    public ByteBufPen bytes(byte b) {
        buffer.writeByte(b);
        return this;
    }
}
