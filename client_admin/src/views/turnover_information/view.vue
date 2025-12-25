<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','title_name') || $check_field('add','title_name') || $check_field('set','title_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="标题名称" prop="title_name">
												<el-input id="title_name" v-model="form['title_name']" placeholder="请输入标题名称"
							  v-if="user_group === '管理员' || (form['turnover_information_id'] && $check_field('set','title_name')) || (!form['turnover_information_id'] && $check_field('add','title_name'))" :disabled="disabledObj['title_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','title_name')">{{form['title_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','business_date') || $check_field('add','business_date') || $check_field('set','business_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="营业日期" prop="business_date">
								<el-date-picker :disabled="disabledObj['business_date_isDisabled']" v-if="user_group === '管理员' || (form['turnover_information_id'] && $check_field('set','business_date')) || (!form['turnover_information_id'] && $check_field('add','business_date'))" id="business_date"
						v-model="form['business_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','business_date')">{{form['business_date']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','business_amount') || $check_field('add','business_amount') || $check_field('set','business_amount')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="营业金额" prop="business_amount">
								<el-input-number id="business_amount" v-model.number="form['business_amount']"
						v-if="user_group === '管理员' || (form['turnover_information_id'] && $check_field('set','business_amount')) || (!form['turnover_information_id'] && $check_field('add','business_amount'))" :disabled="disabledObj['business_amount_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','business_amount')">{{form['business_amount']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','remarks') || $check_field('add','remarks') || $check_field('set','remarks')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="备注信息" prop="remarks">
												<el-input id="remarks" v-model="form['remarks']" placeholder="请输入备注信息"
							  v-if="user_group === '管理员' || (form['turnover_information_id'] && $check_field('set','remarks')) || (!form['turnover_information_id'] && $check_field('add','remarks'))" :disabled="disabledObj['remarks_isDisabled']"></el-input>
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
				field: "turnover_information_id",
				url_add: "~/api/turnover_information/add?",
				url_set: "~/api/turnover_information/set?",
				url_get_obj: "~/api/turnover_information/get_obj?",
				url_upload: "~/api/turnover_information/upload?",

				query: {
					"turnover_information_id": 0,
				},

				form: {
								"title_name":  '', // 标题名称
										"business_date":  '', // 营业日期
										"business_amount":  0, // 营业金额
										"remarks":  '', // 备注信息
											"turnover_information_id": 0, // ID
						
				},
				disabledObj:{
								"title_name_isDisabled": false,
										"business_date_isDisabled": false,
					          			"business_amount_isDisabled": false,
										"remarks_isDisabled": false,
										},

	
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
		
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
				        if (this.form["business_date"].indexOf("-")===-1){
          this.form["business_date"] = this.$toTime(parseInt(this.form["business_date"]),"yyyy-MM-dd")
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


					        if(this.form["business_date"]=="0000-00-00"){
          this.form["business_date"] = null;
        }
				if(parseInt(this.form["business_date"]) > 9999){
					this.form["business_date"] = this.$toTime(parseInt(this.form["business_date"]),"yyyy-MM-dd")
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
					bl = this.$check_action('/turnover_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/turnover_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/turnover_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/turnover_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/turnover_information/view','get');
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
