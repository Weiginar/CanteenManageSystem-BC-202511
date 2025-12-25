<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','dish_name') || $check_field('add','dish_name') || $check_field('set','dish_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="菜品名称" prop="dish_name">
								<el-select id="dish_name" v-model="form['dish_name']"
						v-if="user_group === '管理员' || (form['dish_preferences_id'] && $check_field('set','dish_name')) || (!form['dish_preferences_id'] && $check_field('add','dish_name'))">
						<el-option v-for="o in list_dish_name" :key="o['dish_name']" :label="o['dish_name']"
							:value="o['dish_name']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','dish_name')">{{form['dish_name']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','number_of_male_orders') || $check_field('add','number_of_male_orders') || $check_field('set','number_of_male_orders')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="男性点餐数" prop="number_of_male_orders">
								<el-input-number id="number_of_male_orders" v-model.number="form['number_of_male_orders']"
						v-if="user_group === '管理员' || (form['dish_preferences_id'] && $check_field('set','number_of_male_orders')) || (!form['dish_preferences_id'] && $check_field('add','number_of_male_orders'))" :disabled="disabledObj['number_of_male_orders_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','number_of_male_orders')">{{form['number_of_male_orders']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','number_of_meals_ordered_by_women') || $check_field('add','number_of_meals_ordered_by_women') || $check_field('set','number_of_meals_ordered_by_women')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="女性点餐数" prop="number_of_meals_ordered_by_women">
								<el-input-number id="number_of_meals_ordered_by_women" v-model.number="form['number_of_meals_ordered_by_women']"
						v-if="user_group === '管理员' || (form['dish_preferences_id'] && $check_field('set','number_of_meals_ordered_by_women')) || (!form['dish_preferences_id'] && $check_field('add','number_of_meals_ordered_by_women'))" :disabled="disabledObj['number_of_meals_ordered_by_women_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','number_of_meals_ordered_by_women')">{{form['number_of_meals_ordered_by_women']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','remarks') || $check_field('add','remarks') || $check_field('set','remarks')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="备注信息" prop="remarks">
								<el-input type="textarea" id="remarks" v-model="form['remarks']" placeholder="请输入备注信息"
						v-if="user_group === '管理员' || (form['dish_preferences_id'] && $check_field('set','remarks')) || (!form['dish_preferences_id'] && $check_field('add','remarks'))" :disabled="disabledObj['remarks_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','remarks')">{{form['remarks']}}</div>
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
				field: "dish_preferences_id",
				url_add: "~/api/dish_preferences/add?",
				url_set: "~/api/dish_preferences/set?",
				url_get_obj: "~/api/dish_preferences/get_obj?",
				url_upload: "~/api/dish_preferences/upload?",

				query: {
					"dish_preferences_id": 0,
				},

				form: {
								"dish_name":  '', // 菜品名称
										"number_of_male_orders":  0, // 男性点餐数
										"number_of_meals_ordered_by_women":  0, // 女性点餐数
										"remarks":  '', // 备注信息
											"dish_preferences_id": 0, // ID
						
				},
				disabledObj:{
								"dish_name_isDisabled": false,
					          			"number_of_male_orders_isDisabled": false,
					          			"number_of_meals_ordered_by_women_isDisabled": false,
										"remarks_isDisabled": false,
										},

					// 菜品名称选项列表
				list_dish_name: [""],
	
		
		
		
	
			}
		},
		methods: {


	
				/**
			 * 获取菜品名称列表
			 */
			async get_list_dish_name() {
				var json = await this.$get("~/api/dish_information/get_list?");
				if(json.result && json.result.list){
					this.list_dish_name = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
														
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
												$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


												


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
					bl = this.$check_action('/dish_preferences/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/dish_preferences/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/dish_preferences/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/dish_preferences/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/dish_preferences/view','get');
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
				this.get_list_dish_name();
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
