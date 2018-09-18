package com.pop136.customerservice.mapper.agent.common;

import com.pop136.core.mybatis.AbstractBaseMapper;
import com.pop136.core.mybatis.annotation.Table;
import com.pop136.core.mybatis.criteria.Condition;
import com.pop136.core.mybatis.criteria.ConditionMapping;
import com.pop136.customerservice.entity.tag.TagModule;
import com.pop136.customerservice.entity.view.*;
import com.pop136.customerservice.vo.common.FeedBackTag;
import com.pop136.customerservice.vo.common.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XH on 2018-7-25.
 */
@Repository
public class TagMappingMapper extends AbstractBaseMapper {
    @Override
    public void init() {
        ConditionMapping mapping = new ConditionMapping( ) ;
        super.putMapping( DEF_MAPPING_KEY , mapping);
        super.setUnityFlterCondition( new Condition[]{ new Condition("deleteflag" , 0 , Condition.SYMBOL.EQ )});
    }

    /**
     * 获取标签
     * @param param
     * @return
     */
    public List<Tag> findTagListByModule(Map<String, Object> param) {
        return sqlTemplate.selectList("TagMappingMapper.findTagListByModule",param);
    }

    /**
     * 获取标签+标签value
     * @param param
     * @return
     */
    public List<TagValueVo> findTagValueListByModule (Map<String, Object> param) {
        return sqlTemplate.selectList("TagMappingMapper.findTagValueListByModule",param);
    }

    /**
     * 获取标签的对应关系 value mapping
     * @param param
     * @return
     */
    public List<TagValueMappingVo> findValueMappingListByModule (Map<String, Object> param) {
        return sqlTemplate.selectList("TagMappingMapper.findValueMappingListByModule",param);
    }

    /**
     * 获取回访的标签
     * @param param
     * @return
     */
    public List<FeedBackTag> findFeedBackTagList(Map<String, Object> param) {
        return sqlTemplate.selectList("TagMappingMapper.findFeedBackTagList",param);
    }

    /**
     * 获取回访的标签+标签value
     * @param param
     * @return
     */
    public List<FeedBackTagValueVo> findFeedBackTagValueList (Map<String, Object> param) {
        return sqlTemplate.selectList("TagMappingMapper.findFeedBackTagValueList",param);
    }

    /**
     *
     * @param param
     * @return
     */
    public List<FeedBackTagValueMappingVo> findFeedBackValueMappingList (Map<String, Object> param) {
        return sqlTemplate.selectList("TagMappingMapper.findFeedBackValueMappingList",param);
    }

    public List<FeedBackTagMappingVo> findFeedBackTagMapping (Map<String, Object> param) {
        return sqlTemplate.selectList("TagMappingMapper.findFeedBackTagMapping",param);
    }


}