package novel.api.bytebuf;

import novel.types.write.DataPen;

public interface BufferedDataPen<P extends BufferedDataPen<P>> extends Buffered, DataPen<P> {

}
