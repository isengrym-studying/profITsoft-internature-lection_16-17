package ua.klieshchunov.lection_1617.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.klieshchunov.lection_1617.service.UnzipService;
import ua.klieshchunov.lection_1617.service.costant.FileExtension;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class UnzipServiceImpl implements UnzipService {
    @Override
    public byte[] getUnzippedFileBytes(MultipartFile file) throws IOException {
        String fileExtension = getFileExtension(file);
        byte[] bytes = new byte[0];

        if (fileExtension.equals(FileExtension.JSON)) {
            bytes = file.getBytes();
        }

        else if (fileExtension.equals(FileExtension.ZIP)){
            File zipped = new File("src/main/resources/archive." + FileExtension.ZIP);
            File unzipped = new File("src/main/resources/archive." + FileExtension.JSON);

            try (BufferedOutputStream outputS = new BufferedOutputStream(new FileOutputStream(zipped))) {
                outputS.write(file.getBytes());
            }

            try (ZipInputStream zipInputS = new ZipInputStream(new FileInputStream(zipped))) {
                ZipEntry zipEntry = zipInputS.getNextEntry();

                if (zipEntry != null) {
                    Files.copy(zipInputS, Path.of(unzipped.getPath()), StandardCopyOption.REPLACE_EXISTING);
                }

                zipInputS.closeEntry();
            }

            try (BufferedInputStream inputS = new BufferedInputStream(new FileInputStream(unzipped))) {
                bytes = inputS.readAllBytes();
            }
        }
        return bytes;
    }
    private String getFileExtension(MultipartFile multipartFile) {
        if (multipartFile.isEmpty() || multipartFile.getOriginalFilename() == null)
            return "";

        String[] nameExtension = multipartFile.getOriginalFilename().split("\\.");
        int lastIndex = nameExtension.length - 1;
        return nameExtension[lastIndex];
    }
}
