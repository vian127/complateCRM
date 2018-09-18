package com.pop136.customerservice.service.common;

import com.pop136.core.BeanUtil;
import com.pop136.customerservice.entity.tag.TagCustomer;
import com.pop136.customerservice.entity.tag.TagModule;
import com.pop136.customerservice.entity.view.*;
import com.pop136.customerservice.mapper.agent.common.ContactTagMapper;
import com.pop136.customerservice.mapper.agent.common.CustomerTagMapper;
import com.pop136.customerservice.mapper.agent.common.TagMappingMapper;
import com.pop136.customerservice.service.AbstractBaseService;
import com.pop136.customerservice.utils.Constants;
import com.pop136.customerservice.utils.StringUtil;
import com.pop136.customerservice.vo.common.FeedBackTag;
import com.pop136.customerservice.vo.common.Tag;
import com.pop136.customerservice.vo.common.TagValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by XH on 2018-7-25.
 */
@Service
public class TagService extends AbstractBaseService {

    @Autowired
    private TagMappingMapper tagMappingMapper;

    @Autowired
    private CustomerTagMapper customerTagMapper;

    @Autowired
    private ContactTagMapper contactTagMapper;

    private TagMappingVo tagVo;

    public void init() {
        setMapper(tagMappingMapper);
    }

    public List<Tag> findMulTagList(String module, String id) {
        List<Tag> returnTagList;

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("module", module);
        param.put("tagcate", Constants.select_category_mul);
        List<Tag> tagList = tagMappingMapper.findTagListByModule(param);
        List<TagValueVo> tagValueList = tagMappingMapper.findTagValueListByModule(param);
        List<TagValueMappingVo> tagMappingVoList = tagMappingMapper.findValueMappingListByModule(param);

        //customer tags;
        param = new HashMap<String, Object>();
        param.put("customerid", id);
        Map<String, String> tagCustomersMap = customerTagMapper.getMtypeList(param);

        //contact tags
        param = new HashMap<String, Object>();
        param.put("customerid", id);
        param.put("contactid", id);
        Map<String, String> tagContactMap = contactTagMapper.getMtypeList(param);

        List<Tag> returnTags = new LinkedList<Tag>();
        for (Tag tagobject : tagList) {
            Tag tag = new Tag();
            String tagid = tagobject.getId();
            List<TagValueVo> children = new LinkedList<TagValueVo>();
            for (TagValueVo tagValueVo : tagValueList) {
                if (tagid.equals(tagValueVo.getTagid())) {
                    TagValueVo childTagValue = new TagValueVo();

                    //赋值被客户使用的tag
                    childTagValue.setSelected("");
                    if (tagCustomersMap != null) {
                        String code = (String) tagCustomersMap.get(tagValueVo.getId());
                        if (code != null && code.equals(tagValueVo.getCode())) {
                            childTagValue.setSelected("Y");
                        }
                    }

                    childTagValue.setId(tagValueVo.getId());
                    childTagValue.setCode(tagValueVo.getCode());
                    childTagValue.setValue(tagValueVo.getValue());
                    childTagValue.setTagid(tagValueVo.getTagid());

                    childTagValue.setModule(tagValueVo.getModule());
                    childTagValue.setNlevel(tagValueVo.getNlevel());

                    List<TagValueVo> childrenValue = new LinkedList<TagValueVo>();
                    if (StringUtil.checkString(tagValueVo.getHaschild()).equals("Y")) {
                        for (TagValueMappingVo tagValueMapping : tagMappingVoList) {
                            if (tagValueVo.getId().equals(tagValueMapping.getFromtagvalid())) {

                                TagValueVo childValueMapping = new TagValueVo();
                                childValueMapping.setSelected("");
                                if (tagCustomersMap != null) {
                                    String code = (String) tagCustomersMap.get(tagValueVo.getId());
                                    if (code != null && code.equals(tagValueVo.getCode())) {
                                        childValueMapping.setSelected("Y");
                                    }
                                }

                                childValueMapping.setId(tagValueMapping.getTotagvalid());
                                childValueMapping.setCode(tagValueMapping.getTocode());
                                childValueMapping.setValue(tagValueMapping.getTovalue());
                                childValueMapping.setTagid(tagValueMapping.getTagid());
                                childValueMapping.setModule(tagValueMapping.getModule());
                                //childValueMapping.setNlevel(tagValueVo.getNlevel() + 1);
                                childrenValue.add(childValueMapping);
                            }
                        }
                    }
                    childTagValue.setChildren(childrenValue);
                    children.add(childTagValue);
                }
            }
            tag.setId(tagid);
            tag.setSortnum(tagobject.getSortnum());
            tag.setTagcate(tagobject.getTagcate());
            tag.setTaggroup(tagobject.getTaggroup());
            tag.setTagseries(tagobject.getTagseries());
            tag.setTagclassification(tagobject.getTagclassification());
            tag.setTagsection(tagobject.getTagsection());
            tag.setTagattribute(tagobject.getTagattribute());
            tag.setIsnecessary(tagobject.getIsnecessary());
            tag.setName(tagobject.getName());
            tag.setChildren(children);
            returnTags.add(tag);
        }
        returnTagList = returnTags;
        return returnTagList;
    }

    public List<Tag> findMulTagListByIds(String module, String id, String tagids) {
        List<Tag> returnTagList;

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("module", module);
        param.put("tagcate", Constants.select_category_mul);
        param.put("tagids", BeanUtil.StringToList(tagids));
        List<Tag> tagList = tagMappingMapper.findTagListByModule(param);
        List<TagValueVo> tagValueList = tagMappingMapper.findTagValueListByModule(param);
        List<TagValueMappingVo> tagMappingVoList = tagMappingMapper.findValueMappingListByModule(param);

        //customer tags;
        param = new HashMap<String, Object>();
        param.put("customerid", id);
        Map<String, String> tagCustomersMap = customerTagMapper.getMtypeList(param);

        //contact tags
        param = new HashMap<String, Object>();
        param.put("customerid", id);
        param.put("contactid", id);
        Map<String, String> tagContactMap = contactTagMapper.getMtypeList(param);

        List<Tag> returnTags = new LinkedList<Tag>();
        for (Tag tagobject : tagList) {
            Tag tag = new Tag();
            String tagid = tagobject.getId();
            List<TagValueVo> children = new LinkedList<TagValueVo>();
            for (TagValueVo tagValueVo : tagValueList) {
                if (tagid.equals(tagValueVo.getTagid())) {
                    TagValueVo childTagValue = new TagValueVo();

                    //赋值被客户使用的tag
                    childTagValue.setSelected("");
                    if (tagCustomersMap != null) {
                        String code = (String) tagCustomersMap.get(tagValueVo.getId());
                        if (code != null && code.equals(tagValueVo.getCode())) {
                            childTagValue.setSelected("Y");
                        }
                    }

                    childTagValue.setId(tagValueVo.getId());
                    childTagValue.setCode(tagValueVo.getCode());
                    childTagValue.setValue(tagValueVo.getValue());
                    childTagValue.setTagid(tagValueVo.getTagid());

                    childTagValue.setModule(tagValueVo.getModule());
                    childTagValue.setNlevel(tagValueVo.getNlevel());

                    List<TagValueVo> childrenValue = new LinkedList<TagValueVo>();
                    if (StringUtil.checkString(tagValueVo.getHaschild()).equals("Y")) {
                        for (TagValueMappingVo tagValueMapping : tagMappingVoList) {
                            if (tagValueVo.getId().equals(tagValueMapping.getFromtagvalid())) {

                                TagValueVo childValueMapping = new TagValueVo();
                                childValueMapping.setSelected("");
                                if (tagCustomersMap != null) {
                                    String code = (String) tagCustomersMap.get(tagValueVo.getId());
                                    if (code != null && code.equals(tagValueVo.getCode())) {
                                        childValueMapping.setSelected("Y");
                                    }
                                }

                                childValueMapping.setId(tagValueMapping.getTotagvalid());
                                childValueMapping.setCode(tagValueMapping.getTocode());
                                childValueMapping.setValue(tagValueMapping.getTovalue());
                                childValueMapping.setTagid(tagValueMapping.getTagid());
                                childValueMapping.setModule(tagValueMapping.getModule());
                                //childValueMapping.setNlevel(tagValueVo.getNlevel() + 1);
                                childrenValue.add(childValueMapping);
                            }
                        }
                    }
                    childTagValue.setChildren(childrenValue);
                    children.add(childTagValue);
                }
            }
            tag.setId(tagid);
            tag.setSortnum(tagobject.getSortnum());
            tag.setTagcate(tagobject.getTagcate());
            tag.setTaggroup(tagobject.getTaggroup());
            tag.setTagseries(tagobject.getTagseries());
            tag.setTagclassification(tagobject.getTagclassification());
            tag.setTagsection(tagobject.getTagsection());
            tag.setTagattribute(tagobject.getTagattribute());
            tag.setIsnecessary(tagobject.getIsnecessary());
            tag.setName(tagobject.getName());
            tag.setChildren(children);
            returnTags.add(tag);
        }
        returnTagList = returnTags;
        return returnTagList;
    }

    public List<Tag> findSelectTagList(String module, String id) {
        List<Tag> returnTagList;

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("module", module);
        param.put("tagcate", Constants.select_category_sel);
        List<Tag> tagList = tagMappingMapper.findTagListByModule(param);
        List<TagValueVo> tagValueList = tagMappingMapper.findTagValueListByModule(param);
        List<TagValueMappingVo> tagMappingVoList = tagMappingMapper.findValueMappingListByModule(param);

        //customer tags;
        param = new HashMap<String, Object>();
        param.put("customerid", id);
        Map<String, String> tagCustomersMap = customerTagMapper.getMtypeList(param);

        //contact tags
        param = new HashMap<String, Object>();
        param.put("customerid", id);
        param.put("contactid", id);
        Map<String, String> tagContactMap = contactTagMapper.getMtypeList(param);

        List<Tag> returnTags = new LinkedList<Tag>();

        for (Tag tagobject : tagList) {
            Tag tag = new Tag();
            String tagid = tagobject.getId();
            List<TagValueVo> children = new LinkedList<TagValueVo>();
            for (TagValueVo tagValueVo : tagValueList) {
                if (tagid.equals(tagValueVo.getTagid())) {
                    TagValueVo childTagValue = new TagValueVo();

                    //赋值被客户使用的tag
                    childTagValue.setSelected("");
                    if (tagCustomersMap != null) {
                        String code = (String) tagCustomersMap.get(tagValueVo.getId());
                        if (code != null && code.equals(tagValueVo.getCode())) {
                            childTagValue.setSelected("Y");
                        }
                    }

                    childTagValue.setId(tagValueVo.getId());
                    childTagValue.setCode(tagValueVo.getCode());
                    childTagValue.setValue(tagValueVo.getValue());
                    childTagValue.setTagid(tagValueVo.getTagid());
                    childTagValue.setModule(tagValueVo.getModule());
                    childTagValue.setNlevel(tagValueVo.getNlevel());
                    children.add(childTagValue);
                }
            }
            tag.setId(tagid);
            tag.setSortnum(tagobject.getSortnum());
            tag.setTagcate(tagobject.getTagcate());
            tag.setTaggroup(tagobject.getTaggroup());
            tag.setTagseries(tagobject.getTagseries());
            tag.setTagclassification(tagobject.getTagclassification());
            tag.setTagsection(tagobject.getTagsection());
            tag.setTagattribute(tagobject.getTagattribute());
            tag.setIsnecessary(tagobject.getIsnecessary());
            tag.setName(tagobject.getName());
            tag.setChildren(children);
            returnTags.add(tag);
        }
        returnTagList = returnTags;
        return returnTagList;
    }


    public List<Tag> findSelectTagListByTagIds(String module, String id, String tagids) {
        List<Tag> returnTagList;

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("module", module);
        param.put("tagcate", Constants.select_category_sel);
        param.put("tagids", BeanUtil.StringToList(tagids));
        List<Tag> tagList = tagMappingMapper.findTagListByModule(param);
        List<TagValueVo> tagValueList = tagMappingMapper.findTagValueListByModule(param);
        List<TagValueMappingVo> tagMappingVoList = tagMappingMapper.findValueMappingListByModule(param);

        //customer tags;
        param = new HashMap<String, Object>();
        param.put("customerid", id);
        Map<String, String> tagCustomersMap = customerTagMapper.getMtypeList(param);

        //contact tags
        param = new HashMap<String, Object>();
        param.put("customerid", id);
        param.put("contactid", id);
        Map<String, String> tagContactMap = contactTagMapper.getMtypeList(param);

        List<Tag> returnTags = new LinkedList<Tag>();

        for (Tag tagobject : tagList) {
            Tag tag = new Tag();
            String tagid = tagobject.getId();
            List<TagValueVo> children = new LinkedList<TagValueVo>();
            for (TagValueVo tagValueVo : tagValueList) {
                if (tagid.equals(tagValueVo.getTagid())) {
                    TagValueVo childTagValue = new TagValueVo();

                    //赋值被客户使用的tag
                    childTagValue.setSelected("");
                    if (tagCustomersMap != null) {
                        String code = (String) tagCustomersMap.get(tagValueVo.getId());
                        if (code != null && code.equals(tagValueVo.getCode())) {
                            childTagValue.setSelected("Y");
                        }
                    }

                    childTagValue.setId(tagValueVo.getId());
                    childTagValue.setCode(tagValueVo.getCode());
                    childTagValue.setValue(tagValueVo.getValue());
                    childTagValue.setTagid(tagValueVo.getTagid());
                    childTagValue.setModule(tagValueVo.getModule());
                    childTagValue.setNlevel(tagValueVo.getNlevel());
                    children.add(childTagValue);
                }
            }
            tag.setId(tagid);
            tag.setSortnum(tagobject.getSortnum());
            tag.setTagcate(tagobject.getTagcate());
            tag.setTaggroup(tagobject.getTaggroup());
            tag.setTagseries(tagobject.getTagseries());
            tag.setTagclassification(tagobject.getTagclassification());
            tag.setTagsection(tagobject.getTagsection());
            tag.setTagattribute(tagobject.getTagattribute());
            tag.setIsnecessary(tagobject.getIsnecessary());
            tag.setName(tagobject.getName());
            tag.setChildren(children);
            returnTags.add(tag);
        }
        returnTagList = returnTags;
        return returnTagList;
    }

    public List<Tag> findSelectTagMappingByTagId(String module, String tag_id) {
        List<Tag> returnTagList;

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("tagid", tag_id);

        List<FeedBackTagMappingVo> feedBackTagMappingList = tagMappingMapper.findFeedBackTagMapping(param);

        List<Tag> returnTags = new LinkedList<Tag>();
        String fromtagvalid = "";
        String fromtagcode = "";
        String fromvalue = "";
        String fromtagid = "";
        String totagvalid = "";
        int i = 0;
        Tag tag = new Tag();
        List<TagValueVo> children = new LinkedList<TagValueVo>();
        List<TagValueVo> childrenValue = new LinkedList<TagValueVo>();
        TagValueVo childTagValue = new TagValueVo();
        for (FeedBackTagMappingVo tagobject : feedBackTagMappingList) {
            if (i == 0) {
                tag.setId(tagobject.getFromtagid());
                tag.setName(tagobject.getFromtagname());
            }
            if (!fromtagvalid.equals(tagobject.getFromtagvalid()))
            {
                if (i > 0)
                {
                    childTagValue.setId(fromtagvalid);
                    childTagValue.setCode(fromtagcode);
                    childTagValue.setValue(fromvalue);
                    childTagValue.setTagid(fromtagid);
                    childTagValue.setChildren(childrenValue);
                    children.add(childTagValue);
                    childTagValue = new TagValueVo();
                    childrenValue = new LinkedList<TagValueVo>();
                }

                fromtagvalid = tagobject.getFromtagvalid();
                fromtagcode = tagobject.getFromcode();
                fromvalue = tagobject.getFromtagvalue();
                fromtagid = tagobject.getFromtagid();
            }

            if(!totagvalid.equals(tagobject.getTotagvalid()))
            {
                TagValueVo tagMappigValue = new TagValueVo();
                tagMappigValue.setId(tagobject.getTotagvalid());
                tagMappigValue.setCode(tagobject.getTocode());
                tagMappigValue.setValue(tagobject.getTotagvalue());
                tagMappigValue.setTagid(tagobject.getTotagid());
                tagMappigValue.setTagname(tagobject.getTotagname());
                childrenValue.add(tagMappigValue);
            }

            i = i + 1;
        }
        childTagValue.setId(fromtagvalid);
        childTagValue.setCode(fromtagcode);
        childTagValue.setValue(fromvalue);
        childTagValue.setTagid(fromtagid);
        childTagValue.setChildren(childrenValue);
        children.add(childTagValue);
        tag.setChildren(children);
        returnTags.add(tag);
        returnTagList = returnTags;
        return returnTagList;
    }

    public List<FeedBackTag> findFeedBackMulTagList(String module, String id) {
        List<FeedBackTag> returnTagList;

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("module", module);
        param.put("tagcate", Constants.select_category_mul);
        List<FeedBackTag> tagList = tagMappingMapper.findFeedBackTagList(param);
        List<FeedBackTagValueVo> tagValueList = tagMappingMapper.findFeedBackTagValueList(param);
        List<FeedBackTagValueMappingVo> tagMappingVoList = tagMappingMapper.findFeedBackValueMappingList(param);

        //customer tags;
        param = new HashMap<String, Object>();
        param.put("customerid", id);
        Map<String, String> tagCustomersMap = customerTagMapper.getFeedBackMtypeList(param);

        //contact tags
        param = new HashMap<String, Object>();
        param.put("customerid", id);
        param.put("contactid", id);
        Map<String, String> tagContactMap = contactTagMapper.getFeedBackMtypeList(param);

        List<FeedBackTag> returnTags = new LinkedList<FeedBackTag>();
        for (FeedBackTag tagobject : tagList) {
            FeedBackTag tag = new FeedBackTag();
            String tagid = tagobject.getId();
            List<FeedBackTagValueVo> children = new LinkedList<FeedBackTagValueVo>();
            for (FeedBackTagValueVo tagValueVo : tagValueList) {
                if (tagid.equals(tagValueVo.getTagid())) {
                    FeedBackTagValueVo childTagValue = new FeedBackTagValueVo();

                    //赋值被客户使用的tag
                    childTagValue.setSelected("");
                    if (tagCustomersMap != null) {
                        String code = (String) tagCustomersMap.get(tagValueVo.getId());
                        if (code != null && code.equals(tagValueVo.getCode())) {
                            childTagValue.setSelected("Y");
                        }
                    }

                    childTagValue.setId(tagValueVo.getId());
                    childTagValue.setCode(tagValueVo.getCode());
                    childTagValue.setValue(tagValueVo.getValue());
                    childTagValue.setTagid(tagValueVo.getTagid());

                    childTagValue.setModule(tagValueVo.getModule());
                    childTagValue.setNlevel(tagValueVo.getNlevel());

                    List<FeedBackTagValueVo> childrenValue = new LinkedList<FeedBackTagValueVo>();
                    if (StringUtil.checkString(tagValueVo.getHaschild()).equals("Y")) {
                        for (FeedBackTagValueMappingVo tagValueMapping : tagMappingVoList) {
                            if (tagValueVo.getId().equals(tagValueMapping.getFromtagvalid())) {

                                FeedBackTagValueVo childValueMapping = new FeedBackTagValueVo();
                                childValueMapping.setSelected("");
                                if (tagCustomersMap != null) {
                                    String code = (String) tagCustomersMap.get(tagValueVo.getId());
                                    if (code != null && code.equals(tagValueVo.getCode())) {
                                        childValueMapping.setSelected("Y");
                                    }
                                }

                                childValueMapping.setId(tagValueMapping.getTotagvalid());
                                childValueMapping.setCode(tagValueMapping.getTocode());
                                childValueMapping.setValue(tagValueMapping.getTovalue());
                                childValueMapping.setTagid(tagValueMapping.getTagid());
                                childValueMapping.setModule(tagValueMapping.getModule());
                                //childValueMapping.setNlevel(tagValueVo.getNlevel() + 1);
                                childrenValue.add(childValueMapping);
                            }
                        }
                    }
                    childTagValue.setChildren(childrenValue);
                    children.add(childTagValue);
                }
            }
            tag.setId(tagid);
            tag.setSortnum(tagobject.getSortnum());
            tag.setTagcate(tagobject.getTagcate());
            tag.setTaggroup(tagobject.getTaggroup());
            tag.setTagseries(tagobject.getTagseries());
            tag.setTagclassification(tagobject.getTagclassification());
            tag.setTagsection(tagobject.getTagsection());
            tag.setTagattribute(tagobject.getTagattribute());
            tag.setIsnecessary(tagobject.getIsnecessary());
            tag.setName(tagobject.getName());
            tag.setChildren(children);
            returnTags.add(tag);
        }
        returnTagList = returnTags;
        return returnTagList;
        //return null;
    }

    public List<FeedBackTag> findFeedBackMulTagList(String module, String id, String tagids) {
        List<FeedBackTag> returnTagList;

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("module", module);
        param.put("tagcate", Constants.select_category_mul);
        param.put("tagids", BeanUtil.StringToList(tagids));

        List<FeedBackTag> tagList = tagMappingMapper.findFeedBackTagList(param);
        List<FeedBackTagValueVo> tagValueList = tagMappingMapper.findFeedBackTagValueList(param);
        List<FeedBackTagValueMappingVo> tagMappingVoList = tagMappingMapper.findFeedBackValueMappingList(param);

        //customer tags;
        param = new HashMap<String, Object>();
        param.put("customerid", id);
        Map<String, String> tagCustomersMap = customerTagMapper.getFeedBackMtypeList(param);

        //contact tags
        param = new HashMap<String, Object>();
        param.put("customerid", id);
        param.put("contactid", id);
        Map<String, String> tagContactMap = contactTagMapper.getFeedBackMtypeList(param);

        List<FeedBackTag> returnTags = new LinkedList<FeedBackTag>();
        for (FeedBackTag tagobject : tagList) {
            FeedBackTag tag = new FeedBackTag();
            String tagid = tagobject.getId();
            List<FeedBackTagValueVo> children = new LinkedList<FeedBackTagValueVo>();
            for (FeedBackTagValueVo tagValueVo : tagValueList) {
                if (tagid.equals(tagValueVo.getTagid())) {
                    FeedBackTagValueVo childTagValue = new FeedBackTagValueVo();

                    //赋值被客户使用的tag
                    childTagValue.setSelected("");
                    if (tagCustomersMap != null) {
                        String code = (String) tagCustomersMap.get(tagValueVo.getId());
                        if (code != null && code.equals(tagValueVo.getCode())) {
                            childTagValue.setSelected("Y");
                        }
                    }

                    childTagValue.setId(tagValueVo.getId());
                    childTagValue.setCode(tagValueVo.getCode());
                    childTagValue.setValue(tagValueVo.getValue());
                    childTagValue.setTagid(tagValueVo.getTagid());

                    childTagValue.setModule(tagValueVo.getModule());
                    childTagValue.setNlevel(tagValueVo.getNlevel());

                    List<FeedBackTagValueVo> childrenValue = new LinkedList<FeedBackTagValueVo>();
                    if (StringUtil.checkString(tagValueVo.getHaschild()).equals("Y")) {
                        for (FeedBackTagValueMappingVo tagValueMapping : tagMappingVoList) {
                            if (tagValueVo.getId().equals(tagValueMapping.getFromtagvalid())) {

                                FeedBackTagValueVo childValueMapping = new FeedBackTagValueVo();
                                childValueMapping.setSelected("");
                                if (tagCustomersMap != null) {
                                    String code = (String) tagCustomersMap.get(tagValueVo.getId());
                                    if (code != null && code.equals(tagValueVo.getCode())) {
                                        childValueMapping.setSelected("Y");
                                    }
                                }

                                childValueMapping.setId(tagValueMapping.getTotagvalid());
                                childValueMapping.setCode(tagValueMapping.getTocode());
                                childValueMapping.setValue(tagValueMapping.getTovalue());
                                childValueMapping.setTagid(tagValueMapping.getTagid());
                                childValueMapping.setModule(tagValueMapping.getModule());
                                //childValueMapping.setNlevel(tagValueVo.getNlevel() + 1);
                                childrenValue.add(childValueMapping);
                            }
                        }
                    }
                    childTagValue.setChildren(childrenValue);
                    children.add(childTagValue);
                }
            }
            tag.setId(tagid);
            tag.setSortnum(tagobject.getSortnum());
            tag.setTagcate(tagobject.getTagcate());
            tag.setTaggroup(tagobject.getTaggroup());
            tag.setTagseries(tagobject.getTagseries());
            tag.setTagclassification(tagobject.getTagclassification());
            tag.setTagsection(tagobject.getTagsection());
            tag.setTagattribute(tagobject.getTagattribute());
            tag.setIsnecessary(tagobject.getIsnecessary());
            tag.setName(tagobject.getName());
            tag.setChildren(children);
            returnTags.add(tag);
        }
        returnTagList = returnTags;
        return returnTagList;
    }

    public List<FeedBackTag> findFeedBackSelectTagList(String module, String id) {
        List<FeedBackTag> returnTagList;

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("module", module);
        param.put("tagcate", Constants.select_category_sel);
        List<FeedBackTag> tagList = tagMappingMapper.findFeedBackTagList(param);
        List<FeedBackTagValueVo> tagValueList = tagMappingMapper.findFeedBackTagValueList(param);
        List<FeedBackTagValueMappingVo> tagMappingVoList = tagMappingMapper.findFeedBackValueMappingList(param);

        //customer tags;
        param = new HashMap<String, Object>();
        param.put("customerid", id);
        Map<String, String> tagCustomersMap = customerTagMapper.getMtypeList(param);

        //contact tags
        param = new HashMap<String, Object>();
        param.put("customerid", id);
        param.put("contactid", id);
        Map<String, String> tagContactMap = contactTagMapper.getMtypeList(param);

        List<FeedBackTag> returnTags = new LinkedList<FeedBackTag>();

        for (FeedBackTag tagobject : tagList) {
            FeedBackTag tag = new FeedBackTag();
            String tagid = tagobject.getId();
            List<FeedBackTagValueVo> children = new LinkedList<FeedBackTagValueVo>();
            for (FeedBackTagValueVo tagValueVo : tagValueList) {
                if (tagid.equals(tagValueVo.getTagid())) {
                    FeedBackTagValueVo childTagValue = new FeedBackTagValueVo();

                    //赋值被客户使用的tag
                    childTagValue.setSelected("");
                    if (tagCustomersMap != null) {
                        String code = (String) tagCustomersMap.get(tagValueVo.getId());
                        if (code != null && code.equals(tagValueVo.getCode())) {
                            childTagValue.setSelected("Y");
                        }
                    }

                    childTagValue.setId(tagValueVo.getId());
                    childTagValue.setCode(tagValueVo.getCode());
                    childTagValue.setValue(tagValueVo.getValue());
                    childTagValue.setTagid(tagValueVo.getTagid());
                    childTagValue.setModule(tagValueVo.getModule());
                    childTagValue.setNlevel(tagValueVo.getNlevel());
                    children.add(childTagValue);
                }
            }
            tag.setId(tagid);
            tag.setSortnum(tagobject.getSortnum());
            tag.setTagcate(tagobject.getTagcate());
            tag.setTaggroup(tagobject.getTaggroup());
            tag.setTagseries(tagobject.getTagseries());
            tag.setTagclassification(tagobject.getTagclassification());
            tag.setTagsection(tagobject.getTagsection());
            tag.setTagattribute(tagobject.getTagattribute());
            tag.setIsnecessary(tagobject.getIsnecessary());
            tag.setName(tagobject.getName());
            tag.setChildren(children);
            returnTags.add(tag);
        }
        returnTagList = returnTags;
        return returnTagList;
    }

    public List<FeedBackTag> findFeedBackSelectTagListByTagIds(String module, String id, String tagids) {
        List<FeedBackTag> returnTagList;

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("module", module);
        param.put("tagcate", Constants.select_category_sel);
        param.put("tagids", BeanUtil.StringToList(tagids));
        List<FeedBackTag> tagList = tagMappingMapper.findFeedBackTagList(param);
        List<FeedBackTagValueVo> tagValueList = tagMappingMapper.findFeedBackTagValueList(param);
        List<FeedBackTagValueMappingVo> tagMappingVoList = tagMappingMapper.findFeedBackValueMappingList(param);

        //customer tags;
        param = new HashMap<String, Object>();
        param.put("customerid", id);
        Map<String, String> tagCustomersMap = customerTagMapper.getMtypeList(param);

        //contact tags
        param = new HashMap<String, Object>();
        param.put("customerid", id);
        param.put("contactid", id);
        Map<String, String> tagContactMap = contactTagMapper.getMtypeList(param);

        List<FeedBackTag> returnTags = new LinkedList<FeedBackTag>();

        for (FeedBackTag tagobject : tagList) {
            FeedBackTag tag = new FeedBackTag();
            String tagid = tagobject.getId();
            List<FeedBackTagValueVo> children = new LinkedList<FeedBackTagValueVo>();
            for (FeedBackTagValueVo tagValueVo : tagValueList) {
                if (tagid.equals(tagValueVo.getTagid())) {
                    FeedBackTagValueVo childTagValue = new FeedBackTagValueVo();

                    //赋值被客户使用的tag
                    childTagValue.setSelected("");
                    if (tagCustomersMap != null) {
                        String code = (String) tagCustomersMap.get(tagValueVo.getId());
                        if (code != null && code.equals(tagValueVo.getCode())) {
                            childTagValue.setSelected("Y");
                        }
                    }

                    childTagValue.setId(tagValueVo.getId());
                    childTagValue.setCode(tagValueVo.getCode());
                    childTagValue.setValue(tagValueVo.getValue());
                    childTagValue.setTagid(tagValueVo.getTagid());
                    childTagValue.setModule(tagValueVo.getModule());
                    childTagValue.setNlevel(tagValueVo.getNlevel());
                    children.add(childTagValue);
                }
            }
            tag.setId(tagid);
            tag.setSortnum(tagobject.getSortnum());
            tag.setTagcate(tagobject.getTagcate());
            tag.setTaggroup(tagobject.getTaggroup());
            tag.setTagseries(tagobject.getTagseries());
            tag.setTagclassification(tagobject.getTagclassification());
            tag.setTagsection(tagobject.getTagsection());
            tag.setTagattribute(tagobject.getTagattribute());
            tag.setIsnecessary(tagobject.getIsnecessary());
            tag.setName(tagobject.getName());
            tag.setChildren(children);
            returnTags.add(tag);
        }
        returnTagList = returnTags;
        return returnTagList;
    }

}