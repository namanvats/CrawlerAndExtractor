package com.amazonCrawlerExtractor.project.controller;

import com.amazonCrawlerExtractor.project.Response.BaseResponse;
import com.amazonCrawlerExtractor.project.service.ProductService;
import io.swagger.annotations.ApiParam;
import org.mapstruct.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;



@RestController
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // To get HTML from params SKUID or URL
    @RequestMapping(value = "/gethtml", method = RequestMethod.GET)
    public BaseResponse gethtml(@Context HttpServletRequest httpRequest, @Context HttpServletResponse httpServletResponse,
                                @ApiParam @RequestParam(required = false,name = "url") String url,
                                @ApiParam  @RequestParam(required = false,name = "skuId") String skuId) {
        try {
            BaseResponse response;
            response = productService.gethtml(url,skuId);
            response.setDisplayMessge("Successfully!! Fetched HTML from the given URL or SKUID");
            return response;
        }
        catch (Exception e){
            BaseResponse response = new BaseResponse();
            response.setDisplayMessge(e.getMessage());
            return response;
        }

    }

    // To get Product Details from params SKUID or URL
    @RequestMapping(value = "/getProductDetails", method = RequestMethod.GET)
    public BaseResponse getProductDetails(@Context HttpServletRequest httpRequest, @Context HttpServletResponse httpServletResponse,
                                          @ApiParam @RequestParam(required = false,name = "url") String url,
                                          @ApiParam  @RequestParam(required = false,name = "skuId") String skuId) {
        try {
            BaseResponse response;
            response = productService.getProductDetails(url,skuId);
            response.setDisplayMessge("Successfully!! Fetched Product Details");
            return response;
        }
        catch (Exception e){
            BaseResponse response = new BaseResponse();
            response.setDisplayMessge(e.getMessage());
            return response;
        }
    }

    // To get product details from params SKUID and before particular timestamp
    @RequestMapping(value = "/getProductDetailsBT", method = RequestMethod.GET)
    public BaseResponse getProductDetailsBeforeTimestamp(@Context HttpServletRequest httpRequest, @Context HttpServletResponse httpServletResponse,
                                          @ApiParam @RequestParam(required = false,name = "url") String url,
                                          @ApiParam  @RequestParam(required = false,name = "skuId") String skuId,
                                                         @ApiParam @RequestParam(name = "timestamp")Timestamp timestamp) {
        try {
            BaseResponse response;
            response = productService.getProductDetailsBT(url,skuId,timestamp);
            response.setDisplayMessge("Successfully!! Fetched Product Details");
            return response;
        }
        catch (Exception e){
            BaseResponse response = new BaseResponse();
            response.setDisplayMessge(e.getMessage());
            return response;
        }
    }

    // To get all products crawled till now
    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
    public BaseResponse getAllProducts(@Context HttpServletRequest httpRequest, @Context HttpServletResponse httpServletResponse) {
        try {
            BaseResponse response;
            response = productService.getAllProducts();
            response.setDisplayMessge("Successfully!! Fetched Product Details");
            return response;
        }
        catch (Exception e){
            BaseResponse response = new BaseResponse();
            response.setDisplayMessge(e.getMessage());
            return response;
        }
    }

    //To get price trend of any particular product from params: SKU ID
    @RequestMapping(value = "/getPriceTrend", method = RequestMethod.GET)
    public BaseResponse getPriceTrend(@Context HttpServletRequest httpRequest, @Context HttpServletResponse httpServletResponse,
                                          @ApiParam  @RequestParam(name = "skuId") String skuId) {
        try {
            BaseResponse response;
            response = productService.getAllPriceForProduct(skuId);
            response.setDisplayMessge("Successfully!! Fetched Product Details");
            return response;
        }
        catch (Exception e){
            BaseResponse response = new BaseResponse();
            response.setDisplayMessge(e.getMessage());
            return response;
        }
    }
}
