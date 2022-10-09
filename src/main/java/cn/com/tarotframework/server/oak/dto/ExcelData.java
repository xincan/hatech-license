package cn.com.tarotframework.server.oak.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel(description = "导入数据接收实体")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExcelData extends BaseRowModel {

    @ApiModelProperty(value="项目名称", dataType = "String", required = true, example = "")
    @ExcelProperty("项目名称")
    private String projectName;

    @ApiModelProperty(value="产品名称", dataType = "String", required = true, example = "")
    @ExcelProperty("产品名称")
    private String productName;

    @ApiModelProperty(value="项目类型", dataType = "String", required = true, example = "")
    @ExcelProperty("项目类型")
    private String typeId;

    @ApiModelProperty(value="申请人", dataType = "String", required = true, example = "")
    @ExcelProperty("申请人")
    private String applicant;

    @ApiModelProperty(value="申请时间", dataType = "String", required = true, example = "")
    @ExcelProperty("申请时间")
    private String createTime;

    @ApiModelProperty(value="审核时间", dataType = "String", required = true, example = "")
    @ExcelProperty("审核时间")
    private String examineTime;

    //状态  0代表未提交 1代表商务正在审核 2代表商务审核成功，老板正在审核 3代表老板审核成功，研发副总正在审核4代表驳回 5代表研发副总审核成功，生成license
    @ApiModelProperty(value="审核状态", dataType = "String", required = true, example = "")
    @ExcelProperty("审核状态")
    private String states;

    @ApiModelProperty(value="开始时间", dataType = "String", required = true, example = "")
    @ExcelProperty("开始时间")
    private String startTime;

    @ApiModelProperty(value="到期时间", dataType = "String", required = true, example = "")
    @ExcelProperty("到期时间")
    private String expiryTime;

    @ApiModelProperty(value="mac地址", dataType = "String", required = true, example = "")
    @ExcelProperty("mac地址")
    private String macUrl;


}
