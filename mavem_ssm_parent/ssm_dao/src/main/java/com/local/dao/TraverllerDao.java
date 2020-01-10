package com.local.dao;

import com.local.domain.Traveller;

import java.util.List;

public interface TraverllerDao {
    List<Traveller> travellerFindById(String ordersid);
}
