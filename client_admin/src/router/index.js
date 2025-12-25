import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},


	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},



	// 友情链接路由
	// {
	// 	path: '/link/table',
	// 	name: 'link_table',
	// 	component: () => import('../views/link/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接列表'
	// 	}
	// },
	// {
	// 	path: '/link/view',
	// 	name: 'link_view',
	// 	component: () => import('../views/link/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接详情'
	// 	}
	// },

	// 轮播图路由
	{
		path: '/slides/table',
		name: 'slides_table',
		component: () => import('../views/slides/table.vue'),
		meta: {
			index: 0,
			title: '轮播图列表'
		}
	},
	{
		path: '/slides/view',
		name: 'slides_view',
		component: () => import('../views/slides/view.vue'),
		meta: {
			index: 0,
			title: '轮播图详情'
		}
	},
		// 文章路由
	{
		path: '/article/table',
		name: 'article_table',
		component: () => import('../views/article/table.vue'),
		meta: {
			index: 0,
			title: '文章列表'
		}
	},
	{
		path: '/article/view',
		name: 'article_view',
		component: () => import('../views/article/view.vue'),
		meta: {
			index: 0,
			title: '文章详情'
		}
	},

	// 文章分类路由
	{
		path: '/article_type/table',
		name: 'article_type_table',
		component: () => import('../views/article_type/table.vue'),
		meta: {
			index: 0,
			title: '文章分类列表'
		}
	},
	{
		path: '/article_type/view',
		name: 'article_type_view',
		component: () => import('../views/article_type/view.vue'),
		meta: {
			index: 0,
			title: '文章分类详情'
		}
	},
	
	// 广告路由
	// {
	// 	path: '/ad/table',
	// 	name: 'ad_table',
	// 	component: () => import('../views/ad/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告列表'
	// 	}
	// },
	// {
	// 	path: '/ad/view',
	// 	name: 'ad_view',
	// 	component: () => import('../views/ad/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告详情'
	// 	}
	// },



	// 公告路由
	{
		path: '/notice/table',
		name: 'notice_table',
		component: () => import('../views/notice/table.vue'),
		meta: {
			index: 0,
			title: '公告信息列表'
		}
	},
	{
		path: '/notice/view',
		name: 'notice_view',
		component: () => import('../views/notice/view.vue'),
		meta: {
			index: 0,
			title: '公告信息详情'
		}
	},


	// 评论路由
	{
		path: '/comment/table',
		name: 'comment_table',
		component: () => import('../views/comment/table.vue'),
		meta: {
			index: 0,
			title: '评论列表'
		}
	},
	{
		path: '/comment/view',
		name: 'comment_view',
		component: () => import('../views/comment/view.vue'),
		meta: {
			index: 0,
			title: '评论详情'
		}
	},

	// 顾客用户路由
	{
		path: '/customer_users/table',
		name: 'customer_users_table',
		component: () => import('../views/customer_users/table.vue'),
		meta: {
			index: 0,
			title: '顾客用户列表'
		}
	},
	{
		path: '/customer_users/view',
		name: 'customer_users_view',
		component: () => import('../views/customer_users/view.vue'),
		meta: {
			index: 0,
			title: '顾客用户详情'
		}
	},
	// 员工用户路由
	{
		path: '/employee_users/table',
		name: 'employee_users_table',
		component: () => import('../views/employee_users/table.vue'),
		meta: {
			index: 0,
			title: '员工用户列表'
		}
	},
	{
		path: '/employee_users/view',
		name: 'employee_users_view',
		component: () => import('../views/employee_users/view.vue'),
		meta: {
			index: 0,
			title: '员工用户详情'
		}
	},
	// 菜品信息路由
	{
		path: '/dish_information/table',
		name: 'dish_information_table',
		component: () => import('../views/dish_information/table.vue'),
		meta: {
			index: 0,
			title: '菜品信息列表'
		}
	},
	{
		path: '/dish_information/view',
		name: 'dish_information_view',
		component: () => import('../views/dish_information/view.vue'),
		meta: {
			index: 0,
			title: '菜品信息详情'
		}
	},
	// 分类管理路由
	{
		path: '/classification_management/table',
		name: 'classification_management_table',
		component: () => import('../views/classification_management/table.vue'),
		meta: {
			index: 0,
			title: '分类管理列表'
		}
	},
	{
		path: '/classification_management/view',
		name: 'classification_management_view',
		component: () => import('../views/classification_management/view.vue'),
		meta: {
			index: 0,
			title: '分类管理详情'
		}
	},
	// 线下订单路由
	{
		path: '/offline_orders/table',
		name: 'offline_orders_table',
		component: () => import('../views/offline_orders/table.vue'),
		meta: {
			index: 0,
			title: '线下订单列表'
		}
	},
	{
		path: '/offline_orders/view',
		name: 'offline_orders_view',
		component: () => import('../views/offline_orders/view.vue'),
		meta: {
			index: 0,
			title: '线下订单详情'
		}
	},
	// 线上订单路由
	{
		path: '/online_orders/table',
		name: 'online_orders_table',
		component: () => import('../views/online_orders/table.vue'),
		meta: {
			index: 0,
			title: '线上订单列表'
		}
	},
	{
		path: '/online_orders/view',
		name: 'online_orders_view',
		component: () => import('../views/online_orders/view.vue'),
		meta: {
			index: 0,
			title: '线上订单详情'
		}
	},
	// 营业额信息路由
	{
		path: '/turnover_information/table',
		name: 'turnover_information_table',
		component: () => import('../views/turnover_information/table.vue'),
		meta: {
			index: 0,
			title: '营业额信息列表'
		}
	},
	{
		path: '/turnover_information/view',
		name: 'turnover_information_view',
		component: () => import('../views/turnover_information/view.vue'),
		meta: {
			index: 0,
			title: '营业额信息详情'
		}
	},
	// 菜品偏好路由
	{
		path: '/dish_preferences/table',
		name: 'dish_preferences_table',
		component: () => import('../views/dish_preferences/table.vue'),
		meta: {
			index: 0,
			title: '菜品偏好列表'
		}
	},
	{
		path: '/dish_preferences/view',
		name: 'dish_preferences_view',
		component: () => import('../views/dish_preferences/view.vue'),
		meta: {
			index: 0,
			title: '菜品偏好详情'
		}
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "餐厅管理系统-admin";
	document.title = title;
})

export default router
