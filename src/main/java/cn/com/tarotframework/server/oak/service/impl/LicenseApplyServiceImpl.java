package cn.com.tarotframework.server.oak.service.impl;

import cn.com.tarotframework.server.oak.dto.ExcelData;
import cn.com.tarotframework.server.oak.mapper.ILicenseApplyMapper;
import cn.com.tarotframework.server.oak.mapper.ILicenseMapper;
import cn.com.tarotframework.server.oak.po.License;
import cn.com.tarotframework.server.oak.po.LicenseApply;
import cn.com.tarotframework.server.oak.service.ILicenseApplyService;
import cn.com.tarotframework.utils.DateUtil;
import cn.com.tarotframework.utils.LicenseDataUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class LicenseApplyServiceImpl implements ILicenseApplyService {

    private ILicenseMapper licenseMapper;

    private ILicenseApplyMapper licenseApplyMapper;



    public LicenseApplyServiceImpl(ILicenseMapper licenseMapper, ILicenseApplyMapper licenseApplyMapper) {
        this.licenseMapper = licenseMapper;
        this.licenseApplyMapper = licenseApplyMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void license(String filePath) {

        System.out.println(filePath);

      List<ExcelData>  lists = LicenseDataUtil.getExcelData(filePath);

      lists.forEach( lic -> {
          LambdaQueryWrapper<LicenseApply> licenseApplyLambdaQueryWrapper = Wrappers.lambdaQuery();
          licenseApplyLambdaQueryWrapper.eq(LicenseApply::getMacUrl, lic.getMacUrl())
                  .eq(LicenseApply::getProjectName, lic.getProjectName());

          // 1: 更新申请、审核时间
          LicenseApply licenseApply = LicenseApply.builder()
                  .createTime(DateUtil.strToDateTime(lic.getCreateTime()))
                  .examineTime(DateUtil.strToDateTime(lic.getExamineTime()))
                  .build();
          licenseApplyMapper.update(licenseApply, licenseApplyLambdaQueryWrapper);

          // 2: 获取license_apply_id
          licenseApplyLambdaQueryWrapper.select(LicenseApply::getId);
          List<LicenseApply> licenseApplies = licenseApplyMapper.selectList(licenseApplyLambdaQueryWrapper);

          if(!CollectionUtils.isEmpty(licenseApplies)) {
              licenseApplies.forEach( app -> {
                  System.out.println(app.getId());
                  // 3: 根据apply_id更新license表中 license_public_key
                  LambdaQueryWrapper<License> licenseLambdaQueryWrapper = Wrappers.lambdaQuery();
                  licenseLambdaQueryWrapper.eq(License::getApplyId, app.getId());
                  License license = License.builder()
                          .licensePublicKey("upload\\" + lic.getExamineTime()
                                  .replace("年","").replace("月","").replace("日","")
                                  .replace(" ", "")
                                  .replaceAll(":","")+"license.txt")
                          .build();
                  licenseMapper.update(license, licenseLambdaQueryWrapper);
              });
          }
      });

    }

}
