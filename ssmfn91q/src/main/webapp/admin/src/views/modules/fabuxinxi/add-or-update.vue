<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row>
                        <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'" label="信息编号" prop="xinxibianhao">
            <el-input v-model="ruleForm.xinxibianhao" 
                placeholder="信息编号" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.xinxibianhao" label="信息编号" prop="xinxibianhao">
              <el-input v-model="ruleForm.xinxibianhao" 
                placeholder="信息编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="信息名称" prop="xinximingcheng">
          <el-input v-model="ruleForm.xinximingcheng" 
              placeholder="信息名称" clearable  :readonly="ro.xinximingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="信息名称" prop="xinximingcheng">
              <el-input v-model="ruleForm.xinximingcheng" 
                placeholder="信息名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="类型" prop="leixing">
          <el-select v-model="ruleForm.leixing" placeholder="请选择类型">
            <el-option
                v-for="(item,index) in leixingOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="类型" prop="leixing">
	      <el-input v-model="ruleForm.leixing"
                placeholder="类型" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                                                                                <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info' && !ro.xinxitupian" label="信息图片" prop="xinxitupian">
          <file-upload
          tip="点击上传信息图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.xinxitupian?ruleForm.xinxitupian:''"
          @change="xinxitupianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xinxitupian" label="信息图片" prop="xinxitupian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.xinxitupian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="卖家账号" prop="maijiazhanghao">
          <el-input v-model="ruleForm.maijiazhanghao" 
              placeholder="卖家账号" clearable  :readonly="ro.maijiazhanghao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="卖家账号" prop="maijiazhanghao">
              <el-input v-model="ruleForm.maijiazhanghao" 
                placeholder="卖家账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="卖家姓名" prop="maijiaxingming">
          <el-input v-model="ruleForm.maijiaxingming" 
              placeholder="卖家姓名" clearable  :readonly="ro.maijiaxingming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="卖家姓名" prop="maijiaxingming">
              <el-input v-model="ruleForm.maijiaxingming" 
                placeholder="卖家姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua" 
              placeholder="联系电话" clearable  :readonly="ro.lianxidianhua"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="联系电话" prop="lianxidianhua">
              <el-input v-model="ruleForm.lianxidianhua" 
                placeholder="联系电话" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="卖家地址" prop="maijiadizhi">
          <el-input v-model="ruleForm.maijiadizhi" 
              placeholder="卖家地址" clearable  :readonly="ro.maijiadizhi"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="卖家地址" prop="maijiadizhi">
              <el-input v-model="ruleForm.maijiadizhi" 
                placeholder="卖家地址" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                                            </el-row>
                                                                  <el-row>
            <el-col :span="24">
              <el-form-item class="textarea" v-if="type!='info'" label="简介" prop="jianjie">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="简介"
                  v-model="ruleForm.jianjie" >
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.jianjie" label="简介" prop="jianjie">
                    <span>{{ruleForm.jianjie}}</span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
                                                                                                                                                                                                <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="信息内容" prop="xinxineirong">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.xinxineirong" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.xinxineirong" label="信息内容" prop="xinxineirong">
                    <span v-html="ruleForm.xinxineirong"></span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
                                                                                                        <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    
    
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
	  addEditForm: {"btnSaveFontColor":"rgba(34, 32, 32, 1)","selectFontSize":"14px","btnCancelBorderColor":"#DCDFE6","inputBorderRadius":"16px","inputFontSize":"14px","textareaBgColor":"rgba(207, 199, 199, 0.13)","btnSaveFontSize":"14px","textareaBorderRadius":"16px","uploadBgColor":"rgba(207, 199, 199, 0.13)","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"rgba(207, 199, 199, 0.13)","btnSaveBorderRadius":"16px","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"#606266","addEditBoxColor":"rgba(238, 221, 221, 0.32)","dateIconFontSize":"14px","btnSaveBgColor":"#409EFF","uploadIconFontColor":"#8c939d","textareaBorderColor":"#DCDFE6","btnCancelBgColor":"rgba(84, 244, 185, 1)","selectLableColor":"#606266","btnSaveBorderStyle":"solid","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"16px","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"#C0C4CC","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"rgba(23, 23, 24, 1)","dateBorderColor":"#DCDFE6","dateIconFontColor":"#C0C4CC","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"#606266","dateFontSize":"14px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"rgba(25, 26, 27, 1)","uploadHeight":"148px","textareaLableColor":"#606266","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"16px","inputBgColor":"rgba(207, 199, 199, 0.13)","inputLableFontSize":"14px","uploadLableColor":"#606266","uploadBorderRadius":"16px","btnSaveHeight":"44px","selectBgColor":"rgba(207, 199, 199, 0.13)","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"40px","selectBorderColor":"#DCDFE6","inputBorderColor":"#DCDFE6","uploadBorderColor":"#DCDFE6","textareaFontColor":"rgba(25, 26, 27, 1)","selectBorderWidth":"1px","dateFontColor":"rgba(255, 69, 0, 0.66)","btnCancelBorderWidth":"1px","uploadBorderWidth":"1px","textareaFontSize":"14px","selectBorderRadius":"16px","selectFontColor":"rgba(25, 26, 27, 1)","btnSaveBorderColor":"#409EFF","btnSaveBorderWidth":"1px"},
      id: '',
      type: '',
      ro:{
	xinxibianhao : false,
	xinximingcheng : false,
	leixing : false,
	jianjie : false,
	xinxineirong : false,
	xinxitupian : false,
	maijiazhanghao : false,
	maijiaxingming : false,
	lianxidianhua : false,
	maijiadizhi : false,
	userid : false,
      },
            ruleForm: {
                        xinxibianhao: this.getUUID(),
                        	        xinximingcheng: '',
	                        	        leixing: '',
	                        	        jianjie: '',
	                        	        xinxineirong: '',
	                        	        xinxitupian: '',
	                        	        maijiazhanghao: '',
	                        	        maijiaxingming: '',
	                        	        lianxidianhua: '',
	                        	        maijiadizhi: '',
	                        	        userid: '',
	                      },
                                                    leixingOptions: [],
                                                                                                                                    rules: {
                  xinxibianhao: [
                            { required: true, message: '信息编号不能为空', trigger: 'blur' },
                                    	                                                              ],
                  xinximingcheng: [
                            { required: true, message: '信息名称不能为空', trigger: 'blur' },
                                    	                                                              ],
                  leixing: [
                            { required: true, message: '类型不能为空', trigger: 'blur' },
                                    	                                                              ],
                  jianjie: [
                                    	                                                              ],
                  xinxineirong: [
                                    	                                                              ],
                  xinxitupian: [
                                    	                                                              ],
                  maijiazhanghao: [
                                    	                                                              ],
                  maijiaxingming: [
                                    	                                                              ],
                  lianxidianhua: [
                                    	                                                              ],
                  maijiadizhi: [
                                    	                                                              ],
                  userid: [
                            { required: true, message: '用户id不能为空', trigger: 'blur' },
                                    	                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                                                                                          },
  created() {
	this.addEditStyleChange()
	this.addEditUploadStyleChange()
  },
  methods: {
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          	            if(o=='xinxibianhao'){
            this.ruleForm.xinxibianhao = obj[o];
	    this.ro.xinxibianhao = true;
            continue;
          }
	            	            if(o=='xinximingcheng'){
            this.ruleForm.xinximingcheng = obj[o];
	    this.ro.xinximingcheng = true;
            continue;
          }
	            	            if(o=='leixing'){
            this.ruleForm.leixing = obj[o];
	    this.ro.leixing = true;
            continue;
          }
	            	            if(o=='jianjie'){
            this.ruleForm.jianjie = obj[o];
	    this.ro.jianjie = true;
            continue;
          }
	            	            if(o=='xinxineirong'){
            this.ruleForm.xinxineirong = obj[o];
	    this.ro.xinxineirong = true;
            continue;
          }
	            	            if(o=='xinxitupian'){
            this.ruleForm.xinxitupian = obj[o];
	    this.ro.xinxitupian = true;
            continue;
          }
	            	            if(o=='maijiazhanghao'){
            this.ruleForm.maijiazhanghao = obj[o];
	    this.ro.maijiazhanghao = true;
            continue;
          }
	            	            if(o=='maijiaxingming'){
            this.ruleForm.maijiaxingming = obj[o];
	    this.ro.maijiaxingming = true;
            continue;
          }
	            	            if(o=='lianxidianhua'){
            this.ruleForm.lianxidianhua = obj[o];
	    this.ro.lianxidianhua = true;
            continue;
          }
	            	            if(o=='maijiadizhi'){
            this.ruleForm.maijiadizhi = obj[o];
	    this.ro.maijiadizhi = true;
            continue;
          }
	            	            if(o=='userid'){
            this.ruleForm.userid = obj[o];
	    this.ro.userid = true;
            continue;
          }
	                    }
                                                                                                                                                                                              }
            // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
                                                                                                                                                          		if(json.maijiazhanghao!=''&&json.maijiazhanghao){
              		this.ruleForm.maijiazhanghao = json.maijiazhanghao
		}
                                  		if(json.maijiaxingming!=''&&json.maijiaxingming){
              		this.ruleForm.maijiaxingming = json.maijiaxingming
		}
                                  		if(json.lianxidianhua!=''&&json.lianxidianhua){
              		this.ruleForm.lianxidianhua = json.lianxidianhua
		}
                                  		if(json.maijiadizhi!=''&&json.maijiadizhi){
              		this.ruleForm.maijiadizhi = json.maijiadizhi
		}
                                                    } else {
          this.$message.error(data.msg);
        }
      });
                                                                              this.$http({
              url: `option/leixing/leixingmingcheng`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.leixingOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
         
                                                                                                                                                                            },
                                                                                                // 多级联动参数
                                                                                                                          info(id) {
      this.$http({
        url: `fabuxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
	//解决前台上传图片后台不显示的问题
	let reg=new RegExp('../../../upload','g')//g代表全部
	this.ruleForm.xinxineirong = this.ruleForm.xinxineirong.replace(reg,'../../../ssmfn91q/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },
        // 提交
    onSubmit() {
                  // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                                                                                                                                          this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `fabuxinxi/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.fabuxinxiCrossAddOrUpdateFlag = false;
                  this.parent.search();
                  this.parent.contentStyleChange();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.fabuxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
                                                                                    xinxitupianUploadChange(fileUrls) {
                this.ruleForm.xinxitupian = fileUrls;
				this.addEditUploadStyleChange()
            },
                                                                        	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}
</style>
