package com.pop136.customerservice.service.marketing;

import com.pop136.customerservice.entity.marketing.MsgBatch;
import com.pop136.customerservice.mapper.agent.marketing.MsgBatchMapper;
import com.pop136.customerservice.service.AbstractBaseService;
import com.pop136.customerservice.vo.marketing.search.MsgBatchSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgBatchService extends AbstractBaseService {

  @Autowired
  private MsgBatchMapper batchMapper;


  public void init() {
    setMapper(batchMapper);
  }

  public List<MsgBatch> getBatchList(MsgBatchSearchVo searchVo) {

    return batchMapper.getBatchList(searchVo);
  }

  public String getBatchCount(MsgBatchSearchVo searchVo) {

    return batchMapper.getBatchCount(searchVo);
  }
}
