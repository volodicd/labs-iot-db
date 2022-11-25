package com.izhyk.controller;

import com.izhyk.controller.GeneralController;
import com.izhyk.domain.HotelsBranch;
import com.izhyk.domain.Location;

import java.util.Optional;

public interface HotelsBranchController extends GeneralController<HotelsBranch, Integer> {
    Optional<HotelsBranch> findByBranchName (String branchName);
}
