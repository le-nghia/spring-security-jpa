package com.example.app.service.impl;

import com.example.app.commons.constant.Constants;
import com.example.app.entity.base.BrandBase;
import com.example.app.model.PagerModel;
import com.example.app.model.ResponseDataModel;
import com.example.app.reponsitory.IBrandRepository;
import com.example.app.service.IBrand;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements IBrand {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Value("${parent.folder.images.brand}")
    private String brandLogoFolderPath;

    @Autowired
    IBrandRepository brandRepository;

    @Override
    public List<BrandBase> getAll() {
        return brandRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public BrandBase findByBrandName(String brandName) {
        return brandRepository.findByBrandName(brandName);
    }

    @Override
    public void del(Long id) {
        brandRepository.deleteById(id);
    }

    @Override
    public ResponseDataModel findAllWithPagerApi(int pageNumber) {
        int responseCode = Constants.RESULT_CD_FAIL;
        String responseMsg = StringUtils.EMPTY;
        Map<String, Object> responseMap = new HashMap<>();
        try {
            Sort sortInfo = Sort.by(Sort.Direction.DESC, "brandId");
            Pageable pageable = PageRequest.of(pageNumber - 1, Constants.PAGE_SIZE, sortInfo);
            Page<BrandBase> brandEntitiesPage = brandRepository.findAll(pageable);
            responseMap.put("brandsList", brandEntitiesPage.getContent());
            responseMap.put("paginationInfo", new PagerModel(pageNumber, brandEntitiesPage.getTotalPages()));
            responseCode = Constants.RESULT_CD_SUCCESS;
        } catch (Exception e) {
            responseMsg = e.getMessage();
            LOGGER.error("Error when get all brand: ", e);
        }
        return new ResponseDataModel(responseCode, responseMsg, responseMap);
    }

    @Override
    public ResponseDataModel addApi(BrandBase brandBase) {
        int responseCode = Constants.RESULT_CD_FAIL;
        String responseMsg = StringUtils.EMPTY;
        try {
            if (findByBrandName(brandBase.getBrand()) != null) {
                responseMsg = "Brand Name is duplicated";
                responseCode = Constants.RESULT_CD_DUPL;
            } else {
                /*MultipartFile[] logoFiles = brandBase.get();
                if (logoFiles != null && logoFiles[0].getSize() > 0) {
                    String imagePath = FileHelper.addNewFile(brandLogoFolderPath, logoFiles);
                    brandEntity.setLogo(imagePath);
                }*/
                brandRepository.saveAndFlush(brandBase);
                responseMsg = "Brand is added successfully";
                responseCode = Constants.RESULT_CD_SUCCESS;
            }
        } catch (Exception e) {
            responseMsg = "Error when adding brand";
            LOGGER.error("Error when adding brand: ", e);
        }
        return new ResponseDataModel(responseCode, responseMsg);
    }

    @Override
    public ResponseDataModel updateApi(BrandBase brandEntity) {
        return null;
    }

    @Override
    public ResponseDataModel findBrandByIdApi(Long brandId) {
        return null;
    }

    @Override
    public ResponseDataModel deleteApi(Long brandId) {
        int responseCode = Constants.RESULT_CD_FAIL;
        String responseMsg = StringUtils.EMPTY;
        BrandBase brandBase = brandRepository.findByBrandId(brandId);
        try {
            if (brandBase != null) {
                brandRepository.deleteById(brandId);
                brandRepository.flush();

                // Remove logo of brand from store folder
                //FileHelper.deleteFile(brandBase.getLogo());
                responseMsg = "Brand is deleted successfully";
                responseCode = Constants.RESULT_CD_SUCCESS;
            }
        } catch(Exception e) {
            responseMsg = "Error when deleting brand";
            LOGGER.error("Error when delete brand: ", e);
        }
        return new ResponseDataModel(responseCode, responseMsg);
    }

    @Override
    public ResponseDataModel searchBrand(String brandName, int pageNumber) {
        return null;
    }
}
