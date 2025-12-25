<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','dish_name') || $check_field('add','dish_name') || $check_field('set','dish_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="菜品名称" prop="dish_name">
												<el-input id="dish_name" v-model="form['dish_name']" placeholder="请输入菜品名称"
							  v-if="user_group === '管理员' || (form['dish_information_id'] && $check_field('set','dish_name')) || (!form['dish_information_id'] && $check_field('add','dish_name'))" :disabled="disabledObj['dish_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','dish_name')">{{form['dish_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','categorization_of_dishes') || $check_field('add','categorization_of_dishes') || $check_field('set','categorization_of_dishes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="菜品分类" prop="categorization_of_dishes">
								<el-select id="categorization_of_dishes" v-model="form['categorization_of_dishes']"
						v-if="user_group === '管理员' || (form['dish_information_id'] && $check_field('set','categorization_of_dishes')) || (!form['dish_information_id'] && $check_field('add','categorization_of_dishes'))">
						<el-option v-for="o in list_categorization_of_dishes" :key="o['categorization_of_dishes']" :label="o['categorization_of_dishes']"
							:value="o['categorization_of_dishes']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','categorization_of_dishes')">{{form['categorization_of_dishes']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','price_of_dishes') || $check_field('add','price_of_dishes') || $check_field('set','price_of_dishes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="菜品价格" prop="price_of_dishes">
								<el-input-number id="price_of_dishes" v-model.number="form['price_of_dishes']"
						v-if="user_group === '管理员' || (form['dish_information_id'] && $check_field('set','price_of_dishes')) || (!form['dish_information_id'] && $check_field('add','price_of_dishes'))" :disabled="disabledObj['price_of_dishes_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','price_of_dishes')">{{form['price_of_dishes']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','dishes_and_ingredients') || $check_field('add','dishes_and_ingredients') || $check_field('set','dishes_and_ingredients')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="菜品食材" prop="dishes_and_ingredients">
												<el-input id="dishes_and_ingredients" v-model="form['dishes_and_ingredients']" placeholder="请输入菜品食材"
							  v-if="user_group === '管理员' || (form['dish_information_id'] && $check_field('set','dishes_and_ingredients')) || (!form['dish_information_id'] && $check_field('add','dishes_and_ingredients'))" :disabled="disabledObj['dishes_and_ingredients_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','dishes_and_ingredients')">{{form['dishes_and_ingredients']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','taste_of_dishes') || $check_field('add','taste_of_dishes') || $check_field('set','taste_of_dishes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="菜品口味" prop="taste_of_dishes">
												<el-input id="taste_of_dishes" v-model="form['taste_of_dishes']" placeholder="请输入菜品口味"
							  v-if="user_group === '管理员' || (form['dish_information_id'] && $check_field('set','taste_of_dishes')) || (!form['dish_information_id'] && $check_field('add','taste_of_dishes'))" :disabled="disabledObj['taste_of_dishes_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','taste_of_dishes')">{{form['taste_of_dishes']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','picture_of_dishes') || $check_field('add','picture_of_dishes') || $check_field('set','picture_of_dishes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="菜品图片" prop="picture_of_dishes">
								<el-upload :disabled="disabledObj['picture_of_dishes_isDisabled']" id="picture_of_dishes" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_picture_of_dishes"
						:show-file-list="false" v-if="user_group === '管理员' || (form['dish_information_id'] && $check_field('set','picture_of_dishes')) || (!form['dish_information_id'] && $check_field('add','picture_of_dishes'))">
						<img v-if="form['picture_of_dishes']" :src="$fullUrl(form['picture_of_dishes'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','picture_of_dishes')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['picture_of_dishes'])" :preview-src-list="[$fullUrl(form['picture_of_dishes'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','introduction_to_dishes') || $check_field('add','introduction_to_dishes') || $check_field('set','introduction_to_dishes')" :xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="菜品介绍" prop="introduction_to_dishes">
					<quill-editor v-model.number="form['introduction_to_dishes']"
						v-if="user_group === '管理员' || (form['dish_information_id'] && $check_field('set','introduction_to_dishes')) || (!form['dish_information_id'] && $check_field('add','introduction_to_dishes')) ">
					</quill-editor>
					<div v-else-if="$check_field('get','introduction_to_dishes')" v-html="form['introduction_to_dishes']"></div>
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
				field: "dish_information_id",
				url_add: "~/api/dish_information/add?",
				url_set: "~/api/dish_information/set?",
				url_get_obj: "~/api/dish_information/get_obj?",
				url_upload: "~/api/dish_information/upload?",

				query: {
					"dish_information_id": 0,
				},

				form: {
								"dish_name":  '', // 菜品名称
										"categorization_of_dishes":  '', // 菜品分类
										"price_of_dishes":  0, // 菜品价格
										"dishes_and_ingredients":  '', // 菜品食材
										"taste_of_dishes":  '', // 菜品口味
										"picture_of_dishes":  '', // 菜品图片
										"introduction_to_dishes":  '', // 菜品介绍
											"dish_information_id": 0, // ID
						
				},
				disabledObj:{
								"dish_name_isDisabled": false,
										"categorization_of_dishes_isDisabled": false,
					          			"price_of_dishes_isDisabled": false,
										"dishes_and_ingredients_isDisabled": false,
										"taste_of_dishes_isDisabled": false,
										"picture_of_dishes_isDisabled": false,
										"introduction_to_dishes_isDisabled": false,
										},

	
						// 菜品分类选项列表
				list_categorization_of_dishes: [""],
	
		
		
		
		
		
	
			}
		},
		methods: {


	
	
			
				/**
			 * 获取菜品分类列表
			 */
			async get_list_categorization_of_dishes() {
				var json = await this.$get("~/api/classification_management/get_list?");
				if(json.result && json.result.list){
					this.list_categorization_of_dishes = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
			
	
			
	
			
	
						/**
			 * 上传菜品图片
			 * @param {Object} param 图片参数
			 */
			upload_picture_of_dishes(param){
						this.uploadFile(param.file, "picture_of_dishes");
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
					bl = this.$check_action('/dish_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/dish_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/dish_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/dish_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/dish_information/view','get');
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
						this.get_list_categorization_of_dishes();
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
