<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="年" prop="cbYear">
        <el-input
          v-model="queryParams.cbYear"
          placeholder="请输入年"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="月" prop="cbMonth">
        <el-input
          v-model="queryParams.cbMonth"
          placeholder="请输入月"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="单据编号" prop="documentCode">
        <el-input
          v-model="queryParams.documentCode"
          placeholder="请输入单据编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="业务日期" prop="businessDate">
        <el-date-picker clearable
          v-model="queryParams.businessDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择业务日期">
        </el-date-picker>
      </el-form-item>
<!--      <el-form-item label="发料组织ID" prop="fieldId">-->
<!--        <el-input-->
<!--          v-model="queryParams.fieldId"-->
<!--          placeholder="请输入发料组织ID"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="发料组织名称" prop="fieldName">
        <el-input
          v-model="queryParams.fieldName"
          placeholder="请输入发料组织名称"
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
      <el-form-item label="物料名称" prop="materialName">
        <el-input
          v-model="queryParams.materialName"
          placeholder="请输入物料名称"
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
<!--      <el-form-item label="单位" prop="units">-->
<!--        <el-input-->
<!--          v-model="queryParams.units"-->
<!--          placeholder="请输入单位"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="实发数量" prop="actualQuantityIssued">-->
<!--        <el-input-->
<!--          v-model="queryParams.actualQuantityIssued"-->
<!--          placeholder="请输入实发数量"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="领入栋舍" prop="showInHouse">-->
<!--        <el-input-->
<!--          v-model="queryParams.showInHouse"-->
<!--          placeholder="请输入领入栋舍"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="仓库" prop="warehouse">-->
<!--        <el-input-->
<!--          v-model="queryParams.warehouse"-->
<!--          placeholder="请输入仓库"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="总成本" prop="totalCost">-->
<!--        <el-input-->
<!--          v-model="queryParams.totalCost"-->
<!--          placeholder="请输入总成本"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="类别" prop="category">
        <el-input
          v-model="queryParams.category"
          placeholder="请输入类别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
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
          v-hasPermi="['system:cbProductionMaterial:add']"
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
          v-hasPermi="['system:cbProductionMaterial:edit']"
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
          v-hasPermi="['system:cbProductionMaterial:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:cbProductionMaterial:export']"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['system:cbProductionMaterial:import']"
        >导入</el-button>
      </el-col>

      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-s-help"
          size="mini"
          @click="handleMerge"
          v-hasPermi="['system:cbProductionMaterial:merge']"
        >合并</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList" :columns="columns"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="cbProductionMaterialList" @selection-change="handleSelectionChange" @sort-change="handleSortChange" >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" v-if="columns[0].visible"/>
      <el-table-column label="年" align="center" prop="cbYear" v-if="columns[1].visible" sortable="custom" :sort-orders="['descending', 'ascending']" />
      <el-table-column label="月" align="center" prop="cbMonth" v-if="columns[2].visible"/>
      <el-table-column label="单据编号" align="center" prop="documentCode" v-if="columns[3].visible" width="170"/>
      <el-table-column label="业务日期" align="center" prop="businessDate" width="180" v-if="columns[4].visible">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.businessDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="单据状态" align="center" prop="documentStatus" v-if="columns[5].visible"/>
      <el-table-column label="发料组织ID" align="center" prop="fieldId" v-if="columns[6].visible"/>
      <el-table-column label="发料组织名称" align="center" prop="fieldName" v-if="columns[7].visible"/>
      <el-table-column label="物料编码" align="center" prop="materialCoding" v-if="columns[8].visible"/>
      <el-table-column label="物料名称" align="center" prop="materialName" v-if="columns[9].visible"/>
      <el-table-column label="业务类型" align="center" prop="businessType" v-if="columns[10].visible"/>
      <el-table-column label="规格型号" align="center" prop="specifications" v-if="columns[11].visible"/>
      <el-table-column label="单位" align="center" prop="units" v-if="columns[12].visible"/>
      <el-table-column label="实发数量" align="center" prop="actualQuantityIssued" v-if="columns[13].visible"/>
      <el-table-column label="领入栋舍" align="center" prop="showInHouse" v-if="columns[14].visible"/>
      <el-table-column label="仓库" align="center" prop="warehouse" v-if="columns[15].visible"/>
      <el-table-column label="总成本" align="center" prop="totalCost" v-if="columns[16].visible"/>
      <el-table-column label="类别" align="center" prop="category" v-if="columns[17].visible"/>
      <el-table-column label="备注" align="center" prop="remark" v-if="columns[18].visible"/>
      <el-table-column label="创建人" align="center" prop="createBy" v-if="columns[19].visible"/>
      <el-table-column label="创建时间" align="center" prop="createTime" v-if="columns[20].visible" width="160" sortable="custom" :sort-orders="['descending', 'ascending']" >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新人" align="center" prop="updateBy" v-if="columns[21].visible"/>
      <el-table-column label="更新时间" align="center" prop="updateTime" v-if="columns[22].visible" width="160">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:cbProductionMaterial:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:cbProductionMaterial:remove']"
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

    <!-- 添加或修改生产领料对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="年" prop="cbYear">
          <el-input v-model="form.cbYear" placeholder="请输入年" />
        </el-form-item>
        <el-form-item label="月" prop="cbMonth">
          <el-input v-model="form.cbMonth" placeholder="请输入月" />
        </el-form-item>
        <el-form-item label="单据编号" prop="documentCode">
          <el-input v-model="form.documentCode" placeholder="请输入单据编号" />
        </el-form-item>
        <el-form-item label="业务日期" prop="businessDate">
          <el-date-picker clearable
            v-model="form.businessDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择业务日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="发料组织ID" prop="fieldId">
          <el-input v-model="form.fieldId" placeholder="请输入发料组织ID" />
        </el-form-item>
        <el-form-item label="发料组织名称" prop="fieldName">
          <el-input v-model="form.fieldName" placeholder="请输入发料组织名称" />
        </el-form-item>
        <el-form-item label="物料编码" prop="materialCoding">
          <el-input v-model="form.materialCoding" placeholder="请输入物料编码" />
        </el-form-item>
        <el-form-item label="物料名称" prop="materialName">
          <el-input v-model="form.materialName" placeholder="请输入物料名称" />
        </el-form-item>
        <el-form-item label="规格型号" prop="specifications">
          <el-input v-model="form.specifications" placeholder="请输入规格型号" />
        </el-form-item>
        <el-form-item label="单位" prop="units">
          <el-input v-model="form.units" placeholder="请输入单位" />
        </el-form-item>
        <el-form-item label="实发数量" prop="actualQuantityIssued">
          <el-input v-model="form.actualQuantityIssued" placeholder="请输入实发数量" />
        </el-form-item>
        <el-form-item label="领入栋舍" prop="showInHouse">
          <el-input v-model="form.showInHouse" placeholder="请输入领入栋舍" />
        </el-form-item>
        <el-form-item label="仓库" prop="warehouse">
          <el-input v-model="form.warehouse" placeholder="请输入仓库" />
        </el-form-item>
        <el-form-item label="总成本" prop="totalCost">
          <el-input v-model="form.totalCost" placeholder="请输入总成本" />
        </el-form-item>
        <el-form-item label="类别" prop="category">
          <el-input v-model="form.category" placeholder="请输入类别" />
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
import {
  listCbProductionMaterial,
  getCbProductionMaterial,
  delCbProductionMaterial,
  addCbProductionMaterial,
  updateCbProductionMaterial,
  mergeCbProductionMaterial
} from "@/api/system/cb/cbProductionMaterial";
import {getToken} from "@/utils/auth";

export default {
  name: "CbProductionMaterial",
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
      // 生产领料表格数据
      cbProductionMaterialList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 默认排序
      defaultSort: {prop: 'createTime', order: 'descending'},
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
        url: process.env.VUE_APP_BASE_API + "/system/cb/cbProductionMaterial/importData"
      },

      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        cbYear: null,
        cbMonth: null,
        documentCode: null,
        businessDate: null,
        fieldId: null,
        fieldName: null,
        documentStatus: null,
        materialCoding: null,
        materialName: null,
        businessType: null,
        specifications: null,
        units: null,
        actualQuantityIssued: null,
        showInHouse: null,
        warehouse: null,
        totalCost: null,
        category: null,
      },

      // 列信息
      columns: [
        { key: 0, label: `ID`, visible: false },
        { key: 1, label: `年`, visible: true },
        { key: 2, label: `月`, visible: true },
        { key: 3, label: `单据编号`, visible: true },
        { key: 4, label: `业务日期`, visible: true },
        { key: 5, label: `单据状态`, visible: true },
        { key: 6, label: `发料组织ID`, visible: false },
        { key: 7, label: `发料组织名称`, visible: true },
        { key: 8, label: `物料编码`, visible: true },
        { key: 9, label: `物料名称`, visible: true },
        { key: 10, label: `业务类型`, visible: true },
        { key: 11, label: `规格型号`, visible: true },
        { key: 12, label: `单位`, visible: true },
        { key: 13, label: `实发数量`, visible: true },
        { key: 14, label: `领入栋舍`, visible: true },
        { key: 15, label: `仓库`, visible: true },
        { key: 16, label: `总成本`, visible: true },
        { key: 17, label: `类别`, visible: true },
        { key: 18, label: `备注`, visible: true },
        { key: 19, label: `创建人`, visible: false },
        { key: 20, label: `创建时间`, visible: false },
        { key: 21, label: `更新人`, visible: false },
        { key: 22, label: `更新时间`, visible: false }
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
    /** 查询生产领料列表 */
    getList() {
      this.loading = true;
      listCbProductionMaterial(this.queryParams).then(response => {
        this.cbProductionMaterialList = response.rows;
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
        cbYear: null,
        cbMonth: null,
        documentCode: null,
        businessDate: null,
        fieldId: null,
        fieldName: null,
        documentStatus: null,
        materialCoding: null,
        materialName: null,
        businessType: null,
        specifications: null,
        units: null,
        actualQuantityIssued: null,
        showInHouse: null,
        warehouse: null,
        totalCost: null,
        category: null,
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
      this.$refs.tables.sort(this.defaultSort.prop, this.defaultSort.order)
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
      this.title = "添加生产领料";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCbProductionMaterial(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改生产领料";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCbProductionMaterial(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCbProductionMaterial(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除生产领料编号为"' + ids + '"的数据项？').then(function() {
        return delCbProductionMaterial(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('/system/cb/cbProductionMaterial/export', {
        ...this.queryParams
      }, `cbProductionMaterial_${new Date().getTime()}.xlsx`)
    },

    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "数据导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('system/cb/cbProductionMaterial/importTemplate', {
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
    },
    /** 排序触发事件 */
    handleSortChange(column, prop, order) {
      this.queryParams.orderByColumn = column.prop;
      this.queryParams.isAsc = column.order;
      this.getList();
    },
    handleMerge(){
      this.$modal.loading("正在合并数据，请稍后...");
      mergeCbProductionMaterial();
      this.getList();
      this.$modal.closeLoading("已完成同步");
    },
  }
};
</script>
