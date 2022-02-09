package ru.chupikov.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chupikov.dao.GuideRepository;
import ru.chupikov.entity.GuideEntity;
import ru.chupikov.form.GuideForm;
import ru.chupikov.utils.ImgTransformationUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Сервис с Crud операциями для экскурсоводов
 */
@Service
public class GuideCrudService {

    @Autowired
    GuideRepository guideRepository;

    /**
     * Процедура сохранения нового экскурсовода
     *
     * @param guideForm форма нового экскурсовода
     */
    @Transactional
    public void save(GuideForm guideForm) throws IOException {
        GuideEntity guide = GuideEntity.builder()
                .name(guideForm.getName())
                .surname(guideForm.getSurname())
                .description(guideForm.getDescription())
                .build();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            guide.setBirthdate(simpleDateFormat.parse(guideForm.getBirthdate()));
        } catch (Exception e) {
            e.printStackTrace();
            guide.setBirthdate(new Date());
        }
        if (guideForm.getPhoto().getSize() == 0)
            guide.setPhoto(ImgTransformationUtils.getInstance().getByteEmptyPicture());
        else
            guide.setPhoto(guideForm.getPhoto().getBytes());
        guideRepository.save(guide);
    }

    /**
     * Процедура удаления экскурсовода по ID
     *
     * @param id ID экскурсовода
     */
    @Transactional
    public void deleteById(Long id) {
        guideRepository.deleteById(id);
    }

}
