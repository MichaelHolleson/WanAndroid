# WanAndroid

## 一、项目由来：

本项目使用了鸿祥大神[wanAndroid开放的API](https://www.wanandroid.com/blog/show/2075)，同时借鉴了屈超大神[Awesome-WanAndroid](https://www.wanandroid.com/blog/show/2075)项目，使用了
Material Design + MVP + Retrofit + Dagger2 + RxJava + GreenDao + Glide等技术，仅供参考

## 二、开放API：

### 2.1 baseUrl：
https://www.wanandroid.com

### 2.2 首页：
- 首页文章列表：
https://www.wanandroid.com/article/list/0/json

- 文章按ID查找：
https://www.wanandroid.com/article/list/0/json?cid=60

- 文章按作者查找
https://www.wanandroid.com/article/list/0/json?author=鸿洋

- 首页banner：
https://www.wanandroid.com/banner/json

- 首页常用网站：
https://www.wanandroid.com/friend/json

- 首页搜索热词：
https://www.wanandroid.com/hotkey/json



### 2.3 知识体系：
- 知识体系：
https://www.wanandroid.com/tree/json



### 2.4 导航：
https://www.wanandroid.com/navi/json



### 2.5 项目：
- 项目一级列表：
https://www.wanandroid.com/project/tree/json

- 项目二级列表：
https://www.wanandroid.com/project/list/1/json?cid=294


### 2.6 登录
- 登录
https://www.wanandroid.com/user/login
post username，password

- 注册
https://www.wanandroid.com/user/register
post username,password,repassword

- 退出
https://www.wanandroid.com/user/logout/json
清除cookie


### 2.7 收藏
- 收藏文章列表
https://www.wanandroid.com/lg/collect/list/0/json

- 收藏文章
https://www.wanandroid.com/lg/collect/1165/json
post id

- 取消收藏文章
https://www.wanandroid.com/lg/uncollect_originId/2333/json
post id



- 收藏的网站列表
https://www.wanandroid.com/lg/collect/usertools/json

- 收藏网站
https://www.wanandroid.com/lg/collect/addtool/json
post name,link

- 删除网站
https://www.wanandroid.com/lg/collect/deletetool/json
post id

- 编辑网站
https://www.wanandroid.com/lg/collect/updatetool/json
post id,name,link


- 2.8 搜索
https://www.wanandroid.com/article/query/0/json
post 页码从0开始
k：关键字


## 三、设计

首页 | 知识体系 | 项目 | 设置 | menu
--- | --- | --- | --- | ---
banner 文章列表 | 一级界面 二级界面 | 项目 | 注册 登录 退出 收藏 | 搜索 导航










