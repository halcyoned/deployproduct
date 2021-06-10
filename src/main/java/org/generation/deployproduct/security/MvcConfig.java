package org.generation.deployproduct.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/products").setViewName("products");
        registry.addViewController("/item_form").setViewName("item_form");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images")
                .addResourceLocations("classpath:/static/", "classpath:/images/")
                .setCachePeriod(0);

        exposeDirectory("productImages/images", registry);

    }

    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
        Path uploadDir = Paths.get(dirName);
        String uploadPath = uploadDir.toFile().getAbsolutePath();

        System.out.println(uploadPath);

        System.out.println("/" + dirName + "/**");
        registry.addResourceHandler("/" + dirName + "/**")
                .addResourceLocations("file:" + uploadPath + "/")
                .setCachePeriod(0)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }


}
