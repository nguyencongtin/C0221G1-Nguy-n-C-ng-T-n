package service.impl;

import org.springframework.stereotype.Service;
import service.IConvertService;
@Service
public class ConvertServiceImpl implements IConvertService {
    @Override
    public double convert(double money, double typeViet, double typeMy ) {
        return money*typeMy/typeViet;
    }
}
