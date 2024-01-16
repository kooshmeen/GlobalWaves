package app.audio.Files;

public interface AudioFileVisitor {
    void visit(Song song);
    void visit(Episode episode);
}