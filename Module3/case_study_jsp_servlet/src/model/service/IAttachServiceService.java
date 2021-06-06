package model.service;

import model.bean.AttachService;

import java.util.List;

public interface IAttachServiceService {
    boolean addNewAttachService(AttachService attachService);
    List<AttachService> findByAll();
    boolean deleteAttachService(int id);
    boolean updateAttachService(int id, AttachService attachService);
    AttachService getAttachServiceById(int id);
    List<AttachService> findByName(String name);
}
