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
<!--      <el-form-item label="月" prop="cbMonth">-->
<!--        <el-input-->
<!--          v-model="queryParams.cbMonth"-->
<!--          placeholder="请输入月"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="单据编号" prop="documentCode">
        <el-input
          v-model="queryParams.documentCode"
          placeholder="请输入单据编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="事由" prop="cause">-->
<!--        <el-input-->
<!--          v-model="queryParams.cause"-->
<!--          placeholder="请输入事由"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="申请日期" prop="businessDate">
        <el-date-picker clearable
                        v-model="queryParams.businessDate"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择申请日期">
        </el-date-picker>
      </el-form-item>
<!--      <el-form-item label="申请人" prop="petitioner">-->
<!--        <el-input-->
<!--          v-model="queryParams.petitioner"-->
<!--          placeholder="请输入申请人"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="申请部门ID" prop="petitionerDepartmentId">-->
<!--        <el-input-->
<!--          v-model="queryParams.petitionerDepartmentId"-->
<!--          placeholder="请输入申请部门ID"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="申请部门" prop="petitionerDepartmentName">-->
<!--        <el-input-->
<!--          v-model="queryParams.petitionerDepartmentName"-->
<!--          placeholder="请输入申请部门"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="申请组织ID" prop="petitionerOrganizationId">-->
<!--        <el-input-->
<!--          v-model="queryParams.petitionerOrganizationId"-->
<!--          placeholder="请输入申请组织ID"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="申请组织" prop="petitionerOrganizationName">
        <el-input
          v-model="queryParams.petitionerOrganizationName"
          placeholder="请输入申请组织"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="退款/付款" prop="typeOfTraffic">-->
<!--        <el-input-->
<!--          v-model="queryParams.typeOfTraffic"-->
<!--          placeholder="请输入来往类型"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="申请报销金额汇总" prop="reimburseAmountSummary">-->
<!--        <el-input-->
<!--          v-model="queryParams.reimburseAmountSummary"-->
<!--          placeholder="请输入申请报销金额汇总"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="费用项目" prop="expenseItem">
        <el-input
          v-model="queryParams.expenseItem"
          placeholder="请输入费用项目"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="申请退付款金额汇总" prop="tefundOfPaymentCollect">-->
<!--        <el-input-->
<!--          v-model="queryParams.tefundOfPaymentCollect"-->
<!--          placeholder="请输入申请退付款金额汇总"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="费用承担组织id" prop="costBearingOrganizationId">-->
<!--        <el-input-->
<!--          v-model="queryParams.costBearingOrganizationId"-->
<!--          placeholder="请输入费用承担组织id"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="费用承担组织" prop="costBearingOrganization">-->
<!--        <el-input-->
<!--          v-model="queryParams.costBearingOrganization"-->
<!--          placeholder="请输入费用承担组织"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="审核人" prop="auditor">-->
<!--        <el-input-->
<!--          v-model="queryParams.auditor"-->
<!--          placeholder="请输入审核人"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="已付款金额" prop="amountPaid">-->
<!--        <el-input-->
<!--          v-model="queryParams.amountPaid"-->
<!--          placeholder="请输入已付款金额"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="已退款金额" prop="amountRefunded">-->
<!--        <el-input-->
<!--          v-model="queryParams.amountRefunded"-->
<!--          placeholder="请输入已退款金额"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="创建人" prop="founder">-->
<!--        <el-input-->
<!--          v-model="queryParams.founder"-->
<!--          placeholder="请输入创建人"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="费用大类" prop="categoriesOfExpenses">
        <el-input
          v-model="queryParams.categoriesOfExpenses"
          placeholder="请输入费用大类"
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
          v-hasPermi="['system:cbExpenseDetail:add']"
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
          v-hasPermi="['system:cbExpenseDetail:edit']"
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
          v-hasPermi="['system:cbExpenseDetail:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:cbExpenseDetail:export']"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['system:cbExpenseDetail:import']"
        >导入</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList" :columns="columns"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="cbExpenseDetailList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" v-if="columns[0].visible" />
      <el-table-column label="年" align="center" prop="cbYear" v-if="columns[1].visible" />
      <el-table-column label="月" align="center" prop="cbMonth" v-if="columns[2].visible" />
      <el-table-column label="单据编号" align="center" prop="documentCode" v-if="columns[3].visible" />
      <el-table-column label="事由" align="center" prop="cause" v-if="columns[4].visible" />
      <el-table-column label="申请日期" align="center" prop="businessDate" width="180" v-if="columns[5].visible">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.businessDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="申请人" align="center" prop="petitioner" v-if="columns[6].visible" />
      <el-table-column label="申请部门ID" align="center" prop="petitionerDepartmentId" v-if="columns[7].visible" />
      <el-table-column label="申请部门" align="center" prop="petitionerDepartmentName" v-if="columns[8].visible" />
      <el-table-column label="申请组织ID" align="center" prop="petitionerOrganizationId" v-if="columns[9].visible" />
      <el-table-column label="申请组织" align="center" prop="petitionerOrganizationName" v-if="columns[10].visible" />
      <el-table-column label="退款/付款" align="center" prop="typeOfTraffic" v-if="columns[11].visible" />
      <el-table-column label="申请报销金额汇总" align="center" prop="reimburseAmountSummary" v-if="columns[12].visible" />
      <el-table-column label="费用项目" align="center" prop="expenseItem" v-if="columns[13].visible" />
      <el-table-column label="申请退付款金额汇总" align="center" prop="tefundOfPaymentCollect" v-if="columns[14].visible" />
      <el-table-column label="单据状态" align="center" prop="documentStatus" v-if="columns[15].visible" />
      <el-table-column label="费用承担组织id" align="center" prop="costBearingOrganizationId" v-if="columns[16].visible" />
      <el-table-column label="费用承担组织" align="center" prop="costBearingOrganization" v-if="columns[17].visible" />
      <el-table-column label="审核人" align="center" prop="auditor" v-if="columns[18].visible" />
      <el-table-column label="已付款金额" align="center" prop="amountPaid" v-if="columns[19].visible" />
      <el-table-column label="已退款金额" align="center" prop="amountRefunded" v-if="columns[20].visible" />
      <el-table-column label="创建人" align="center" prop="founder" v-if="columns[21].visible" />
      <el-table-column label="费用大类" align="center" prop="categoriesOfExpenses" v-if="columns[22].visible" />
      <el-table-column label="创建者" align="center" prop="createBy" v-if="columns[23].visible" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180" v-if="columns[24].visible">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新者" align="center" prop="updateBy" v-if="columns[25].visible" />
      <el-table-column label="更新时间" align="center" prop="updateTime" width="180" v-if="columns[26].visible">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" v-if="columns[27].visible" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['CbExpenseDetail:cbExpenseDetail:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['CbExpenseDetail:cbExpenseDetail:remove']"
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

    <!-- 添加或修改费用明细对话框 -->
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
        <el-form-item label="事由" prop="cause">
          <el-input v-model="form.cause" placeholder="请输入事由" />
        </el-form-item>
        <el-form-item label="申请日期" prop="businessDate">
          <el-date-picker clearable
                          v-model="form.businessDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择申请日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="申请人" prop="petitioner">
          <el-input v-model="form.petitioner" placeholder="请输入申请人" />
        </el-form-item>
        <el-form-item label="申请部门ID" prop="petitionerDepartmentId">
          <el-input v-model="form.petitionerDepartmentId" placeholder="请输入申请部门ID" />
        </el-form-item>
        <el-form-item label="申请部门" prop="petitionerDepartmentName">
          <el-input v-model="form.petitionerDepartmentName" placeholder="请输入申请部门" />
        </el-form-item>
        <el-form-item label="申请组织ID" prop="petitionerOrganizationId">
          <el-input v-model="form.petitionerOrganizationId" placeholder="请输入申请组织ID" />
        </el-form-item>
        <el-form-item label="申请组织" prop="petitionerOrganizationName">
          <el-input v-model="form.petitionerOrganizationName" placeholder="请输入申请组织" />
        </el-form-item>
        <el-form-item label="来往类型" prop="typeOfTraffic">
          <el-input v-model="form.typeOfTraffic" placeholder="请输入来往类型" />
        </el-form-item>
        <el-form-item label="申请报销金额汇总" prop="reimburseAmountSummary">
          <el-input v-model="form.reimburseAmountSummary" placeholder="请输入申请报销金额汇总" />
        </el-form-item>
        <el-form-item label="费用项目" prop="expenseItem">
          <el-input v-model="form.expenseItem" placeholder="请输入费用项目" />
        </el-form-item>
        <el-form-item label="申请退付款金额汇总" prop="tefundOfPaymentCollect">
          <el-input v-model="form.tefundOfPaymentCollect" placeholder="请输入申请退付款金额汇总" />
        </el-form-item>
        <el-form-item label="费用承担组织id" prop="costBearingOrganizationId">
          <el-input v-model="form.costBearingOrganizationId" placeholder="请输入费用承担组织id" />
        </el-form-item>
        <el-form-item label="费用承担组织" prop="costBearingOrganization">
          <el-input v-model="form.costBearingOrganization" placeholder="请输入费用承担组织" />
        </el-form-item>
        <el-form-item label="审核人" prop="auditor">
          <el-input v-model="form.auditor" placeholder="请输入审核人" />
        </el-form-item>
        <el-form-item label="已付款金额" prop="amountPaid">
          <el-input v-model="form.amountPaid" placeholder="请输入已付款金额" />
        </el-form-item>
        <el-form-item label="已退款金额" prop="amountRefunded">
          <el-input v-model="form.amountRefunded" placeholder="请输入已退款金额" />
        </el-form-item>
        <el-form-item label="创建人" prop="founder">
          <el-input v-model="form.founder" placeholder="请输入创建人" />
        </el-form-item>
        <el-form-item label="费用大类" prop="categoriesOfExpenses">
          <el-input v-model="form.categoriesOfExpenses" placeholder="请输入费用大类" />
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
import { listCbExpenseDetail, getCbExpenseDetail, delCbExpenseDetail, addCbExpenseDetail, updateCbExpenseDetail } from "@/api/system/cb/cbExpenseDetail";
import {getToken} from "@/utils/auth";

export default {
  name: "CbExpenseDetail",
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
      // 费用明细表格数据
      cbExpenseDetailList: [],
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
        url: process.env.VUE_APP_BASE_API + "/system/cb/cbExpenseDetail/importData"
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        cbYear: null,
        cbMonth: null,
        documentCode: null,
        cause: null,
        businessDate: null,
        petitioner: null,
        petitionerDepartmentId: null,
        petitionerDepartmentName: null,
        petitionerOrganizationId: null,
        petitionerOrganizationName: null,
        typeOfTraffic: null,
        reimburseAmountSummary: null,
        expenseItem: null,
        tefundOfPaymentCollect: null,
        documentStatus: null,
        costBearingOrganizationId: null,
        costBearingOrganization: null,
        auditor: null,
        amountPaid: null,
        amountRefunded: null,
        founder: null,
        categoriesOfExpenses: null,
      },
      // 列信息
      columns: [
        { key: 0, label: `ID`, visible: false },
        { key: 1, label: `年`, visible: true },
        { key: 2, label: `月`, visible: true },
        { key: 3, label: `单据编号`, visible: true },
        { key: 4, label: `事由`, visible: false },
        { key: 5, label: `申请日期`, visible: true },
        { key: 6, label: `申请人`, visible: true },
        { key: 7, label: `申请部门ID`, visible: false },
        { key: 8, label: `申请部门`, visible: true },
        { key: 9, label: `申请组织ID`, visible: false },
        { key: 10, label: `申请组织`, visible: true },
        { key: 11, label: `退款/付款`, visible: true },
        { key: 12, label: `申请报销金额汇总`, visible: true },
        { key: 13, label: `费用项目`, visible: true },
        { key: 14, label: `申请退付款金额汇总`, visible: true },
        { key: 15, label: `单据状态`, visible: true },
        { key: 16, label: `费用承担组织ID`, visible: false },
        { key: 17, label: `费用承担组织`, visible: true },
        { key: 18, label: `审核人`, visible: true },
        { key: 19, label: `已付款金额`, visible: true },
        { key: 20, label: `已退款金额`, visible: true },
        { key: 21, label: `创建人`, visible: true },
        { key: 22, label: `费用大类`, visible: true },
        { key: 23, label: `备注`, visible: true },
        { key: 24, label: `创建人`, visible: false },
        { key: 25, label: `创建时间`, visible: false },
        { key: 26, label: `更新人`, visible: false },
        { key: 27, label: `更新时间`, visible: false }
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
    /** 查询费用明细列表 */
    getList() {
      this.loading = true;
      listCbExpenseDetail(this.queryParams).then(response => {
        this.cbExpenseDetailList = response.rows;
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
        cause: null,
        businessDate: null,
        petitioner: null,
        petitionerDepartmentId: null,
        petitionerDepartmentName: null,
        petitionerOrganizationId: null,
        petitionerOrganizationName: null,
        typeOfTraffic: null,
        reimburseAmountSummary: null,
        expenseItem: null,
        tefundOfPaymentCollect: null,
        documentStatus: null,
        costBearingOrganizationId: null,
        costBearingOrganization: null,
        auditor: null,
        amountPaid: null,
        amountRefunded: null,
        founder: null,
        categoriesOfExpenses: null,
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
      this.title = "添加费用明细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCbExpenseDetail(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改费用明细";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCbExpenseDetail(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCbExpenseDetail(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除费用明细编号为"' + ids + '"的数据项？').then(function() {
        return delCbExpenseDetail(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/cb/cbExpenseDetail/export', {
        ...this.queryParams
      }, `cbExpenseDetail_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "数据导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('system/cb/cbExpenseDetail/importTemplate', {
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
