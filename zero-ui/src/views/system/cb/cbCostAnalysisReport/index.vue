<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="项目" prop="project">
        <el-input
          v-model="queryParams.project"
          placeholder="请输入项目"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年份" prop="cbYear">
        <el-input
          v-model="queryParams.cbYear"
          placeholder="请输入年份"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="组织ID" prop="hoggeryId">
        <el-input
          v-model="queryParams.hoggeryId"
          placeholder="请输入组织ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="组织名称" prop="hoggeryName">
        <el-input
          v-model="queryParams.hoggeryName"
          placeholder="请输入组织名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="平均/合计" prop="avgOrTotal">-->
<!--        <el-input-->
<!--          v-model="queryParams.avgOrTotal"-->
<!--          placeholder="请输入平均/合计"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="一月" prop="jan">-->
<!--        <el-input-->
<!--          v-model="queryParams.jan"-->
<!--          placeholder="请输入一月"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="二月" prop="february">-->
<!--        <el-input-->
<!--          v-model="queryParams.february"-->
<!--          placeholder="请输入二月"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="三月" prop="march">-->
<!--        <el-input-->
<!--          v-model="queryParams.march"-->
<!--          placeholder="请输入三月"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="四月" prop="april">-->
<!--        <el-input-->
<!--          v-model="queryParams.april"-->
<!--          placeholder="请输入四月"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="五月" prop="may">-->
<!--        <el-input-->
<!--          v-model="queryParams.may"-->
<!--          placeholder="请输入五月"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="六月" prop="june">-->
<!--        <el-input-->
<!--          v-model="queryParams.june"-->
<!--          placeholder="请输入六月"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="七月" prop="july">-->
<!--        <el-input-->
<!--          v-model="queryParams.july"-->
<!--          placeholder="请输入七月"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="八月" prop="august">-->
<!--        <el-input-->
<!--          v-model="queryParams.august"-->
<!--          placeholder="请输入八月"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="九月" prop="september">-->
<!--        <el-input-->
<!--          v-model="queryParams.september"-->
<!--          placeholder="请输入九月"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="十月" prop="october">-->
<!--        <el-input-->
<!--          v-model="queryParams.october"-->
<!--          placeholder="请输入十月"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="十一月" prop="november">-->
<!--        <el-input-->
<!--          v-model="queryParams.november"-->
<!--          placeholder="请输入十一月"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="十二月" prop="december">-->
<!--        <el-input-->
<!--          v-model="queryParams.december"-->
<!--          placeholder="请输入十二月"-->
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
          v-hasPermi="['system:cbCostAnalysisReport:add']"
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
          v-hasPermi="['system:cbCostAnalysisReport:edit']"
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
          v-hasPermi="['system:cbCostAnalysisReport:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:cbCostAnalysisReport:export']"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-s-release"
          size="mini"
          @click="handleAcquire"
          v-hasPermi="['system:cbCostAnalysisReport:acquire']"
        >获取</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="cbCostAnalysisReportList" @selection-change="handleSelectionChange">
      <el-table-column label="选项" type="selection" width="55" align="center"  v-if="columns[0].visible"/>
      <el-table-column label="ID" align="center" prop="id" v-if="columns[1].visible" />
      <el-table-column label="类型" align="center" prop="cbType" v-if="columns[2].visible" />
      <el-table-column label="项目" align="center" prop="project" v-if="columns[3].visible" />
      <el-table-column label="种类" align="center" prop="variety" v-if="columns[4].visible" />
      <el-table-column label="年份" align="center" prop="cbYear" v-if="columns[5].visible" />
      <el-table-column label="组织ID" align="center" prop="hoggeryId" v-if="columns[6].visible" />
      <el-table-column label="组织名称" align="center" prop="hoggeryName" v-if="columns[7].visible" />
      <el-table-column label="平均/合计" align="center" prop="avgOrTotal" v-if="columns[8].visible" />
      <el-table-column label="一月" align="center" prop="jan" v-if="columns[9].visible" />
      <el-table-column label="二月" align="center" prop="february" v-if="columns[10].visible" />
      <el-table-column label="三月" align="center" prop="march" v-if="columns[11].visible" />
      <el-table-column label="四月" align="center" prop="april" v-if="columns[12].visible" />
      <el-table-column label="五月" align="center" prop="may" v-if="columns[13].visible" />
      <el-table-column label="六月" align="center" prop="june" v-if="columns[14].visible" />
      <el-table-column label="七月" align="center" prop="july" v-if="columns[15].visible" />
      <el-table-column label="八月" align="center" prop="august" v-if="columns[16].visible" />
      <el-table-column label="九月" align="center" prop="september" v-if="columns[17].visible" />
      <el-table-column label="十月" align="center" prop="october" v-if="columns[18].visible" />
      <el-table-column label="十一月" align="center" prop="november" v-if="columns[19].visible" />
      <el-table-column label="十二月" align="center" prop="december" v-if="columns[20].visible" />
      <el-table-column label="备注" align="center" prop="remark" v-if="columns[21].visible" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" v-if="columns[22].visible" >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:cbCostAnalysisReport:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:cbCostAnalysisReport:remove']"
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

    <!-- 添加或修改成本分析报表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目" prop="project">
          <el-input v-model="form.project" placeholder="请输入项目" />
        </el-form-item>
        <el-form-item label="年份" prop="cbYear">
          <el-input v-model="form.cbYear" placeholder="请输入年份" />
        </el-form-item>
        <el-form-item label="组织ID" prop="hoggeryId">
          <el-input v-model="form.hoggeryId" placeholder="请输入组织ID" />
        </el-form-item>
        <el-form-item label="组织名称" prop="hoggeryName">
          <el-input v-model="form.hoggeryName" placeholder="请输入组织名称" />
        </el-form-item>
        <el-form-item label="平均/合计" prop="avgOrTotal">
          <el-input v-model="form.avgOrTotal" placeholder="请输入平均/合计" />
        </el-form-item>
        <el-form-item label="一月" prop="jan">
          <el-input v-model="form.jan" placeholder="请输入一月" />
        </el-form-item>
        <el-form-item label="二月" prop="february">
          <el-input v-model="form.february" placeholder="请输入二月" />
        </el-form-item>
        <el-form-item label="三月" prop="march">
          <el-input v-model="form.march" placeholder="请输入三月" />
        </el-form-item>
        <el-form-item label="四月" prop="april">
          <el-input v-model="form.april" placeholder="请输入四月" />
        </el-form-item>
        <el-form-item label="五月" prop="may">
          <el-input v-model="form.may" placeholder="请输入五月" />
        </el-form-item>
        <el-form-item label="六月" prop="june">
          <el-input v-model="form.june" placeholder="请输入六月" />
        </el-form-item>
        <el-form-item label="七月" prop="july">
          <el-input v-model="form.july" placeholder="请输入七月" />
        </el-form-item>
        <el-form-item label="八月" prop="august">
          <el-input v-model="form.august" placeholder="请输入八月" />
        </el-form-item>
        <el-form-item label="九月" prop="september">
          <el-input v-model="form.september" placeholder="请输入九月" />
        </el-form-item>
        <el-form-item label="十月" prop="october">
          <el-input v-model="form.october" placeholder="请输入十月" />
        </el-form-item>
        <el-form-item label="十一月" prop="november">
          <el-input v-model="form.november" placeholder="请输入十一月" />
        </el-form-item>
        <el-form-item label="十二月" prop="december">
          <el-input v-model="form.december" placeholder="请输入十二月" />
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
  </div>
</template>

<script>
import { listCbCostAnalysisReport, getCbCostAnalysisReport, delCbCostAnalysisReport, addCbCostAnalysisReport, updateCbCostAnalysisReport, acquireCbCostAnalysisReport } from "@/api/system/cb/cbCostAnalysisReport";

export default {
  name: "CbCostAnalysisReport",
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
      // 成本分析报表表格数据
      cbCostAnalysisReportList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        cbType: null,
        project: null,
        variety: null,
        cbYear: null,
        hoggeryId: null,
        hoggeryName: null,
        avgOrTotal: null,
        jan: null,
        february: null,
        march: null,
        april: null,
        may: null,
        june: null,
        july: null,
        august: null,
        september: null,
        october: null,
        november: null,
        december: null,
      },

      // 列信息
      columns: [
        { key: 0, label: `选项`, visible: false },
        { key: 1, label: `ID`, visible: false },
        { key: 2, label: `类型`, visible: true },
        { key: 3, label: `项目`, visible: true },
        { key: 4, label: `种类`, visible: true },
        { key: 5, label: `年份`, visible: true },
        { key: 6, label: `组织ID`, visible: true },
        { key: 7, label: `组织名称`, visible: true },
        { key: 8, label: `平均/合计`, visible: true },
        { key: 9, label: `一月`, visible: true },
        { key: 10, label: `二月`, visible: true },
        { key: 11, label: `三月`, visible: true },
        { key: 12, label: `四月`, visible: true },
        { key: 13, label: `五月`, visible: true },
        { key: 14, label: `六月`, visible: true },
        { key: 15, label: `七月`, visible: true },
        { key: 16, label: `八月`, visible: true },
        { key: 17, label: `九月`, visible: true },
        { key: 18, label: `十月`, visible: true },
        { key: 19, label: `十一月`, visible: true },
        { key: 20, label: `十二月`, visible: true },
        { key: 21, label: `备注`, visible: true },
        { key: 22, label: `操作`, visible: false },
        { key: 23, label: `创建人`, visible: false },
        { key: 24, label: `创建时间`, visible: false },
        { key: 25, label: `更新人`, visible: false },
        { key: 26, label: `更新时间`, visible: false }
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
    /** 查询成本分析报表列表 */
    getList() {
      this.loading = true;
      listCbCostAnalysisReport(this.queryParams).then(response => {
        this.cbCostAnalysisReportList = response.rows;
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
        cbType: null,
        project: null,
        variety: null,
        cbYear: null,
        hoggeryId: null,
        hoggeryName: null,
        avgOrTotal: null,
        jan: null,
        february: null,
        march: null,
        april: null,
        may: null,
        june: null,
        july: null,
        august: null,
        september: null,
        october: null,
        november: null,
        december: null,
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
      this.title = "添加成本分析报表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCbCostAnalysisReport(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改成本分析报表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCbCostAnalysisReport(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCbCostAnalysisReport(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除成本分析报表编号为"' + ids + '"的数据项？').then(function() {
        return delCbCostAnalysisReport(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/cb/cbCostAnalysisReport/export', {
        ...this.queryParams
      }, `cbCostAnalysisReport_${new Date().getTime()}.xlsx`)
    },

    /** 获取部分数据 */
    handleAcquire() {
      acquireCbCostAnalysisReport();
      this.getList();
      this.$modal.msgSuccess("数据更新成功");
    },
  }
};
</script>
