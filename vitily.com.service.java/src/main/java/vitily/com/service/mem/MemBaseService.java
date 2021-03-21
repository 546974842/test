package vitily.com.service.mem;

import vitily.base.tv_entity.TvPageList;
import vitily.com.api_entity.resp_entity.mem.TmMemCommissionInfo;
import vitily.com.api_entity.resp_entity.mem.TmMemCommissionRinkingInfo;
import vitily.com.api_entity.resp_entity.mem.TmMemRecommendInfo;
import vitily.com.service.base.BasicService;
import vitily.com.api_entity.req_entity.other.TqMemLogin;
import vitily.com.tb_entity.mem.TbMemBase;
import vitily.com.ts_entity.mem.TsMemBase;
import vitily.com.ts_entity.mem.TsMemCommission;
import vitily.com.tv_entity.mem.TvMemBase;

import java.util.List;

public interface MemBaseService extends BasicService<TbMemBase,TsMemBase,TvMemBase> {
	boolean isExists(TsMemBase entity)throws Exception;
	/**
	 * 不检查是否存在，一般用于检查其他非唯一资料如修改密码等
	 * @param entity 1
	 * @throws Exception 2
	 */
    void updateNotCheck(TvMemBase entity)throws Exception;
	TvMemBase login(TqMemLogin req)throws Exception;
	/**
	 * 如果没登陆，已经报异常了，不需要再次判断
	 * @param token 1
	 * @return 2
	 * @throws Exception 3
	 */
    TvMemBase getTvMemberByToken(String token)throws Exception;
	TmMemCommissionInfo selectCommssionInfo(Integer id)throws Exception;
	TmMemRecommendInfo selectRecommendInfo(Integer memberId)throws Exception;
	TvPageList getRecommendPageList(TsMemBase bean)throws Exception;
	List<TmMemCommissionRinkingInfo> getForRankingReward(TsMemCommission bean);
}