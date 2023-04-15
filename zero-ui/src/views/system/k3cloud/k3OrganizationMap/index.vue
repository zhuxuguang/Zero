<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="本地组织ID" prop="deptId">
        <el-input
          v-model="queryParams.deptId"
          placeholder="请输入本地组织ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="第三方组织内码" prop="k3Forgid">
        <el-input
          v-model="queryParams.k3Forgid"
          placeholder="请输入第三方组织内码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="第三方组织编码" prop="k3Fnumber">
        <el-input
          v-model="queryParams.k3Fnumber"
          placeholder="请输入第三方组织编码"
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
          v-hasPermi="['system:k3OrganizationMap:add']"
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
          v-hasPermi="['system:k3OrganizationMap:edit']"
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
          v-hasPermi="['system:k3OrganizationMap:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:k3OrganizationMap:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="k3OrganizationMapList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="本地组织ID" align="center" prop="deptId" />
      <el-table-column label="本地组织名称" align="center" prop="deptName" />
      <el-table-column label="第三方组织内码" align="center" prop="k3Forgid" />
      <el-table-column label="第三方组织编码" align="center" prop="k3Fnumber" />
      <el-table-column label="第三方组织名称" align="center" prop="fname" />
      <el-table-column label="创建者" align="center" prop="createBy" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新着" align="center" prop="updateBy" />
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
            v-hasPermi="['system:k3OrganizationMap:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:k3OrganizationMap:remove']"
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

    <!-- 添加或修改组织间映射对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-form-item label="本地组织" prop="deptId" label-width="150px">
            <treeselect v-model="form.deptId" :options="deptOptions" :show-count="true" placeholder="请选择本地组织" />
          </el-form-item>
          <el-form-item label="第三方组织" label-width="150px">
            <el-select v-model="form.k3Forgid" filterable placeholder="请输入第三方组织" style="width: 510px">
              <el-option
                v-for="item in k3Os"
                :key="item.forgid"
                :label="item.fname"
                :value="item.forgid"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="第三方组织编码" prop="k3Fnumber" label-width="150px" hidden>
            <el-input v-model="form.k3Fnumber" placeholder="请输入第三方组织编码" />
          </el-form-item>
          <el-form-item label="备注" prop="remark" label-width="150px">
            <el-input v-model="form.remark" placeholder="请输入备注" />
          </el-form-item>
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
  listK3OrganizationMap,
  getK3OrganizationMap,
  delK3OrganizationMap,
  addK3OrganizationMap,
  updateK3OrganizationMap,
  deptTreeSelect, k3OrganizationSelect
} from "@/api/system/k3cloud/k3OrganizationMap";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";
export default {
  name: "K3OrganizationMap",
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
      // 组织间映射表格数据
      k3OrganizationMapList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 部门树选项
      deptOptions: undefined,
      // 第三方组织选项
      k3Os: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        deptId: null,
        k3Forgid: null,
        k3Fnumber: null,
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
    this.getDeptTree();
  },
  methods: {
    /** 查询组织间映射列表 */
    getList() {
      this.loading = true;
      listK3OrganizationMap(this.queryParams).then(response => {
        this.k3OrganizationMapList = response.rows;
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
        deptId: null,
        k3Forgid: null,
        k3Fnumber: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        forgids: []
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
      k3OrganizationSelect().then(response => {
        this.k3Os = response.k3Organizations;
        this.open = true;
        this.title = "添加组织间映射";
      });
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getK3OrganizationMap(id).then(response => {
        this.form = response.data;
        this.k3Os = response.k3Organizations;
        this.$set(this.form, "k3Forgid", response.k3Forgid);
        this.open = true;
        this.title = "修改组织间映射";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateK3OrganizationMap(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addK3OrganizationMap(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除组织间映射编号为"' + ids + '"的数据项？').then(function() {
        return delK3OrganizationMap(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/k3cloud/k3OrganizationMap/export', {
        ...this.queryParams
      }, `k3OrganizationMap_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
