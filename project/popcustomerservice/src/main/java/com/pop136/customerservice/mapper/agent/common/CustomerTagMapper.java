package com.pop136.customerservice.mapper.agent.common;

import com.pop136.core.mybatis.AbstractBaseMapper;
import com.pop136.core.mybatis.criteria.Condition;
import com.pop136.core.mybatis.criteria.ConditionMapping;
import com.pop136.core.mybatis.handler.FblMapResultHandler;
import com.pop136.customerservice.entity.tag.FeedBackTagCustomer;
import com.pop136.customerservice.entity.tag.TagCustomer;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static javax.xml.stream.XMLStreamConstants.NAMESPACE;

/**
 * Created by XH on 2018-7-25.
 */
@Repository
public class CustomerTagMapper extends AbstractBaseMapper {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public void init() {
        ConditionMapping mapping = new ConditionMapping( ) ;
        super.putMapping( DEF_MAPPING_KEY , mapping);
        super.setUnityFlterCondition( new Condition[]{ new Condition("deleteflag" , 0 , Condition.SYMBOL.EQ )});
    }

    /**
     *
     * @param param
     * @return
     */
    public List<TagCustomer> findCustomerTagListByCustaomerid(Map<String, Object> param) {
        return sqlTemplate.selectList("CustomerTagMapper.findCustomerTagListByCustaomerid", param);
    }

    /**
     *
     * @param paramete
     * @return
     */
    public Map<String, String> getMtypeList(Object paramete)
    {
        FblMapResultHandler fbl = new FblMapResultHandler();
        sqlSession.select("CustomerTagMapper.getAllTagsByCustomerId", paramete,fbl);
        @SuppressWarnings("rawtypes")
        Map map =fbl.getMappedResults();
        return map;
    }

    /**
     * 得到回访的客户标签信息
     * @param param
     * @return
     */
    public List<FeedBackTagCustomer> findFeedBackTagListByCustId(Map<String, Object> param) {
        return sqlTemplate.selectList("CustomerTagMapper.findFeedBackTagListByCustId", param);
    }

    /**
     * 得到回访的客户标签
     * @param paramete
     * @return
     */
    public Map<String, String> getFeedBackMtypeList(Object paramete)
    {
        FblMapResultHandler fbl = new FblMapResultHandler();
        sqlSession.select("CustomerTagMapper.getAllFeedBackTagsByCustomerId", paramete,fbl);
        @SuppressWarnings("rawtypes")
        Map map = fbl.getMappedResults();
        return map;
    }

}
