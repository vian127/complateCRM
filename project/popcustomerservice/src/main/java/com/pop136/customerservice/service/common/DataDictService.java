package com.pop136.customerservice.service.common;

import com.pop136.customerservice.mapper.agent.common.DataDictMapper;
import com.pop136.customerservice.mapper.agent.cusotmer.CustomerMapper;
import com.pop136.customerservice.service.AbstractBaseService;
import com.pop136.customerservice.vo.common.DatadictVo;
import com.pop136.customerservice.vo.customer.*;
import com.pop136.customerservice.vo.customer.search.CustomerSearchVo;
import com.pop136.customerservice.vo.customer.search.CustomerVo;
import com.pop136.customerservice.vo.user.UserComm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataDictService extends AbstractBaseService {

    @Autowired
    private DataDictMapper dataDictMapper;


    public void init() {
        setMapper(dataDictMapper);
    }

    public List<DatadictVo> findAreaList(String fatherid) {
        return dataDictMapper.findAreaList(fatherid);
    }

    public List<DatadictVo> findTagList(Map<String, Object> param) {
        return dataDictMapper.findTagList(param);
    }

    public String getNameByID(String dbName, String IDCol, String NameCol, String id) {
        String name = "";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("fieldname", NameCol);
        param.put("dbname", dbName);
        param.put("IDCol", IDCol);
        param.put("id", id);
        DatadictVo datadictVo = dataDictMapper.getNameByID(param);
        if(datadictVo != null)
        {
            name = datadictVo.getName();
        }
        return name;
    }
}
