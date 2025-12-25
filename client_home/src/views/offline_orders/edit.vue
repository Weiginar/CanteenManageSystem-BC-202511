<template>
	<div class="diy_edit page_offline_orders" id="offline_orders_edit">
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
	




					<!-- 座位 -->
					<div class="form-item selected_seat_box col-12 col-md-6">
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
							<div v-for="row in seatRow" :key="row">
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
				url_get_obj: "~/api/offline_orders/get_obj?",
				url_add: "~/api/offline_orders/add?",
				url_set: "~/api/offline_orders/set?",

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
							"order_status": "",
						"offline_orders_id": 0,
					"seat": "", // 座位
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
							"order_status":  '', // 订单状态
						"offline_orders_id": 0,
					"seat": "", // 座位
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
							"order_status":  '', // 订单状态
						"offline_orders_id": 0,
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
									"total_price_of_dishes_isDisabled": false,
							"order_notes_isDisabled": false,
							"order_status_isDisabled": false,
					},

																// 用户列表
				list_user_customer_information: [],
																		// 订单状态选项列表
				list_order_status: ['配餐中','已完成'],
		
				// ID字段
				field: "offline_orders_id",

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
				this.$post("~/api/offline_orders/upload?", form, (res) => {
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
				this.get_list();
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
			  let seat = this.obj.seat;
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
			 * 获取所有坐座位信息
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
																				this.get_user_session_customer_information();
					this.get_list_user_customer_information();
																								},
	}
</script>

<style>


	.seat-wrapper {
	  margin-top: 20px;
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
