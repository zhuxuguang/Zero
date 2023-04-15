package com.zero.common.utils;

/**
 * @Author: ZhuXuGuang
 * @Description: 常量信息-提供相应常量参数
 * @Date: create in 2022/3/22 22:08
 */
public class CbConstants {

    /** 保存状态 */
    public static final String SAVE_STATUS = "0";

    /** 提交状态 */
    public static final String SUBMIT_STATUS = "1";

    /** 审核状态 */
    public static final String CHECK_STATUS = "2";

    /** 反审核状态 */
    public static final String ON_CHECK_STATUS = "3";

    /** 正常状态 */
    public static final String NORMAL_STATUS = "0";

    /** 禁用状态 */
    public static final String DEAD_STATUS = "1";

    /** 入司方式-社招 */
    public static final String SOCIAL_RECRUITMENT = "0";

    /** 入司方式-校招 */
    public static final String PROJECT_ENGINEER = "1";

    /** 就业状态 */
    public static final String EMPLOYMENT_TYPE  = "31";

    /** 板块 */
    public static final String PLATES_TYPE  = "32";

    /** 岗位属性 */
    public static final String POST_PROPERTIES_TYPE  = "33";

    /** 职位信息 */
    public static final String POSITION_TYPE  = "34";

    /** 不缴纳社保 */
    public static final String SOCIAL_SECURITY_TYPE_NO = "0";

    /** 缴纳社保 */
    public static final String SOCIAL_SECURITY_TYPE_YES = "1";

    /** 工伤 */
    public static final String WORK_INJURY_TYPE = "1";

    /** 养老 */
    public static final String YANG_LAO_TYPE = "2";

    /** 失业 */
    public static final String UNEMPLOYMENT_TYPE = "3";

    /** 医疗 */
    public static final String MEDICAL_TREATMENT_TYPE = "4";

    /** 公积金 */
    public static final String ACCUMULATION_FUND_TYPE = "5";

    /** 大病医疗 */
    public static final String ILLNESS_MEDICAL_TYPE = "6";

    //就业状态
    /** 就业状态-在职 */
    public static final String EMPLOYMENT_ON_JOB = "1";

    /** 就业状态-离职(正常，个人承担个人部分) */
    public static final String EMPLOYMENT_SEPARATION = "2";

    /** 就业状态-离职(非正常，全额承担) */
    public static final String EMPLOYMENT_ABNORMAL_RESIGNATION = "3";

    /** 就业状态-暂时请假(统筹全部个人承担超过一个月自动离职) */
    public static final String EMPLOYMENT_TEMPORARY_LEAVE = "4";

    /** 就业状态-特殊交社保(需选定代扣人) */
    public static final String EMPLOYMENT_SPECIAL_PAY = "5";

    /** 就业状态-实习(不交统筹) */
    public static final String EMPLOYMENT_PRACTICE = "6";

    /** 就业状态-返聘(不交统筹) */
    public static final String EMPLOYMENT_DIS = "7";

    /** 就业状态-其他 */
    public static final String EMPLOYMENT_ELSE = "8";

    /** 操作类型-自动生成 */
    public static final String AUTOMATICALLY_TYPE = "1";

    /** 操作类型-手动获取 */
    public static final String HAND_MOVEMENT_TYPE = "2";

    /** 操作类型-手动补录 */
    public static final String MANUAL_COLLECTION_TYPE = "3";

    /** 操作类型-社保补缴 */
    public static final String CONSCIENCE_MONEY_TYPE = "4";

    /** 数据状态-正常状态 */
    public static final String DATA_STATE_NORMAL = "0";

    /** 数据状态-锁定状态 */
    public static final String DATA_STATE_LOCK = "1";

    /** 人资管理信息系统 */
    public static final String HR_IS = "HR";

    /** 管理费用 */
    public static final String HANDLING_EXPENSE  = "1";

    /** 销售费用 */
    public static final String SELLING_EXPENSE  = "2";

    /** 制造费用 */
    public static final String MANUFACTURING_EXPENSE  = "3";

    //员工事件
    /** 入职 */
    public static final String INCIDENT_ENTRY = "1";

    /** 离职 */
    public static final String INCIDENT_DIMISSION = "2";

    /** 请假 */
    public static final String INCIDENT_LEAVE = "3";

    /** 员工调出 */
    public static final String COME_INCIDENT_TRANSFER = "5";

    /** 员工调入 */
    public static final String ENTER_INCIDENT_TRANSFER = "4";


    /** 特殊事件 */
    public static final String MARKET_ONE = "0";

    /** 退休 */
    public static final String MARKET_TWO = "1";

    /** 合同到期 */
    public static final String MARKET_THREE = "2";

    /** 次月继续缴纳社保 */
    public static final String PAYMENT_YES = "0";

    /** 次月不在继续缴纳社保 */
    public static final String PAYMENT_NO = "1";

    /** 未计算 */
    public static final String OPERATION_YES = "0";

    /** 已计算 */
    public static final String OPERATION_NO = "1";

    /** 数据初始化为0 */
    public static final String ZERO = "0";

    /** 数据合并状态 未合并 0 */
    public static final String MERGE_STATUS_NO = "0";

    /** 数据合并状态 已合并 1 */
    public static final String MERGE_STATUS_YES = "1";

}
