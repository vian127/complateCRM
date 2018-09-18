package com.pop136.customerservice.mapper.agent.tag;

import com.pop136.core.mybatis.AbstractBaseMapper;
import com.pop136.core.mybatis.annotation.Table;
import com.pop136.core.mybatis.criteria.Condition;
import com.pop136.core.mybatis.criteria.ConditionMapping;
import com.pop136.customerservice.entity.tag.TagContact;
import com.pop136.customerservice.entity.tag.TagContactLog;
import com.pop136.customerservice.entity.tag.TagCustomerLog;
import com.pop136.customerservice.vo.tag.TagValueVo;
import com.pop136.customerservice.vo.tag.search.TagValueSearchVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 客户联系人标签 values
 */
@Repository
@Table("ss_tagvalue_contact")
public class TagContactMapper extends AbstractBaseMapper {

    public void init() {
        ConditionMapping mapping = new ConditionMapping( ) ;
        super.putMapping( DEF_MAPPING_KEY , mapping);
        super.setUnityFlterCondition( new Condition[]{ new Condition("deleteflag" , 0 , Condition.SYMBOL.EQ )});
    }

    public List<TagContact> findTagContactList(TagValueSearchVo searchVo) {
        return sqlTemplate.selectList("TagContactMapper.findTagContactList", searchVo);
    }

    public TagContact findTagContact(TagValueSearchVo searchVo) {
        return sqlTemplate.selectOne("TagContactMapper.findTagContact", searchVo);
    }

    public List<TagValueVo> findTagValueByContactId(String contactId) {
        return sqlTemplate.selectList("TagContactMapper.findTagValueByContactId", contactId);
    }

    public void batchInsertContactLog(List<TagContactLog> tagContactLogs) {
        sqlTemplate.update("TagContactMapper.batchInsertContactLog", tagContactLogs);
    }


    public void clearTagContactById(String contactId) {
        sqlTemplate.update("TagContactMapper.clearTagContactById", contactId);
    }
}
