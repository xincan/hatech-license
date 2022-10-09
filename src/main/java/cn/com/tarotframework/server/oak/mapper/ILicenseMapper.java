package cn.com.tarotframework.server.oak.mapper;

import cn.com.tarotframework.server.oak.po.License;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ILicenseMapper extends BaseMapper<License> {


}
