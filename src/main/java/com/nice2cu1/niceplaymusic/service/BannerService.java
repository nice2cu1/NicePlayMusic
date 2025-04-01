package com.nice2cu1.niceplaymusic.service;

import java.util.List;
import java.util.Map;

public interface BannerService {

    /**
     * 获取首页轮播图
     *
     * @return 轮播图列表
     */
    List<Map<String, Object>> getBannerSongs();
}
