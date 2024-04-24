## 引入方式
1.下载本地mvn clean package install

2.下载压缩包解压本地maven

3.下载jar包引入

## 快速开始
引入后, 导入sql即可使用

提供@RbacIgnore注解, 用于忽略权限校验

如需要添加接口文档, 扫描路径为com.jackieyang.rbac

提供两大核心接口, 用于权限校验 ( RbacService )

```java
/**
 * Check if the user has the permission to access the path
 * if not, throw a forbidden exception
 * @param path request path
 * @param method http method
 * @param userRolePermissionVO user role permission
 */
public void authorization(String path, String method, UserRolePermissionVO userRolePermissionVO);

/**
 * Query user role permission
 * @param userId user id
 * @return user role permission
 */
public UserRolePermissionVO queryUserRolePermission(Long userId);
```
使用AntPathMatcher进行路径匹配

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