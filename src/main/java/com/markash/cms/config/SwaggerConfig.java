/**
 * 
 */
package com.markash.cms.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置
 * 
 * @author muanan
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo((apiInfo())).select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).paths(PathSelectors.any())
				.build().securitySchemes(security());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("cms").description("CMS 描述").build();
	}

	public List<ApiKey> security() {
		List<ApiKey> list = new ArrayList<>();
		list.add(new ApiKey("token", "token", "header"));
		return list;
	}
}
