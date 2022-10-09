package cn.com.tarotframework.server.oak.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@TableName("license_apply")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LicenseApply {

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @TableField(value = "mac_url")
    private String macUrl;

    @TableField(value = "project_name")
    private String projectName;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "examine_Time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime examineTime;

}
