<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>

				<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="新闻资讯"
				source_table="article"
			  ></list_result_search>


						  <list_result_search
				v-if="$check_action('/customer_users/list', 'get')"
				:list="result_customer_users_customer_name"
				title="顾客用户顾客姓名"
				source_table="customer_users"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/customer_users/list', 'get')"
				:list="result_customer_users_customer_gender"
				title="顾客用户顾客性别"
				source_table="customer_users"
			  ></list_result_search>
												  <list_result_search
				v-if="$check_action('/employee_users/list', 'get')"
				:list="result_employee_users_employee_name"
				title="员工用户员工姓名"
				source_table="employee_users"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/employee_users/list', 'get')"
				:list="result_employee_users_employee_gender"
				title="员工用户员工性别"
				source_table="employee_users"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/employee_users/list', 'get')"
				:list="result_employee_users_employee_id"
				title="员工用户员工工号"
				source_table="employee_users"
			  ></list_result_search>
									  <list_result_search
				v-if="$check_action('/dish_information/list', 'get')"
				:list="result_dish_information_dish_name"
				title="菜品信息菜品名称"
				source_table="dish_information"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/dish_information/list', 'get')"
				:list="result_dish_information_categorization_of_dishes"
				title="菜品信息菜品分类"
				source_table="dish_information"
			  ></list_result_search>
																								  <list_result_search
				v-if="$check_action('/classification_management/list', 'get')"
				:list="result_classification_management_categorization_of_dishes"
				title="分类管理菜品分类"
				source_table="classification_management"
			  ></list_result_search>
												  <list_result_search
				v-if="$check_action('/offline_orders/list', 'get')"
				:list="result_offline_orders_dish_name"
				title="线下订单菜品名称"
				source_table="offline_orders"
			  ></list_result_search>
																																						  <list_result_search
				v-if="$check_action('/offline_orders/list', 'get')"
				:list="result_offline_orders_order_status"
				title="线下订单订单状态"
				source_table="offline_orders"
			  ></list_result_search>
												  <list_result_search
				v-if="$check_action('/online_orders/list', 'get')"
				:list="result_online_orders_dish_name"
				title="线上订单菜品名称"
				source_table="online_orders"
			  ></list_result_search>
																																									  <list_result_search
				v-if="$check_action('/online_orders/list', 'get')"
				:list="result_online_orders_order_status"
				title="线上订单订单状态"
				source_table="online_orders"
			  ></list_result_search>
												  <list_result_search
				v-if="$check_action('/turnover_information/list', 'get')"
				:list="result_turnover_information_title_name"
				title="营业额信息标题名称"
				source_table="turnover_information"
			  ></list_result_search>
																		  <list_result_search
				v-if="$check_action('/dish_preferences/list', 'get')"
				:list="result_dish_preferences_dish_name"
				title="菜品偏好菜品名称"
				source_table="dish_preferences"
			  ></list_result_search>
															</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_article": [],
						"result_customer_users_customer_name":[],
								"result_customer_users_customer_gender":[],
												"result_employee_users_employee_name":[],
								"result_employee_users_employee_gender":[],
								"result_employee_users_employee_id":[],
									"result_dish_information_dish_name":[],
								"result_dish_information_categorization_of_dishes":[],
																								"result_classification_management_categorization_of_dishes":[],
												"result_offline_orders_dish_name":[],
																																						"result_offline_orders_order_status":[],
												"result_online_orders_dish_name":[],
																																									"result_online_orders_order_status":[],
												"result_turnover_information_title_name":[],
																		"result_dish_preferences_dish_name":[],
													};
  },
  methods: {
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},

				/**
	 * 获取customer_name
	 */
	get_customer_users_customer_name(){
		let url = "~/api/customer_users/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "customer_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_customer_users_customer_name = json.result.list;
			result_customer_users_customer_name.map(o => o.title = o['customer_name'])
	  			this.result_customer_users_customer_name = result_customer_users_customer_name
		 	}
		});
	},
						/**
	 * 获取customer_gender
	 */
	get_customer_users_customer_gender(){
		let url = "~/api/customer_users/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "customer_gender": this.query.word }, (json) => {
		  if (json.result) {
			var result_customer_users_customer_gender = json.result.list;
			result_customer_users_customer_gender.map(o => o.title = o['customer_gender'])
	  			this.result_customer_users_customer_gender = result_customer_users_customer_gender
		 	}
		});
	},
										/**
	 * 获取employee_name
	 */
	get_employee_users_employee_name(){
		let url = "~/api/employee_users/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "employee_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_employee_users_employee_name = json.result.list;
			result_employee_users_employee_name.map(o => o.title = o['employee_name'])
	  			this.result_employee_users_employee_name = result_employee_users_employee_name
		 	}
		});
	},
						/**
	 * 获取employee_gender
	 */
	get_employee_users_employee_gender(){
		let url = "~/api/employee_users/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "employee_gender": this.query.word }, (json) => {
		  if (json.result) {
			var result_employee_users_employee_gender = json.result.list;
			result_employee_users_employee_gender.map(o => o.title = o['employee_gender'])
	  			this.result_employee_users_employee_gender = result_employee_users_employee_gender
		 	}
		});
	},
						/**
	 * 获取employee_id
	 */
	get_employee_users_employee_id(){
		let url = "~/api/employee_users/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "employee_id": this.query.word }, (json) => {
		  if (json.result) {
			var result_employee_users_employee_id = json.result.list;
			result_employee_users_employee_id.map(o => o.title = o['employee_id'])
	  			this.result_employee_users_employee_id = result_employee_users_employee_id
		 	}
		});
	},
							/**
	 * 获取dish_name
	 */
	get_dish_information_dish_name(){
		let url = "~/api/dish_information/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "dish_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_dish_information_dish_name = json.result.list;
			result_dish_information_dish_name.map(o => o.title = o['dish_name'])
	  			this.result_dish_information_dish_name = result_dish_information_dish_name
		 	}
		});
	},
						/**
	 * 获取categorization_of_dishes
	 */
	get_dish_information_categorization_of_dishes(){
		let url = "~/api/dish_information/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "categorization_of_dishes": this.query.word }, (json) => {
		  if (json.result) {
			var result_dish_information_categorization_of_dishes = json.result.list;
			result_dish_information_categorization_of_dishes.map(o => o.title = o['categorization_of_dishes'])
	  			this.result_dish_information_categorization_of_dishes = result_dish_information_categorization_of_dishes
		 	}
		});
	},
																						/**
	 * 获取categorization_of_dishes
	 */
	get_classification_management_categorization_of_dishes(){
		let url = "~/api/classification_management/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "categorization_of_dishes": this.query.word }, (json) => {
		  if (json.result) {
			var result_classification_management_categorization_of_dishes = json.result.list;
			result_classification_management_categorization_of_dishes.map(o => o.title = o['categorization_of_dishes'])
	  			this.result_classification_management_categorization_of_dishes = result_classification_management_categorization_of_dishes
		 	}
		});
	},
										/**
	 * 获取dish_name
	 */
	get_offline_orders_dish_name(){
		let url = "~/api/offline_orders/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "dish_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_offline_orders_dish_name = json.result.list;
			result_offline_orders_dish_name.map(o => o.title = o['dish_name'])
	  			this.result_offline_orders_dish_name = result_offline_orders_dish_name
		 	}
		});
	},
																																				/**
	 * 获取order_status
	 */
	get_offline_orders_order_status(){
		let url = "~/api/offline_orders/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "order_status": this.query.word }, (json) => {
		  if (json.result) {
			var result_offline_orders_order_status = json.result.list;
			result_offline_orders_order_status.map(o => o.title = o['order_status'])
	  			this.result_offline_orders_order_status = result_offline_orders_order_status
		 	}
		});
	},
										/**
	 * 获取dish_name
	 */
	get_online_orders_dish_name(){
		let url = "~/api/online_orders/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "dish_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_online_orders_dish_name = json.result.list;
			result_online_orders_dish_name.map(o => o.title = o['dish_name'])
	  			this.result_online_orders_dish_name = result_online_orders_dish_name
		 	}
		});
	},
																																							/**
	 * 获取order_status
	 */
	get_online_orders_order_status(){
		let url = "~/api/online_orders/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "order_status": this.query.word }, (json) => {
		  if (json.result) {
			var result_online_orders_order_status = json.result.list;
			result_online_orders_order_status.map(o => o.title = o['order_status'])
	  			this.result_online_orders_order_status = result_online_orders_order_status
		 	}
		});
	},
										/**
	 * 获取title_name
	 */
	get_turnover_information_title_name(){
		let url = "~/api/turnover_information/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "title_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_turnover_information_title_name = json.result.list;
			result_turnover_information_title_name.map(o => o.title = o['title_name'])
	  			this.result_turnover_information_title_name = result_turnover_information_title_name
		 	}
		});
	},
																/**
	 * 获取dish_name
	 */
	get_dish_preferences_dish_name(){
		let url = "~/api/dish_preferences/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "dish_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_dish_preferences_dish_name = json.result.list;
			result_dish_preferences_dish_name.map(o => o.title = o['dish_name'])
	  			this.result_dish_preferences_dish_name = result_dish_preferences_dish_name
		 	}
		});
	},
												
  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_article();
					this.get_customer_users_customer_name();
							this.get_customer_users_customer_gender();
											this.get_employee_users_employee_name();
							this.get_employee_users_employee_gender();
							this.get_employee_users_employee_id();
								this.get_dish_information_dish_name();
							this.get_dish_information_categorization_of_dishes();
																							this.get_classification_management_categorization_of_dishes();
											this.get_offline_orders_dish_name();
																																					this.get_offline_orders_order_status();
											this.get_online_orders_dish_name();
																																								this.get_online_orders_order_status();
											this.get_turnover_information_title_name();
																	this.get_dish_preferences_dish_name();
												  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_article();
				  this.get_customer_users_customer_name();
						  this.get_customer_users_customer_gender();
										  this.get_employee_users_employee_name();
						  this.get_employee_users_employee_gender();
						  this.get_employee_users_employee_id();
							  this.get_dish_information_dish_name();
						  this.get_dish_information_categorization_of_dishes();
																						  this.get_classification_management_categorization_of_dishes();
										  this.get_offline_orders_dish_name();
																																				  this.get_offline_orders_order_status();
										  this.get_online_orders_dish_name();
																																							  this.get_online_orders_order_status();
										  this.get_turnover_information_title_name();
																  this.get_dish_preferences_dish_name();
													},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
