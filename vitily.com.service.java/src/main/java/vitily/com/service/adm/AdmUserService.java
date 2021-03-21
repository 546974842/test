package vitily.com.service.adm;

import vitily.com.service.base.BasicService;
import vitily.com.api_entity.req_entity.other.TqUserLogin;
import vitily.com.tb_entity.adm.TbAdmUser;
import vitily.com.other_entity.CustomerException;
import vitily.com.other_entity.UserStorage;
import vitily.com.ts_entity.adm.TsAdmUser;
import vitily.com.tv_entity.adm.TvAdmUser;

public interface AdmUserService extends BasicService<TbAdmUser,TsAdmUser,TvAdmUser> {
	 /**
     * 根据密码修改用户信息
     * @param admin 1
     * @param newPassword 2
     * @throws Exception 3
     */
	 void updateByPassword(TbAdmUser admin, String newPassword)throws Exception;
	 /**
     * 根据id查询用户：
     * @param id 1
     * @return 2
     */
	 TvAdmUser getTvAdminById(int id)throws Exception;
    /**
     * 用户登陆
     * @param req 请求实体
     * @return 1
     * @throws CustomerException 2
     * @throws Exception 3
     */
	UserStorage login(TqUserLogin req)throws Exception;
}