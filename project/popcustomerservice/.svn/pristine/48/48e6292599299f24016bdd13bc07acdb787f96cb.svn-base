package com.pop136.customerservice.service.user;

import com.pop136.customerservice.entity.user.FrameWork;
import com.pop136.customerservice.mapper.agent.user.UserRoleMapper;
import com.pop136.customerservice.service.AbstractBaseService;
import com.pop136.customerservice.utils.StringUtils;
import com.pop136.customerservice.vo.user.UserComm;
import com.pop136.customerservice.vo.user.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class UserRoleService extends AbstractBaseService {

    @Autowired
    private UserRoleMapper userRoleMapper;


    public void init() {
        setMapper(userRoleMapper);
    }

    /***************************************************************************
     * 主要职位 以下是比较重要的，通过userroleid获得该员工的下级员工的vector－－－begin
     **************************************************************************/

    // 获得员工的下属的部门,部门ID，员工userroleid，员工名称
    /*
	 * SystemPrint.PrintMessage("LFI--->"+(String)aMap.get("LFI")); 下属部门ID
	 * SystemPrint.PrintMessage("LFN--->"+(String)aMap.get("LFN")); 下属部门名字
	 * SystemPrint.PrintMessage("LUI--->"+(String)aMap.get("LUI")); 下属的员工ID
	 * SystemPrint.PrintMessage("LUN--->"+(String)aMap.get("LUN")); 下属的员工名字
	 */
    public HashMap getLow(UserComm usercomm){
        HashMap aMap = new HashMap();
        String strLowFrameWorkID = "";
        String strLowFrameWorkName = "";
        String strLowUserID = "";
        String strLowUserName = "";
        List aLowFrameWorkList = new ArrayList();
        List<Integer> frameworkIds = new ArrayList<Integer>();
        aLowFrameWorkList = userRoleMapper.getAllFrameWorkId(usercomm.getFrameworkid());
        for (int i = 0; i < aLowFrameWorkList.size(); i++) {
            UserVo value = (UserVo) aLowFrameWorkList.get(i);
            frameworkIds.add(value.getFrameworkid());
        }
        frameworkIds.add(usercomm.getFrameworkid());
        aLowFrameWorkList = userRoleMapper.getAllFrameWorkById(frameworkIds);
        //aLowFrameWorkList = getFrameWorkId(false, usercomm.getFrameworkid(), aLowFrameWorkList);

/*        aLowFrameWorkList = getFrameWorkId(false, usercomm.getFrameworkid(), aLowFrameWorkList);*/
        if (aLowFrameWorkList.size() > 0) {
            for (int i = 0; i < aLowFrameWorkList.size(); i++) {
                UserVo value = (UserVo) aLowFrameWorkList.get(i);
                    strLowFrameWorkID = strLowFrameWorkID + value.getFrameworkid() + ",";
                    strLowFrameWorkName = strLowFrameWorkName + value.getFrameworkname();
                    strLowUserID = strLowUserID + value.getRoleid() + ",";
                    strLowUserName = strLowUserName + value.getUsername() + ",";
            }
            aMap.put("LFI", StringUtils.cutEnd(strLowFrameWorkID, ","));
            aMap.put("LFN", StringUtils.cutEnd(strLowFrameWorkName, ","));
            aMap.put("LUI", StringUtils.cutEnd(strLowUserID, ","));
            aMap.put("LUN", StringUtils.cutEnd(strLowUserName, ","));
        } else {
            aMap.put("LFI", "");
            aMap.put("LFN", "");
            aMap.put("LUI", "");
            aMap.put("LUN", "");
        }
        return aMap;
    }

    // 获得员工的下属的部门,部门ID，员工userroleid，员工名称
	/*
	 * SystemPrint.PrintMessage("LFI--->"+(String)aMap.get("LFI")); 下属部门ID
	 * SystemPrint.PrintMessage("LFN--->"+(String)aMap.get("LFN")); 下属部门名字
	 * SystemPrint.PrintMessage("LUI--->"+(String)aMap.get("LUI")); 下属的员工ID
	 * SystemPrint.PrintMessage("LUN--->"+(String)aMap.get("LUN")); 下属的员工名字
	 */
    public HashMap getLow(String visUserRoleID, UserComm usercomm) {
        HashMap aMap = new HashMap();
        String strLowFrameWorkID = "";
        String strLowFrameWorkName = "";
        String strLowUserID = "";
        String strLowUserName = "";
        ArrayList aLowFrameWorkList = new ArrayList();
        aLowFrameWorkList = getPrivateFrameWorkId(visUserRoleID, usercomm);
        if (aLowFrameWorkList.size() > 0) {
            for (int i = 0; i < aLowFrameWorkList.size(); i++) {
                FrameWork value = (FrameWork) aLowFrameWorkList.get(i);
                if ((value.getTypeid()).equals("0")) {
                    strLowFrameWorkID = strLowFrameWorkID + value.getId() + ",";
                    strLowFrameWorkName = strLowFrameWorkName + value.getName()
                            + ",";
                } else if (value.getTypeid().equals("1")) {
                    strLowUserID = strLowUserID + value.getId() + ",";
                    strLowUserName = strLowUserName + value.getName() + ",";
                }
            }
            aMap.put("LFI", StringUtils.cutEnd(strLowFrameWorkID, ","));
            aMap.put("LFN", StringUtils.cutEnd(strLowFrameWorkName, ","));
            aMap.put("LUI", StringUtils.cutEnd(strLowUserID, ","));
            aMap.put("LUN", StringUtils.cutEnd(strLowUserName, ","));
        } else {
            aMap.put("LFI", "");
            aMap.put("LFN", "");
            aMap.put("LUI", "");
            aMap.put("LUN", "");
        }
        // SystemPrint.PrintMessage("LFI--->" + (String) aMap.get("LFI"));
        // SystemPrint.PrintMessage("LFN--->" + (String) aMap.get("LFN"));
        // SystemPrint.PrintMessage("LUI--->" + (String) aMap.get("LUI"));
        // SystemPrint.PrintMessage("LUN--->" + (String) aMap.get("LUN"));
        return aMap;
    }

/*    *//**
     * 根据frameworkid获得下属所有的员工和部门 不包括同级员工
     *//*
    List<UserVo> resultList = new CopyOnWriteArrayList<UserVo>();
    Map<String, String> userMap = new HashMap<String, String>();
    private List<UserVo> getFrameWorkId(boolean iDisplayAllUsers, int iFrameWorkFatherID, List<UserVo> list){
        List<UserVo> subList =  new ArrayList<UserVo>();
        for(int i = 0 ; i < list.size(); ++i )
        {
            UserVo user = list.get(i);
            System.out.println(i);
            if (userMap.get(user.getRoleid()) == null)
            {
                resultList.add(user);
                userMap.put(user.getRoleid(), user.getRoleid());
                subList = userRoleMapper.getAllFrameWorkById(user.getFrameworkid());
                for(UserVo subUser : subList)
                {
                    list.add(subUser);
                }
                list.remove(user);
                getFrameWorkId(true, user.getFrameworkid(), list);
            }
            i = i +1;
        }
        return resultList;
        //return resultList;
    }*/

    public Collection getUserRoleListNoHaveMainByUserID(String userID,
                                                        int listSize, UserComm usercomm){
        ArrayList mList = new ArrayList();

/*        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = " SELECT "
                + CommPrepareStatementFilter.getLimitSQL(0, listSize)
                + this.COL_USERROLE + " FROM " + this.TAB_USERROLE + " a "
                + " where a.roletype='1' and a.deleteflag=0 ";
        sql = CommPrepareStatementFilter.getWholeSqlByGrpOrgLocCode(
                CommPrepareStatementFilter.GOL_GRPORG, sql, "", usercomm);

        // 查询条件
        sql += " and a.userid = ? ";

        String strOrderBy = " a.lastupdatetime desc ";

        sql += " order by roletype, deleteflag, createtime  ";

        if (listSize > 0) {
            sql = CommPrepareStatementFilter.getLimitForWholeSQL(sql, 0,
                    listSize);
        }

        SystemPrint.PrintMessage(sql);

        try {
            con = SimpleConnetionPool.getConnection(usercomm);
            ps = CommPrepareStatementFilter.getPrepareStatement(con, sql);
            ps.setString(1, userID);
            rs = SimpleConnetionPool.doExecuteQuery(ps);
            SystemPrint.PrintMessage(ps);

            while (rs.next()) {
                int k = 1;
                if (true) {
                    UserRoleForm value = getValueFromRS(rs, k);

                    String userName = GNI.getUserNameByID(value.getUserid(),
                            usercomm);
                    value.setUsername(userName);
                    String frameWorkName = GNI.getFrameworkByID(value
                            .getFrameworkid(), usercomm);
                    value.setFrameworkname(frameWorkName);
                    String positionName = GNI.getNameByID(
                            PositionCommonSession.TAB_POSITION, "id", "name",
                            String.valueOf(value.getPositionid()), usercomm);
                    value.setPositionname(positionName);

                    mList.add(value);
                }
            }
        } catch (Exception e) {
            SimpleConnetionPool
                    .printError("[getUserRoleListNoHaveMainByUserID]" + sql
                            + e.toString());
            throw e;
        } finally {
            SystemGC.setNull(rs);
            SimpleConnetionPool.releaseConnection(ps, con, usercomm);
        }*/
        return mList;

    }

    /**
     * 根据frameworkid获得下属所有的员工和部门 不包括同级员工
     */
    private ArrayList getPrivateFrameWorkId(String visUserRoleID,
                                            UserComm usercomm) {
        ArrayList list = new ArrayList();
        int i = 0;

/*        // 根据UserRoleID获得UserRoleForm
        SearchUserRoleForm sUrForm = new SearchUserRoleForm();
        sUrForm.setId(visUserRoleID);
        UserRoleGetSession urSession = new UserRoleGetSession();
        UserRoleForm urForm = urSession.getUserRoleValueByPK(sUrForm, usercomm);

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // 是否显示同级员工
        // 0为不显示
        // 1为显示
        if (usercomm.getListSameLevelEmp() == 1) {
            list = getUserByFrameWorkId(list, String.valueOf(urForm
                    .getFrameworkid()), i, usercomm);
        }

        String sql = "SELECT a.id as id, a.name as name, a.fatherid as fatherid FROM "+FrameworkCommonSession.TAB_FRAMEWORK+" a "
                + "WHERE a.deleteflag=0 and a.fatherid = ? ";
        sql = CommPrepareStatementFilter.getWholeSqlByGrpOrgLocCode(CommPrepareStatementFilter.GOL_GRPORG, sql, "", usercomm);

        con = SimpleConnetionPool.getConnection(usercomm);
        ps = CommPrepareStatementFilter.getPrepareStatement(con, sql);
        ps.setInt(1, urForm.getFrameworkid());
        rs = SimpleConnetionPool.doExecuteQuery(ps);
        SystemPrint.PrintMessage(ps);
        try {
            while (rs.next()) {
                int k = 1;
                FrameWorkForm value = new FrameWorkForm();
                value.setId(rs.getString("id"));
                value.setName(rs.getString("name"));
                value.setFatherid(rs.getString("fatherid"));
                value.setTypeid("0");
                value.setFlag(i);

                list.add(value);
                list = getUserByFrameWorkId(list, value.getId(), i + 1,
                        usercomm);
                list = getFrameWork(list, value.getId(), i + 1, usercomm);
            }
        } catch (Exception e) {
            SimpleConnetionPool.printError("[getPrivateFrameWorkId]" + sql
                    + e.toString());
            throw e;
        } finally {
            SystemGC.setNull(rs);
            SimpleConnetionPool.releaseConnection(ps, con, usercomm);
        }*/
        return list;
    }

    /**
     * 获取该员工的模块权限 参数：用户id 返回：职位id
     */
    public boolean getComponentID(String iPositionID, UserComm usercomm)
           {

        boolean bReturn = false;
/*               Connection con = null;
               PreparedStatement ps = null;
               ResultSet rs = null;
        SimpleConnetionPool.printLog("模块权限－－员工iPositionID为[" + iPositionID
                + "]");
        // 获取该员工的模块权限
        String sql = " SELECT  a.componentid " + " FROM "
                + PositionCommonSession.TAB_POSITIONRIGHT + " a " + " WHERE  "
                + " SUBSTRING(a.rightcode, 32, 1)=1 "
                + " AND a.deleteflag = 0 " + " AND a.positionid =? ";
        sql = CommPrepareStatementFilter.getWholeSqlByGrpOrgLocCode(
                CommPrepareStatementFilter.GOL_NONE, sql, "a", usercomm);
        if ((iPositionID != null)
                && (!(StringUtils.validateString(iPositionID).equals("")))) {
            try {
                con = SimpleConnetionPool.getConnection(usercomm);
                ps = CommPrepareStatementFilter.getPrepareStatement(con, sql);

                ps.setString(1, iPositionID);
                rs = SimpleConnetionPool.doExecuteQuery(ps);

                bReturn = true;
                int k = 0;
                LinkedList ilist = new LinkedList();
                while (rs.next()) {
                    ilist.add(k, rs.getString(1));
                    SystemPrint.PrintMessage(k + "---"
                            + (String) (ilist.get(k)));
                    k = k + 1;
                }
                if (k == 0) {
                    bReturn = false;
                    SimpleConnetionPool.printLog("此员工无模块权限－－员工iPositionID为["
                            + iPositionID + "]");
                }

                SystemPrint.PrintMessage("-----------------------");
                String[] s = new String[k];

                for (int i = 0; i < k; i++) {
                    s[i] = (String) (ilist.get(i));
                    SystemPrint.PrintMessage(i + "---" + s[i]);
                }
                usercomm.setCompnentID(s);
            } catch (Exception e) {
                SimpleConnetionPool
                        .printError("[login-->session--->LoginGetSession--->getComponentID]"
                                + sql + e.toString());
                throw e;
            } finally {
                SystemGC.setNull(rs);
                SimpleConnetionPool.releaseConnection(ps, con, usercomm);
            }
        }*/
        return bReturn;
    }

    /*
     * 获取该员工的权限 参数：用户id 返回：职位id
     */
    public boolean getPositionRightID(String iPositionID, UserComm usercomm)
            {
        boolean bReturn = false;
/*        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // 得到缺省的功能模块id、操作权限信息
        String sql = " SELECT  c.id,p.rightcode,"
                + " SUBSTRING(p.rightcode,c.rcposition + 1,1) as rightid,"
                + " c.componentname , c.rightname " + " FROM "
                + PositionCommonSession.TAB_POSITIONRIGHT + " p, "
                + PositionCommonSession.TAB_COMPONENTRIGHTTYPE + " c "
                + " WHERE p.componentid = c.componentid"
                + " AND SUBSTRING(p.rightcode,c.rcposition + 1,1) = 1 "
                + " AND p.deleteflag = 0 " + " AND p.positionid =? ";
        sql = CommPrepareStatementFilter.getWholeSqlByGrpOrgLocCode(
                CommPrepareStatementFilter.GOL_NONE, sql, "p", usercomm);
        sql = CommPrepareStatementFilter.getWholeSqlByGrpOrgLocCode(
                CommPrepareStatementFilter.GOL_NONE, sql, "c", usercomm);
        if ((iPositionID != null)
                && (!(StringUtils.validateString(iPositionID).equals("")))) {
            try {
                con = SimpleConnetionPool.getConnection(usercomm);
                ps = CommPrepareStatementFilter.getPrepareStatement(con, sql);

                ps.setString(1, iPositionID);
                rs = SimpleConnetionPool.doExecuteQuery(ps);

                bReturn = true;
                int k = 0;
                LinkedList ilist = new LinkedList();
                while (rs.next()) {
                    ilist.add(k, rs.getString(1));
                    SystemPrint.PrintMessage(k + "---"
                            + (String) (ilist.get(k)));
                    k = k + 1;
                }

                if (k == 0) {
                    bReturn = false;
                    SimpleConnetionPool.printLog("查无此员工－－员工iPositionID为["
                            + iPositionID + "]");
                }

                SystemPrint.PrintMessage("-----------------------");
                String[] s = new String[k];

                for (int i = 0; i < k; i++) {
                    s[i] = (String) (ilist.get(i));
                    SystemPrint.PrintMessage(i + "---" + s[i]);
                }
                usercomm.setRightcode(s);
            } catch (Exception e) {
                SimpleConnetionPool
                        .printError("[login-->session--->LoginGetSession--->getPositionRightID]"
                                + sql + e.toString());
                throw e;
            } finally {
                SystemGC.setNull(rs);
                SimpleConnetionPool.releaseConnection(ps, con, usercomm);
            }
        }*/
        return bReturn;
    }

    /**
     * 取得该公司可以使用的全部模块
     *
     * @param usercomm
     * @return
     */
    public boolean getAllComponentCode(UserComm usercomm){
        boolean bReturn = false;
/*        PositionRightGetSession eSession = new PositionRightGetSession();
        try {
            ArrayList positionRightModelList = eSession
                    .getComponentRightModel(usercomm);
            int k = positionRightModelList.size();
            HashMap mList = new HashMap();
            for (int i = 0; i < k; i++) {
                ComponentRightTypeForm crValue = (ComponentRightTypeForm) positionRightModelList
                        .get(i);
                mList.put(String.valueOf(crValue.getComponentid()), crValue
                        .getComponentname());
            }
            usercomm.setComponentCodeMap(mList);
        } catch (Exception e) {
            SimpleConnetionPool
                    .printError("[login-->session--->LoginGetSession--->getAllComponentCode]"
                            + e.toString());
            throw e;
        }*/
        return bReturn;
    }

}
