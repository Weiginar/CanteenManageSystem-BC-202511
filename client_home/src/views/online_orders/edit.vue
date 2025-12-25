<template>
	<div class="diy_edit page_online_orders" id="online_orders_edit">
		<div class='warp'>
			<div class='container'>
				<div class='row diy_edit_content_box'>
						<div v-if="$check_field('set','order_number') || $check_field('add','order_number') || $check_field('get','order_number')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								订单编号:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_order_number" v-model="form['order_number']" placeholder="请输入订单编号" v-if="(form['order_number'] && $check_field('set','order_number')) || (!form['order_number'] && $check_field('add','order_number'))" :disabled="true"/>
							<span v-else-if="$check_field('get','order_number')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','dish_name') || $check_field('add','dish_name') || $check_field('get','dish_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								菜品名称:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_dish_name" v-model="form['dish_name']" placeholder="请输入菜品名称" v-if="(form['dish_name'] && $check_field('set','dish_name')) || (!form['dish_name'] && $check_field('add','dish_name'))"  :disabled="disabledObj['dish_name_isDisabled']"/>
							<span v-else-if="$check_field('get','dish_name')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','categorization_of_dishes') || $check_field('add','categorization_of_dishes') || $check_field('get','categorization_of_dishes')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								菜品分类:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_categorization_of_dishes" v-model="form['categorization_of_dishes']" placeholder="请输入菜品分类" v-if="(form['categorization_of_dishes'] && $check_field('set','categorization_of_dishes')) || (!form['categorization_of_dishes'] && $check_field('add','categorization_of_dishes'))"  :disabled="disabledObj['categorization_of_dishes_isDisabled']"/>
							<span v-else-if="$check_field('get','categorization_of_dishes')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','price_of_dishes') || $check_field('add','price_of_dishes') || $check_field('get','price_of_dishes')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								菜品价格:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_price_of_dishes" v-model="form['price_of_dishes']" placeholder="请输入菜品价格" v-if="(form['price_of_dishes'] && $check_field('set','price_of_dishes')) || (!form['price_of_dishes'] && $check_field('add','price_of_dishes'))"  :disabled="disabledObj['price_of_dishes_isDisabled']"/>
							<span v-else-if="$check_field('get','price_of_dishes')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','order_date') || $check_field('add','order_date') || $check_field('get','order_date')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								订单日期:
							</span>
						</div>
								<!-- 日期 -->
						<div class="diy_field diy_date">
							<input type="date" :disabled="disabledObj['order_date_isDisabled']" id="form_order_date" v-model="form['order_date']" placeholder="请输入订单日期" v-if="(form['order_date'] && $check_field('set','order_date')) || (!form['order_date'] && $check_field('add','order_date'))" />
							<span v-else-if="$check_field('get','order_date')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','customer_information') || $check_field('add','customer_information') || $check_field('get','customer_information')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								顾客信息:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_customer_information" :disabled="disabledObj['customer_information_isDisabled']" v-model="form['customer_information']" v-if="(form['customer_information'] && $check_field('set','customer_information')) || (!form['customer_information'] && $check_field('add','customer_information'))" >
								<option v-for="o in list_user_customer_information" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','customer_information')">{{ form['customer_information'] }}</span>
						</div>
					</div>
							<div v-if="$check_field('set','customer_name') || $check_field('add','customer_name') || $check_field('get','customer_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								顾客姓名:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_customer_name" v-model="form['customer_name']" placeholder="请输入顾客姓名" v-if="(form['customer_name'] && $check_field('set','customer_name')) || (!form['customer_name'] && $check_field('add','customer_name'))"  :disabled="disabledObj['customer_name_isDisabled']"/>
							<span v-else-if="$check_field('get','customer_name')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','customer_gender') || $check_field('add','customer_gender') || $check_field('get','customer_gender')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								顾客性别:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_customer_gender" v-model="form['customer_gender']" placeholder="请输入顾客性别" v-if="(form['customer_gender'] && $check_field('set','customer_gender')) || (!form['customer_gender'] && $check_field('add','customer_gender'))"  :disabled="disabledObj['customer_gender_isDisabled']"/>
							<span v-else-if="$check_field('get','customer_gender')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','contact_number') || $check_field('add','contact_number') || $check_field('get','contact_number')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								联系电话:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_contact_number" v-model="form['contact_number']" placeholder="请输入联系电话" v-if="(form['contact_number'] && $check_field('set','contact_number')) || (!form['contact_number'] && $check_field('add','contact_number'))"  :disabled="disabledObj['contact_number_isDisabled']"/>
							<span v-else-if="$check_field('get','contact_number')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','order_quantity') || $check_field('add','order_quantity') || $check_field('get','order_quantity')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								点餐数量:
							</span>
						</div>
								<!-- 数字 -->
						<div class="diy_field diy_number">
							<input type="number" id="form_order_quantity" v-model.number="form['order_quantity']" placeholder="请输入点餐数量" v-if="(form['order_quantity'] && $check_field('set','order_quantity')) || (!form['order_quantity'] && $check_field('add','order_quantity'))" :disabled="disabledObj['order_quantity_isDisabled']" />
							<span v-else-if="$check_field('get','order_quantity')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','total_price_of_dishes') || $check_field('add','total_price_of_dishes') || $check_field('get','total_price_of_dishes')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								菜品总价:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_total_price_of_dishes" v-model="form['total_price_of_dishes']" placeholder="请输入菜品总价" v-if="(form['total_price_of_dishes'] && $check_field('set','total_price_of_dishes')) || (!form['total_price_of_dishes'] && $check_field('add','total_price_of_dishes'))"  @focus="set_total_price_of_dishes()" :disabled="disabledObj['total_price_of_dishes_isDisabled']"/>
							<span v-else-if="$check_field('get','total_price_of_dishes')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','order_notes') || $check_field('add','order_notes') || $check_field('get','order_notes')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								点餐备注:
							</span>
						</div>
								<!-- 多文本 -->
						<div class="diy_field diy_desc">
							<textarea id="form_order_notes" v-model="form['order_notes']" v-if="(form['order_notes'] && $check_field('set','order_notes')) || (!form['order_notes'] && $check_field('add','order_notes'))" :disabled="disabledObj['order_notes_isDisabled']" />
							<span v-else-if="$check_field('get','order_notes')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','shipping_address') || $check_field('add','shipping_address') || $check_field('get','shipping_address')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								配送地址:
							</span>
						</div>
								<!-- 多文本 -->
						<div class="diy_field diy_desc">
							<textarea id="form_shipping_address" v-model="form['shipping_address']" v-if="(form['shipping_address'] && $check_field('set','shipping_address')) || (!form['shipping_address'] && $check_field('add','shipping_address'))" :disabled="disabledObj['shipping_address_isDisabled']" />
							<span v-else-if="$check_field('get','shipping_address')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','order_status') || $check_field('add','order_status') || $check_field('get','order_status')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								订单状态:
							</span>
						</div>
								<!-- 选项 -->
						<div class="diy_field diy_down">
							<select id="form_order_status" v-model="form['order_status']" v-if="(form['order_status'] && $check_field('set','order_status')) || (!form['order_status'] && $check_field('add','order_status'))" >
								<option v-for="o in list_order_status" :value="o">
									{{o}}
								</option>
							</select>
							<span v-else-if="$check_field('get','order_status')">{{ form['order_status'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','delivery_description') || $check_field('add','delivery_description') || $check_field('get','delivery_description')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								配送描述:
							</span>
						</div>
								<!-- 多文本 -->
						<div class="diy_field diy_desc">
							<textarea id="form_delivery_description" v-model="form['delivery_description']" v-if="(form['delivery_description'] && $check_field('set','delivery_description')) || (!form['delivery_description'] && $check_field('add','delivery_description'))" :disabled="disabledObj['delivery_description_isDisabled']" />
							<span v-else-if="$check_field('get','delivery_description')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
	




				</div>
				<div class="diy_edit_submit_box row">
					<div class="col-12">
						<div class="btn_box">
							<button class="btn_submit" @click="submit()">提交</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/page.js";
	export default {
		mixins: [mixin],
		components: {},
		data() {
			return {
				url_get_obj: "~/api/online_orders/get_obj?",
				url_add: "~/api/online_orders/add?",
				url_set: "~/api/online_orders/set?",

				// 登录权限
				oauth: {
					"signIn": true,
					"user_group": []
				},

				// 查询条件
				query: {
						"order_number": "",
							"dish_name": "",
							"categorization_of_dishes": "",
							"price_of_dishes": "",
							"order_date": "",
							"customer_information": 0,
							"customer_name": "",
							"customer_gender": "",
							"contact_number": "",
							"order_quantity": 0,
							"total_price_of_dishes": "",
							"order_notes": "",
							"shipping_address": "",
							"order_status": "",
							"delivery_description": "",
						"online_orders_id": 0,
				},

				obj: {
						"order_number": this.$get_stamp(), // 订单编号
							"dish_name":  '', // 菜品名称
							"categorization_of_dishes":  '', // 菜品分类
							"price_of_dishes":  '', // 菜品价格
							"order_date": new Date().getTime(),
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
						"online_orders_id": 0,
				},

				// 表单字段
				form: {
						"order_number": this.$get_stamp(), // 订单编号
							"dish_name":  '', // 菜品名称
							"categorization_of_dishes":  '', // 菜品分类
							"price_of_dishes":  '', // 菜品价格
							"order_date": new Date().getTime(),
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
						"online_orders_id": 0,
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
									"total_price_of_dishes_isDisabled": false,
							"order_notes_isDisabled": false,
							"shipping_address_isDisabled": false,
							"order_status_isDisabled": false,
							"delivery_description_isDisabled": false,
					},

																// 用户列表
				list_user_customer_information: [],
																				// 订单状态选项列表
				list_order_status: ['配餐中','配送中','已完成'],
				
				// ID字段
				field: "online_orders_id",

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
					async get_user_session_customer_information(){
				var _this = this;
				var json = await this.$get("~/api/user_group/get_obj?name=顾客用户");
				if(json.result && json.result.obj){
					var source_table = json.result.obj.source_table;
					var user_id = _this.$store.state.user.user_id;
					if (user_id){
						var url = "~/api/"+source_table+"/get_obj?"
						this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
							if (res.result && res.result.obj) {
								var arr = []
								for (let key in res.result.obj) {
									arr.push(key)
								}
								var arrForm = []
								for (let key in _this.form) {
									arrForm.push(key)
								}
								_this.form["customer_information"] = user_id
								_this.disabledObj['customer_information' + '_isDisabled'] = true
								for (var i=0;i<arr.length;i++){
                  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                    for (var j = 0; j < arrForm.length; j++) {
                      if (arr[i] === arrForm[j]) {
                        if (arr[i] !== "customer_information") {
                          _this.form[arrForm[j]] = res.result.obj[arr[i]]
                          _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                          break;
                        }
                      }
                    }
                  }
								}
							}
						});
					}
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
				
				
				
				
				
									set_total_price_of_dishes(){
				this.form.total_price_of_dishes = parseFloat(this.form.price_of_dishes) * parseFloat(this.form.order_quantity)
        let r = /^\+?[1-9][0-9]*$/; // 正整数
        if(!r.test(this.form.total_price_of_dishes) ){
          this.form.total_price_of_dishes = this.form.total_price_of_dishes.toFixed(2);
        }
			},
									
				
				
				
	
			/**
			 * 修改文件
			 * @param { Object } files 上传文件对象
			 * @param { String } str 表单的属性名
			 */
			change_file(files, str) {
				var form = new FormData();
				form.append("file", files[0]);
				this.$post("~/api/online_orders/upload?", form, (res) => {
					if (res.result) {
						this.form[str] = res.result.url;
					} else if (res.error) {
						this.$toast(res.error.message);
					}
				});
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_before(param){
				var form = $.db.get("form");
				// if (form) {
        //   delete(form.examine_state)
        //   delete(form.examine_reply)
        //   this.obj = $.push(this.obj ,form);
				// 	this.form = $.push(this.form ,form);
				// }
				// var arr = []
				// for (let key in form) {
				// 	arr.push(key)
				// }
				// for (var i=0;i<arr.length;i++){
				// 	this.disabledObj[arr[i] + '_isDisabled'] = true
				// }
        if (form) {
          var arr = []
          for (let key in form) {
            arr.push(key)
          }
          var arrForm = []
          for (let key in this.form) {
            arrForm.push(key)
          }
          for (var i=0;i<arr.length;i++){
            if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
              for (var j = 0; j < arrForm.length; j++) {
                if (arrForm[j] === arr[i]) {
                  this.form[arrForm[j]] = form[arr[i]]
                  this.obj[arrForm[j]] = form[arr[i]]
                  this.disabledObj[arrForm[j] + '_isDisabled'] = true
                  break;
                }
              }
            }
          }
        }
										        if (JSON.stringify(this.form["order_date"]).indexOf("-")===-1) {
          this.form["order_date"] = this.$toTime(parseInt(this.form["order_date"]), "yyyy-MM-dd")
        }
																					
        $.db.del("form");
				return param;
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json ,func){
				// var form = $.db.get("form");
				// var obj = Object.assign({} ,form ,this.obj);
				// if (obj) {
        //   delete(obj.examine_state)
        //   delete(obj.examine_reply)
				// 	this.obj = $.push(this.obj ,obj);
				// }
				// if (form) {
        //   delete(form.examine_state)
        //   delete(form.examine_reply)
				// 	this.form = $.push(this.form ,form);
				// }

				if(func){
					func(json);
				}
			},

		},
		created() {
																				this.get_user_session_customer_information();
					this.get_list_user_customer_information();
																														},
	}
</script>

<style>




</style>
