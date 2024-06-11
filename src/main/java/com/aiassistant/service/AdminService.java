在`com.aiassistant.service.AdminService`接口中添加以下方法：

```java
public interface AdminService {

    ResultModel<Boolean> updateAdminPassword(Integer adminId, String newPassword);

    ResultPageModel<Admin> getAdminList(Integer pageNo, Integer pageSize);

}
```