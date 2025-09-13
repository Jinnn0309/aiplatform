<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>企业内部AI应用平台PRD文档</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script>
        tailwind.config = {
            theme: {
                extend: {
                    colors: {
                        primary: '#0066FF',
                        secondary: '#36CFC9',
                        accent: '#722ED1',
                        dark: '#1D2129',
                        light: '#F7F8FA'
                    },
                    fontFamily: {
                        sans: ['Inter', 'system-ui', 'sans-serif'],
                    },
                }
            }
        }
    </script>
    <style type="text/tailwindcss">
        @layer utilities {
            .content-auto {
                content-visibility: auto;
            }
            .toc-item {
                @apply py-1 border-l-2 border-transparent pl-3 hover:border-primary hover:text-primary transition-colors;
            }
            .toc-item.active {
                @apply border-primary text-primary font-medium;
            }
            .section-title {
                @apply text-2xl font-bold mb-6 pb-2 border-b border-gray-200 text-dark;
            }
            .subsection-title {
                @apply text-xl font-semibold mb-4 text-dark;
            }
            .table-header {
                @apply bg-gray-50 font-medium text-gray-700;
            }
        }
    </style>
</head>
<body class="bg-gray-50 font-sans text-gray-800">
    <!-- 顶部导航 -->
    <header class="bg-white shadow-sm sticky top-0 z-50">
        <div class="container mx-auto px-4 py-4 flex justify-between items-center">
            <div class="flex items-center">
                <i class="fa fa-file-text-o text-primary text-2xl mr-3"></i>
                <h1 class="text-xl font-bold">企业内部AI应用平台PRD文档</h1>
            </div>
            <div class="flex items-center space-x-4">
                <button class="bg-primary hover:bg-primary/90 text-white px-4 py-2 rounded-lg text-sm transition-colors flex items-center">
                    <i class="fa fa-download mr-2"></i>下载文档
                </button>
            </div>
        </div>
    </header>

    <!-- 主内容区 -->
    <div class="container mx-auto px-4 py-8 flex flex-col lg:flex-row gap-8">
        <!-- 左侧目录 -->
        <aside class="lg:w-1/4 xl:w-1/5 shrink-0">
            <div class="bg-white rounded-xl shadow-sm p-5 sticky top-24 h-fit">
                <h3 class="font-bold text-lg mb-4 pb-2 border-b border-gray-100">文档目录</h3>
                <nav class="space-y-1 text-sm overflow-y-auto max-h-[calc(100vh-200px)]">
                    <a href="#basic-info" class="toc-item block">1. 文档基础信息</a>
                    <a href="#product-goals" class="toc-item block">2. 产品目标</a>
                    <a href="#function-architecture" class="toc-item block">3. 整体功能架构</a>
                    <a href="#detailed-requirements" class="toc-item block">4. 详细功能需求</a>
                    <a href="#core-applications" class="toc-item block">5. 核心AI应用详细需求</a>
                    <a href="#smart-contract" class="toc-item block pl-6">5.1 智能合同分析平台</a>
                    <a href="#intelligent-qa" class="toc-item block pl-6">5.2 企业智能问答助手</a>
                    <a href="#meeting-assistant" class="toc-item block pl-6">5.3 智能会议助手</a>
                    <a href="#document-writing" class="toc-item block pl-6">5.4 智能公文写作</a>
                    <a href="#bidding-assistant" class="toc-item block pl-6">5.5 智能投标助手</a>
                    <a href="#image-recognition" class="toc-item block pl-6">5.6 图像智能识别</a>
                    <a href="#customer-service" class="toc-item block pl-6">5.7 智能客户服务</a>
                </nav>
            </div>
        </aside>

        <!-- 右侧内容 -->
        <main class="lg:w-3/4 xl:w-4/5 bg-white rounded-xl shadow-sm p-8">
            <!-- 1. 文档基础信息 -->
            <section id="basic-info" class="mb-10">
                <h2 class="section-title">1. 文档基础信息</h2>
                <div class="overflow-x-auto">
                    <table class="min-w-full divide-y divide-gray-200">
                        <tbody class="bg-white divide-y divide-gray-200">
                            <tr>
                                <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700 w-1/3">文档名称</td>
                                <td class="px-4 py-3 whitespace-nowrap text-gray-600">企业内部AI应用平台产品需求文档（PRD）</td>
                            </tr>
                            <tr>
                                <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">产品版本</td>
                                <td class="px-4 py-3 whitespace-nowrap text-gray-600">V1.0</td>
                            </tr>
                            <tr>
                                <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">目标用户</td>
                                <td class="px-4 py-3 text-gray-600">企业内部各部门员工（如管理人员、法务人员、销售人员、行政人员等）</td>
                            </tr>
                            <tr>
                                <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">产品定位</td>
                                <td class="px-4 py-3 text-gray-600">整合企业内部高频使用的AI工具，提供统一入口，降低员工使用门槛，提升工作效率的内部服务平台</td>
                            </tr>
                            <tr>
                                <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">文档状态</td>
                                <td class="px-4 py-3 whitespace-nowrap text-gray-600">初稿</td>
                            </tr>
                            <tr>
                                <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">编写日期</td>
                                <td class="px-4 py-3 whitespace-nowrap text-gray-600">2024年X月X日</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </section>

            <!-- 2. 产品目标 -->
            <section id="product-goals" class="mb-10">
                <h2 class="section-title">2. 产品目标</h2>
                
                <h3 class="subsection-title">2.1 核心目标</h3>
                <ul class="list-disc pl-6 mb-6 space-y-2 text-gray-700">
                    <li>整合企业内部AI资源，提供"一站式"AI应用访问入口，减少员工跨平台操作成本</li>
                    <li>通过AI工具赋能各业务场景，平均降低员工30%重复性工作时间，提升整体工作效率</li>
                    <li>建立应用使用数据追踪体系，为后续AI工具优化和新应用拓展提供数据支撑</li>
                </ul>
                
                <h3 class="subsection-title">2.2 次要目标</h3>
                <ul class="list-disc pl-6 space-y-2 text-gray-700">
                    <li>降低AI工具使用门槛，通过简洁的交互设计，让非技术岗位员工也能快速上手</li>
                    <li>支持应用权限分级管理，确保不同部门、不同职级员工只能访问权限范围内的应用</li>
                    <li>提供应用反馈通道，收集员工使用建议，持续优化应用体验</li>
                </ul>
            </section>

            <!-- 3. 整体功能架构 -->
            <section id="function-architecture" class="mb-10">
                <h2 class="section-title">3. 整体功能架构</h2>
                
                <h3 class="subsection-title">3.1 功能模块划分</h3>
                <div class="overflow-x-auto mb-6">
                    <table class="min-w-full divide-y divide-gray-200">
                        <thead>
                            <tr>
                                <th class="px-4 py-3 whitespace-nowrap table-header text-left">模块名称</th>
                                <th class="px-4 py-3 whitespace-nowrap table-header text-left">核心功能</th>
                                <th class="px-4 py-3 whitespace-nowrap table-header text-left">优先级</th>
                            </tr>
                        </thead>
                        <tbody class="bg-white divide-y divide-gray-200">
                            <tr>
                                <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">平台基础模块</td>
                                <td class="px-4 py-3 text-gray-600">登录认证（对接企业SSO）、用户信息展示、通知提醒、搜索功能</td>
                                <td class="px-4 py-3 whitespace-nowrap text-gray-600">P0（必须实现）</td>
                            </tr>
                            <tr>
                                <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">快捷访问模块</td>
                                <td class="px-4 py-3 text-gray-600">常用应用收藏、最近使用应用展示、应用快捷入口</td>
                                <td class="px-4 py-3 whitespace-nowrap text-gray-600">P1（重要）</td>
                            </tr>
                            <tr>
                                <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">应用分类导航模块</td>
                                <td class="px-4 py-3 text-gray-600">按业务场景分类展示应用、分类数据统计、分类筛选</td>
                                <td class="px-4 py-3 whitespace-nowrap text-gray-600">P0（必须实现）</td>
                            </tr>
                            <tr>
                                <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">应用展示模块</td>
                                <td class="px-4 py-3 text-gray-600">推荐应用展示、全部应用列表、应用详情、应用排序</td>
                                <td class="px-4 py-3 whitespace-nowrap text-gray-600">P0（必须实现）</td>
                            </tr>
                            <tr>
                                <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">数据统计模块</td>
                                <td class="px-4 py-3 text-gray-600">个人使用统计（次数、效率提升）、应用使用排行、图表可视化</td>
                                <td class="px-4 py-3 whitespace-nowrap text-gray-600">P1（重要）</td>
                            </tr>
                            <tr>
                                <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">辅助功能模块</td>
                                <td class="px-4 py-3 text-gray-600">使用指南、常见问题、反馈建议、联系支持</td>
                                <td class="px-4 py-3 whitespace-nowrap text-gray-600">P2（次要）</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </section>

            <!-- 4. 详细功能需求 -->
            <section id="detailed-requirements" class="mb-10">
                <h2 class="section-title">4. 详细功能需求</h2>
                
                <h3 class="subsection-title">4.1 平台基础模块</h3>
                
                <h4 class="text-lg font-medium mb-3 text-gray-800">4.1.1 登录认证</h4>
                <div class="bg-gray-50 p-4 rounded-lg mb-4">
                    <p class="font-medium mb-2">需求描述：</p>
                    <p class="text-gray-700 mb-3">对接企业内部SSO单点登录系统，员工无需单独注册账号，通过企业统一身份认证即可登录</p>
                    
                    <p class="font-medium mb-2">交互逻辑：</p>
                    <ol class="list-decimal pl-6 mb-3 space-y-1 text-gray-700">
                        <li>员工访问平台URL，自动跳转至企业SSO登录页面</li>
                        <li>完成SSO认证后，自动回跳至平台首页，并同步用户基础信息（姓名、部门、职级、权限等）</li>
                    </ol>
                    
                    <p class="font-medium mb-2">异常处理：</p>
                    <p class="text-gray-700">若SSO认证失败，显示"认证失败，请联系IT部门"提示，并提供"重新认证"按钮</p>
                </div>
                
                <h4 class="text-lg font-medium mb-3 text-gray-800">4.1.2 用户信息展示</h4>
                <div class="bg-gray-50 p-4 rounded-lg mb-4">
                    <p class="font-medium mb-2">需求描述：</p>
                    <p class="text-gray-700 mb-3">在顶部导航栏展示当前登录用户信息，支持查看个人资料和退出登录</p>
                    
                    <p class="font-medium mb-2">展示内容：</p>
                    <ul class="list-disc pl-6 mb-3 space-y-1 text-gray-700">
                        <li>用户头像（默认使用企业邮箱头像，支持手动上传更换）</li>
                        <li>用户名（如"张经理"）</li>
                        <li>部门信息（鼠标悬浮时显示，如"市场部-品牌组"）</li>
                    </ul>
                    
                    <p class="font-medium mb-2">操作功能：</p>
                    <ul class="list-disc pl-6 text-gray-700">
                        <li>点击头像/用户名，展开下拉菜单，包含"个人资料""修改密码""退出登录"选项</li>
                        <li>点击"退出登录"，清除当前会话，跳转至企业SSO退出页面</li>
                    </ul>
                </div>
                
                <h4 class="text-lg font-medium mb-3 text-gray-800">4.1.3 通知提醒</h4>
                <div class="bg-gray-50 p-4 rounded-lg mb-4">
                    <p class="font-medium mb-2">需求描述：</p>
                    <p class="text-gray-700 mb-3">实时推送平台相关通知（如应用更新、新应用上线、使用提醒等），并在导航栏显示未读数量</p>
                    
                    <p class="font-medium mb-2">通知类型：</p>
                    <ul class="list-disc pl-6 mb-3 space-y-1 text-gray-700">
                        <li>系统通知（如"智能合同分析平台V2.0已上线，新增风险预警功能"）</li>
                        <li>应用提醒（如"您的智能投标助手有1份待处理投标文件"）</li>
                        <li>到期提醒（如"您的图像智能识别权限将于7天后到期，请联系管理员续期"）</li>
                    </ul>
                    
                    <p class="font-medium mb-2">交互逻辑：</p>
                    <ol class="list-decimal pl-6 text-gray-700">
                        <li>新通知推送时，导航栏通知图标旁显示红色未读数字（如"3"）</li>
                        <li>点击通知图标，展开通知列表，未读通知标为红色背景</li>
                        <li>点击单条通知，跳转至对应页面（如应用详情页、待处理任务页）</li>
                        <li>支持"标记全部已读"和"删除通知"操作</li>
                    </ol>
                </div>
                
                <h4 class="text-lg font-medium mb-3 text-gray-800">4.1.4 搜索功能</h4>
                <div class="bg-gray-50 p-4 rounded-lg mb-6">
                    <p class="font-medium mb-2">需求描述：</p>
                    <p class="text-gray-700 mb-3">支持通过应用名称、功能关键词搜索AI应用，提升应用查找效率</p>
                    
                    <p class="font-medium mb-2">搜索规则：</p>
                    <ul class="list-disc pl-6 mb-3 space-y-1 text-gray-700">
                        <li>支持模糊搜索（如输入"合同"，可搜索出"智能合同分析平台"）</li>
                        <li>支持关键词联想（输入"投"，下拉显示"智能投标助手""投标文件生成"等相关结果）</li>
                        <li>搜索结果按"匹配度"排序，优先显示名称完全匹配的应用</li>
                    </ul>
                    
                    <p class="font-medium mb-2">交互逻辑：</p>
                    <ol class="list-decimal pl-6 text-gray-700">
                        <li>点击搜索框，显示最近搜索记录（最多10条，支持清除）</li>
                        <li>输入关键词时，实时显示搜索结果下拉列表，包含应用图标、名称、所属分类</li>
                        <li>点击搜索结果，跳转至对应应用详情页</li>
                        <li>若搜索结果为空，显示"未找到相关应用，可尝试其他关键词"提示，并推荐热门应用</li>
                    </ol>
                </div>

                <h3 class="subsection-title">4.2 快捷访问模块</h3>
                
                <h4 class="text-lg font-medium mb-3 text-gray-800">4.2.1 常用应用收藏</h4>
                <div class="bg-gray-50 p-4 rounded-lg mb-4">
                    <p class="font-medium mb-2">需求描述：</p>
                    <p class="text-gray-700 mb-3">支持员工将高频使用的应用添加至"快捷访问"区域，实现一键直达</p>
                    
                    <p class="font-medium mb-2">交互逻辑：</p>
                    <ol class="list-decimal pl-6 text-gray-700">
                        <li>应用详情页/列表页提供"添加到快捷访问"按钮，点击后该应用显示在首页快捷访问区</li>
                        <li>快捷访问区最多显示5个应用，超过时支持左右滑动查看</li>
                        <li>鼠标悬浮在快捷访问应用上，显示"移除"按钮，点击可删除该应用</li>
                        <li>支持拖拽调整快捷访问应用的排序</li>
                    </ol>
                </div>
                
                <h4 class="text-lg font-medium mb-3 text-gray-800">4.2.2 最近使用应用展示</h4>
                <div class="bg-gray-50 p-4 rounded-lg mb-6">
                    <p class="font-medium mb-2">需求描述：</p>
                    <p class="text-gray-700 mb-3">自动记录员工最近3天使用过的应用（最多5个），显示在快捷访问区下方，方便再次使用</p>
                    
                    <p class="font-medium mb-2">交互逻辑：</p>
                    <ol class="list-decimal pl-6 text-gray-700">
                        <li>每次使用应用后，该应用自动添加至"最近使用"列表，若已存在则刷新排序（最新使用的排在最前）</li>
                        <li>"最近使用"列表与"常用收藏"列表区分显示（如用"最近使用"标题标注）</li>
                        <li>点击最近使用的应用，直接打开应用功能页面</li>
                        <li>支持"清除最近使用记录"操作</li>
                    </ol>
                </div>

                <h3 class="subsection-title">4.3 应用分类导航模块</h3>
                
                <h4 class="text-lg font-medium mb-3 text-gray-800">4.3.1 分类展示</h4>
                <div class="bg-gray-50 p-4 rounded-lg mb-4">
                    <p class="font-medium mb-2">需求描述：</p>
                    <p class="text-gray-700 mb-3">按业务场景将AI应用分为6个大类，每个分类显示应用数量，支持点击切换分类</p>
                    
                    <p class="font-medium mb-2">分类列表：</p>
                    <div class="overflow-x-auto mb-3">
                        <table class="min-w-full divide-y divide-gray-200">
                            <thead>
                                <tr>
                                    <th class="px-4 py-3 whitespace-nowrap table-header text-left">分类名称</th>
                                    <th class="px-4 py-3 whitespace-nowrap table-header text-left">包含应用</th>
                                    <th class="px-4 py-3 whitespace-nowrap table-header text-left">应用数量（示例）</th>
                                </tr>
                            </thead>
                            <tbody class="bg-white divide-y divide-gray-200">
                                <tr>
                                    <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">全部应用</td>
                                    <td class="px-4 py-3 text-gray-600">平台所有AI应用</td>
                                    <td class="px-4 py-3 whitespace-nowrap text-gray-600">18</td>
                                </tr>
                                <tr>
                                    <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">文档处理</td>
                                    <td class="px-4 py-3 text-gray-600">智能合同分析平台、智能公文写作、投标文件生成等</td>
                                    <td class="px-4 py-3 whitespace-nowrap text-gray-600">6</td>
                                </tr>
                                <tr>
                                    <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">智能沟通</td>
                                    <td class="px-4 py-3 text-gray-600">企业智能问答助手、智能会议助手、智能客户服务等</td>
                                    <td class="px-4 py-3 whitespace-nowrap text-gray-600">4</td>
                                </tr>
                                <tr>
                                    <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">图像识别</td>
                                    <td class="px-4 py-3 text-gray-600">图像智能识别、安全隐患识别、产品图像分类等</td>
                                    <td class="px-4 py-3 whitespace-nowrap text-gray-600">3</td>
                                </tr>
                                <tr>
                                    <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">数据分析</td>
                                    <td class="px-4 py-3 text-gray-600">业务数据可视化、用户行为分析、销售预测分析等</td>
                                    <td class="px-4 py-3 whitespace-nowrap text-gray-600">2</td>
                                </tr>
                                <tr>
                                    <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">安全检测</td>
                                    <td class="px-4 py-3 text-gray-600">安全隐患识别、文档安全扫描、权限风险检测等</td>
                                    <td class="px-4 py-3 whitespace-nowrap text-gray-600">3</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    
                    <p class="font-medium mb-2">交互逻辑：</p>
                    <ol class="list-decimal pl-6 text-gray-700">
                        <li>左侧导航栏显示所有分类，当前选中分类标为蓝色背景+蓝色文字</li>
                        <li>每个分类右侧显示应用数量（如"文档处理 · 6"）</li>
                        <li>点击分类，右侧应用列表区域同步显示该分类下的所有应用</li>
                    </ol>
                </div>
                
                <h4 class="text-lg font-medium mb-3 text-gray-800">4.3.2 分类数据统计</h4>
                <div class="bg-gray-50 p-4 rounded-lg mb-6">
                    <p class="font-medium mb-2">需求描述：</p>
                    <p class="text-gray-700 mb-3">在分类导航下方展示员工个人"使用统计"图表，直观显示各分类应用的使用频率</p>
                    
                    <p class="font-medium mb-2">图表类型：</p>
                    <p class="text-gray-700 mb-3">折线图（X轴为月份，Y轴为使用次数，默认显示近6个月数据）</p>
                    
                    <p class="font-medium mb-2">交互逻辑：</p>
                    <ol class="list-decimal pl-6 text-gray-700">
                        <li>图表默认显示"全部应用"的使用趋势，点击某一分类，图表同步切换为该分类的使用数据</li>
                        <li>鼠标悬浮在图表数据点上，显示具体数值（如"3月：28次"）</li>
                        <li>支持"下载图表"功能，可导出为PNG图片或Excel数据</li>
                    </ol>
                </div>

                <h3 class="subsection-title">4.4 应用展示模块</h3>
                
                <h4 class="text-lg font-medium mb-3 text-gray-800">4.4.1 推荐应用展示</h4>
                <div class="bg-gray-50 p-4 rounded-lg mb-4">
                    <p class="font-medium mb-2">需求描述：</p>
                    <p class="text-gray-700 mb-3">在首页展示2个核心推荐应用（基于企业使用热度和员工岗位匹配度），包含详细功能说明</p>
                    
                    <p class="font-medium mb-2">推荐规则：</p>
                    <ul class="list-disc pl-6 mb-3 space-y-1 text-gray-700">
                        <li>企业级推荐：优先展示本月使用量TOP2的应用（如"智能合同分析平台""企业智能问答助手"）</li>
                        <li>个性化推荐：结合员工岗位（如销售岗推荐"智能投标助手"，行政岗推荐"智能公文写作"）</li>
                    </ul>
                    
                    <p class="font-medium mb-2">展示内容：</p>
                    <ul class="list-disc pl-6 text-gray-700">
                        <li>应用基础信息：图标、名称、所属分类、本月使用次数</li>
                        <li>应用标签：如"新版""热门"（用不同颜色背景区分）</li>
                        <li>功能描述：3-4行文字说明核心功能和价值</li>
                        <li>功能标签：如"合同审查""风险识别"（最多3个）</li>
                        <li>用户评分：星级评分（1-5星）+ 评分人数</li>
                        <li>操作按钮："立即使用"（跳转至应用功能页）</li>
                    </ul>
                </div>
                
                <h4 class="text-lg font-medium mb-3 text-gray-800">4.4.2 全部应用列表</h4>
                <div class="bg-gray-50 p-4 rounded-lg mb-4">
                    <p class="font-medium mb-2">需求描述：</p>
                    <p class="text-gray-700 mb-3">按网格布局展示所有应用，支持按"使用频率""最新上线""评分优先"排序</p>
                    
                    <p class="font-medium mb-2">展示内容（单应用卡片）：</p>
                    <ul class="list-disc pl-6 mb-3 space-y-1 text-gray-700">
                        <li>应用图标（80*80px，圆形，带分类色系背景）</li>
                        <li>应用名称（最多8个字，超出换行）</li>
                        <li>所属分类+评分（如"文档处理 · 4.6 (152)"）</li>
                        <li>功能简介（最多2行，超出显示"..."）</li>
                        <li>操作按钮："打开应用"（点击跳转至应用功能页）</li>
                    </ul>
                    
                    <p class="font-medium mb-2">排序规则：</p>
                    <ul class="list-disc pl-6 mb-3 space-y-1 text-gray-700">
                        <li>使用频率：按员工个人近30天使用次数降序排列</li>
                        <li>最新上线：按应用上线时间降序排列（显示"新"标签）</li>
                        <li>评分优先：按用户评分降序排列（评分相同则按评分人数降序）</li>
                    </ul>
                    
                    <p class="font-medium mb-2">分页逻辑：</p>
                    <ul class="list-disc pl-6 text-gray-700">
                        <li>每页显示6个应用（1行3个，共2行）</li>
                        <li>底部显示分页控件，支持"上一页""下一页"和直接点击页码跳转</li>
                        <li>当前页码标为蓝色背景，未选中页码为灰色边框</li>
                    </ul>
                </div>
                
                <h4 class="text-lg font-medium mb-3 text-gray-800">4.4.3 应用详情页（通用模板）</h4>
                <div class="bg-gray-50 p-4 rounded-lg mb-6">
                    <p class="font-medium mb-2">需求描述：</p>
                    <p class="text-gray-700 mb-3">点击应用卡片进入详情页，展示应用完整信息，包含功能说明、使用指南、操作入口</p>
                    
                    <p class="font-medium mb-2">页面结构：</p>
                    <ol class="list-decimal pl-6 text-gray-700">
                        <li>应用头部：图标、名称、所属分类、评分、使用次数、标签（如"新版"）</li>
                        <li>功能说明：
                            <ul class="list-disc pl-6 mt-1">
                                <li>核心价值：1-2句话概括应用能解决的问题</li>
                                <li>详细功能：分点说明3-5个核心功能（带图标）</li>
                            </ul>
                        </li>
                        <li>使用指南：
                            <ul class="list-disc pl-6 mt-1">
                                <li>操作步骤：3-4步图文说明使用流程</li>
                                <li>注意事项：如"支持上传PDF/Word格式，单个文件不超过20MB"</li>
                            </ul>
                        </li>
                        <li>相关推荐：推荐2个同分类的其他应用</li>
                        <li>操作区域："立即使用"（主按钮）、"添加到快捷访问"（次按钮）</li>
                    </ol>
                </div>

                <h3 class="subsection-title">4.5 数据统计模块</h3>
                
                <h4 class="text-lg font-medium mb-3 text-gray-800">4.5.1 个人使用统计</h4>
                <div class="bg-gray-50 p-4 rounded-lg mb-4">
                    <p class="font-medium mb-2">需求描述：</p>
                    <p class="text-gray-700 mb-3">在首页顶部展示员工个人"本月使用次数"和"效率提升"数据，量化AI工具的价值</p>
                    
                    <p class="font-medium mb-2">数据计算规则：</p>
                    <ul class="list-disc pl-6 mb-3 space-y-1 text-gray-700">
                        <li>本月使用次数：统计当月员工打开并完成操作的应用次数（仅计算有效使用，打开后30秒内关闭不计入）</li>
                        <li>效率提升：基于应用使用前后的工作时长对比，取所有使用应用的平均提升值</li>
                    </ul>
                    
                    <p class="font-medium mb-2">展示形式：</p>
                    <ul class="list-disc pl-6 text-gray-700">
                        <li>图标+文字组合（如"<i class='fa fa-clock-o text-primary'></i> 本月使用: 28次"）</li>
                        <li>数据实时更新（每24小时同步一次）</li>
                    </ul>
                </div>
                
                <h4 class="text-lg font-medium mb-3 text-gray-800">4.5.2 应用使用排行</h4>
                <div class="bg-gray-50 p-4 rounded-lg mb-6">
                    <p class="font-medium mb-2">需求描述：</p>
                    <p class="text-gray-700 mb-3">在"数据统计"页面展示企业级应用使用排行（TOP10），包含使用次数、覆盖率、满意度</p>
                    
                    <p class="font-medium mb-2">排行维度：</p>
                    <ul class="list-disc pl-6 mb-3 space-y-1 text-gray-700">
                        <li>使用次数排行：按本月企业所有员工的使用总次数降序</li>
                        <li>部门覆盖率排行：按使用该应用的部门数量占比降序（如"8/10个部门在使用"）</li>
                        <li>满意度排行：按用户评分（1-5星）降序</li>
                    </ul>
                    
                    <p class="font-medium mb-2">展示形式：</p>
                    <p class="text-gray-700">表格（包含排名、应用名称、使用次数/覆盖率/满意度、趋势箭头）</p>
                </div>

                <h3 class="subsection-title">4.6 辅助功能模块</h3>
                
                <h4 class="text-lg font-medium mb-3 text-gray-800">4.6.1 使用指南</h4>
                <div class="bg-gray-50 p-4 rounded-lg mb-4">
                    <p class="font-medium mb-2">需求描述：</p>
                    <p class="text-gray-700 mb-3">提供平台整体使用指南和各应用单独的操作手册，帮助员工快速上手</p>
                    
                    <p class="font-medium mb-2">内容结构：</p>
                    <ul class="list-disc pl-6 mb-3 space-y-1 text-gray-700">
                        <li>平台指南：包含"如何搜索应用""如何添加快捷访问""如何查看使用统计"等基础操作</li>
                        <li>应用指南：每个应用对应1份手册，包含功能说明、操作步骤、常见问题</li>
                    </ul>
                    
                    <p class="font-medium mb-2">交互逻辑：</p>
                    <ol class="list-decimal pl-6 text-gray-700">
                        <li>页脚"使用指南"链接跳转至指南首页，支持按应用搜索手册</li>
                        <li>应用详情页提供"查看使用指南"按钮，直接跳转至该应用的手册页面</li>
                        <li>手册支持"目录导航"和"关键词搜索"，方便定位内容</li>
                    </ol>
                </div>
                
                <h4 class="text-lg font-medium mb-3 text-gray-800">4.6.2 反馈建议</h4>
                <div class="bg-gray-50 p-4 rounded-lg">
                    <p class="font-medium mb-2">需求描述：</p>
                    <p class="text-gray-700 mb-3">提供反馈入口，员工可提交应用问题或功能建议，支持上传截图</p>
                    
                    <p class="font-medium mb-2">反馈类型：</p>
                    <ul class="list-disc pl-6 mb-3 space-y-1 text-gray-700">
                        <li>功能问题：如"智能公文写作生成的报告格式错误"</li>
                        <li>功能建议：如"希望智能投标助手增加报价计算功能"</li>
                        <li>体验优化：如"应用加载速度慢，希望优化"</li>
                    </ul>
                    
                    <p class="font-medium mb-2">交互逻辑：</p>
                    <ol class="list-decimal pl-6 text-gray-700">
                        <li>页脚"反馈建议"链接跳转至反馈表单页</li>
                        <li>表单包含"反馈类型"（下拉选择）、"应用名称"（下拉选择）、"反馈内容"（文本框）、"上传截图"、"联系方式"（可选）</li>
                        <li>提交后显示"反馈已收到，我们将在3个工作日内回复"提示，并提供反馈编号</li>
                        <li>支持在"我的反馈"页面查看历史反馈状态（待处理/处理中/已解决）</li>
                    </ol>
                </div>
            </section>

            <!-- 5. 核心AI应用详细需求 -->
            <section id="core-applications" class="mb-10">
                <h2 class="section-title">5. 核心AI应用详细需求</h2>
                
                <!-- 5.1 智能合同分析平台 -->
                <section id="smart-contract" class="mb-8">
                    <h3 class="subsection-title">5.1 智能合同分析平台</h3>
                    
                    <div class="mb-5">
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.1.1 应用定位</h4>
                        <p class="text-gray-700 pl-4 border-l-2 border-primary">面向法务、采购、销售部门，自动审查合同文本，识别风险条款，提取关键信息，降低人工审查成本</p>
                    </div>
                    
                    <div class="mb-5">
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.1.2 输入</h4>
                        <div class="overflow-x-auto">
                            <table class="min-w-full divide-y divide-gray-200">
                                <thead>
                                    <tr>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">输入类型</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">具体要求</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">格式限制</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white divide-y divide-gray-200">
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">合同文件</td>
                                        <td class="px-4 py-3 text-gray-600">需审查的合同文本（如采购合同、销售合同、服务合同等）</td>
                                        <td class="px-4 py-3 text-gray-600">支持PDF、Word（.docx）格式，单个文件≤20MB，页数≤100页</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">审查维度</td>
                                        <td class="px-4 py-3 text-gray-600">可选需重点审查的维度（可多选）：<br>
                                        1. 风险条款（如违约条款、免责条款）<br>
                                        2. 关键信息（如金额、期限、甲方乙方）<br>
                                        3. 格式规范（如是否符合企业合同模板）<br>
                                        4. 法律合规（如是否符合最新法律法规）</td>
                                        <td class="px-4 py-3 text-gray-600">下拉选择，默认全选</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">参考模板</td>
                                        <td class="px-4 py-3 text-gray-600">可选企业标准合同模板（用于格式对比）</td>
                                        <td class="px-4 py-3 text-gray-600">仅支持平台提供的模板列表，需管理员提前上传</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    
                    <div>
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.1.3 输出</h4>
                        <div class="overflow-x-auto">
                            <table class="min-w-full divide-y divide-gray-200">
                                <thead>
                                    <tr>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">输出类型</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">具体内容</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">交互方式</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white divide-y divide-gray-200">
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">风险报告</td>
                                        <td class="px-4 py-3 text-gray-600">1. 风险等级：高/中/低（用红/黄/绿三色标注）<br>
                                        2. 风险条款：定位到具体条款内容，标注风险点<br>
                                        3. 修改建议：针对高/中风险条款提供具体修改方案</td>
                                        <td class="px-4 py-3 text-gray-600">在线预览（支持高亮定位到原文），支持下载为PDF</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">信息提取表</td>
                                        <td class="px-4 py-3 text-gray-600">结构化展示合同关键信息：<br>
                                        1. 合同基本信息：名称、编号、签订日期<br>
                                        2. 双方信息：甲方/乙方名称、地址、联系人<br>
                                        3. 核心条款：金额、支付方式、履行期限、违约责任<br>
                                        4. 附件清单：列出合同附带的所有文件</td>
                                        <td class="px-4 py-3 text-gray-600">1. 表格形式在线展示，支持展开/收起详情<br>
                                        2. 支持导出为Excel格式<br>
                                        3. 支持复制单条信息</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">格式对比报告</td>
                                        <td class="px-4 py-3 text-gray-600">1. 差异点：对比上传合同与企业标准模板的格式差异<br>
                                        2. 合规率：计算格式合规得分<br>
                                        3. 调整指引：针对每个差异点提供具体修改步骤</td>
                                        <td class="px-4 py-3 text-gray-600">1. 左右分栏对比，差异处标红<br>
                                        2. 支持"一键生成修改版合同"<br>
                                        3. 支持打印对比报告</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">法律合规校验结果</td>
                                        <td class="px-4 py-3 text-gray-600">1. 合规项：标注符合当前法律法规的条款<br>
                                        2. 不合规项：指出违反法律法规的条款及依据<br>
                                        3. 修订建议：提供符合法律要求的条款修订方案</td>
                                        <td class="px-4 py-3 text-gray-600">1. 在线预览时，合规项标绿，不合规项标红<br>
                                        2. 支持下载完整合规校验报告<br>
                                        3. 支持一键生成"合规修订版"合同草案</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </section>
                
                <!-- 5.2 企业智能问答助手 -->
                <section id="intelligent-qa" class="mb-8">
                    <h3 class="subsection-title">5.2 企业智能问答助手</h3>
                    
                    <div class="mb-5">
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.2.1 应用定位</h4>
                        <p class="text-gray-700 pl-4 border-l-2 border-primary">面向全企业员工，基于企业内部知识库（如规章制度、业务流程、产品信息等）提供7×24小时智能问答，减少人工咨询成本</p>
                    </div>
                    
                    <div class="mb-5">
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.2.2 输入</h4>
                        <div class="overflow-x-auto">
                            <table class="min-w-full divide-y divide-gray-200">
                                <thead>
                                    <tr>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">输入类型</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">具体要求</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">格式限制</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white divide-y divide-gray-200">
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">问题文本</td>
                                        <td class="px-4 py-3 text-gray-600">员工需咨询的问题（如业务流程、政策解读、产品参数等），支持自然语言描述</td>
                                        <td class="px-4 py-3 text-gray-600">1. 文本长度：10-500字<br>
                                        2. 支持中英文混合输入，不支持特殊符号</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">问题分类</td>
                                        <td class="px-4 py-3 text-gray-600">可选问题所属领域：<br>
                                        1. 行政人事（如"请假流程""社保缴纳"）<br>
                                        2. 业务流程（如"报销审批""合同签订流程"）<br>
                                        3. 产品知识（如"产品功能""定价策略"）<br>
                                        4. 技术支持（如"系统登录问题"）<br>
                                        5. 其他</td>
                                        <td class="px-4 py-3 text-gray-600">下拉选择，默认"其他"</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">上下文补充（可选）</td>
                                        <td class="px-4 py-3 text-gray-600">若问题需要背景信息支撑，可补充历史上下文</td>
                                        <td class="px-4 py-3 text-gray-600">文本输入，最多300字，支持上传截图</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">回答偏好</td>
                                        <td class="px-4 py-3 text-gray-600">可选回答形式：<br>
                                        1. 简洁版（核心结论+关键步骤）<br>
                                        2. 详细版（含完整流程、依据、注意事项）<br>
                                        3. 步骤版（分点列出操作步骤）</td>
                                        <td class="px-4 py-3 text-gray-600">单选，默认"简洁版"，可在回答后切换版本</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    
                    <div>
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.2.3 输出</h4>
                        <div class="overflow-x-auto">
                            <table class="min-w-full divide-y divide-gray-200">
                                <thead>
                                    <tr>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">输出类型</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">具体内容</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">交互方式</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white divide-y divide-gray-200">
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">智能回答</td>
                                        <td class="px-4 py-3 text-gray-600">1. 核心结论：直接回应问题<br>
                                        2. 依据来源：标注回答引用的知识库文件<br>
                                        3. 补充信息：针对问题延伸相关内容<br>
                                        4. 版本说明：标注当前生效版本及更新时间</td>
                                        <td class="px-4 py-3 text-gray-600">1. 文本在线展示，关键信息标蓝突出<br>
                                        2. 支持"切换回答版本"<br>
                                        3. 支持"复制回答""分享给同事"<br>
                                        4. 提供"转人工咨询"按钮</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">相关问题推荐</td>
                                        <td class="px-4 py-3 text-gray-600">基于当前问题，推荐3-5个员工常问的关联问题</td>
                                        <td class="px-4 py-3 text-gray-600">1. 以卡片形式展示，每个卡片包含问题标题和"查看回答"按钮<br>
                                        2. 点击卡片直接跳转至对应问题的回答页面<br>
                                        3. 支持"不感兴趣"按钮</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">操作指引（适用于流程类问题）</td>
                                        <td class="px-4 py-3 text-gray-600">1. 步骤拆解：分点列出操作步骤，每个步骤附操作截图<br>
                                        2. 操作入口：提供直接跳转至对应系统的链接<br>
                                        3. 常见问题：列出该操作中员工常遇到的问题及解决方案</td>
                                        <td class="px-4 py-3 text-gray-600">1. 步骤用序号+图标区分，截图可点击放大查看<br>
                                        2. 操作链接支持"复制链接"和"直接打开"<br>
                                        3. 支持下载完整操作指引</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">人工咨询入口</td>
                                        <td class="px-4 py-3 text-gray-600">1. 客服分配：自动匹配对应领域的人工客服<br>
                                        2. 排队提示：显示当前排队人数和预计等待时间<br>
                                        3. 问题预填：自动将员工的问题和已有的AI回答同步给客服<br>
                                        4. 咨询方式：支持"在线聊天""电话咨询""预约会议"</td>
                                        <td class="px-4 py-3 text-gray-600">1. 显示客服分配结果和排队状态<br>
                                        2. 支持"取消排队"和"接收排队提醒"<br>
                                        3. 咨询结束后，显示"满意度评价"</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </section>
                
                <!-- 5.3 智能会议助手 -->
                <section id="meeting-assistant" class="mb-8">
                    <h3 class="subsection-title">5.3 智能会议助手</h3>
                    
                    <div class="mb-5">
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.3.1 应用定位</h4>
                        <p class="text-gray-700 pl-4 border-l-2 border-primary">面向各部门会议组织者和参会人员，支持实时会议记录、语音转文字、纪要生成、待办分配，提升会议效率和后续执行跟踪</p>
                    </div>
                    
                    <div class="mb-5">
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.3.2 输入</h4>
                        <div class="overflow-x-auto">
                            <table class="min-w-full divide-y divide-gray-200">
                                <thead>
                                    <tr>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">输入类型</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">具体要求</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">格式限制</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white divide-y divide-gray-200">
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">会议基础信息</td>
                                        <td class="px-4 py-3 text-gray-600">1. 会议名称（如"2024年Q2市场部工作计划会议"）<br>
                                        2. 会议时间（开始/结束时间）<br>
                                        3. 参会人员（支持从企业通讯录选择）<br>
                                        4. 会议类型（可选：部门例会、项目评审会等）</td>
                                        <td class="px-4 py-3 text-gray-600">1. 会议名称：10-50字，不支持特殊符号<br>
                                        2. 参会人员：最多50人，支持批量导入<br>
                                        3. 会议类型：下拉选择</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">会议语音/视频源</td>
                                        <td class="px-4 py-3 text-gray-600">1. 实时录音：开启麦克风权限后，实时采集会议语音<br>
                                        2. 上传录音文件：若未实时录制，可上传事后录音<br>
                                        3. 视频文件：支持上传会议视频，自动提取音频进行转写</td>
                                        <td class="px-4 py-3 text-gray-600">1. 实时录音：支持切换麦克风设备<br>
                                        2. 上传文件：MP3、WAV、MP4、MOV格式，单个文件≤5GB<br>
                                        3. 多语言支持：默认中文，可选择双语转写</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">会议议程（可选）</td>
                                        <td class="px-4 py-3 text-gray-600">提前录入会议议程（如"1. 市场部Q1工作总结；2. Q2工作计划讨论"）</td>
                                        <td class="px-4 py-3 text-gray-600">1. 支持添加/删除/调整议程顺序，每个议程可设置时长<br>
                                        2. 支持导入Excel格式的议程模板</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">重点标记指令</td>
                                        <td class="px-4 py-3 text-gray-600">会议过程中，可手动标记重点内容，或设置关键词自动标记</td>
                                        <td class="px-4 py-3 text-gray-600">1. 实时会议时，支持快捷键标记或点击界面按钮<br>
                                        2. 关键词设置：最多20个，支持模糊匹配<br>
                                        3. 标记类型：可区分"待办事项""重要结论""争议点"</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    
                    <div>
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.3.3 输出</h4>
                        <div class="overflow-x-auto">
                            <table class="min-w-full divide-y divide-gray-200">
                                <thead>
                                    <tr>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">输出类型</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">具体内容</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">交互方式</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white divide-y divide-gray-200">
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">实时语音转文字记录</td>
                                        <td class="px-4 py-3 text-gray-600">1. 逐句转写：将会议语音实时转换为文字，标注发言人<br>
                                        2. 时间戳：每个语句前标注具体时间<br>
                                        3. 多语言对照：若开启双语转写，显示中英文对照文本<br>
                                        4. 纠错功能：自动识别并标注可能的转写错误</td>
                                        <td class="px-4 py-3 text-gray-600">1. 在线实时滚动显示，当前说话内容标黄突出<br>
                                        2. 支持"暂停转写""继续转写"操作<br>
                                        3. 支持按发言人筛选文本<br>
                                        4. 支持复制或导出文本</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">结构化会议纪要</td>
                                        <td class="px-4 py-3 text-gray-600">1. 会议基本信息：自动填充会议名称、时间、参会人员等<br>
                                        2. 议程环节总结：按提前设置的议程，分模块总结每个环节的核心内容<br>
                                        3. 重点内容提炼：将标记的重点内容分类展示<br>
                                        4. 数据补充：自动生成简单数据图表</td>
                                        <td class="px-4 py-3 text-gray-600">1. 支持选择纪要模板<br>
                                        2. 在线编辑功能：支持添加/删除内容、调整格式<br>
                                        3. 支持导出为Word/PDF格式或同步至企业OA系统<br>
                                        4. 支持"一键发送给参会人员"</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">待办事项清单</td>
                                        <td class="px-4 py-3 text-gray-600">1. 待办内容：明确待办事项描述<br>
                                        2. 负责人：标注具体负责人<br>
                                        3. 截止日期：标注完成时间<br>
                                        4. 关联依据：附待办事项对应的会议原文片段<br>
                                        5. 优先级：支持设置"高/中/低"优先级</td>
                                        <td class="px-4 py-3 text-gray-600">1. 表格形式展示，支持拖拽调整顺序<br>
                                        2. 支持"编辑待办""删除待办"操作<br>
                                        3. 支持关联企业任务管理系统<br>
                                        4. 支持设置待办提醒</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">会议回顾视频（可选）</td>
                                        <td class="px-4 py-3 text-gray-600">1. 视频剪辑：自动剪辑包含重点内容的片段<br>
                                        2. 字幕叠加：叠加实时转写的文字字幕<br>
                                        3. 索引生成：生成视频索引，点击直接跳转至对应片段</td>
                                        <td class="px-4 py-3 text-gray-600">1. 支持选择剪辑模式<br>
                                        2. 支持调整视频分辨率和格式<br>
                                        3. 支持下载视频或上传至企业内部平台<br>
                                        4. 支持分享视频片段链接</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </section>
                
                <!-- 5.4 智能公文写作 -->
                <section id="document-writing" class="mb-8">
                    <h3 class="subsection-title">5.4 智能公文写作</h3>
                    
                    <div class="mb-5">
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.4.1 应用定位</h4>
                        <p class="text-gray-700 pl-4 border-l-2 border-primary">面向行政、人事、市场等需要频繁撰写公文的部门，支持自动生成各类企业公文（如通知、报告、请示、函等），确保格式规范、内容合规，提升写作效率</p>
                    </div>
                    
                    <div class="mb-5">
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.4.2 输入</h4>
                        <div class="overflow-x-auto">
                            <table class="min-w-full divide-y divide-gray-200">
                                <thead>
                                    <tr>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">输入类型</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">具体要求</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">格式限制</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white divide-y divide-gray-200">
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">公文类型选择</td>
                                        <td class="px-4 py-3 text-gray-600">从企业标准公文类型中选择，不同类型对应不同模板：<br>
                                        1. 通知（如"会议通知""放假通知""制度发布通知"）<br>
                                        2. 报告（如"工作总结报告""项目进展报告"）<br>
                                        3. 请示（如"费用请示""人员招聘请示"）<br>
                                        4. 函（如"商洽函""询问函""答复函"）<br>
                                        5. 纪要（如"部门例会纪要"）<br>
                                        6. 其他（支持自定义模板）</td>
                                        <td class="px-4 py-3 text-gray-600">下拉选择，选择后自动加载对应类型的标准模板和必填字段</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">核心信息填写</td>
                                        <td class="px-4 py-3 text-gray-600">根据所选公文类型，填写关键信息（不同类型字段不同）：<br>
                                        - 会议通知：会议名称、时间、地点、参会人员、会议内容<br>
                                        - 工作总结报告：报告周期、总结部门、核心工作成果、存在问题<br>
                                        - 费用请示：请示事项、金额（含明细）、用途、预期效果</td>
                                        <td class="px-4 py-3 text-gray-600">1. 字段分类：分为"必填字段"（标红*）和"可选字段"<br>
                                        2. 文本输入框根据内容长度自动调整高度<br>
                                        3. 日期、金额等字段提供格式化输入辅助</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">格式与风格选择</td>
                                        <td class="px-4 py-3 text-gray-600">1. 格式要求：选择公文格式（如"标准格式""简版格式""对外格式"）<br>
                                        2. 语言风格：选择行文风格（如"正式严谨""简洁明了""详细全面"）<br>
                                        3. 字数要求：设置大致字数范围（如"300-500字""800-1000字"）</td>
                                        <td class="px-4 py-3 text-gray-600">1. 格式和风格为下拉选择<br>
                                        2. 字数要求为滑块选择或直接输入数字范围</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">参考资料（可选）</td>
                                        <td class="px-4 py-3 text-gray-600">可上传相关参考资料（如既往公文范例、数据报表、会议纪要等），帮助AI生成更贴合需求的内容</td>
                                        <td class="px-4 py-3 text-gray-600">1. 支持上传Word、PDF、Excel格式文件<br>
                                        2. 单个文件≤10MB，最多上传3个文件<br>
                                        3. 也可直接粘贴文本内容作为参考（最多5000字）</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    
                    <div>
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.4.3 输出</h4>
                        <div class="overflow-x-auto">
                            <table class="min-w-full divide-y divide-gray-200">
                                <thead>
                                    <tr>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">输出类型</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">具体内容</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">交互方式</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white divide-y divide-gray-200">
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">生成的公文初稿</td>
                                        <td class="px-4 py-3 text-gray-600">1. 完整文本：符合所选类型和格式要求的公文全文，包含标准公文要素（如文号、签发人、主送机关、正文、附件说明、成文日期等）<br>
                                        2. 格式规范：自动应用企业标准格式（字体、字号、行距、页边距等）<br>
                                        3. 内容适配：根据输入的核心信息和参考资料生成针对性内容，避免模板化表述</td>
                                        <td class="px-4 py-3 text-gray-600">1. 在线编辑器展示，支持实时编辑修改<br>
                                        2. 编辑器支持常见文本格式化操作（加粗、缩进、项目符号等）<br>
                                        3. 支持"保存草稿"功能，草稿自动保存7天<br>
                                        4. 提供"重新生成"按钮，可基于修改后的信息重新生成</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">格式校验报告</td>
                                        <td class="px-4 py-3 text-gray-600">1. 合规检查：自动检查公文格式是否符合企业标准（如文号格式、标题格式、落款位置等）<br>
                                        2. 问题提示：标注不符合规范的位置并说明原因（如"文号应为'企办发〔2024〕X号'格式"）<br>
                                        3. 修正建议：提供具体的格式修正方案，支持一键修复</td>
                                        <td class="px-4 py-3 text-gray-600">1. 在校稿模式下，格式问题处标红并显示悬浮提示<br>
                                        2. 支持"一键修复所有格式问题"功能<br>
                                        3. 修复后提供"修改记录"，显示修复前后的对比</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">内容优化建议</td>
                                        <td class="px-4 py-3 text-gray-600">1. 用词建议：识别不规范或不恰当的用词，推荐更合适的表述（如将"我们觉得"改为"本单位认为"）<br>
                                        2. 逻辑优化：提示内容逻辑不清晰或冗余的部分，建议调整顺序或精简表述<br>
                                        3. 合规提醒：若涉及敏感内容（如数据、政策引用），提示需核实的信息点</td>
                                        <td class="px-4 py-3 text-gray-600">1. 优化建议以侧边栏形式展示，可逐条查看<br>
                                        2. 支持"采纳"或"忽略"单条建议，采纳后自动修改文本<br>
                                        3. 提供"查看所有建议"和"一键采纳全部建议"选项</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">多格式导出文件</td>
                                        <td class="px-4 py-3 text-gray-600">1. 可导出为多种格式：<br>
                                        - Word格式（.docx）：保留完整编辑功能，用于后续修改<br>
                                        - PDF格式：用于正式发布或归档<br>
                                        - 纯文本格式（.txt）：用于快速复制粘贴<br>
                                        2. 导出文件自动添加企业标准页眉页脚（如公司logo、保密级别）</td>
                                        <td class="px-4 py-3 text-gray-600">1. 提供"导出"下拉菜单，选择所需格式<br>
                                        2. 导出前可设置文件名（默认格式："[公文类型]-[标题]-[日期].docx"）<br>
                                        3. 支持"直接发送至审批系统"（对接企业OA审批流程）</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </section>
                
                <!-- 5.5 智能投标助手 -->
                <section id="bidding-assistant" class="mb-8">
                    <h3 class="subsection-title">5.5 智能投标助手</h3>
                    
                    <div class="mb-5">
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.5.1 应用定位</h4>
                        <p class="text-gray-700 pl-4 border-l-2 border-primary">面向销售、商务、市场等参与投标工作的部门，提供招标文件分析、投标文件生成、竞争力分析等功能，提高投标效率和中标率</p>
                    </div>
                    
                    <div class="mb-5">
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.5.2 输入</h4>
                        <div class="overflow-x-auto">
                            <table class="min-w-full divide-y divide-gray-200">
                                <thead>
                                    <tr>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">输入类型</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">具体要求</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">格式限制</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white divide-y divide-gray-200">
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">招标文件</td>
                                        <td class="px-4 py-3 text-gray-600">完整的招标方发布文件，包括招标公告、投标人须知、技术要求、商务要求、合同条款、评分标准等</td>
                                        <td class="px-4 py-3 text-gray-600">1. 支持PDF、Word格式<br>
                                        2. 单个文件≤50MB，多文件总大小≤100MB<br>
                                        3. 可识别扫描版PDF中的文字内容（OCR处理）</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">企业基础资料</td>
                                        <td class="px-4 py-3 text-gray-600">1. 公司资质：营业执照、相关行业资质证书、荣誉奖项等<br>
                                        2. 过往业绩：类似项目案例、客户评价、成功案例介绍<br>
                                        3. 团队信息：核心团队成员资质、经验介绍</td>
                                        <td class="px-4 py-3 text-gray-600">1. 支持PDF、Word、图片格式<br>
                                        2. 可选择关联平台已存储的企业资料（需提前上传）<br>
                                        3. 文字资料最多5000字，图片最多10张</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">投标策略参数</td>
                                        <td class="px-4 py-3 text-gray-600">1. 投标目标：中标优先级（如"必须中标""争取中标""尝试参与"）<br>
                                        2. 价格策略：预算范围、价格竞争力定位（如"低价策略""中等价格""优质高价"）<br>
                                        3. 优势重点：希望突出的企业优势（如"技术优势""服务优势""价格优势""经验优势"）</td>
                                        <td class="px-4 py-3 text-gray-600">1. 通过选项卡和下拉菜单选择<br>
                                        2. 预算范围支持输入具体金额区间<br>
                                        3. 优势重点可多选（最多4项）并排序</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">特殊要求说明</td>
                                        <td class="px-4 py-3 text-gray-600">针对本次投标的特殊情况说明，如：<br>
                                        1. 需要规避的风险点<br>
                                        2. 必须满足的特殊条件<br>
                                        3. 其他需要特别说明的事项</td>
                                        <td class="px-4 py-3 text-gray-600">文本输入，最多1000字，支持加粗、列表等简单格式</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    
                    <div>
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.5.3 输出</h4>
                        <div class="overflow-x-auto">
                            <table class="min-w-full divide-y divide-gray-200">
                                <thead>
                                    <tr>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">输出类型</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">具体内容</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">交互方式</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white divide-y divide-gray-200">
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">招标文件分析报告</td>
                                        <td class="px-4 py-3 text-gray-600">1. 核心需求提炼：招标方的核心需求、重点关注事项、项目目标<br>
                                        2. 资格要求清单：逐条列出投标人资格要求及注意事项<br>
                                        3. 评分标准解读：分析各评分项权重、得分要点、失分风险<br>
                                        4. 关键时间节点：投标截止时间、开标时间、答疑截止时间等<br>
                                        5. 风险提示：潜在的投标风险点（如要求不合理、时间紧张等）</td>
                                        <td class="px-4 py-3 text-gray-600">1. 在线分页展示，重要信息标红突出<br>
                                        2. 支持跳转到招标文件对应位置查看原文<br>
                                        3. 提供PDF格式下载，支持打印<br>
                                        4. 支持添加批注和笔记</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">投标文件框架与初稿</td>
                                        <td class="px-4 py-3 text-gray-600">1. 标准框架：根据招标文件要求自动生成符合规范的投标文件目录结构<br>
                                        2. 内容初稿：<br>
                                        - 公司简介（基于企业资料自动生成）<br>
                                        - 技术方案（根据招标技术要求和企业优势生成）<br>
                                        - 商务方案（包含报价表、服务承诺等）<br>
                                        - 资质证明文件清单（自动匹配招标要求）<br>
                                        3. 格式规范：符合招标文件要求的字体、页码、目录格式</td>
                                        <td class="px-4 py-3 text-gray-600">1. 在线编辑环境，支持多人协作编辑<br>
                                        2. 左侧显示目录导航，可快速跳转至对应章节<br>
                                        3. 支持自动保存和版本管理（保留最近5个版本）<br>
                                        4. 提供"插入企业资料"按钮，快速插入已上传的资质文件</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">竞争力分析报告</td>
                                        <td class="px-4 py-3 text-gray-600">1. 优势分析：企业相对于招标要求的优势点，及如何在投标中突出展示<br>
                                        2. 劣势应对：企业存在的不足或与招标要求的差距，及应对建议<br>
                                        3. 价格建议：基于市场行情和竞争情况的报价区间建议<br>
                                        4. 中标概率评估：综合评分（1-10分）及中标可能性分析</td>
                                        <td class="px-4 py-3 text-gray-600">1. 以仪表盘和图表形式直观展示分析结果<br>
                                        2. 支持查看分析依据和计算逻辑<br>
                                        3. 可调整参数（如价格策略）重新计算评估结果<br>
                                        4. 支持导出为PPT格式，用于内部评审会议</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">投标检查清单</td>
                                        <td class="px-4 py-3 text-gray-600">1. 文档完整性检查：投标文件是否包含所有要求的内容<br>
                                        2. 格式合规检查：是否符合招标文件的格式要求<br>
                                        3. 资质匹配检查：提交的资质是否满足所有资格要求<br>
                                        4. 商务条款检查：报价、付款方式等是否合理<br>
                                        5. 常见错误检查：是否存在错别字、数据错误等低级错误</td>
                                        <td class="px-4 py-3 text-gray-600">1. 以交互式清单形式展示，支持逐项勾选确认<br>
                                        2. 未完成项标红提醒，已完成项标绿<br>
                                        3. 提供"一键检查"功能，自动检测常见问题<br>
                                        4. 支持导出检查结果，作为内部审批依据</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </section>
                
                <!-- 5.6 图像智能识别 -->
                <section id="image-recognition" class="mb-8">
                    <h3 class="subsection-title">5.6 图像智能识别</h3>
                    
                    <div class="mb-5">
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.6.1 应用定位</h4>
                        <p class="text-gray-700 pl-4 border-l-2 border-primary">面向需要处理大量图像信息的部门（如质检、仓储、行政），提供图像内容识别、文字提取、物体检测等功能，将图像信息转化为可编辑的结构化数据</p>
                    </div>
                    
                    <div class="mb-5">
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.6.2 输入</h4>
                        <div class="overflow-x-auto">
                            <table class="min-w-full divide-y divide-gray-200">
                                <thead>
                                    <tr>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">输入类型</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">具体要求</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">格式限制</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white divide-y divide-gray-200">
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">图像文件</td>
                                        <td class="px-4 py-3 text-gray-600">需要识别的图像，包括：<br>
                                        1. 文档类图像：扫描件、照片、截图等包含文字的图像<br>
                                        2. 物体类图像：产品照片、场景照片等需要识别物体的图像<br>
                                        3. 图表类图像：包含表格、图表的图像</td>
                                        <td class="px-4 py-3 text-gray-600">1. 支持JPG、PNG、BMP、TIFF格式<br>
                                        2. 单个文件大小≤10MB<br>
                                        3. 分辨率建议≥300dpi，最低不低于72dpi<br>
                                        4. 支持批量上传，单次最多20张</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">识别类型选择</td>
                                        <td class="px-4 py-3 text-gray-600">选择需要执行的识别任务类型：<br>
                                        1. 文字识别（OCR）：提取图像中的文字内容<br>
                                        2. 物体检测：识别图像中的物体并分类计数<br>
                                        3. 表格识别：提取图像中的表格内容并转化为Excel格式<br>
                                        4. 人脸识别（需权限）：识别图像中的人脸并比对（适用于门禁、考勤等场景）<br>
                                        5. 自定义识别：基于企业自定义模型的专项识别（如产品缺陷检测）</td>
                                        <td class="px-4 py-3 text-gray-600">可多选，不同识别类型对应不同的处理流程和输出结果</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">识别参数设置</td>
                                        <td class="px-4 py-3 text-gray-600">根据选择的识别类型设置具体参数：<br>
                                        1. 文字识别：选择语言（中、英、日、韩等）、是否保留排版、是否区分段落<br>
                                        2. 物体检测：选择检测模型（通用物体、特定行业物体如"电子元件""工业零件"）<br>
                                        3. 表格识别：是否包含表头、是否合并单元格、是否识别公式</td>
                                        <td class="px-4 py-3 text-gray-600">根据所选识别类型动态显示相关参数设置项，提供默认值</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">输出格式选择</td>
                                        <td class="px-4 py-3 text-gray-600">选择识别结果的输出格式：<br>
                                        1. 文字识别：纯文本、Word、PDF（可搜索）<br>
                                        2. 物体检测：标注图像、JSON数据、Excel统计<br>
                                        3. 表格识别：Excel、CSV、HTML表格<br>
                                        4. 人脸识别：识别报告、比对结果表格</td>
                                        <td class="px-4 py-3 text-gray-600">可多选输出格式，系统将同时生成所选的多种格式文件</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    
                    <div>
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.6.3 输出</h4>
                        <div class="overflow-x-auto">
                            <table class="min-w-full divide-y divide-gray-200">
                                <thead>
                                    <tr>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">输出类型</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">具体内容</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">交互方式</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white divide-y divide-gray-200">
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">识别结果预览</td>
                                        <td class="px-4 py-3 text-gray-600">1. 文字识别：提取的文字内容，保留原始排版格式，识别准确率标注<br>
                                        2. 物体检测：原始图像上叠加物体框和类别标签，显示每个物体的置信度<br>
                                        3. 表格识别：识别后的表格内容预览，与原始表格图像对比显示<br>
                                        4. 人脸识别：识别结果列表，包含相似度评分、匹配人员信息</td>
                                        <td class="px-4 py-3 text-gray-600">1. 分屏对比显示（左侧原始图像，右侧识别结果）<br>
                                        2. 支持缩放、平移操作，查看细节<br>
                                        3. 识别结果中低置信度部分标黄提示<br>
                                        4. 提供在线编辑功能，可直接修正识别错误</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">结构化数据文件</td>
                                        <td class="px-4 py-3 text-gray-600">1. 根据所选输出格式生成的可编辑文件：<br>
                                        - 文字内容：Word文档、纯文本文件<br>
                                        - 表格数据：Excel文件、CSV文件<br>
                                        - 物体信息：包含物体类别、位置、数量的JSON/Excel文件<br>
                                        2. 所有文件保留与原始图像的关联信息，方便溯源</td>
                                        <td class="px-4 py-3 text-gray-600">1. 提供压缩包下载（包含所有生成的文件）<br>
                                        2. 支持单个文件下载，鼠标悬停显示文件大小<br>
                                        3. 支持直接打开在线预览（如Excel表格在线查看）<br>
                                        4. 支持"发送到邮箱"功能，将文件发送至指定邮箱</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">识别质量报告</td>
                                        <td class="px-4 py-3 text-gray-600">1. 总体识别准确率：基于样本对比计算的总体准确率评分（0-100%）<br>
                                        2. 错误分析：识别错误的类型统计（如文字识别中的错字、漏字、多字）<br>
                                        3. 优化建议：提高识别质量的建议（如"图像模糊，建议重新拍摄清晰图像"）<br>
                                        4. 处理时间：各环节的处理时长统计</td>
                                        <td class="px-4 py-3 text-gray-600">1. 以图表和数字形式直观展示<br>
                                        2. 支持查看详细的错误示例和位置<br>
                                        3. 可导出为PDF报告，用于质量分析<br>
                                        4. 提供"重新识别"按钮，可调整参数后重新处理</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">批量处理结果汇总</td>
                                        <td class="px-4 py-3 text-gray-600">当进行批量识别时，提供：<br>
                                        1. 处理状态统计：成功数量、失败数量、处理中数量<br>
                                        2. 结果概览：各图像的关键识别结果摘要（如"共识别10张发票，总金额XXX元"）<br>
                                        3. 异常提示：识别失败或质量较差的图像列表及原因</td>
                                        <td class="px-4 py-3 text-gray-600">1. 以仪表盘形式展示批量处理统计数据<br>
                                        2. 支持按处理状态、识别质量筛选图像<br>
                                        3. 提供批量下载所有结果或仅下载成功结果的选项<br>
                                        4. 支持将汇总数据导出为Excel统计报表</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </section>
                
                <!-- 5.7 智能客户服务 -->
                <section id="customer-service" class="mb-8">
                    <h3 class="subsection-title">5.7 智能客户服务</h3>
                    
                    <div class="mb-5">
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.7.1 应用定位</h4>
                        <p class="text-gray-700 pl-4 border-l-2 border-primary">面向客服、销售等直接与客户接触的部门，提供客户咨询自动应答、问题分类、工单生成等功能，提升客户服务效率和满意度</p>
                    </div>
                    
                    <div class="mb-5">
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.7.2 输入</h4>
                        <div class="overflow-x-auto">
                            <table class="min-w-full divide-y divide-gray-200">
                                <thead>
                                    <tr>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">输入类型</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">具体要求</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">格式限制</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white divide-y divide-gray-200">
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">客户咨询内容</td>
                                        <td class="px-4 py-3 text-gray-600">客户通过各种渠道（电话、在线聊天、邮件）提交的咨询内容，包括：<br>
                                        1. 文本咨询：客户输入的文字消息<br>
                                        2. 语音咨询：客户的语音留言或实时语音（需转为文本）<br>
                                        3. 图像咨询：客户发送的包含问题的图片（如产品故障照片）</td>
                                        <td class="px-4 py-3 text-gray-600">1. 文本：最多500字，支持中英文<br>
                                        2. 语音：支持MP3、WAV格式，时长≤5分钟<br>
                                        3. 图像：支持JPG、PNG格式，大小≤5MB<br>
                                        4. 支持多轮对话上下文关联</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">客户信息</td>
                                        <td class="px-4 py-3 text-gray-600">1. 基本信息：客户姓名、联系方式、客户ID（如有）<br>
                                        2. 历史记录：客户过往咨询记录、购买记录、服务记录<br>
                                        3. 标签信息：客户分类标签（如"VIP客户""新客户""投诉客户"）</td>
                                        <td class="px-4 py-3 text-gray-600">1. 可手动输入或从CRM系统自动同步<br>
                                        2. 支持通过手机号/邮箱快速查询客户信息<br>
                                        3. 历史记录最多显示最近10条</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">服务参数设置</td>
                                        <td class="px-4 py-3 text-gray-600">1. 服务类型：售前咨询、售后支持、投诉处理、产品咨询等<br>
                                        2. 应答风格：正式、亲切、专业、简洁等<br>
                                        3. 权限设置：是否允许提及价格、是否可以承诺服务期限等<br>
                                        4. 转接条件：设置自动转接人工客服的条件（如关键词、情绪识别）</td>
                                        <td class="px-4 py-3 text-gray-600">1. 通过下拉菜单和复选框进行设置<br>
                                        2. 提供默认参数模板，可快速应用<br>
                                        3. 转接条件可自定义设置多个规则</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">产品/服务信息</td>
                                        <td class="px-4 py-3 text-gray-600">与客户咨询相关的产品或服务信息，如：<br>
                                        1. 产品型号、规格、价格<br>
                                        2. 服务内容、范围、期限<br>
                                        3. 常见问题及解决方案</td>
                                        <td class="px-4 py-3 text-gray-600">1. 可从产品数据库选择或手动输入<br>
                                        2. 支持关联多个相关产品/服务<br>
                                        3. 系统自动匹配客户咨询可能涉及的产品信息</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    
                    <div>
                        <h4 class="text-lg font-medium mb-3 text-gray-800">5.7.3 输出</h4>
                        <div class="overflow-x-auto">
                            <table class="min-w-full divide-y divide-gray-200">
                                <thead>
                                    <tr>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">输出类型</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">具体内容</th>
                                        <th class="px-4 py-3 whitespace-nowrap table-header text-left">交互方式</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white divide-y divide-gray-200">
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">智能应答内容</td>
                                        <td class="px-4 py-3 text-gray-600">1. 回复文本：针对客户咨询的自然语言回复，包含：<br>
                                        - 问题解答：直接回应客户疑问<br>
                                        - 相关信息：提供客户可能需要的补充信息<br>
                                        - 下一步建议：引导客户进行下一步操作（如"如需购买，可点击链接..."）<br>
                                        2. 多媒体内容：根据需要提供的图片、视频、文档等辅助说明材料<br>
                                        3. 个性化调整：根据客户信息和历史记录调整回复语气和内容</td>
                                        <td class="px-4 py-3 text-gray-600">1. 提供"直接发送"和"编辑后发送"两个选项<br>
                                        2. 支持调整回复语气和详细程度<br>
                                        3. 可一键添加常用回复模板内容<br>
                                        4. 发送后自动记录到客户沟通历史</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">客户意图分析</td>
                                        <td class="px-4 py-3 text-gray-600">1. 意图分类：识别客户咨询的主要意图（如"产品咨询""投诉""购买意向""技术支持"）<br>
                                        2. 情绪分析：判断客户情绪状态（如"满意""中性""不满""愤怒"）<br>
                                        3. 关键信息提取：提取咨询中的关键信息（如产品型号、问题描述、时间地点）<br>
                                        4. 潜在需求：分析客户可能未明确表达的潜在需求</td>
                                        <td class="px-4 py-3 text-gray-600">1. 在客服界面侧边栏实时显示<br>
                                        2. 情绪分析结果用不同颜色标识（绿色-积极，黄色-中性，红色-消极）<br>
                                        3. 关键信息可点击复制，快速填入工单或CRM系统<br>
                                        4. 支持人工修正分析结果，系统通过反馈不断优化</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">服务工单</td>
                                        <td class="px-4 py-3 text-gray-600">当需要后续处理时，自动生成服务工单，包含：<br>
                                        1. 工单基本信息：工单编号、创建时间、优先级<br>
                                        2. 客户信息：姓名、联系方式、客户ID<br>
                                        3. 问题描述：基于客户咨询内容自动生成<br>
                                        4. 处理建议：针对问题的推荐处理方案和责任人<br>
                                        5. 处理状态：待处理、处理中、已解决、已关闭</td>
                                        <td class="px-4 py-3 text-gray-600">1. 支持"自动创建"和"手动创建"两种方式<br>
                                        2. 工单信息自动填充，可手动编辑补充<br>
                                        3. 支持一键分配给相关处理人员<br>
                                        4. 工单状态变更时自动通知相关人员和客户<br>
                                        5. 支持导出工单报表，进行服务质量分析</td>
                                    </tr>
                                    <tr>
                                        <td class="px-4 py-3 whitespace-nowrap font-medium text-gray-700">服务质量分析</td>
                                        <td class="px-4 py-3 text-gray-600">1. 会话分析：单次会话的处理时长、解决率、客户满意度预测<br>
                                        2. 趋势统计：客户咨询量、问题类型分布、解决率的时间趋势<br>
                                        3. 热点问题：高频出现的客户问题及解决方案效果评估<br>
                                        4. 改进建议：基于分析结果提出的服务改进建议（如"增加XX问题的自动回复模板"）</td>
                                        <td class="px-4 py-3 text-gray-600">1. 以仪表盘和图表形式直观展示<br>
                                        2. 支持按时间、部门、客服人员等维度筛选分析<br>
                                        3. 可导出详细分析报告（PDF/Excel格式）<br>
                                        4. 支持设置关键指标预警（如"投诉率超过5%时预警"）</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </section>
            </section>
        </main>
    </div>

    <!-- 页脚 -->
    <footer class="bg-white border-t border-gray-200 mt-12">
        <div class="container mx-auto px-4 py-6">
            <div class="flex flex-col md:flex-row justify-between items-center">
                <p class="text-sm text-gray-500">© 2024 企业AI应用平台 内部文档</p>
                <div class="flex space-x-6 mt-4 md:mt-0">
                    <a href="#" class="text-sm text-gray-500 hover:text-primary transition-colors">文档修订记录</a>
                    <a href="#" class="text-sm text-gray-500 hover:text-primary transition-colors">版本说明</a>
                    <a href="#" class="text-sm text-gray-500 hover:text-primary transition-colors">反馈建议</a>
                </div>
            </div>
        </div>
    