import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AdminMapper {

    @Update("UPDATE admin SET password = #{newPassword} WHERE admin_id = #{adminId}")
    int updateAdminPassword(@Param("adminId") Integer adminId, @Param("newPassword") String newPassword);

    @Select("SELECT * FROM admin ORDER BY admin_id")
    List<Admin> getAdminList();

    @Select("SELECT * FROM admin WHERE admin_id = #{adminId}")
    Optional<Admin> selectById(@Param("adminId") Integer adminId);

}
