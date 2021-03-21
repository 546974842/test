package vitily.com.service.comm.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.comm.TbMessage;
import vitily.com.mapper.comm.MessageMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.comm.MessageService;
import vitily.com.ts_entity.comm.TsMessage;
import vitily.com.tv_entity.comm.TvMessage;

@Component
public class MessageServiceImpl extends BasicServiceImpl<TbMessage,TsMessage,TvMessage> implements MessageService {

	final
	MessageMapper messageMapper;

	@Autowired()
	public MessageServiceImpl(MessageMapper messageMapper) {
		this.messageMapper = messageMapper;
		super.setBaseMapper(messageMapper);
	}
}