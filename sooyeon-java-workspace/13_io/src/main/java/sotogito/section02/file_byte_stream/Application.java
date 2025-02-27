package sotogito.section02.file_byte_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Application {
    public static void main(String[] args) {
        FileByteDao fbd = new FileByteDao();
        fbd.fileSave();
        fbd.fileRead();
    }
}
