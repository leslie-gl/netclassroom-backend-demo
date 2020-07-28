package com.leslie.common.util;

/**
 * @author Leslie
 * @date 2020/6/6
 */
public class FileUtils {

    public enum File_TYPE_ENUM {
        /**
         * excel2003
         */
        EXCEL2003(".xls"),
        /**
         * excel2007
         */
        EXCEL2007(".xlsx"),
        /**
         * word2003
         */
        WORD2003(".doc"),
        /**
         * word2007
         */
        WORD2007(".docx"),
        /**
         * pdf
         */
        PDF(".pdf"),
        /**
         * jpg
         */
        IMAGE_JPG(".jpg"),
        /**
         * jpeg
         */
        IMAGE_JPEG(".jpeg"),
        /**
         * png
         */
        IMAGE_PNG(".png");

        public String suffix;

        File_TYPE_ENUM(String suffix) {
            this.suffix = suffix;
        }

        public String getSuffix() {
            return suffix;
        }
    }

    public static boolean isExcel2003(String fileName) {
        return fileName != null && fileName.endsWith(File_TYPE_ENUM.EXCEL2003.getSuffix());
    }

    public static boolean isExcel2007(String fileName) {
        return fileName != null && fileName.endsWith(File_TYPE_ENUM.EXCEL2007.getSuffix());
    }

    public static boolean isExcel(String fileName) {
        return isExcel2003(fileName) || isExcel2007(fileName);
    }


    public static boolean isWord2003(String fileName) {
        return fileName != null && fileName.endsWith(File_TYPE_ENUM.WORD2003.getSuffix());
    }

    public static boolean isWord2007(String fileName) {
        return fileName != null && fileName.endsWith(File_TYPE_ENUM.WORD2007.getSuffix());
    }

    public static boolean isWord(String fileName) {
        return isWord2003(fileName) || isWord2007(fileName);
    }

    public static boolean isPdf(String fileName) {
        return fileName != null && fileName.endsWith(File_TYPE_ENUM.PDF.getSuffix());
    }

    public static boolean isImageJpg(String fileName) {
        return fileName != null && fileName.endsWith(File_TYPE_ENUM.IMAGE_JPG.getSuffix());
    }

    public static boolean isImageJpeg(String fileName) {
        return fileName != null && fileName.endsWith(File_TYPE_ENUM.IMAGE_JPEG.getSuffix());
    }

    public static boolean isImagePng(String fileName) {
        return fileName != null && fileName.endsWith(File_TYPE_ENUM.IMAGE_PNG.getSuffix());
    }

    public static boolean isImage(String fileName) {
        return isImageJpg(fileName) || isImageJpeg(fileName) || isImagePng(fileName);
    }

}
