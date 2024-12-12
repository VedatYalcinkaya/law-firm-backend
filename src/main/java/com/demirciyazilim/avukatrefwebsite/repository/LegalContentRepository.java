package com.demirciyazilim.avukatrefwebsite.repository;

import com.demirciyazilim.avukatrefwebsite.entity.LegalContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegalContentRepository extends JpaRepository<LegalContent, Long> {
}