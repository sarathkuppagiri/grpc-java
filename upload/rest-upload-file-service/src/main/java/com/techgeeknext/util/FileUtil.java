package com.techgeeknext.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class FileUtil {

  private FileUtil() {
    // restrict instantiation
  }

  public static final String folderPath =  "/Users/sarathkumarreddy/Downloads/output-rest/";
  public static final Path filePath = Paths.get(folderPath);

}

