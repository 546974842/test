package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.consts.DelTagDesc;
import vitily.com.consts.YesOrNoDesc;
import vitily.com.mapper.mem.MemBaseMapper;
import vitily.com.mapper.mem.MemPersonalCertifyinfoMapper;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.mem.MemPersonalCertifyinfoService;
import vitily.com.tb_entity.mem.*;
import vitily.com.ts_entity.mem.TsMemPersonalCertifyinfo;
import vitily.com.tv_entity.mem.TvMemPersonalCertifyinfo;

import java.util.Date;

@Component
public class MemPersonalCertifyinfoServiceImpl extends BasicServiceImpl<TbMemPersonalCertifyinfo, TsMemPersonalCertifyinfo, TvMemPersonalCertifyinfo> implements MemPersonalCertifyinfoService {

    final MemPersonalCertifyinfoMapper memPersonalCertifyinfoMapper;
    @Autowired
    MemBaseMapper memBaseMapper;

    @Autowired
    public MemPersonalCertifyinfoServiceImpl(MemPersonalCertifyinfoMapper memPersonalCertifyinfoMapper) {
        this.memPersonalCertifyinfoMapper = memPersonalCertifyinfoMapper;
        super.setBaseMapper(memPersonalCertifyinfoMapper);
    }
    @Override
    public int insert(TsMemPersonalCertifyinfo bean) throws Exception{
        if(memPersonalCertifyinfoMapper.isExists(bean)){
            throw new DuplicateDataException("该用户已经开通信用信息,无需再次开通啦！");
        }
        Date now=new Date();
        bean.getEntity().setCreateDate(now);
        bean.getEntity().setDeltag(DelTagDesc.正常.getValue());
        int r = memPersonalCertifyinfoMapper.insertSelective(bean.getEntity());
        if(r > 0){
            TbMemBase upMemBase = new TbMemBase();
            upMemBase.setOpenCreditfile(YesOrNoDesc.是.getValue());
            upMemBase.setId(bean.getEntity().getMemberId());
            upMemBase.setUpdateDate(now);
            memBaseMapper.updateByPrimaryKeySelective(upMemBase);
        }
        return r;
    }
    /**
     * 审核 个人认证资料
     * @param bean
     */
    @Override
    public void updateForAuditCreditfile(TsMemPersonalCertifyinfo bean)throws Exception{
        //先查出历史数据再更新
        Date now = new Date();
        bean.getEntity().setUpdateDate(now);
        memPersonalCertifyinfoMapper.updateByPrimaryKeySelective(bean.getEntity());
    }
}