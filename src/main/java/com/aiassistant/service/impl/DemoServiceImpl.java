在`com.aiassistant.service.impl.DemoServiceImpl`类中实现`getDemoInfo()`方法：
   - 调用`demoMapper.getDemoList()`方法获取磐安旅游的宣传视频和图片信息。
   - 将获取到的视频URL和图片URL列表封装到`Demo`对象中。
   - 返回封装好的`Demo`对象。