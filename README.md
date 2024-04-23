## 引入方式
1.下载本地mvn clean package install

2.下载压缩包解压本地maven

3.下载jar包引入

## 快速开始
引入后, 导入sql即可使用

## 拦截器

优先级：5

在前后添加拦截器
```java
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DemoFilter())
                .order(1); // order小于5在前面添加, 大于5在后面添加
    }
}
```