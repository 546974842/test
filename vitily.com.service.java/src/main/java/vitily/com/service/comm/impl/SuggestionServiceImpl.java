package vitily.com.service.comm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vitily.com.tb_entity.comm.TbSuggestion;
import vitily.com.mapper.comm.SuggestionMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.comm.SuggestionService;
import vitily.com.ts_entity.comm.TsSuggestion;
import vitily.com.tv_entity.comm.TvSuggestion;

@Component
public class SuggestionServiceImpl extends BasicServiceImpl<TbSuggestion,TsSuggestion,TvSuggestion> implements SuggestionService {

	final
	SuggestionMapper suggestionMapper;

	@Autowired()
	public SuggestionServiceImpl(SuggestionMapper suggestionMapper) {
		this.suggestionMapper = suggestionMapper;
		super.setBaseMapper(suggestionMapper);
	}
}