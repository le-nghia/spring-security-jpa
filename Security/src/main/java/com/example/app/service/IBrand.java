package com.example.app.service;

import com.example.app.entity.base.BrandBase;
import com.example.app.model.ResponseDataModel;

import java.util.List;

public interface IBrand {
    List<BrandBase> getAll();

    BrandBase findByBrandName(String brandName);

    void del(Long id);

    ResponseDataModel findAllWithPagerApi(int pageNumber);

    ResponseDataModel addApi(BrandBase brandEntity);

    ResponseDataModel updateApi(BrandBase brandEntity);

    ResponseDataModel findBrandByIdApi(Long brandId);

    ResponseDataModel deleteApi(Long brandId);

    ResponseDataModel searchBrand(String brandName, int pageNumber);
}
