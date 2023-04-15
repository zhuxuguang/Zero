<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="创建组织ID" prop="creatingAnOrganizationId">
        <el-input
          v-model="queryParams.creatingAnOrganizationId"
          placeholder="请输入创建组织ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建组织" prop="creatingAnOrganizationName">
        <el-input
          v-model="queryParams.creatingAnOrganizationName"
          placeholder="请输入创建组织"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="使用组织ID" prop="organizationOfUseId">
        <el-input
          v-model="queryParams.organizationOfUseId"
          placeholder="请输入使用组织ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="使用组织名称" prop="organizationOfUseName">
        <el-input
          v-model="queryParams.organizationOfUseName"
          placeholder="请输入使用组织名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物料名称" prop="materialName">
        <el-input
          v-model="queryParams.materialName"
          placeholder="请输入物料名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物料编码" prop="materialCoding">
        <el-input
          v-model="queryParams.materialCoding"
          placeholder="请输入物料编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="规格型号" prop="specifications">-->
<!--        <el-input-->
<!--          v-model="queryParams.specifications"-->
<!--          placeholder="请输入规格型号"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="物料分组" prop="groupingOfMaterials">
        <el-input
          v-model="queryParams.groupingOfMaterials"
          placeholder="请输入物料分组"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="物料分组编码" prop="groupingOfMaterialsCoding">-->
<!--        <el-input-->
<!--          v-model="queryParams.groupingOfMaterialsCoding"-->
<!--          placeholder="请输入物料分组编码"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="数据状态" prop="dataState">-->
<!--        <el-input-->
<!--          v-model="queryParams.dataState"-->
<!--          placeholder="请输入数据状态"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="存货类别" prop="category">-->
<!--        <el-input-->
<!--          v-model="queryParams.category"-->
<!--          placeholder="请输入存货类别"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="物料属性" prop="propertiesOfMaterials">-->
<!--        <el-input-->
<!--          v-model="queryParams.propertiesOfMaterials"-->
<!--          placeholder="请输入物料属性"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="单位" prop="units">-->
<!--        <el-input-->
<!--          v-model="queryParams.units"-->
<!--          placeholder="请输入单位"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="创建者" prop="createBy">-->
<!--        <el-input-->
<!--          v-model="queryParams.createBy"-->
<!--          placeholder="请输入创建者"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="创建时间" prop="createTime">-->
<!--        <el-date-picker clearable-->
<!--          v-model="queryParams.createTime"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="请选择创建时间">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="更新者" prop="updateBy">-->
<!--        <el-input-->
<!--          v-model="queryParams.updateBy"-->
<!--          placeholder="请输入更新者"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="更新时间" prop="updateTime">-->
<!--        <el-date-picker clearable-->
<!--          v-model="queryParams.updateTime"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="请选择更新时间">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="备注" prop="remark">-->
<!--        <el-input-->
<!--          v-model="queryParams.remark"-->
<!--          placeholder="请输入备注"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:cbFileOfMaterials:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:cbFileOfMaterials:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:cbFileOfMaterials:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:cbFileOfMaterials:export']"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['system:cbProductionTarget:import']"
        >导入</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"  :columns="columns"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="cbFileOfMaterialsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="创建组织ID" align="center" prop="creatingAnOrganizationId" />
      <el-table-column label="创建组织" align="center" prop="creatingAnOrganizationName" />
      <el-table-column label="使用组织ID" align="center" prop="organizationOfUseId" />
      <el-table-column label="使用组织名称" align="center" prop="organizationOfUseName" />
      <el-table-column label="物料名称" align="center" prop="materialName" />
      <el-table-column label="物料编码" align="center" prop="materialCoding" />
      <el-table-column label="规格型号" align="center" prop="specifications" />
      <el-table-column label="物料分组" align="center" prop="groupingOfMaterials" />
      <el-table-column label="物料分组编码" align="center" prop="groupingOfMaterialsCoding" />
      <el-table-column label="数据状态" align="center" prop="dataState" />
      <el-table-column label="存货类别" align="center" prop="category" />
      <el-table-column label="物料属性" align="center" prop="propertiesOfMaterials" />
      <el-table-column label="单位" align="center" prop="units" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:cbFileOfMaterials:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:cbFileOfMaterials:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改物料档案对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="创建组织ID" prop="creatingAnOrganizationId">
          <el-input v-model="form.creatingAnOrganizationId" placeholder="请输入创建组织ID" />
        </el-form-item>
        <el-form-item label="创建组织" prop="creatingAnOrganizationName">
          <el-input v-model="form.creatingAnOrganizationName" placeholder="请输入创建组织" />
        </el-form-item>
        <el-form-item label="使用组织ID" prop="organizationOfUseId">
          <el-input v-model="form.organizationOfUseId" placeholder="请输入使用组织ID" />
        </el-form-item>
        <el-form-item label="使用组织名称" prop="organizationOfUseName">
          <el-input v-model="form.organizationOfUseName" placeholder="请输入使用组织名称" />
        </el-form-item>
        <el-form-item label="物料名称" prop="materialName">
          <el-input v-model="form.materialName" placeholder="请输入物料名称" />
        </el-form-item>
        <el-form-item label="物料编码" prop="materialCoding">
          <el-input v-model="form.materialCoding" placeholder="请输入物料编码" />
        </el-form-item>
        <el-form-item label="规格型号" prop="specifications">
          <el-input v-model="form.specifications" placeholder="请输入规格型号" />
        </el-form-item>
        <el-form-item label="物料分组" prop="groupingOfMaterials">
          <el-input v-model="form.groupingOfMaterials" placeholder="请输入物料分组" />
        </el-form-item>
        <el-form-item label="物料分组编码" prop="groupingOfMaterialsCoding">
          <el-input v-model="form.groupingOfMaterialsCoding" placeholder="请输入物料分组编码" />
        </el-form-item>
        <el-form-item label="数据状态" prop="dataState">
          <el-input v-model="form.dataState" placeholder="请输入数据状态" />
        </el-form-item>
        <el-form-item label="存货类别" prop="category">
          <el-input v-model="form.category" placeholder="请输入存货类别" />
        </el-form-item>
        <el-form-item label="物料属性" prop="propertiesOfMaterials">
          <el-input v-model="form.propertiesOfMaterials" placeholder="请输入物料属性" />
        </el-form-item>
        <el-form-item label="单位" prop="units">
          <el-input v-model="form.units" placeholder="请输入单位" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 用户导入对话框 -->
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px" append-to-body>
      <el-upload
        ref="upload"
        :limit="1"
        accept=".xlsx, .xls"
        :headers="upload.headers"
        :action="upload.url + '?updateSupport=' + upload.updateSupport"
        :disabled="upload.isUploading"
        :on-progress="handleFileUploadProgress"
        :on-success="handleFileSuccess"
        :auto-upload="false"
        drag
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip text-center" slot="tip">
          <div class="el-upload__tip" slot="tip">
            <el-checkbox v-model="upload.updateSupport" /> 是否更新已经存在的数据
          </div>
          <span>仅允许导入xls、xlsx格式文件。</span>
          <el-link type="primary" :underline="false" style="font-size:12px;vertical-align: baseline;" @click="importTemplate">下载模板</el-link>
        </div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCbFileOfMaterials, getCbFileOfMaterials, delCbFileOfMaterials, addCbFileOfMaterials, updateCbFileOfMaterials } from "@/api/system/cb/cbFileOfMaterials";
import {getToken} from "@/utils/auth";

export default {
  name: "CbFileOfMaterials",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 物料档案表格数据
      cbFileOfMaterialsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 用户导入参数
      upload: {
        // 是否显示弹出层（用户导入）
        open: false,
        // 弹出层标题（用户导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/system/cb/cbFileOfMaterials/importData"
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        creatingAnOrganizationId: null,
        creatingAnOrganizationName: null,
        organizationOfUseId: null,
        organizationOfUseName: null,
        materialName: null,
        materialCoding: null,
        specifications: null,
        groupingOfMaterials: null,
        groupingOfMaterialsCoding: null,
        dataState: null,
        category: null,
        propertiesOfMaterials: null,
        units: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      },
      // 列信息
      columns: [
        { key: 0, label: `ID`, visible: false },
        { key: 1, label: `场别ID`, visible: true },
        { key: 2, label: `场别名称`, visible: true },
        { key: 3, label: `年`, visible: true },
        { key: 4, label: `月`, visible: true },
        { key: 5, label: `业务日期`, visible: false },
        { key: 6, label: `生产指标`, visible: true },
        { key: 7, label: `预算`, visible: true },
        { key: 8, label: `预算累计`, visible: true },
        { key: 9, label: `实际`, visible: true },
        { key: 10, label: `月度完成率`, visible: true },
        { key: 11, label: `实际累计`, visible: true },
        { key: 12, label: `累计完成率`, visible: true },
        { key: 13, label: `全年任务完成率`, visible: true },
        { key: 14, label: `年度目标差异值`, visible: true },
        { key: 15, label: `备注`, visible: true },
        { key: 16, label: `创建时间`, visible: true }
      ],
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询物料档案列表 */
    getList() {
      this.loading = true;
      listCbFileOfMaterials(this.queryParams).then(response => {
        this.cbFileOfMaterialsList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        creatingAnOrganizationId: null,
        creatingAnOrganizationName: null,
        organizationOfUseId: null,
        organizationOfUseName: null,
        materialName: null,
        materialCoding: null,
        specifications: null,
        groupingOfMaterials: null,
        groupingOfMaterialsCoding: null,
        dataState: null,
        category: null,
        propertiesOfMaterials: null,
        units: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加物料档案";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCbFileOfMaterials(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改物料档案";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCbFileOfMaterials(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCbFileOfMaterials(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除物料档案编号为"' + ids + '"的数据项？').then(function() {
        return delCbFileOfMaterials(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/cb/cbFileOfMaterials/export', {
        ...this.queryParams
      }, `cbFileOfMaterials_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "数据导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('system/cb/cbFileOfMaterials/importTemplate', {
      }, `user_template_${new Date().getTime()}.xlsx`)
    },
    // 文件上传中处理
    handleFileUploadProgress(event, file, fileList) {
      this.upload.isUploading = true;
    },
    // 文件上传成功处理
    handleFileSuccess(response, file, fileList) {
      this.upload.open = false;
      this.upload.isUploading = false;
      this.$refs.upload.clearFiles();
      this.$alert("<div style='overflow: auto;overflow-x: hidden;max-height: 70vh;padding: 10px 20px 0;'>" + response.msg + "</div>", "导入结果", { dangerouslyUseHTMLString: true });
      this.getList();
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    }
  }
};
</script>
