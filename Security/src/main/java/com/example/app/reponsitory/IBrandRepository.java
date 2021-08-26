package com.example.app.reponsitory;

import com.example.app.entity.base.BrandBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBrandRepository extends JpaRepository<BrandBase, Long> {

    @Query(value = "select * from BrandBase b where  u.brand = ?1",nativeQuery = true)
    BrandBase findByBrandName(String name);

    @Query(value = "select * from BrandBase b where  u.id = ?1",nativeQuery = true)
    BrandBase findByBrandId(Long id);

}
