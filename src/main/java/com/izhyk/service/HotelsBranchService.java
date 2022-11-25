package com.izhyk.service;

import com.izhyk.domain.HotelsBranch;

import java.util.Optional;

public interface HotelsBranchService extends GeneralService<HotelsBranch, Integer>{
    Optional<HotelsBranch> findByBranchName (String branchName);
}
