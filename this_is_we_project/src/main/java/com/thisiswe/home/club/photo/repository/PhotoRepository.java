package com.thisiswe.home.club.photo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thisiswe.home.club.photo.entity.PhotoEntity;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {

}
