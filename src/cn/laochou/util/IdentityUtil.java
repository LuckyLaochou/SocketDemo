package cn.laochou.util;

import cn.laochou.common.MessageFormat;
import cn.laochou.enums.IdentityEnums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 身份工具
 */
public class IdentityUtil {

    /**
     * 判断身份是否合法
     * @param message 消息
     * @return true | false
     */
    public static boolean isLegal(String message) {
        if(message == null || message.length() == 0) return false;
        Pattern pattern = Pattern.compile("^[1-3].*");
        Matcher matcher = pattern.matcher(message);
        return matcher.matches();
    }

    /**
     * 获取身份
     * @return 身份
     */
    public static IdentityEnums getIdentity(String message) {
        // 在这里注意，返回的时候，可能存在NullPointerException问题
        // 所以我新增了一个身份枚举（不存在）
        // 事实上，调用这个方法的时候，在目前的场景已经验证过了。就怕以后的业务迭代过程中存在隐患
        if(message == null || message.length() == 0) return IdentityEnums.NOT_EXIST;
        String identityCode = message.substring(0, message.indexOf(MessageFormat.MESSAGE_SEPARATOR));
        return getIdentityByCode(identityCode);
    }


    private static IdentityEnums getIdentityByCode(String code) {
        switch (code) {
            case "1" : return IdentityEnums.PC;
            case "2" : return IdentityEnums.PHONE;
            case "3" : return IdentityEnums.SERVER;
            default:return IdentityEnums.NOT_EXIST;
        }
    }

}
