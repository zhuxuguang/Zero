<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
<!--      <el-form-item label="场别ID" prop="fieldId">-->
<!--        <el-input-->
<!--          v-model="queryParams.fieldId"-->
<!--          placeholder="请输入场别ID"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="场别名称" prop="fieldName">
        <el-input
          v-model="queryParams.fieldName"
          placeholder="请输入场别名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
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
<!--      <el-form-item label="业务日期" prop="businessDate">-->
<!--        <el-date-picker clearable-->
<!--                        v-model="queryParams.businessDate"-->
<!--                        type="date"-->
<!--                        value-format="yyyy-MM-dd"-->
<!--                        placeholder="请选择业务日期">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
      <el-form-item label="生产指标" prop="productionIndex">
        <el-input
          v-model="queryParams.productionIndex"
          placeholder="请输入生产指标"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="预算" prop="budget">-->
<!--        <el-input-->
<!--          v-model="queryParams.budget"-->
<!--          placeholder="请输入预算"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="预算累计" prop="budgetAccumulative">-->
<!--        <el-input-->
<!--          v-model="queryParams.budgetAccumulative"-->
<!--          placeholder="请输入预算累计"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="实际" prop="practical">-->
<!--        <el-input-->
<!--          v-model="queryParams.practical"-->
<!--          placeholder="请输入实际"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="月度完成率" prop="finishingRate">-->
<!--        <el-input-->
<!--          v-model="queryParams.finishingRate"-->
<!--          placeholder="请输入月度完成率"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="实际累计" prop="actualAccumulation">-->
<!--        <el-input-->
<!--          v-model="queryParams.actualAccumulation"-->
<!--          placeholder="请输入实际累计"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="累计完成率" prop="cumulativeCompletionRate">-->
<!--        <el-input-->
<!--          v-model="queryParams.cumulativeCompletionRate"-->
<!--          placeholder="请输入累计完成率"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="全年任务完成率" prop="yearCompletionRate">-->
<!--        <el-input-->
<!--          v-model="queryParams.yearCompletionRate"-->
<!--          placeholder="请输入全年任务完成率"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="年度目标差异值" prop="yearTargetVariance">-->
<!--        <el-input-->
<!--          v-model="queryParams.yearTargetVariance"-->
<!--          placeholder="请输入年度目标差异值"-->
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
          v-hasPermi="['system:cbProductionTarget:add']"
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
          v-hasPermi="['system:cbProductionTarget:edit']"
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
          v-hasPermi="['system:cbProductionTarget:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:cbProductionTarget:export']"
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
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList" :columns="columns"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="cbProductionTargetList" :default-sort="defaultSort" @selection-change="handleSelectionChange" @sort-change="handleSortChange" >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id"  v-if="columns[0].visible"/>
      <el-table-column label="场别ID" align="center" prop="fieldId" v-if="columns[1].visible"/>
      <el-table-column label="场别名称" align="center" prop="fieldName" v-if="columns[2].visible"/>
      <el-table-column label="年" align="center" prop="cbYear" v-if="columns[3].visible" sortable="custom" :sort-orders="['descending', 'ascending']"  />
      <el-table-column label="月" align="center" prop="cbMonth" v-if="columns[4].visible"/>
      <el-table-column label="业务日期" align="center" prop="businessDate" width="180" v-if="columns[5].visible">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.businessDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="生产指标" align="center" prop="productionIndex" v-if="columns[6].visible"/>
      <el-table-column label="预算" align="center" prop="budget" v-if="columns[7].visible"/>
      <el-table-column label="预算累计" align="center" prop="budgetAccumulative" v-if="columns[8].visible"/>
      <el-table-column label="实际" align="center" prop="practical" v-if="columns[9].visible"/>
      <el-table-column label="月度完成率" align="center" prop="finishingRate" v-if="columns[10].visible"/>
      <el-table-column label="实际累计" align="center" prop="actualAccumulation" v-if="columns[11].visible"/>
      <el-table-column label="累计完成率" align="center" prop="cumulativeCompletionRate" v-if="columns[12].visible"/>
      <el-table-column label="全年任务完成率" align="center" prop="yearCompletionRate" v-if="columns[13].visible"/>
      <el-table-column label="年度目标差异值" align="center" prop="yearTargetVariance" v-if="columns[14].visible"/>
      <el-table-column label="备注" align="center" prop="remark" v-if="columns[15].visible"/>
      <el-table-column label="创建时间" align="center" prop="createTime" v-if="columns[16].visible" sortable="custom" :sort-orders="['descending', 'ascending']" width="160">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:cbProductionTarget:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:cbProductionTarget:remove']"
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

    <!-- 添加或修改生产目标对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">

        <el-row>

          <el-col :span="12">
            <el-form-item label="场别" prop="fieldId">
<!--              <el-input v-model="form.fieldId" placeholder="请输入场别ID" />-->
              <treeselect v-model="form.fieldId" :options="deptOptions" :show-count="true" placeholder="请选择场别" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="场别名称" prop="fieldName" hidden>
              <el-input v-model="form.fieldName" placeholder="请输入场别名称" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="年" prop="cbYear" sortable="custom" :sort-orders="['descending', 'ascending']" >
              <el-input v-model="form.cbYear" placeholder="请输入年" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="月" prop="cbMonth">
              <el-input v-model="form.cbMonth" placeholder="请输入月" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="业务日期" prop="businessDate">
              <el-date-picker clearable
                              v-model="form.businessDate"
                              type="date"
                              value-format="yyyy-MM-dd"
                              placeholder="请选择业务日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="生产指标" prop="productionIndex">
              <el-input v-model="form.productionIndex" placeholder="请输入生产指标" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="预算" prop="budget">
              <el-input v-model="form.budget" placeholder="请输入预算" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="预算累计" prop="budgetAccumulative">
              <el-input v-model="form.budgetAccumulative" placeholder="请输入预算累计" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="实际" prop="practical">
              <el-input v-model="form.practical" placeholder="请输入实际" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="月度完成率" prop="finishingRate">
              <el-input v-model="form.finishingRate" placeholder="请输入月度完成率" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="实际累计" prop="actualAccumulation">
              <el-input v-model="form.actualAccumulation" placeholder="请输入实际累计" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="累计完成率" prop="cumulativeCompletionRate">
              <el-input v-model="form.cumulativeCompletionRate" placeholder="请输入累计完成率" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="全年任务完成率" prop="yearCompletionRate">
              <el-input v-model="form.yearCompletionRate" placeholder="请输入全年任务完成率" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="年度目标差异值" prop="yearTargetVariance">
              <el-input v-model="form.yearTargetVariance" placeholder="请输入年度目标差异值" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="备注" prop="remark">
              <el-input v-model="form.remark" placeholder="请输入备注" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="备注" prop="remark">
              <el-input v-model="form.remark" placeholder="请输入备注" />
            </el-form-item>
          </el-col>

        </el-row>
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
import { listCbProductionTarget, getCbProductionTarget, delCbProductionTarget, addCbProductionTarget, updateCbProductionTarget, deptTreeSelect } from "@/api/system/cb/cbProductionTarget";
import {getToken} from "@/utils/auth";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";
export default {
  name: "CbProductionTarget",
  components: { Treeselect },
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
      // 生产目标表格数据
      cbProductionTargetList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 默认排序
      defaultSort: {prop: 'createTime', order: 'descending'},
      // 部门树选项
      deptOptions: undefined,
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
        url: process.env.VUE_APP_BASE_API + "/system/cb/cbProductionTarget/importData"
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        fieldId: null,
        fieldName: null,
        businessDate: null,
        productionIndex: null,
        budget: null,
        budgetAccumulative: null,
        practical: null,
        finishingRate: null,
        actualAccumulation: null,
        cumulativeCompletionRate: null,
        yearCompletionRate: null,
        yearTargetVariance: null,
      },

      // 列信息
      columns: [
        { key: 0, label: `ID`, visible: false },
        { key: 1, label: `场别ID`, visible: false },
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
    this.getDeptTree();
  },
  methods: {
    /** 查询生产目标列表 */
    getList() {
      this.loading = true;
      listCbProductionTarget(this.queryParams).then(response => {
        this.cbProductionTargetList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询部门下拉树结构 */
    getDeptTree() {
      deptTreeSelect().then(response => {
        this.deptOptions = response.data;
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
        fieldId: null,
        fieldName: null,
        businessDate: null,
        productionIndex: null,
        budget: null,
        budgetAccumulative: null,
        practical: null,
        finishingRate: null,
        actualAccumulation: null,
        cumulativeCompletionRate: null,
        yearCompletionRate: null,
        yearTargetVariance: null,
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
      this.$refs.tables.sort(this.defaultSort.prop, this.defaultSort.order);
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
      this.title = "添加生产目标";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCbProductionTarget(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改生产目标";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCbProductionTarget(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCbProductionTarget(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除生产目标编号为"' + ids + '"的数据项？').then(function() {
        return delCbProductionTarget(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/cb/cbProductionTarget/export', {
        ...this.queryParams
      }, `cbProductionTarget_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "数据导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('system/cb/cbProductionTarget/importTemplate', {
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
  }
};
</script>
