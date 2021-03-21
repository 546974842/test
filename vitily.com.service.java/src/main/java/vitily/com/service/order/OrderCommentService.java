package vitily.com.service.order;

import vitily.com.api_entity.req_entity.mem.TqAuditOrderComment;
import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.order.TbOrderComment;
import vitily.com.ts_entity.order.TsOrderComment;
import vitily.com.tv_entity.order.TvOrderComment;

public interface OrderCommentService extends BasicService<TbOrderComment, TsOrderComment, TvOrderComment> {
    void saveComment(TbOrderComment entity)throws Exception;
    void auditComment(TqAuditOrderComment bean)throws Exception;
}