package com.fadedos.vo;

import java.util.List;
import java.util.Map;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/2
 */
public class CollectionVO {
    private List<String> lists;

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    private Map<String, String> maps;

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }
}
