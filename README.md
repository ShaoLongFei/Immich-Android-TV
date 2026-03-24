# Immich Android TV

Immich 是一款自托管的照片和视频备份解决方案，主要功能包括：

- 上传和查看视频与照片
- 打开应用时自动备份
- 选择性相册备份
- 多用户支持
- 相册与共享相册

更多信息请访问：https://github.com/immich-app/immich

本 Android TV 应用可让你在电视上浏览已上传的照片和视频，当前功能如下：

| 功能                                                                                      | 状态     |
|:------------------------------------------------------------------------------------------|----------|
| 通过手机登录（https://github.com/giejay/Immich-Android-TV-Authentication）               | 已完成   |
| 通过输入 API 密钥登录                                                                     | 已完成   |
| 演示环境                                                                                  | 已完成   |
| 相册获取 + 懒加载                                                                         | 已完成   |
| 查看相册内的照片                                                                          | 已完成   |
| 查看人物、随机、最近或时节照片                                                            | 已完成   |
| 以自定义间隔播放照片和视频幻灯片                                                          | 已完成   |
| 将应用设置为屏保                                                                          | 已完成   |
| 设置屏保中显示的相册                                                                      | 已完成   |
| 配置屏保切换间隔                                                                          | 已完成   |
| 相册和照片通用排序                                                                        | 已完成   |
| 特定相册排序（选中行末项后再次按右键）                                                    | 已完成   |
| 显示 4K 缩略图代替原图以加快加载速度                                                      | 已完成   |
| 显示 EXIF 数据并优化幻灯片视图                                                            | 已完成   |
| 配置视频是否播放声音                                                                      | 已完成   |
| 应用内切换显示语言（简体中文 / 繁体中文 / 英文）                                          | 已完成   |
| 更智能地合并竖向照片（相同人物、日期、城市）                                              | 待完成   |
| 幻灯片切换动画                                                                            | 待完成   |
| 地点/标签视图                                                                             | 待完成   |
| 屏保中显示后台媒体播放信息                                                                | 待完成   |
| 投屏功能                                                                                  | 待完成   |
| 搜索相册                                                                                  | 待完成   |
| 使用 Hilt/Dagger 进行依赖注入                                                             | 待完成   |

## 所需 API 权限

在 Immich 中配置 API 密钥时，请确保授予以下权限以保证应用正常运行：

- `album.read` - 读取相册信息
- `activity.read` - 读取动态数据
- `asset.read` - 读取素材元数据
- `asset.view` - 查看素材（照片/视频）
- `asset.download` - 下载素材以供查看
- `album.download` - 下载相册内容
- `archive.read` - 读取已归档的项目
- `face.read` - 读取人脸识别数据
- `library.read` - 读取媒体库信息
- `timeline.read` - 读取时间线数据
- `memory.read` - 读取记忆/时刻数据
- `partner.read` - 读取伴侣共享数据
- `person.read` - 读取人物/人员数据
- `session.read` - 读取会话信息
- `tag.read` - 读取标签信息
- `tag.asset` - 读取素材标签关联

## 截图

|                                                                                    |                                                                      |                                                                                    |
|:----------------------------------------------------------------------------------:|:--------------------------------------------------------------------:|:----------------------------------------------------------------------------------:|
|        ![Alt text](/screenshots/homescreen-1.png?raw=true "Album overview")        |      ![Alt text](/screenshots/photos.png?raw=true "All photos")      |      ![Alt text](/screenshots/sorting-options.png?raw=true "Sorting options")      |
|         ![Alt text](/screenshots/home-edit.png?raw=true "Edit homescreen")         | ![Alt text](/screenshots/settings-view.png?raw=true "View settings") | ![Alt text](/screenshots/settings-screensaver.png?raw=true "Screensaver settings") |
| ![Alt text](/screenshots/screensaver-portrait.png?raw=true "Screensaver portrait") |        ![Alt text](/screenshots/people.png?raw=true "People")        |             ![Alt text](/screenshots/seasonl.png?raw=true "Seasonal")              |

## 构建步骤

1. 克隆项目：`git clone --recurse git@github.com:giejay/Immich-Android-TV.git`
2. 在 Firebase 创建账号并生成 google-services.json 文件，或直接执行：
   `cp app/google-services.example app/google-services.json`
3. 将 `app/strings_other.xml.example` 复制为 `app/src/main/res/values/strings_other.xml`，并填入你的演示服务器地址和 API 密钥。
4. 执行 `./gradlew assembleRelease` 构建 APK。

## 支持项目

你可以通过以下方式支持本项目：

- 提交详细的 Bug 报告：https://github.com/giejay/Immich-Android-TV/issues/new/choose
- 提交 Pull Request：https://github.com/giejay/Immich-Android-TV/pulls
- 如果你觉得这款 Android TV 应用是 Immich 的有益补充，也可以请作者喝杯咖啡或啤酒：

[!["Buy Me A Coffee"](https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png)](https://www.buymeacoffee.com/giejay)

## 常见问题

#### 无法将应用设置为屏保

1. 在设备上启用开发者模式（在「系统 → 关于」设置中连续点击版本号或"Android TV OS Build"7 次）。
2. 前往「系统 → 开发者选项」，启用 USB 调试。
3. 如果电脑上尚未安装 ADB，请参考以下教程：https://www.xda-developers.com/install-adb-windows-macos-linux/
4. 安装 ADB 后，使用设备 IP 连接：`adb connect 192.168.xx.xx`
5. 连接成功后执行以下命令：
   ```
   adb shell settings put secure screensaver_components nl.giejay.android.tv.immich/.screensaver.ScreenSaverService
   ```
6. 完成！
