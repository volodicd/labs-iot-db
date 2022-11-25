package com.izhyk.dao;

import com.izhyk.dao.GeneralDao;
import com.izhyk.domain.HotelsBranch;


import java.util.Optional;

public interface HotelsBranchDao extends GeneralDao<HotelsBranch, Integer>  {
    Optional<HotelsBranch> findByBranchName (String branchName);
}
