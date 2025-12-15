# Dashboard App - Jetpack Compose

这是一个使用 Jetpack Compose 构建的 Android Dashboard 应用程序。

## 项目结构

```
android/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/dashboard/
│   │       │   ├── MainActivity.kt              # 主入口
│   │       │   ├── model/
│   │       │   │   └── TableEntry.kt           # 数据模型
│   │       │   ├── data/
│   │       │   │   └── TableData.kt            # 模拟数据
│   │       │   ├── config/
│   │       │   │   └── StatusConfig.kt         # 状态配置
│   │       │   └── ui/
│   │       │       ├── components/             # 可重用组件
│   │       │       │   ├── StatusBadge.kt
│   │       │       │   ├── ProgressBar.kt
│   │       │       │   └── ActionDropdown.kt
│   │       │       ├── screens/                # 主要屏幕组件
│   │       │       │   ├── Navigation.kt
│   │       │       │   ├── HeroPanel.kt
│   │       │       │   ├── SummaryCards.kt
│   │       │       │   └── DataTable.kt
│   │       │       └── theme/
│   │       │           └── Theme.kt
│   │       └── AndroidManifest.xml
│   └── build.gradle.kts
└── README.md
```

## 主要功能

### 1. 顶部导航栏 (TopNavigation)
- Logo 和导航链接
- 搜索框
- 新建项目按钮
- 用户头像下拉菜单

### 2. Hero 面板 (HeroPanel)
- 欢迎信息
- 4个成就统计卡片（收入、用户、转化率、成就）
- 图表占位符（收入趋势、用户增长）

### 3. 摘要卡片 (SummaryCards)
- 总销售额
- 订单数
- 活跃会话
- 处理中的支付

### 4. 数据表格 (DataTable)
- 项目列表展示
- 状态徽章
- 进度条
- 操作下拉菜单
- 分页功能

## 技术栈

- **Kotlin**: 主要编程语言
- **Jetpack Compose**: 声明式 UI 框架
- **Material 3**: 设计系统
- **Material Icons Extended**: 图标库

## 依赖项

```kotlin
// Compose
implementation(platform("androidx.compose:compose-bom:2024.02.00"))
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")
implementation("androidx.compose.material:material-icons-extended")

// Core
implementation("androidx.core:core-ktx:1.12.0")
implementation("androidx.activity:activity-compose:1.8.2")
```

## 安装和运行

1. 使用 Android Studio 打开项目
2. 确保安装了 Android SDK 34
3. 同步 Gradle 依赖
4. 运行应用到模拟器或真机

```bash
./gradlew assembleDebug
```

## 代码架构特点

### 组件化设计
- **原子组件**: StatusBadge, ProgressBar, ActionDropdown
- **复合组件**: TableRow, AchievementCard, SummaryCard
- **页面组件**: Navigation, HeroPanel, SummaryCards, DataTable

### 数据分离
- **Model**: 定义数据结构（TableEntry, StatusType）
- **Data**: 提供模拟数据（TableData）
- **Config**: 配置样式映射（StatusConfig）

### 状态管理
- 使用 `remember` 和 `mutableStateOf` 管理组件状态
- 下拉菜单自动关闭逻辑
- 分页状态管理

## 可访问性

- 添加了 `contentDescription` 描述所有图标
- 按钮状态禁用处理
- 语义化的组件结构

## 颜色系统

应用使用了一致的颜色系统：

- **Primary**: `#2563EB` (蓝色)
- **Secondary**: `#9333EA` (紫色)
- **Background**: `#F9FAFB` (浅灰)
- **Surface**: `#FFFFFF` (白色)
- **Success**: `#15803D` (绿色)
- **Error**: `#991B1B` (红色)

## 自定义和扩展

### 添加新的表格列

修改 `TableRow` 组件的权重分配：

```kotlin
Row(modifier = Modifier.weight(1f)) {
    Text(text = newColumn)
}
```

### 更改状态样式

编辑 `StatusConfig.kt` 中的颜色配置：

```kotlin
StatusType.NEW_STATUS -> StatusStyle(
    label = "New Status",
    backgroundColor = Color(0xFFXXXXXX),
    textColor = Color(0xFFXXXXXX)
)
```

### 添加图表

可以集成第三方图表库，如：
- **Vico**: 现代 Compose 图表库
- **MPAndroidChart**: 经典图表库（需要 interop）

## 性能优化

- 使用 `LazyColumn` 进行列表虚拟化
- `remember` 缓存计算结果
- 最小化重组范围

## 下一步改进

- [ ] 添加真实的图表实现
- [ ] 集成网络请求和数据持久化
- [ ] 添加动画和转场效果
- [ ] 支持深色模式
- [ ] 添加响应式布局（平板适配）
- [ ] 实现拉取刷新和无限滚动

## License

MIT License
