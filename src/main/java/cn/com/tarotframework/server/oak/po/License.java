package cn.com.tarotframework.server.oak.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * copyright (C), 2022, 塔罗牌基础架构
 * 工时填表详情表
 * @program: tarot-authorization-server
 * @description: 用户映射数据库表实体类
 * @author: Jiang Xincan
 * @version: 0.0.1
 * @create: 2022/5/20 18:54
 **/
@Data
@TableName("license")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class License {

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @TableField(value = "license_public_key")
    private String licensePublicKey;

    @TableField(value = "apply_id")
    private String applyId;

}
