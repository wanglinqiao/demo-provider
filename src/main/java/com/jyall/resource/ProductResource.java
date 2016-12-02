package com.jyall.resource;

import com.alibaba.fastjson.JSONObject;
import com.jyall.pojo.Product;
import com.jyall.service.ProductService;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品管理
 * Created by wang.linqiao on 2016/10/31.
 */
@Controller
@RequestMapping("/product")
@Api(description = "商品管理相关接口", value = "/product")
public class ProductResource {
    private Logger logger = LoggerFactory.getLogger(ProductResource.class);

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "获取商品列表", notes = "", httpMethod = "GET")
//    @RequestMapping("/getProductList/{idOrName}/{title}/{price}")
    @RequestMapping("/getProductList")
    @ResponseBody
    public String getProductList(/*@ApiParam(value = "名称/编号",required = false) @PathVariable("idOrName") */String idOrName,/*@ApiParam("标题") @PathVariable("title")*/ String title,/*@ApiParam("价格") @PathVariable("price")*/ String price) {
        try {
            Map<String, String> param = new HashMap<>();
            param.put("idOrName", idOrName);
            param.put("title", title);
            param.put("price", price);

            List<Product> productList = productService.getProductList(param);
            return JSONObject.toJSONString(productList);
        } catch (Exception e) {
            logger.error("获取用户列表失败", e);
            return null;
        }
    }

}
