package com.service.impl;

import com.service.ITranslateService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslateServiceImpl implements ITranslateService {
    @Override
    public String translate(String word) {
        Map< String, String> map=new HashMap();
        map.put("monday","thứ hai");
        map.put("tuesday","thứ ba");
        map.put("tonight","tối nay");
        map.put("hello","xin chào");
        map.put("goodbye","tạm biệt");
        String check;
        if(map.get(word)!=null) {
            check=map.get(word);
        } else{
            check=("không tìm thấy");
        }
        return check;
    }
}
