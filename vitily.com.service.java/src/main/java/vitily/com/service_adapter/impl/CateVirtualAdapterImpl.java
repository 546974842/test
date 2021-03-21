package vitily.com.service_adapter.impl;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.comm.TbCateVirtual;
import vitily.com.service_adapter.CateVirtualAdapter;
import vitily.com.util.CommonUtil;

@Component
public class CateVirtualAdapterImpl implements CateVirtualAdapter {
    @Override
    public void setCateVirtualSql(TbCateVirtual entity){
        StringBuilder sb = new StringBuilder("");
        if(!CommonUtil.isNull(entity.getTypeId())){
            sb.append(" and e.type_id = ").append(entity.getTypeId());
        }
        if(CommonUtil.isNumOrD(entity.getCateIds())){
            sb.append(" and e.cate_id in (").append(entity.getCateIds()).append(")");
        }
        if(CommonUtil.isNumOrD(entity.getBrandIds())){
            sb.append(" and e.brand_id in(").append(entity.getBrandIds()).append(")");
        }
        if(CommonUtil.isNumOrD(entity.getLabelIds())){
            String[] labelIds = entity.getLabelIds().split(",");
            for(String item : labelIds){
                sb.append(" and concat(',',e.label_ids,',') like '%,").append(item).append(",%'");
            }
        }
        if(CommonUtil.isNormalSql(entity.getSelKeyword())){
            sb.append("and ( e.name like '%").append(entity.getSelKeyword()).append("%' ");
            sb.append(" or e.number like '%").append(entity.getSelKeyword()).append("%' ");
            sb.append(" or e.sub_desc like '%").append(entity.getSelKeyword()).append("%') ");
        }
        if(!CommonUtil.isNull(entity.getMinPrice())){
            sb.append(" and e.sale_price >=").append(entity.getMinPrice());
        }
        if(!CommonUtil.isNull(entity.getMaxPrice())){
            sb.append(" and e.sale_price <=").append(entity.getMaxPrice());
        }

        entity.setSql(sb.toString());
    }
}
