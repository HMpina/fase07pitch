package com.guliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guliver.models.HotelModel;


public interface HotelRepository extends JpaRepository<HotelModel, Long> {

}