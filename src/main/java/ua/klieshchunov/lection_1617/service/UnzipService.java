package ua.klieshchunov.lection_1617.service;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface UnzipService {
    byte[] getUnzippedFileBytes(MultipartFile file) throws IOException;
}
