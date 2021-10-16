package com.laycoding.common.enums;

/**
 *
 * @author laycoding
 * @since 2021-10-15
 */
public enum FolderReqTypeEnum {
    /**
     * 创建的自定义文件夹
     */
    CREATE_FILE(0,"自定义"),

    RECENT_FILE(1,"最近文件"),

    COLLECT_FILE(2,"收藏文件"),

    DELETE_FILE(-1,"删除文件")
    ;


    private Integer type;

    private String desc;


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    FolderReqTypeEnum(Integer type, String desc){
        this.type =type;
        this.desc =desc;
    }


}
