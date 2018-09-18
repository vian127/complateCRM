package com.pop136.customerservice.mapper.agent.cusotmer;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pop136.core.BeanUtil;
import com.pop136.core.mybatis.AbstractBaseMapper;
import com.pop136.core.mybatis.annotation.Table;
import com.pop136.core.mybatis.criteria.Condition;
import com.pop136.core.mybatis.criteria.ConditionMapping;
import com.pop136.customerservice.entity.customer.CustomerApm;
import com.pop136.customerservice.vo.customer.*;
import com.pop136.customerservice.vo.customer.search.CustomerSearchVo;
import com.pop136.customerservice.vo.customer.search.CustomerVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
@Table("mp_customer")
public class CustomerMapper extends AbstractBaseMapper {


  @Override
  public void init() {
    ConditionMapping mapping = new ConditionMapping( ) ;
    mapping.put("name", new Condition("name" , Condition.SYMBOL.LIKE ) ) ;
    super.putMapping( DEF_MAPPING_KEY , mapping);
  }

  /**
   * 获取客户列表信息
   * @return
   */
  public List<CustomerVo> getCustomerList(CustomerSearchVo searchVo) {
    PageHelper.startPage(searchVo.getPage(), searchVo.getSize());

    return sqlTemplate.selectList("CustomerMapper.getCustomerList", searchVo);
  }


  /**
   * 获取客户总数
   * @return
   */
  public String getCustomerCount(CustomerSearchVo searchVo) {

    return sqlTemplate.selectOne("CustomerMapper.getCustomerCount",searchVo);
  }


  /**
   * 获取客户 领用列表详情
   * @return
   */
  public List<ReceiveInfoVo> getReceiveInfoByCustomerId(String customerId) {

    return sqlTemplate.selectList("CustomerMapper.getReceiveInfoByCustomerId",customerId);
  }


  /**
   * 获取客户 协助列表
   * @param customerId
   * @return
   */
  public List<AssistInfoVo> getAssistInfoByCustomerId(String customerId) {
    return sqlTemplate.selectList("CustomerMapper.getAssistInfoByCustomerId",customerId);
  }

  /**
   * 获取 客户 活动列表
   * @param customerId
   * @return
   */
  public List<ActivityInfoVo> getActivityInfoByCustomerId(String customerId) {
    return sqlTemplate.selectList("CustomerMapper.getActivityInfoByCustomerId",customerId);
  }

  /**
   * 获取 客户 呼入列表
   * @param customerId
   * @return
   */
  public List<CallInfoVo> getCallInByCustomerId(String customerId) {
    return sqlTemplate.selectList("CustomerMapper.getCallInByCustomerId",customerId);
  }


  /**
   * 获取 客户 呼出列表
   * @param customerId
   * @return
   */
  public List<CallInfoVo> getCallOutByCustomerId(String customerId) {
    return sqlTemplate.selectList("CustomerMapper.getCallOutByCustomerId",customerId);
  }


  /**
   * 获取 客户 客服记录 列表
   */
  public List<ServiceInfoVo> getServiceByCustomerId(String customerId, String groundFlag) {
    Map<String, String> paramMap = new HashMap<>();
    paramMap.put("customerId", customerId);
    paramMap.put("groundFlag", groundFlag);
    return sqlTemplate.selectList("CustomerMapper.getServiceByCustomerId",paramMap);
  }

  /**
   * 获取客户 订单 记录表
   * @param customerId
   * @return
   */
  public List<OrderInfoVo> getOrderByCustomerId(String customerId) {

    return sqlTemplate.selectList("CustomerMapper.getOrderByCustomerId",customerId);
  }

  /**
   * 获取客户 发票列表
   */
  public List<InvoiceInfoVo> getInvoiceByCustomerId(String customerId) {

    return sqlTemplate.selectList("CustomerMapper.getInvoiceByCustomerId",customerId);
  }

  /**
   * 获取 客户开 发票记录
   */
  public List<InvoiceLogInfoVo> getInvoiceLogByCustomerId(String customerId) {
    return sqlTemplate.selectList("CustomerMapper.getInvoiceLogByCustomerId",customerId);

  }

  /**
   * 获取 客服 商派 记录
   */
  public List<ShangpainfoVo> getShangPaiByCustomerId(String customerId) {
    return sqlTemplate.selectList("CustomerMapper.getShangPaiByCustomerId",customerId);
  }

  /**
   * 获取 客户 apm 书籍 信息
   */
  public List<CustomerApm> getApmBookInfo(String customerId) {


    return sqlTemplate.selectList("CustomerMapper.getApmBookInfo",customerId);
  }


}
