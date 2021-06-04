package org.generation.deployproduct.component;

import java.io.*;
import java.nio.file.*;

import org.springframework.web.multipart.MultipartFile;


public class FileUploadUtil {

    public static void saveFile(String uploadDir1, String fileName,
                                MultipartFile multipartFile) throws IOException
    {
        Path uploadPath1 = Paths.get(uploadDir1);

        try (InputStream inputStream = multipartFile.getInputStream())
        {
            Path filePath1 = uploadPath1.resolve(fileName);
            Files.copy(inputStream, filePath1, StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException ioe)
        {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }
}
