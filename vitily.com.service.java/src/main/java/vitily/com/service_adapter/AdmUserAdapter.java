package vitily.com.service_adapter;

import vitily.com.api_entity.req_entity.other.TqUserLogin;
import vitily.com.tb_entity.adm.TbAdmUser;
import vitily.com.tv_entity.adm.TvAdmUser;

public interface AdmUserAdapter {
    void logout(TqUserLogin req)throws Exception;
    void checkAdmin(TvAdmUser admin)throws Exception;
    String encryPassword(TbAdmUser entity, String customerPassword);
    String encryToken(TbAdmUser entity);
    String getTotalPermissionStr(TvAdmUser admin);
    TvAdmUser getTvAdminByToken(TqUserLogin req)throws Exception;
    TvAdmUser getTvAdminByUserName(TqUserLogin req)throws Exception;
}
