package vitily.com.service.comm.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.comm.TbTaskLog;
import vitily.com.ts_entity.comm.TsTaskLog;
import vitily.com.tv_entity.comm.TvTaskLog;
import vitily.com.mapper.comm.TaskLogMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.comm.TaskLogService;

@Component
public class TaskLogServiceImpl extends BasicServiceImpl<TbTaskLog,TsTaskLog,TvTaskLog> implements TaskLogService {

	final
    TaskLogMapper taskLogMapper;

	@Autowired()
	public TaskLogServiceImpl(TaskLogMapper taskLogMapper) {
		this.taskLogMapper = taskLogMapper;
		super.setBaseMapper(taskLogMapper);
	}
}
