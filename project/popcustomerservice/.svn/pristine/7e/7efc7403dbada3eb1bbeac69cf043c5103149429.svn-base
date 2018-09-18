package com.pop136.customerservice.mapper.agent.common;

import com.pop136.core.mybatis.AbstractBaseMapper;
import com.pop136.core.mybatis.annotation.Table;
import com.pop136.core.mybatis.criteria.Condition;
import com.pop136.core.mybatis.criteria.ConditionMapping;
import com.pop136.customerservice.vo.common.DatadictVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Table("gp_datadict")
public class DataDictMapper extends AbstractBaseMapper {
    @Override
    public void init() {
        ConditionMapping mapping = new ConditionMapping();
        mapping.put("name", new Condition("name", Condition.SYMBOL.EQ));
        mapping.put("id", new Condition("name", Condition.SYMBOL.EQ));
        mapping.put("stype", new Condition("stype", Condition.SYMBOL.EQ));
        mapping.put("description", new Condition("description", Condition.SYMBOL.LIKE));
        super.putMapping(DEF_MAPPING_KEY, mapping);
        super.setUnityFlterCondition(new Condition[]{new Condition("deleteflag", 0, Condition.SYMBOL.EQ)});
    }

    public List<DatadictVo> findAreaList(String fatherid) {
        return sqlTemplate.selectList("DataDictMapper.findAreaList", fatherid);
    }

    public List<DatadictVo> findTagList(Map<String, Object> param) {
        return sqlTemplate.selectList("DataDictMapper.findTagList", param);
    }

    public DatadictVo getNameByID(Map<String, Object> param)
    {
        return sqlTemplate.selectOne("DataDictMapper.getNameByID", param);
    }

}
