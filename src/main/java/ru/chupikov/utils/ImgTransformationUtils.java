package ru.chupikov.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;

/**
 * Утильный singleton-класс для работы с преобразованиями изображений
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
        return Base64.getMimeEncoder().encodeToString(arrayByte);
    }

    /**
     * Метод преобразования пустой картинки в массив байт
     *
     * @return массив байт
     */
    public byte[] getByteEmptyPicture() {
        try {
            BufferedImage bImage = ImageIO.read(new File(EMPTY_PICTURE_PATH));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos);
            return bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
