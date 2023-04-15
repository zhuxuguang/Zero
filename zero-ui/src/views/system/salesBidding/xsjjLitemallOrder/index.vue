<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="订单编号" prop="orderSn">
        <el-input
          v-model="queryParams.orderSn"
          placeholder="请输入订单编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="实付费用" prop="actualPrice">-->
<!--        <el-input-->
<!--          v-model="queryParams.actualPrice"-->
<!--          placeholder="请输入实付费用"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="车辆数" prop="vehicleNumber">-->
<!--        <el-input-->
<!--          v-model="queryParams.vehicleNumber"-->
<!--          placeholder="请输入车辆数"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="头数" prop="headNumber">-->
<!--        <el-input-->
<!--          v-model="queryParams.headNumber"-->
<!--          placeholder="请输入头数"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="原值1" prop="integralprice">-->
<!--        <el-input-->
<!--          v-model="queryParams.integralprice"-->
<!--          placeholder="请输入原值1"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="原值2" prop="freightprice">-->
<!--        <el-input-->
<!--          v-model="queryParams.freightprice"-->
<!--          placeholder="请输入原值2"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="订单费用" prop="orderPrice">-->
<!--        <el-input-->
<!--          v-model="queryParams.orderPrice"-->
<!--          placeholder="请输入订单费用"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="下单时间" prop="addTime">-->
<!--        <el-date-picker clearable-->
<!--          v-model="queryParams.addTime"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="请选择下单时间">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="下单用户ID" prop="userId">-->
<!--        <el-input-->
<!--          v-model="queryParams.userId"-->
<!--          placeholder="请输入下单用户ID"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="下单用户名称" prop="userName">-->
<!--        <el-input-->
<!--          v-model="queryParams.userName"-->
<!--          placeholder="请输入下单用户名称"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="用户头像" prop="userAvatar">-->
<!--        <el-input-->
<!--          v-model="queryParams.userAvatar"-->
<!--          placeholder="请输入用户头像"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="联系人" prop="consignee">-->
<!--        <el-input-->
<!--          v-model="queryParams.consignee"-->
<!--          placeholder="请输入联系人"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="联系地址" prop="address">-->
<!--        <el-input-->
<!--          v-model="queryParams.address"-->
<!--          placeholder="请输入联系地址"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="联系方式" prop="mobile">-->
<!--        <el-input-->
<!--          v-model="queryParams.mobile"-->
<!--          placeholder="请输入联系方式"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="商品名称" prop="goodsNamev">-->
<!--        <el-input-->
<!--          v-model="queryParams.goodsNamev"-->
<!--          placeholder="请输入商品名称"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="商品编号" prop="goodsSnv">-->
<!--        <el-input-->
<!--          v-model="queryParams.goodsSnv"-->
<!--          placeholder="请输入商品编号"-->
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
<!--          v-hasPermi="['system:xsjjLitemallOrder:add']"-->
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
<!--          v-hasPermi="['system:xsjjLitemallOrder:edit']"-->
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
<!--          v-hasPermi="['system:xsjjLitemallOrder:remove']"-->
<!--        >删除</el-button>-->
<!--      </el-col>-->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:xsjjLitemallOrder:export']"
        >导出</el-button>
      </el-col>

      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-s-release"
          size="mini"
          @click="handleAcquire"
          v-hasPermi="['system:xsjjLitemallOrder:acquire']"
        >获取</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="xsjjLitemallOrderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="订单编号" align="center" prop="orderSn" />
      <el-table-column label="订单状态" align="center" prop="orderStatus" />
      <el-table-column label="实付费用" align="center" prop="actualPrice" />
      <el-table-column label="车辆数" align="center" prop="vehicleNumber" />
      <el-table-column label="头数" align="center" prop="headNumber" />
      <el-table-column label="原值1" align="center" prop="integralprice" />
      <el-table-column label="原值2" align="center" prop="freightprice" />
      <el-table-column label="订单费用" align="center" prop="orderPrice" />
      <el-table-column label="下单时间" align="center" prop="addTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.addTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="下单用户ID" align="center" prop="userId" />
      <el-table-column label="下单用户名称" align="center" prop="userName" />
<!--      <el-table-column label="用户头像" align="center" prop="userAvatar" />-->
      <el-table-column label="用户头像" align="center" prop="userAvatar" width="180">
        <template slot-scope="scope">
          <el-avatar :src="scope.row.userAvatar" />
        </template>
      </el-table-column>
      <el-table-column label="联系人" align="center" prop="consignee" />
      <el-table-column label="联系地址" align="center" prop="address" />
      <el-table-column label="联系方式" align="center" prop="mobile" />
      <el-table-column label="用户订单留言" align="center" prop="message" />
      <el-table-column label="商品名称" align="center" prop="goodsNamev" />
      <el-table-column label="商品编号" align="center" prop="goodsSnv" />
      <el-table-column label="计算状态" align="center" prop="countStatus" />
      <el-table-column label="备注" align="center" prop="remark" />
<!--      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">-->
<!--        <template slot-scope="scope">-->
<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-edit"-->
<!--            @click="handleUpdate(scope.row)"-->
<!--            v-hasPermi="['system:xsjjLitemallOrder:edit']"-->
<!--          >修改</el-button>-->
<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-delete"-->
<!--            @click="handleDelete(scope.row)"-->
<!--            v-hasPermi="['system:xsjjLitemallOrder:remove']"-->
<!--          >删除</el-button>-->
<!--        </template>-->
<!--      </el-table-column>-->
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改销售竞价第三方订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="订单编号" prop="orderSn">
          <el-input v-model="form.orderSn" placeholder="请输入订单编号" />
        </el-form-item>
        <el-form-item label="实付费用" prop="actualPrice">
          <el-input v-model="form.actualPrice" placeholder="请输入实付费用" />
        </el-form-item>
        <el-form-item label="车辆数" prop="vehicleNumber">
          <el-input v-model="form.vehicleNumber" placeholder="请输入车辆数" />
        </el-form-item>
        <el-form-item label="头数" prop="headNumber">
          <el-input v-model="form.headNumber" placeholder="请输入头数" />
        </el-form-item>
        <el-form-item label="原值1" prop="integralprice">
          <el-input v-model="form.integralprice" placeholder="请输入原值1" />
        </el-form-item>
        <el-form-item label="原值2" prop="freightprice">
          <el-input v-model="form.freightprice" placeholder="请输入原值2" />
        </el-form-item>
        <el-form-item label="订单费用" prop="orderPrice">
          <el-input v-model="form.orderPrice" placeholder="请输入订单费用" />
        </el-form-item>
        <el-form-item label="下单时间" prop="addTime">
          <el-date-picker clearable
            v-model="form.addTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择下单时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="下单用户ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入下单用户ID" />
        </el-form-item>
        <el-form-item label="下单用户名称" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入下单用户名称" />
        </el-form-item>
        <el-form-item label="用户头像" prop="userAvatar">
          <el-input v-model="form.userAvatar" placeholder="请输入用户头像" />
        </el-form-item>
        <el-form-item label="联系人" prop="consignee">
          <el-input v-model="form.consignee" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="联系地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入联系地址" />
        </el-form-item>
        <el-form-item label="联系方式" prop="mobile">
          <el-input v-model="form.mobile" placeholder="请输入联系方式" />
        </el-form-item>
        <el-form-item label="用户订单留言" prop="message">
          <el-input v-model="form.message" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="商品名称" prop="goodsNamev">
          <el-input v-model="form.goodsNamev" placeholder="请输入商品名称" />
        </el-form-item>
        <el-form-item label="商品编号" prop="goodsSnv">
          <el-input v-model="form.goodsSnv" placeholder="请输入商品编号" />
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
import {
  listXsjjLitemallOrder,
  getXsjjLitemallOrder,
  delXsjjLitemallOrder,
  addXsjjLitemallOrder,
  updateXsjjLitemallOrder,
  acquireXSJj
} from "@/api/system/salesBidding/xsjjLitemallOrder";

export default {
  name: "XsjjLitemallOrder",
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
      // 销售竞价第三方订单表格数据
      xsjjLitemallOrderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderSn: null,
        orderStatus: null,
        actualPrice: null,
        vehicleNumber: null,
        headNumber: null,
        integralprice: null,
        freightprice: null,
        orderPrice: null,
        addTime: null,
        userId: null,
        userName: null,
        userAvatar: null,
        consignee: null,
        address: null,
        mobile: null,
        message: null,
        goodsNamev: null,
        goodsSnv: null,
        countStatus: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        orderSn: [
          { required: true, message: "订单编号不能为空", trigger: "blur" }
        ],
        orderStatus: [
          { required: true, message: "订单状态不能为空", trigger: "change" }
        ],
        actualPrice: [
          { required: true, message: "实付费用不能为空", trigger: "blur" }
        ],
        orderPrice: [
          { required: true, message: "订单费用不能为空", trigger: "blur" }
        ],
        consignee: [
          { required: true, message: "联系人不能为空", trigger: "blur" }
        ],
        address: [
          { required: true, message: "联系地址不能为空", trigger: "blur" }
        ],
        mobile: [
          { required: true, message: "联系方式不能为空", trigger: "blur" }
        ],
        message: [
          { required: true, message: "用户订单留言不能为空", trigger: "blur" }
        ],
        goodsNamev: [
          { required: true, message: "商品名称不能为空", trigger: "blur" }
        ],
        goodsSnv: [
          { required: true, message: "商品编号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询销售竞价第三方订单列表 */
    getList() {
      this.loading = true;
      listXsjjLitemallOrder(this.queryParams).then(response => {
        this.xsjjLitemallOrderList = response.rows;
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
        orderSn: null,
        orderStatus: null,
        actualPrice: null,
        vehicleNumber: null,
        headNumber: null,
        integralprice: null,
        freightprice: null,
        orderPrice: null,
        addTime: null,
        userId: null,
        userName: null,
        userAvatar: null,
        consignee: null,
        address: null,
        mobile: null,
        message: null,
        goodsNamev: null,
        goodsSnv: null,
        countStatus: null,
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
      this.title = "添加销售竞价第三方订单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getXsjjLitemallOrder(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改销售竞价第三方订单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateXsjjLitemallOrder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addXsjjLitemallOrder(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除销售竞价第三方订单编号为"' + ids + '"的数据项？').then(function() {
        return delXsjjLitemallOrder(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/xsjjLitemallOrder/export', {
        ...this.queryParams
      }, `xsjjLitemallOrder_${new Date().getTime()}.xlsx`)
    },
    /** 获取部分数据 */
    handleAcquire() {
      acquireXSJj();
      this.getList();
      this.$modal.msgSuccess("数据更新成功");
    },
  }
};
</script>
