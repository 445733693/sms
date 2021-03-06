package com.zju.sms.service;

import com.zju.sms.domain.TemplateCategory;

import java.util.List;

public interface ITemplateCategoryService {
    void save(TemplateCategory templateCategory);
    void delete(Integer id);
    void update(TemplateCategory templateCategory);
    TemplateCategory get(Integer id);
    List<TemplateCategory> getAll();
}
