package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.consts.DelTagDesc;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.consts.CreditfileCertifyStateDesc;
import vitily.com.consts.YesOrNoDesc;
import vitily.com.tb_entity.mem.TbMemBase;
import vitily.com.tb_entity.mem.TbMemCreditHistory;
import vitily.com.tb_entity.mem.TbMemCreditfileCertifyLog;
import vitily.com.tb_entity.mem.TbMemPersonalCreditfile;
import vitily.com.mapper.mem.MemBaseMapper;
import vitily.com.mapper.mem.MemCreditHistoryMapper;
import vitily.com.mapper.mem.MemCreditfileCertifyLogMapper;
import vitily.com.mapper.mem.MemPersonalCreditfileMapper;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.service.mem.MemPersonalCreditfileService;
import vitily.com.ts_entity.mem.TsMemPersonalCreditfile;
import vitily.com.tv_entity.mem.TvMemPersonalCreditfile;
import vitily.com.util.CommonUtil;

import java.util.Date;

@Component
public class MemPersonalCreditfileServiceImpl extends BasicServiceImpl<TbMemPersonalCreditfile,TsMemPersonalCreditfile,TvMemPersonalCreditfile> implements MemPersonalCreditfileService {

	final MemPersonalCreditfileMapper memPersonalCreditfileMapper;
	final MemBaseMapper memBaseMapper;
	final MemCreditHistoryMapper memCreditHistoryMapper;
	final MemCreditfileCertifyLogMapper memCreditfileCertifyLogMapper;

	@Autowired()
	public MemPersonalCreditfileServiceImpl(MemPersonalCreditfileMapper memPersonalCreditfileMapper
			,MemBaseMapper memBaseMapper
			,MemCreditHistoryMapper memCreditHistoryMapper
			,MemCreditfileCertifyLogMapper memCreditfileCertifyLogMapper
	) {
		this.memPersonalCreditfileMapper = memPersonalCreditfileMapper;
		this.memBaseMapper = memBaseMapper;
		this.memCreditHistoryMapper = memCreditHistoryMapper;
		this.memCreditfileCertifyLogMapper = memCreditfileCertifyLogMapper;
		super.setBaseMapper(memPersonalCreditfileMapper);
	}
	@Override
	public int insert(TsMemPersonalCreditfile bean) throws Exception{
		if(memPersonalCreditfileMapper.isExists(bean)){
			throw new DuplicateDataException("?????????????????????????????????,????????????????????????");
		}
		bean.getEntity().setCreditPoints(0);
		Date now=new Date();
		bean.getEntity().setCreateDate(now);
		bean.getEntity().setDeltag(DelTagDesc.??????.getValue());
		int r = memPersonalCreditfileMapper.insertSelective(bean.getEntity());
		if(r > 0){
			TbMemBase upMemBase = new TbMemBase();
			upMemBase.setOpenCreditfile(YesOrNoDesc.???.getValue());
			upMemBase.setId(bean.getEntity().getMemberId());
			upMemBase.setUpdateDate(now);
			memBaseMapper.updateByPrimaryKeySelective(upMemBase);
		}
		return r;
	}
	/**
	 * ?????? ??????????????????
	 * @param bean
	 */
	@Override
	public void updateForAuditCreditfile(TsMemPersonalCreditfile bean)throws Exception{
		//??????????????????????????????
		TbMemPersonalCreditfile updateEntity = bean.getEntity();
		TbMemCreditHistory history = bean.getCreditHistory();
		TbMemCreditfileCertifyLog log = new TbMemCreditfileCertifyLog();
		TbMemPersonalCreditfile old = memPersonalCreditfileMapper.selectForUpdate(updateEntity.getId());
		boolean auditOk = CommonUtil.isEqual(CreditfileCertifyStateDesc.????????????.getValue(),bean.getAuditResult());
		if(!CommonUtil.isNull(history.getCreditValue()) && auditOk){
			updateEntity.setCreditPoints(old.getCreditPoints()+history.getCreditValue());
		}else{
			updateEntity.setCreditPoints(null);
		}
		Date now = new Date();
		updateEntity.setUpdateDate(now);
		memPersonalCreditfileMapper.updateByPrimaryKeySelective(updateEntity);
		if(auditOk) {
			//????????????
			history.setBalance(updateEntity.getCreditPoints());
			history.setCreateDate(now);
			memCreditHistoryMapper.insertSelective(history);
		}

		//????????????
		log.setCreateDate(now);
		log.setMemo("??????????????????,?????????"+history.getMemo());
		log.setAdmUserId(history.getAdmUserId());
		log.setRelationLinks(history.getRelationLinks());
		log.setCreditfileType(history.getRecordType());
		log.setCreditfileState(bean.getAuditResult());
		log.setMemberId(history.getMemberId());
		log.setState(history.getState());
		log.setDeltag(history.getDeltag());
		log.setIp(bean.getAuditIp());
		memCreditfileCertifyLogMapper.insertSelective(log);
	}
}