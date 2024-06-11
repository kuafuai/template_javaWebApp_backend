@RestController
@RequestMapping("/manger/account")
@ResponseBody
@Api(tags = "管理端：账号管理")
public class AccountMangerController {
    @Resource
    private AdminService adminService;


    @PostMapping()
    @ApiOperation("修改超级管理员/普通管理员密码")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN')")
    public BaseResponse<Boolean> changePassword(@Validated @RequestBody ChangePasswordRequest changePasswordRequest) {
        Integer id = changePasswordRequest.getId();
        String newPassword = changePasswordRequest.getPassword();
        String confirmPassword = changePasswordRequest.getCheckPassword();

        if (!newPassword.equals(confirmPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "两次密码不一致");
        }


        boolean b = adminService.changePassword(id, newPassword);

        // 进行密码修改操作
        return ResultUtils.success(b);
    }


    @PostMapping("page")
    @ApiOperation("获取管理员列表")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN')")
    public BaseResponse<Page<AdminMangerVo>> getAdminByPage(@Validated @RequestBody AdminQueryRequest adminQueryRequest) {


        if (adminQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请输入请求参数");
        }

        Page<Admin> adminPage = new Page<>();


        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        if (adminQueryRequest.getUserName() != null) {
            queryWrapper.like(Admin::getUsername, adminQueryRequest.getUserName());

        }

        adminService.page(adminPage, queryWrapper);
        Page<AdminMangerVo> adminMangerVoPage = new Page<>();
        BeanUtils.copyProperties(adminPage, adminMangerVoPage);

        adminMangerVoPage.setRecords(adminPage.getRecords().stream().map(admin -> {
            AdminMangerVo adminMangerVo = new AdminMangerVo();
            adminMangerVo.setId(admin.getId());
            adminMangerVo.setUsername(admin.getUsername());
            adminMangerVo.setNickName(admin.getNickName());
            return adminMangerVo;
        }).collect(Collectors.toList()));

        return ResultUtils.success(adminMangerVoPage);

    }

}