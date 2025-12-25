<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','order_number') || $check_field('add','order_number') || $check_field('set','order_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单编号" prop="order_number">
												<el-input id="order_number" v-model="form['order_number']" placeholder="请输入订单编号"
							  v-if="user_group === '管理员' || (form['online_orders_id'] && $check_field('set','order_number')) || (!form['online_orders_id'] && $check_field('add','order_number'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','order_number')">{{form['order_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','dish_name') || $check_field('add','dish_name') || $check_field('set','dish_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="菜品名称" prop="dish_name">
												<el-input id="dish_name" v-model="form['dish_name']" placeholder="请输入菜品名称"
							  v-if="user_group === '管理员' || (form['online_orders_id'] && $check_field('set','dish_name')) || (!form['online_orders_id'] && $check_field('add','dish_name'))" :disabled="disabledObj['dish_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','dish_name')">{{form['dish_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','categorization_of_dishes') || $check_field('add','categorization_of_dishes') || $check_field('set','categorization_of_dishes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="菜品分类" prop="categorization_of_dishes">
												<el-input id="categorization_of_dishes" v-model="form['categorization_of_dishes']" placeholder="请输入菜品分类"
							  v-if="user_group === '管理员' || (form['online_orders_id'] && $check_field('set','categorization_of_dishes')) || (!form['online_orders_id'] && $check_field('add','categorization_of_dishes'))" :disabled="disabledObj['categorization_of_dishes_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','categorization_of_dishes')">{{form['categorization_of_dishes']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','price_of_dishes') || $check_field('add','price_of_dishes') || $check_field('set','price_of_dishes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="菜品价格" prop="price_of_dishes">
												<el-input id="price_of_dishes" v-model="form['price_of_dishes']" placeholder="请输入菜品价格"
							  v-if="user_group === '管理员' || (form['online_orders_id'] && $check_field('set','price_of_dishes')) || (!form['online_orders_id'] && $check_field('add','price_of_dishes'))" :disabled="disabledObj['price_of_dishes_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','price_of_dishes')">{{form['price_of_dishes']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_date') || $check_field('add','order_date') || $check_field('set','order_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单日期" prop="order_date">
								<el-date-picker :disabled="disabledObj['order_date_isDisabled']" v-if="user_group === '管理员' || (form['online_orders_id'] && $check_field('set','order_date')) || (!form['online_orders_id'] && $check_field('add','order_date'))" id="order_date"
						v-model="form['order_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','order_date')">{{form['order_date']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','customer_information') || $check_field('add','customer_information') || $check_field('set','customer_information')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="顾客信息" prop="customer_information">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_customer_information(form['customer_information']) }}
							<!--<el-input id="business_name" v-model="form['customer_information']" placeholder="请输入顾客信息"-->
							<!--v-if="user_group === '管理员' || (form['online_orders_id'] && $check_field('set','customer_information')) || (!form['online_orders_id'] && $check_field('add','customer_information'))" :disabled="disabledObj['customer_information_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','customer_information')">{{form['customer_information']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['online_orders_id'] && $check_field('set','customer_information')) || (!form['online_orders_id'] && $check_field('add','customer_information'))" id="customer_information" v-model="form['customer_information']" :disabled="disabledObj['customer_information_isDisabled']">
								<el-option v-for="o in list_user_customer_information" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','customer_information')" id="customer_information" v-model="form['customer_information']" :disabled="true">
								<el-option v-for="o in list_user_customer_information" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="customer_information" v-model="form['customer_information']" :disabled="disabledObj['customer_information_isDisabled']">
							<el-option v-for="o in list_user_customer_information" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','customer_name') || $check_field('add','customer_name') || $check_field('set','customer_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="顾客姓名" prop="customer_name">
												<el-input id="customer_name" v-model="form['customer_name']" placeholder="请输入顾客姓名"
							  v-if="user_group === '管理员' || (form['online_orders_id'] && $check_field('set','customer_name')) || (!form['online_orders_id'] && $check_field('add','customer_name'))" :disabled="disabledObj['customer_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','customer_name')">{{form['customer_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','customer_gender') || $check_field('add','customer_gender') || $check_field('set','customer_gender')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="顾客性别" prop="customer_gender">
												<el-input id="customer_gender" v-model="form['customer_gender']" placeholder="请输入顾客性别"
							  v-if="user_group === '管理员' || (form['online_orders_id'] && $check_field('set','customer_gender')) || (!form['online_orders_id'] && $check_field('add','customer_gender'))" :disabled="disabledObj['customer_gender_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','customer_gender')">{{form['customer_gender']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','contact_number') || $check_field('add','contact_number') || $check_field('set','contact_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="联系电话" prop="contact_number">
												<el-input id="contact_number" v-model="form['contact_number']" placeholder="请输入联系电话"
							  v-if="user_group === '管理员' || (form['online_orders_id'] && $check_field('set','contact_number')) || (!form['online_orders_id'] && $check_field('add','contact_number'))" :disabled="disabledObj['contact_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','contact_number')">{{form['contact_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_quantity') || $check_field('add','order_quantity') || $check_field('set','order_quantity')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="点餐数量" prop="order_quantity">
								<el-input-number id="order_quantity" v-model.number="form['order_quantity']"
						v-if="user_group === '管理员' || (form['online_orders_id'] && $check_field('set','order_quantity')) || (!form['online_orders_id'] && $check_field('add','order_quantity'))" :disabled="disabledObj['order_quantity_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','order_quantity')">{{form['order_quantity']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','total_price_of_dishes') || $check_field('add','total_price_of_dishes') || $check_field('set','total_price_of_dishes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="菜品总价" prop="total_price_of_dishes">
												<el-input id="total_price_of_dishes" v-model="form['total_price_of_dishes']" placeholder="请输入菜品总价"
							  v-if="user_group === '管理员' || (form['online_orders_id'] && $check_field('set','total_price_of_dishes')) || (!form['online_orders_id'] && $check_field('add','total_price_of_dishes'))"  @focus="set_total_price_of_dishes()" :disabled="disabledObj['total_price_of_dishes_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','total_price_of_dishes')">{{form['total_price_of_dishes']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_notes') || $check_field('add','order_notes') || $check_field('set','order_notes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="点餐备注" prop="order_notes">
								<el-input type="textarea" id="order_notes" v-model="form['order_notes']" placeholder="请输入点餐备注"
						v-if="user_group === '管理员' || (form['online_orders_id'] && $check_field('set','order_notes')) || (!form['online_orders_id'] && $check_field('add','order_notes'))" :disabled="disabledObj['order_notes_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','order_notes')">{{form['order_notes']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','shipping_address') || $check_field('add','shipping_address') || $check_field('set','shipping_address')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="配送地址" prop="shipping_address">
								<el-input type="textarea" id="shipping_address" v-model="form['shipping_address']" placeholder="请输入配送地址"
						v-if="user_group === '管理员' || (form['online_orders_id'] && $check_field('set','shipping_address')) || (!form['online_orders_id'] && $check_field('add','shipping_address'))" :disabled="disabledObj['shipping_address_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','shipping_address')">{{form['shipping_address']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_status') || $check_field('add','order_status') || $check_field('set','order_status')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单状态" prop="order_status">
								<el-select id="order_status" v-model="form['order_status']"
						v-if="user_group === '管理员' || (form['online_orders_id'] && $check_field('set','order_status')) || (!form['online_orders_id'] && $check_field('add','order_status'))">
						<el-option v-for="o in list_order_status" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','order_status')">{{form['order_status']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','delivery_description') || $check_field('add','delivery_description') || $check_field('set','delivery_description')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="配送描述" prop="delivery_description">
								<el-input type="textarea" id="delivery_description" v-model="form['delivery_description']" placeholder="请输入配送描述"
						v-if="user_group === '管理员' || (form['online_orders_id'] && $check_field('set','delivery_description')) || (!form['online_orders_id'] && $check_field('add','delivery_description'))" :disabled="disabledObj['delivery_description_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','delivery_description')">{{form['delivery_description']}}</div>
							</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "online_orders_id",
				url_add: "~/api/online_orders/add?",
				url_set: "~/api/online_orders/set?",
				url_get_obj: "~/api/online_orders/get_obj?",
				url_upload: "~/api/online_orders/upload?",

				query: {
					"online_orders_id": 0,
				},

				form: {
								"order_number": this.$get_stamp(), // 订单编号
										"dish_name":  '', // 菜品名称
										"categorization_of_dishes":  '', // 菜品分类
										"price_of_dishes":  '', // 菜品价格
										"order_date":  '', // 订单日期
										"customer_information": 0, // 顾客信息
										"customer_name":  '', // 顾客姓名
										"customer_gender":  '', // 顾客性别
										"contact_number":  '', // 联系电话
										"order_quantity":  0, // 点餐数量
										"total_price_of_dishes":  '', // 菜品总价
										"order_notes":  '', // 点餐备注
										"shipping_address":  '', // 配送地址
										"order_status":  '', // 订单状态
										"delivery_description":  '', // 配送描述
											"online_orders_id": 0, // ID
						
				},
				disabledObj:{
								"order_number_isDisabled": false,
										"dish_name_isDisabled": false,
										"categorization_of_dishes_isDisabled": false,
										"price_of_dishes_isDisabled": false,
										"order_date_isDisabled": false,
										"customer_information_isDisabled": false,
										"customer_name_isDisabled": false,
										"customer_gender_isDisabled": false,
										"contact_number_isDisabled": false,
					          			"order_quantity_isDisabled": false,
										"total_price_of_dishes_isDisabled": false,
										"order_notes_isDisabled": false,
										"shipping_address_isDisabled": false,
										"order_status_isDisabled": false,
										"delivery_description_isDisabled": false,
										},

	
		
		
		
		
		
					// 用户列表
				list_user_customer_information: [],
						// 用户组
				group_user_customer_information: "",
				
		
		
		
		
		
		
						// 订单状态选项列表
				list_order_status: ['配餐中','配送中','已完成'],
	
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
			
	
			
	
				/**
			 * 获取顾客用户用户列表
			 */
			async get_list_user_customer_information() {
                // if(this.user_group !== "管理员" && this.form["customer_information"] === 0) {
                //     this.form["customer_information"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=顾客用户");
                if(json.result && json.result.list){
                    this.list_user_customer_information = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取顾客用户用户组
			 */
			async get_group_user_customer_information() {
							this.form["customer_information"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=顾客用户");
				if(json.result && json.result.obj){
					this.group_user_customer_information = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_customer_information(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_customer_information.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
									for (let key in _this.form) {
							arrForm.push(key)
						}
												_this.form["customer_information"] = id
									_this.disabledObj['customer_information' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "customer_information") {
			                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
			                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								  break;
								} else {
								  _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								}
							  }
							}
						  }
						}
					}
				});
			},
					get_user_customer_information(id){
				var obj = this.list_user_customer_information.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
			
	
			
	
			
	
										set_total_price_of_dishes(){
				this.form.total_price_of_dishes = parseFloat(this.form.price_of_dishes) * parseFloat(this.form.order_quantity)
			},
							
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
												// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
											
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
										        if (this.form["order_date"].indexOf("-")===-1){
          this.form["order_date"] = this.$toTime(parseInt(this.form["order_date"]),"yyyy-MM-dd")
        }
																									$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


														        if(this.form["order_date"]=="0000-00-00"){
          this.form["order_date"] = null;
        }
				if(parseInt(this.form["order_date"]) > 9999){
					this.form["order_date"] = this.$toTime(parseInt(this.form["order_date"]),"yyyy-MM-dd")
				}
																																


			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																																																			return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/online_orders/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/online_orders/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/online_orders/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/online_orders/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/online_orders/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
															this.get_list_user_customer_information();
					this.get_group_user_customer_information();
																							},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
