package com.zero.common.enums;

/**
 * 业务操作类型
 * 
 * @author ruoyi
 */
public enum BusinessType
{
    /**
     * 其它
     */
    OTHER,

    /**
     * 新增
     */
    INSERT,

    /**
     * 修改
     */
    UPDATE,

    /**
     * 删除
     */
    DELETE,

    /**
     * 授权
     */
    GRANT,

    /**
     * 导出
     */
    EXPORT,

    /**
     * 导入
     */
    IMPORT,

    /**
     * 强退
     */
    FORCE,

    /**
     * 生成代码
     */
    GENCODE,
    
    /**
     * 清空数据
     */
    CLEAN,

    /**
     * 模板下载
     */
    TEMPLATE_DOWNLOAD,

    /**
     * 审核
     */
    CHECK,

    /**
     * 反审
     */
    ON_CHECK,

    /**
     * 第三方查询接口调用
     */
    WEBAPI_SELECT,

    /**
     * 合并
     */
    MERGE

}
