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
<!--      <el-form-item label="公司ID" prop="companyId">-->
<!--        <el-input-->
<!--          v-model="queryParams.companyId"-->
<!--          placeholder="请输入公司ID"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="公司名称" prop="companyName">
        <el-input
          v-model="queryParams.companyName"
          placeholder="请输入公司名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="场别id" prop="hoggeryId">-->
<!--        <el-input-->
<!--          v-model="queryParams.hoggeryId"-->
<!--          placeholder="请输入场别id"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="场别名称" prop="hoggeryName">
        <el-input
          v-model="queryParams.hoggeryName"
          placeholder="请输入场别名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="费用属性" prop="costAttribute">-->
<!--        <el-input-->
<!--          v-model="queryParams.costAttribute"-->
<!--          placeholder="请输入费用属性"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="费用类型" prop="cosTypes">-->
<!--        <el-input-->
<!--          v-model="queryParams.cosTypes"-->
<!--          placeholder="请输入费用类型"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="人数" prop="population">-->
<!--        <el-input-->
<!--          v-model="queryParams.population"-->
<!--          placeholder="请输入人数"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="计提金额" prop="amountWithdrawn">-->
<!--        <el-input-->
<!--          v-model="queryParams.amountWithdrawn"-->
<!--          placeholder="请输入计提金额"-->
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
          v-hasPermi="['system:cbArtificial:add']"
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
          v-hasPermi="['system:cbArtificial:edit']"
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
          v-hasPermi="['system:cbArtificial:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:cbArtificial:export']"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['system:cbArtificial:import']"
        >导入</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList" :columns="columns"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="cbArtificialList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" v-if="columns[0].visible" />
      <el-table-column label="年" align="center" prop="cbYear" v-if="columns[1].visible" />
      <el-table-column label="月" align="center" prop="cbMonth" v-if="columns[2].visible" />
      <el-table-column label="公司ID" align="center" prop="companyId" v-if="columns[3].visible" />
      <el-table-column label="公司名称" align="center" prop="companyName" v-if="columns[4].visible" />
      <el-table-column label="场别id" align="center" prop="hoggeryId" v-if="columns[5].visible" />
      <el-table-column label="场别名称" align="center" prop="hoggeryName" v-if="columns[6].visible" />
      <el-table-column label="费用属性" align="center" prop="costAttribute" v-if="columns[7].visible" />
      <el-table-column label="费用类型" align="center" prop="cosTypes" v-if="columns[8].visible" />
      <el-table-column label="人数" align="center" prop="population" v-if="columns[9].visible" />
      <el-table-column label="计提金额" align="center" prop="amountWithdrawn" v-if="columns[10].visible" />
      <el-table-column label="备注" align="center" prop="remark" v-if="columns[11].visible" />
      <el-table-column label="创建人" align="center" prop="createBy" v-if="columns[12].visible"/>
      <el-table-column label="创建时间" align="center" prop="createTime" v-if="columns[13].visible" width="160">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新人" align="center" prop="updateBy" v-if="columns[14].visible"/>
      <el-table-column label="更新时间" align="center" prop="updateTime" v-if="columns[15].visible" width="160">
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
            v-hasPermi="['system:cbArtificial:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:cbArtificial:remove']"
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

    <!-- 添加或修改人工对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">

        <el-row>
          <el-col :span="10">
            <el-form-item label="年" prop="cbYear">
              <el-input v-model="form.cbYear" placeholder="请输入年" />
            </el-form-item>
          </el-col>

          <el-col :span="10">
            <el-form-item label="月" prop="cbMonth">
              <el-input v-model="form.cbMonth" placeholder="请输入月" />
            </el-form-item>
          </el-col>

          <el-col :span="10">
            <el-form-item label="公司ID" prop="companyId">
<!--              <el-input v-model="form.companyId" placeholder="请输入公司ID" />-->
              <treeselect v-model="form.companyId" :options="deptOptions" :show-count="true" placeholder="请选择公司" />
            </el-form-item>
          </el-col>

          <el-col :span="10">
            <el-form-item label="公司名称" prop="companyName" hidden>
              <el-input v-model="form.companyName" placeholder="请输入公司名称" />
            </el-form-item>
          </el-col>

          <el-col :span="10">
            <el-form-item label="场别id" prop="hoggeryId">
<!--              <el-input v-model="form.hoggeryId" placeholder="请输入场别id" />-->
              <treeselect v-model="form.hoggeryId" :options="deptOptions" :show-count="true" placeholder="请选择场别" />
            </el-form-item>
          </el-col>

          <el-col :span="10">
            <el-form-item label="场别名称" prop="hoggeryName" hidden>
              <el-input v-model="form.hoggeryName" placeholder="请输入场别名称" />
            </el-form-item>
          </el-col>

          <el-col :span="10">
            <el-form-item label="费用属性" prop="costAttribute">
              <el-input v-model="form.costAttribute" placeholder="请输入费用属性" />
            </el-form-item>
          </el-col>

          <el-col :span="10">
            <el-form-item label="费用类型" prop="cosTypes">
              <el-input v-model="form.cosTypes" placeholder="请输入费用类型" />
            </el-form-item>
          </el-col>

          <el-col :span="10">
            <el-form-item label="人数" prop="population">
              <el-input v-model="form.population" placeholder="请输入人数" />
            </el-form-item>
          </el-col>

          <el-col :span="10">
            <el-form-item label="计提金额" prop="amountWithdrawn">
              <el-input v-model="form.amountWithdrawn" placeholder="请输入计提金额" />
            </el-form-item>
          </el-col>

          <el-col :span="10">
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
import { listCbArtificial, getCbArtificial, delCbArtificial, addCbArtificial, updateCbArtificial, deptTreeSelect } from "@/api/system/cb/cbArtificial";
import {getToken} from "@/utils/auth";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";
export default {
  name: "CbArtificial",
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
      // 人工表格数据
      cbArtificialList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
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
        url: process.env.VUE_APP_BASE_API + "/system/cb/cbArtificial/importData"
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        cbYear: null,
        cbMonth: null,
        companyId: null,
        companyName: null,
        hoggeryId: null,
        hoggeryName: null,
        costAttribute: null,
        cosTypes: null,
        population: null,
        amountWithdrawn: null,
      },

      // 列信息
      columns: [
        { key: 0, label: `ID`, visible: false },
        { key: 1, label: `年`, visible: true },
        { key: 2, label: `月`, visible: true },
        { key: 3, label: `公司ID`, visible: false },
        { key: 4, label: `公司名称`, visible: true },
        { key: 5, label: `场别ID`, visible: false },
        { key: 6, label: `场别名称`, visible: true },
        { key: 7, label: `费用属性`, visible: true },
        { key: 8, label: `费用类型`, visible: true },
        { key: 9, label: `人数`, visible: true },
        { key: 10, label: `计提金额`, visible: true },
        { key: 11, label: `备注`, visible: true },
        { key: 12, label: `创建人`, visible: false },
        { key: 13, label: `创建时间`, visible: false },
        { key: 14, label: `更新人`, visible: false },
        { key: 15, label: `更新时间`, visible: false }
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
    /** 查询人工列表 */
    getList() {
      this.loading = true;
      listCbArtificial(this.queryParams).then(response => {
        this.cbArtificialList = response.rows;
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
        cbYear: null,
        cbMonth: null,
        companyId: null,
        companyName: null,
        hoggeryId: null,
        hoggeryName: null,
        costAttribute: null,
        cosTypes: null,
        population: null,
        amountWithdrawn: null,
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
      this.title = "添加人工";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCbArtificial(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改人工";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCbArtificial(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCbArtificial(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除人工编号为"' + ids + '"的数据项？').then(function() {
        return delCbArtificial(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/cb/cbArtificial/export', {
        ...this.queryParams
      }, `cbArtificial_${new Date().getTime()}.xlsx`)
    },

    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "数据导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('system/cb/cbArtificial/importTemplate', {
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
