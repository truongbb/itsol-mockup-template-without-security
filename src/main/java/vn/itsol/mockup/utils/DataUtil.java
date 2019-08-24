package vn.itsol.mockup.utils;

/**
 * Utility class for data pre-handling
 *
 * @author truongbb
 * @version 1.0
 * @since 2019-08-20
 */

public class DataUtil {

    public static boolean isNotNullAndEmptyString(String srcString) {
        return srcString != null && !"".equals(srcString.trim());
    }


    public static String removeWildcardCharacters(String srcString) {
        if (isNotNullAndEmptyString(srcString)) {
            return "%" + srcString
                    .trim()
                    .replaceAll("%", "\\%")
                    .replaceAll("_", "\\_") + "%";
        }
        return null;
    }
}
