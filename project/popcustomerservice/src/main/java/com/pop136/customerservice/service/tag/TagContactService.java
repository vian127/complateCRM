package com.pop136.customerservice.service.tag;

import com.pop136.customerservice.entity.tag.TagContact;
import com.pop136.customerservice.mapper.agent.tag.TagContactMapper;
import com.pop136.customerservice.service.AbstractBaseService;
import com.pop136.customerservice.vo.tag.TagValueVo;
import com.pop136.customerservice.vo.tag.search.TagValueSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TagContactService extends AbstractBaseService {

    @Autowired
    private TagContactMapper tagContactMapper;

    public void init() {
        setMapper(tagContactMapper);
    }

    public List<TagContact> findTagContactList(TagValueSearchVo searchVo) {
        return tagContactMapper.findTagContactList(searchVo);
    }

    public List<TagValueVo> findTagValueByContactId(String contactId) {
        return tagContactMapper.findTagValueByContactId(contactId);
    }
}
