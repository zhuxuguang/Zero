<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
<!--      <el-form-item label="货主组织ID" prop="shipperOrganizationId">-->
<!--        <el-input-->
<!--          v-model="queryParams.shipperOrganizationId"-->
<!--          placeholder="请输入货主组织ID"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="货主组织名称" prop="fieldName">
        <el-input
          v-model="queryParams.fieldName"
          placeholder="请输入货主组织名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="折旧" prop="cbYear">
        <el-input
          v-model="queryParams.cbYear"
          placeholder="请输入折旧"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年期" prop="cbMonth">
        <el-input
          v-model="queryParams.cbMonth"
          placeholder="请输入年期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资产类别" prop="documentCode">
        <el-input
          v-model="queryParams.documentCode"
          placeholder="请输入资产类别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="业务日期" prop="businessDate">-->
<!--        <el-date-picker clearable-->
<!--          v-model="queryParams.businessDate"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="请选择业务日期">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="部门ID" prop="userDepartmentId">-->
<!--        <el-input-->
<!--          v-model="queryParams.userDepartmentId"-->
<!--          placeholder="请输入部门ID"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="使用部门" prop="userDepartment">-->
<!--        <el-input-->
<!--          v-model="queryParams.userDepartment"-->
<!--          placeholder="请输入使用部门"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="资产位置" prop="propertyPlace">-->
<!--        <el-input-->
<!--          v-model="queryParams.propertyPlace"-->
<!--          placeholder="请输入资产位置"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="变动方式" prop="modeOfChange">-->
<!--        <el-input-->
<!--          v-model="queryParams.modeOfChange"-->
<!--          placeholder="请输入变动方式"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="卡片编码" prop="cardCoding">-->
<!--        <el-input-->
<!--          v-model="queryParams.cardCoding"-->
<!--          placeholder="请输入卡片编码"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="资产名称" prop="assetName">-->
<!--        <el-input-->
<!--          v-model="queryParams.assetName"-->
<!--          placeholder="请输入资产名称"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="资产数量" prop="assetAmount">-->
<!--        <el-input-->
<!--          v-model="queryParams.assetAmount"-->
<!--          placeholder="请输入资产数量"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="开始使用日期" prop="beginUseDate">-->
<!--        <el-date-picker clearable-->
<!--          v-model="queryParams.beginUseDate"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="请选择开始使用日期">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="入账日期" prop="entryDate">-->
<!--        <el-date-picker clearable-->
<!--          v-model="queryParams.entryDate"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="请选择入账日期">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="使用寿命" prop="useLifetime">-->
<!--        <el-input-->
<!--          v-model="queryParams.useLifetime"-->
<!--          placeholder="请输入使用寿命"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="已使用寿命" prop="usedLifetime">-->
<!--        <el-input-->
<!--          v-model="queryParams.usedLifetime"-->
<!--          placeholder="请输入已使用寿命"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="月折旧率" prop="monthlyDepreciationRate">-->
<!--        <el-input-->
<!--          v-model="queryParams.monthlyDepreciationRate"-->
<!--          placeholder="请输入月折旧率"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="(期初)期初原值" prop="initialValue">-->
<!--        <el-input-->
<!--          v-model="queryParams.initialValue"-->
<!--          placeholder="请输入(期初)期初原值"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="(期初)期初累计折旧" prop="qcAggregateDeprecition">-->
<!--        <el-input-->
<!--          v-model="queryParams.qcAggregateDeprecition"-->
<!--          placeholder="请输入(期初)期初累计折旧"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="(期初)期初净值" prop="qcNetValue">-->
<!--        <el-input-->
<!--          v-model="queryParams.qcNetValue"-->
<!--          placeholder="请输入(期初)期初净值"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="(期初)期初减值准备" prop="qcDepreciReserves">-->
<!--        <el-input-->
<!--          v-model="queryParams.qcDepreciReserves"-->
<!--          placeholder="请输入(期初)期初减值准备"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="(期初)期初可回收静额" prop="qcRecoverableNet">-->
<!--        <el-input-->
<!--          v-model="queryParams.qcRecoverableNet"-->
<!--          placeholder="请输入(期初)期初可回收静额"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="(本期发生)本期折旧额" prop="cgBqzje">-->
<!--        <el-input-->
<!--          v-model="queryParams.cgBqzje"-->
<!--          placeholder="请输入(本期发生)本期折旧额"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="(本期发生)本期累计折旧额" prop="cgBnljzje">-->
<!--        <el-input-->
<!--          v-model="queryParams.cgBnljzje"-->
<!--          placeholder="请输入(本期发生)本期累计折旧额"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="(期末)期末原值" prop="qmQmyz">-->
<!--        <el-input-->
<!--          v-model="queryParams.qmQmyz"-->
<!--          placeholder="请输入(期末)期末原值"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="(期末)期末累计折旧" prop="qmQmljzj">-->
<!--        <el-input-->
<!--          v-model="queryParams.qmQmljzj"-->
<!--          placeholder="请输入(期末)期末累计折旧"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="(期末)期末净值" prop="qmQmjz">-->
<!--        <el-input-->
<!--          v-model="queryParams.qmQmjz"-->
<!--          placeholder="请输入(期末)期末净值"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="(期末)期末减值准备" prop="qmQmjzzb">-->
<!--        <el-input-->
<!--          v-model="queryParams.qmQmjzzb"-->
<!--          placeholder="请输入(期末)期末减值准备"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="(期末)期末可回收金额" prop="qmQmkhsje">-->
<!--        <el-input-->
<!--          v-model="queryParams.qmQmkhsje"-->
<!--          placeholder="请输入(期末)期末可回收金额"-->
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
          v-hasPermi="['system:cbDeprecition:add']"
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
          v-hasPermi="['system:cbDeprecition:edit']"
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
          v-hasPermi="['system:cbDeprecition:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:cbDeprecition:export']"
        >导出</el-button>
      </el-col>

      <el-col :span="1.5">
        <el-button
          type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['system:cbDeprecition:import']"
        >导入</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList" :columns="columns"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="cbDeprecitionList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" v-if="columns[0].visible"/>
      <el-table-column label="货主组织ID" align="center" prop="shipperOrganizationId" v-if="columns[1].visible"/>
      <el-table-column label="货主组织名称" align="center" prop="fieldName" v-if="columns[2].visible"/>
      <el-table-column label="折旧" align="center" prop="cbYear" v-if="columns[3].visible"/>
      <el-table-column label="年期" align="center" prop="cbMonth" v-if="columns[4].visible"/>
      <el-table-column label="资产类别" align="center" prop="documentCode" v-if="columns[5].visible"/>
      <el-table-column label="业务日期" align="center" prop="businessDate" width="180" v-if="columns[6].visible">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.businessDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="部门ID" align="center" prop="userDepartmentId" v-if="columns[7].visible"/>
      <el-table-column label="使用部门" align="center" prop="userDepartment" v-if="columns[8].visible"/>
      <el-table-column label="资产状态" align="center" prop="propertyStatus" v-if="columns[9].visible"/>
      <el-table-column label="资产位置" align="center" prop="propertyPlace" v-if="columns[10].visible"/>
      <el-table-column label="变动方式" align="center" prop="modeOfChange" v-if="columns[11].visible"/>
      <el-table-column label="卡片编码" align="center" prop="cardCoding" v-if="columns[12].visible"/>
      <el-table-column label="资产名称" align="center" prop="assetName" v-if="columns[13].visible"/>
      <el-table-column label="资产数量" align="center" prop="assetAmount" v-if="columns[14].visible"/>
      <el-table-column label="开始使用日期" align="center" prop="beginUseDate" width="180" v-if="columns[15].visible">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.beginUseDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="入账日期" align="center" prop="entryDate" width="180" v-if="columns[16].visible">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.entryDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="使用寿命" align="center" prop="useLifetime" v-if="columns[17].visible"/>
      <el-table-column label="已使用寿命" align="center" prop="usedLifetime" v-if="columns[18].visible"/>
      <el-table-column label="月折旧率" align="center" prop="monthlyDepreciationRate" v-if="columns[19].visible"/>
      <el-table-column label="(期初)期初原值" align="center" prop="initialValue" v-if="columns[20].visible"/>
      <el-table-column label="(期初)期初累计折旧" align="center" prop="qcAggregateDeprecition" v-if="columns[21].visible"/>
      <el-table-column label="(期初)期初净值" align="center" prop="qcNetValue" v-if="columns[22].visible"/>
      <el-table-column label="(期初)期初减值准备" align="center" prop="qcDepreciReserves" v-if="columns[23].visible"/>
      <el-table-column label="(期初)期初可回收静额" align="center" prop="qcRecoverableNet" v-if="columns[24].visible"/>
      <el-table-column label="(本期发生)本期折旧额" align="center" prop="cgBqzje" v-if="columns[25].visible"/>
      <el-table-column label="(本期发生)本期累计折旧额" align="center" prop="cgBnljzje" v-if="columns[26].visible"/>
      <el-table-column label="(期末)期末原值" align="center" prop="qmQmyz" v-if="columns[27].visible"/>
      <el-table-column label="(期末)期末累计折旧" align="center" prop="qmQmljzj" v-if="columns[28].visible"/>
      <el-table-column label="(期末)期末净值" align="center" prop="qmQmjz" v-if="columns[29].visible"/>
      <el-table-column label="(期末)期末减值准备" align="center" prop="qmQmjzzb" v-if="columns[30].visible"/>
      <el-table-column label="(期末)期末可回收金额" align="center" prop="qmQmkhsje" v-if="columns[31].visible"/>
      <el-table-column label="备注" align="center" prop="remark" v-if="columns[32].visible"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:cbDeprecition:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:cbDeprecition:remove']"
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

    <!-- 添加或修改折旧对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="货主组织ID" prop="shipperOrganizationId">
          <el-input v-model="form.shipperOrganizationId" placeholder="请输入货主组织ID" />
        </el-form-item>
        <el-form-item label="货主组织名称" prop="fieldName">
          <el-input v-model="form.fieldName" placeholder="请输入货主组织名称" />
        </el-form-item>
        <el-form-item label="折旧" prop="cbYear">
          <el-input v-model="form.cbYear" placeholder="请输入折旧" />
        </el-form-item>
        <el-form-item label="年期" prop="cbMonth">
          <el-input v-model="form.cbMonth" placeholder="请输入年期" />
        </el-form-item>
        <el-form-item label="资产类别" prop="documentCode">
          <el-input v-model="form.documentCode" placeholder="请输入资产类别" />
        </el-form-item>
        <el-form-item label="业务日期" prop="businessDate">
          <el-date-picker clearable
            v-model="form.businessDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择业务日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="部门ID" prop="userDepartmentId">
          <el-input v-model="form.userDepartmentId" placeholder="请输入部门ID" />
        </el-form-item>
        <el-form-item label="使用部门" prop="userDepartment">
          <el-input v-model="form.userDepartment" placeholder="请输入使用部门" />
        </el-form-item>
        <el-form-item label="资产位置" prop="propertyPlace">
          <el-input v-model="form.propertyPlace" placeholder="请输入资产位置" />
        </el-form-item>
        <el-form-item label="变动方式" prop="modeOfChange">
          <el-input v-model="form.modeOfChange" placeholder="请输入变动方式" />
        </el-form-item>
        <el-form-item label="卡片编码" prop="cardCoding">
          <el-input v-model="form.cardCoding" placeholder="请输入卡片编码" />
        </el-form-item>
        <el-form-item label="资产名称" prop="assetName">
          <el-input v-model="form.assetName" placeholder="请输入资产名称" />
        </el-form-item>
        <el-form-item label="资产数量" prop="assetAmount">
          <el-input v-model="form.assetAmount" placeholder="请输入资产数量" />
        </el-form-item>
        <el-form-item label="开始使用日期" prop="beginUseDate">
          <el-date-picker clearable
            v-model="form.beginUseDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择开始使用日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="入账日期" prop="entryDate">
          <el-date-picker clearable
            v-model="form.entryDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择入账日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="使用寿命" prop="useLifetime">
          <el-input v-model="form.useLifetime" placeholder="请输入使用寿命" />
        </el-form-item>
        <el-form-item label="已使用寿命" prop="usedLifetime">
          <el-input v-model="form.usedLifetime" placeholder="请输入已使用寿命" />
        </el-form-item>
        <el-form-item label="月折旧率" prop="monthlyDepreciationRate">
          <el-input v-model="form.monthlyDepreciationRate" placeholder="请输入月折旧率" />
        </el-form-item>
        <el-form-item label="(期初)期初原值" prop="initialValue">
          <el-input v-model="form.initialValue" placeholder="请输入(期初)期初原值" />
        </el-form-item>
        <el-form-item label="(期初)期初累计折旧" prop="qcAggregateDeprecition">
          <el-input v-model="form.qcAggregateDeprecition" placeholder="请输入(期初)期初累计折旧" />
        </el-form-item>
        <el-form-item label="(期初)期初净值" prop="qcNetValue">
          <el-input v-model="form.qcNetValue" placeholder="请输入(期初)期初净值" />
        </el-form-item>
        <el-form-item label="(期初)期初减值准备" prop="qcDepreciReserves">
          <el-input v-model="form.qcDepreciReserves" placeholder="请输入(期初)期初减值准备" />
        </el-form-item>
        <el-form-item label="(期初)期初可回收静额" prop="qcRecoverableNet">
          <el-input v-model="form.qcRecoverableNet" placeholder="请输入(期初)期初可回收静额" />
        </el-form-item>
        <el-form-item label="(本期发生)本期折旧额" prop="cgBqzje">
          <el-input v-model="form.cgBqzje" placeholder="请输入(本期发生)本期折旧额" />
        </el-form-item>
        <el-form-item label="(本期发生)本期累计折旧额" prop="cgBnljzje">
          <el-input v-model="form.cgBnljzje" placeholder="请输入(本期发生)本期累计折旧额" />
        </el-form-item>
        <el-form-item label="(期末)期末原值" prop="qmQmyz">
          <el-input v-model="form.qmQmyz" placeholder="请输入(期末)期末原值" />
        </el-form-item>
        <el-form-item label="(期末)期末累计折旧" prop="qmQmljzj">
          <el-input v-model="form.qmQmljzj" placeholder="请输入(期末)期末累计折旧" />
        </el-form-item>
        <el-form-item label="(期末)期末净值" prop="qmQmjz">
          <el-input v-model="form.qmQmjz" placeholder="请输入(期末)期末净值" />
        </el-form-item>
        <el-form-item label="(期末)期末减值准备" prop="qmQmjzzb">
          <el-input v-model="form.qmQmjzzb" placeholder="请输入(期末)期末减值准备" />
        </el-form-item>
        <el-form-item label="(期末)期末可回收金额" prop="qmQmkhsje">
          <el-input v-model="form.qmQmkhsje" placeholder="请输入(期末)期末可回收金额" />
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
import { listCbDeprecition, getCbDeprecition, delCbDeprecition, addCbDeprecition, updateCbDeprecition } from "@/api/system/cb/cbDeprecition";
import {getToken} from "@/utils/auth";

export default {
  name: "CbDeprecition",
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
      // 折旧表格数据
      cbDeprecitionList: [],
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
        url: process.env.VUE_APP_BASE_API + "/system/cb/cbDeprecition/importData"
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        shipperOrganizationId: null,
        fieldName: null,
        cbYear: null,
        cbMonth: null,
        documentCode: null,
        businessDate: null,
        userDepartmentId: null,
        userDepartment: null,
        propertyStatus: null,
        propertyPlace: null,
        modeOfChange: null,
        cardCoding: null,
        assetName: null,
        assetAmount: null,
        beginUseDate: null,
        entryDate: null,
        useLifetime: null,
        usedLifetime: null,
        monthlyDepreciationRate: null,
        initialValue: null,
        qcAggregateDeprecition: null,
        qcNetValue: null,
        qcDepreciReserves: null,
        qcRecoverableNet: null,
        cgBqzje: null,
        cgBnljzje: null,
        qmQmyz: null,
        qmQmljzj: null,
        qmQmjz: null,
        qmQmjzzb: null,
        qmQmkhsje: null,
      },
      // 列信息
      columns: [
        { key: 0, label: `ID`, visible: false },
        { key: 1, label: `货主组织ID`, visible: false },
        { key: 2, label: `货主组织名称`, visible: true },
        { key: 3, label: `折旧`, visible: true },
        { key: 4, label: `年期`, visible: true },
        { key: 5, label: `资产类别`, visible: true },
        { key: 6, label: `业务日期`, visible: false },
        { key: 7, label: `部门ID`, visible: false },
        { key: 8, label: `使用部门`, visible: true },
        { key: 9, label: `资产状态`, visible: true },
        { key: 10, label: `资产位置`, visible: true },
        { key: 11, label: `变动方式`, visible: true },
        { key: 12, label: `卡片编码`, visible: true },
        { key: 13, label: `资产名称`, visible: true },
        { key: 14, label: `资产数量`, visible: true },
        { key: 15, label: `开始使用日期`, visible: true },
        { key: 16, label: `入账日期`, visible: true },
        { key: 17, label: `使用寿命`, visible: true },
        { key: 18, label: `已使用寿命`, visible: true },
        { key: 19, label: `月折旧率`, visible: true },
        { key: 20, label: `(期初)期初原值`, visible: true },
        { key: 21, label: `(期初)期初累计折旧`, visible: true },
        { key: 22, label: `(期初)期初净值`, visible: true },
        { key: 23, label: `(期初)期初减值准备`, visible: true },
        { key: 24, label: `(期初)期初可回收静额`, visible: true },
        { key: 25, label: `(本期发生)本期折旧额`, visible: true },
        { key: 26, label: `(本期发生)本期累计折旧额`, visible: true },
        { key: 27, label: `(期末)期末原值`, visible: true },
        { key: 28, label: `(期末)期末累计折旧`, visible: true },
        { key: 29, label: `(期末)期末净值`, visible: true },
        { key: 30, label: `(期末)期末减值准备`, visible: true },
        { key: 31, label: `(期末)期末可回收金额`, visible: true },
        { key: 32, label: `备注`, visible: true }
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
    /** 查询折旧列表 */
    getList() {
      this.loading = true;
      listCbDeprecition(this.queryParams).then(response => {
        this.cbDeprecitionList = response.rows;
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
        shipperOrganizationId: null,
        fieldName: null,
        cbYear: null,
        cbMonth: null,
        documentCode: null,
        businessDate: null,
        userDepartmentId: null,
        userDepartment: null,
        propertyStatus: null,
        propertyPlace: null,
        modeOfChange: null,
        cardCoding: null,
        assetName: null,
        assetAmount: null,
        beginUseDate: null,
        entryDate: null,
        useLifetime: null,
        usedLifetime: null,
        monthlyDepreciationRate: null,
        initialValue: null,
        qcAggregateDeprecition: null,
        qcNetValue: null,
        qcDepreciReserves: null,
        qcRecoverableNet: null,
        cgBqzje: null,
        cgBnljzje: null,
        qmQmyz: null,
        qmQmljzj: null,
        qmQmjz: null,
        qmQmjzzb: null,
        qmQmkhsje: null,
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
      this.title = "添加折旧";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCbDeprecition(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改折旧";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCbDeprecition(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCbDeprecition(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除折旧编号为"' + ids + '"的数据项？').then(function() {
        return delCbDeprecition(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/cb/cbDeprecition/export', {
        ...this.queryParams
      }, `cbDeprecition_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "数据导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('system/cb/cbDeprecition/importTemplate', {
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
