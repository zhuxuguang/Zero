<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
<!--      <el-form-item label="源单ID" prop="fid">-->
<!--        <el-input-->
<!--          v-model="queryParams.fid"-->
<!--          placeholder="请输入源单ID"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="单据编号" prop="fbillno">
        <el-input
          v-model="queryParams.fbillno"
          placeholder="请输入单据编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="业务日期" prop="fdate">
        <el-date-picker clearable
          v-model="queryParams.fdate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择业务日期">
        </el-date-picker>
      </el-form-item>
<!--      <el-form-item label="发料组织ID" prop="fstockorgId">-->
<!--        <el-input-->
<!--          v-model="queryParams.fstockorgId"-->
<!--          placeholder="请输入发料组织ID"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="发料组织名称" prop="fstockorgName">
        <el-input
          v-model="queryParams.fstockorgName"
          placeholder="请输入发料组织名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物料编码" prop="fmaterialId">
        <el-input
          v-model="queryParams.fmaterialId"
          placeholder="请输入物料编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物料名称" prop="fmaterialName">
        <el-input
          v-model="queryParams.fmaterialName"
          placeholder="请输入物料名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="跨组织业务类型" prop="ftransferbiztypeId">-->
<!--        <el-input-->
<!--          v-model="queryParams.ftransferbiztypeId"-->
<!--          placeholder="请输入跨组织业务类型"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="规格" prop="fspecification">-->
<!--        <el-input-->
<!--          v-model="queryParams.fspecification"-->
<!--          placeholder="请输入规格"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="单位编号" prop="funitid">-->
<!--        <el-input-->
<!--          v-model="queryParams.funitid"-->
<!--          placeholder="请输入单位编号"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="实发数量" prop="factualqty">-->
<!--        <el-input-->
<!--          v-model="queryParams.factualqty"-->
<!--          placeholder="请输入实发数量"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="栋舍" prop="fds">-->
<!--        <el-input-->
<!--          v-model="queryParams.fds"-->
<!--          placeholder="请输入栋舍"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="仓库" prop="fstockId">-->
<!--        <el-input-->
<!--          v-model="queryParams.fstockId"-->
<!--          placeholder="请输入仓库"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="总成本" prop="famount">-->
<!--        <el-input-->
<!--          v-model="queryParams.famount"-->
<!--          placeholder="请输入总成本"-->
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
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="primary"-->
<!--          plain-->
<!--          icon="el-icon-plus"-->
<!--          size="mini"-->
<!--          @click="handleAdd"-->
<!--          v-hasPermi="['system:k3SpPickmtrl:add']"-->
<!--        >新增</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="success"-->
<!--          plain-->
<!--          icon="el-icon-edit"-->
<!--          size="mini"-->
<!--          :disabled="single"-->
<!--          @click="handleUpdate"-->
<!--          v-hasPermi="['system:k3SpPickmtrl:edit']"-->
<!--        >修改</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="danger"-->
<!--          plain-->
<!--          icon="el-icon-delete"-->
<!--          size="mini"-->
<!--          :disabled="multiple"-->
<!--          @click="handleDelete"-->
<!--          v-hasPermi="['system:k3SpPickmtrl:remove']"-->
<!--        >删除</el-button>-->
<!--      </el-col>-->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:k3SpPickmtrl:export']"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-loading"
          size="mini"
          @click="handleWebApi"
          v-hasPermi="['system:k3SpPickmtrl:webapi']"
        >同步</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="k3SpPickmtrlList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="源单ID" align="center" prop="fid" />
      <el-table-column label="单据编号" align="center" prop="fbillno" />
      <el-table-column label="业务日期" align="center" prop="fdate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.fdate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="单据状态" align="center" prop="fdocumentStatus" />
      <el-table-column label="发料组织ID" align="center" prop="fstockorgId" />
      <el-table-column label="发料组织名称" align="center" prop="fstockorgName" />
      <el-table-column label="物料内码" align="center" prop="fmaterialId" />
      <el-table-column label="物料名称" align="center" prop="fmaterialName" />
      <el-table-column label="跨组织业务类型" align="center" prop="ftransferbiztypeId" />
      <el-table-column label="规格" align="center" prop="fspecification" />
      <el-table-column label="单位编号" align="center" prop="funitid" />
      <el-table-column label="实发数量" align="center" prop="factualqty" />
      <el-table-column label="栋舍" align="center" prop="fds" />
      <el-table-column label="仓库" align="center" prop="fstockId" />
      <el-table-column label="总成本" align="center" prop="famount" />
      <el-table-column label="创建者" align="center" prop="createBy" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新者" align="center" prop="updateBy" />
      <el-table-column label="更新时间" align="center" prop="updateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:k3SpPickmtrl:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:k3SpPickmtrl:remove']"
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

    <!-- 添加或修改第三方简单生产领料单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="源单ID" prop="fid">
          <el-input v-model="form.fid" placeholder="请输入源单ID" />
        </el-form-item>
        <el-form-item label="单据编号" prop="fbillno">
          <el-input v-model="form.fbillno" placeholder="请输入单据编号" />
        </el-form-item>
        <el-form-item label="业务日期" prop="fdate">
          <el-date-picker clearable
            v-model="form.fdate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择业务日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="发料组织ID" prop="fstockorgId">
          <el-input v-model="form.fstockorgId" placeholder="请输入发料组织ID" />
        </el-form-item>
        <el-form-item label="发料组织名称" prop="fstockorgName">
          <el-input v-model="form.fstockorgName" placeholder="请输入发料组织名称" />
        </el-form-item>
        <el-form-item label="物料编码" prop="fmaterialId">
          <el-input v-model="form.fmaterialId" placeholder="请输入物料编码" />
        </el-form-item>
        <el-form-item label="物料名称" prop="fmaterialName">
          <el-input v-model="form.fmaterialName" placeholder="请输入物料名称" />
        </el-form-item>
        <el-form-item label="跨组织业务类型" prop="ftransferbiztypeId">
          <el-input v-model="form.ftransferbiztypeId" placeholder="请输入跨组织业务类型" />
        </el-form-item>
        <el-form-item label="规格" prop="fspecification">
          <el-input v-model="form.fspecification" placeholder="请输入规格" />
        </el-form-item>
        <el-form-item label="单位编号" prop="funitid">
          <el-input v-model="form.funitid" placeholder="请输入单位编号" />
        </el-form-item>
        <el-form-item label="实发数量" prop="factualqty">
          <el-input v-model="form.factualqty" placeholder="请输入实发数量" />
        </el-form-item>
        <el-form-item label="栋舍" prop="fds">
          <el-input v-model="form.fds" placeholder="请输入栋舍" />
        </el-form-item>
        <el-form-item label="仓库" prop="fstockId">
          <el-input v-model="form.fstockId" placeholder="请输入仓库" />
        </el-form-item>
        <el-form-item label="总成本" prop="famount">
          <el-input v-model="form.famount" placeholder="请输入总成本" />
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
import { listK3SpPickmtrl, getK3SpPickmtrl, delK3SpPickmtrl, addK3SpPickmtrl, updateK3SpPickmtrl, k3WebApiAcquire } from "@/api/system/k3cloud/k3SpPickmtrl";

export default {
  name: "K3SpPickmtrl",
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
      // 第三方简单生产领料单表格数据
      k3SpPickmtrlList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        fid: null,
        fbillno: null,
        fdate: null,
        fdocumentStatus: null,
        fstockorgId: null,
        fstockorgName: null,
        fmaterialId: null,
        fmaterialName: null,
        ftransferbiztypeId: null,
        fspecification: null,
        funitid: null,
        factualqty: null,
        fds: null,
        fstockId: null,
        famount: null,
      },
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
    /** 查询第三方简单生产领料单列表 */
    getList() {
      this.loading = true;
      listK3SpPickmtrl(this.queryParams).then(response => {
        this.k3SpPickmtrlList = response.rows;
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
        fid: null,
        fbillno: null,
        fdate: null,
        fdocumentStatus: null,
        fstockorgId: null,
        fstockorgName: null,
        fmaterialId: null,
        fmaterialName: null,
        ftransferbiztypeId: null,
        fspecification: null,
        funitid: null,
        factualqty: null,
        fds: null,
        fstockId: null,
        famount: null,
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
      this.title = "添加第三方简单生产领料单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getK3SpPickmtrl(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改第三方简单生产领料单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateK3SpPickmtrl(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addK3SpPickmtrl(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除第三方简单生产领料单编号为"' + ids + '"的数据项？').then(function() {
        return delK3SpPickmtrl(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/k3cloud/k3SpPickmtrl/export', {
        ...this.queryParams
      }, `k3SpPickmtrl_${new Date().getTime()}.xlsx`)
    },
    /** 获取部分数据 */
    handleWebApi() {
      this.$modal.loading("正在同步数据，请稍后...");
      k3WebApiAcquire();
      this.getList();
      this.$modal.closeLoading("已完成同步");
    },
  }
}
</script>
