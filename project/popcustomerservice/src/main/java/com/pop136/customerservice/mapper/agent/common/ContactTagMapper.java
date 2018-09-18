package com.pop136.customerservice.mapper.agent.common;

import com.pop136.core.mybatis.AbstractBaseMapper;
import com.pop136.core.mybatis.criteria.Condition;
import com.pop136.core.mybatis.criteria.ConditionMapping;
import com.pop136.core.mybatis.handler.FblMapResultHandler;
import com.pop136.customerservice.entity.tag.TagContact;
import com.pop136.customerservice.entity.view.TagValueMappingVo;
import com.pop136.customerservice.entity.view.TagValueVo;
import com.pop136.customerservice.vo.common.Tag;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XH on 2018-7-25.
 */
@Repository
public class ContactTagMapper extends AbstractBaseMapper {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void init() {
        ConditionMapping mapping = new ConditionMapping( ) ;
        super.putMapping( DEF_MAPPING_KEY , mapping);
        super.setUnityFlterCondition( new Condition[]{ new Condition("deleteflag" , 0 , Condition.SYMBOL.EQ )});
    }

    public List<TagContact> findCustomerTagListByCustaomerid(Map<String, Object> param) {
        return sqlTemplate.selectList("CustomerTagMapper.findCustomerTagListByCustaomerid",param);
    }

    public Map<String, String> getMtypeList(Object paramete)
    {
        FblMapResultHandler fbl = new FblMapResultHandler();
        sqlSession.select("ContactTagMapper.getAllTagsByCustomerId", paramete,fbl);
        @SuppressWarnings("rawtypes")
        Map map =fbl.getMappedResults();
        return map;
    }

    /**
     *
     * @param paramete
     * @return
     */
    public Map<String, String> getFeedBackMtypeList(Object paramete)
    {
        FblMapResultHandler fbl = new FblMapResultHandler();
        sqlSession.select("ContactTagMapper.getAllFeedBackTagsByCustomerId", paramete,fbl);
        @SuppressWarnings("rawtypes")
        Map map =fbl.getMappedResults();
        return map;
    }

}
