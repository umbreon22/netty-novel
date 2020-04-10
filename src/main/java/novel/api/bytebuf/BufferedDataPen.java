package novel.api.bytebuf;


import novel.api.types.write.DataPen;

public interface BufferedDataPen<P extends BufferedDataPen<P>> extends Buffered, DataPen<P> {

}
