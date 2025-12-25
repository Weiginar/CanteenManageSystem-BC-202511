<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','order_number') || $check_field('add','order_number') || $check_field('set','order_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单编号" prop="order_number">
												<el-input id="order_number" v-model="form['order_number']" placeholder="请输入订单编号"
							  v-if="user_group === '管理员' || (form['offline_orders_id'] && $check_field('set','order_number')) || (!form['offline_orders_id'] && $check_field('add','order_number'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','order_number')">{{form['order_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','dish_name') || $check_field('add','dish_name') || $check_field('set','dish_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="菜品名称" prop="dish_name">
												<el-input id="dish_name" v-model="form['dish_name']" placeholder="请输入菜品名称"
							  v-if="user_group === '管理员' || (form['offline_orders_id'] && $check_field('set','dish_name')) || (!form['offline_orders_id'] && $check_field('add','dish_name'))" :disabled="disabledObj['dish_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','dish_name')">{{form['dish_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','categorization_of_dishes') || $check_field('add','categorization_of_dishes') || $check_field('set','categorization_of_dishes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="菜品分类" prop="categorization_of_dishes">
												<el-input id="categorization_of_dishes" v-model="form['categorization_of_dishes']" placeholder="请输入菜品分类"
							  v-if="user_group === '管理员' || (form['offline_orders_id'] && $check_field('set','categorization_of_dishes')) || (!form['offline_orders_id'] && $check_field('add','categorization_of_dishes'))" :disabled="disabledObj['categorization_of_dishes_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','categorization_of_dishes')">{{form['categorization_of_dishes']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','price_of_dishes') || $check_field('add','price_of_dishes') || $check_field('set','price_of_dishes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="菜品价格" prop="price_of_dishes">
												<el-input id="price_of_dishes" v-model="form['price_of_dishes']" placeholder="请输入菜品价格"
							  v-if="user_group === '管理员' || (form['offline_orders_id'] && $check_field('set','price_of_dishes')) || (!form['offline_orders_id'] && $check_field('add','price_of_dishes'))" :disabled="disabledObj['price_of_dishes_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','price_of_dishes')">{{form['price_of_dishes']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_date') || $check_field('add','order_date') || $check_field('set','order_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单日期" prop="order_date">
								<el-date-picker :disabled="disabledObj['order_date_isDisabled']" v-if="user_group === '管理员' || (form['offline_orders_id'] && $check_field('set','order_date')) || (!form['offline_orders_id'] && $check_field('add','order_date'))" id="order_date"
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
							<!--v-if="user_group === '管理员' || (form['offline_orders_id'] && $check_field('set','customer_information')) || (!form['offline_orders_id'] && $check_field('add','customer_information'))" :disabled="disabledObj['customer_information_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','customer_information')">{{form['customer_information']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['offline_orders_id'] && $check_field('set','customer_information')) || (!form['offline_orders_id'] && $check_field('add','customer_information'))" id="customer_information" v-model="form['customer_information']" :disabled="disabledObj['customer_information_isDisabled']">
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
							  v-if="user_group === '管理员' || (form['offline_orders_id'] && $check_field('set','customer_name')) || (!form['offline_orders_id'] && $check_field('add','customer_name'))" :disabled="disabledObj['customer_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','customer_name')">{{form['customer_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','customer_gender') || $check_field('add','customer_gender') || $check_field('set','customer_gender')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="顾客性别" prop="customer_gender">
												<el-input id="customer_gender" v-model="form['customer_gender']" placeholder="请输入顾客性别"
							  v-if="user_group === '管理员' || (form['offline_orders_id'] && $check_field('set','customer_gender')) || (!form['offline_orders_id'] && $check_field('add','customer_gender'))" :disabled="disabledObj['customer_gender_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','customer_gender')">{{form['customer_gender']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','contact_number') || $check_field('add','contact_number') || $check_field('set','contact_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="联系电话" prop="contact_number">
												<el-input id="contact_number" v-model="form['contact_number']" placeholder="请输入联系电话"
							  v-if="user_group === '管理员' || (form['offline_orders_id'] && $check_field('set','contact_number')) || (!form['offline_orders_id'] && $check_field('add','contact_number'))" :disabled="disabledObj['contact_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','contact_number')">{{form['contact_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_quantity') || $check_field('add','order_quantity') || $check_field('set','order_quantity')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="点餐数量" prop="order_quantity">
								<el-input-number id="order_quantity" v-model.number="form['order_quantity']"
						v-if="user_group === '管理员' || (form['offline_orders_id'] && $check_field('set','order_quantity')) || (!form['offline_orders_id'] && $check_field('add','order_quantity'))" :disabled="disabledObj['order_quantity_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','order_quantity')">{{form['order_quantity']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','total_price_of_dishes') || $check_field('add','total_price_of_dishes') || $check_field('set','total_price_of_dishes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="菜品总价" prop="total_price_of_dishes">
												<el-input id="total_price_of_dishes" v-model="form['total_price_of_dishes']" placeholder="请输入菜品总价"
							  v-if="user_group === '管理员' || (form['offline_orders_id'] && $check_field('set','total_price_of_dishes')) || (!form['offline_orders_id'] && $check_field('add','total_price_of_dishes'))"  @focus="set_total_price_of_dishes()" :disabled="disabledObj['total_price_of_dishes_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','total_price_of_dishes')">{{form['total_price_of_dishes']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_notes') || $check_field('add','order_notes') || $check_field('set','order_notes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="点餐备注" prop="order_notes">
								<el-input type="textarea" id="order_notes" v-model="form['order_notes']" placeholder="请输入点餐备注"
						v-if="user_group === '管理员' || (form['offline_orders_id'] && $check_field('set','order_notes')) || (!form['offline_orders_id'] && $check_field('add','order_notes'))" :disabled="disabledObj['order_notes_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','order_notes')">{{form['order_notes']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_status') || $check_field('add','order_status') || $check_field('set','order_status')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单状态" prop="order_status">
								<el-select id="order_status" v-model="form['order_status']"
						v-if="user_group === '管理员' || (form['offline_orders_id'] && $check_field('set','order_status')) || (!form['offline_orders_id'] && $check_field('add','order_status'))">
						<el-option v-for="o in list_order_status" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','order_status')">{{form['order_status']}}</div>
							</el-form-item>
			</el-col>
					
	
	
	
				<el-col :xs="24" :sm="24" :lg="24" class="el_form_item_warp">
				<el-form-item label="选座" prop="seat">
				  <div class="seat-wrapper">
					<div class="illustration">
					  <div class="illustration-img-wrapper unselected-seat"></div>
					  <span class="illustration-text">可选</span>
					  <div class="illustration-img-wrapper selected-seat"></div>
					  <span class="illustration-text">已选</span>
					  <div class="illustration-img-wrapper bought-seat"></div>
					  <span class="illustration-text">不可选</span>
					  <div class="btn-buy" @click="buySeat">选定座位</div>
					</div>
					<div class="inner-seat-wrapper" ref="innerSeatWrapper">
					  <div v-for="row in seatRow">
						<!--这里的v-if很重要，如果没有则会导致报错，因为seatArray初始状态为空-->
						<div
						  v-for="col in seatCol"
						  v-if="seatArray.length > 0"
						  class="seat"
						  :style="{ width: seatSize + 'px', height: seatSize + 'px' }"
						>
						  <div
							class="inner-seat"
							@click="handleChooseSeat(row - 1, col - 1)"
							v-if="seatArray[row - 1][col - 1] !== -1"
							:class="
							  seatArray[row - 1][col - 1] === 2
								? 'bought-seat'
								: seatArray[row - 1][col - 1] === 1
								? 'selected-seat'
								: 'unselected-seat'
							"
						  ></div>
						</div>
					  </div>
					</div>
				  </div>
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
				field: "offline_orders_id",
				url_add: "~/api/offline_orders/add?",
				url_set: "~/api/offline_orders/set?",
				url_get_obj: "~/api/offline_orders/get_obj?",
				url_upload: "~/api/offline_orders/upload?",

				query: {
					"offline_orders_id": 0,
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
										"order_status":  '', // 订单状态
											"offline_orders_id": 0, // ID
								"seat": "", // 座位
				
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
										"order_status_isDisabled": false,
										},

	
		
		
		
		
		
					// 用户列表
				list_user_customer_information: [],
						// 用户组
				group_user_customer_information: "",
				
		
		
		
		
		
						// 订单状态选项列表
				list_order_status: ['配餐中','已完成'],
	
	
				//影院座位的二维数组,-1为非座位，0为未购座位，1为已选座位(绿色),2为已购座位(红色)
				seatArray: [],
				//影院座位行数
				seatRow: 5,
				//影院座位列数
				seatCol: 8,
				//座位尺寸
				seatSize: "",
				seatArr: [],
				list_: [],
				seatList: "",
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
																										


				this.get_list();
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
					bl = this.$check_action('/offline_orders/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/offline_orders/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/offline_orders/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/offline_orders/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/offline_orders/view','get');
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
			// 选座
			//选定且购买座位
			buySeat: function () {
			  //遍历seatArray，将值为1的座位变为2
			  let oldArray = this.seatArray.slice();
			  for (let i = 0; i < this.seatRow; i++) {
				for (let j = 0; j < this.seatCol; j++) {
				  if (oldArray[i][j] === 1) {
					oldArray[i][j] = 2;
				  }
				}
			  }
			  this.seatArray = oldArray;
			  let string = "";
			  for (let x = 0; x < oldArray.length; x++) {
				let array = oldArray[x];
				for (let j = 0; j < array.length; j++) {
				  if (oldArray[x][j] === 2) {
					if (string == "") {
					  string = "" + (x * 8 + j);
					} else {
					  string = string + "," + (x * 8 + j);
					}
				  }
				}
			  }
			  // 对比判断哪些是新增的座位
			  let seat = this.form.seat;
			  let seatB = "";
			  if (string != "" && string != null) {
				let stringList = string.split(",");
				let seatList = this.seatList;
				if (seatList.length != 0) {
				  let seatListArr = seatList.split(",");
				  for (let v = 0; v < stringList.length; v++) {
					if (
					  seatListArr.indexOf(stringList[v]) == -1 &&
					  seat.indexOf(stringList[v]) == -1
					) {
					  if (seat == "" || seat == null) {
						seat = stringList[v] + "";
						seatB = seat;
					  } else {
						if (seat.indexOf(stringList[v]) == -1) {
						  seat = seat + "," + stringList[v];
						  if (seatB == "" || seatB == null) {
							seatB = stringList[v];
						  } else {
							seatB = seatB + "," + stringList[v];
						  }
						}
					  }
					}
				  }
				} else {
				  seat = string;
				}
			  }

			  if (this.form.seat == "") {
				this.form.seat = seat;
			  } else {
				if (seatB != "") {
				  this.form.seat = this.form.seat + "," + seatB;
				}
			  }
			  this.seatList = string;
			},
			//处理座位选择逻辑
			handleChooseSeat: function (row, col) {
			  let seatValue = this.seatArray[row][col];
			  let newArray = this.seatArray;
			  //如果是已购座位，直接返回
			  if (seatValue === 2) return;
			  //如果是已选座位点击后变未选
			  if (seatValue === 1) {
				newArray[row][col] = 0;
			  } else if (seatValue === 0) {
				newArray[row][col] = 1;
			  }
			  //必须整体更新二维数组，Vue无法检测到数组某一项更新,必须slice复制一个数组才行
			  this.seatArray = newArray.slice();
			},
			/**
			 * 获取所有座位
			 */
			async get_list() {
			  var json = await this.$get("~/api/offline_orders/get_list"
							  );
			  if (json.result && json.result.list) {
				this.list_ = json.result.list;
			  } else if (json.error) {
				console.error(json.error);
			  }
			  console.log(json);
			  let list = json.result.list;
			  if (list != null && list.length != 0) {
				let seatArr = "";
				for (let j = 0; j < list.length; j++) {
				  let seat = list[j].seat;
				  if (seat != null && seat != "") {
					if (seatArr == "") {
					  seatArr = seat + "";
					} else {
					  seatArr = seatArr + "," + seat;
					}
				  }
				}
				this.seatList = seatArr;
			  }
			  this.initSeatArray(5, 8);
			},

			//初始座位数组
			initSeatArray: function () {
			  let seatList = this.seatList;
			  let seatArr = seatList.split(",");
			  if (seatList == "" || seatList == null) {
				seatArr = [];
			  }
			  this.seatArr = seatArr;

			  let seatArray = Array(this.seatRow)
				.fill(0)
				.map(() => Array(this.seatCol).fill(0));
			  this.seatArray = seatArray;
			  for (let j = 0; j < seatArr.length; j++) {
				let i = Math.floor(seatArr[j] / 8);
				let x = seatArr[j] % 8;
				seatArray[i][x] = 2;
			  }
			  this.seatSize = this.$refs.innerSeatWrapper
				? parseInt(
					parseInt(
					  window.getComputedStyle(this.$refs.innerSeatWrapper).width,
					  10
					) / this.seatCol,
					10
				  )
				: 0;
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

	.seat-wrapper {
	height: 370px;
	width: 500px;
	border: 1px dotted #c5c5c5;
	/* margin: 0 auto; */
	position: relative;
	overflow: hidden;
	}

	.inner-seat-wrapper {
	position: absolute;
	bottom: 0;
	width: 100%;
	box-sizing: border-box;
	}
	.seat {
	float: left;
	display: flex;
	justify-content: center;
	align-items: center;
	}
	.inner-seat {
	width: 80%;
	height: 80%;
	cursor: pointer;
	}

	.btn-wrapper {
	margin: 20px auto;
	width: 1000px;
	height: 30px;
	text-align: center;
	}

	.btn-buy {
	height: 100%;
	line-height: 35px;
	font-size: 15px;
	border-radius: 5px;
	padding: 0 5px;
	background-color: #ffa349;
	color: #ffffff;
	display: inline-block;
	cursor: pointer;
	margin: 5px;
	}

	.illustration {
	position: absolute;
	left: 10px;
	top: 20px;
	height: 35px;
	width: 300px;
	}

	.illustration-img-wrapper {
	width: 25px;
	height: 25px;
	position: relative;
	top: 50%;
	display: inline-block;
	transform: translateY(-50%);
	margin-left: 10px;
	}

	.illustration-text {
	display: inline-block;
	height: 100%;
	line-height: 35px;
	font-size: 14px;
	position: relative;
	top: -2px;
	}



    .selected-seat {
	background: url("/img/selected1.png") center center no-repeat;
	background-size: 100% 100%;
	}

	.unselected-seat {
	background: url("/img/unselected1.png") center center no-repeat;
	background-size: 100% 100%;
	}

	.bought-seat {
	background: url("/img/bought1.png") center center no-repeat;
	background-size: 100% 100%;
	}
</style>
