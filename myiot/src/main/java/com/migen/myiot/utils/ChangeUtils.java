package com.migen.myiot.utils;

import com.migen.myiot.enums.Constants;

/**
 *
 * @author fengy
 *
 */
public class ChangeUtils {

	/**
	 * 警告类型转换成实际内容
	 *
	 * @param subType
	 * @return
	 */
	public static String warnType(String subType) {
		String content = "";
		if (Constants.OUTER_SUB_WARN_NUMS.equals(subType)) {
			content = "生产即将完成";
		} else if (Constants.OUTER_SUB_WARN_POI.equals(subType)) {
			content = "银行租用即将到期";
		} else if (Constants.OUTER_SUB_WARN_TROUBLE.equals(subType)) {
			content = "机械故障";
		} else if (Constants.OUTER_SUB_WARN_LOCK.equals(subType)) {
			content = "机器已锁定";
		} else if (Constants.OUTER_SUB_WARN_CLOSE.equals(subType)) {
			content = "机器异常关机";
		} else if (Constants.OUTER_SUB_WARN_OTHER.equals(subType)) {
			content = "未知故障";
		} else if (Constants.OUTER_SUB_WARN_CHANGEID.equals(subType)) {
			content = "智盒编号更换";
		} else if (Constants.OUTER_SUB_WARN_BATTERY.equals(subType)) {
			content = "电量不足";
		} else if (Constants.OUTER_SUB_WARN_CONNCLOSE.equals(subType)) {
			content = "连接关闭";
		}

		return content;
	}

	/**
	 * @param pri
	 * @return
	 */
	public static String warnPri(int pri) {
		String content = "";
		if (pri == 1) {
			content = "重要";
		} else if (pri == 2) {
			content = "主要";
		} else if (pri == 3) {
			content = "次要";
		} else if (pri == 4) {
			content = "一般";
		}

		return content;
	}

	/**
	 * @param node
	 * @return
	 */
	public static String warnNode(int node) {
		String content = "";
		if (node == 1) {
			content = "智盒";
		} else if (node == 2) {
			content = "机器";
		} else if (node == 3) {
			content = "智盒云";
		} else if (node == 4) {
			content = "未知";
		}

		return content;
	}

	/**
	 * @param subType
	 * @return
	 */
	public static int warnTypeToNode(String subType) {
		int content = 4;
		if (Constants.OUTER_SUB_WARN_NUMS.equals(subType)) {
			content = 1;
		} else if (Constants.OUTER_SUB_WARN_POI.equals(subType)) {
			content = 1;
		} else if (Constants.OUTER_SUB_WARN_TROUBLE.equals(subType)) {
			content = 2;
		} else if (Constants.OUTER_SUB_WARN_LOCK.equals(subType)) {
			content = 2;
		} else if (Constants.OUTER_SUB_WARN_CLOSE.equals(subType)) {
			content = 2;
		} else if (Constants.OUTER_SUB_WARN_OTHER.equals(subType)) {
			content = 4;
		} else if (Constants.OUTER_SUB_WARN_CHANGEID.equals(subType)) {
			content = 3;
		} else if (Constants.OUTER_SUB_WARN_BATTERY.equals(subType)) {
			content = 2;
		} else if (Constants.OUTER_SUB_WARN_CONNCLOSE.equals(subType)) {
			content = 4;
		}

		return content;
	}

	/**
	 * @param subType
	 * @return
	 */
	public static int warnTypeToPri(String subType) {
		int content = 4;
		if (Constants.OUTER_SUB_WARN_NUMS.equals(subType)) {
			content = 4;
		} else if (Constants.OUTER_SUB_WARN_POI.equals(subType)) {
			content = 1;
		} else if (Constants.OUTER_SUB_WARN_TROUBLE.equals(subType)) {
			content = 1;
		} else if (Constants.OUTER_SUB_WARN_LOCK.equals(subType)) {
			content = 2;
		} else if (Constants.OUTER_SUB_WARN_CLOSE.equals(subType)) {
			content = 1;
		} else if (Constants.OUTER_SUB_WARN_OTHER.equals(subType)) {
			content = 4;
		} else if (Constants.OUTER_SUB_WARN_CHANGEID.equals(subType)) {
			content = 4;
		} else if (Constants.OUTER_SUB_WARN_BATTERY.equals(subType)) {
			content = 3;
		} else if (Constants.OUTER_SUB_WARN_CONNCLOSE.equals(subType)) {
			content = 4;
		}

		return content;
	}
}
