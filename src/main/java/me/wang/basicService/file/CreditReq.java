package me.wang.basicService.file;

import lombok.Data;

/**
 * @author wangbing
 * @date 2021/1/14
 * @description
 */
@Data
public class CreditReq {
    private String appKey;
    private String entName;
    private String entCode;
    private String uploadTime;
    private String checkTime;
}
