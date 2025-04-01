package com.nice2cu1.niceplaymusic.service.impl;

import com.nice2cu1.niceplaymusic.mapper.BannerMapper;
import com.nice2cu1.niceplaymusic.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerSongMapper;

    public List<Map<String, Object>> getBannerSongs() {
        return bannerSongMapper.getBannerSongs();
    }
}