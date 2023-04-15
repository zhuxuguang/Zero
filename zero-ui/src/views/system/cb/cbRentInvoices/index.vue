<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
<!--      <el-form-item label="年" prop="cbYear">-->
<!--        <el-input-->
<!--          v-model="queryParams.cbYear"-->
<!--          placeholder="请输入年"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="月" prop="cbMonth">-->
<!--        <el-input-->
<!--          v-model="queryParams.cbMonth"-->
<!--          placeholder="请输入月"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="业务日期" prop="businessDate">
        <el-date-picker clearable
          v-model="queryParams.businessDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择业务日期">
        </el-date-picker>
      </el-form-item>
<!--      <el-form-item label="场别ID" prop="hoggeryId">-->
<!--        <el-input-->
<!--          v-model="queryParams.hoggeryId"-->
<!--          placeholder="请输入场别ID"-->
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
      <el-form-item label="费用类型" prop="costTypes">
        <el-input
          v-model="queryParams.costTypes"
          placeholder="请输入费用类型"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="资产原值" prop="initialAssetValue">-->
<!--        <el-input-->
<!--          v-model="queryParams.initialAssetValue"-->
<!--          placeholder="请输入资产原值"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="摊销月数" prop="amortizeMonths">-->
<!--        <el-input-->
<!--          v-model="queryParams.amortizeMonths"-->
<!--          placeholder="请输入摊销月数"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="摊销起始月份" prop="amortizeStartMonth">-->
<!--        <el-date-picker clearable-->
<!--          v-model="queryParams.amortizeStartMonth"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="请选择摊销起始月份">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="摊销结束月份" prop="amortizeEndMonth">-->
<!--        <el-date-picker clearable-->
<!--          v-model="queryParams.amortizeEndMonth"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="请选择摊销结束月份">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="本月摊销金额" prop="instantAmortizedMoney">-->
<!--        <el-input-->
<!--          v-model="queryParams.instantAmortizedMoney"-->
<!--          placeholder="请输入本月摊销金额"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="已摊销月数" prop="alreadyAmortizedMonths">-->
<!--        <el-input-->
<!--          v-model="queryParams.alreadyAmortizedMonths"-->
<!--          placeholder="请输入已摊销月数"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="已摊销金额" prop="alreadyAmortizedMoney">-->
<!--        <el-input-->
<!--          v-model="queryParams.alreadyAmortizedMoney"-->
<!--          placeholder="请输入已摊销金额"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="核算维度" prop="dimensionOfAccounting">-->
<!--        <el-input-->
<!--          v-model="queryParams.dimensionOfAccounting"-->
<!--          placeholder="请输入核算维度"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="余额" prop="balance">-->
<!--        <el-input-->
<!--          v-model="queryParams.balance"-->
<!--          placeholder="请输入余额"-->
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
<!--      <el-form-item label="更新着" prop="updateBy">-->
<!--        <el-input-->
<!--          v-model="queryParams.updateBy"-->
<!--          placeholder="请输入更新着"-->
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
<!--      <el-form-item label="备注" prop="remake">-->
<!--        <el-input-->
<!--          v-model="queryParams.remake"-->
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
          v-hasPermi="['system:cbRentInvoices:add']"
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
          v-hasPermi="['system:cbRentInvoices:edit']"
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
          v-hasPermi="['system:cbRentInvoices:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:cbRentInvoices:export']"
        >导出</el-button>
      </el-col>

      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-s-check"
          size="mini"
          @click="handleCheck"
          v-hasPermi="['system:cbRentInvoices:check']"
        >审核</el-button>
      </el-col>

      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-close"
          size="mini"
          @click="handleOnCheck"
          v-hasPermi="['system:cbRentInvoices:onCheck']"
        >反审核</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList" :columns="columns"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="cbRentInvoicesList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" v-if="columns[0].visible" />
      <el-table-column label="年" align="center" prop="cbYear" v-if="columns[1].visible" />
      <el-table-column label="月" align="center" prop="cbMonth" v-if="columns[2].visible" />
      <el-table-column label="业务日期" align="center" prop="businessDate" width="180" v-if="columns[3].visible">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.businessDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="资产名称" align="center" prop="assetName" v-if="columns[4].visible" />
      <el-table-column label="场别ID" align="center" prop="hoggeryId" v-if="columns[5].visible" />
      <el-table-column label="场别名称" align="center" prop="hoggeryName" v-if="columns[6].visible" />
      <el-table-column label="公司ID" align="center" prop="companyId" v-if="columns[7].visible" />
      <el-table-column label="公司名称" align="center" prop="companyName" v-if="columns[8].visible" />
      <el-table-column label="费用类型" align="center" prop="costTypes" v-if="columns[9].visible" />
      <el-table-column label="资产原值" align="center" prop="initialAssetValue" v-if="columns[10].visible" />
      <el-table-column label="摊销月数" align="center" prop="amortizeMonths" v-if="columns[11].visible" />
      <el-table-column label="摊销起始月份" align="center" prop="amortizeStartMonth" width="180" v-if="columns[12].visible">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.amortizeStartMonth, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="摊销结束月份" align="center" prop="amortizeEndMonth" width="180" v-if="columns[13].visible">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.amortizeEndMonth, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="本月摊销金额" align="center" prop="instantAmortizedMoney" v-if="columns[14].visible" />
      <el-table-column label="已摊销月数" align="center" prop="alreadyAmortizedMonths" v-if="columns[15].visible" />
      <el-table-column label="已摊销金额" align="center" prop="alreadyAmortizedMoney" v-if="columns[16].visible" />
      <el-table-column label="核算维度" align="center" prop="dimensionOfAccounting" v-if="columns[17].visible" />
      <el-table-column label="余额" align="center" prop="balance" v-if="columns[18].visible" />
      <el-table-column label="单据状态" align="center" prop="documentStatus" v-if="columns[19].visible">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.cb_document_status" :value="scope.row.documentStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remake" v-if="columns[20].visible" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:cbRentInvoices:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:cbRentInvoices:remove']"
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

    <!-- 添加或修改租金录入单据对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="6">
            <el-form-item label="年" prop="cbYear" hidden>
              <el-input v-model="form.cbYear" placeholder="请输入年" />
            </el-form-item>
          </el-col>
          <el-form-item label="月" prop="cbMonth" hidden>
            <el-input v-model="form.cbMonth" placeholder="请输入月" />
          </el-form-item>
          <el-row>
            <el-col :span="10">
              <el-form-item label="业务日期" prop="businessDate">
                <el-date-picker clearable
                                v-model="form.businessDate"
                                type="date"
                                value-format="yyyy-MM-dd"
                                placeholder="请选择业务日期">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="10">
              <el-form-item label="资产名称" prop="assetName">
                <el-input v-model="form.assetName" placeholder="请输入资产名称" />
              </el-form-item>
            </el-col>
            <el-col :span="10">
              <el-form-item label="场别" prop="hoggeryId" >
<!--                <el-input v-model="form.hoggeryId" placeholder="请输入场别ID" />-->
                <treeselect v-model="form.hoggeryId" :options="deptOptions" :show-count="true" placeholder="请选择场别" />
              </el-form-item>
            </el-col>

            <el-col :span="10">
              <el-form-item label="场别名称" prop="hoggeryName" hidden>
                <el-input v-model="form.hoggeryName" placeholder="请输入场别名称" />
              </el-form-item>
            </el-col>

            <el-col :span="10">
              <el-form-item label="公司" prop="companyId">
                <treeselect v-model="form.companyId" :options="deptOptions" :show-count="true" placeholder="请选择公司" />
              </el-form-item>
            </el-col>

            <el-col :span="10" >
              <el-form-item label="公司名称" prop="companyName" hidden>
                <el-input v-model="form.companyName" placeholder="请输入公司名称" />
              </el-form-item>
            </el-col>
            <el-col :span="10">
              <el-form-item label="费用类型" prop="costTypes">
                <el-input v-model="form.costTypes" placeholder="请输入费用类型" />
              </el-form-item>
            </el-col>

            <el-col :span="10">
              <el-form-item label="资产原值" prop="initialAssetValue">
                <el-input v-model="form.initialAssetValue" placeholder="请输入资产原值" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="10">
              <el-form-item label="摊销月数" prop="amortizeMonths" hidden>
                <el-input v-model="form.amortizeMonths" placeholder="请输入摊销月数" />
              </el-form-item>
            </el-col>

            <el-col :span="10">
              <el-form-item label="摊销起始月份" prop="amortizeStartMonth">
                <el-date-picker clearable
                                v-model="form.amortizeStartMonth"
                                type="month"
                                value-format="yyyy-MM"
                                placeholder="请选择摊销起始月份">
                </el-date-picker>
              </el-form-item>
            </el-col>

            <el-col :span="10">
              <el-form-item label="摊销结束月份" prop="amortizeEndMonth">
                <el-date-picker clearable
                                v-model="form.amortizeEndMonth"
                                type="month"
                                value-format="yyyy-MM"
                                placeholder="请选择摊销结束月份">
                </el-date-picker>
              </el-form-item>
            </el-col>

            <el-col :span="10">
              <el-form-item label="本月摊销金额" prop="instantAmortizedMoney" hidden>
                <el-input v-model="form.instantAmortizedMoney" placeholder="请输入本月摊销金额" />
              </el-form-item>
            </el-col>

            <el-col :span="10">
              <el-form-item label="已摊销月数" prop="alreadyAmortizedMonths" hidden>
                <el-input v-model="form.alreadyAmortizedMonths" placeholder="请输入已摊销月数" />
              </el-form-item>
            </el-col>

            <el-col :span="10">
              <el-form-item label="已摊销金额" prop="alreadyAmortizedMoney" hidden>
                <el-input v-model="form.alreadyAmortizedMoney" placeholder="请输入已摊销金额" />
              </el-form-item>
            </el-col>
        </el-row>

          <el-row>

            <el-col :span="10">
              <el-form-item label="核算维度" prop="dimensionOfAccounting">
                <el-input v-model="form.dimensionOfAccounting" placeholder="请输入核算维度" />
              </el-form-item>
            </el-col>

            <el-col :span="10">
              <el-form-item label="余额" prop="balance" hidden>
                <el-input v-model="form.balance" placeholder="请输入余额" />
              </el-form-item>
            </el-col>

            <el-form-item label="单据状态" prop="documentStatus" hidden>
              <el-select v-model="form.documentStatus" placeholder="请选择单据状态">
                <el-option
                  v-for="dict in dict.type.cb_document_status"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-row>


          <el-row>
            <el-col :span="10">
              <el-form-item label="备注" prop="remake">
                <el-input v-model="form.remake" placeholder="请输入备注" />
              </el-form-item>
            </el-col>
          </el-row>

        </el-row>




      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listCbRentInvoices,
  getCbRentInvoices,
  delCbRentInvoices,
  addCbRentInvoices,
  updateCbRentInvoices,
  deptTreeSelect,
  checkCbRentInvoices,
  onCheckCbRentInvoices
} from "@/api/system/cb/cbRentInvoices";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

export default {
  name: "CbRentInvoices",
  dicts: ['cb_document_status'],
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
      // 租金录入单据表格数据
      cbRentInvoicesList: [],
      // 弹出层标题
      title: "",
      // 部门树选项
      deptOptions: undefined,
      // 部门名称
      deptName: undefined,
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        cbYear: null,
        cbMonth: null,
        businessDate: null,
        hoggeryId: null,
        hoggeryName: null,
        companyId: null,
        companyName: null,
        costTypes: null,
        initialAssetValue: null,
        amortizeMonths: null,
        amortizeStartMonth: null,
        amortizeEndMonth: null,
        instantAmortizedMoney: null,
        alreadyAmortizedMonths: null,
        alreadyAmortizedMoney: null,
        dimensionOfAccounting: null,
        balance: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remake: null,
        deptId: undefined
      },

      // 列信息
      columns: [
        { key: 0, label: `ID`, visible: false },
        { key: 1, label: `年`, visible: false },
        { key: 2, label: `月`, visible: false },
        { key: 3, label: `业务日期`, visible: true },
        { key: 4, label: `资产名称`, visible: true },
        { key: 5, label: `场别ID`, visible: false },
        { key: 6, label: `场别名称`, visible: true },
        { key: 7, label: `公司ID`, visible: false },
        { key: 8, label: `公司名称`, visible: true },
        { key: 9, label: `费用类型`, visible: true },
        { key: 10, label: `资产原值`, visible: true },
        { key: 11, label: `摊销月数`, visible: false },
        { key: 12, label: `摊销起始月份`, visible: true },
        { key: 13, label: `摊销结束月份`, visible: true },
        { key: 14, label: `本月摊销金额`, visible: false },
        { key: 15, label: `已摊销月数`, visible: false },
        { key: 16, label: `已摊销金额`, visible: false },
        { key: 17, label: `核算维度`, visible: true },
        { key: 18, label: `余额`, visible: false },
        { key: 19, label: `单据状态`, visible: true },
        { key: 20, label: `备注`, visible: true }
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
    /** 查询租金录入单据列表 */
    getList() {
      this.loading = true;
      listCbRentInvoices(this.queryParams).then(response => {
        this.cbRentInvoicesList = response.rows;
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
        businessDate: null,
        hoggeryId: null,
        hoggeryName: null,
        companyId: null,
        companyName: null,
        costTypes: null,
        initialAssetValue: null,
        amortizeMonths: null,
        amortizeStartMonth: null,
        amortizeEndMonth: null,
        instantAmortizedMoney: null,
        alreadyAmortizedMonths: null,
        alreadyAmortizedMoney: null,
        dimensionOfAccounting: null,
        balance: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remake: null
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
      this.title = "添加租金录入单据";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCbRentInvoices(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改租金录入单据";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCbRentInvoices(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCbRentInvoices(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除租金录入单据编号为"' + ids + '"的数据项？').then(function() {
        return delCbRentInvoices(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/cb/cbRentInvoices/export', {
        ...this.queryParams
      }, `cbRentInvoices_${new Date().getTime()}.xlsx`)
    },

    /** 审核按钮操作 */
    handleCheck(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认审核租金录入单据编号为"' + ids + '"的数据项？').then(function() {
        return checkCbRentInvoices(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("审核成功");
      }).catch(() => {});
    },

    /** 审核按钮操作 */
    handleOnCheck(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认反租金录入单据编号为"' + ids + '"的数据项？').then(function() {
        return onCheckCbRentInvoices(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("反审核成功");
      }).catch(() => {});
    },


  }
};
</script>
