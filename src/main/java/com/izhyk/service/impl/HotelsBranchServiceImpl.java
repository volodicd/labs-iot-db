package com.izhyk.service.impl;

import com.izhyk.dao.HotelsBranchDao;

import com.izhyk.domain.HotelsBranch;

import com.izhyk.service.HotelsBranchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelsBranchServiceImpl implements HotelsBranchService {
    @Autowired
    private HotelsBranchDao hotelsBranchDao;

    @Override
    public List<HotelsBranch> findAll() {
        return hotelsBranchDao.findAll();
    }

    @Override
    public Optional<HotelsBranch> findById(Integer id) {
        return hotelsBranchDao.findById(id);
    }

    @Override
    public int create(HotelsBranch hotelsBranch) {
        return hotelsBranchDao.create(hotelsBranch);
    }

    @Override
    public int update(Integer id, HotelsBranch hotelsBranch) {
        return hotelsBranchDao.update(id, hotelsBranch);
    }

    @Override
    public int delete(Integer id) {
        return hotelsBranchDao.delete(id);
    }

    @Override
    public Optional<HotelsBranch> findByBranchName (String branchName) {
        return hotelsBranchDao.findByBranchName(branchName);
    }


}