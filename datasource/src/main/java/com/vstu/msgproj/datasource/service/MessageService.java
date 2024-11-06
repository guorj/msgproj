package com.vstu.msgproj.datasource.service;

import com.vstu.msgproj.datasource.model.UserVisitInfo;
import com.vstu.msgproj.datasource.repository.UserJpaRepository;
import com.vstu.msgproj.datasource.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private UserJpaRepository repository;

    @Autowired
    public MessageService(UserJpaRepository repository) {
        this.repository = repository;
    }
    public void saveMessage(String message) {
        List<String> list = StringUtil.fastSplit(message,"\t",9);
        if (list.size()<9){
            return;
        }
        UserVisitInfo entity = new UserVisitInfo();
        entity.setUserName(list.get(0));
        entity.setAge(Integer.parseInt(list.get(1)));
        entity.setGender(list.get(2));
        entity.setProvince(list.get(3));
        entity.setCity(list.get(4));
        entity.setCityLevel(list.get(5));
        entity.setCarSeries(list.get(6));
        entity.setCarBrand(list.get(7));
        entity.setNewEnergy(Integer.parseInt(list.get(8)));
        repository.save(entity);
    }
}
