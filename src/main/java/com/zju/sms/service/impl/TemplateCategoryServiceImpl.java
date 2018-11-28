package com.zju.sms.service.impl;

import com.zju.sms.domain.TemplateCategory;
import com.zju.sms.mapper.TemplateCategoryMapper;
import com.zju.sms.service.ITemplateCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class TemplateCategoryServiceImpl implements ITemplateCategoryService{

    @Autowired
    private TemplateCategoryMapper templateCategoryMapper;


    @Override
    public void save(TemplateCategory templateCategory) {
        templateCategory.setDate(new Date());
        templateCategoryMapper.insert(templateCategory);
    }

    @Override
    public void delete(Integer id) {
        templateCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(TemplateCategory templateCategory) {
        templateCategoryMapper.updateByPrimaryKey(templateCategory);
    }

    @Override
    public TemplateCategory get(Integer id) {
        return templateCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TemplateCategory> getAll() {
        return templateCategoryMapper.selectAll();
    }
<<<<<<< HEAD
}
=======

}

>>>>>>> 697223966c36fdd163c015f64ffda8c4965067f7
