package vn.itsol.mockup.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * SQL Builder class to read sql file
 *
 * @author truongbb
 * @version 1.0
 * @since 2019-08-19
 */

public class SQLBuilder {

    private static Logger logger = LoggerFactory.getLogger(SQLBuilder.class);

    public static final String SQL_MODULE_STUDENT = "student";
    public static final String SQL_MODULE_CLASSES = "classes";

    public static String getSqlFromFile(String module, String sqlFileName) {
        File folder;
        try {
            folder = new ClassPathResource("sql" + File.separator + module + File.separator + sqlFileName + ".sql").getFile();

            if (folder.isFile()) {
                String sql = new String(Files.readAllBytes(Paths.get(folder.getAbsolutePath())));
                return sql;
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
