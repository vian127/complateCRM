package com.pop136.customerservice.service.customer;

import com.pop136.core.BeanUtil;
import com.pop136.customerservice.constant.CommonConstant;
import com.pop136.customerservice.constant.ContactConstant;
import com.pop136.customerservice.constant.CustomerConstant;
import com.pop136.customerservice.constant.FeedBackTagConstant;
import com.pop136.customerservice.entity.customer.FeedBack;
import com.pop136.customerservice.entity.tag.*;
import com.pop136.customerservice.mapper.agent.cusotmer.FeedBackMapper;
import com.pop136.customerservice.mapper.agent.tag.FeedBackTagContactMapper;
import com.pop136.customerservice.mapper.agent.tag.FeedBackTagCustomerMapper;
import com.pop136.customerservice.mapper.agent.tag.TagContactMapper;
import com.pop136.customerservice.mapper.agent.tag.TagCustomerMapper;
import com.pop136.customerservice.service.AbstractBaseService;
import com.pop136.customerservice.utils.GetRID;
import com.pop136.customerservice.utils.TimeUtil;
import com.pop136.customerservice.vo.feedback.FeedBackVo;
import com.pop136.customerservice.vo.feedback.param.FeedBackParamVo;
import com.pop136.customerservice.vo.customer.param.TagParamVo;
import com.pop136.customerservice.vo.customer.search.FeedBackSearchVo;
import com.pop136.customerservice.vo.tag.TagValueVo;
import com.pop136.customerservice.vo.tag.search.TagValueSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FeedBackService extends AbstractBaseService {

  @Autowired
  private FeedBackMapper feedBackMapper;

  @Autowired
  private FeedBackTagContactMapper tagContactMapper;

  @Autowired
  private FeedBackTagCustomerMapper tagCustomerMapper;

  @Autowired
  private TagContactMapper contactMapper;

  @Autowired
  private TagCustomerMapper customerMapper;


  public void init() {
    setMapper(feedBackMapper);
  }


  public List<FeedBackVo> getFeedBackList(FeedBackSearchVo searchVo) {
    return feedBackMapper.getFeedBackList(searchVo);
  }

  public String getFeedBackCount(FeedBackSearchVo searchVo) {
    return feedBackMapper.getFeedBackCount(searchVo);
  }


  /**
   * 获取 客户回访标签信息 service
   * @return
   */
  public List<TagValueVo> findTagCustomer(String id) {

    return tagCustomerMapper.findTagValueById(id);
  }

  /**
   * 获取 联系人回访标签信息 service
   * @param contactId
   * @return
   */
  public List<TagValueVo> findTagContact(String contactId) {

    return tagContactMapper.findTagValueByContactId(contactId);
  }


  /**
   * 添加 客户 回访标签信息
   * @param paramVo
   */
  public void addTagCustomer(FeedBackParamVo paramVo) {

    List<TagParamVo> customerTags = paramVo.getCustomerTags();

    addCustomerTagInfo(customerTags, paramVo);

  }


  /**
   * 添加 联系人标签
   * @param paramVo
   */
  public void addTagContact(FeedBackParamVo paramVo) {

    List<TagParamVo> contactTags = paramVo.getContactTags();

    addContactTagInfo(contactTags, paramVo);//添加标签
  }


  /**
   * 添加联系人 标签
   * @param contactTags
   */
  public void addContactTagInfo(List<TagParamVo> contactTags, FeedBackParamVo paramVo) {

    for (TagParamVo tagParamVo : contactTags) {
      TagContact tagContact =  new TagContact();

      tagContact.setId(new GetRID("2", "tag_contact", paramVo.getContactId()).getId());//生成id
      tagContact.setTagid(tagParamVo.getTagId());//
      tagContact.setTagvalid(tagParamVo.getId());//属性标签id
      tagContact.setContactid(paramVo.getContactId());//联系人id
      tagContact.setCustomerid(paramVo.getCustomerId());//客户id
      tagContact.setDeleteflag(0);
      tagContact.setCreatetime(TimeUtil.currentTime());//更新时间

      tagContact.setCreateroleid(paramVo.getUserRoleId());//更新人
      if (tagParamVo.getTagId().equals(ContactConstant.CONTACT_IMPRESSION.TYPE_1.getTagId())){
        //更新 客户印象
        updateTagImplession(paramVo, tagParamVo, tagContact);

      }else {
        tagContact.setFeedbackid(paramVo.getId());//回访id
        tagContactMapper.createBean(tagContact, TagContact.class);//新增 联系人 回访标签
      }

    }
  }

  /**
   * 更新客户印象 标签
   * @param paramVo
   * @param tagParamVo
   * @param tagContact
   */
  private void updateTagImplession(FeedBackParamVo paramVo, TagParamVo tagParamVo, TagContact tagContact) {
    //添加客户印象
    TagValueSearchVo searchVo = new TagValueSearchVo();
    searchVo.setTagId(ContactConstant.CONTACT_IMPRESSION.TYPE_1.getTagId());
    searchVo.setContactId(paramVo.getContactId());

    TagContact implession = contactMapper.findTagContact(searchVo);

    if (implession != null) {
      implession.setUpdateroleid(paramVo.getUserRoleId());
      implession.setLastupdatetime(TimeUtil.currentTime());
      implession.setTagvalid(tagParamVo.getId());
      //更新
      contactMapper.updateBean("id", implession.getId(), implession);
    }else {
      //新增
      contactMapper.createBean(tagContact, TagContact.class);
    }
  }


  /**
   * 更新 客户关注项
   * @param paramVo
   * @param tagParamVo
   * @param tagCustomer
   */
  private void updateTagAttention(FeedBackParamVo paramVo, TagParamVo tagParamVo, TagCustomer tagCustomer) {
    //添加客户印象
    TagValueSearchVo searchVo = new TagValueSearchVo();
    searchVo.setTagId(CommonConstant.CUSTOMER_TAG_ID.CUSTOMER_ATTENTION.getKey());
    searchVo.setCustomerId(paramVo.getCustomerId());

//    TagCustomer attention = customerMapper.findTagCustomer(searchVo);
    List<TagCustomer> attentions = customerMapper.findTagCustomerList(searchVo);

    if (attentions != null && !attentions.isEmpty()) {
      //修改关注项目
      for (TagCustomer attention : attentions) {
        attention.setUpdateroleid(paramVo.getUserRoleId());
        attention.setLastupdatetime(TimeUtil.currentTime());
        attention.setDeleteflag(1);
        //更新
        customerMapper.updateBean("id", attention.getId(), attention);
      }
    }else {
        //新增
        customerMapper.createBean(tagCustomer, TagCustomer.class);
    }
  }

  /**
   * 添加客户 标签
   * @param contactTags
   * @param paramVo
   */
  public void addCustomerTagInfo(List<TagParamVo> contactTags, FeedBackParamVo paramVo) {

    for (TagParamVo tagParamVo : contactTags) {


      TagCustomer tagCustomer =  new TagCustomer();

      tagCustomer.setId(new GetRID("2", "tag_customer", paramVo.getCustomerId()).getId());//生成id
      tagCustomer.setTagvalid(tagParamVo.getId());//属性标签id

      tagCustomer.setTagid(tagParamVo.getTagId());//
      tagCustomer.setCustomerid(paramVo.getCustomerId());//客户id
      tagCustomer.setDeleteflag(0);
      tagCustomer.setCreatetime(TimeUtil.currentTime());//更新时间

      tagCustomer.setCreateroleid(paramVo.getUserRoleId());//更新人

      if (tagParamVo.getTagId().equals(CommonConstant.CUSTOMER_TAG_ID.CUSTOMER_ATTENTION.getKey())){
        //更新 客户关注
        updateTagAttention(paramVo, tagParamVo, tagCustomer);

      }else {
        tagCustomer.setFeedbackid(paramVo.getId());//回访id
        tagCustomerMapper.createBean(tagCustomer, TagCustomer.class);//新增 客户标签
      }

    }
  }


  private void clearTagContact(FeedBackParamVo paramVo, List<TagContact> tagContacts) {
    //清除
    List<TagContactLog> tagContactLogs = new ArrayList<>();

    for (TagContact tagContact : tagContacts) {
      TagContactLog contactLog = new TagContactLog();
      contactLog.setId(new GetRID("pop_","contact-log", paramVo.getContactId()).getId());
      contactLog.setTagid(tagContact.getTagid());
      contactLog.setCustomerid(paramVo.getCustomerId());
      contactLog.setContactid(paramVo.getId());
      contactLog.setCreateroleid(paramVo.getUserRoleId());
      contactLog.setCreater(paramVo.getUserRoleName());
      contactLog.setCreatetime(TimeUtil.currentTime());
      tagContactLogs.add(contactLog);
    }
    //添加日志记录数据
    tagContactMapper.batchInsertContactLog(tagContactLogs);


    //清除客户标签数据
    tagContactMapper.clearTagContactById(paramVo.getId());
  }

  private void clearTagCustomer(FeedBackParamVo paramVo, List<TagCustomer> tagCustomers) {
    //清除
    List<TagCustomerLog> tagCustomerLogs = new ArrayList<>();

    for (TagCustomer tagCustomer : tagCustomers) {
      TagCustomerLog customerLog = new TagCustomerLog();
      customerLog.setId(new GetRID("pop_","customer-log", paramVo.getCustomerId()).getId());
      customerLog.setTagid(tagCustomer.getTagid());
      customerLog.setCustomerid(paramVo.getCustomerId());
      customerLog.setCreateroleid(paramVo.getUserRoleId());
      customerLog.setCreater(paramVo.getUserRoleName());
      customerLog.setCreatetime(TimeUtil.currentTime());
      tagCustomerLogs.add(customerLog);
    }
    //添加日志记录数据
    tagCustomerMapper.batchInsertCustomertLog(tagCustomerLogs);


    //清除客户标签数据
    tagCustomerMapper.clearCustomerTag(paramVo.getCustomerId());
  }


  /**
   * 转换 客户详情标签
   * @param result
   * @param tagCustomerVos
   */
  public void convertContactListTagVal(Map<String, Object> result, List<TagValueVo> tagContacts) {

    List<TagValueVo> contactType = new ArrayList<>();//联络类型
    List<TagValueVo> contactResult = new ArrayList<>();//联络结果
    List<TagValueVo> serviceWay = new ArrayList<>();//服务方式


    if (tagContacts != null && !tagContacts.isEmpty()) {
      //转换 客户标签
      for (TagValueVo tagContact : tagContacts) {

        if (tagContact.getTagId().equals(FeedBackTagConstant.CONTACT_TYPE.TYPE_0.getKey())){
          //联络类型
          contactType.add(tagContact);
        }else if (tagContact.getTagId().equals(FeedBackTagConstant.CONTACT_TYPE.TYPE_1.getKey())){
          //联络结果
          contactResult.add(tagContact);
        }else if (tagContact.getTagId().equals(FeedBackTagConstant.CONTACT_TYPE.TYPE_2.getKey())){
          //服务方式
          serviceWay.add(tagContact);
        }
      }
    }
    result.put("contactType",BeanUtil.convertTagListValue(contactType));//联络类型
    result.put("contactResult",BeanUtil.convertTagListValue(contactResult));//联络结果
    result.put("serviceWay",BeanUtil.convertTagListValue(serviceWay));//服务方式

  }


  /**
   * 转换 客户详情标签
   * @param result
   * @param tagCustomerVos
   */
  public void convertContactTagVal(Map<String, Object> result, List<TagValueVo> tagContacts) {

    List<TagValueVo> contactType = new ArrayList<>();//联络类型
    List<TagValueVo> contactResult = new ArrayList<>();//联络结果
    List<TagValueVo> serviceWay = new ArrayList<>();//服务方式


    if (tagContacts != null && !tagContacts.isEmpty()) {
      //转换 客户标签
      for (TagValueVo tagContact : tagContacts) {

        if (tagContact.getTagId().equals(FeedBackTagConstant.CONTACT_TYPE.TYPE_0.getKey())){
          //联络类型
          contactType.add(tagContact);
        }else if (tagContact.getTagId().equals(FeedBackTagConstant.CONTACT_TYPE.TYPE_1.getKey())){
          //联络结果
          contactResult.add(tagContact);
        }else if (tagContact.getTagId().equals(FeedBackTagConstant.CONTACT_TYPE.TYPE_2.getKey())){
          //服务方式
          serviceWay.add(tagContact);
        }
      }
    }
    result.put("contactType",BeanUtil.convertTagValue(contactType));//联络类型
    result.put("contactResult",BeanUtil.convertTagValue(contactResult));//联络结果
    result.put("serviceWay",BeanUtil.convertTagValue(serviceWay));//服务方式

  }

  /**
   * 转换 客户详情标签
   * @param result
   * @param tagCustomerVos
   */
  public void convertCustomerListTagVal(Map<String, Object> result, List<TagValueVo> tagCustomerVos) {

    List<TagValueVo> feedback = new ArrayList<>();//回访基础项
    List<TagValueVo> invoice = new ArrayList<>();//发票
    List<TagValueVo> complimentary  = new ArrayList<>();//赠品
    List<TagValueVo> login = new ArrayList<>();//登陆项
    List<TagValueVo> webService = new ArrayList<>();//网站服务
    List<TagValueVo> recommend = new ArrayList<>();//备注项目


    if (tagCustomerVos != null && !tagCustomerVos.isEmpty()) {
      //转换 客户标签
      for (TagValueVo tagCustomerVo : tagCustomerVos) {

        if (tagCustomerVo.getTagId().equals(FeedBackTagConstant.CUSTOMER_TYPE.TYPE_0.getTagId())){
          //基础项
          feedback.add(tagCustomerVo);
        }else if (tagCustomerVo.getTagId().equals(FeedBackTagConstant.CUSTOMER_TYPE.TYPE_1.getTagId())){
          //发票项
          invoice.add(tagCustomerVo);
        }else if (tagCustomerVo.getTagId().equals(FeedBackTagConstant.CUSTOMER_TYPE.TYPE_2.getTagId())){
          //赠品
          complimentary.add(tagCustomerVo);
        }else if (tagCustomerVo.getTagId().equals(FeedBackTagConstant.CUSTOMER_TYPE.TYPE_3.getTagId())){
          //登陆项
          login.add(tagCustomerVo);
        }else if (tagCustomerVo.getTagId().equals(FeedBackTagConstant.CUSTOMER_TYPE.TYPE_4.getTagId())){
          //网站服务
          webService.add(tagCustomerVo);
        }else if (tagCustomerVo.getTagId().equals(FeedBackTagConstant.CUSTOMER_TYPE.TYPE_5.getTagId())){
          //推荐项
          recommend.add(tagCustomerVo);
        }
      }
    }

    result.put("feedback", BeanUtil.convertTagListValue(feedback));//回访基础项
    result.put("invoice",BeanUtil.convertTagListValue(invoice));//发票
    result.put("complimentary",BeanUtil.convertTagListValue(complimentary));//赠品
    result.put("login",BeanUtil.convertTagListValue(login));//登陆
    result.put("webService", BeanUtil.convertTagListValue(webService));//网站服务
    result.put("recommend", BeanUtil.convertTagListValue(recommend));//推荐项

    result.put("serviceInfo",BeanUtil.TrimString(BeanUtil.convertTagListTagValue(feedback) +","+ BeanUtil.convertTagListTagValue(invoice)
        +","+ BeanUtil.convertTagListTagValue(complimentary)+","+BeanUtil.convertTagListTagValue(login)+
        ","+BeanUtil.convertTagListTagValue(webService)+BeanUtil.convertTagListTagValue(recommend)));
  }

  /**
   * 转换 客户详情标签
   * @param result
   * @param tagCustomerVos
   */
  public void convertCustomerTagVal(Map<String, Object> result, List<TagValueVo> tagCustomerVos) {

    List<TagValueVo> feedback = new ArrayList<>();//回访基础项
    List<TagValueVo> invoice = new ArrayList<>();//发票
    List<TagValueVo> complimentary  = new ArrayList<>();//赠品
    List<TagValueVo> login = new ArrayList<>();//登陆项
    List<TagValueVo> webService = new ArrayList<>();//网站服务
    List<TagValueVo> recommend = new ArrayList<>();//备注项目


    if (tagCustomerVos != null && !tagCustomerVos.isEmpty()) {
      //转换 客户标签
      for (TagValueVo tagCustomerVo : tagCustomerVos) {

        if (tagCustomerVo.getTagId().equals(FeedBackTagConstant.CUSTOMER_TYPE.TYPE_0.getTagId())){
          //基础项
          feedback.add(tagCustomerVo);
        }else if (tagCustomerVo.getTagId().equals(FeedBackTagConstant.CUSTOMER_TYPE.TYPE_1.getTagId())){
          //发票项
          invoice.add(tagCustomerVo);
        }else if (tagCustomerVo.getTagId().equals(FeedBackTagConstant.CUSTOMER_TYPE.TYPE_2.getTagId())){
          //赠品
          complimentary.add(tagCustomerVo);
        }else if (tagCustomerVo.getTagId().equals(FeedBackTagConstant.CUSTOMER_TYPE.TYPE_3.getTagId())){
          //登陆项
          login.add(tagCustomerVo);
        }else if (tagCustomerVo.getTagId().equals(FeedBackTagConstant.CUSTOMER_TYPE.TYPE_4.getTagId())){
          //网站服务
          webService.add(tagCustomerVo);
        }else if (tagCustomerVo.getTagId().equals(FeedBackTagConstant.CUSTOMER_TYPE.TYPE_5.getTagId())){
          //推荐项
          recommend.add(tagCustomerVo);
        }
      }
    }

    result.put("feedback", BeanUtil.convertTagValue(feedback));//回访基础项
    result.put("invoice",BeanUtil.convertTagValue(invoice));//发票
    result.put("complimentary",BeanUtil.convertTagValue(complimentary));//赠品
    result.put("login",BeanUtil.convertTagValue(login));//登陆
    result.put("webService", BeanUtil.convertTagValue(webService));//网站服务
    result.put("recommend", BeanUtil.convertTagValue(recommend));//推荐项
  }
}
