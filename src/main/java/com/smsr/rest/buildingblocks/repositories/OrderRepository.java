package com.smsr.rest.buildingblocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smsr.rest.buildingblocks.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
