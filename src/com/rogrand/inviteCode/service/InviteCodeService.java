package com.rogrand.inviteCode.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.inviteCode.domain.InviteCode;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：邀请码 Service
 */
@Service("InviteCodeService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class InviteCodeService extends BaseService {
    /**
     * 查询邀请码对象
     * @param id 字符串型主键
     * @return InviteCode
     * @throws Exception 异常
     */
    public InviteCode query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_invite_code.pageList", param);
    }

    /**
     * 查询邀请码对象集合
     * @param param 查询条件
     * @return List<InviteCode>
     * @throws Exception 异常
     */
    public List<InviteCode> list(PageParam param) throws Exception {
    	return sqlDao.list("t_invite_code.pageList",param);
    }
    
    /**
     * 邀请码翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_invite_code.pageCount");
    	param.setRecordSql("t_invite_code.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入邀请码记录
     * @param inviteCode 邀请码对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(InviteCode inviteCode) throws Exception  {
        sqlDao.create("t_invite_code.create",inviteCode);
        return "1";
    }

    /**
     * 更新邀请码记录
     * @param inviteCode 邀请码对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(InviteCode inviteCode) throws Exception {
        sqlDao.update("t_invite_code.update", inviteCode);
        return "1";
    }

    /**
     * 删除邀请码记录
     * @param inviteCode 邀请码对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(InviteCode inviteCode) throws Exception {
        sqlDao.delete("t_invite_code.delete", inviteCode);
        return "1";
    }

    /**
     * 删除邀请码记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new InviteCode(id));
    }

    /**
     * 删除邀请码记录
     * @param ids 字符串型主键数组
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String[] ids) throws Exception {
        for(String id:ids){
            delete(id);
        }
        return "1";
    }
}