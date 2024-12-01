package com.vstu.msgproj.webui.model;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Result {
    private String columnName;
    private Map<String, Long> valueMap;

    public Result(String columnName, List<Map<String, String>> list) {
        if (StringUtils.isBlank(columnName) || list == null || list.size() == 0){
            return;
        }
        valueMap = new HashMap<>();
        for (Map<String, String> map : list) {
            String value = String.valueOf(map.get(columnName));
            Long totalNum = Long.parseLong(String.valueOf(map.get("totalNum")));
            valueMap.put(value,totalNum);
        }
        this.columnName = columnName;
    }

    public Map<String, Long> getValueMap() {
        return valueMap;
    }
}
