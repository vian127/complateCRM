package com.pop136.core.mybatis.handler;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by XH on 2018-8-7.
 */
public class FblMapResultHandler implements ResultHandler {
    @SuppressWarnings("rawtypes")
    private final Map mappedResults = new HashMap();

    @SuppressWarnings("unchecked")
    @Override
    public void handleResult(ResultContext context) {
        @SuppressWarnings("rawtypes")
        Map map = (Map) context.getResultObject();
        mappedResults.put(map.get("key"), map.get("value"));  // xml 配置里面的property的值，对应的列
    }
    public Map getMappedResults() {
        return mappedResults;
    }
}
