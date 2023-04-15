<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="物料内码" prop="fmaterialId">
        <el-input
          v-model="queryParams.fmaterialId"
          placeholder="请输入物料内码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物料编码" prop="fnumber">
        <el-input
          v-model="queryParams.fnumber"
          placeholder="请输入物料编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物料名称" prop="fname">
        <el-input
          v-model="queryParams.fname"
          placeholder="请输入物料名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="存货类别ID" prop="fcategoryId">-->
<!--        <el-input-->
<!--          v-model="queryParams.fcategoryId"-->
<!--          placeholder="请输入存货类别ID"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="存货类别名称" prop="fcategoryName">
        <el-input
          v-model="queryParams.fcategoryName"
          placeholder="请输入存货类别名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="创建组织ID" prop="fcreateorgId">-->
<!--        <el-input-->
<!--          v-model="queryParams.fcreateorgId"-->
<!--          placeholder="请输入创建组织ID"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="创建组织名称" prop="fcreateorgName">
        <el-input
          v-model="queryParams.fcreateorgName"
          placeholder="请输入创建组织名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="使用组织ID" prop="fuseorgId">-->
<!--        <el-input-->
<!--          v-model="queryParams.fuseorgId"-->
<!--          placeholder="请输入使用组织ID"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="使用组织名称" prop="fuseorgName">
        <el-input
          v-model="queryParams.fuseorgName"
          placeholder="请输入使用组织名称"
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
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="primary"-->
<!--          plain-->
<!--          icon="el-icon-plus"-->
<!--          size="mini"-->
<!--          @click="handleAdd"-->
<!--          v-hasPermi="['system:k3BdMaterialbase:add']"-->
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
<!--          v-hasPermi="['system:k3BdMaterialbase:edit']"-->
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
<!--          v-hasPermi="['system:k3BdMaterialbase:remove']"-->
<!--        >删除</el-button>-->
<!--      </el-col>-->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:k3BdMaterialbase:export']"
        >导出</el-button>
      </el-col>

      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-loading"
          size="mini"
          @click="handleWebApi"
          v-hasPermi="['system:k3BdMaterialbase:webapi']"
        >同步</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="k3BdMaterialbaseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="物料内码" align="center" prop="fmaterialId" />
      <el-table-column label="物料编码" align="center" prop="fnumber" />
      <el-table-column label="物料名称" align="center" prop="fname" />
      <el-table-column label="存货类别ID" align="center" prop="fcategoryId" />
      <el-table-column label="存货类别名称" align="center" prop="fcategoryName" />
      <el-table-column label="创建组织ID" align="center" prop="fcreateorgId" />
      <el-table-column label="创建组织名称" align="center" prop="fcreateorgName" />
      <el-table-column label="使用组织ID" align="center" prop="fuseorgId" />
      <el-table-column label="使用组织名称" align="center" prop="fuseorgName" />
      <el-table-column label="禁用状态" align="center" prop="fforbidStatus" />
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
            v-hasPermi="['system:k3BdMaterialbase:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:k3BdMaterialbase:remove']"
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

    <!-- 添加或修改存储物料信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="物料内码" prop="fmaterialId">
          <el-input v-model="form.fmaterialId" placeholder="请输入物料内码" />
        </el-form-item>
        <el-form-item label="物料编码" prop="fnumber">
          <el-input v-model="form.fnumber" placeholder="请输入物料编码" />
        </el-form-item>
        <el-form-item label="物料名称" prop="fname">
          <el-input v-model="form.fname" placeholder="请输入物料名称" />
        </el-form-item>
        <el-form-item label="存货类别ID" prop="fcategoryId">
          <el-input v-model="form.fcategoryId" placeholder="请输入存货类别ID" />
        </el-form-item>
        <el-form-item label="存货类别名称" prop="fcategoryName">
          <el-input v-model="form.fcategoryName" placeholder="请输入存货类别名称" />
        </el-form-item>
        <el-form-item label="创建组织ID" prop="fcreateorgId">
          <el-input v-model="form.fcreateorgId" placeholder="请输入创建组织ID" />
        </el-form-item>
        <el-form-item label="创建组织名称" prop="fcreateorgName">
          <el-input v-model="form.fcreateorgName" placeholder="请输入创建组织名称" />
        </el-form-item>
        <el-form-item label="使用组织ID" prop="fuseorgId">
          <el-input v-model="form.fuseorgId" placeholder="请输入使用组织ID" />
        </el-form-item>
        <el-form-item label="使用组织名称" prop="fuseorgName">
          <el-input v-model="form.fuseorgName" placeholder="请输入使用组织名称" />
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
import { listK3BdMaterialbase, getK3BdMaterialbase, delK3BdMaterialbase, addK3BdMaterialbase, updateK3BdMaterialbase, k3WebApiAcquire } from "@/api/system/k3cloud/k3BdMaterialbase";

export default {
  name: "K3BdMaterialbase",
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
      // 存储物料信息表格数据
      k3BdMaterialbaseList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        fmaterialId: null,
        fnumber: null,
        fname: null,
        fcategoryId: null,
        fcategoryName: null,
        fcreateorgId: null,
        fcreateorgName: null,
        fuseorgId: null,
        fuseorgName: null,
        fforbidStatus: null,
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
    /** 查询存储物料信息列表 */
    getList() {
      this.loading = true;
      listK3BdMaterialbase(this.queryParams).then(response => {
        this.k3BdMaterialbaseList = response.rows;
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
        fmaterialId: null,
        fnumber: null,
        fname: null,
        fcategoryId: null,
        fcategoryName: null,
        fcreateorgId: null,
        fcreateorgName: null,
        fuseorgId: null,
        fuseorgName: null,
        fforbidStatus: null,
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
      this.title = "添加存储物料信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getK3BdMaterialbase(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改存储物料信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateK3BdMaterialbase(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addK3BdMaterialbase(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除存储物料信息编号为"' + ids + '"的数据项？').then(function() {
        return delK3BdMaterialbase(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/k3cloud/k3BdMaterialbase/export', {
        ...this.queryParams
      }, `k3BdMaterialbase_${new Date().getTime()}.xlsx`)
    },
    /** 获取部分数据 */
    handleWebApi() {
      k3WebApiAcquire();
      this.getList();
      this.$modal.msgSuccess("数据更新成功");
    },
  }
};
</script>
