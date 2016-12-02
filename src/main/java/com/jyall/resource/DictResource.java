package com.jyall.resource;

import com.alibaba.fastjson.JSONObject;
import com.jyall.pojo.Dict;
import com.jyall.service.DictService;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by wang.linqiao on 2016/11/2.
 */
@RestController
@Api(description = "字典相关接口",produces = MediaType.APPLICATION_JSON,value = "/dict")
@RequestMapping("/dict")
public class DictResource {
    @Autowired
    private DictService dictService;

    @ApiOperation(value = "根据类别查询字典信息", notes = "", httpMethod = "GET")
    @RequestMapping("/getDictByTypeCode/{typeCode}")
    @ResponseBody
    public String getDictByTypeCode(@ApiParam("类别码") @PathVariable String typeCode) {

        List<Dict> list = dictService.getDictByTypeCode(typeCode);
        return JSONObject.toJSONString(list);
    }
}
