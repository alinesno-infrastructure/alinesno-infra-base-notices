import { createWebHistory, createRouter } from 'vue-router'
/* Layout */
import Layout from '@/layout/SaaSLayout'
// import Layout from '@/layout'

/**
 * Note: 路由配置项
 *
 * hidden: true                     // 当设置 true 的时候该路由不会再侧边栏出现 如401，login等页面，或者如一些编辑页面/edit/1
 * alwaysShow: true                 // 当你一个路由下面的 children 声明的路由大于1个时，自动会变成嵌套的模式--如组件页面
 *                                  // 只有一个时，会将那个子路由当做根路由显示在侧边栏--如引导页面
 *                                  // 若你想不管路由下面的 children 声明的个数都显示你的根路由
 *                                  // 你可以设置 alwaysShow: true，这样它就会忽略之前定义的规则，一直显示根路由
 * redirect: noRedirect             // 当设置 noRedirect 的时候该路由在面包屑导航中不可被点击
 * name:'router-name'               // 设定路由的名字，一定要填写不然使用<keep-alive>时会出现各种问题
 * query: '{"id": 1, "name": "ry"}' // 访问路由的默认传递参数
 * roles: ['admin', 'common']       // 访问路由的角色权限
 * permissions: ['a:a:a', 'b:b:b']  // 访问路由的菜单权限
 * meta : {
    noCache: true                   // 如果设置为true，则不会被 <keep-alive> 缓存(默认 false)
    title: 'title'                  // 设置该路由在侧边栏和面包屑中展示的名字
    icon: 'svg-name'                // 设置该路由的图标，对应路径src/assets/icons/svg
    breadcrumb: false               // 如果设置为false，则不会在breadcrumb面包屑中显示
    activeMenu: '/system/user'      // 当路由设置了该属性，则会高亮相对应的侧边栏。
  }
 */

// 公共路由
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login'),
    hidden: true
  },
   {
     path: '/sso/login',
     component: () => import('@/views/loginSso'),
     hidden: true
   },
  {
    path: "/:pathMatch(.*)*",
    component: () => import('@/views/error/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error/401'),
    hidden: true
  },
  {
    path: '',
    component: Layout,
    redirect: '/index',
    hidden: true,
    children: [
      {
        path: '/index',
        component: () => import('@/views/index'),
        name: '/index',
        meta: { title: '首页', icon: 'dashboard', affix: true }
      },

      // {
      //   path: '/dashboard/smartService',
      //   component: () => import('@/views/smartService'),
      //   name: '/dashboard/smartService',
      //   meta: { title: '智能客服', icon: 'dashboard', affix: true }
      // },
      // {
      //   path: '/dashboard/serviceList',
      //   component: () => import('@/views/serviceList'),
      //   name: '/dashboard/serviceList',
      //   meta: { title: '服务列表', icon: 'dashboard', affix: true }
      // },
      {
        path: '/dashboard/suportTechnique',
        component: () => import('@/views/suportTechnique'),
        name: '/dashboard/suportTechnique',
        meta: { title: '支持管理', icon: 'dashboard', affix: true }
      },
      {
        path: '/dashboard/learnPanel',
        component: () => import('@/views/learnPanel'),
        name: '/dashboard/learnPanel',
        meta: { title: '学习手册', icon: 'dashboard', affix: true }
      },

      // ->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
      {
        path: '/createGateway',
        name: 'createGateway',
        hidden: true,
        component: () => import('@/views/gateway/createGateway'),
        meta: { title: '创建网关服务', icon: 'dashboard', affix: true }
      },
      {
        path: '/gatewayTopology',
        name: 'gatewayTopology',
        hidden: true,
        component: () => import('@/views/gateway/gatewayTopology'),
        meta: { title: '网关路由拓扑结构', icon: 'dashboard', affix: true }
      },
      {
        path: '/createClient',
        name: 'createClient',
        hidden: true,
        component: () => import('@/views/gateway/createClient'),
        meta: { title: '创建客户端', icon: 'dashboard', affix: true }
      },
      {
        path: '/addGatewayClient',
        name: 'addGatewayClient',
        hidden: true,
        component: () => import('@/views/gateway/addGatewayClient'),
        meta: { title: '添加网关客户端', icon: 'dashboard', affix: true }
      },
      {
        path: '/addClientGateway',
        name: 'addClientGateway',
        hidden: true,
        component: () => import('@/views/gateway/addClientGateway'),
        meta: { title: '添加客户端网关', icon: 'dashboard', affix: true }
      },
      {
        path: '/addGroovyScript',
        name: 'addGroovyScript',
        hidden: true,
        component: () => import('@/views/gateway/addGroovyScript'),
        meta: { title: '添加规则组件', icon: 'dashboard', affix: true }
      },
      {
        path: '/createBalanced',
        name: 'createBalanced',
        hidden: true,
        component: () => import('@/views/gateway/createBalanced'),
        meta: { title: '创建负载均衡', icon: 'dashboard', affix: true }
      },

      // >>>>>>>>>>>>>> message_router_start >>>>>>>>>>>>>>>>>>>>>
      {
        path: '/base/notice/alert/index',
        component: () => import('@/views/base/notice/alert/index'),
        name: '/base/notice/alert/index',
        meta: { title: '告警配置', icon: 'dashboard', affix: true }
      }, 
      {
        path: '/base/notice/application/index',
        component: () => import('@/views/base/notice/application/index'),
        name: '/base/notice/application/index',
        meta: { title: '应用管理', icon: 'dashboard', affix: true }
      }, 
      {
        path: '/base/notice/analyse/index',
        component: () => import('@/views/base/notice/analyse/index'),
        name: '/base/notice/analyse/index',
        meta: { title: '识别分析', icon: 'dashboard', affix: true }
      }, 
      // {
      //   path: '/base/notice/topic/index',
      //   component: () => import('@/views/base/notice/topic/index'),
      //   name: '/base/notice/topic/index',
      //   meta: { title: '主题管理', icon: 'dashboard', affix: true }
      // }, 
      // {
      //   path: '/base/notice/sendMessage/index',
      //   component: () => import('@/views/base/notice/sendMessage/index'),
      //   name: '/base/notice/sendMessage/index',
      //   meta: { title: '消息管理', icon: 'dashboard', affix: true }
      // }, 
      {
        path: '/base/notice/sendHistory/index',
        component: () => import('@/views/base/notice/sendHistory/index'),
        name: '/base/notice/sendHistory/index',
        meta: { title: '异常消息', icon: 'dashboard', affix: true }
      }, 
      {
        path: '/base/notice/settings/index',
        component: () => import('@/views/base/notice/settings/index'),
        name: '/base/notice/settings/index',
        meta: { title: '渠道配置', icon: 'dashboard', affix: true }
      }, 
      {
        path: '/base/notice/send/index',
        component: () => import('@/views/base/notice/send/index'),
        name: '/base/notice/send/index',
        meta: { title: '操作记录', icon: 'dashboard', affix: true }
      }, 
      {
        path: '/base/notice/apiRecord/index',
        component: () => import('@/views/base/notice/apiRecord/index'),
        name: '/base/notice/apiRecord/index',
        meta: { title: '操作记录', icon: 'dashboard', affix: true }
      } 
      // >>>>>>>>>>>>>> message_router_end   >>>>>>>>>>>>>>>>>>>>>

    ]
  },
  {
    path: '/user',
    component: Layout,
    hidden: true,
    redirect: 'noredirect',
    children: [
      {
        path: 'profile',
        component: () => import('@/views/system/user/profile/index'),
        name: 'Profile',
        meta: { title: '个人中心', icon: 'user' }
      }
    ]
  }
]

// 动态路由，基于用户权限动态去加载
export const dynamicRoutes = [
]

const router = createRouter({
  history: createWebHistory(),
  routes: constantRoutes,
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition
    } else {
      return { top: 0 }
    }
  },
});

export default router;
