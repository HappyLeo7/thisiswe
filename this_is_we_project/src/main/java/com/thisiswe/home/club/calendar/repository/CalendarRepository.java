package com.thisiswe.home.club.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thisiswe.home.club.calendar.entity.CalendarEntity;

public interface CalendarRepository extends JpaRepository<CalendarEntity, Long>{

}
