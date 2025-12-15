# 项目结构说明

## 目录结构（按"先跑起来再精修"原则组织）

```
app/src/main/java/com/dashboard/
├── App.kt                          # Application 入口
├── MainActivity.kt                 # Activity 入口
│
├── core/                          # 核心模块（通用基础设施）
│   ├── navigation/                # 导航配置
│   │   ├── AppNavGraph.kt        # 导航图
│   │   └── Routes.kt             # 路由定义
│   │
│   └── ui/                       # UI 基础设施
│       ├── theme/                # 主题和设计 Token
│       │   ├── Color.kt         # 颜色系统（对应 Figma）
│       │   ├── Type.kt          # 字体样式
│       │   ├── Theme.kt         # Material3 主题
│       │   └── Dimens.kt        # 尺寸规范（4/8/12/16...）
│       │
│       └── components/           # 通用组件库
│           ├── AppScaffold.kt   # 统一脚手架
│           ├── AppTopBar.kt     # 顶部导航栏
│           ├── AppButton.kt     # 按钮组件（Primary/Secondary/Destructive/Ghost）
│           ├── AppTextField.kt  # 输入框组件
│           ├── AppCard.kt       # 卡片容器
│           ├── AppListItem.kt   # 列表项组件
│           ├── AppDialog.kt     # 对话框
│           ├── LoadingIndicator.kt  # 加载指示器
│           ├── EmptyState.kt    # 空状态
│           └── ErrorState.kt    # 错误状态
│
├── feature/                      # 功能模块（按页面拆分）
│   ├── home/                    # 首页
│   │   ├── HomeRoute.kt        # 路由入口
│   │   ├── HomeScreen.kt       # 屏幕 UI
│   │   ├── HomeViewModel.kt    # 视图模型
│   │   └── HomeUiState.kt      # UI 状态
│   │
│   ├── analytics/               # 分析页
│   │   └── AnalyticsRoute.kt
│   │
│   └── settings/                # 设置页
│       ├── SettingsRoute.kt
│       ├── SettingsScreen.kt
│       ├── SettingsViewModel.kt
│       └── SettingsUiState.kt
│
└── data/                        # 数据层（暂时保留旧代码）
    ├── model/
    ├── data/
    └── config/
```

## ✅ 已完成组件清单

### A. 必做通用组件（已完成 ✓）
1. ✅ **AppScaffold** - 统一 TopBar/Snackbar/内容区
2. ✅ **AppTopBar** - 标题 + 返回 + 右侧操作按钮位
3. ✅ **AppButton** - Primary/Secondary/Destructive/Ghost + Loading/Disabled
4. ✅ **AppTextField** - 单行/密码/数字/邮箱 + 错误提示
5. ✅ **AppDialog** - 确认/取消（1/2 按钮）
6. ✅ **LoadingIndicator** - 全屏/局部加载
7. ✅ **EmptyState** - 无数据占位（图标 + 文案 + 按钮）
8. ✅ **ErrorState** - 错误占位（文案 + 重试）

### B. 列表与卡片组件（已完成 ✓）
9. ✅ **AppCard** - 标准卡片容器（圆角、阴影、padding）
10. ✅ **AppListItem** - 标题/副标题/右侧状态/可点击/带开关

### D. 主题与设计 Token（已完成 ✓）
11. ✅ **Color.kt** - Primary/Secondary/Surface/Error + 状态颜色
12. ✅ **Type.kt** - Display/Headline/Title/Body/Label
13. ✅ **Dimens.kt** - 4/8/12/16/24/32...（对应 Figma spacing）

## 🎯 落地顺序（已执行）

### 第一步：基础设施 ✅
- [x] Theme + Dimens + Color + Type
- [x] AppScaffold + AppTopBar
- [x] AppButton + AppTextField

### 第二步：示例页面 ✅
- [x] HomeScreen - 欢迎页 + 统计卡片
- [x] SettingsScreen - 设置页 + 开关组件
- [x] Navigation - 路由配置

### 第三步：通用状态组件 ✅
- [x] LoadingIndicator
- [x] EmptyState
- [x] ErrorState
- [x] AppDialog

## 📦 关键特性

### 1. 设计系统对齐
- **颜色系统**：Primary/Secondary/Success/Warning/Error + 变体
- **间距规范**：4dp 基准，符合 8pt Grid
- **圆角系统**：Small(4) / Medium(8) / Large(12) / XLarge(16)
- **字体层级**：Display / Headline / Title / Body / Label

### 2. 组件变体支持
- **AppButton**：4 种变体（Primary/Secondary/Destructive/Ghost）
- **AppTextField**：4 种类型（Text/Password/Number/Email）
- **Loading/Error/Empty** 状态组件

### 3. MVVM 架构
- **Screen**：纯 UI 展示
- **ViewModel**：状态管理 + 业务逻辑
- **UiState**：UI 状态数据类
- **Route**：路由入口 + Scaffold 配置

## 🚀 下一步扩展

### 业务组件（根据实际需求添加）
- [ ] DestinationPicker - 点位选择器
- [ ] NavControlPanel - 导航控制面板
- [ ] StatusPanel - 状态展示面板
- [ ] MapCanvas - 地图画布

### 数据层完善
- [ ] Repository 实现
- [ ] API DataSource
- [ ] Local DataSource
- [ ] 数据模型定义

### 高级功能
- [ ] 深色模式支持
- [ ] 多语言支持
- [ ] 数据持久化
- [ ] 网络请求封装

## 📝 使用指南

### 创建新页面的标准步骤

1. **定义 UiState**
```kotlin
data class MyScreenUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: List<Item> = emptyList()
)
```

2. **创建 ViewModel**
```kotlin
class MyScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MyScreenUiState())
    val uiState: StateFlow<MyScreenUiState> = _uiState.asStateFlow()
}
```

3. **编写 Screen**
```kotlin
@Composable
fun MyScreen(viewModel: MyScreenViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    // UI 实现
}
```

4. **配置 Route**
```kotlin
@Composable
fun MyRoute(navController: NavController) {
    AppScaffold(
        topBar = { AppTopBar(title = "My Screen") }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            MyScreen()
        }
    }
}
```

5. **添加到导航图**
```kotlin
composable(Routes.MyScreen.route) {
    MyRoute(navController = navController)
}
```

## 🎨 设计 Token 对应

| Figma | Code |
|-------|------|
| Primary Color | `Primary = Color(0xFF2563EB)` |
| Spacing 4 | `Dimens.space4 = 4.dp` |
| Spacing 8 | `Dimens.space8 = 8.dp` |
| Border Radius M | `Dimens.radiusMedium = 8.dp` |
| Title Large | `MaterialTheme.typography.titleLarge` |

## 📄 License

MIT License
