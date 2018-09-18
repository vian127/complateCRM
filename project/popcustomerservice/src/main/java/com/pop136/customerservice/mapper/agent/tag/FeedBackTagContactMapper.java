package com.pop136.customerservice.mapper.agent.tag;

import com.pop136.core.mybatis.AbstractBaseMapper;
import com.pop136.core.mybatis.annotation.Table;
import com.pop136.core.mybatis.criteria.Condition;
import com.pop136.core.mybatis.criteria.ConditionMapping;
import com.pop136.customerservice.entity.tag.TagContact;
import com.pop136.customerservice.entity.tag.TagContactLog;
import com.pop136.customerservice.vo.customer.param.TagParamVo;
import com.pop136.customerservice.vo.tag.TagValueVo;
import com.pop136.customerservice.vo.tag.search.TagValueSearchVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 联系人 回访标签
 */
@Repository
@Table("ss_feedback_tagvalue_contact")
public class FeedBackTagContactMapper extends AbstractBaseMapper {

    public void init() {
        ConditionMapping mapping = new ConditionMapping( ) ;
        super.putMapping( DEF_MAPPING_KEY , mapping);
        super.setUnityFlterCondition( new Condition[]{ new Condition("deleteflag" , 0 , Condition.SYMBOL.EQ )});
    }

    public List<TagContact> findTagContactList(TagValueSearchVo searchVo) {
        return sqlTemplate.selectList("FeedBackTagContactMapper.findTagContactList", searchVo);
    }


    public List<TagValueVo> findTagValueByContactId(String feedId) {
        return sqlTemplate.selectList("FeedBackTagContactMapper.findTagValueById", feedId);
    }

    public void batchInsertContactLog(List<TagContactLog> tagContactLogs) {
        sqlTemplate.update("FeedBackTagContactMapper.batchInsertContactLog", tagContactLogs);
    }


    public void clearTagContactById(String contactId) {
        sqlTemplate.update("FeedBackTagContactMapper.clearTagContactById", contactId);
    }


}
