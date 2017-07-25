# MonitorPlatform
简介：基于SpringBoot/MyBatis/Thymeleaf/Quartz构建的用于监控应用健康状态的Web应用
## 一些说明
- 基于SpringBoot Java Config,尽量减少XML配置
- 使用Druid连接池及MyBatis作为ORM框架
- 前端展示使用官方推荐的Thymeleaf以及metronic_v4.5.6模板
- 数据库、redis均基于Docker容器
- Quartz控制定时任务起停功能正在开发
- 因metronic_v4.5.6模板较大，所以只上传了部分文件，因此造成页面js/css缺失，后期会进行补传
