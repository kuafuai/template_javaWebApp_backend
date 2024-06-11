public class AdminServiceImpl implements AdminService {

    private AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public ResultModel<Boolean> updateAdminPassword(Integer adminId, String newPassword) {
        if (adminId == null || newPassword == null || newPassword.isEmpty()) {
            return ResultModel.error("Invalid adminId or newPassword");
        }

        try {
            // Update the admin password in the database
            adminMapper.updateAdminPassword(adminId, newPassword);
            return ResultModel.success(true);
        } catch (Exception e) {
            return ResultModel.error("Failed to update admin password");
        }
    }

    @Override
    public ResultPageModel<Admin> getAdminList(Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageSize == null || pageNo <= 0 || pageSize <= 0) {
            return ResultPageModel.error("Invalid pageNo or pageSize");
        }

        try {
            // Calculate the offset and limit for pagination
            int offset = (pageNo - 1) * pageSize;
            int limit = pageSize;

            // Retrieve the paginated list of admins from the database
            List<Admin> admins = adminMapper.getAdminList(offset, limit);

            // Retrieve the total count of admins from the database
            int totalCount = adminMapper.getAdminCount();

            return ResultPageModel.success(admins, pageNo, pageSize, totalCount);
        } catch (Exception e) {
            return ResultPageModel.error("Failed to retrieve admin list");
        }
    }
}
