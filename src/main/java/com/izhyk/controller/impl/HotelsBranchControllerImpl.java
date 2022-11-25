package com.izhyk.controller.impl;

import com.izhyk.controller.HotelsBranchController;
import com.izhyk.dao.HotelsBranchDao;
import com.izhyk.domain.HotelsBranch;
import com.izhyk.service.HotelsBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelsBranchControllerImpl implements HotelsBranchController {
    @Autowired
    private HotelsBranchService hotelsBranchService;

    @Override
    public List<HotelsBranch> findAll() {
        return hotelsBranchService.findAll();
    }

    @Override
    public Optional<HotelsBranch> findById(Integer id) {
        return hotelsBranchService.findById(id);
    }

    @Override
    public int create(HotelsBranch hotelsBranch) {
        return hotelsBranchService.create(hotelsBranch);
    }

    @Override
    public int update(Integer id, HotelsBranch hotelsBranch) {
        return hotelsBranchService.update(id, hotelsBranch);
    }

    @Override
    public int delete(Integer id) {
        return hotelsBranchService.delete(id);
    }

    @Override
    public Optional<HotelsBranch> findByBranchName (String branchName) {
        return hotelsBranchService.findByBranchName(branchName);
    }
}
