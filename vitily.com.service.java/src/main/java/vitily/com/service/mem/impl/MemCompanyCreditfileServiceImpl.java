package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.consts.DelTagDesc;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.consts.CreditfileCertifyStateDesc;
import vitily.com.consts.YesOrNoDesc;
import vitily.com.tb_entity.mem.TbMemBase;
import vitily.com.tb_entity.mem.TbMemCompanyCreditfile;
import vitily.com.tb_entity.mem.TbMemCreditHistory;
import vitily.com.tb_entity.mem.TbMemCreditfileCertifyLog;
import vitily.com.mapper.mem.MemBaseMapper;
import vitily.com.mapper.mem.MemCompanyCreditfileMapper;
import vitily.com.mapper.mem.MemCreditHistoryMapper;
import vitily.com.mapper.mem.MemCreditfileCertifyLogMapper;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.service.mem.MemCompanyCreditfileService;
import vitily.com.ts_entity.mem.TsMemCompanyCreditfile;
import vitily.com.tv_entity.mem.TvMemCompanyCreditfile;
import vitily.com.util.CommonUtil;

import java.util.Date;

@Component
public class MemCompanyCreditfileServiceImpl extends BasicServiceImpl<TbMemCompanyCreditfile,TsMemCompanyCreditfile,TvMemCompanyCreditfile> implements MemCompanyCreditfileService {

	final MemCompanyCreditfileMapper memCompanyCreditfileMapper;
	final MemBaseMapper memBaseMapper;
	final MemCreditHistoryMapper memCreditHistoryMapper;
	final MemCreditfileCertifyLogMapper memCreditfileCertifyLogMapper;

	@Autowired()
	public MemCompanyCreditfileServiceImpl(MemCompanyCreditfileMapper memCompanyCreditfileMapper
			,MemBaseMapper memBaseMapper
			,MemCreditHistoryMapper memCreditHistoryMapper
			,MemCreditfileCertifyLogMapper memCreditfileCertifyLogMapper
	) {
		this.memCompanyCreditfileMapper = memCompanyCreditfileMapper;
		this.memBaseMapper = memBaseMapper;
		this.memCreditHistoryMapper = memCreditHistoryMapper;
		this.memCreditfileCertifyLogMapper = memCreditfileCertifyLogMapper;
		super.setBaseMapper(memCompanyCreditfileMapper);
	}
	@Override
	public int insert(TsMemCompanyCreditfile bean) throws Exception{
		if(memCompanyCreditfileMapper.isExists(bean)){
			throw new DuplicateDataException("?????????????????????????????????,????????????????????????");
		}
		bean.getEntity().setCreditPoints(0);
		Date now=new Date();
		bean.getEntity().setCreateDate(now);
		bean.getEntity().setDeltag(DelTagDesc.??????.getValue());
		int r = memCompanyCreditfileMapper.insertSelective(bean.getEntity());
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
	public void updateForAuditCreditfile(TsMemCompanyCreditfile bean)throws Exception{
		//??????????????????????????????
		TbMemCompanyCreditfile updateEntity = bean.getEntity();
		TbMemCreditHistory history = bean.getCreditHistory();
		TbMemCreditfileCertifyLog log = new TbMemCreditfileCertifyLog();
		TbMemCompanyCreditfile old = memCompanyCreditfileMapper.selectForUpdate(updateEntity.getId());
		boolean auditOk = CommonUtil.isEqual(CreditfileCertifyStateDesc.????????????.getValue(),bean.getAuditResult());
		if(!CommonUtil.isNull(history.getCreditValue()) && auditOk){
			updateEntity.setCreditPoints(old.getCreditPoints()+history.getCreditValue());
		}else{
			updateEntity.setCreditPoints(null);
		}
		Date now = new Date();
		updateEntity.setUpdateDate(now);
		memCompanyCreditfileMapper.updateByPrimaryKeySelective(updateEntity);
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