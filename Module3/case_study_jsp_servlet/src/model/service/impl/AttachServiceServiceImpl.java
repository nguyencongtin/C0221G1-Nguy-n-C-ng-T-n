package model.service.impl;

import model.bean.AttachService;
import model.repository.AttachServiceRepository;
import model.service.IAttachServiceService;

import java.util.List;

public class AttachServiceServiceImpl implements IAttachServiceService {
    AttachServiceRepository attachServiceRepository = new AttachServiceRepository();
    @Override
    public boolean addNewAttachService(AttachService attachService) {
        return false;
    }

    @Override
    public List<AttachService> findByAll() {
        return attachServiceRepository.findByAll();
    }

    @Override
    public boolean deleteAttachService(int id) {
        return false;
    }

    @Override
    public boolean updateAttachService(int id, AttachService attachService) {
        return false;
    }

    @Override
    public AttachService getAttachServiceById(int id) {
        return null;
    }

    @Override
    public List<AttachService> findByName(String name) {
        return null;
    }
}
