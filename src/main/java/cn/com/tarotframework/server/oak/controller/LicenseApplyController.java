package cn.com.tarotframework.server.oak.controller;

import cn.com.tarotframework.exception.LicenseException;
import cn.com.tarotframework.response.TarotResponseResultBody;
import cn.com.tarotframework.server.oak.service.ILicenseApplyService;
import cn.com.tarotframework.utils.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = {"数据冲洗"})
@Validated
@RestController
@RequestMapping("license")
@TarotResponseResultBody
public class LicenseApplyController {

    @Value("${tarot.file.upload.path}")
    public String targetFilePath;

    private final ILicenseApplyService licenseApplyService;

    public LicenseApplyController(ILicenseApplyService licenseApplyService) {
        this.licenseApplyService = licenseApplyService;
    }

    @ApiOperation(value = "License数据冲洗", httpMethod = "POST", notes = "修改时间")
    @PostMapping
    public void license(@ApiParam(value = "文件", required = true) @RequestPart @RequestParam("file") MultipartFile file) {
        if(ObjectUtils.isEmpty(file) || file.getSize() <= 0) {
            throw new LicenseException(6000, "上传文件不能为空");
        }
        String filePath =  FileUtils.saveFile(file, targetFilePath);
        System.out.println(filePath);
        licenseApplyService.license(filePath);
    }

}
