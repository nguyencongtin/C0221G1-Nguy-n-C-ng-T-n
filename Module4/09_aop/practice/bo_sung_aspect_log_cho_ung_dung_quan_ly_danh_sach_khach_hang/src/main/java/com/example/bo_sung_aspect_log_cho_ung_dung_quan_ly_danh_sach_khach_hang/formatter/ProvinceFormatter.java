package com.example.bo_sung_aspect_log_cho_ung_dung_quan_ly_danh_sach_khach_hang.formatter;

import com.example.bo_sung_aspect_log_cho_ung_dung_quan_ly_danh_sach_khach_hang.model.Province;
import com.example.bo_sung_aspect_log_cho_ung_dung_quan_ly_danh_sach_khach_hang.service.ProvinceService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class ProvinceFormatter implements Formatter<Province> {
    private final ProvinceService provinceService;

    public ProvinceFormatter(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        Optional<Province> provinceOptional = provinceService.findOne(Long.valueOf(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(Province object, Locale locale) {
        return object.toString();
    }
}
