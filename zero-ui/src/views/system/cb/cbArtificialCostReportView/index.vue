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
      <el-form-item label="种类" prop="variety">
        <el-input
          v-model="queryParams.variety"
          placeholder="请输入种类"
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
      <el-form-item label="平均-合计" prop="avgOrTotal">
        <el-input
          v-model="queryParams.avgOrTotal"
          placeholder="请输入平均-合计"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="一月" prop="jan">
        <el-input
          v-model="queryParams.jan"
          placeholder="请输入一月"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="二月" prop="february">
        <el-input
          v-model="queryParams.february"
          placeholder="请输入二月"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="三月" prop="march">
        <el-input
          v-model="queryParams.march"
          placeholder="请输入三月"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="四月" prop="april">
        <el-input
          v-model="queryParams.april"
          placeholder="请输入四月"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="五月" prop="may">
        <el-input
          v-model="queryParams.may"
          placeholder="请输入五月"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="六月" prop="june">
        <el-input
          v-model="queryParams.june"
          placeholder="请输入六月"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="七月" prop="july">
        <el-input
          v-model="queryParams.july"
          placeholder="请输入七月"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="八月" prop="august">
        <el-input
          v-model="queryParams.august"
          placeholder="请输入八月"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="九月" prop="september">
        <el-input
          v-model="queryParams.september"
          placeholder="请输入九月"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="十月" prop="october">
        <el-input
          v-model="queryParams.october"
          placeholder="请输入十月"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="十一月" prop="november">
        <el-input
          v-model="queryParams.november"
          placeholder="请输入十一月"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="十二月" prop="december">
        <el-input
          v-model="queryParams.december"
          placeholder="请输入十二月"
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
          v-hasPermi="['system:cbArtificialCostReportView:add']"
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
          v-hasPermi="['system:cbArtificialCostReportView:edit']"
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
          v-hasPermi="['system:cbArtificialCostReportView:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:cbArtificialCostReportView:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="cbArtificialCostReportViewList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="类型" align="center" prop="type" />
      <el-table-column label="项目" align="center" prop="project" />
      <el-table-column label="种类" align="center" prop="variety" />
      <el-table-column label="年份" align="center" prop="cbYear" />
      <el-table-column label="组织ID" align="center" prop="hoggeryId" />
      <el-table-column label="平均-合计" align="center" prop="avgOrTotal" />
      <el-table-column label="一月" align="center" prop="jan" />
      <el-table-column label="二月" align="center" prop="february" />
      <el-table-column label="三月" align="center" prop="march" />
      <el-table-column label="四月" align="center" prop="april" />
      <el-table-column label="五月" align="center" prop="may" />
      <el-table-column label="六月" align="center" prop="june" />
      <el-table-column label="七月" align="center" prop="july" />
      <el-table-column label="八月" align="center" prop="august" />
      <el-table-column label="九月" align="center" prop="september" />
      <el-table-column label="十月" align="center" prop="october" />
      <el-table-column label="十一月" align="center" prop="november" />
      <el-table-column label="十二月" align="center" prop="december" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:cbArtificialCostReportView:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:cbArtificialCostReportView:remove']"
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

    <!-- 添加或修改人工成本计算视图对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目" prop="project">
          <el-input v-model="form.project" placeholder="请输入项目" />
        </el-form-item>
        <el-form-item label="种类" prop="variety">
          <el-input v-model="form.variety" placeholder="请输入种类" />
        </el-form-item>
        <el-form-item label="年份" prop="cbYear">
          <el-input v-model="form.cbYear" placeholder="请输入年份" />
        </el-form-item>
        <el-form-item label="组织ID" prop="hoggeryId">
          <el-input v-model="form.hoggeryId" placeholder="请输入组织ID" />
        </el-form-item>
        <el-form-item label="平均-合计" prop="avgOrTotal">
          <el-input v-model="form.avgOrTotal" placeholder="请输入平均-合计" />
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
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCbArtificialCostReportView, getCbArtificialCostReportView, delCbArtificialCostReportView, addCbArtificialCostReportView, updateCbArtificialCostReportView } from "@/api/system/cb/cbArtificialCostReportView";

export default {
  name: "CbArtificialCostReportView",
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
      // 人工成本计算视图表格数据
      cbArtificialCostReportViewList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        type: null,
        project: null,
        variety: null,
        cbYear: null,
        hoggeryId: null,
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
        december: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        type: [
          { required: true, message: "类型不能为空", trigger: "change" }
        ],
        project: [
          { required: true, message: "项目不能为空", trigger: "blur" }
        ],
        variety: [
          { required: true, message: "种类不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询人工成本计算视图列表 */
    getList() {
      this.loading = true;
      listCbArtificialCostReportView(this.queryParams).then(response => {
        this.cbArtificialCostReportViewList = response.rows;
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
        type: null,
        project: null,
        variety: null,
        cbYear: null,
        hoggeryId: null,
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
        december: null
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
      this.ids = selection.map(item => item.type)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加人工成本计算视图";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const type = row.type || this.ids
      getCbArtificialCostReportView(type).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改人工成本计算视图";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.type != null) {
            updateCbArtificialCostReportView(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCbArtificialCostReportView(this.form).then(response => {
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
      const types = row.type || this.ids;
      this.$modal.confirm('是否确认删除人工成本计算视图编号为"' + types + '"的数据项？').then(function() {
        return delCbArtificialCostReportView(types);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/cbArtificialCostReportView/export', {
        ...this.queryParams
      }, `cbArtificialCostReportView_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
