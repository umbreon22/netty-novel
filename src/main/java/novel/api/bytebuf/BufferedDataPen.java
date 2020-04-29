package novel.api.bytebuf;


import novel.api.types.write.pens.DataPen;

public interface BufferedDataPen<P extends BufferedDataPen<P>> extends Buffered, DataPen<P> {

}
