package com.clubio.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.configuration.SpringDocConfiguration;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Smile
 * @date 2023-10-16 13:09
 */

@Configuration
@AutoConfigureBefore(SpringDocConfiguration.class)
public class OpenApiConfig {

    private static final String TOKEN_HEADER = "Authorization";

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("社团天地文档")
                                .description("愿世俗多点温柔，愿你少点难过。")
                                .contact(new Contact().name("Smile").email("smile_liuyu@qq.com").url("https://space.bilibili.com/435193261"))
                                // 参考 Apache 2.0 许可及地址，你可以不配此项
                                .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                                .version("1.0")
                )
                // 引入外部的文档，我这里引得是 springdoc 官方文档地址，你可以不配此项
                .externalDocs(new ExternalDocumentation()
                        .description("SpringDoc Full Documentation")
                        .url("https://springdoc.org/")
                );
    }

    /**
     * GroupedOpenApi 是对接口文档分组，类似于 swagger 的 Docket
     *
     * @return
     */
    @Bean
    public GroupedOpenApi authApi1() {
        return GroupedOpenApi.builder()
                // 组名
                .group("登录接口")
                // 扫描的路径，支持通配符
                .pathsToMatch("/login/**")
                // 扫描的包
                .packagesToScan("com.clubio.controller")
                .build();
    }
    @Bean
    public GroupedOpenApi authApi2() {
        return GroupedOpenApi.builder()
                // 组名
                .group("测试接口")
                // 扫描的路径，支持通配符
                .pathsToMatch("/test/**")
                // 扫描的包
                .packagesToScan("com.clubio.controller")
                .build();
    }
}

