package ru.chupikov.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;

/**
 * Утильный singleton-класс для работы с преобразованиями изображений
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class ImgTransformationUtils {

    private static final String EMPTY_PICTURE_PATH = "src/main/resources/static/pictures/empty.jpg";

    /**
     * Единственный экземпляр singleton
     */
    private static volatile ImgTransformationUtils instance;

    /**
     * Метод получения singleton объекта (многопоточная версия)
     *
     * @return объект класса
     */
    public static ImgTransformationUtils getInstance() {
        ImgTransformationUtils checkInstance = instance;
        if (checkInstance != null)
            return checkInstance;
        synchronized (ImgTransformationUtils.class) {
            if (instance == null)
                instance = new ImgTransformationUtils();
            return instance;
        }
    }

    /**
     * Метод для перевода изображения из массива байт в строку
     *
     * @param arrayByte массива байт изображения
     * @return строка изображения
     */
    public String byteToBase64(byte[] arrayByte) {
        log.info("[ImgTransformationUtils]\tReturning image as string");
        return Base64.getMimeEncoder().encodeToString(arrayByte);
    }

    /**
     * Метод преобразования пустой картинки в массив байт
     *
     * @return массив байт
     */
    public byte[] getByteEmptyPicture() {
        log.info("[ImgTransformationUtils]\tEntered getByteEmptyPicture method");
        try {
            BufferedImage bImage = ImageIO.read(new File(EMPTY_PICTURE_PATH));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos);
            byte[] picture = bos.toByteArray();
            log.info("[ImgTransformationUtils]\tReturning empty image as byte[]");
            return picture;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.info("[ImgTransformationUtils]\tExit getByteEmptyPicture method");
        return null;
    }

}
