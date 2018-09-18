package com.pop136.customerservice.service.user;

import com.pop136.customerservice.entity.user.Account;
import com.pop136.customerservice.entity.user.User;
import com.pop136.customerservice.entity.user.UserRole;
import com.pop136.customerservice.mapper.agent.user.UserMapper;
import com.pop136.customerservice.mapper.agent.user.UserRoleMapper;
import com.pop136.customerservice.service.AbstractBaseService;
import com.pop136.customerservice.service.common.DataDictService;
import com.pop136.customerservice.utils.*;
import com.pop136.customerservice.vo.user.UserComm;
import com.pop136.customerservice.vo.user.UserValueVo;
import com.pop136.customerservice.vo.user.search.UserValueSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService extends AbstractBaseService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private DataDictService dataDictService;

    @Autowired
    private UserRoleService userRoleService;


    public void init() {
        setMapper(userMapper);
    }

    public List<UserValueVo> findUserValueList(UserValueSearchVo searchVo) {
        return userMapper.findUserListByNameAndPasswd(searchVo);
    }

    public UserValueVo findUserValue(UserValueSearchVo searchVo) {
        return userMapper.findUserByNameAndPasswd(searchVo);
    }

    public UserComm getUserInfo(UserValueSearchVo searchVo)
    {
        UserComm usercomm = new UserComm();
        Account account = new Account();
        UserRole userRole = new UserRole();
        User user = new User();

        String strAccountDescription = "";
        String strAccountRegion = "";
        String strAccountDepartment = "";
        String strAccountCustomerStatus = "";
        String strUserRoleId = "";

        UserValueVo userValueVo = userMapper.findUserByNameAndPasswd(searchVo);
        if(userValueVo != null)
        {
            usercomm.setActorID(userValueVo.getUserroleid());
            account = userMapper.finAccountById(userValueVo.getUserid());
            if(account != null)
            {
                strAccountDescription = StringUtils.validateString(account.getDescription());
                strAccountRegion = StringUtils.validateString(account.getEmail_smtp());
                strAccountDepartment = StringUtils.validateString(account.getEmail_pwd());
                strAccountCustomerStatus = StringUtils.validateString(account.getEmail_pop3());
                strUserRoleId = StringUtils.validateString(userValueVo.getUserroleid());

                usercomm.setAccountID(String.valueOf(account.getId()));
                usercomm.setUserName(account.getName());
                usercomm.setAccountDescription(strAccountDescription);
                usercomm.setAccountRegion(strAccountRegion);
                usercomm.setAccountDepartment(strAccountDepartment);
                usercomm.setUserRoleID(strUserRoleId);
                usercomm.setAccountCustomerStatus(strAccountCustomerStatus);
            }

            userRole = userRoleMapper.findUserRoleById(userValueVo.getUserroleid());

            if(userRole != null)
            {
                usercomm.setUserID(userRole.getUserid());
                usercomm.setFrameworkid(userRole.getFrameworkid());
                usercomm.setPositionid(userRole.getPositionid());
                usercomm.setUserRoleTypeID(userRole.getTypeid());
                // 取得部门和职位名称
                String sFrameworkName = dataDictService.getNameByID("gp_framework", "id", "name", String
                        .valueOf(usercomm.getFrameworkid()));
                usercomm.setFrameworkName(sFrameworkName);

                String sPositionName = dataDictService.getNameByID( "gp_position", "id", "name", String
                        .valueOf(usercomm.getPositionid()));
                usercomm.setPositionName(sPositionName);
            }

            user = userMapper.findUserById(userRole.getUserid());
            if(user != null)
            {
                usercomm.setUserName(user.getName());
                usercomm.setListLeaveEmp(user.getListleaveemp());
                usercomm.setSex(String.valueOf(user.getSex()));
            }

            HashMap aMap = userRoleService.getLow(usercomm);
            String strVISLowFrameWorkID = "";
            String strVISLowFrameWorkName = "";
            String strVISLowUserRoleID = "";
            String strVISLowUserRoleName = "";
            String strVISLowSQLUserRoleID = "";
            String strVISAllSQLUserRoleID = "";
            // 将下级信息放入usercomm
            String str_lfi = (String) aMap.get("LFI");
            if(!StringUtil.checkString(str_lfi).equals(""))
                usercomm.setStrLowFrameWorkID( str_lfi+ "," + strVISLowFrameWorkID);

            String str_lfn = (String) aMap.get("LFN");
            if(!StringUtil.checkString(str_lfn).equals(""))
                usercomm.setStrLowFrameWorkID( str_lfn+ "," + strVISLowFrameWorkName);

            String str_lui = (String) aMap.get("LUI");
            if(!StringUtil.checkString(str_lui).equals(""))
                usercomm.setStrLowUserRoleID(str_lui + "," + strVISLowUserRoleID);

            String str_lun = (String) aMap.get("LUN");
            if(!StringUtil.checkString(str_lun).equals(""))
                usercomm.setStrLowUserRoleName(str_lun + "," + strVISLowUserRoleName);

            String strLowUserRoleID = usercomm.getStrLowUserRoleID() + ","
                    + strVISLowUserRoleID;
            strLowUserRoleID = "'" + strLowUserRoleID.replaceAll(",", "','") + "'";
            usercomm.setStrLowSQLUserRoleID(strLowUserRoleID.replaceAll(",''", ""));

            usercomm.setStrAllSQLUserRoleID((usercomm.getStrLowSQLUserRoleID()
                    + ",'" + usercomm.getActorID() + "'").replaceAll(",''", ""));
            usercomm.setStrAllSQLUserRoleName("全部");
        }



/*


        if(user != null)
        {
            usercomm.setUserName(user.getName());
            usercomm.setListLeaveEmp(user.getListleaveemp());
            usercomm.setSex(String.valueOf(user.getSex()));
        }

        // 取得主要职位下级员工
        System.out.println("取得主要职位下级员工");


        // 取得虚拟职位的下级员工
        Iterator itUR = userRoleService.getUserRoleListNoHaveMainByUserID(
                usercomm.getUserID(), 0, usercomm).iterator();
        String strVISLowFrameWorkID = "";
        String strVISLowFrameWorkName = "";
        String strVISLowUserRoleID = "";
        String strVISLowUserRoleName = "";
        String strVISLowSQLUserRoleID = "";
        String strVISAllSQLUserRoleID = "";
        while (itUR.hasNext()) {
            UserRole Value = (UserRole) itUR.next();
            HashMap iaMap = userRoleService.getLow(Value.getId(), usercomm);
           SystemPrint.PrintMessage("LFI" + Value.getId()
                    + (String) iaMap.get("LFI"));
            SystemPrint.PrintMessage("LFN" + Value.getId()
                    + (String) iaMap.get("LFN"));
            SystemPrint.PrintMessage("LUI" + Value.getId()
                    + (String) iaMap.get("LUI"));
            SystemPrint.PrintMessage("LUN" + Value.getId()
                    + (String) iaMap.get("LUN"));
            if (StringUtils.isValidateString((String) iaMap.get("LFI"))) {
                strVISLowFrameWorkID = (strVISLowFrameWorkID
                        + (String) iaMap.get("LFI") + ",");
            }
            if (StringUtils.isValidateString((String) iaMap.get("LFN"))) {
                strVISLowFrameWorkName = (strVISLowFrameWorkName
                        + (String) iaMap.get("LFN") + ",");
            }
            if (StringUtils.isValidateString((String) iaMap.get("LUI"))) {
                strVISLowUserRoleID = (strVISLowUserRoleID
                        + (String) iaMap.get("LUI") + ",");
            }
            if (StringUtils.isValidateString((String) iaMap.get("LUN"))) {
                strVISLowUserRoleName = (strVISLowUserRoleName
                        + (String) iaMap.get("LUN") + ",");
            }

            String striLowUserRoleID = (String) iaMap.get("LUI");
            if (StringUtils.isValidateString(striLowUserRoleID)) {
                strVISLowSQLUserRoleID = (strVISLowSQLUserRoleID
                        + striLowUserRoleID + ",");
            }
            if (StringUtils.isValidateString(strVISLowUserRoleID)) {
                strVISAllSQLUserRoleID = (strVISAllSQLUserRoleID
                        + strVISLowUserRoleID + ",");
            }
        }
        strVISLowFrameWorkID = StringUtils.cutEnd(strVISLowFrameWorkID, ",");
        strVISLowFrameWorkName = StringUtils
                .cutEnd(strVISLowFrameWorkName, ",");
        strVISLowUserRoleID = StringUtils.cutEnd(strVISLowUserRoleID, ",");
        strVISLowUserRoleName = StringUtils.cutEnd(strVISLowUserRoleName, ",");
        strVISLowSQLUserRoleID = StringUtils
                .cutEnd(strVISLowSQLUserRoleID, ",");
        strVISAllSQLUserRoleID = StringUtils
                .cutEnd(strVISAllSQLUserRoleID, ",");

        // 将下级信息放入usercomm
        usercomm.setStrLowFrameWorkID((String) aMap.get("LFI") + ","
                + strVISLowFrameWorkID);
        usercomm.setStrLowFrameWorkName((String) aMap.get("LFN") + ","
                + strVISLowFrameWorkName);
        usercomm.setStrLowUserRoleID((String) aMap.get("LUI") + ","
                + strVISLowUserRoleID);
        usercomm.setStrLowUserRoleName((String) aMap.get("LUN") + ","
                + strVISLowUserRoleName);
        String strLowUserRoleID = usercomm.getStrLowUserRoleID() + ","
                + strVISLowUserRoleID;
        strLowUserRoleID = "'" + strLowUserRoleID.replaceAll(",", "','") + "'";
        usercomm.setStrLowSQLUserRoleID(strLowUserRoleID.replaceAll(",''", ""));

        usercomm.setStrAllSQLUserRoleID((usercomm.getStrLowSQLUserRoleID()
                + ",'" + usercomm.getActorID() + "'").replaceAll(",''", ""));
        usercomm.setStrAllSQLUserRoleName("全部");

        // 取得模块权限
       //SystemPrint.PrintMessage("取得模块权限");
        userRoleService.getComponentID(String.valueOf(usercomm.getPositionid()),
                usercomm);
        String sCompnentID = "";
        for (int i = 0; i < usercomm.getCompnentID().length; i++) {
            sCompnentID = sCompnentID + "'" + (usercomm.getCompnentID()[i])
                    + "'" + ",";
        }
        // SystemPrint.PrintMessage("取得模块权限sCompnentID--->"+sCompnentID);
        usercomm.setStrCompnentID(sCompnentID);

        // 取得操作权限
        //SystemPrint.PrintMessage("取得操作权限");
        userRoleService.getPositionRightID(String.valueOf(usercomm.getPositionid()),   usercomm);
        String sRightCode = "";
        for (int i = 0; i < usercomm.getRightcode().length; i++) {
            sRightCode = sRightCode + (usercomm.getRightcode()[i]) + ",";
        }
        usercomm.setStrRightCode(sRightCode);

        // 取得公司可以使用的全部componentcode, admin关闭后的不显示
        userRoleService.getAllComponentCode(usercomm);

       SystemPrint.PrintMessage("显示UserComm中的数据－－begin");
        SystemPrint.PrintMessage("usercommLFI--->"
                + usercomm.getStrLowFrameWorkID());
        SystemPrint.PrintMessage("usercommLFN--->"
                + usercomm.getStrLowFrameWorkName());
        SystemPrint.PrintMessage("usercommLUI--->"
                + usercomm.getStrLowUserRoleID());
        SystemPrint.PrintMessage("usercommLUN--->"
                + usercomm.getStrLowUserRoleName());
        SystemPrint.PrintMessage("usercommSQLLUI--->"
                + usercomm.getStrLowSQLUserRoleID());
        SystemPrint.PrintMessage("getStrLowSQLUserRoleID--->"
                + usercomm.getStrLowSQLUserRoleID());
        SystemPrint.PrintMessage("getStrAllSQLUserRoleID--->"
                + usercomm.getStrAllSQLUserRoleID());
        SystemPrint.PrintMessage("userroleid--->" + usercomm.getActorID());
        SystemPrint.PrintMessage("frameworkid--->" + usercomm.getFrameworkid());
        SystemPrint.PrintMessage("frameworkname--->"
                + usercomm.getFrameworkName());
        SystemPrint.PrintMessage("positionid--->" + usercomm.getPositionid());
        SystemPrint.PrintMessage("positionname--->"
                + usercomm.getPositionName());
        for (int i = 0; i < usercomm.getCompnentID().length; i++) {
            SystemPrint.PrintMessage(usercomm.getCompnentID()[i]);
        }
        SystemPrint.PrintMessage("setStrCompnentID－－end"
                + usercomm.getStrCompnentID());

        for (int i = 0; i < usercomm.getRightcode().length; i++) {
            SystemPrint.PrintMessage(usercomm.getRightcode()[i]);
        }
        SystemPrint.PrintMessage("setStrRightCode－－end"
                + usercomm.getStrRightCode());
        SystemPrint.PrintMessage("显示UserComm中的数据－－end");

        // 是否显示产品树(针对产品数量比较大的客户) 0:不显示 1:显示
        BConfigGetSession cfSession = new BConfigGetSession();
        String isDisplayProductTree = cfSession.getCustomNameByValue(
                "displayproducttree", usercomm);
        int iIsDisplayProductTree = 0;
        try {
            iIsDisplayProductTree = StringUtils.str2int(StringUtils
                    .validateString(isDisplayProductTree));
        } catch (RuntimeException e) {
            iError += ErrorCollection.inError(e);
        }
        System.out.println("iIsDisplayProductTree----" + iIsDisplayProductTree);
        usercomm.setIsDisplayProductTree(iIsDisplayProductTree);

        // 如果在个人设置中设置了界面风格和语言，则将设置的值放入usercomm
        UserSettingCommonSession usCommonSession = new UserSettingCommonSession();
        usCommonSession.setSessionUserSettingValueByUserRoleID(usercomm);

        // 取金额几位小数
        String strMoneyDecimalNum = cfSession.getCustomNameByValue(
                "moneydecimalnum", usercomm);
        int iMoneyDecimalNum = 0;
        try {
            iMoneyDecimalNum = StringUtils.str2int(StringUtils
                    .validateString(strMoneyDecimalNum));
            usercomm.setGHPTITLE(getTitle(usercomm));

        } catch (RuntimeException e) {
            iError += ErrorCollection.inError(e);
        }
        usercomm.setIZeroFixed(iMoneyDecimalNum);

        // 取survey服务器地址
*        if (sp.getSettingBooleanValue(TpSettingCommonSession.IsPlugInSurvey,
                usercomm)) {
            SystemSurvey systemSurvey = new SystemSurvey();
            usercomm.setSurveyIP(systemSurvey.getSurveyIP());
            usercomm.setSurveyOuterIP(systemSurvey.getSurveyOuterIP());
            usercomm.setSurveymailaddress(systemSurvey.getSurveymailaddress());
        }
        */

        return usercomm;
    }

    public UserComm login(String username, String passwd) throws Exception
    {
        UserValueSearchVo searchVo = new UserValueSearchVo();
        searchVo.setName(username);
        searchVo.setPasswd(MD5.GetMD5(passwd));
        UserComm userComm = getUserInfo(searchVo);

        return userComm;
    }

    public User findUserById(String id)
    {
        return userMapper.findUserById(id);
    }

    public UserRole findUserRoleById(String id)
    {
        return userRoleMapper.findUserRoleById(id);
    }

    public User getUserInfo(String ownerroleid) {
        return userMapper.getUserInfo(ownerroleid);
    }
}
