package vitily.com.mapper.mem;

import vitily.com.api_entity.req_entity.other.TqMemLogin;
import vitily.com.api_entity.resp_entity.mem.TmMemCommissionInfo;
import vitily.com.api_entity.resp_entity.mem.TmMemCommissionRinkingInfo;
import vitily.com.api_entity.resp_entity.mem.TmMemRecommendListInfo;
import vitily.com.api_entity.resp_entity.mem.TmMemRecommendInfo;
import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.mem.TbMemBase;
import vitily.com.ts_entity.mem.TsMemBase;
import vitily.com.ts_entity.mem.TsMemCommission;
import vitily.com.tv_entity.mem.TvMemBase;

import java.util.List;

public interface MemBaseMapper extends BaseMapper<TbMemBase,TsMemBase,TvMemBase> {
	TvMemBase getTvMemberByLogin(TqMemLogin req);
	TmMemCommissionInfo selectCommssionInfo(Integer id);
	TmMemRecommendInfo selectRecommendInfo(Integer memberId);
	List<TmMemRecommendListInfo> getRecommendList(TsMemBase bean);
	List<TmMemCommissionRinkingInfo> getForRankingReward(TsMemCommission bean);
}