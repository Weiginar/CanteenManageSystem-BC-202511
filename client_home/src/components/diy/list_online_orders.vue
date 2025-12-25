<template>
	<div class="diy_home diy_list diy_online_orders" id="diy_online_orders_list">
		<!-- 列表 -->
		<div class="diy_view_list list list-x" v-if="show">
			<router-link class="diy_card goods diy_list_box_wrap" v-for="(o, i) in list" :key="i"
				:to="'/online_orders/details?online_orders_id=' + o['online_orders_id']">
				<!-- 图片 -->
				<div class="diy_list_img_box" v-if="imgList.length" >
					<div class="diy_row" v-for="(item,index) in imgList" :key="item+index" v-show="$check_field('get',item.name,'/online_orders/details') && +item.is_img_list">
						<div class="diy_title diy_list_img_title">
							<span>{{item.title}}:</span>
						</div>
						<div class="diy_field diy_img">
							<img :src="$fullUrl(o[item.name])" style="width:100%;height:100%" />
						</div>
					</div>
				</div>
				<!-- 内容 -->
				<div class="diy_list_item_box">
					<div class="diy_list_item_content" v-for="(item,index) in showItemList" :key="item+index">
						<div class="diy_row" :class="{[item.name]:true}" v-if="$check_field('get',item.name,'/online_orders/details') && +item.is_img_list">
							<div class="diy_title">
								<span>{{item.title}}:</span>
							</div>
							<div class="diy_field diy_text">
								<span v-if="item.type == 'UID'" v-text="get_user_name(item.name,o[item.name])"></span>
								<span v-else-if="item.type == '日期'" v-text="$toTime(o[item.name],'yyyy-MM-dd')"></span>
								<span v-else-if="item.type == '时间'" v-text="$toTime(o[item.name],'hh:mm:ss')"></span>
								<span v-else-if="item.type == '日长'" v-text="$toTime(o[item.name],'yyyy-MM-dd hh:mm:ss')"></span>
								<span v-else v-text="o[item.name]"></span>
							</div>
						</div>
					</div>
				</div>
			</router-link>
		</div>
		<!-- 表格 -->
		<div class="diy_view_table" v-else>
			<table class="diy_table">
				<tr class="diy_row">
						<th class="diy_title" v-if="$check_field('get','order_number')">
						订单编号
					</th>
							<th class="diy_title" v-if="$check_field('get','dish_name')">
						菜品名称
					</th>
							<th class="diy_title" v-if="$check_field('get','categorization_of_dishes')">
						菜品分类
					</th>
							<th class="diy_title" v-if="$check_field('get','price_of_dishes')">
						菜品价格
					</th>
							<th class="diy_title" v-if="$check_field('get','order_date')">
						订单日期
					</th>
							<th class="diy_title" v-if="$check_field('get','customer_information')">
						顾客信息
					</th>
							<th class="diy_title" v-if="$check_field('get','customer_name')">
						顾客姓名
					</th>
							<th class="diy_title" v-if="$check_field('get','customer_gender')">
						顾客性别
					</th>
							<th class="diy_title" v-if="$check_field('get','contact_number')">
						联系电话
					</th>
							<th class="diy_title" v-if="$check_field('get','order_quantity')">
						点餐数量
					</th>
							<th class="diy_title" v-if="$check_field('get','total_price_of_dishes')">
						菜品总价
					</th>
							<th class="diy_title" v-if="$check_field('get','order_notes')">
						点餐备注
					</th>
							<th class="diy_title" v-if="$check_field('get','shipping_address')">
						配送地址
					</th>
							<th class="diy_title" v-if="$check_field('get','order_status')">
						订单状态
					</th>
							<th class="diy_title" v-if="$check_field('get','delivery_description')">
						配送描述
					</th>
					</tr>
				<tr class="diy_row" v-for="(o,i) in list" :key="o+i">
						<td class="diy_field diy_text" v-if="$check_field('get','order_number')">
						<span>
							{{ o["order_number"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','dish_name')">
						<span>
							{{ o["dish_name"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','categorization_of_dishes')">
						<span>
							{{ o["categorization_of_dishes"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','price_of_dishes')">
						<span>
							{{ o["price_of_dishes"] }}
						</span>
					</td>
							<td class="diy_field diy_date" v-if="$check_field('get','order_date')">
						<span>
							{{ $toTime(o["order_date"] ,"yyyy-MM-dd") }}
						</span>
					</td>
							<td class="diy_field diy_uid" v-if="$check_field('get','customer_information')">
						<span>
							{{ get_user_name('customer_information',o['customer_information']) }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','customer_name')">
						<span>
							{{ o["customer_name"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','customer_gender')">
						<span>
							{{ o["customer_gender"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','contact_number')">
						<span>
							{{ o["contact_number"] }}
						</span>
					</td>
							<td class="diy_field diy_number" v-if="$check_field('get','order_quantity')">
						<span>
							{{ o["order_quantity"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','total_price_of_dishes')">
						<span>
							{{ o["total_price_of_dishes"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','order_notes')">
						<span>
							{{ o["order_notes"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','shipping_address')">
						<span>
							{{ o["shipping_address"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','order_status')">
						<span>
							{{ o["order_status"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','delivery_description')">
						<span>
							{{ o["delivery_description"] }}
						</span>
					</td>
					</tr>
			</table>
		</div>
	</div>
</template>

<script>
	export default {
		props: {
			list: {
				type: Array,
				default: function() {
					return [];
				},
			},
			show: {
				type: Boolean,
				default: function(){
					return true;
				}
			}
		},
		data() {
			return {
						imgList: [
						],
						itemList: [
								{
									title: "订单编号",
									name: "order_number",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "菜品名称",
									name: "dish_name",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "菜品分类",
									name: "categorization_of_dishes",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "菜品价格",
									name: "price_of_dishes",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "订单日期",
									name: "order_date",
									type: "日期",
									is_img_list: "0"
								},
								{
									title: "顾客信息",
									name: "customer_information",
									type: "UID",
									is_img_list: "0"
								},
								{
									title: "顾客姓名",
									name: "customer_name",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "顾客性别",
									name: "customer_gender",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "联系电话",
									name: "contact_number",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "点餐数量",
									name: "order_quantity",
									type: "数字",
									is_img_list: "0"
								},
								{
									title: "菜品总价",
									name: "total_price_of_dishes",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "订单状态",
									name: "order_status",
									type: "下拉",
									is_img_list: "0"
								},
						],
						richList: [
								{
									title: "点餐备注",
									name: "order_notes",
									type: "多文本"
								},
								{
									title: "配送地址",
									name: "shipping_address",
									type: "多文本"
								},
								{
									title: "配送描述",
									name: "delivery_description",
									type: "多文本"
								},
						],
										// 用户列表
				list_user_customer_information: [],
													};
		},
		methods: {
			get_user_name(name,id){
				var obj = null;
										if (name == 'customer_information'){
					obj = this.list_user_customer_information.getObj({"user_id":id});
				}
														var ret = "";
				if(obj){
					ret = obj.nickname+"-"+obj.username;
					// if(obj.nickname){
					// 	ret = obj.nickname;
					// }
					// else{
					// 	ret = obj.username;
					// }
				}
				return ret;
			},
									/**
			 * 获取顾客用户用户列表
			 */
			async get_list_user_customer_information() {
				var json = await this.$get("~/api/user/get_list?user_group=顾客用户");
				if(json.result && json.result.list){
					this.list_user_customer_information = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
												},
		created() {
									this.get_list_user_customer_information();
												},
		computed:{
			showItemList(){
				let arr = [];
				let _type = ["视频","音频","文件"];
				this.itemList.forEach(item => {
					if(_type.indexOf(item.type) === -1 && !!+item.is_img_list){
						arr.push(item)
					}
				})
				return arr.slice(0,4);
			}
		}
	};
</script>

<style scoped>
	.media {
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		flex-basis: 75%;
		min-height: 10rem;
	}

	.goods {
		display: flex;
		width: calc(25% - 1rem);
		margin: 0.5rem;
		padding: 0.5rem;
		flex-direction: column;
		justify-content: space-between;
		background-color: white;
		border-radius: 0.5rem;
	}

	.goods:hover {
		border: 0.2rem solid #909399;
		box-shadow: 0 0.1rem 0.3rem rgba(0, 0, 0, 0.15);
	}

	.goods:hover img {
		filter: blur(1px);
	}

	.price {
		font-size: 1rem;
		margin-right: 3px;
	}

	.price_ago {
		text-decoration: line-through;
		font-size: 0.5rem;
		color: #999;

	}

	.title {
		word-break: break-all;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
		font-weight: 700;
		padding: .25rem;
	}

	.icon_cart {
		color: #FF5722;
		float: right;
	}

	@media (max-width: 992px) {

		.goods {
			width: calc(33% - 1rem);
			;
		}

	}

	@media (max-width: 768px) {

		.goods {
			width: calc(50% - 1rem);
			;
		}

	}
</style>

